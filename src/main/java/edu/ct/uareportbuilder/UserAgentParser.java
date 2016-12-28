/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ct.uareportbuilder;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 
 * @author Steven Corriveau (scorriveau@commnet.edu)
 */
public class UserAgentParser {
  private HashMap<String, DeviceInfo> deviceMap = new HashMap<String, DeviceInfo>();
  private File skipFile = new File("skipped.txt");
  private File notFoundFile = new File("not_found.txt");
  private File deviceInfo = new File("device_info.txt");
  private BufferedWriter skipped;
  private BufferedWriter notFound;
  private BufferedReader devices;
  
  private String browserName;
  private String browserVersion;
  private String operatingSystem;
  private String osVersion;
  private String deviceType;
  private String browserDevice;
  private String productModel;
  private String productMake;
  private String language;
  private String country;
  
  private final BrowserStatistics stats = new BrowserStatistics();

  public UserAgentParser() {
    try {
      skipped = new BufferedWriter(new FileWriter(skipFile, true));
      notFound = new BufferedWriter(new FileWriter(notFoundFile, true));
      devices = new BufferedReader(new FileReader(deviceInfo));
      
      loadDeviceInfo();
    } 
    catch (IOException ex) {
      Logger.getLogger(UserAgentParser.class.getName()).log(Level.SEVERE, null, ex);
    }
  }
  
  /**
   * Reads the device info file and loads the data into a map so that the
   * device info can be looked up later.
   */
  private void loadDeviceInfo() {
    String line;
      
      try {
        while ((line = devices.readLine()) != null) {
          String[] parts = line.split("\\t");
          DeviceInfo myInfo = new DeviceInfo(parts[1], parts[2], parts[3]);
          deviceMap.put(parts[0], myInfo);
        }
      } catch (IOException ex) {
        ex.printStackTrace();
        //Logger.getLogger(UAReportBuilderFrame.class.getName()).log(Level.SEVERE, null, ex);
      }
      
      try {
        devices.close();
      } catch (IOException ex) {
        ex.printStackTrace();
        //Logger.getLogger(UAReportBuilderFrame.class.getName()).log(Level.SEVERE, null, ex);
      }
  }
    
  /**
   * Parses the incoming user agent string into useful data about the browser
   * and its operating system.
   *
   */
  public void parse(String userAgentString) {
    //this.userAgentString = userAgentString;
    
    if (userAgentString.startsWith("Dalvik")) {
      parseDalvikUA(userAgentString);
    }
    else if (userAgentString.contains("Series40") ||
             userAgentString.contains("hp-tablet")) {
      parseMiscUA(userAgentString);
    }
    else if (userAgentString.startsWith("Opera")) {
      parseOperaUA(userAgentString);
    }
    else if (userAgentString.contains("BlackBerry") ||
             userAgentString.contains("BB10") ||
             userAgentString.contains("PlayBook")) {
      parseBlackBerryUA(userAgentString);
    }
    else if (determineLinuxBased(userAgentString)) {
      parseLinuxUA(userAgentString);
    }
    else if (userAgentString.contains("Macintosh") ||
             userAgentString.contains("Mac_PowerPC") ||
             userAgentString.contains("iPhone")  ||
             userAgentString.contains("iPod")  ||
             userAgentString.contains("iPad")) {
      parseMacintoshUA(userAgentString);
    }
    else if (userAgentString.contains("Windows")) {
      parseWindowsUA(userAgentString);
    }
    else {
      try {
        skipped.write(userAgentString);
        skipped.newLine();
        System.out.println("Not in good place...");
      } 
      catch (IOException ex) {
        ex.printStackTrace();
      }
    }
    
    // See if we can parse out a language/country token
    String[] langCountry = detectLangCountry(userAgentString);
    language = langCountry[0];
    country = langCountry[1];
    
    // Need to process statistics
    if (browserName != null) {
      stats.analyze(browserName,
        browserVersion,
        operatingSystem,
        osVersion,
        deviceType,
        browserDevice,
        productModel,
        productMake,
        language,
        country
      );
    }
  }
  
  private boolean determineLinuxBased(String userAgentString) {
    boolean isLinuxBased = false;
    
    Pattern pLinux = Pattern.compile("Linux");
    Matcher mOS = pLinux.matcher(userAgentString);
    
    if (mOS.find()) {
      isLinuxBased = true;
    }
    else {
      Pattern pAndroid = Pattern.compile("Android");
      mOS = pAndroid.matcher(userAgentString);
      
      if (mOS.find()) {
        isLinuxBased = true;
      }
      else {
        Pattern pCrOS = Pattern.compile("CrOS");
        mOS = pCrOS.matcher(userAgentString);

        if (mOS.find()) {
          isLinuxBased = true;
        }
        else {
          Pattern px11 = Pattern.compile("X11");
          mOS = px11.matcher(userAgentString);

          if (mOS.find()) {
            isLinuxBased = true;
          }
        }
      }
    }
    
    return isLinuxBased;
  }
  
  /**
   * Handles the parsing of miscellaneous UA strings.
   *
   * @param userAgentString the user agent header from the browser.
   */
  private void parseMiscUA(String userAgentString) {
    operatingSystem = "Unknown";
    osVersion = "Unknown";
    browserName = "Unknown";
    browserVersion = "Unknown";
    deviceType = "Unknown";
    productModel = "Unknown";
    productMake = "Unknown";
    browserDevice = "Unknown";
    
    if (userAgentString.contains("Series40")) {
      // Lazily assuming Asha for device
      operatingSystem = "Other";
      browserName = "Other";
      deviceType = "Smartphone";
      productModel = "Asha";
    }
    else if (userAgentString.contains("hp-tablet")) {
      operatingSystem = "webOS";
      browserName = "wOSBrowser";
      deviceType = "Tablet";
      productModel = "TouchPad";
    }
  }
  
  /**
   * Handles the parsing of Linux systems.
   *
   * @param userAgentString the user agent header from the browser.
   */
  private void parseLinuxUA(String userAgentString) {
    operatingSystem = "Unknown";
    osVersion = "Unknown";
    browserName = "Unknown";
    browserVersion = "Unknown";
    deviceType = "Unknown";
    productModel = "Unknown";
    productMake = "Unknown";
    browserDevice = "Unknown";
    
    // Determine operating system
    Pattern pAndroid = Pattern.compile("(Android[ ]?(\\d+\\.\\d+\\.?\\d*)?)");
    Matcher mOS = pAndroid.matcher(userAgentString);
    
    if (userAgentString.matches("CrOS") || userAgentString.matches("Chromium")) {
      operatingSystem = "Chromium";
      osVersion = "Unknown";
    }
    else if (mOS.find()) {
      // Need to account for Windows 8.1+ spoofing of Android
      if (userAgentString.contains("Windows")) {
        // If we find 'Windows' this is Windows spoofing Android.  Pass on
        // processing to the Windows branch.
        parseWindowsUA(userAgentString);
        return;
      }
      else {
        // Test for Android
        if (mOS.group(2) != null) {
          operatingSystem = "Android";
          osVersion = mOS.group(2);
          deviceType = "Unknown";
        }
        else {
          if (userAgentString.contains("like Android")) {
            operatingSystem = "Linux";
            osVersion = "Unknown";
            deviceType = "Unknown";
          }
          else{
            operatingSystem = "Android";
            osVersion = "Unknown";
            deviceType = "Unknown";
          }
        }
      }
    }
    else {
      operatingSystem = "Linux";
      osVersion = "Unknown";
      deviceType = "Unknown";
    }
    
    // Determine browser
    Pattern pOpera = Pattern.compile("OPR/(\\d+\\.\\d+\\.?\\d*\\.?\\d*)");
    Matcher mBrowser = pOpera.matcher(userAgentString);
    
    if (mBrowser.find()) {
      browserName = "Opera";
      browserVersion = mBrowser.group(1);
    }
    else {
      String[] firefoxFamily = detectFirfoxFamily(userAgentString);
      
      if (firefoxFamily[0] != null) {
        browserName = firefoxFamily[0];
        browserVersion = firefoxFamily[1];
        deviceType = firefoxFamily[2];
        productModel = firefoxFamily[3];
        productMake = firefoxFamily[4];
      }
      else {
        String[] webkitFamily = detectWebKitFamily(userAgentString);
        
        if (webkitFamily[0] != null) {
          browserName = webkitFamily[0];
          browserVersion = webkitFamily[1];
          deviceType = webkitFamily[2];
          productModel = webkitFamily[3];
          productMake = webkitFamily[4];

          if (webkitFamily[5] != null) {
            // We overrode the OS
            operatingSystem = webkitFamily[5];
          }
        }
      }
    }
    
    // If Gecko/20100101 - this is a desktop
    Pattern pGecko = Pattern.compile("Gecko/20100101");
    Matcher mDevice = pGecko.matcher(userAgentString);
    
    if (mDevice.find()) {
      deviceType = "PC";
    }
    else if (userAgentString.contains("Windows Phone")) {      
      deviceType = "Smartphone";
    }
    else if (userAgentString.contains("Mobile;")) {
      // Gecko strings with Mobile; are most likely to be smartphones
      deviceType = "Smartphone";
    }
    else if (userAgentString.contains("Tablet;")) {
      // Gecko strings with Tablet; are most likely to be tablets
      deviceType = "Tablet";
    }
    
    // Check build token to see if we can determine device
    String build = detectBuild(userAgentString);

    if (build != null) {
      String[] device = translateBuild(build);

      if (device[0] != null) {
        deviceType = device[2];
        productModel = device[1];
        productMake = device[0];
      }
    }
    
    if (userAgentString.contains("Lumia") ||
        userAgentString.contains("NOKIA; 909;") ||
        userAgentString.contains("WPDesktop; 909;")) {
      // Check Windows Phone strings for Lumia identification
      deviceType = "Smartphone";
      productModel = "Lumia";
    }
  }
  
  /**
   * Handles the special case for a user agent string for Windows.
   *
   * @param userAgentString the user agent header from the browser.
   */
  private void parseWindowsUA(String userAgentString) {
    operatingSystem = "Unknown";
    osVersion = "Unknown";
    browserName = "Unknown";
    browserVersion = "Unknown";
    deviceType = "Unknown";
    productModel = "Unknown";
    productMake = "Unknown";
    browserDevice = "Unknown";
    
    String[] os = null;
    
    Pattern pOSphone = Pattern.compile("(Windows Phone \\d+\\.\\d+\\.?\\d*)");
    Matcher  mOS = pOSphone.matcher(userAgentString);
      
    if (mOS.find()) {
      String windowsOS = mOS.group(1);
      os = translateMSOSString(windowsOS);
      operatingSystem = os[0];
      osVersion = os[1];  
      deviceType = "Smartphone";
    }
    else {
      Pattern pOS = Pattern.compile("(Windows NT \\d+\\.\\d+\\.?\\d*)");
      mOS = pOS.matcher(userAgentString);

      if (mOS.find()) {
        String windowsOS = mOS.group(1);
        os = translateMSOSString(windowsOS);
        operatingSystem = os[0];
        osVersion = os[1];

        // If Windows NT os and contains Touch indicates a tablet
        if (userAgentString.contains("Touch")) {  
          deviceType = "Tablet";
        }
        else {
          // We earlier checked for phone so this must be a desktop  
          deviceType = "PC";
        }
      }
    }
    
    Pattern pOpera = Pattern.compile("OPR/(\\d+\\.\\d+\\.?\\d*\\.?\\d*)");
    Matcher mBrowser = pOpera.matcher(userAgentString);
    
    if (mBrowser.find()) {
      browserName = "Opera";
      browserVersion = mBrowser.group(1);
    }
    else {
      // Check for new Edge browser
      Pattern pEdge = Pattern.compile("Edge/(\\d+\\.\\d+\\.?\\d*\\.?\\d*)");
      mBrowser = pEdge.matcher(userAgentString);

      if (mBrowser.find()) {
        browserName = "Edge";
        browserVersion = mBrowser.group(1);
      }
      else {
        String[] firefoxFamily = detectFirfoxFamily(userAgentString);

        if (firefoxFamily[0] != null) {
          browserName = firefoxFamily[0];
          browserVersion = firefoxFamily[1];

          // Only update if we have not previously identified device
          if (deviceType == "Unknown") {
            deviceType = firefoxFamily[2];
            productModel = firefoxFamily[3];
            productMake = firefoxFamily[4];
          }
        }
        else {
          String webkit[] = detectWebKitFamily(userAgentString);

          if (webkit[0] != null) {
            browserName = webkit[0];
            browserVersion = webkit[1];

            // Only update if we have not previously identified device
            if (deviceType == "Unknown") {
              deviceType = webkit[2];
              productModel = webkit[3];
              productMake = webkit[4];
            }
          }
          else {
            // Check for other trident-based browsers first
            Pattern pSiteKiosk = Pattern.compile("SiteKiosk (\\d+\\.\\d+\\.?\\d*\\.?\\d*)");
            mBrowser = pSiteKiosk.matcher(userAgentString);

            if (mBrowser.find()) {
              browserName = "SiteKiosk";
              browserVersion = mBrowser.group(1);
            }
            else {
              Pattern pSlimBrowser = Pattern.compile("SlimBrowser/(\\d+\\.\\d+\\.?\\d*\\.?\\d*)");
              mBrowser = pSlimBrowser.matcher(userAgentString);

              if (mBrowser.find()) {
                browserName = "SlimBrowser";
                browserVersion = mBrowser.group(1);
              }
              else {
                // Check for older style of list IE
                Pattern pIE = Pattern.compile("MSIE (\\d+)\\.\\d+\\.?\\d*\\.?\\d*");
                mBrowser = pIE.matcher(userAgentString);

                if (mBrowser.find()) {
                  browserName = "IE";
                  browserVersion = mBrowser.group(1);
                }
                else {
                  // Look for newer-style string
                  Pattern pNewIE = Pattern.compile("rv:(\\d+)\\.\\d+\\.?\\d*\\.?\\d*");
                  mBrowser = pNewIE.matcher(userAgentString);

                  if (mBrowser.find()) {
                    browserName = "IE";
                    browserVersion = mBrowser.group(1);
                  }
                  else {
                    browserName = "Other";
                    browserVersion = "Unknown";
                  }
                }
              }
            }
          }
        }
      }
    }
    
    if (userAgentString.contains("Tablet PC")) {
      // Identifies this as a Tablet PC, 'Tablet' for our purposes
      deviceType = "Tablet";
    }
    else if (userAgentString.contains("Lumia") ||
             userAgentString.contains("NOKIA; 909") ||
             userAgentString.contains("WPDesktop; 909")) {
      // Identifies this as a Lumia Smartphone
      deviceType = "Smartphone";
      productModel = "Lumia";
    }
  }
  
  /**
   * Handles the parsing of Macintosh systems.
   *
   * @param userAgentString the user agent header from the browser.
   */
  private void parseMacintoshUA(String userAgentString) {
    operatingSystem = "Macintosh";
    osVersion = "Unknown";
    browserName = "Unknown";
    browserVersion = "Unknown";
    deviceType = "Unknown";
    productModel = "Unknown";
    productMake = "Unknown";
    browserDevice = "Unknown";
    
    Pattern pCriOS = Pattern.compile("CriOS");
    Matcher mOS = pCriOS.matcher(userAgentString);
    
    if (mOS.find()) {
      operatingSystem = "iOS";
    }
    else {
      Pattern pOPiOS = Pattern.compile("OPiOS");
      mOS = pOPiOS.matcher(userAgentString);

      if (mOS.find()) {
        operatingSystem = "iOS";
      }
    }
    
    Pattern pOpera = Pattern.compile("OPR/(\\d+\\.\\d+\\.?\\d*\\.?\\d*)");
    Matcher mBrowser = pOpera.matcher(userAgentString);
    
    if (mBrowser.find()) {
      browserName = "Opera";
      browserVersion = mBrowser.group(1);
    }
    else {
      String[] firefoxFamily = detectFirfoxFamily(userAgentString);

      if (firefoxFamily[0] != null) {
        browserName = firefoxFamily[0];
        browserVersion = firefoxFamily[1];
        deviceType = firefoxFamily[2];
        productModel = firefoxFamily[3];
        productMake = firefoxFamily[4];
      }
      else {
        String webkit[] = detectWebKitFamily(userAgentString);

        if (webkit[0] != null) {
          browserName = webkit[0];
          browserVersion = webkit[1];
          deviceType = webkit[2];
          productModel = webkit[3];
          productMake = webkit[4];
        }
        else {
          browserName = "Other";
          browserVersion = "Unknown";
        }
      }
    }
    
    // If Gecko/20100101 - this is a desktop otherwise, we will check for 
    // mobile device
    Pattern pGecko = Pattern.compile("Gecko/20100101");
    Matcher mDevice = pGecko.matcher(userAgentString);
    
    if (mDevice.find()) {
      deviceType = "PC";
    }
    else if (userAgentString.contains("iPad")) {      
      deviceType = "Tablet";
      operatingSystem = "iOS";
    }
    else if (userAgentString.contains("iPod")) {      
      deviceType = "Smartphone";
      operatingSystem = "iOS";
    }
    else if (userAgentString.contains("iPhone")) {      
      deviceType = "Smartphone";
      operatingSystem = "iOS";
    }
    
    // Check build token to see if we can determine device
    String build = detectBuild(userAgentString);

    if (build != null) {
      String[] device = translateBuild(build);

      if (device[0] != null) {
        deviceType = device[2];
        productModel = device[1];
        productMake = device[0];
      }
    }
  }
  
  /**
   * Handles the special case for a user agent string for the Dalvik process.
   * Dalvik is the Android VM (for now).
   *
   * @param userAgentString the user agent header from the browser.
   */
  private void parseDalvikUA(String userAgentString) {
    osVersion = "Unknown";
    productModel = "Unknown";
    productMake = "Unknown";
    deviceType = "Unknown";
    browserDevice = "Unknown";
    
    Pattern pOS = Pattern.compile("Android (\\d\\.\\d\\.?\\d?)");
    Matcher mOS = pOS.matcher(userAgentString);
    
    if (mOS.find()) {
      operatingSystem = "Android";
      osVersion = mOS.group(1);
    }
    else {
      operatingSystem = "Unknown";
      osVersion = "Unknown";
    }
    
    String build = detectBuild(userAgentString);
    
    if (build != null) {
      String[] deviceInfo = translateBuild(build);
      
      if (deviceInfo[0] != null) {
        productMake = deviceInfo[0];
        productModel = deviceInfo[1];
        deviceType = deviceInfo[2];
      }
      else {
        productModel = "Unknown";
        productMake = "Unknown";
      }
    }
    else {
      productModel = "Unknown";
      productMake = "Unknown";
    }
    
    Pattern pBrowser = Pattern.compile("Dalvik/(\\d\\.\\d\\.?\\d?)");
    Matcher mBrowser = pBrowser.matcher(userAgentString);
    
    if (mBrowser.find()) {
      browserName = "Dalvik";
      browserVersion = mBrowser.group(1);
    }
    else {
      browserName = "Unknown";
      browserVersion = "Unknown";
    }
  }
  
  /**
   * Handles the special case for a user agent string for Opera.
   *
   * @param userAgentString the user agent header from the browser.
   */
  private void parseOperaUA(String userAgentString) {
    osVersion = "Unknown";
    productModel = "Unknown";
    productMake = "Unknown";
    deviceType = "Unknown";
    browserDevice = "Unknown";
    
    String[] os = {null, null};
    
    Pattern pSpreadTrum = Pattern.compile("SpreadTrum");
    Pattern pWindows = Pattern.compile("(Windows NT \\d+\\.\\d)");
    Pattern pAndroid = Pattern.compile("(Android[ ]?(\\d\\.\\d\\.?\\d?)?)");
    Pattern pLinux = Pattern.compile("Linux");
    Pattern pMacintosh = Pattern.compile("Macintosh");
    Matcher mOS = pSpreadTrum.matcher(userAgentString);
    
    // Test for 'SpreadTrum'
    if (mOS.find()) {
      operatingSystem = "Unknown";
      osVersion  = "Unknown";
      deviceType = "Mobile";
    }
    else {
      // Test for 'Windows NT'
      mOS = pWindows.matcher(userAgentString);
      
      if (mOS.find()) {
        os = translateMSOSString(mOS.group(1));
        operatingSystem = os[0];
        osVersion = os[1];
        deviceType = "Unknown";
      }
      else {
        // Test for Android
        mOS = pAndroid.matcher(userAgentString);

        if (mOS.find()) {
          if (mOS.group(2) != null) {
            operatingSystem = "Android";
            osVersion = mOS.group(2);
            deviceType = "Unknown";
          }
          else {
            if (userAgentString.contains("like Android")) {
              operatingSystem = "Linux";
              osVersion = "Unknown";
              deviceType = "Unknown";
            }
            else{
              operatingSystem = "Android";
              osVersion = "Unknown";
              deviceType = "Unknown";
            }
          }
        }
        else {
          // Test for Linux
          mOS = pLinux.matcher(userAgentString);
          
          if (mOS.find()) {
            operatingSystem = "Linux";
            osVersion = "Unknown";
            deviceType = "Unknown";
          }
          else {
            // Test for Macintosh
            mOS = pMacintosh.matcher(userAgentString);

            if (mOS.find()) {
              // Need to locate version
              Pattern pVersion = Pattern.compile("Intel Mac OS X (\\d+\\.\\d+\\.?\\d*)");
              Matcher mVersion = pVersion.matcher(userAgentString);

              if (mVersion.find()) {
                operatingSystem = "Macintosh";
                osVersion = mVersion.group(1);
                deviceType = "Unknown";
              }
              else {
                operatingSystem = "Macintosh";
                osVersion = "Unknown";
                deviceType = "Unknown";
              }
            }
          }
        }
      }
    }
    
    // Look for 'Opera Mini' first then 'Version\'
    Pattern pBrowser1 = Pattern.compile("Opera Mini/(\\d+\\.\\d+\\.?\\d*)");
    Pattern pBrowser2 = Pattern.compile("Version/(\\d+\\.\\d+\\.?\\d*)");
    Matcher mBrowser = pBrowser1.matcher(userAgentString);
    
    if (mBrowser.find()) {
      browserName = "Opera Mini";
      browserVersion = mBrowser.group(1);
    }
    else {
      mBrowser = pBrowser2.matcher(userAgentString);
      
      if (mBrowser.find()) {
        browserName = "Opera";
        browserVersion = mBrowser.group(1);
        
        Pattern pMobi = Pattern.compile("Opera Mobi/");
        Matcher mMobi = pMobi.matcher(userAgentString);
        
        if (mMobi.find()) {
          deviceType = "Mobile";
        }
      }
      else {
        browserName = "Opera";
        browserVersion = "Unknown";
      }
    }
  }
  
  /**
   * Handles the user agent strings for BlackBerry.
   *
   * @param userAgentString the user agent header from the browser.
   */
  private void parseBlackBerryUA(String userAgentString) {
    osVersion = "Unknown";
    productModel = "Unknown";
    productMake = "BlackBerry";
    deviceType = "Unknown";
    browserDevice = "Unknown";
    
    // Determine OS
    
    Pattern pAndroid = Pattern.compile("(Android[ ]?(\\d\\.\\d\\.?\\d?)?)");
    Matcher mOS = pAndroid.matcher(userAgentString);

    if (mOS.find()) {
      if (mOS.group(2) != null) {
        operatingSystem = "Android";
        osVersion = mOS.group(2);
        deviceType = "Unknown";
      }
      else {
        if (userAgentString.contains("like Android")) {
          operatingSystem = "Linux";
          osVersion = "Unknown";
          deviceType = "Unknown";
        }
        else{
          operatingSystem = "Android";
          osVersion = "Unknown";
          deviceType = "Unknown";
        }
      }
    }
    else {
      operatingSystem = "BlackBerry";
      osVersion = "Unknown";
    }
    
    // Determine browser
    String[] firefoxFamily = detectFirfoxFamily(userAgentString);

    if (firefoxFamily[0] != null) {
      browserName = firefoxFamily[0];
      browserVersion = firefoxFamily[1];
      deviceType = firefoxFamily[2];
    }
    else {
      String webkit[] = detectWebKitFamily(userAgentString);

      if (webkit[0] != null) {
        browserName = webkit[0];
        browserVersion = webkit[1];
        deviceType = webkit[2];
      }
      else {
        browserName = "Other";
        browserVersion = "Unknown";
      }
    }
    
    // Find Device
    if (userAgentString.contains("PlayBook")) {
      deviceType = "Tablet";
      productModel = "PlayBook";
    }
    else {
      if (userAgentString.contains("BB10")) {
        // The new UA does not provide device-specific information.  We can only
        // infer that it is a Smartphone
        deviceType = "Smartphone";
      }
      else {
        Pattern pDevice = Pattern.compile("BlackBerry (\\d{4}[\\w]?);");
        Matcher mDevice = pDevice.matcher(userAgentString);

        if (mDevice.find()) {
          String[] deviceInfo = lookupBlackBerryDevice(mDevice.group(1));
          
          if (deviceInfo[0] != null) {
            deviceType = deviceInfo[0];
            productModel = deviceInfo[1];
            productMake = "BlackBerry";
          }
        }
      }
    }
  }
  
  private String[] lookupBlackBerryDevice(String model) {
    String[] info = {null, null};
    
    switch(model){
      case "8300":
      case "8310":
      case "8320":
      case "8330":
      case "8350i":
      case "8520":
      case "8530":
      case "8900":
      case "9300":
      case "9310":
      case "9315":
      case "9320":
      case "9330":
      case "9350":
      case "9360":
      case "9370":
        info[0] = "Smartphone";
        info[1] = "Curve";
        break;
      case "9650":
      case "9700":
      case "9780":
      case "9790":
      case "9900":
      case "9930":
        info[0] = "Smartphone";
        info[1] = "Bold";
        break;
      case "9800":
      case "9810":
      case "9850":
      case "9860":
        info[0] = "Smartphone";
        info[1] = "Torch";
        break;
      default:
        break;
    }
    
    return info;
  }
  
  private String[] translateMSOSString(String uaos) {
    String testOS = uaos.toLowerCase().trim();
    String[] actualOS = {null, null};
    
      switch (testOS) {
        case "windows phone 10.0":
          actualOS[0] = "Windows Phone";
          actualOS[1] = "10.0";
          break;
        case "windows phone 8.1":
          actualOS[0] = "Windows Phone";
          actualOS[1] = "8.1";
          break;
        case "windows phone 8.0":
          actualOS[0] = "Windows Phone";
          actualOS[1] = "8.0";
          break;
        case "windows nt 10.0":
          actualOS[0] = "Windows";
          actualOS[1] = "10.0";
          break;
        case "windows nt 6.3":
          actualOS[0] = "Windows";
          actualOS[1] = "8.1";
          break;
        case "windows nt 6.2":
          actualOS[0] = "Windows";
          actualOS[1] = "8";
          break;
        case "windows nt 6.1":
          actualOS[0] = "Windows";
          actualOS[1] = "7";
          break;
        case "windows nt 6.0":
          actualOS[0] = "Windows";
          actualOS[1] = "Vista";
          break;
        case "windows nt 5.1":
        case "windows nt 5.2":
          actualOS[0] = "Windows";
          actualOS[1] = "XP";
          break;
        case "windows nt 5.0":
          actualOS[0] = "Windows";
          actualOS[1] = "2000";
          break;
        default: 
          actualOS[0] = "Windows";
          actualOS[1] = "Unknown";
      }
      
      return actualOS;
  }
  
  /**
   * Parses UA string for Puffin browser.
   *
   * @param userAgentString the User Agent String
   * @return a string array with null if browser not detected or the following
 parts:
   browserName
   browserVersion
   deviceType
   productModel
   productMake
   browserOSOverride
   */
  private String[] detectPuffin(String userAgentString) {
    String[] results = {null, null, null, null, null, null};
    
    Pattern pPuffin = Pattern.compile("Puffin/(\\d+\\.\\d+\\.?\\d*\\.?\\d*)(\\w?\\w?)");
    Matcher mBrowser = pPuffin.matcher(userAgentString);

    if (mBrowser.find()) {     
      results[0] = "Puffin";
      results[1] = mBrowser.group(1);
      String deviceCode = mBrowser.group(2);

      //Determine device based on code
      switch (deviceCode) {
        case "IP":
          results[2] = "Smartphone";
          results[5] = "iOS";
          break;
        case "IT":
          results[2] = "Tablet";
          results[5] = "iOS";
          break;
        case "AP":
          results[2] = "Smartphone";
          results[5] = "Android";
          break;
        case "AT":
          results[2] = "Tablet";
          results[5] = "Android";
          break;
        case "WP":
          results[2] = "Smartphone";
          results[5] = "Windows Phone";
          break;
        case "WT":
          results[2] = "Tablet";
          results[5] = "Windows Phone";
          break;
        case "M":
          results[2] = "Mobile";
          break;
        default:
          results[2] = "Unknown";
      }
    }
    
    results[3] = "Unknown";
    results[4] = "Unknown";
    
    return results;
  }
  
  /**
   * Parses UA string for Safari browsers.
   *
   * @param userAgentString the User Agent String
   * @return a string array with null if browser not detected or the following
 parts:
   browserName
   browserVersion
   deviceType
   productModel
   productMake
   browserOSOverride
   */
  private String[] detectSafari(String userAgentString) {
    String[] results = {null, null, null, null, null, null};
    
    Pattern pSafari = Pattern.compile("(Mobile )?Safari/?(\\d+\\.?\\d*\\.?\\d*\\.?\\d*)?");
    Matcher mBrowser = pSafari.matcher(userAgentString);

    if (mBrowser.find()) {
      results[0] = "Safari";
      
      if (mBrowser.group(2) != null) {
        results[1] = mBrowser.group(2);
      }
      else {
        results[1] = "Unknown";
      }
      
      if (mBrowser.group(1) != null) {
        results[0] = "Mobile Safari";
        results[2] = "Mobile";
      }
      else {
        results[2] = "Unknown";
      }
      results[3] = "Unknown";
      results[4] = "Unknown";
    }
    
    return results;
  }
  
  /**
   * Parses UA string for Maxthon browsers.  If QupZilla appears in the UA it is
   * QupZilla browser not Maxthon.
   *
   * @param userAgentString the User Agent String
   * @return a string array with null if browser not detected or the following
 parts:
   browserName
   browserVersion
   deviceType
   productModel
   productMake
   browserOSOverride
   */
  private String[] detectMaxthonOrQupZilla(String userAgentString) {
    String[] results = {null, null, null, null, null, null};
    
    Pattern pQupZilla = Pattern.compile("QupZilla/(\\d+\\.\\d+\\.?\\d*\\.?\\d*)");
    Matcher mBrowser = pQupZilla.matcher(userAgentString);

    if (mBrowser.find()) {
      results[0] = "QupZilla";
      results[1] = mBrowser.group(1);
      results[2] = "Unknown";
      results[3] = "Unknown";
      results[4] = "Unknown";
    }
      else {    
      Pattern pMaxthon = Pattern.compile("(Maxthon|MAXTHON)[/ ](\\d+\\.\\d+\\.?\\d*\\.?\\d*)");
      mBrowser = pMaxthon.matcher(userAgentString);
      
      if (mBrowser.find()) {
        results[0] = "Maxthon";
        results[1] = mBrowser.group(2);
        results[2] = "Unknown";
        results[3] = "Unknown";
        results[4] = "Unknown";
      }
      else {
        Pattern pMaxthon2 = Pattern.compile("MxBrowser/(\\d+\\.\\d+\\.?\\d*\\.?\\d*)");
        mBrowser = pMaxthon2.matcher(userAgentString);

        if (mBrowser.find()) {
          results[0] = "Maxthon";
          results[1] = mBrowser.group(1);
          results[2] = "Unknown";
          results[3] = "Unknown";
          results[4] = "Unknown";
        }
      }
    }
    
    //TODO - need to check for MyIE2 (Windows only???)
    return results;
  }
  
  /**
   * Parses UA string for any of the Firefox-related browsers.  Currently checks
   * for TenFoxFour, SeaMonkey, Iceweasel and Firefox.
   *
   * @param userAgentString the User Agent String
   * @return a string array with null if browser not detected or the following
 parts:
   browserName
   browserVersion
   deviceType
   productModel
   productMake
   browserOSOverride
   */
  private String[] detectFirfoxFamily(String userAgentString) {
    String[] results = {null, null, null, null, null, null};
    
    Pattern pSeaMonkey = Pattern.compile("(SeaMonkey|Iceweasel|IceDragon|TenFourFox|Waterfox|Cyberfox|PaleMoon|Mozilla Firebird|Camino|CometBird)/([\\d\\w]+\\.?[\\d\\w]*\\.?[\\d\\w]*\\.?[\\d\\w]*)");
    Matcher mBrowser = pSeaMonkey.matcher(userAgentString);
    
    // Look for variants first (Firefox always appeears in these lines)
    if (mBrowser.find()) {     
      results[0] = mBrowser.group(1);
      results[1] = mBrowser.group(2);
    }
    else {
      // Check for Firefox
      Pattern pFirefox = Pattern.compile("Firefox/(\\d+\\.\\d+\\.?\\d*\\.?\\d*)");
      mBrowser = pFirefox.matcher(userAgentString);

      if (mBrowser.find()) {     
        results[0] = "Firefox";
        results[1] = mBrowser.group(1);
      }
    }
    
    //TODO We can check for Mobile or Tablet tokens to find device type
    results[2] = "Unknown";
    results[3] = "Unknown";
    results[4] = "Unknown";
    
    return results;
  }
  
  /**
   * Parses UA string for any of the WebKit-based browsers.  Currently checks
   * for Chromium, Chrome, Safari, and many minor browsers.
   *
   * @param userAgentString the User Agent String
   * @return a string array with null if browser not detected or the following
 parts:
   browserName
   browserVersion
   deviceType
   productModel
   productMake
   browserOSOverride
   */
  private String[] detectWebKitFamily(String userAgentString) {
    String[] results = {null, "Unknown", "Unknown", "Unknown", "Unknown", null};
    
    String[] kindle = detectKindle(userAgentString);
    
    if (kindle[0] != null) {
      results = kindle;
    }
    else {
      String[] minor = detectMinorWebKit(userAgentString);

      if (minor[0] != null) {
        results = minor;
      }
      else {
        String[] major = detectMajorWebKit(userAgentString);

        if (major[0] != null) {
          results = major;
        }
      }
    }
    
    // Check for Kindle last: Adjust browser only if Silk found
    
    return results;
  }
  
  /**
   * Parses UA string for any of the major WebKit-based browsers.  Currently 
   * checks for Chromium, Chrome, Safari.  We also check for UCBrowser as we 
   * need to call this after detecting Kindle.
   *
   * @param userAgentString the User Agent String
   * @return a string array with null if browser not detected or the following
 parts:
   browserName
   browserVersion
   deviceType
   productModel
   productMake
   browserOSOverride
   */
  private String[] detectMajorWebKit(String userAgentString) {
    String[] results = {null, "Unknown", "Unknown", "Unknown", "Unknown", null};
    
    Pattern pUCbrowser = Pattern.compile("UCBrowser/(\\d+\\.\\d+\\.?\\d*\\.?\\d*)");
    Matcher mBrowser = pUCbrowser.matcher(userAgentString);
    
    if (mBrowser.find()) {
      results[0] = "UCBrowser";
      results[1] = mBrowser.group(1);
    }
    else {
      Pattern pChromium = Pattern.compile("Chromium/(\\d+\\.\\d+\\.?\\d*\\.?\\d*)");
      mBrowser = pChromium.matcher(userAgentString);

      if (mBrowser.find()) {
        results[0] = "Chromium";
        results[1] = mBrowser.group(1);
      }
      else {
        Pattern pChrome = Pattern.compile("Chrome/(\\d+\\.\\d+\\.?\\d*\\.?\\d*)");
        mBrowser = pChrome.matcher(userAgentString);

        if (mBrowser.find()) {
          results[0] = "Chrome";
          results[1] = mBrowser.group(1);
        }
        else {
          String safari[] = detectSafari(userAgentString);

          if (safari[0] != null) {
            results = safari;
          }
        }
      }
    }
    
    return results;
  }
  
  /**
   * Parses UA string for any of the not-so-heavily-used WebKit-based browsers.
   * Currently checks for Maxthon, Epiphany, Silk, Puffin, Midori, LuaKit.
   *
   * @param userAgentString the User Agent String
   * @return a string array with null if browser not detected or the following
 parts:
   browserName
   browserVersion
   deviceType
   productModel
   productMake
   browserOSOverride
   */
  private String[] detectMinorWebKit(String userAgentString) {
    String[] results = {null, "Unknown", "Unknown", "Unknown", "Unknown", null};
    
    // *Note* March 2012: Epiphany renamed Web - not sure of effect on UA
    Pattern pBatch1 = Pattern.compile("(Epiphany|Konqueror|qutebrowser|Midori|Qt|Sleipnir|OmniWeb|Skyfire|QQBrowser|MQQBrowser)/(\\d+\\.\\d+\\.?\\d*\\.?\\d*)");
    Pattern pBatch2 = Pattern.compile("(Mercury|Coast|RockMelt|Photon|WhiteHat Aviator|Fast_Browser|coc_coc_browser|BoBrowser|PlayFreeBrowser)/(\\d+\\.\\d+\\.?\\d*\\.?\\d*)");
    Pattern pBatch3 = Pattern.compile("(Dragon|YaBrowser|Iron|Diglo|NokiaBrowser|SamsungBrowser)/(\\d+\\.\\d+\\.?\\d*\\.?\\d*)");
    Matcher mBrowser = pBatch1.matcher(userAgentString);

    if (mBrowser.find()) {     
      results[0] = mBrowser.group(1);
      results[1] = mBrowser.group(2);
    }
    else {
      mBrowser = pBatch2.matcher(userAgentString);

      if (mBrowser.find()) {     
        results[0] = mBrowser.group(1);
        results[1] = mBrowser.group(2);
      }
      else {
        mBrowser = pBatch3.matcher(userAgentString);

        if (mBrowser.find()) {     
          results[0] = mBrowser.group(1);
          results[1] = mBrowser.group(2);
        }
        else {
          String maxthon[] = detectMaxthonOrQupZilla(userAgentString);

          if (maxthon[0] != null) {
            results = maxthon;
          }
          else {
            String puffin[] = detectPuffin(userAgentString);

            if (puffin[0] != null) {
              results[0] = puffin[0];
              results[1] = puffin[1];
              results[2] = puffin[2];
              results[3] = puffin[3];
              results[4] = puffin[4];

              if (puffin[5] != null) {
                // We overrode the OS
                results[5] = puffin[5];
              }
            }
            else {
              Pattern pLuaKit = Pattern.compile("luakit/?(\\d+\\.\\d+\\.?\\d*|[\\w\\d]+)?");
              mBrowser = pLuaKit.matcher(userAgentString);

              if (mBrowser.find()) {
                results[0] = "LuaKit";

                if (mBrowser.group(1) != null) {
                  results[1] = mBrowser.group(1);
                }
                else {
                  results[1] = "Unknown";
                }
              }
              else {
                Pattern pBaidu = Pattern.compile("(baidubrowser|baiduboxapp|Baidu|BaiduHD)/(\\d+\\.\\d+\\.?\\d*\\.?\\d*)?");
                mBrowser = pBaidu.matcher(userAgentString);

                if (mBrowser.find()) {
                  results[0] = "Baidu";

                  if (mBrowser.group(2) != null) {
                    results[1] = mBrowser.group(2);
                  }
                  else {
                    results[1] = "Unknown";
                  }
                }
              }
            }
          }
        }
      }
    }
    
    return results;
  }
  
  /**
   * Amazon Kindle products need to be handled separately.
   *
   * @param userAgentString the User Agent String
   * @return a string array with null if browser not detected or the following
 parts:
   browserName
   browserVersion
   deviceType
   productModel
   productMake
   browserOSOverride
   */
  private String[] detectKindle(String userAgentString) {
    String[] results = {null, "Unknown", "Unknown", "Unknown", "Unknown", null};
    
    Pattern pSilk = Pattern.compile("Silk/(\\d+\\.\\d+\\.?\\d*\\.?\\d*)");
    Matcher mBrowser = pSilk.matcher(userAgentString);

    if (mBrowser.find()) {
      results[0] = "Silk";
      results[1] = mBrowser.group(1);

      String build = detectBuild(userAgentString);
      
      if (build != null) {
        String[] device = translateKindleBuild(build);
        
        if (device[0] != null) {
          results[2] = device[2];
          results[3] = device[1];
          results[4] = device[0];
        }
      }
    }
    else {
      Pattern pKindle = Pattern.compile("Kindle");
      mBrowser = pKindle.matcher(userAgentString);

      if (mBrowser.find()) {
        // Found Kindle device not running Silk - need to determine the browser.
        String[] major = detectMajorWebKit(userAgentString);
        
        if (major[0] != null) {
          results[0] = major[0];
          results[1] = major[1];
        }
        else {
          results[0] = "Unknown";
          results[1] = "Unknown";
        }
        
        // Need to determine device type
        String build = detectBuild(userAgentString);
      
        if (build != null) {
          String[] device = translateKindleBuild(build);

          if (device[0] != null) {
            results[2] = device[2];
            results[3] = device[1];
            results[4] = device[0];
          }
        }
      }
      else {
        // Last place to check is the build element to see if it is a Kindle
        // device.
        String build = detectBuild(userAgentString);
      
        if (build != null) {
          String[] device = translateKindleBuild(build);

          if (device[0] != null) {
            // We have found a Kindle device
            results[2] = device[2];
            results[3] = device[1];
            results[4] = device[0];
          
            // Need to now determine browser          
            String[] minor = detectMajorWebKit(userAgentString);

            if (minor[0] != null) {
              results[0] = minor[0];
              results[1] = minor[1];
            }
            else {
              String[] major = detectMajorWebKit(userAgentString);

              if (major[0] != null) {
                results[0] = major[0];
                results[1] = major[1];
              }
              else {
                results[0] = "Unknown";
                results[1] = "Unknown";
              }
            }
          }
        }
      }
    }
    
    return results;
  }
  
  /**
   * Parses UA string looking for the build token.
   *
   * @param userAgentString the User Agent String
   * @return a string with the build or "Unknown"
   */
  private String detectBuild(String userAgentString) {
    String build = null;
    Pattern pBuild = Pattern.compile(";\\s*([\\w\\d\\s-/\\[\\]\\.]+)\\s+Build");
    //Pattern pBuild = Pattern.compile(";\\s*([\\w\\d\\s-]+)\\s+Build");
    //Pattern pBuild = Pattern.compile(";\\w*(.+) Build/(.+)\\w*\\)");
    Matcher mBuild = pBuild.matcher(userAgentString);

    if (mBuild.find()) {
      build = mBuild.group(1);
    }
    
    return build;
  }
  
  /**
   * Parses UA string looking for a language/country token.
   *
   * @param userAgentString the User Agent String
   * @return a string array with the language/country or "None"
   */
  private String[] detectLangCountry(String userAgentString) {
    String ua = userAgentString.toLowerCase();
    String[] details = {null , null};
    Pattern pLangCountry = Pattern.compile("[; ]([a-z]{2})[-_]([a-z]{2})[;\\)]");
    Matcher mLangCountry = pLangCountry.matcher(ua);

    if (mLangCountry.find()) {
      details[0] = mLangCountry.group(1);
      details[1] = mLangCountry.group(2);
    }
    else {
      // Check for known special cases
      Pattern pLangCountry2 = Pattern.compile("(en;|en\\)|en-;|es;|ru\\)| pl;)");
      Matcher mLangCountry2 = pLangCountry2.matcher(ua);

      if (mLangCountry2.find()) {
        String country = (mLangCountry2.group(0)).substring(0, 2);
        
        details[0] = country;
        details[1] = "None";
      } 
      else {
        details[0] = "None";
        details[1] = "None";
      }
    }
    
    return details;
  }
  
  /*
   * Uses the build number taken from the UA to determine device info.  We first
   * check device categories with special considerations then we do a misc
   * check.
   */
  private String[] translateBuild(String build) {
    String[] deviceInfo = {null, null, null};
    
    DeviceInfo device = deviceMap.get(build);
    
    if (device != null) {
      deviceInfo[0] = device.getDeviceMake();
      deviceInfo[1] = device.getDeviceModel();
      deviceInfo[2] = device.getDeviceType();
      
      return deviceInfo;
    }
    else {
      try {
        notFound.write(build);
        notFound.newLine();
      } 
      catch (IOException ex) {
        ex.printStackTrace();
        //Logger.getLogger(UserAgentParser.class.getName()).log(Level.SEVERE, null, ex);
      }
    }
    
    return deviceInfo;
  }
  
  /**
   * Returns the device type and model based on the inputed build string.
   *
   * @param build the build String
   * @return a string array with null if browser not detected or the following
   * parts:
   *   productMake
   *   productModel
   *   deviceType
   */
  private String[] translateKindleBuild(String build) {
    String[] results = {null, null, null};
    
    // Check build variable to determine device
    switch (build.trim()) {
      case "Amazon Kindle Fire" :
      case "Kindle Fire" :
      case "KFOT" :
        results[0] = "Amazon";
        results[1] = "Kindle Fire";
        results[2] = "Tablet";
        break;
      case "Kindle Fire HD" :
      case "KFTT" :
      case "KFJWI" :
      case "KFJWA" :
      case "KFSOWI" :
        results[0] = "Amazon";
        results[1] = "Kindle Fire HD";
        results[2] = "Tablet";
        break;
      case "Kindle Fire HDX" :
      case "KFTHWI" :
      case "KFTHWA" :
      case "KFAPWI" :
      case "KFAPWA" :
        results[0] = "Amazon";
        results[1] = "Kindle Fire HDX";
        results[2] = "Tablet";
        break;
      case "Fire HD" :
      case "KFARWI" :// Need test
      case "KFASWI" :
        results[0] = "Amazon";
        results[1] = "Fire HD";
        results[2] = "Tablet";
        break;
      case "Fire HDX" :
      case "KFSAWI":
      case "KFSAWA":
        results[0] = "Amazon";
        results[1] = "Fire HDX";
        results[2] = "Tablet";
        break;
      case "Fire Phone":
      case "SD4930UR":
        results[0] = "Amazon";
        results[1] = "Fire Phone";
        results[2] = "Smartphone";
        break;
      default:
        // Not Kindle
    }
      
    return results;
  }
  
  /**
   * @return the name of the browser
   */
  public String getBrowserName() {
    return browserName;
  }

  /**
   * @return the version of the browser
   */
  public String getBrowserVersion() {
    return browserVersion;
  }

  /**
   * @return the operating system the browser is running on.
   */
  public String getOperatingSystem() {
    return operatingSystem;
  }

  /**
   * @return the version of the operating system the browser is running on.
   */
  public String getOsVersion() {
    return osVersion;
  }

  /**
   * @return the device the browser is running on.
   */
  public String getBrowserDevice() {
    return browserDevice;
  }

  /**
   * @return the device type the browser is running on.
   */
  public String getDeviceType() {
    return deviceType;
  }

  /**
   * @return the product model from the build platform attribute.
   */
  public String getProductModel() {
    return productModel;
  }

  /**
   * @return the product build from the build platform attribute.
   */
  public String getProductMake() {
    return productMake;
  }

  /**
   * @return the language.
   */
  public String getLanguage() {
    return language;
  }

  /**
   * @return the country.
   */
  public String getCountry() {
    return country;
  }
  
  /**
   * @return the product build from the build platform attribute.
   */
  public String[] getBrowserDetails() {
    String[] details = {browserName, 
                        browserVersion, 
                        operatingSystem, 
                        osVersion, 
                        deviceType, 
                        browserDevice, 
                        productModel, 
                        productMake,
                        language,
                        country};
    return details;
  }
  
  public void printStats() {
    stats.dumpStats();
  }
  
  public BrowserStatistics getCurrentStatistics() {
    return stats;
  }
  
  public void closeFiles() {
    try {
      skipped.close();
      notFound.close();
    } catch (IOException ex) {
      ex.printStackTrace();
    }
  }
}
