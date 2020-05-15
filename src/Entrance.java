import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Entrance extends JFrame {

    public Entrance() {
        JFrame a = new JFrame("Entrance");
        JButton[] b = new JButton[2];
        for (int i = 0; i < b.length; i++) {
            b[i] = new JButton();
        }

        for (int i = 0; i < b.length; i++) {
            a.add(b[i]);
        }
        a.setSize(350, 250);
        a.setLocationRelativeTo(null);
        a.setLayout(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        a.setVisible(true);

        b[0].setBounds(100, 50, 150, 50);
        b[1].setBounds(100, 100, 150, 50);
        b[0].setText("PieChart");
        b[1].setText("LineChart");

        b[0].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new PieChartGUI();
                setVisible(false);
            }
        });

        b[1].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new LineChartGUI();
                setVisible(false);
            }
        });

    }

    public static void main(String[] args) {
        new Entrance();
    }
}