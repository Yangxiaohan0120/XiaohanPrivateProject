
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.labels.StandardPieSectionLabelGenerator;
import org.jfree.chart.plot.PiePlot3D;
import org.jfree.chart.title.TextTitle;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;

import java.awt.*;
import java.text.DecimalFormat;
import java.text.NumberFormat;

public class PieChartAction {
    /**
     * @param args
     */
    public static void main(String[] args)
    {
        //设置数据源
        PieDataset mDataset = GetDataset();
        //建立图表
        JFreeChart mChart = ChartFactory.createPieChart3D("项目进度分布", mDataset, true, true, false);
        //设置图表标题
        mChart.setTitle(new TextTitle("项目状态分布", new Font("黑体",Font.CENTER_BASELINE, 20)));
        //设置Legend字体
        mChart.getLegend().setItemFont(new Font("宋体", Font.ROMAN_BASELINE, 15));

        PiePlot3D mPiePlot = (PiePlot3D)mChart.getPlot();
        //以默认方式显示百分比
        //mPiePlot.setLabelGenerator(new StandardPieSectionLabelGenerator(StandardPieToolTipGenerator.DEFAULT_TOOLTIP_FORMAT));
        // 图片中显示百分比:自定义方式，{0} 表示选项， {1} 表示数值， {2} 表示所占比例 ,小数点后两位
        mPiePlot.setLabelGenerator(new StandardPieSectionLabelGenerator("{0}={1}({2})", NumberFormat.getNumberInstance(), new DecimalFormat("0.00%")));
        // 底部图例显示百分比:自定义方式， {0} 表示选项， {1} 表示数值， {2} 表示所占比例
        mPiePlot.setLegendLabelGenerator(new StandardPieSectionLabelGenerator("{0}={1}({2})"));
        //设置饼图标签字体
        mPiePlot.setLabelFont(new Font("宋体", Font.PLAIN, 15));
        //内置对象显示图表
        ChartFrame mChartFrame = new ChartFrame("项目状态分布", mChart);
        mChartFrame.pack();
        mChartFrame.setVisible(true);

    }
    public static PieDataset GetDataset()
    {
        DefaultPieDataset mDataset = new DefaultPieDataset();
        mDataset.setValue(" 市场前期", new Double(10));
        mDataset.setValue(" 立项", new Double(15));
        mDataset.setValue(" 计划", new Double(10));
//        mDataset.setValue(" 需求与设计", new Double(10));
//        mDataset.setValue(" 执行控制", new Double(35));
//        mDataset.setValue(" 收尾", new Double(10));
//        mDataset.setValue(" 运维",new Double(10));
        return mDataset;
    }
}
