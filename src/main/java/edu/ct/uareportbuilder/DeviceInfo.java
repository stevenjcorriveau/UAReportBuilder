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

/**
 * This class stores the information for a particular device.
 * 
 * @author Steve
 */
public class DeviceInfo {
  
  private String deviceMake = null;
  private String deviceModel = null;
  private String deviceType = null;
  
  public DeviceInfo(String make, String model, String type) {
    this.deviceMake = make;
    this.deviceModel = model;
    this.deviceType = type;
  }
  
  public String getDeviceMake() {
    return this.deviceMake;
  }
  
  public String getDeviceModel() {
    return this.deviceModel;
  }
  
  public String getDeviceType() {
    return this.deviceType;
  }
}
