
import javax.swing.*;
import java.awt.*;

/**
 * @author LbZhang
 * @version 创建时间：2015年12月14日 下午5:14:11
 * @description 类说明
 */
public class Demo extends JPanel{

    private final int MID = 150;
    private final int TOP = 50;

    public Demo(){
        setPreferredSize(new Dimension(300,225));
        setBackground(Color.cyan);//背景色的设置
    }

    /**
     * 当图形组件在屏幕上渲染的时候会自动调用该组件的paintComponent方法。
     * 注意：paintComponent方法接收一个Graphics对象作为参数，Graphics对象
     * 定义一个特定图像的上下文，我们可以与之交互。
     *
     * draw a snowman
     */
    public void paintComponent(Graphics page){
        //确保背景色的绘制
        super.paintComponent(page);

        page.setColor(Color.blue);
        page.fillRect(0, 175, 300, 50);//Ground

        page.setColor(Color.yellow);
        page.fillOval(-50, -50, 80, 80);

        page.setColor(Color.white);
        page.fillOval(MID-20, TOP, 40, 40);
        page.fillOval(MID-35, TOP+35, 70, 50);
        page.fillOval(MID-50, TOP+80, 100, 60);

        page.setColor(Color.black);
        page.fillOval(MID-10, TOP+10, 5, 5);
        page.fillOval(MID+10, TOP+10, 5, 5);

        page.drawArc(MID-10, TOP+20, 20, 20, 190, 160);

        page.drawLine(MID-25, TOP+60, MID-50, TOP+20);
        page.drawLine(MID+55, TOP+60, MID+55, TOP+60);

        page.drawLine(MID-20, TOP+5, MID+20, TOP+5);

        page.fillRect(MID-15, TOP-20, 30, 25);
    }


    public static void main(String[] args) {
        JFrame jframe = new JFrame("pushcounter");
        jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        jframe.getContentPane().add(new Demo());
        jframe.pack();
        jframe.setVisible(true);
    }

}









