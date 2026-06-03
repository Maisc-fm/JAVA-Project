import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MainApp {

    public static void main(String[] args) {
        // Member 1 
    }

    public static void launchLearningModule(User user) {
    import java.util.Scanner;
    // Member 2
    // Class: MainApp
    // Main driver class of the application.
    // Controls learning module and quiz.
    // Created By: Nashrur Aisyha Hani binti Suphian @ Sharbini (102776)

    public class MainApp {

    // Learning module object
    private LearningModule module;

    // Constructor
    public MainApp() {

        module = new LearningModule();
    }

    // Start application.
    public void start() {

        Scanner input =
                new Scanner(System.in);

        System.out.println(
                "================================");

        System.out.println(
                "WELCOME TO SDG 4 LEARNING APP");

        System.out.println(
                "================================");

        System.out.println(
                module.getTitle());

        // Display first page
        module.showPage(0);

        // Create TF question
        Questionable q1 =
        new TFQuestion(
        "SDG 4 focuses on Quality Education. (true/false)",
        true);

        System.out.println(
                "\nQuiz Time!");

        System.out.println(
                q1.getQuestion());

        System.out.print(
                "Answer: ");

        String answer =
                input.nextLine();

        // Check answer
        if (q1.checkAnswer(answer)) {

            System.out.println(
                    "Correct!");

        } else {

            System.out.println(
                    "Wrong Answer!");
        }

        input.close();
    }

    // Program entry point.
     // @param args command line arguments
     public static void main(String[] args) {

        MainApp app =
                new MainApp();

        app.start();
    }
}

    public static void launchQuiz(User user) {
        // Member 3 
        //Class: MainApp
        //Creator: Bong Ming Meng (103541)
        //Tester:
        //Main entry point for the Quality Education

        public class MainApp extends JFrame {
    
        private User user;
        private LearningModule module;
        private Quiz quiz;
        private Leaderboard leaderboard;

        private FileStorage storage;
    
        private final Color SDG_RED = new Color(197,32,38 );
        private final Color WHITE = Color.WHITE;
        private final Color LIGHT_GRAY = new Color(240, 240, 240);

        private JTextField nameField;
        private JButton startButton;
        private JComboBox<String> quizTypeBox;

        public MainApp(){
            setTitle("Quality Education SDG Quiz");
            setSize(400, 700);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setResizable(false);
            setLocationRelativeTo(null);

            initComponents();
            setVisible(true);
        }

        private void initComponents(){
            JPanel mainPanel = new JPanel();
            mainPanel.setLayout(new BorderLayout());
            mainPanel.setBackground(WHITE);

            //Top panel
            JPanel topPanel = new JPanel();
            topPanel.setLayout(new GridLayout(3,1));
            topPanel.setBackground(SDG_RED);
            topPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

            JLabel sdgLabel = new JLabel("SDG Quiz", JLabel.CENTER);
            sdgLabel.setFont(new Font("Arial", Font.BOLD, 24));
            sdgLabel.setForeground(WHITE);

            JLabel titleLabel = new JLabel("Quality Education", JLabel.CENTER);
            titleLabel.setFont(new Font("Arial", Font.BOLD, 18));  
            titleLabel.setForeground(WHITE);

            JLabel subtitleLabel = new JLabel("Test Your Knowledge!", JLabel.CENTER);
            subtitleLabel.setFont(new Font("Arial", Font.PLAIN, 14));
            subtitleLabel.setForeground(WHITE);

            topPanel.add(sdgLabel);
            topPanel.add(titleLabel);
            topPanel.add(subtitleLabel);

            // middle panel
            JPanel middlePanel = new JPanel();
            middlePanel.setLayout(new GridLayout(6,1, 10, 10));
            middlePanel.setBackground(WHITE);
            middlePanel.setBorder(BorderFactory.createEmptyBorder(40,30,40,30));

            JLabel nameLabel = new JLabel("Enter Your Name:");
            nameLabel.setFont(new Font("Arial", Font.BOLD, 14));

            nameField = new JTextField();
            nameField.setFont(new Font("Arial", Font.PLAIN, 14));
            nameField.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(Color.GRAY, 2),
                BorderFactory.createEmptyBorder(5, 5, 5, 5)
            ));

            JLabel quizTypeLabel = new JLabel("Select Quiz Type:");
            quizTypeLabel.setFont(new Font("Arial", Font.BOLD, 14));

            String[] quizTypes = {"MCQ - Multiple Choice", "TF - True or False"};
            quizTypeBox = new JComboBox<>(quizTypes);
            quizTypeBox.setFont(new Font("Arial", Font.PLAIN, 14));

            startButton = new JButton("Start Quiz");
            startButton.setFont(new Font("Arial", Font.BOLD, 16));
            startButton.setBackground(SDG_RED);
            startButton.setForeground(WHITE);
            startButton.setFocusPainted(false);
            startButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
            startButton.addActionListener(e -> launchGUI());

            middlePanel.add(nameLabel);
            middlePanel.add(nameField);
            middlePanel.add(quizTypeLabel);
            middlePanel.add(quizTypeBox); 
            middlePanel.add(new JLabel()); // Empty space
            middlePanel.add(startButton);

            //Bottom panel
            JPanel bottomPanel = new JPanel();
            bottomPanel.setBackground(LIGHT_GRAY);
            bottomPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

            JLabel footerLabel = new JLabel("TMF2954 Java Programming | Group Project", JLabel.CENTER);
            footerLabel.setFont(new Font("Arial", Font.PLAIN, 12));
            footerLabel.setForeground(Color.GRAY);

            bottomPanel.add(footerLabel);

            //assemble
            mainPanel.add(topPanel, BorderLayout.NORTH);
            mainPanel.add(middlePanel, BorderLayout.CENTER);
            mainPanel.add(bottomPanel, BorderLayout.SOUTH);

            add(mainPanel);
            }

            public void launchGUI(){
                String username = nameField.getText().trim();
                if (username.isEmpty()) {
                    JOptionPane.showMessageDialog(this,
                        "Please enter your name.", "Input Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                int selectedIndex = quizTypeBox.getSelectedIndex();
                String quizType = selectedIndex == 0 ? "MCQ" : "TF";
    
                quiz = new Quiz(quizType);
                storage = new FileStorage();
                user = new User(username);
                module = new LearningModule();
                leaderboard = new Leaderboard();
    
                this.dispose();
                new QuizScreenGUI(username, quiz, storage);
            }    

            //Get motivation message
            public String getMotivation(){
                if (quiz != null){
                    return quiz.getMotivationalMessage();
                }    
                return "Keep learning!";
            }

            //Save score
            public void saveScore(){
                if (quiz != null && storage != null){
                    String message = getMotivation();
                    storage.wroteScore(user.getUsername(), quiz.getScore(), message);
                    System.out.println("Score saved: "+ quiz.getScore());
                }    
            }
    
            //Main method
            public static void main(String[] args){
                SwingUtilities.invokeLater(() -> {
                    new MainApp();
                });
            }
        }
    }


public static void launchLeaderboard(String username, int score) {
     
     // Member 4
     // Made by Nur Syukrinah binti Suhaidi (97717)

     // Create leaderboard system
     Leaderboard leaderboard = new Leaderboard();

     // Add user score into leaderboard
     leaderboard.addScore(username, score);

     // Create badge manager
     BadgeManager badgeManager = new BadgeManager();

     // Display information
     System.out.println("User: " + username);
     System.out.println("Score: " + score);
     System.out.println("Badge: " + badgeManager.getBadge(score));

     // Open leaderboard GUI
     new LeaderboardScreenGUI(leaderboard);
}
}
    

