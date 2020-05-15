import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PieChartGUI extends JFrame{

    private static final JDesktopPane DESKTOP_PANE = new JDesktopPane();

    public PieChartGUI(){

        JFrame f = new JFrame("Demo");
//        final JTextField tf = new JTextField();
//        tf.setBounds(50, 50, 150, 20);
        String dates = "1\n" +
                "2\n" +
                "3\n" +
                "4\n" +
                "5\n" +
                "6\n" +
                "7\n" +
                "8\n" +
                "9\n" +
                "10\n" +
                "11\n" +
                "12\n" +
                "13\n" +
                "14\n" +
                "15\n" +
                "16\n" +
                "17\n" +
                "18\n" +
                "19\n" +
                "20\n" +
                "21\n" +
                "22\n" +
                "23\n" +
                "24\n" +
                "25\n" +
                "26\n" +
                "27\n" +
                "28\n" +
                "29\n" +
                "30\n" +
                "31\n" +
                "32\n" +
                "33\n" +
                "34\n" +
                "35\n" +
                "36\n" +
                "37\n" +
                "38\n" +
                "39\n" +
                "40\n" +
                "41\n" +
                "42\n" +
                "43\n" +
                "44\n" +
                "45\n" +
                "46\n" +
                "47\n" +
                "48\n" +
                "49\n" +
                "50\n" +
                "51\n" +
                "52\n" +
                "53\n" +
                "54\n" +
                "55\n" +
                "56\n" +
                "57\n" +
                "58\n" +
                "59\n" +
                "60\n" +
                "61\n" +
                "62\n" +
                "63\n" +
                "64\n" +
                "65\n" +
                "66\n" +
                "67\n" +
                "68\n" +
                "69\n" +
                "70\n" +
                "71\n" +
                "72\n" +
                "73\n" +
                "74\n" +
                "75\n" +
                "76\n" +
                "77\n" +
                "78\n" +
                "79\n" +
                "80\n" +
                "81\n" +
                "82\n" +
                "83\n" +
                "84\n" +
                "85\n" +
                "86\n" +
                "87\n" +
                "88\n" +
                "89\n" +
                "90\n" +
                "91\n" +
                "92\n" +
                "93\n" +
                "94\n" +
                "95";
        String[] names = dates.split("\n");
        JButton[] b = new JButton[95];
        for (int i = 0; i < b.length; i++) {
            int x = 130 * (i%5);
            int y = (i/5)* 35;
            b[i] = new JButton();
            b[i].setBounds(x, y, 120, 30);
            b[i].setText("NO."+names[i]+" day");
            String date = b[i].getText().replace(" day","").split("NO.")[1];

            b[i].addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
//                String name = tf.getText();
//                String cityname = tf.getText();
                    PieChartDemo d = new PieChartDemo(date);
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
        f.setSize(750, 750);
        f.setLocationRelativeTo(null);
        f.setLayout(null);
        f.setVisible(true);
    }

    public static void addIFame(JInternalFrame iframe) { // 添加子窗体的方法
        DESKTOP_PANE.add(iframe);
    }

    public static void main(String[] args) {
        new PieChartGUI();
    }
}