package Week06_01;
/**
 *
 * @author Aman
 */
import org.jfree.chart.ChartFactory;  
import org.jfree.chart.ChartPanel;  
import org.jfree.chart.JFreeChart;  
import org.jfree.chart.axis.ValueAxis;  
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import org.jfree.chart.StandardChartTheme;

import javax.swing.*;  
import java.awt.*;  
import java.awt.event.WindowAdapter;  
import java.awt.event.WindowEvent;  
 
public class RealTimeChart extends ChartPanel implements Runnable {  
  
    private static XYSeries TimeSeries;  
    private int counter=0;
  
    public RealTimeChart(String chartContent, String title,String xAxisName, String yAxisName) {  
        super(createChart(chartContent, title,xAxisName, yAxisName));  
    }  
  
    private static JFreeChart createChart(String chartContent, String title, String xAxisName,String yAxisName) {  
        TimeSeries = new XYSeries(chartContent);  
        XYSeriesCollection timeseriescollection = new XYSeriesCollection(TimeSeries);  
        JFreeChart jfreechart = ChartFactory.createXYLineChart(title,xAxisName,yAxisName,timeseriescollection,PlotOrientation.VERTICAL,true,true,true);
        ValueAxis x = jfreechart.getXYPlot().getDomainAxis();
        x.setAutoRange(true);
        x.setFixedAutoRange(20);
        return jfreechart;  
    }  
  
    @Override  
    public void run() {  
        while (true) {  
            if(counter<1000000) {
                counter++;
            } else {
                break;
            }
            try {
                TimeSeries.add(counter, Math.random() * 100);  
                Thread.sleep(500);
            } catch (InterruptedException e) {  
            }
        }
    }  
  
    public static void main(String[] args) {
        StandardChartTheme standardChartTheme = new StandardChartTheme("Chart");  
        standardChartTheme.setExtraLargeFont(new Font("Avenir Next", Font.BOLD,25));  
        standardChartTheme.setRegularFont(new Font("Avenir Next", Font.PLAIN, 15));  
        standardChartTheme.setLargeFont(new Font("Avenir Next", Font.PLAIN, 15));  
        ChartFactory.setChartTheme(standardChartTheme);
        
        JFrame frame = new JFrame("Real-Time Chart");  
        RealTimeChart realTimeChart = new RealTimeChart("Random Numbers","Chart for Displaying Random Numbers","Counter","Number");  
        frame.getContentPane().add(realTimeChart, BorderLayout.CENTER);  
        frame.pack();  
        frame.setVisible(true);
        
        (new Thread(realTimeChart)).start();  
        frame.addWindowListener(new WindowAdapter() {  
            @Override  
            public void windowClosing(WindowEvent windowevent) {  
                System.exit(0);  
            }  
        });  
    }  
}