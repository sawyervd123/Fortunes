import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

public class FortuneTellerFrame extends JFrame {
    private final JTextArea fortuneDisplay;
    private final ArrayList<String> fortunes;
    private int lastFortuneIndex = -1;

    public FortuneTellerFrame() {
        setTitle("Fortune Teller");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 400);
        setLayout(new BorderLayout());

        // Top Panel
        JPanel topPanel = new JPanel();
        JLabel titleLabel = new JLabel("Fortune Teller", JLabel.CENTER);
        titleLabel.setFont(new Font("Serif", Font.BOLD, 36));
        ImageIcon icon = new ImageIcon("fortune_icon.png");
        JLabel imageLabel = new JLabel(icon);
        topPanel.add(titleLabel);
        topPanel.add(imageLabel);
        add(topPanel, BorderLayout.NORTH);

        // Middle Panel
        fortuneDisplay = new JTextArea(10, 50);
        fortuneDisplay.setFont(new Font("SansSerif", Font.PLAIN, 16));
        fortuneDisplay.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(fortuneDisplay);
        add(scrollPane, BorderLayout.CENTER);

        // Bottom Panel
        JPanel bottomPanel = new JPanel();
        JButton readFortuneButton = new JButton("Read My Fortune!");
        JButton quitButton = new JButton("Quit");
        bottomPanel.add(readFortuneButton);
        bottomPanel.add(quitButton);
        add(bottomPanel, BorderLayout.SOUTH);

        // Fortune List
        fortunes = new ArrayList<>();
        populateFortunes();

        // Button Actions
        readFortuneButton.addActionListener(e -> displayFortune());
        quitButton.addActionListener(e -> System.exit(0));
    }

    private void populateFortunes() {
        fortunes.add("You will have a fantastic day!");
        fortunes.add("A surprise is waiting for you at home.");
        fortunes.add("Someone you miss will reach out soon.");
        fortunes.add("Unexpected good news is on the way.");
        fortunes.add("You will find money in an unusual place.");
        fortunes.add("An exciting adventure awaits you.");
        fortunes.add("Laughter is the key to a joyful life.");
        fortunes.add("A new friendship will brighten your week.");
        fortunes.add("Today is the perfect day to start something new.");
        fortunes.add("Your kindness will return to you in a surprising way.");
        fortunes.add("A great opportunity is around the corner.");
        fortunes.add("Your positive energy attracts great things.");
    }

    private void displayFortune() {
        Random rand = new Random();
        int newIndex;
        do {
            newIndex = rand.nextInt(fortunes.size());
        } while (newIndex == lastFortuneIndex);

        lastFortuneIndex = newIndex;
        fortuneDisplay.append(fortunes.get(newIndex) + "\n");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            FortuneTellerFrame frame = new FortuneTellerFrame();
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });
    }
}
