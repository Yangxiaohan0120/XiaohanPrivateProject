import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LineChartGUI extends JFrame{

    private static final JDesktopPane DESKTOP_PANE = new JDesktopPane();

    public LineChartGUI(){

        JFrame f = new JFrame("Demo");
//        final JTextField tf = new JTextField();
//        tf.setBounds(50, 50, 150, 20);
        String citynames = "Afghanistan\n" +
                "Australia\n" +
                "Canada\n" +
                "China\n" +
                "France\n" +
                "Iceland\n" +
                "India\n" +
                "Indonesia\n" +
                "Iran\n" +
                "Iraq\n" +
                "Ireland\n" +
                "Italy\n" +
                "Japan\n" +
                "South Korea\n" +
                "Pakistan\n" +
                "Panama\n" +
                "Peru\n" +
                "Poland\n" +
                "Russia\n" +
                "South Africa\n" +
                "Spain\n" +
                "United Kingdom";
        String[] names = citynames.split("\n");
        JButton[] b = new JButton[names.length];
        for (int i = 0; i < b.length; i++) {
            int x = 130 * (i%4);
            int y = (i/4)* 35;
            b[i] = new JButton();
            b[i].setBounds(x, y, 120, 30);
            b[i].setText(names[i]);
            String cityname = b[i].getText();
            b[i].addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
//                String name = tf.getText();
//                String cityname = tf.getText();
                    LineChartDemo d = new LineChartDemo(cityname);
//                tf.setText(p);
//                demo.LineChartDemo();
//                    tf.setText("按钮事件如此简单");
//                    tf.setBackground(Color.cyan);
                }
            });
        }
        for (int i = 0; i < names.length; i++) {
            f.add(b[i]);
        }
        f.setSize(600, 300);
        f.setLocationRelativeTo(null);
        f.setLayout(null);
        f.setVisible(true);
    }

    public static void addIFame(JInternalFrame iframe) { // 添加子窗体的方法
        DESKTOP_PANE.add(iframe);
    }

    public static void main(String[] args) {
        new LineChartGUI();
    }
}