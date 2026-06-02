import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;

public class HomeScreenGUI extends JFrame {

    // palette 
    private static final Color BG          = new Color(245, 247, 250);
    private static final Color HEADER_BG   = new Color(0, 94, 165);
    private static final Color CARD_LEARN  = new Color(0, 150, 109);
    private static final Color CARD_QUIZ   = new Color(232, 119, 34);
    private static final Color CARD_BOARD  = new Color(0, 94, 165);
    private static final Color TEXT_WHITE  = Color.WHITE;
    private static final Color TEXT_DARK   = new Color(30, 30, 30);
    private static final Color TEXT_SUB    = new Color(100, 100, 100);

    // state 
    private final MainApp app;

    // constructor 
    public HomeScreenGUI(MainApp app) {
        this.app = app;
        initUI();
    }

    // UI setup 
    private void initUI() {
        setTitle("SDG Quest – Home");
        setSize(390, 844);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);

        JPanel root = new JPanel(new BorderLayout());
        root.setBackground(BG);
        setContentPane(root);

        // header 
        root.add(buildHeader(), BorderLayout.NORTH);

        // scrollable body 
        JPanel body = new JPanel();
        body.setBackground(BG);
        body.setLayout(new BoxLayout(body, BoxLayout.Y_AXIS));
        body.setBorder(new EmptyBorder(20, 20, 20, 20));

        // Welcome banner
        body.add(buildWelcomeBanner());
        body.add(Box.createVerticalStrut(20));

        // Section title
        body.add(label("What do you want to do?", 16, Font.BOLD, TEXT_DARK));
        body.add(Box.createVerticalStrut(14));

        // Navigation cards
        body.add(buildNavCard("📚", "Learn",
                "Explore SDG educational content",
                CARD_LEARN, e -> openLearning()));
        body.add(Box.createVerticalStrut(14));

        body.add(buildNavCard("✏️", "Take the Quiz",
                "Test your SDG knowledge",
                CARD_QUIZ, e -> openQuiz()));
        body.add(Box.createVerticalStrut(14));

        body.add(buildNavCard("🏆", "Leaderboard",
                "See top scores and badges",
                CARD_BOARD, e -> openLeaderboard()));
        body.add(Box.createVerticalStrut(28));

        // Motivational footer quote
        body.add(buildQuote());

        JScrollPane scroll = new JScrollPane(body);
        scroll.setBorder(null);
        scroll.getVerticalScrollBar().setUnitIncrement(12);
        root.add(scroll, BorderLayout.CENTER);
    }

    // header 
    private JPanel buildHeader() {
        JPanel hdr = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.setColor(HEADER_BG);
                g.fillRect(0, 0, getWidth(), getHeight());
            }
        };
        hdr.setPreferredSize(new Dimension(390, 80));
        hdr.setLayout(new BorderLayout(0, 0));
        hdr.setBorder(new EmptyBorder(0, 18, 0, 18));

        JLabel appName = new JLabel("🌍  SDG Quest");
        appName.setFont(new Font("Georgia", Font.BOLD, 22));
        appName.setForeground(TEXT_WHITE);

        String name = (app.getUser() != null) ? app.getUser().getUsername() : "Player";
        JLabel userLbl = new JLabel("Hi, " + name + "!");
        userLbl.setFont(new Font("Dialog", Font.PLAIN, 13));
        userLbl.setForeground(new Color(200, 225, 255));

        hdr.add(appName,  BorderLayout.WEST);
        hdr.add(userLbl,  BorderLayout.EAST);
        return hdr;
    }

    // welcome banner 
    private JPanel buildWelcomeBanner() {
        JPanel p = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                Graphics2D g2 = (Graphics2D) g;
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                                    RenderingHints.VALUE_ANTIALIAS_ON);
                GradientPaint gp = new GradientPaint(
                        0, 0, new Color(0, 150, 109),
                        getWidth(), getHeight(), new Color(0, 94, 165));
                g2.setPaint(gp);
                g2.fill(new RoundRectangle2D.Float(0, 0, getWidth(), getHeight(), 18, 18));
            }
        };
        p.setOpaque(false);
        p.setLayout(new BoxLayout(p, BoxLayout.Y_AXIS));
        p.setBorder(new EmptyBorder(18, 18, 18, 18));
        p.setMaximumSize(new Dimension(Integer.MAX_VALUE, 120));

        JLabel heading = new JLabel("Welcome to SDG Quest!");
        heading.setFont(new Font("Georgia", Font.BOLD, 18));
        heading.setForeground(TEXT_WHITE);
        heading.setAlignmentX(LEFT_ALIGNMENT);

        JLabel sub = new JLabel(
                "<html>Learn about the UN Sustainable Development<br>"
                + "Goals and make a difference!</html>");
        sub.setFont(new Font("Dialog", Font.PLAIN, 13));
        sub.setForeground(new Color(220, 240, 225));
        sub.setAlignmentX(LEFT_ALIGNMENT);

        p.add(heading);
        p.add(Box.createVerticalStrut(6));
        p.add(sub);
        return p;
    }

    // navigation card 
    private JPanel buildNavCard(String icon, String title,
                                String subtitle, Color accent,
                                ActionListener action) {
        JPanel card = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                Graphics2D g2 = (Graphics2D) g;
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                                    RenderingHints.VALUE_ANTIALIAS_ON);
                g2.setColor(Color.WHITE);
                g2.fill(new RoundRectangle2D.Float(0, 0, getWidth(), getHeight(), 16, 16));
                // left accent bar
                g2.setColor(accent);
                g2.fill(new RoundRectangle2D.Float(0, 0, 6, getHeight(), 6, 6));
            }
        };
        card.setOpaque(false);
        card.setLayout(new BorderLayout(12, 0));
        card.setBorder(new EmptyBorder(16, 20, 16, 16));
        card.setMaximumSize(new Dimension(Integer.MAX_VALUE, 90));
        card.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        // Hover effect
        card.addMouseListener(new MouseAdapter() {
            @Override public void mouseEntered(MouseEvent e) {
                card.setBorder(new CompoundBorder(
                        new LineBorder(accent, 2, true),
                        new EmptyBorder(14, 18, 14, 14)));
                card.repaint();
            }
            @Override public void mouseExited(MouseEvent e) {
                card.setBorder(new EmptyBorder(16, 20, 16, 16));
                card.repaint();
            }
            @Override public void mouseClicked(MouseEvent e) { action.actionPerformed(null); }
        });

        JLabel iconLbl = new JLabel(icon);
        iconLbl.setFont(new Font("Dialog", Font.PLAIN, 36));

        JPanel textPanel = new JPanel();
        textPanel.setOpaque(false);
        textPanel.setLayout(new BoxLayout(textPanel, BoxLayout.Y_AXIS));

        JLabel titleLbl = new JLabel(title);
        titleLbl.setFont(new Font("Dialog", Font.BOLD, 16));
        titleLbl.setForeground(TEXT_DARK);

        JLabel subLbl = new JLabel(subtitle);
        subLbl.setFont(new Font("Dialog", Font.PLAIN, 12));
        subLbl.setForeground(TEXT_SUB);

        textPanel.add(titleLbl);
        textPanel.add(Box.createVerticalStrut(3));
        textPanel.add(subLbl);

        JLabel arrow = new JLabel("›");
        arrow.setFont(new Font("Dialog", Font.BOLD, 24));
        arrow.setForeground(accent);

        card.add(iconLbl,   BorderLayout.WEST);
        card.add(textPanel, BorderLayout.CENTER);
        card.add(arrow,     BorderLayout.EAST);
        return card;
    }

    // motivational quote 
    private JPanel buildQuote() {
        JPanel p = new JPanel(new BorderLayout());
        p.setOpaque(false);
        p.setMaximumSize(new Dimension(Integer.MAX_VALUE, 60));

        JLabel ql = new JLabel(
                "<html><center><i>\"The greatest threat to our planet is the<br>"
                + "belief that someone else will save it.\"</i></center></html>",
                SwingConstants.CENTER);
        ql.setFont(new Font("Georgia", Font.ITALIC, 12));
        ql.setForeground(TEXT_SUB);
        p.add(ql, BorderLayout.CENTER);
        return p;
    }

    // helpers 
    private JLabel label(String text, int size, int style, Color color) {
        JLabel l = new JLabel(text);
        l.setFont(new Font("Dialog", style, size));
        l.setForeground(color);
        l.setAlignmentX(LEFT_ALIGNMENT);
        return l;
    }

    // navigation actions 
    private void openLearning() {
        LearningScreenGUI ls = new LearningScreenGUI(app);
        ls.setVisible(true);
        // Optionally hide home: setVisible(false);
    }

    private void openQuiz() {
        QuizScreenGUI qs = new QuizScreenGUI(app);
        qs.setVisible(true);
    }

    private void openLeaderboard() {
        LeaderboardScreenGUI lb = new LeaderboardScreenGUI(app);
        lb.setVisible(true);
    }
}

