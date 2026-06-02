import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;

public class LoginGUI extends JFrame {

    // colors
    private static final Color BG_TOP    = new Color(0, 94, 165);   // UN Blue
    private static final Color BG_BOT    = new Color(0, 150, 109);  // SDG Green
    private static final Color CARD_BG   = new Color(255, 255, 255, 230);
    private static final Color ACCENT    = new Color(0, 150, 109);
    private static final Color TXT_DARK  = new Color(30, 30, 30);
    private static final Color TXT_LIGHT = Color.WHITE;

    // state
    private final MainApp    app;
    private       JTextField nameField;
    private       JLabel     errorLabel;

    // constructor
    public LoginGUI(MainApp app) {
        this.app = app;
        initUI();
    }

    // UI setup
    private void initUI() {
        setTitle("SDG Quiz – Login");
        setSize(390, 844);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);

        // gradient background panel 
        JPanel bg = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2 = (Graphics2D) g;
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                                    RenderingHints.VALUE_ANTIALIAS_ON);
                GradientPaint gp = new GradientPaint(
                        0, 0, BG_TOP, 0, getHeight(), BG_BOT);
                g2.setPaint(gp);
                g2.fillRect(0, 0, getWidth(), getHeight());
            }
        };
        bg.setLayout(new GridBagLayout());
        setContentPane(bg);

        // card panel
        JPanel card = new JPanel();
        card.setOpaque(false);
        card.setBackground(CARD_BG);
        card.setLayout(new BoxLayout(card, BoxLayout.Y_AXIS));
        card.setBorder(new EmptyBorder(32, 28, 32, 28));

        // Make card opaque via custom painting
        JPanel cardWrapper = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                Graphics2D g2 = (Graphics2D) g;
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                                    RenderingHints.VALUE_ANTIALIAS_ON);
                g2.setColor(CARD_BG);
                g2.fill(new RoundRectangle2D.Float(0, 0, getWidth(), getHeight(), 24, 24));
            }
        };
        cardWrapper.setOpaque(false);
        cardWrapper.setLayout(new BoxLayout(cardWrapper, BoxLayout.Y_AXIS));
        cardWrapper.setBorder(new EmptyBorder(32, 28, 32, 28));
        cardWrapper.setPreferredSize(new Dimension(320, 440));
        cardWrapper.setMaximumSize(new Dimension(320, 440));

        // SDG wheel emoji / logo area 
        JLabel logoLabel = new JLabel("🌍", SwingConstants.CENTER);
        logoLabel.setFont(new Font("Dialog", Font.PLAIN, 64));
        logoLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        // app title
        JLabel title = new JLabel("SDG Quest", SwingConstants.CENTER);
        title.setFont(new Font("Georgia", Font.BOLD, 28));
        title.setForeground(BG_TOP);
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        // subtitle 
        JLabel subtitle = new JLabel(
                "<html><center>Learn. Quiz. Change the World.</center></html>",
                SwingConstants.CENTER);
        subtitle.setFont(new Font("Dialog", Font.ITALIC, 13));
        subtitle.setForeground(new Color(100, 100, 100));
        subtitle.setAlignmentX(Component.CENTER_ALIGNMENT);

        // name label 
        JLabel nameLabel = new JLabel("Enter your name to begin:");
        nameLabel.setFont(new Font("Dialog", Font.BOLD, 13));
        nameLabel.setForeground(TXT_DARK);
        nameLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        // name text field 
        nameField = new JTextField();
        nameField.setFont(new Font("Dialog", Font.PLAIN, 14));
        nameField.setMaximumSize(new Dimension(Integer.MAX_VALUE, 40));
        nameField.setBorder(BorderFactory.createCompoundBorder(
                new LineBorder(ACCENT, 2, true),
                new EmptyBorder(6, 10, 6, 10)));
        nameField.setHorizontalAlignment(JTextField.CENTER);
        nameField.addActionListener(e -> handleLogin());   // Enter key

        // error label 
        errorLabel = new JLabel(" ", SwingConstants.CENTER);
        errorLabel.setFont(new Font("Dialog", Font.ITALIC, 12));
        errorLabel.setForeground(new Color(200, 50, 50));
        errorLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        // start button 
        JButton startBtn = createStyledButton("▶  Start Learning");
        startBtn.addActionListener(e -> handleLogin());

        // assemble card 
        cardWrapper.add(logoLabel);
        cardWrapper.add(Box.createVerticalStrut(8));
        cardWrapper.add(title);
        cardWrapper.add(Box.createVerticalStrut(4));
        cardWrapper.add(subtitle);
        cardWrapper.add(Box.createVerticalStrut(28));
        cardWrapper.add(nameLabel);
        cardWrapper.add(Box.createVerticalStrut(8));
        cardWrapper.add(nameField);
        cardWrapper.add(Box.createVerticalStrut(6));
        cardWrapper.add(errorLabel);
        cardWrapper.add(Box.createVerticalStrut(16));
        cardWrapper.add(startBtn);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.anchor = GridBagConstraints.CENTER;
        bg.add(cardWrapper, gbc);
    }

    // login handler 
    private void handleLogin() {
        String name = nameField.getText().trim();
        if (name.isEmpty()) {
            errorLabel.setText("⚠  Please enter your name.");
            nameField.requestFocus();
            return;
        }
        // Delegate to MainApp which wires the rest of the app
        dispose();
        app.onLoginSuccess(name);
    }

    // helper 
    private JButton createStyledButton(String text) {
        JButton btn = new JButton(text) {
            @Override
            protected void paintComponent(Graphics g) {
                Graphics2D g2 = (Graphics2D) g;
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                                    RenderingHints.VALUE_ANTIALIAS_ON);
                if (getModel().isPressed()) {
                    g2.setColor(BG_TOP.darker());
                } else if (getModel().isRollover()) {
                    g2.setColor(ACCENT.brighter());
                } else {
                    g2.setColor(ACCENT);
                }
                g2.fill(new RoundRectangle2D.Float(0, 0, getWidth(), getHeight(), 14, 14));
                g2.setColor(TXT_LIGHT);
                g2.setFont(getFont());
                FontMetrics fm = g2.getFontMetrics();
                int x = (getWidth()  - fm.stringWidth(getText())) / 2;
                int y = (getHeight() + fm.getAscent() - fm.getDescent()) / 2;
                g2.drawString(getText(), x, y);
            }
        };
        btn.setFont(new Font("Dialog", Font.BOLD, 15));
        btn.setForeground(TXT_LIGHT);
        btn.setContentAreaFilled(false);
        btn.setBorderPainted(false);
        btn.setFocusPainted(false);
        btn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btn.setAlignmentX(Component.CENTER_ALIGNMENT);
        btn.setMaximumSize(new Dimension(Integer.MAX_VALUE, 48));
        btn.setPreferredSize(new Dimension(240, 48));
        return btn;
    }
}

