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
public class BrowserChart extends UserAgentChart {
  
  public BrowserChart(BrowserStatistics stats) {
    DefaultPieDataset data = new DefaultPieDataset();
    double webkitPercent = stats.getWebKitPercent();
    double geckoPercent = stats.getGeckoPercent();
    double tridentPercent = stats.getTridentPercent();
    double otherPercent = stats.getMiscBrowserPercent();
    double unknownPercent = stats.getUnknownBrowserPercent();
    
    String webkitCategory = "Webkit-based: " + webkitPercent + "%";
    String geckoCategory = "Gecko-based: " + geckoPercent + "%";
    String tridentCategory = "Trident-based: " + tridentPercent + "%";
    String otherCategory = "Other: " + otherPercent + "%";
    String unknownCategory = "Unknown: " + unknownPercent + "%";
    
    data.setValue(webkitCategory, webkitPercent);
    data.setValue(geckoCategory, geckoPercent);
    data.setValue(tridentCategory, tridentPercent);
    data.setValue(otherCategory, otherPercent);
    data.setValue(unknownCategory, unknownPercent);
    
    chart = ChartFactory.createPieChart("Browser Usage", data);
    chart.removeLegend();
    
    PiePlot plot = (PiePlot) chart.getPlot();
    plot.setSectionPaint(webkitCategory, Color.GREEN);
    plot.setSectionPaint(geckoCategory, Color.ORANGE);
    plot.setSectionPaint(tridentCategory, Color.CYAN);
    plot.setSectionPaint(otherCategory, Color.YELLOW);
    plot.setSectionPaint(unknownCategory, Color.GRAY);
    
    writeChartToFile("browser_percentage_chart.png", 500, 300);
  }
}
