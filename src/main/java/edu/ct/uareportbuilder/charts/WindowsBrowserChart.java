/*
 * Copyright (C) 2015 Steven Corriveau
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package edu.ct.uareportbuilder.charts;

import edu.ct.uareportbuilder.BrowserStatistics;
import java.awt.Color;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.plot.PiePlot;
import org.jfree.data.general.DefaultPieDataset;

/**
 *
 * @author Steve
 */
public class WindowsBrowserChart extends UserAgentChart {
  
  public WindowsBrowserChart(BrowserStatistics stats) {
    DefaultPieDataset data = new DefaultPieDataset();
    double ie6Percent = stats.getIE6Percent();
    double ie7Percent = stats.getIE7Percent();
    double ie8Percent = stats.getIE8Percent();
    double ie9Percent = stats.getIE9Percent();
    double ie10Percent = stats.getIE10Percent();
    double ie11Percent = stats.getIE11Percent();
    double edgePercent = stats.getEdgePercent();
    double otherPercent = stats.getOtherTridentPercent();
    
    String ie6Category = "IE6: " + ie6Percent + "%";
    String ie7Category = "IE7: " + ie7Percent + "%";
    String ie8Category = "IE8: " + ie8Percent + "%";
    String ie9Category = "IE9: " + ie9Percent + "%";
    String ie10Category = "IE10: " + ie10Percent + "%";
    String ie11Category = "IE11: " + ie11Percent + "%";
    String edgeCategory = "Edge: " + edgePercent + "%";
    String otherCategory = "Other: " + otherPercent + "%";
    
    data.setValue(ie6Category, ie6Percent);
    data.setValue(ie7Category, ie7Percent);
    data.setValue(ie8Category, ie8Percent);
    data.setValue(ie9Category, ie9Percent);
    data.setValue(ie10Category, ie10Percent);
    data.setValue(ie11Category, ie11Percent);
    data.setValue(edgeCategory, edgePercent);
    data.setValue(otherCategory, otherPercent);
    
    chart = ChartFactory.createPieChart("Windows Browsers", data);
    chart.removeLegend();
    
    PiePlot plot = (PiePlot) chart.getPlot();
    plot.setSectionPaint(ie6Category, Color.RED);
    plot.setSectionPaint(ie7Category, Color.BLUE);
    plot.setSectionPaint(ie8Category, Color.YELLOW);
    plot.setSectionPaint(ie9Category, Color.CYAN);
    plot.setSectionPaint(ie10Category, Color.ORANGE);
    plot.setSectionPaint(ie11Category, Color.GREEN);
    plot.setSectionPaint(edgeCategory, Color.MAGENTA);
    plot.setSectionPaint(otherCategory, Color.GRAY);
    
    writeChartToFile("windows_browser_percentage_chart.png", 500, 300);
  }
}
