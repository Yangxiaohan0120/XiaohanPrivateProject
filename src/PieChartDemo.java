import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.labels.StandardPieSectionLabelGenerator;
import org.jfree.chart.plot.PiePlot3D;
import org.jfree.chart.title.TextTitle;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;

import java.awt.*;
import java.io.BufferedReader;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.HashMap;

public class PieChartDemo {

    String inputfile = "/Users/yxh/NetBeansProjects/XiaohanPrivateProject/database/Covid.txt";
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

    public PieChartDemo(String date) {
        //设置数据源
        PieDataset mDataset = GetDataset(date);
        //建立图表
        JFreeChart mChart = ChartFactory.createPieChart3D("各国分布比例", mDataset, true, true, false);
        //设置图表标题
        mChart.setTitle(new TextTitle("各国分布比例", new Font("黑体", Font.CENTER_BASELINE, 20)));
        //设置Legend字体
        mChart.getLegend().setItemFont(new Font("宋体", Font.ROMAN_BASELINE, 15));

        PiePlot3D mPiePlot = (PiePlot3D) mChart.getPlot();
        //以默认方式显示百分比
        //mPiePlot.setLabelGenerator(new StandardPieSectionLabelGenerator(StandardPieToolTipGenerator.DEFAULT_TOOLTIP_FORMAT));
        // 图片中显示百分比:自定义方式，{0} 表示选项， {1} 表示数值， {2} 表示所占比例 ,小数点后两位
        mPiePlot.setLabelGenerator(new StandardPieSectionLabelGenerator("{0}={1}({2})", NumberFormat.getNumberInstance(), new DecimalFormat("0.00%")));
        // 底部图例显示百分比:自定义方式， {0} 表示选项， {1} 表示数值， {2} 表示所占比例
        mPiePlot.setLegendLabelGenerator(new StandardPieSectionLabelGenerator("{0}={1}({2})"));
        //设置饼图标签字体
        mPiePlot.setLabelFont(new Font("宋体", Font.PLAIN, 15));
        //内置对象显示图表
        ChartFrame mChartFrame = new ChartFrame("各国分布比例", mChart);
        mChartFrame.pack();
        mChartFrame.setVisible(true);
    }

    public DefaultPieDataset GetDataset(String date) {
        DefaultPieDataset mDataset = new DefaultPieDataset();
        HashMap<String, Number> distribution = new HashMap<>();
        distribution = getInformationPieChart(this.inputfile, date);
        for (int i = 0; i < distribution.size(); i++) {
            String cityname = names[i];
            mDataset.setValue(cityname, distribution.get(cityname));
        }
        return mDataset;
    }


    //返回一个关于cityname这个城市的每天人数hashmap
    public HashMap<String, Number> getInformationPieChart(String inputfile, String date) {
        HashMap<String, Number> distribution = new HashMap<>();
        HashMap<String, String> DateInformation = new HashMap<>();
        DateInformation = dateinfor(inputfile);
        String temp = DateInformation.get(date);
        String[] temps = null;
//        System.out.println(information);
        temps = temp.split("\t");
        for (int i = 0; i < names.length; i++) {
            String cityname = names[i];
            distribution.put(cityname, Double.parseDouble(temps[i]));
        }
        return distribution;
    }

    // 返回一个关于不同城市名字和对应信息的hashmap
    public HashMap<String, String> dateinfor(String inputfile) {
        String temp = null;
        String[] temps = null;
        BufferedReader[] br = new BufferedReader[95];
        BufferedReader br1 = IOUtils.getTextReader(inputfile);
        String temp1 = null;
        String[] temps1 = null;
        int datenumber =0;
        try {
            temp1 = br1.readLine();
            temps1 = temp1.split("\t");
            datenumber = temps1.length-1;
        } catch (Exception e) {
            e.printStackTrace();
        }
        for (int i = 0; i < datenumber; i++) {
            br[i] = IOUtils.getTextReader(inputfile);
        }
        HashMap<String, String> DateInformation = new HashMap();
        try {
            for (int i = 0; i < datenumber; i++) {
                StringBuffer information = new StringBuffer();
                br[i].readLine();
                while ((temp = br[i].readLine()) != null) {
                    int index = i + 1;
                    temps = temp.split("\t");
                    information.append(temps[index] + "\t");
                    continue;
                }
                DateInformation.put(String.valueOf(i + 1), information.toString());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return DateInformation;
    }


    public static void main(String[] args) {
        String date = args[0];
//        String inputfile = args[0];
        new PieChartDemo(date);

    }
}