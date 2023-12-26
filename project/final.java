package project;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class final{

public class ClickGame extends JFrame {

    private JButton clickButton;
    private JLabel scoreLabel;
    private int score = 0;

    public ClickGame() {
        super("Click Game");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        initComponents();
    }

    private void initComponents() {
        setLayout(new BorderLayout());

        clickButton = new JButton("Click me!");
        clickButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                handleButtonClick();
            }
        });

        scoreLabel = new JLabel("Score: 0", SwingConstants.CENTER);

        add(clickButton, BorderLayout.CENTER);
        add(scoreLabel, BorderLayout.SOUTH);
    }

    private void handleButtonClick() {
        score++;
        scoreLabel.setText("Score: " + score);
        JOptionPane.showMessageDialog(this, "Good job! Your score is now " + score);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new ClickGame().setVisible(true);
            }
        });
    }
}
}