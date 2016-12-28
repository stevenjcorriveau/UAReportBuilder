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
package edu.ct.uareportbuilder;

import com.lowagie.text.Document;

/**
 *
 * @author Steve
 */
public class UAShutdownHook extends Thread {
  private Document userAgentPDF;
  
  public UAShutdownHook(Document doc) {
    this.userAgentPDF = doc;
  }
  
  public void run() {
    this.userAgentPDF.close();
  }
}
