"""
Quiz Game — Backend API
------------------------
Stores player name + score with a timestamp.
Leaderboard endpoint only returns entries from the last 7 days —
anything older is automatically filtered out (and cleaned from the
file) every time the leaderboard is requested.

Run with:  python app.py
Runs on:   http://localhost:5000
"""

from flask import Flask, request, jsonify
from flask_cors import CORS
import json
import os
from datetime import datetime, timedelta, timezone

app = Flask(__name__)
CORS(app)  # allow the frontend (served from a different origin) to call this API

DATA_FILE = os.path.join(os.path.dirname(__file__), "scores.json")
SEVEN_DAYS = timedelta(days=7)


def load_scores():
    if not os.path.exists(DATA_FILE):
        return []
    with open(DATA_FILE, "r") as f:
        try:
            return json.load(f)
        except json.JSONDecodeError:
            return []


def save_scores(scores):
    with open(DATA_FILE, "w") as f:
        json.dump(scores, f, indent=2)


def prune_old_scores(scores):
    """Keep only entries from the last 7 days."""
    cutoff = datetime.now(timezone.utc) - SEVEN_DAYS
    fresh = []
    for entry in scores:
        try:
            ts = datetime.fromisoformat(entry["timestamp"])
            if ts >= cutoff:
                fresh.append(entry)
        except (KeyError, ValueError):
            continue  # skip malformed entries
    return fresh


@app.route("/api/submit_score", methods=["POST"])
def submit_score():
    data = request.get_json(force=True, silent=True) or {}
    name = str(data.get("name", "")).strip()[:30]  # cap length, basic sanitizing
    score = data.get("score")

    if not name:
        return jsonify({"error": "Name is required"}), 400
    if not isinstance(score, (int, float)) or score < 0:
        return jsonify({"error": "Valid score is required"}), 400

    scores = load_scores()
    scores = prune_old_scores(scores)
    scores.append({
        "name": name,
        "score": int(score),
        "timestamp": datetime.now(timezone.utc).isoformat()
    })
    save_scores(scores)

    return jsonify({"message": "Score saved", "name": name, "score": int(score)}), 201


@app.route("/api/leaderboard", methods=["GET"])
def leaderboard():
    scores = load_scores()
    fresh = prune_old_scores(scores)
    save_scores(fresh)  # persist the pruning so old entries don't pile up in the file

    # Highest score first; if tied, most recent first
    fresh.sort(key=lambda e: (e["score"], e["timestamp"]), reverse=True)
    top = fresh[:20]  # top 20 entries

    return jsonify({"leaderboard": top, "count": len(fresh)})


@app.route("/api/health", methods=["GET"])
def health():
    return jsonify({"status": "ok"})


if __name__ == "__main__":
    app.run(debug=True, port=5000)
