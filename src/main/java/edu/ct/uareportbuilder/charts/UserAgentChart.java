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

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;

/**
 *
 * @author Steve
 */
public abstract class UserAgentChart {
  protected JFreeChart chart;
  
  public UserAgentChart() {
    
  }
  
  protected BufferedImage getBufferedImage(int width, int height) {
    BufferedImage image = chart.createBufferedImage(width, height);
    return image;
  }
  
  protected void writeChartToFile(String filename, int width, int height) {
    BufferedImage deviceChartImage = chart.createBufferedImage(width, height);
    File chartFile = new File(filename);
    
    try {
      FileOutputStream fos = new FileOutputStream(chartFile);
      ChartUtilities.writeBufferedImageAsPNG(fos, deviceChartImage);
      fos.close();
    } 
    catch (FileNotFoundException ex) {
      Logger.getLogger(DeviceChart.class.getName()).log(Level.SEVERE, null, ex);
    } 
    catch (IOException ex) {
      Logger.getLogger(DeviceChart.class.getName()).log(Level.SEVERE, null, ex);
    }
  }
}
