import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI implements ActionListener {
    private int clicks = 0;
    private JLabel label;
    private JFrame frame;
    private JButton button;
    private JPanel panel;

    public GUI() {
        frame = new JFrame();
        button = new JButton("Click");
        button.addActionListener(this);
        label = new JLabel("Number of Clicks: " + clicks);

        panel = new JPanel();
        panel.setBorder(BorderFactory.createEmptyBorder(30, 10, 30, 30));
        panel.setLayout(new GridLayout(0, 1));
        panel.add(button);
        panel.add(label);

        frame.add(panel, BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Example GUI");
        frame.pack();
        frame.setVisible(true);
    }
    public static void main(String[] args) {
        new GUI();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        clicks++;
        label.setText("Number of Clicks: " + clicks);
    }
}