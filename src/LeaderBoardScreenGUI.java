import java.awt.*;
import javax.swing.*;

public class LeaderBoardScreenGUI extends JFrame {
   
    //Member 4
    //Made by Nur Syukrinah binti Suhaidi (97717)

    // Text area used to display leaderboard information.
    private JTextArea leaderboardArea;

    // Constructor.
    // Creates the leaderboard window and initializes GUI components.
    public LeaderBoardScreenGUI() {

        setTitle("Leaderboard");
        setSize(400, 700);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        initializeComponents();

        setVisible(true);
    }

    // Creates and arranges all GUI components.
    private void initializeComponents() {

        JPanel mainPanel = new JPanel(new BorderLayout());

        JLabel titleLabel = new JLabel("Leaderboard", JLabel.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 20));

        leaderboardArea = new JTextArea();
        leaderboardArea.setEditable(false);

        leaderboardArea.setText(
                "1. Ali - 95 points\n" +
                "2. Abu - 85 points\n" +
                "3. Siti - 75 points"
        );

        JScrollPane scrollPane = new JScrollPane(leaderboardArea);

        mainPanel.add(titleLabel, BorderLayout.NORTH);
        mainPanel.add(scrollPane, BorderLayout.CENTER);

        add(mainPanel);
    }

    // Updates the leaderboard display.
    public void updateLeaderboard(String text) {
        leaderboardArea.setText(text);
    }
}
