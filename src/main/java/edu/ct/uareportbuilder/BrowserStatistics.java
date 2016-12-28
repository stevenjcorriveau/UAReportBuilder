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

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Steve
 */
public class BrowserStatistics {
  // Keep tract of date and user to limit stats to one per day
  
  // OS Counters
  private int windowsVistaOSCount = 0;
  private int windowsXPOSCount = 0;
  private int windows7OSCount = 0;
  private int windows8OSCount = 0;
  private int windows10OSCount = 0;
  private int windows80PhoneOSCount = 0;
  private int windows81PhoneOSCount = 0;
  private int windows10PhoneOSCount = 0;
  private int windowsOtherOSCount = 0;
  private int windowsUnknownOSCount = 0;
  private int unixOSCount = 0;
  private int linuxOSCount = 0;
  private int android2OSCount = 0;
  private int android3OSCount = 0;
  private int android4OSCount = 0;
  private int android5OSCount = 0;
  private int androidOtherOSCount = 0;
  private int androidUnknownOSCount = 0;
  private int chromiumOSCount = 0;
  private int iOSCount = 0;
  private int macOSCount = 0;
  private int cyanogenOSCount = 0;
  private int maemoOSCount = 0;
  private int otherOSCount = 0;
  private int unknownOSCount = 0;
  
  // Browser counters
  private int safariCount = 0;
  private int safariMobileCount = 0;
  private int kindleCount = 0;
  private int chromeCount = 0;
  private int operaCount = 0;
  private int operaMiniCount = 0;
  private int operaCoastCount = 0;
  private int puffinCount = 0;
  private int dolphinCount = 0;
  private int konquerorCount = 0;
  private int otherWebKitCount = 0;
  private int ie6Count = 0;
  private int ie7Count = 0;
  private int ie8Count = 0;
  private int ie9Count = 0;
  private int ie10Count = 0;
  private int ie11Count = 0;
  private int edgeCount = 0;
  private int siteKioskCount = 0;
  private int otherTridentCount = 0;
  private int firefoxCount = 0;
  private int seaMonkeyCount = 0;
  private int iceweaselCount = 0;
  private int paleMoonCount = 0;
  private int tenFourFoxCount = 0;
  private int waterfoxCount = 0;
  private int cyberfoxCount = 0;
  private int icedragonCount = 0;
  private int otherGeckoCount = 0;
  private int miscBrowserCount = 0;
  private int unknownBrowserCount = 0;
  
  // Device counters
  private int desktopCount = 0;
  private int tabletCount = 0;
  private int smartphoneCount = 0;
  private int mobileCount = 0;
  private int otherCount = 0;
  private int unknownDeviceCount = 0;
  
  // Campus counters
  private int borCount = 0;
  private int accCount = 0;
  private int cccCount = 0;
  private int coccCount = 0;
  private int gccCount = 0;
  private int hccCount = 0;
  private int mccCount = 0;
  private int mxccCount = 0;
  private int nvccCount = 0;
  private int ncccCount = 0;
  private int nccCount = 0;
  private int qvccCount = 0;
  private int trccCount = 0;
  private int txccCount = 0;
  
  // Language/Country counters
  private HashMap<String, Integer> langMap = new HashMap<String, Integer>();
  private HashMap<String, String> langTrans = new HashMap<String, String>();
  private HashMap<String, Integer> countryMap = new HashMap<String, Integer>();
  private HashMap<String, String> countryTrans = new HashMap<String, String>();
  
  private File languageFile = new File("language_list.txt");
  private File countryFile = new File("country_list.txt");
  
  public BrowserStatistics() {
    try {
      BufferedReader languages = new BufferedReader(new FileReader(languageFile));
      String line;
      
      while ((line = languages.readLine()) != null) {
        String[] parts = line.split("\\t");
        langTrans.put(parts[0], parts[1]);
      }
      languages.close();
      
      BufferedReader countries = new BufferedReader(new FileReader(countryFile));
      
      while ((line = countries.readLine()) != null) {
        String[] parts = line.split("\\t");
        countryTrans.put(parts[0], parts[1]);
      }
      countries.close();
    } 
    catch (IOException ex) {
      Logger.getLogger(BrowserStatistics.class.getName()).log(Level.SEVERE, null, ex);
    }
  }
  
  public void analyze(String[] browserDetails) {
    analyze(browserDetails[0],
            browserDetails[1],
            browserDetails[2],
            browserDetails[3],
            browserDetails[4],
            browserDetails[5],
            browserDetails[6],
            browserDetails[7],
            browserDetails[8],
            browserDetails[9]);
  }
  
  public void analyze(String browserName, 
                      String browserVersion, 
                      String browserOperatingSystem, 
                      String osVersion,
                      String browserDeviceType, 
                      String browserDevice, 
                      String productModel, 
                      String productBuild,
                      String language,
                      String country) {
    
    analyzeBrowser(browserName, browserVersion);
    analyzeDevice(browserDeviceType);
    analyzeOS(browserOperatingSystem, osVersion);
    analyzeLanguage(language);
    analyzeCountry(country);
  }
  
  private void analyzeBrowser(String browser, String version) {
    // Accumulate statistics for browsers
    switch (browser) {
      case "Firefox":
        firefoxCount++;
        break;
      case "SeaMonkey":
        seaMonkeyCount++;
        break;
      case "Iceweasel":
        iceweaselCount++;
        break;
      case "PaleMoon":
        paleMoonCount++;
        break;
      case "TenFourFox":
        tenFourFoxCount++;
        break;
      case "Waterfox":
        waterfoxCount++;
        break;
      case "Cyberfox":
        cyberfoxCount++;
        break;
      case "IceDragon":
        icedragonCount++;
        break;
      case "Mozilla Firebird":
      case "Camino":
      case "CometBird":
        otherGeckoCount++;
        break;
      case "Safari":
        safariCount++;
        break;
      case "Mobile Safari":
        safariMobileCount++;
        break;
      case "Chrome":
      case "Chromium":
        chromeCount++;
        break;
      case "Opera":
        operaCount++;
        break;
      case "Opera Mini":
        operaMiniCount++;
        break;
      case "Coast":
        operaCoastCount++;
        break;
      case "Konqueror":
        konquerorCount++;
        break;
      case "Puffin":
        puffinCount++;
        break;
      case "Dolphin":
        dolphinCount++;
        break;
      case "Kindle":
        kindleCount++;
        break;
      case "RockMelt":
      case "Midori":
      case "QupZilla":
      case "Epiphany":
      case "UCBrowser":
      case "qutebrowser":
      case "wOSBrowser":
      case "Photon":
      case "WhiteHat Aviator":
      case "Silk":
      case "Qt":
      case "Sleipnir":
      case "Skyfire":
      case "OmniWeb":
      case "Mercury":
      case "Dragon":
      case "YaBrowser":
      case "Iron":
      case "Diglo":
      case "NokiaBrowser":
      case "SamsungBrowser":
      case "Baidu":
        otherWebKitCount++;
        break;
      case "IE":
        switch (version) {
          case "6":
            ie6Count++;
            break;
          case "7":
            ie7Count++;
            break;
          case "8":
            ie8Count++;
            break;
          case "9":
            ie9Count++;
            break;
          case "10":
            ie10Count++;
            break;
          case "11":
            ie11Count++;
            break;
        }
        break;
      case "Edge":
        edgeCount++;
        break;
      case "SiteKiosk":
        siteKioskCount++;
        break;
      case "SlimBrowser":
      case "QQBrowser":
      case "Maxthon":
        otherTridentCount++;
        break;
      case "Avant":
      case "Dalvik":
      case "LuaKit":
      case "BoBrowser":
      case "Fast_Browser":
      case "coc_coc_browser":
      case "MQQBrowser":
      case "PlayFreeBrowser":
      case "Other":
        miscBrowserCount++;
        break;
      default:
        unknownBrowserCount++;
        break;
    }
  }
  
  private void analyzeDevice(String device) {
    // Accumulate statistics for devices
    switch (device) {
      case "PC":
        desktopCount++;
        break;
      case "Tablet":
        tabletCount++;
        break;
      case "Smartphone":
        smartphoneCount++;
        break;
      case "Mobile":
        mobileCount++;
        break;
      case "Other":
        otherCount++;
        break;
      default:
        unknownDeviceCount++;
        break;
    }
  }
  
  private void analyzeOS(String os, String version) {
    // Accumulate statistices for Operating Systems
    switch (os) {
      case "Linux":
        linuxOSCount++;
        break;
      case "Macintosh":
        macOSCount++;
        break;
      case "iOS":
        iOSCount++;
        break;
      case "Chromium":
        chromiumOSCount++;
        break;
      case "Windows":
        switch (version) {
          case "10.0":
            windows10OSCount++;
            break;
          case "8.1":
          case "8.0":
          case "8":
            windows8OSCount++;
            break;
          case "7":
            windows7OSCount++;
            break;
          case "XP":
            windowsXPOSCount++;
            break;
          case "Vista":
            windowsVistaOSCount++;
            break;
          default:
            windowsOtherOSCount++;
            break;
        }
        break;
      case "Windows Phone":
        switch (version) {
          case "10.0":
            windows10PhoneOSCount++;
            break;
          case "8.1":
            windows81PhoneOSCount++;
            break;
          case "8.0":
            windows80PhoneOSCount++;
            break;
          default:
            windowsOtherOSCount++;
            break;
        }
        break;
      case "Android":
        String[] parts = version.split("\\.");
        switch (parts[0]) {
          case "2":
            android2OSCount++;
            break;
          case "3":
            android3OSCount++;
            break;
          case "4":
            android4OSCount++;
            break;
          case "5":
            android5OSCount++;
            break;
          default:
            androidUnknownOSCount++;
            break;
        }
        break;
      case "Cyanogen":
      case "Maemo":
      case "webOS":
      case "BlackBerry":
      case "Other":
        otherOSCount++;
        break;
      default:
        unknownOSCount++;
        break;
    }
  }
  
  private void analyzeLanguage(String langCode) {
    String lang = translateLanguage(langCode);
    
    // If lang equals null, we did not find a match in the language table.  This
    // is likely a regex false positive so we will skip counting it.
    if (lang != null) {
      // Accumulate statistics for languages
      if (langMap.containsKey(lang)) {
        langMap.put(lang, langMap.get(lang) + 1);
      }
      else {
        langMap.put(lang, 1);
      }

      // Accumulate total languages found
      if (langCode != "None") {
        if (langMap.containsKey("Total")) {
          langMap.put("Total", langMap.get("Total") + 1);
        }
        else {
          langMap.put("Total", 1);
        }
      }
    }
  }
  
  private void analyzeCountry(String countryCode) {
    String country = translateCountry(countryCode);
    
    // If country equals null, we did not find a match in the country table.  
    // This is likely a regex false positive so we will skip counting it.
    if (country != null) {
      // Accumulate statistics for countries
      if (countryMap.containsKey(country)) {
        countryMap.put(country, countryMap.get(country) + 1);
      }
      else {
        countryMap.put(country, 1);
      }

      // Accumulate total countries found
      if (countryCode != "None") {
        if (countryMap.containsKey("Total")) {
          countryMap.put("Total", countryMap.get("Total") + 1);
        }
        else {
          countryMap.put("Total", 1);
        }
      }
    }
  }
  
  private String translateLanguage(String langCode) {
    String lang = null;
    
    if (langCode == "None") {
      lang = langCode;
    }
    else {
      lang = langTrans.get(langCode);
    }
    
    return lang;
  }
  
  private String translateCountry(String countryCode) {
    String country = null;
    
    if (countryCode == "None") {
      country = countryCode;
    }
    else {
      country = countryTrans.get(countryCode);
    }
    
    return country;
  }
  
  /*
   *  Getters for Operating System statistics
   */
  public int getWindowsVistaOSCount() {
    return windowsVistaOSCount;
  }
  
  public int getWindowsXPOSCount() {
    return windowsXPOSCount;
  }

  public int getWindows7OSCount() {
    return windows7OSCount;
  }
  
  public int getWindows8OSCount() {
    return windows8OSCount;
  }
  
  public int getWindows10OSCount() {
    return windows10OSCount;
  }
  
  public int getWindows80PhoneOSCount() {
    return windows80PhoneOSCount;
  }
  
  public int getWindows81PhoneOSCount() {
    return windows81PhoneOSCount;
  }
  
  public int getWindows10PhoneOSCount() {
    return windows10PhoneOSCount;
  }
  
  public int getWindowsPhoneOSCount() {
    return windows80PhoneOSCount + windows81PhoneOSCount + windows10PhoneOSCount;
  }
  
  public int getWindowsOtherOSCount() {
    return windowsOtherOSCount;
  }
  
  public int getWindowsUnknownOSCount() {
    return windowsUnknownOSCount;
  }
  
  public int getWindowsOSCount() {
    return windowsVistaOSCount + windowsXPOSCount + windows7OSCount +
           windows8OSCount + windows80PhoneOSCount + windows81PhoneOSCount + 
           windows10OSCount + windows10PhoneOSCount + 
           windowsOtherOSCount + windowsUnknownOSCount;
  }
  
  public double getWindowsVistaOSPercent() {
    return Math.round((((double)windowsVistaOSCount / (double)getWindowsOSCount()) * 100.0) * 100.0) / 100.0;
  }
  
  public double getWindowsXPOSPercent() {
    return Math.round((((double)windowsXPOSCount / (double)getWindowsOSCount()) * 100.0) * 100.0) / 100.0;
  }

  public double getWindows7OSPercent() {
    return Math.round((((double)windows7OSCount / (double)getWindowsOSCount()) * 100.0) * 100.0) / 100.0;
  }
  
  public double getWindows8OSPercent() {
    return Math.round((((double)windows8OSCount / (double)getWindowsOSCount()) * 100.0) * 100.0) / 100.0;
  }
  
  public double getWindows10OSPercent() {
    return Math.round((((double)windows10OSCount / (double)getWindowsOSCount()) * 100.0) * 100.0) / 100.0;
  }
  
  public double getWindowsPhoneOSPercent() {
    return  Math.round((((double)getWindowsPhoneOSCount() / (double)getWindowsOSCount()) * 100.0) * 100.0) / 100.0;
  }
  
  public double getWindowsOtherOSPercent() {
    return Math.round((((double)windowsOtherOSCount / (double)getWindowsOSCount()) * 100.0) * 100.0) / 100.0;
  }
  
  public double getWindowsTotalOSPercent() {
    return Math.round((((double)getWindowsOSCount() / (double)getOSTotal()) * 100.0) * 100.0) / 100.0;
  }
  
  public int getUnixOSCount() {
    return unixOSCount;
  }
  
  public int getLinuxOSCount() {
    return linuxOSCount;
  }
  
  public int getAndroid2OSCount() {
    return android2OSCount;
  }
  
  public int getAndroid3OSCount() {
    return android3OSCount;
  }
  
  public int getAndroid4OSCount() {
    return android4OSCount;
  }
  
  public int getAndroid5OSCount() {
    return android5OSCount;
  }
  
  public int getAndroidOtherOSCount() {
    return androidOtherOSCount;
  }
  
  public int getAndroidUnknownOSCount() {
    return androidUnknownOSCount;
  }
  
  public int getAndroidTotalOSCount() {
    return android2OSCount + android3OSCount + android4OSCount + 
           android5OSCount + androidOtherOSCount + androidUnknownOSCount;
  }
  
  public int getNixOSCount() {
    return unixOSCount + linuxOSCount + android2OSCount + android3OSCount +
           android4OSCount + android5OSCount + androidOtherOSCount +
           androidUnknownOSCount;
  }
  
  public double getNixOSPercent() {
    return Math.round(((double)getNixOSCount() / (double)getOSTotal() * 100.0)*100.0) / 100.0;
  }
  
  public int getChromiumOSCount() {
    return chromiumOSCount;
  }
  
  public double getChromiumOSPercent() {
    return Math.round(((double)chromiumOSCount / (double)getOSTotal() * 100.0)*100.0) / 100.0;
  }
  
  public int getIOSCount() {
    return iOSCount;
  }
  
  public double getIOSPercent() {
    return Math.round(((double)iOSCount / (double)getOSTotal() * 100.0)*100.0) / 100.0;
  }
  
  public int getMacOSCount() {
    return macOSCount;
  }
  
  public double getMacOSPercent() {
    return Math.round((((double)macOSCount / (double)getOSTotal()) * 100.0) * 100.0) / 100.0;
  }
  
  public int getCyanogenOSCount() {
    return cyanogenOSCount;
  }
  
  public int getMaemoOSCount() {
    return maemoOSCount;
  }
  
  public int getMiscOSCount() {
    return chromiumOSCount + cyanogenOSCount + maemoOSCount + otherOSCount;
  }
  
  public double getMiscOSPercent() {
    return Math.round((((double)getMiscOSCount() / (double)getOSTotal()) * 100.0) * 100.0) / 100.0;
  }
  
  public int getUnknownOSCount() {
    return unknownOSCount;
  }
  
  public double getUnknownOSPercent() {
    return Math.round((((double)getUnknownOSCount() / (double)getOSTotal()) * 100.0) * 100.0) / 100.0;
  }
  
  public int getOSTotal() {
    return getWindowsOSCount() + getNixOSCount() + getChromiumOSCount() + 
           getIOSCount() + getMacOSCount() + getMiscOSCount() +
           getUnknownOSCount();
  }
  
  /*
   *  Getters for browser statistics
   */
  public int getSafariCount() {
    return safariCount;
  }
  
  public int getSafariMobileCount() {
    return safariMobileCount;
  }
  
  public int getKindleCount() {
    return kindleCount;
  }
  
  public int getChromeCount() {
    return chromeCount;
  }
  
  public int getOperaCount() {
    return operaCount;
  }
  
  public int getOperaMiniCount() {
    return operaMiniCount;
  }
  
  public int getCoastCount() {
    return operaCoastCount;
  }
  
  public int getPuffinCount() {
    return puffinCount;
  }
  
  public int getDolphinCount() {
    return dolphinCount;
  }
  
  public int getKonquerorCount() {
    return konquerorCount;
  }
  
  public int getOtherWebKitCount() {
    return otherWebKitCount;
  }
  
  public int getWebKitCount() {
    return safariCount + safariMobileCount + kindleCount + chromeCount +
           operaCount + operaMiniCount + operaCoastCount + puffinCount + 
           dolphinCount + konquerorCount + otherWebKitCount;
  }
  
  public double getWebKitPercent() {
    return Math.round((((double)getWebKitCount() / (double)getTotalBrowserCount()) * 100.0) * 100.0) / 100.0;
  }
  
  public int getIE6Count() {
    return ie6Count;
  }
  
  public int getIE7Count() {
    return ie7Count;
  }
  
  public int getIE8Count() {
    return ie8Count;
  }
  
  public int getIE9Count() {
    return ie9Count;
  }
  
  public int getIE10Count() {
    return ie10Count;
  }
  
  public int getIE11Count() {
    return ie11Count;
  }
  
  public int getEdgeCount() {
    return edgeCount;
  }
  
  public int getSiteKioskCount() {
    return siteKioskCount;
  }
  
  public int getOtherTridentCount() {
    return otherTridentCount;
  }
  
  public int getTridentCount() {
    return ie6Count + ie7Count + ie8Count + ie9Count + ie10Count + ie11Count +
           edgeCount + siteKioskCount + otherTridentCount;
  }
  
  public double getIE6Percent() {
    return Math.round((((double)ie6Count / (double)getTridentCount()) * 100.0) * 100.0) / 100.0;
  }
  
  public double getIE7Percent() {
    return Math.round((((double)ie7Count / (double)getTridentCount()) * 100.0) * 100.0) / 100.0;
  }
  
  public double getIE8Percent() {
    return Math.round((((double)ie8Count / (double)getTridentCount()) * 100.0) * 100.0) / 100.0;
  }
  
  public double getIE9Percent() {
    return Math.round((((double)ie9Count / (double)getTridentCount()) * 100.0) * 100.0) / 100.0;
  }
  
  public double getIE10Percent() {
    return Math.round((((double)ie10Count / (double)getTridentCount()) * 100.0) * 100.0) / 100.0;
  }
  
  public double getIE11Percent() {
    return Math.round((((double)ie11Count / (double)getTridentCount()) * 100.0) * 100.0) / 100.0;
  }
  
  public double getEdgePercent() {
    return Math.round((((double)edgeCount / (double)getTridentCount()) * 100.0) * 100.0) / 100.0;
  }
  
  public double getSiteKioskPercent() {
    return Math.round((((double)siteKioskCount / (double)getTridentCount()) * 100.0) * 100.0) / 100.0;
  }
  
  public double getOtherTridentPercent() {
    return Math.round((((double)otherTridentCount / (double)getTridentCount()) * 100.0) * 100.0) / 100.0;
  }
  
  public double getTridentPercent() {
    return Math.round((((double)getTridentCount() / (double)getTotalBrowserCount()) * 100.0) * 100.0) / 100.0;
  }
  
  public int getFirefoxCount() {
    return firefoxCount;
  }
  
  public int getSeaMonkeyCount() {
    return seaMonkeyCount;
  }
  
  public int getIceweaselCount() {
    return iceweaselCount;
  }
  
  public int getPaleMoonCount() {
    return paleMoonCount;
  }
  
  public int getTenFourFoxCount() {
    return tenFourFoxCount;
  }
  
  public int getWaterfoxCount() {
    return waterfoxCount;
  }
  
  public int getCyberfoxCount() {
    return cyberfoxCount;
  }
  
  public int getIcedragonCount() {
    return icedragonCount;
  }
  
  public int getOtherGeckoCount() {
    return otherGeckoCount;
  }
  
  public int getGeckoCount() {
    return firefoxCount + seaMonkeyCount + iceweaselCount + paleMoonCount + 
           tenFourFoxCount + waterfoxCount + cyberfoxCount + icedragonCount +
           otherGeckoCount;
  }
  
  public double getGeckoPercent() {
    return Math.round((((double)getGeckoCount() / (double)getTotalBrowserCount()) * 100.0) * 100.0) / 100.0;
  }
  
  public int getMiscBrowserCount() {
    return miscBrowserCount;
  }
  
  public double getMiscBrowserPercent() {
    return Math.round((((double)getMiscBrowserCount() / (double)getTotalBrowserCount()) * 100.0) * 100.0) / 100.0;
  }
  
  public int getUnknownBrowserCount() {
    return unknownBrowserCount;
  }
  
  public double getUnknownBrowserPercent() {
    return Math.round((((double)getUnknownBrowserCount() / (double)getTotalBrowserCount()) * 100.0) * 100.0) / 100.0;
  }
  
  public int getTotalBrowserCount() {
    return getWebKitCount() + getTridentCount() + getGeckoCount() + 
           miscBrowserCount + unknownBrowserCount;
  }
  
  /*
   *  Getters for device statistics
   */
  public int getTotalDeviceCount() {
    return desktopCount + tabletCount + smartphoneCount + mobileCount + 
           otherCount + unknownDeviceCount;
  }
  
  public int getDesktopCount() {
    return desktopCount;
  }
  
  public int getTabletCount() {
    return tabletCount;
  }
  
  public int getSmartPhoneCount() {
    return smartphoneCount;
  }
  
  public int getMobileCount() {
    return mobileCount;
  }
  
  public int getOtherDeviceCount() {
    return otherCount;
  }
  
  public int getUnknownDeviceCount() {
    return unknownDeviceCount;
  }
  public double getDesktopPercent() {
    return Math.round((((double)desktopCount / (double)getTotalDeviceCount()) * 100.0) * 100.0) / 100.0;
  }
  
  public double getTabletPercent() {
    return Math.round((((double)tabletCount / (double)getTotalDeviceCount()) * 100.0) * 100.0) / 100.0;
  }
  
  public double getSmartPhonePercent() {
    return Math.round((((double)smartphoneCount / (double)getTotalDeviceCount()) * 100.0) * 100.0) / 100.0;
  }
  
  public double getMobilePercent() {
    return Math.round((((double)mobileCount / (double)getTotalDeviceCount()) * 100.0) * 100.0) / 100.0;
  }
  
  public double getOtherDevicePercent() {
    return Math.round((((double)otherCount / (double)getTotalDeviceCount()) * 100.0) * 100.0) / 100.0;
  }
  
  public double getUnknownDevicePercent() {
    return Math.round((((double)unknownDeviceCount / (double)getTotalDeviceCount()) * 100.0) * 100.0) / 100.0;
  }
  
  // Get total for a particular language
  public int getLanguageTotal(String key){
    int total = 0;
    
    if (langMap.containsKey(key)) {
      total = langMap.get(key);
    }
    
    return total;
  }
  
  // Get total for a particular country
  public int getCountryTotal(String key){
    int total = 0;
    
    if (countryMap.containsKey(key)) {
      total = countryMap.get(key);
    }
    
    return total;
  }
  
  public HashMap getSortedLanguages() {
    return sortByValues(langMap);
  }
  
  public HashMap getSortedCountries() {
    return sortByValues(countryMap);
  }
  
  private HashMap sortByValues(HashMap map) {
    List list = new LinkedList(map.entrySet());
    
    Collections.sort(list, new Comparator() {
        public int compare(Object o1, Object o2) {
          return ((Comparable) ((Map.Entry) (o2)).getValue()).compareTo(((Map.Entry) (o1)).getValue());
        }
      }
    );
    
    HashMap sortedHashMap = new LinkedHashMap();
    for (Iterator it = list.iterator(); it.hasNext();) {
      Map.Entry entry = (Map.Entry) it.next();
      sortedHashMap.put(entry.getKey(), entry.getValue());
    }
    
    return sortedHashMap;
  }
  
  public void dumpStats() {
    System.out.println("-------------------------------------------");
    System.out.println("- Browser Statistics                      -");
    System.out.println("-------------------------------------------");
    System.out.println("*******************************************");
    System.out.println("* Operating Systems                       *");
    System.out.println("*******************************************");
    System.out.println("Windows:");
    System.out.println("  Vista:             " + windowsVistaOSCount);
    System.out.println("  XP:                " + windowsXPOSCount);
    System.out.println("  Windows 7:         " + windows7OSCount);
    System.out.println("  Windows 8:         " + windows8OSCount);
    System.out.println("  Windows Phone 8.0: " + windows80PhoneOSCount);
    System.out.println("  Windows Phone 8.1: " + windows81PhoneOSCount);
    System.out.println("  Other Windows:     " + windowsOtherOSCount);
    System.out.println("  Unknown Windows:   " + windowsUnknownOSCount);
    System.out.println("  Total Windows:     " + getWindowsOSCount());
    System.out.println("*nix-based:");
    System.out.println("  Unix:              " + unixOSCount);
    System.out.println("  Linix:             " + linuxOSCount);
    System.out.println("  Android 2:         " + android2OSCount);
    System.out.println("  Android 3:         " + android3OSCount);
    System.out.println("  Android 4:         " + android4OSCount);
    System.out.println("  Android 5:         " + android5OSCount);
    System.out.println("  Other Android:     " + androidOtherOSCount);
    System.out.println("  Unknown Android:   " + androidUnknownOSCount);
    System.out.println("  Total *Nix:        " + getNixOSCount());
    System.out.println("Misc:");
    System.out.println("  Chromium:          " + chromiumOSCount);
    System.out.println("  iOS:               " + iOSCount);
    System.out.println("  Macintosh:         " + macOSCount);
    System.out.println("  Cyanogen:          " + cyanogenOSCount);
    System.out.println("  Maemo:             " + maemoOSCount);
    System.out.println("  Other:             " + otherOSCount);
    System.out.println("Percent:");
    System.out.println("  Windows:           " + getWindowsTotalOSPercent());
    System.out.println("  *Nix:              " + getNixOSPercent());
    System.out.println("  Macintosh:         " + getMacOSPercent());
    System.out.println("  iOS:               " + getIOSPercent());
    System.out.println("  Other:             " + getMiscOSPercent());
    System.out.println("  Unknown:           " + getUnknownOSPercent());
    System.out.println("*******************************************");
    System.out.println("* Browsers                                *");
    System.out.println("*******************************************");
    System.out.println("WebKit:");
    System.out.println("  Safari:             " + safariCount);
    System.out.println("  Safari Mobile:      " + safariMobileCount);
    System.out.println("  Kindle:             " + kindleCount);
    System.out.println("  Chrome:             " + chromeCount);
    System.out.println("  Opera:              " + operaCount);
    System.out.println("  Opera Mini:         " + operaMiniCount);
    System.out.println("  Opera Coast:        " + operaCoastCount);
    System.out.println("  Puffin:             " + puffinCount);
    System.out.println("  Dolphin:            " + dolphinCount);
    System.out.println("  Konqueror:          " + konquerorCount);
    System.out.println("  Other:              " + otherWebKitCount);
    System.out.println("Trident:");
    System.out.println("  IE6:                " +  ie6Count);
    System.out.println("  IE7:                " +  ie7Count);
    System.out.println("  IE8:                " +  ie8Count);
    System.out.println("  IE9:                " +  ie9Count);
    System.out.println("  IE10:               " +  ie10Count);
    System.out.println("  IE11:               " +  ie11Count);
    System.out.println("  SiteKiosk:          " + siteKioskCount);
    System.out.println("  Other:              " + otherTridentCount);
    System.out.println("Gecko:");
    System.out.println("  Firefox:            " + firefoxCount);
    System.out.println("  SeaMonkey:          " + seaMonkeyCount);
    System.out.println("  Iceweasel:          " + iceweaselCount);
    System.out.println("  Pale Moon:          " + paleMoonCount);
    System.out.println("  TenFourFox:         " + tenFourFoxCount);
    System.out.println("  Waterfox:           " + waterfoxCount);
    System.out.println("  Cyberfox:           " + cyberfoxCount);
    System.out.println("  Icedragon:          " + icedragonCount);
    System.out.println("  Other:              " + otherGeckoCount);
    System.out.println("Other:");
    System.out.println("  Other:              " + miscBrowserCount);
    System.out.println("  Unknown:            " + unknownBrowserCount);
    System.out.println("Percent:");
    System.out.println("  Trident:            " + getTridentPercent());
    System.out.println("  Gecko:              " + getGeckoPercent());
    System.out.println("  WebKit:             " + getWebKitPercent());
    System.out.println("  Other:              " + getMiscBrowserPercent());
    System.out.println("  Unknown:            " + getUnknownBrowserPercent());
    System.out.println("*******************************************");
    System.out.println("* Devices                                 *");
    System.out.println("*******************************************");
    System.out.println("  Desktop:            " + desktopCount);
    System.out.println("  Tablet:             " + tabletCount);
    System.out.println("  Smartphone:         " + smartphoneCount);
    System.out.println("  Mobile:             " + mobileCount);
    System.out.println("  Other:              " + otherCount);
    System.out.println("  Unknown:            " + unknownDeviceCount);
    System.out.println("Percent:");
    System.out.println("  Desktop:            " + getDesktopPercent());
    System.out.println("  Tablet:             " + getTabletPercent());
    System.out.println("  Smartphone:         " + getSmartPhonePercent());
    System.out.println("  Mobile:             " + getMobilePercent());
    System.out.println("  Other:              " + getOtherDevicePercent());
    System.out.println("  Unknown:            " + getUnknownDevicePercent());
    System.out.println("");
  }
}
