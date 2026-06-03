import java.awt.*;
import javax.swing.*;

// Class: LearningScreen
// Purpose: GUI screen for SDG 4 learning module.
// Design: Smartphone size 390 x 844 px.
// Created By: Nashrur Aisyha Hani binti Suphian @ Sharbini (102776)

public class LearningScreenGUI extends JFrame {

    private LearningModule module;

    private JLabel titleLabel;
    private JLabel pageLabel;
    private JTextArea contentArea;
    private JLabel imageLabel;

    private JButton prevButton;
    private JButton nextButton;

    private int currentPage;

    public void LearningScreen() {

        module = new LearningModule();
        currentPage = 0;

        setTitle("SDG 4 Learning Screen");
        setSize(390, 844);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);
        setResizable(false);

        initUI();
        displayPage(currentPage);

        setVisible(true);
    }

    private void initUI() {

    // Header Panel
    JPanel headerPanel = new JPanel();
    headerPanel.setBackground(Color.WHITE);
    headerPanel.setBounds(0, 0, 390, 90);
    headerPanel.setLayout(null);
    add(headerPanel);

    // SDG Logo
    ImageIcon logoIcon = new ImageIcon("sdg_logo.png");

    if (logoIcon.getIconWidth() == -1) {

        System.out.println("SDG logo not found!");

    } else {

        Image logoImage = logoIcon.getImage().getScaledInstance(
                55,
                55,
                Image.SCALE_SMOOTH
        );

        JLabel logoLabel = new JLabel(new ImageIcon(logoImage));
        logoLabel.setBounds(15, 15, 55, 55);

        headerPanel.add(logoLabel);
    }

    // Global Goals Title
    titleLabel = new JLabel("THE GLOBAL GOALS");
    titleLabel.setFont(new Font("Arial", Font.BOLD, 18));
    titleLabel.setForeground(Color.BLACK);
    titleLabel.setBounds(80, 20, 250, 40);
    headerPanel.add(titleLabel);

    // Divider Line
    JSeparator separator = new JSeparator();
    separator.setBounds(0, 89, 390, 1);
    headerPanel.add(separator);

    // Main Panel
    JPanel mainPanel = new JPanel();
    mainPanel.setBackground(new Color(197, 25, 45));
    mainPanel.setBounds(0, 90, 390, 754);
    mainPanel.setLayout(null);
    add(mainPanel);

    // Page Label
    pageLabel = new JLabel("Page 1");
    pageLabel.setForeground(Color.WHITE);
    pageLabel.setFont(new Font("Arial", Font.BOLD, 22));
    pageLabel.setBounds(30, 30, 300, 40);
    mainPanel.add(pageLabel);

    // Image Display Area
    imageLabel = new JLabel("Image Here", SwingConstants.CENTER);
    imageLabel.setOpaque(true);
    imageLabel.setBackground(Color.WHITE);
    imageLabel.setBounds(45, 90, 300, 180);
    mainPanel.add(imageLabel);

    // Content Area
    contentArea = new JTextArea();
    contentArea.setLineWrap(true);
    contentArea.setWrapStyleWord(true);
    contentArea.setEditable(false);
    contentArea.setFont(new Font("Arial", Font.PLAIN, 16));
    contentArea.setForeground(Color.WHITE);
    contentArea.setBackground(new Color(197, 25, 45));
    contentArea.setBounds(35, 300, 320, 280);
    mainPanel.add(contentArea);

    // Previous Button
    prevButton = new JButton("Previous");
    prevButton.setBounds(35, 630, 130, 45);
    mainPanel.add(prevButton);

    // Next Button
    nextButton = new JButton("Next");
    nextButton.setBounds(220, 630, 130, 45);
    mainPanel.add(nextButton);

    // Button Actions
    prevButton.addActionListener(e -> previousPage());
    nextButton.addActionListener(e -> nextPage());
}

    
    private void displayPage(int index) {

    pageLabel.setText("Page " + (index + 1) + " / " + module.getTotalPages());

    module.showPage(index);

    contentArea.setText(module.getPageContent(index));

    String imagePath = module.getImagePath();

    ImageIcon icon = new ImageIcon(imagePath);

    if (icon.getIconWidth() == -1) {
        imageLabel.setIcon(null);
        imageLabel.setText("Image not found");
    } else {
        Image image = icon.getImage().getScaledInstance(
                300,
                180,
                Image.SCALE_SMOOTH
        );

        imageLabel.setIcon(new ImageIcon(image));
        imageLabel.setText("");
    }
}
    private String getPageContent(int index) {

        String[] contents = {
            "Make sure all girls and boys can get free, fair and good-quality primary and secondary education that helps them learn useful knowledge and skills.",
            "Make sure all girls and boys can access quality early childhood care and preschool education so they are ready for primary school.",
            "Ensure all women and men have equal access to affordable, quality vocational, technical and university education.",
            "Increase the number of young people and adults with useful technical and vocational skills for jobs and starting businesses.",
            "Remove gender inequality in education and ensure vulnerable groups have equal access to education and vocational training.",
            "Ensure all young people and many adults, both men and women can read, write, and do basic math.",
            "Help everyone learn how to live sustainably, respect others and contribute to a peaceful and inclusive society.",
            "Build and improve schools that are safe, inclusive and accessible for children, people with disabilities and all genders.",
            "Provide more scholarships to help students from developing countries access higher education and specialized training.",
            "Increase the number of qualified teachers through better training and international cooperation especially in developing countries."
        };

        return contents[index];
    }

    private void nextPage() {

        if (currentPage < module.getTotalPages() - 1) {
            currentPage++;
            displayPage(currentPage);
        }
    }

    private void previousPage() {

        if (currentPage > 0) {
            currentPage--;
            displayPage(currentPage);
        }
    }
}
