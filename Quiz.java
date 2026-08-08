import java.util.Scanner;

/**
 * Quiz Game — Java command-line version
 * Same 50 questions as the web version (Current Affairs, GK, Computer,
 * Aptitude, Science, Logical Reasoning, Geography, English, Sports).
 * Run with: javac Quiz.java && java Quiz
 */
public class Quiz {

    static String[] questions = {
        "An 18-year-old just broke a 306-year-old Guinness World Record — for what achievement?",
        "Which cricket legend retired from international cricket in July 2026 after 195 international matches?",
        "India's Navy inducted a new indigenous diving support vessel whose name means 'skilled' — what is it called?",
        "Who became the first woman in IAF history to clear the Fighter Combat Leader course?",
        "The Union Cabinet approved a ₹36,441 crore outlay in 2026 to expand which sports scheme?",
        "Who invented both the first web browser and the first web server, back in 1990?",
        "An Indian-origin NASA astronaut completed a spacewalk outside which structure in August 2026?",
        "August 9 marks the anniversary of which grim WWII event?",
        "Who is known as the Father of the Nation in India?",
        "What is the national bird of India?",
        "Which is the longest river in the world?",
        "In cricket, can the same bowler bowl two overs in a row?",
        "Which Indian city is nicknamed the 'Silicon Valley of India'?",
        "What does CPU stand for?",
        "Which key deletes a character to the left of the cursor?",
        "What does 'www' stand for?",
        "Which of these is an operating system?",
        "What does RAM stand for?",
        "Which language is used to style web pages?",
        "What does the shortcut Ctrl+V do?",
        "Which data structure follows First-In-First-Out (FIFO) order?",
        "What does HTTP stand for?",
        "Which sorting algorithm splits a list in half repeatedly until it can't anymore?",
        "If a train travels 60 km in 1 hour, how far does it travel in 3 hours at the same speed?",
        "A shopkeeper buys a pen for ₹10 and sells it for ₹15. What is his profit?",
        "Find the odd one out: Apple, Banana, Carrot, Mango",
        "If CAT is coded as DBU (each letter shifted by +1), how would DOG be coded?",
        "A is twice as old as B. Five years ago, A was three times as old as B. What is A's current age?",
        "What planet do we live on?",
        "What gas do humans need to breathe to survive?",
        "What is the 'powerhouse of the cell' called?",
        "What is the chemical formula for water?",
        "Which invisible force keeps planets orbiting the sun?",
        "Complete the sequence: 2, 4, 6, 8, ?",
        "If all cats are animals, and Tom is a cat, is Tom an animal?",
        "Find the odd one out: Circle, Square, Triangle, Sphere",
        "If today is Wednesday, what day will it be after 100 days?",
        "Five friends sit in a row: A is left of B, C is right of B, D is between A and B, E is at the far right. Who sits in the middle?",
        "Which is the largest continent by area?",
        "Which is the smallest country in the world?",
        "Which is the largest hot desert in the world?",
        "Mount Everest is located in which mountain range?",
        "Choose the word that means the same as 'Happy'.",
        "Choose the opposite of 'Brave'.",
        "Choose the correctly spelled word.",
        "Which sentence uses an apostrophe correctly?",
        "How many players are on a football (soccer) team on the field at once?",
        "Winning all four majors in one calendar year completes a 'Grand Slam' — in which sport?",
        "The modern Olympics made their comeback in 1896 — in which city?",
        "The Olympic Games are held once every how many years?"
    };

    static String[][] options = {
        {"Youngest male professor", "Youngest CEO", "Youngest astronaut", "Youngest Olympic gold medalist"},
        {"Virat Kohli", "Ajinkya Rahane", "Rohit Sharma", "Cheteshwar Pujara"},
        {"Nipun", "Kalvari", "Vikrant", "Arihant"},
        {"Avani Chaturvedi", "Bhawana Kanth", "Shivangi Singh", "Mohana Singh"},
        {"Khelo India", "Fit India", "TOPS", "Target Olympic Podium"},
        {"Bill Gates", "Tim Berners-Lee", "Steve Jobs", "Vint Cerf"},
        {"Tiangong Space Station", "International Space Station", "Hubble Telescope", "Artemis Base Camp"},
        {"Hiroshima bombing", "Nagasaki bombing", "Pearl Harbor attack", "D-Day invasion"},
        {"Jawaharlal Nehru", "Mahatma Gandhi", "Subhas Chandra Bose", "Sardar Patel"},
        {"Sparrow", "Peacock", "Eagle", "Parrot"},
        {"Amazon", "Nile", "Yangtze", "Mississippi"},
        {"Yes, always", "No, never allowed", "Only in T20", "Only if captain agrees"},
        {"Hyderabad", "Pune", "Bengaluru", "Chennai"},
        {"Central Processing Unit", "Central Program Unit", "Computer Personal Unit", "Central Processor User"},
        {"Delete", "Backspace", "Shift", "Tab"},
        {"World Wide Web", "World Web Wide", "Wide World Web", "Web World Wide"},
        {"Windows", "Photoshop", "Excel", "Chrome"},
        {"Random Access Memory", "Read Access Memory", "Random Active Memory", "Read Active Module"},
        {"HTML", "CSS", "Python", "Java"},
        {"Copy", "Cut", "Paste", "Undo"},
        {"Stack", "Queue", "Tree", "Graph"},
        {"HyperText Transfer Protocol", "High Transfer Text Protocol", "HyperText Technical Protocol", "Home Transfer Text Protocol"},
        {"Bubble Sort", "Merge Sort", "Insertion Sort", "Selection Sort"},
        {"120 km", "150 km", "180 km", "200 km"},
        {"₹3", "₹5", "₹7", "₹10"},
        {"Apple", "Banana", "Carrot", "Mango"},
        {"EPH", "EQH", "FPH", "EPI"},
        {"15", "20", "25", "30"},
        {"Mars", "Earth", "Venus", "Jupiter"},
        {"Nitrogen", "Oxygen", "Carbon Dioxide", "Hydrogen"},
        {"Nucleus", "Mitochondria", "Ribosome", "Cytoplasm"},
        {"CO2", "H2O", "O2", "NaCl"},
        {"Magnetism", "Gravity", "Friction", "Inertia"},
        {"9", "10", "11", "12"},
        {"Yes", "No", "Cannot say", "Sometimes"},
        {"Circle", "Square", "Triangle", "Sphere"},
        {"Thursday", "Friday", "Saturday", "Sunday"},
        {"A", "B", "C", "D"},
        {"Africa", "Asia", "Europe", "Antarctica"},
        {"Monaco", "Vatican City", "San Marino", "Malta"},
        {"Sahara", "Gobi", "Kalahari", "Thar"},
        {"Andes", "Alps", "Himalayas", "Rockies"},
        {"Sad", "Joyful", "Angry", "Tired"},
        {"Bold", "Cowardly", "Strong", "Fearless"},
        {"Neccessary", "Necessary", "Neccessery", "Necessery"},
        {"It's raining", "Its' raining", "Its raining outside now'", "I'ts raining"},
        {"9", "10", "11", "12"},
        {"Cricket", "Tennis", "Badminton", "Golf"},
        {"Paris", "London", "Athens", "Rome"},
        {"2", "3", "4", "5"}
    };

    // 0-indexed correct answer for each question, matching the options above
    static int[] correctAnswers = {0, 1, 0, 1, 0, 1, 1, 1, 1, 1, 1, 1, 2, 0, 1, 0, 0, 0, 1, 2, 1, 0, 1, 2, 1, 2, 0, 1, 1, 1, 1, 1, 1, 1, 0, 3, 1, 1, 1, 1, 0, 2, 1, 1, 1, 0, 2, 1, 2, 2};

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int score = 0;

        System.out.println("=== Quiz Game (Java version) ===");
        System.out.print("Enter your name: ");
        String name = scanner.nextLine().trim();
        if (name.isEmpty()) name = "Player";

        for (int i = 0; i < questions.length; i++) {
            System.out.println("\nQuestion " + (i + 1) + " of " + questions.length);
            System.out.println(questions[i]);
            for (int j = 0; j < options[i].length; j++) {
                System.out.println("  " + (j + 1) + ") " + options[i][j]);
            }
            System.out.print("Your answer (1-4): ");

            int answer = -1;
            while (answer < 1 || answer > 4) {
                String input = scanner.nextLine().trim();
                try {
                    answer = Integer.parseInt(input);
                    if (answer < 1 || answer > 4) {
                        System.out.print("Please enter a number between 1 and 4: ");
                    }
                } catch (NumberFormatException e) {
                    System.out.print("Please enter a valid number (1-4): ");
                }
            }

            int chosenIndex = answer - 1;
            if (chosenIndex == correctAnswers[i]) {
                System.out.println("Correct!");
                score++;
            } else {
                System.out.println("Incorrect. The correct answer was: " + options[i][correctAnswers[i]]);
            }
        }

        System.out.println("\n=== Quiz Complete ===");
        System.out.println(name + ", your final score is: " + score + " / " + questions.length);

        scanner.close();
    }
}
