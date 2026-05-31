import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MainApp {

    public static void main(String[] args) {
        // Member 1 
    }

    public static void launchLearningModule(User user) {
        // Member 2 
        // Made by Nashrur Aisyha Hani binti Suphian @ Sharbini (102776) 

import javax.swing.SwingUtilities;
public class MainApp {

    // Stores the learning module used in the application.
    private LearningModule module;

    // Constructor.
    // Creates the sample learning module when the application starts.
    public MainApp() {
        module = buildSampleModule();
    }

    // Main method.
    // This is the first method that runs when the program starts.
    public static void main(String[] args) {
        MainApp app = new MainApp();
        app.launchGUI();
    }

    // Opens the LearningScreen window.
    // The learning content is displayed inside the GUI.
    public void launchGUI() {
        SwingUtilities.invokeLater(() -> {
            LearningScreen screen = new LearningScreen(module);
            screen.initUI();
        });
    }

    // Returns a motivational message for the user.
    public String getMotivation() {
        return "Keep learning! Education changes lives.";
    }

    // Placeholder method for saving scores.
    // The full implementation can be added later.
    public void saveScore() {
        System.out.println("[MainApp] saveScore() - to be integrated with other members.");
    }

    // Creates sample learning pages for the application.
    // Each page contains educational content and an image.
    private LearningModule buildSampleModule() {
        LearningModule m = new LearningModule();

        // First page: Introduction to SDG Goal 4
        m.addPage(
            "SDG Goal 4 - Quality Education\n\n" +
            "Ensure inclusive and equitable quality education and promote " +
            "lifelong learning opportunities for all.",
            "images/sdg4_cover.png"
        );

        // Second page: Importance of education
        m.addPage(
            "Why Education Matters\n\n" +
            "Education is the foundation for improving people's lives and " +
            "achieving sustainable development.",
            "images/sdg4_why.png"
        );

        // Third page: Main targets of SDG Goal 4
        m.addPage(
            "Key Targets\n\n" +
            "By 2030, ensure all girls and boys complete free, equitable, " +
            "and quality primary and secondary education.",
            "images/sdg4_targets.png"
        );

        return m;
    }

    // Returns the current learning module
    public LearningModule getModule() {
        return module;
    }

    // Updates the learning module
    public void setModule(LearningModule module) {
        this.module = module;
    }
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

     public static void launchLeaderboard(User user) {
        // Member 4 
    }
}
