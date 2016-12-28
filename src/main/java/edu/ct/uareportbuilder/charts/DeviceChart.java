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
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PiePlot;
import org.jfree.data.general.DefaultPieDataset;

/**
 *
 * @author Steve
 */
public class DeviceChart extends UserAgentChart {
  
  public DeviceChart(BrowserStatistics stats) {
    DefaultPieDataset data = new DefaultPieDataset();
    double phonePercent = stats.getSmartPhonePercent();
    double tabletPercent = stats.getTabletPercent();
    double mobilePercent = stats.getMobilePercent();
    double desktopPercent = stats.getDesktopPercent();
    double otherPercent = stats.getOtherDevicePercent();
    double unknownPercent = stats.getUnknownDevicePercent();
    
    String phoneCategory = "Smartphone: " + phonePercent + "%";
    String tabletCategory = "Tablet: " + tabletPercent + "%";
    String mobileCategory = "Mobile: " + mobilePercent + "%";
    String desktopCategory = "Desktop: " + desktopPercent + "%";
    String otherCategory = "Other: " + otherPercent + "%";
    String unknownCategory = "Unknown: " + unknownPercent + "%";
    
    data.setValue(phoneCategory, phonePercent);
    data.setValue(tabletCategory, tabletPercent);
    data.setValue(mobileCategory, mobilePercent);
    data.setValue(desktopCategory, desktopPercent);
    data.setValue(otherCategory, otherPercent);
    data.setValue(unknownCategory, unknownPercent);
    
    chart = ChartFactory.createPieChart("Device Usage", data);
    chart.removeLegend();
    
    PiePlot plot = (PiePlot) chart.getPlot();
    plot.setSectionPaint(phoneCategory, Color.GREEN);
    plot.setSectionPaint(tabletCategory, Color.ORANGE);
    plot.setSectionPaint(mobileCategory, Color.RED);
    plot.setSectionPaint(desktopCategory, Color.CYAN);
    plot.setSectionPaint(otherCategory, Color.YELLOW);
    plot.setSectionPaint(unknownCategory, Color.GRAY);
    
    writeChartToFile("device_percentage_chart.png", 500, 300);
  }
}
