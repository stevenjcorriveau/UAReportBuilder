/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ct.uareportbuilder;

/**
 * Responsible for handling all parsed browser details since there may be many
 * of these in one browser UserAgent string.
 *
 * @author Glen Smith (glen@bytecode.com.au)
 * Modified by Steven Corriveau (scorriveau@commnet.edu)
 */
public class UserAgentDetails {

  private String browserName;
  private String browserVersion;
  private String browserComments;
  private String browserDevice;
  private String browserDeviceType;
  private String deviceModel;

  /**
   * Constructor.
   *
   * @param browserName the name of the browser
   * @param browserVersion the version of the browser
   * @param browserComments the operating system the browser is running on
   */
  UserAgentDetails(String browserName, String browserVersion, String browserComments, String browserDevice, String browserDeviceType, String deviceModel) {
    this.browserName = browserName;
    this.browserVersion = browserVersion;
    this.browserComments = browserComments;
    this.browserDevice = browserDevice;
    this.browserDeviceType = browserDeviceType;
    this.deviceModel = deviceModel;
  }

  public String getBrowserComments() {
    return browserComments;
  }

  public String getBrowserName() {
    return browserName;
  }

  public String getBrowserVersion() {
    return browserVersion;
  }

  public String getBrowserDevice() {
    return browserDevice;
  }

  public String getBrowserDeviceType() {
    return browserDevice;
  }

  public String getBrowserDeviceModel() {
    return deviceModel;
  }

}
