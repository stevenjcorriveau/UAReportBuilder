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
public class OSChart extends UserAgentChart {
  
  public OSChart(BrowserStatistics stats) {
    DefaultPieDataset data = new DefaultPieDataset();
    double winPercent = stats.getWindowsTotalOSPercent();
    double macPercent = stats.getMacOSPercent();
    double unixPercent = stats.getNixOSPercent();
    double iosPercent = stats.getIOSPercent();
    double otherPercent = stats.getMiscOSPercent();
    double unknownPercent = stats.getUnknownOSPercent();
    
    String winCategory = "Windows: " + winPercent + "%";
    String macCategory = "Macintosh: " + macPercent + "%";
    String unixCategory = "Unix-based: " + unixPercent + "%";
    String iosCategory = "iOS: " + iosPercent + "%";
    String otherCategory = "Other: " + otherPercent + "%";
    String unknownCategory = "Unknown: " + unknownPercent + "%";
    
    data.setValue(winCategory, winPercent);
    data.setValue(macCategory, macPercent);
    data.setValue(unixCategory, unixPercent);
    data.setValue(iosCategory, iosPercent);
    data.setValue(otherCategory, otherPercent);
    data.setValue(unknownCategory, unknownPercent);
    
    chart = ChartFactory.createPieChart("OS Usage", data);
    chart.removeLegend();
    
    PiePlot plot = (PiePlot) chart.getPlot();
    plot.setSectionPaint(winCategory, Color.GREEN);
    plot.setSectionPaint(macCategory, Color.ORANGE);
    plot.setSectionPaint(unixCategory, Color.CYAN);
    plot.setSectionPaint(iosCategory, Color.RED);
    plot.setSectionPaint(otherCategory, Color.YELLOW);
    plot.setSectionPaint(unknownCategory, Color.GRAY);
    
    writeChartToFile("os_percentage_chart.png", 500, 300);
  }
}
