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

import java.util.Arrays;
import java.util.Collection;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

/**
 *
 * @author Steve
 */
@RunWith(Parameterized.class)
public class UserAgentParserTest {
  private String testNum;
  private UserAgentParser uap;
  private String ua;
  private String os;
  private String osv;
  private String make;
  private String model;
  private String device;
  private String browser;
  private String bv;
  private String lang;
  private String country;
  
  public UserAgentParserTest(String testNum, String ua, String os, String osv, String make, String model, String device, String browser, String bv, String lang, String country) {
    this.testNum = testNum;
    this.ua = ua;
    this.os = os;
    this.osv = osv;
    this.make = make;
    this.model = model;
    this.device = device;
    this.browser = browser;
    this.bv = bv;
    this.lang = lang;
    this.country = country;
  }
  
  @Before
  public void setUp() {
    uap = new UserAgentParser();
  }
  
  @Parameterized.Parameters
  public static Collection uaStrings() {
    return Arrays.asList(new Object[][] {
      {"1", "Mozilla/5.0 (Windows NT 6.1; Trident/7.0; rv:11.0) like Gecko", "Windows", "7", "Unknown", "Unknown", "PC", "IE", "11", "None", "None"},
      {"2", "Mozilla/5.0 (Windows NT 6.3; Win64, x64; Trident/7.0; Touch; rv:11.0) like Gecko", "Windows", "8.1", "Unknown", "Unknown", "Tablet", "IE", "11", "None", "None"},
      {"3", "Mozilla/5.0 (Windows NT 6.3; WOW64; Trident/7.0; Touch; rv:11.0) like Gecko", "Windows", "8.1", "Unknown", "Unknown", "Tablet", "IE", "11", "None", "None"},
      {"4", "Mozilla/5.0 (Windows NT 6.1; WOW64; Trident/7.0; rv:11.0) like Gecko", "Windows", "7", "Unknown", "Unknown", "PC", "IE", "11", "None", "None"},
      {"5", "Mozilla/5.0 (Windows Phone 8.1; ARM; Trident/7.0; Touch; rv:11.0; IEMobile/11.0; NOKIA; Lumia 928) like Gecko", "Windows Phone", "8.1", "Unknown", "Lumia", "Smartphone", "IE", "11", "None", "None"},
      {"6", "Mozilla/5.0 (Windows Phone 8.1; ARM; Trident/7.0; Touch; rv:11.0; WebBrowser/8.1; IEMobile/11.0; NOKIA; Lumia 1520) like Gecko", "Windows Phone", "8.1", "Unknown", "Lumia", "Smartphone", "IE", "11", "None", "None"},
      {"7", "Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/39.0.2171.71 Safari/537.36 Edge/12.0", "Windows", "10.0", "Unknown", "Unknown", "PC", "Edge", "12.0", "None", "None"},
      {"8", "Mozilla/5.0 (compatible; MSIE 10.0; Windows NT 6.2; Trident/6.0; Touch)", "Windows", "8", "Unknown", "Unknown", "Tablet", "IE", "10", "None", "None"},
      {"9", "Mozilla/5.0 (compatible; MSIE 10.0; Windows NT 6.1; WOW64; Trident/6.0)", "Windows", "7", "Unknown", "Unknown", "PC", "IE", "10", "None", "None"},
      {"10", "Mozilla/5.0 (compatible; MSIE 10.0; Windows NT 6.1; Win64; x64; Trident/6.0)", "Windows", "7", "Unknown", "Unknown", "PC", "IE", "10", "None", "None"},
      {"11", "Mozilla/5.0 (compatible; MSIE 10.0; Windows NT 6.1; Win64; x64; Trident/6.0)", "Windows", "7", "Unknown", "Unknown", "PC", "IE", "10", "None", "None"},
      {"12", "Mozilla/5.0 (compatible; MSIE 10.0; Windows NT 6.2; Trident/6.0; ARM; Touch)", "Windows", "8", "Unknown", "Unknown", "Tablet", "IE", "10", "None", "None"},
      {"13", "Mozilla/5.0 (compatible; MSIE 10.0; Windows NT 6.2; Trident/6.0; Xbox; Xbox One)", "Windows", "8", "Unknown", "Unknown", "PC", "IE", "10", "None", "None"},
      {"14", "Mozilla/5.0 (compatible; MSIE 10.0; Windows NT 6.1; Tri0101 Firefox/33.0", "Windows", "7", "Unknown", "Unknown", "PC", "Firefox", "33.0", "None", "None"},
      {"15", "Mozilla/5.0 (compatible; MSIE 10.0; Windows Phone 8.0; Trident/6.0; IEMobile/10.0; ARM; Touch; SAMSUNG; SPH-I800; SPRINT)", "Windows Phone", "8.0", "Unknown", "Unknown", "Smartphone", "IE", "10", "None", "None"},
      {"16", "Mozilla/5.0 (compatible; MSIE 9.0; Windows NT 6.1; Trident/5.0)", "Windows", "7", "Unknown", "Unknown", "PC", "IE", "9", "None", "None"},
      {"17", "Mozilla/5.0 (compatible; MSIE 9.0; Windows NT 6.1; Trident/5.0; Xbox)", "Windows", "7", "Unknown", "Unknown", "PC", "IE", "9", "None", "None"},
      {"18", "Mozilla/5.0 (compatible; MSIE 9.0; AOL 9.7; AOLBuild 4343.55; Windows NT 6.2; WOW64; Trident/7.0)", "Windows", "8", "Unknown", "Unknown", "PC", "IE", "9", "None", "None"},
      {"19", "Mozilla/5.0 (compatible; MSIE 9.0; qdesk 2.4.1264.203; Windows NT 6.2; WOW64; Trident/6.0)", "Windows", "8", "Unknown", "Unknown", "PC", "IE", "9", "None", "None"},
      {"20", "Mozilla/5.0 (compatible; MSIE 9.0; Windows NT 6.3; WOW64; Trident/7.0; Touch; LCJB)", "Windows", "8.1", "Unknown", "Unknown", "Tablet", "IE", "9", "None", "None"},
      {"21", "Mozilla/4.0(compatible; MSIE 8.0; Windows NT 6.1; Trident/4.0; SLCC2; .NET CLR 2.0.50727)", "Windows", "7", "Unknown", "Unknown", "PC", "IE", "8", "None", "None"},
      {"22", "Mozilla/4.0 (compatible; MSIE 8.0; Windows NT 6.1; Trident/4.0; Tablet PC 2.0)", "Windows", "7", "Unknown", "Unknown", "Tablet", "IE", "8", "None", "None"},
      {"23", "Mozilla/4.0(compatible; MSIE 8.0; Windows NT 5.1; Trident/4.0; .NET CLR 1.0.3705; .NET CLR 1.1.4322; Media Center PC 4.0)", "Windows", "XP", "Unknown", "Unknown", "PC", "IE", "8", "None", "None"},
      {"24", "Mozilla/4.0 (compatible; MSIE 8.0; Windows NT 6.0; Win64; x64; Trident/4.0)", "Windows", "Vista", "Unknown", "Unknown", "PC", "IE", "8", "None", "None"},
      {"25", "Mozilla/4.0(compatible; MSIE 8.0; Windows NT 6.0; WOW64; Trident/4.0; SLCC1; .NET CLR 2.0.50727; .NET CLR 3.5.30729; .NET CLR 3.0.30729; MS-RTC LM 8; MS-RTC EA 2)", "Windows", "Vista", "Unknown", "Unknown", "PC", "IE", "8", "None", "None"},
      {"26", "Mozilla/4.0(compatible; MSIE 8.0; Windows NT 6.1; Win64; x64; Trident/4.0; .NET CLR 2.0.50727; SLCC2; .NET CLR 3.5.30729; .NET CLR 3.0.30729; .NET4.0C; .NET4.0E; InfoPath.3)", "Windows", "7", "Unknown", "Unknown", "PC", "IE", "8", "None", "None"},
      {"27", "Mozilla/4.0(compatible; MSIE 8.0; Windows NT 5.1; Trident/4.0; chromeframe/15.0.874.102; .NET CLR 2.0.50727; .NET CLR 3.0.4506.2152; .NET CLR 3.5.30729)", "Windows", "XP", "Unknown", "Unknown", "PC", "IE", "8", "None", "None"},
      {"28", "Mozilla/4.0(compatible; MSIE 8.0; Windows NT 6.1; Trident/4.0; SLCC2; .NET CLR 2.0.50727; .NET CLR 3.5.30729; .NET CLR 3.0.30729; Media Center PC 6.0; Tablet PC 2.0; InfoPath.1)", "Windows", "7", "Unknown", "Unknown", "Tablet", "IE", "8", "None", "None"},
      {"29", "Mozilla/4.0(compatible; MSIE 8.0; Windows NT 6.1; WOW64; Trident/4.0; SLCC2; .NET CLR 2.0.50727; .NET CLR 3.5.30729; .NET CLR 3.0.30729; Media Center PC 6.0; MDDC; .NET4.0C)",  "Windows", "7", "Unknown", "Unknown", "PC", "IE", "8", "None", "None"},
      {"30", "Mozilla/4.0 (compatible; MSIE 8.0; Windows NT 6.1; Win64; x64; Trident/4.0; .NET CLR 2.0.50727; SLCC2; .NET CLR 3.5.30729; .NET CLR 3.0.30729; Media Center PC 6.0; MDDC; Tablet PC 2.0)", "Windows", "7", "Unknown", "Unknown", "Tablet", "IE", "8", "None", "None"},
      {"31", "Mozilla/4.0 (compatible; MSIE 8.0; Windows NT 6.0; SLCC1; .NET CLR 2.0.50727; .NET CLR 3.0.04506; Tablet PC 2.0; InfoPath.2)", "Windows", "Vista", "Unknown", "Unknown", "Tablet", "IE", "8", "None", "None"},
      {"32", "Mozilla/4.0 (compatible; MSIE 8.0; Windows NT 5.1; Trident/4.0; Hotel; .NET CLR 1.1.4322; .NET CLR 1.0.3705; .NET CLR 2.0.50727; .NET CLR 3.0.04506.30; .NET CLR 3.0.04506.648; .NET CLR 3.0.4506.2152; .NET CLR 3.5.30729; Hotel; Hotel; SiteKiosk 7.7 Build 313)", "Windows", "XP", "Unknown", "Unknown", "PC", "SiteKiosk", "7.7", "None", "None"},
      {"33", "Mozilla/4.0 (compatible; MSIE 8.0; Windows NT 5.1; Trident/4.0; Comcast Install 1.0; .NET CLR 1.1.4322; .NET CLR 2.0.50727; .NET CLR 3.0.4506.2152; .NET CLR 3.5.30729)", "Windows", "XP", "Unknown", "Unknown", "PC", "IE", "8", "None", "None"},
      {"34", "Mozilla/4.0 (compatible; MSIE 8.0; Windows NT 5.1; Trident/4.0; East Hartford Public Schools; .NET CLR 2.0.50727; .NET CLR 3.0.04506.30; .NET CLR 1.1.4322; .NET CLR 3.0.4506.2152; .NET CLR 3.5.30729; .NET4.0C; .NET4.0E)", "Windows", "XP", "Unknown", "Unknown", "PC", "IE", "8", "None", "None"},
      {"35", "Mozilla/4.0 (compatible; MSIE 8.0; Windows NT 6.1; WOW64; Trident/4.0; chromeframe/17.0.963.56; SLCC2; .NET CLR 2.0.50727; .NET CLR 3.5.30729; .NET CLR 3.0.30729; Media Center PC 6.0; InfoPath.3; .NET4.0C; .NET4.0E)", "Windows", "7", "Unknown", "Unknown", "PC", "IE", "8", "None", "None"},
      {"36", "Mozilla/4.0(compatible; MSIE 7.0; Windows NT 6.0; WOW64; SLCC1; .NET CLR 2.0.50727; .NET CLR 3.0.04506)",  "Windows", "Vista", "Unknown", "Unknown", "PC", "IE", "7", "None", "None"},
      {"37", "Mozilla/4.0 (compatible; MSIE 7.0; Windows NT 5.1; winfx; .NET CLR 1.1.4322; .NET CLR 2.0.50727; Zune 2.0)",  "Windows", "XP", "Unknown", "Unknown", "PC", "IE", "7", "None", "None"},
      {"38", "Mozilla/4.0 (compatible; MSIE 7.0; Windows NT 6.0; Trident/5.0)", "Windows", "Vista", "Unknown", "Unknown", "PC", "IE", "7", "None", "None"},
      {"39", "Mozilla/4.0 (compatible; MSIE 7.0; Windows NT 5.1)", "Windows", "XP", "Unknown", "Unknown", "PC", "IE", "7", "None", "None"},
      {"40", "Mozilla/4.0(compatible; MSIE 7.0; Windows NT 6.1; Win64; x64; Trident/5.0; .NET CLR 2.0.50727; SLCC2; .NET CLR 3.5.30729; .NET CLR 3.0.30729; Media Center PC 6.0)", "Windows", "7", "Unknown", "Unknown", "PC", "IE", "7", "None", "None"},
      {"41", "Mozilla/4.0 (compatible; MSIE 7.0; Windows NT 6.0; SU 3.1; SLCC1; .NET CLR 2.0.50727; .NET CLR 3.0.04506; .NET CLR 1.1.4322; Tablet PC 2.0; .NET CLR 3.5.21022)", "Windows", "Vista", "Unknown", "Unknown", "Tablet", "IE", "7", "None", "None"},
      {"42", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1; SV1; InfoPath.1)", "Windows", "XP", "Unknown", "Unknown", "PC", "IE", "6", "None", "None"},
      {"43", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1; SV1; NeosBrowser; .NET CLR 1.1.4322; .NET CLR 2.0.50727)", "Windows", "XP", "Unknown", "Unknown", "PC", "IE", "6", "None", "None"},
      {"44", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1) Netscape/8.0.4", "Windows", "XP", "Unknown", "Unknown", "PC", "IE", "6", "None", "None"},
      {"45", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.2; Win64; AMD64)", "Windows", "XP", "Unknown", "Unknown", "PC", "IE", "6", "None", "None"},
      {"47", "Mozilla/5.0 (Windows Phone 8.1; ARM; Trident/7.0; Touch; rv:11; IEMobile/11.0; NOKIA; Lumia 928) like Gecko",  "Windows Phone", "8.1", "Unknown", "Lumia", "Smartphone", "Other", "Unknown", "None", "None"},
      {"48", "Mozilla/5.0 (compatible; MSIE 10.0; Windows Phone 8.0; Trident/6.0; IEMobile/10.0; ARM; Touch; rv:11; NOKIA; Lumia 920) like Gecko", "Windows Phone", "8.0", "Unknown", "Lumia", "Smartphone", "IE", "10", "None", "None"},
      {"49", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1; SV1; .NET CLR 2.0.50727; MAXTHON 2.0);", "Windows", "XP", "Unknown", "Unknown", "PC", "Maxthon", "2.0", "None", "None"},
      {"50", "Mozilla/4.0 (compatible; MSIE 5.23; Mac_PowerPC)", "Macintosh", "Unknown", "Unknown", "Unknown", "Unknown", "Other", "Unknown", "None", "None"},
      {"51", "Mozilla/4.0 (compatible; MSIE 7.0; Windows NT 5.1; {39CDB7E2-F3B1-8ED2-9BE7-3C9290A510DA}; Avant Browser; .NET CLR 1.1.4322)", "Windows", "XP", "Unknown", "Unknown", "PC", "IE", "7", "None", "None"},
      {"52", "Mozilla/5.0 (Mobile; Windows Phone 8.1; Android 4.0; ARM; Trident/7.0; Touch; rv:11.0; IEMobile/11.0; NOKIA; Lumia 929) like iPhone OS 7_0_3 Mac OS X AppleWebKit/537 (KHTML, like Gecko) Mobile Safari/537", "Windows Phone", "8.1", "Unknown", "Lumia", "Smartphone", "Mobile Safari", "537", "None", "None"},
      {"53", "Mozilla/5.0 (Windows NT 6.1; Trident/7.0; rv:11.0; SiteKiosk 7.8 Build 332)", "Windows", "7", "Unknown", "Unknown", "PC", "SiteKiosk", "7.8", "None", "None"},
      {"54", "Mozilla/5.0 (Windows NT 6.1; Trident/7.0; rv:11.0; SlimBrowser/6.01.101)", "Windows", "7", "Unknown", "Unknown", "PC", "SlimBrowser", "6.01.101", "None", "None"},
      {"55", "Mozilla/5.0 (Windows NT 6.1; Win64; x64; rv:33.0) Gecko/20100101 Firefox/33.0.2 Waterfox/33.0", "Windows", "7", "Unknown", "Unknown", "PC", "Waterfox", "33.0", "None", "None"},
      {"56", "Mozilla/5.0 (Windows NT 6.1; Win64; x64; rv:34.0) Gecko/20100101 Firefox/34.0 Cyberfox/34.0.5", "Windows", "7", "Unknown", "Unknown", "PC", "Cyberfox", "34.0.5", "None", "None"},
      {"57", "Mozilla/5.0 (Windows NT 6.1; WOW64; rv:26.0) Gecko/20100101 Firefox/26.0 IceDragon/26.0.0.2", "Windows", "7", "Unknown", "Unknown", "PC", "IceDragon", "26.0.0.2", "None", "None"},
      {"58", "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/535.7 (KHTML, like Gecko) RockMelt/0.16.91.483 Chrome/16.0.912.77 Safari/535.7", "Windows", "7", "Unknown", "Unknown", "PC", "RockMelt", "0.16.91.483", "None", "None"},
      {"59", "Mozilla/5.0 (Windows NT 6.3; Trident/7.0; rv:11.0; QQBrowser/8.0.3197.400) like Gecko", "Windows", "8.1", "Unknown", "Unknown", "PC", "QQBrowser", "8.0.3197.400", "None", "None"},
      {"60", "Mozilla/5.0 (Windows NT 6.2; WOW64) KHTML/4.11 Gecko/20130308 Firefox/23.0 (PaleMoon/20.3)", "Windows", "8", "Unknown", "Unknown", "PC", "PaleMoon", "20.3", "None", "None"},
      {"61", "Mozilla/5.0 (Windows NT 6.2; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/30.0.1599.101 Safari/537.36 Photon/4.0", "Windows", "8", "Unknown", "Unknown", "PC", "Photon", "4.0", "None", "None"},
      {"62", "Mozilla/5.0 (Windows NT 6.1) AppleWebKit/538.1 (KHTML, like Gecko) Chrome/18.0.1025.133 Safari/538.1 Midori/0.5", "Windows", "7", "Unknown", "Unknown", "PC", "Midori", "0.5", "None", "None"},
      {"63", "Mozilla/5.0 (Windows NT 6.3; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) WhiteHat Aviator/35.0.1916.114 Chrome/35.0.1916.114 Safari/537.36", "Windows", "8.1", "Unknown", "Unknown", "PC", "WhiteHat Aviator", "35.0.1916.114", "None", "None"},
      {"64", "Mozilla/5.0 (Windows; U; Windows NT 5.0; en-US; rv:1.4b) Gecko/20030516 Mozilla Firebird/0.6", "Windows", "2000", "Unknown", "Unknown", "PC", "Mozilla Firebird", "0.6", "en", "us"},
      {"65", "Mozilla/5.0 (Windows NT 6.3; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Fast_Browser/34.0.1848.0 Chrome/34.0.1848.0 Safari/537.36", "Windows", "8.1", "Unknown", "Unknown", "PC", "Fast_Browser", "34.0.1848.0", "None", "None"},
      {"66", "Mozilla/5.0 (Windows NT 6.3; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) coc_coc_browser/44.0 Chrome/38.0.2125.105 Safari/537.36", "Windows", "8.1", "Unknown", "Unknown", "PC", "coc_coc_browser", "44.0", "None", "None"},
      {"67", "Mozilla/5.0 (Windows NT 6.3; WOW64; Trident/7.0; Touch; USPortal; rv:11.0) like Gecko", "Windows", "8.1", "Unknown", "Unknown", "Tablet", "IE", "11", "None", "None"},
      {"68", "Mozilla/5.0 (Windows; U; Windows NT 6.1; en-US) AppleWebKit/534.7 (KHTML, like Gecko) Chrome/7.0.517.44 Safari/534.7 ZemanaAID/FFFF00A0", "Windows", "7", "Unknown", "Unknown", "PC", "Chrome", "7.0.517.44", "en", "us"},
      {"69", "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/20.0.1207.0 PlayFreeBrowser/4.0.3.7 Safari/537.36", "Windows", "7", "Unknown", "Unknown", "PC", "PlayFreeBrowser", "4.0.3.7", "None", "None"},
      {"70", "Mozilla/5.0 (Windows NT 6.2; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/36.0.1985.125 BoBrowser/36.0.1985.136 Safari/537.36", "Windows", "8", "Unknown", "Unknown", "PC", "BoBrowser", "36.0.1985.136", "None", "None"},
      {"71", "Mozilla/5.0 (Linux; U; Android 4.2.2; en-us; SD4930UR Build/JDQ39) AppleWebKit/537.36 (KHTML, like Gecko) Silk/3.41 like Chrome/37.0.2026.117 Mobile Safari/537.36", "Android", "4.2.2", "Kindle", "Fire Phone", "Smartphone", "Silk", "3.41", "en", "us"},
      {"72", "Mozilla/5.0 (Linux; U; Android 2.3.4; en-us; Kindle Fire Build/GINGERBREAD) AppleWebKit/533.1 (KHTML, like Gecko) Version/4.0 Mobile Safari/533.1", "Android", "2.3.4", "Kindle", "Kindle Fire", "Tablet", "Mobile Safari", "533.1", "en", "us"},
      {"73", "Mozilla/5.0 (Linux; U; Android 4.0.3; en-us; KFOT Build/IML74K) AppleWebKit/537.36 (KHTML, like Gecko) Silk/3.44 like Chrome/37.0.2026.117 Safari/537.36", "Android", "4.0.3", "Kindle", "Kindle Fire", "Tablet", "Silk", "3.44", "en", "us"},
      {"74", "Mozilla/5.0 (Linux; U; Android 4.4.3; en-us; KFTT Build/IML74K) AppleWebKit/535.19 (KHTML, like Gecko) Silk/3.4 like Safari/535.19 Silk-Accelerated=true", "Android", "4.4.3", "Kindle", "Kindle Fire HD", "Tablet", "Silk", "3.4", "en", "us"},
      {"75", "Mozilla/5.0 (Linux; U; en-us; KFJWI Build/IMM76D) AppleWebKit/535.19 (KHTML, like Gecko) Silk/3.21 like Safari/535.19 Silk-Accelerated=true", "Linux", "Unknown", "Kindle", "Kindle Fire HD", "Tablet", "Silk", "3.21", "en", "us"},
      {"76", "Mozilla/5.0 (Linux; U; Android 4.2.2; en-gb; KFSOWI Build/JDQ39) AppleWebKit/537.36 (KHTML, like Gecko) Silk/3.23 like Chrome/34.0.1847.137 Safari/537.36", "Android", "4.2.2", "Kindle", "Kindle Fire HD", "Tablet", "Silk", "3.23", "en", "gb"},
      {"77", "Mozilla/5.0 (Linux; U; Android 4.0.4; en-us; KFJWA Build/IMM76D) AppleWebKit/534.30 (KHTML, like Gecko) Version/4.0 Safari/534.30 UCBrowser/2.4.2.348", "Android", "4.0.4", "Kindle", "Kindle Fire HD", "Tablet", "UCBrowser", "2.4.2.348", "en", "us"},
      {"78", "Mozilla/5.0 (Linux; U; Android 4.4.3; en-us; KFASWI Build/KTU84M) AppleWebKit/537.36 (KHTML, like Gecko) Silk/3.46 like Chrome/37.0.2026.117 Safari/537.36", "Android", "4.4.3", "Kindle", "Fire HD", "Tablet", "Silk", "3.46", "en", "us"},
      {"79", "Mozilla/5.0 (Linux; U; Android 4.2.2; en-us; KFTHWI Build/JDQ39) AppleWebKit/534.30 (KHTML, like Gecko) Version/4.0 Safari/534.30", "Android", "4.2.2", "Kindle", "Kindle Fire HDX", "Tablet", "Safari", "534.30", "en", "us"},
      {"80", "Mozilla/5.0 (Linux; U; Android 4.2.2; en-us; KFTHWA Build/JDQ39) AppleWebKit/534.30 (KHTML, like Gecko) Version/4.0 Safari/534.30", "Android", "4.2.2", "Kindle", "Kindle Fire HDX", "Tablet", "Safari", "534.30", "en", "us"},
      {"81", "Mozilla/5.0 (Linux; U; en-us; KFAPWI Build/JDQ39) AppleWebKit/535.19 (KHTML, like Gecko) Silk/3.13 Safari/535.19 Silk-Accelerated=true", "Linux", "Unknown", "Kindle", "Kindle Fire HDX", "Tablet", "Silk", "3.13", "en", "us"},
      {"82", "Mozilla/5.0 (Linux; U; Android 4.4; en-us; KFSAWI Build/KTU84M) AppleWebKit/537.36 (KHTML, like Gecko) Silk/3.40 like Chrome/37.0.2026.117 Safari/537.36", "Android", "4.4", "Kindle", "Fire HDX", "Tablet", "Silk", "3.40", "en", "us"},
      {"", "Mozilla/5.0 (Linux; Android 4.4.3; en-us; KFSAWA Build/KTU84M) AppleWebKit/537.36 (KHTML, like Gecko) Version/4.0 Chrome/34.0.0.0 Safari/537.36", "Android", "4.4.3", "Kindle", "Fire HDX", "Tablet", "Chrome", "34.0.0.0", "en", "us"},
      {"83", "Mozilla/5.0 (Linux; U; en-us; KFAPWA Build/JDQ39) AppleWebKit/535.19 (KHTML, like Gecko) Silk/3.8 Safari/535.19 Silk-Accelerated=true", "Linux", "Unknown", "Kindle", "Kindle Fire HDX", "Tablet", "Silk", "3.8", "en", "us"},
      {"84", "Mozilla/5.0 (Linux; U; Android 2.3.4; en-us; Silk/1.0.143.1-Gen4_11004910) AppleWebKit/533.1 (KHTML, like Gecko) Version/4.0 Mobile Safari/533.1 Silk-Accelerated=true", "Android", "2.3.4", "Unknown", "Unknown", "Unknown", "Silk", "1.0.143.1", "en", "us"},
      {"85", "Mozilla/5.0 (X11; U; Linux armv7l like Android; en-us) AppleWebKit/531.2+ (KHTML, like Gecko) Version/5.0 Safari/533.2+ Kindle/3.0+", "Linux", "Unknown", "Unknown", "Unknown", "Unknown", "Safari", "533.2", "en", "us"},
      {"86", "Mozilla/5.0 (Macintosh; U; Intel Mac OS X 10_6_3; en-us; Silk/1.0.143.1-Gen4_11004910) AppleWebKit/533.16 (KHTML, like Gecko) Version/5.0 Safari/533.16 Silk-Accelerated=false", "Macintosh", "Unknown", "Unknown", "Unknown", "Unknown", "Silk", "1.0.143.1", "en", "us"},
      {"87", "Mozilla/5.0 (Linux; U; Android 2.2.2; ja-jp; 001DL Build/FRG83G) AppleWebKit/533.1 (KHTML, like Gecko) Version/4.0 Mobile Safari/533.1", "Android", "2.2.2", "Dell", "Streak", "Smartphone", "Mobile Safari", "533.1", "ja", "jp"},
      {"88", "Mozilla/5.0 (Linux; U; Android 2.3.3; ja-jp; 001HT Build/GRI40) AppleWebKit/533.1 (KHTML, like Gecko) Version/4.0 Mobile Safari/533.1", "Android", "2.3.3", "HTC", "Desire", "Smartphone", "Mobile Safari", "533.1", "ja", "jp"},
      {"89", "Mozilla/5.0 (Linux; U; Android 2.3.4; ja-jp; 009Z Build/GINGERBREAD) AppleWebKit/533.1 (KHTML, like Gecko) Version/4.0 Mobile Safari/533.1", "Android", "2.3.4", "ZTE", "Star", "Smartphone", "Mobile Safari", "533.1", "ja", "jp"},
      {"90", "Mozilla/5.0 (Linux; U; Android 2.3.5; ja-jp; 101P Build/GRJ90) AppleWebKit/533.1 (KHTML, like Gecko) Version/4.0 Mobile Safari/533.1", "Android", "2.3.5", "Panasonic", "Lumix", "Smartphone", "Mobile Safari", "533.1", "ja", "jp"},
      {"91", "Mozilla/5.0 (Linux; U; Android 2.3.4; ja-jp; A1_07 Build/GRJ22) AppleWebKit/533.1 (KHTML, like Gecko) Version/4.0 Mobile Safari/533.1", "Android", "2.3.4", "Lenovo", "IdeaTab", "Tablet", "Mobile Safari", "533.1", "ja", "jp"},
      {"92", "Mozilla/5.0 (Linux; U; Android 3.2.1; es-es; A01SH Build/HTK55D) AppleWebKit/533.1 (KHTML, like Gecko) Version/4.0 Safari/533.1", "Android", "3.2.1", "Sharp", "Galapagos", "Tablet", "Safari", "533.1", "es", "es"},
      {"93", "Mozilla/5.0 (Linux; U; Android 3.0.1; ja-jp; A500 Build/HRI66) AppleWebKit/534.13 (KHTML, like Gecko) Version/4.0 Safari/534.13", "Android", "3.0.1", "Acer", "Iconia", "Tablet", "Safari", "534.13", "ja", "jp"},
      {"94", "Mozilla/5.0 (Linux; U; Android 4.0.4; ja-jp; A700 Build/IMM76D) AppleWebKit/534.30 (KHTML, like Gecko) Version/4.0 Safari/534.30", "Android", "4.0.4", "Acer", "Iconia", "Tablet", "Safari", "534.30", "ja", "jp"},
      {"95", "Mozilla/5.0 (Linux; U; Android 4.0.4; en-us; AT100 Build/IMM76D) AppleWebKit/534.30 (KHTML, like Gecko) Version/4.0 Safari/534.30", "Android", "4.0.4", "Toshiba", "Excite", "Tablet", "Safari", "534.30", "en", "us"},
      {"96", "Mozilla/5.0 (Linux; U; Android 4.1.1; zh-tw; Amazon Kindle Fire Build/JRO03L; CyanogenMod-cmot20120817 cobe123) AppleWebKit/534.30 (KHTML, like Gecko) Version/4.0 Mobile Safari/534.30", "Android", "4.1.1", "Kindle", "Kindle Fire", "Tablet", "Mobile Safari", "534.30", "zh", "tw"},
      {"97", "Mozilla/5.0 (Linux; U; Android 4.0.1; ja-jp; Galaxy Nexus Build/ITL41D) AppleWebKit/534.30 (KHTML, like Gecko) Version/4.0 Mobile Safari/534.30", "Android", "4.0.1", "Samsung", "Galaxy Nexus", "Smartphone", "Mobile Safari", "534.30", "ja", "jp"},
      {"98", "Mozilla/5.0 (Linux; U; Android 4.0.2; ja-jp; Galaxy Nexus Build/ICL53F) AppleWebKit/534.30 (KHTML, like Gecko) Version/4.0 Mobile Safari/534.30", "Android", "4.0.2", "Samsung", "Galaxy Nexus", "Smartphone", "Mobile Safari", "534.30", "ja", "jp"},
      {"99", "Mozilla/5.0 (Linux; Android 4.4.4; Nexus 7 Build/KTU84P) AppleWebKit/537.36 (KHTML, like Gecko) Version/4.0 Chrome/32.0.1700.99 Safari/537.36", "Android", "4.4.4", "Asus", "Nexus 7", "Tablet", "Chrome", "32.0.1700.99", "None", "None"},
      {"100", "Mozilla/5.0 (Android; Mobile; rv:36.0) Gecko/36.0 Firefox/36.0", "Android", "Unknown", "Unknown", "Unknown", "Smartphone", "Firefox", "36.0", "None", "None"},
      {"101", "Mozilla/5.0 (Android; Tablet; rv:35.0) Gecko/35.0 Firefox/35.0", "Android", "Unknown", "Unknown", "Unknown", "Tablet", "Firefox", "35.0", "None", "None"},
      {"102", "Mozilla/5.0 (Linux; U;Android 4.4.2; LGLS990 Build/KVT49L.LS990ZV6) AppleWebKit/537.36 (KHTML, like Gecko) Version/4.0 Chrome/34.0.1847.118 Mobile Safari/537.36", "Android", "4.4.2", "LG", "G3", "Smartphone", "Chrome", "34.0.1847.118", "None", "None"},
      {"103", "Mozilla/5.0 (Linux; Android 4.1.2; Nokia_XL Build/JZO54K) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/30.0.1599.82 Mobile Safari/537.36 NokiaBrowser/1.0.1.54", "Android", "4.1.2", "Nokia", "XL", "Smartphone", "NokiaBrowser", "1.0.1.54", "None", "None"},
      {"104", "Mozilla/5.0 (Linux; Android 4.4.2; LG-D800 Build/KOT49I.F410S10f) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/40.0.2214.89 Mobile Safari/537.36 OPR/27.0.1698.89115", "Android", "4.4.2", "LG", "G2", "Smartphone", "Opera", "27.0.1698.89115", "None", "None"},
      {"105", "Mozilla/5.0 (Linux; Android 5.0.1; Nexus 5 Build/LRX22C) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/40.0.2214.89 Mobile Safari/537.36 OPR/27.0.1698.89115", "Android", "5.0.1", "LG", "Nexus 5", "Smartphone", "Opera", "27.0.1698.89115", "None", "None"},
      {"106", "Mozilla/5.0 (Linux; U; Android 4.1.2; en-us; LGMS769 Build/JZO54K) AppleWebKit/534.30 (KHTML, like Gecko) Version/4.0 Mobile Safari/534.30/TansoDL", "Android", "4.1.2", "LG", "Optimus", "Smartphone", "Mobile Safari", "534.30", "en", "us"},
      {"107", "Mozilla/5.0 (Linux; Android 4.4.2; SCH-I435 Build/KOT49H) AppleWebKit/537.36 (KHTML, like Gecko) Version/4.0 Chrome/30.0.0.0 Mobile Safari/537.36 homerun/4.2.5", "Android", "4.4.2", "Samsung", "Galaxy S4 Mini", "Smartphone", "Chrome", "30.0.0.0", "None", "None"},
      {"108", "Mozilla/5.0 (Linux; U; Android 4.0.4; en-US; ADR6410LVW Build/IMM76D) AppleWebKit/534.30 (KHTML, like Gecko) Version/4.0 UCBrowser/10.0.1.512 U3/0.8.0 Mobile Safari/534.30", "Android", "4.0.4", "HTC", "Droid Incredible", "Smartphone", "UCBrowser", "10.0.1.512", "en", "us"},
      {"109", "Dalvik/1.2.0 (Linux; U; Android 2.2.2; 001DL Build/FRG83G)", "Android", "2.2.2", "Dell", "Streak", "Smartphone", "Dalvik", "1.2.0", "None", "None"},
      {"110", "Dalvik/1.4.0 (Linux; U; Android 2.3.3; 001HT Build/GRI40)", "Android", "2.3.3", "HTC", "Desire", "Smartphone", "Dalvik", "1.4.0", "None", "None"},
      {"111", "Dalvik/1.4.0 (Linux; U; Android 2.3.4; 009Z Build/GINGERBREAD)", "Android", "2.3.4", "ZTE", "Star", "Smartphone", "Dalvik", "1.4.0", "None", "None"},
      {"112", "Dalvik/1.6.0 (Linux; U; Android 4.1.1; Amazon Kindle Fire Build/JRO03L)", "Android", "4.1.1", "Kindle", "Kindle Fire", "Tablet", "Dalvik", "1.6.0", "None", "None"},
      {"113", "Dalvik/1.6.0 (Linux; U; Android 4.4.4; XT1030 Build/SU6-7)", "Android", "4.4.4", "Motorola", "Droid Mini", "Smartphone", "Dalvik", "1.6.0", "None", "None"},
      {"114", "Dalvik/1.6.0 (Linux; U; Android 4.4.2; LGMS323 Build/KOT49I.MS32310c)", "Android", "4.4.2", "LG", "Optimus", "Smartphone", "Dalvik", "1.6.0", "None", "None"},
      {"115", "Dalvik/1.6.0 (Linux; U; Android 4.3; SAMSUNG-SGH-I747 Build/JSS15J)", "Android", "4.3", "Samsung", "Galaxy S3", "Smartphone", "Dalvik", "1.6.0", "None", "None"},
      {"116", "Dalvik/2.1.0 (Linux; U; Android 5.0.1; Nexus 4 Build/LRX22C)", "Android", "5.0.1", "LG", "Nexus 4", "Smartphone", "Dalvik", "2.1.0", "None", "None"},
      {"117", "Opera/9.80 (Windows NT 5.1; Edition United States Local) Presto/2.12.388 Version/12.17", "Windows", "XP", "Unknown", "Unknown", "Unknown", "Opera", "12.17", "None", "None"},
      {"118", "Opera/9.80 (Android; Opera Mini/7.6.40234/35.7108; U; en) Presto/2.8.119 Version/11.10", "Android", "Unknown", "Unknown", "Unknown", "Unknown", "Opera Mini", "7.6.40234", "en", "None"},
      {"119", "Opera/9.80 (Android 4.0.4; Linux; Opera Mobi/ADR-1309251116) Presto/2.11.355 Version/12.10", "Android", "4.0.4", "Unknown", "Unknown", "Mobile", "Opera", "12.10", "None", "None"},
      {"120", "Opera/9.80 (Macintosh; Intel Mac OS X 10.6.8) Presto/2.12.388 Version/12.16", "Macintosh", "10.6.8", "Unknown", "Unknown", "Unknown", "Opera", "12.16", "None", "None"},
      {"121", "Opera/9.80 (SpreadTrum; Opera Mini/4.4.31492/35.7598; U; en) Presto/2.8.119 Version/11.10", "Unknown", "Unknown", "Unknown", "Unknown", "Mobile", "Opera Mini", "4.4.31492", "en", "None"},
      {"122", "Opera/9.26 (Macintosh; Intel Mac OS X; U; en)", "Macintosh", "Unknown", "Unknown", "Unknown", "Unknown", "Opera", "Unknown", "en", "None"},
      {"123", "Opera/9.80 (X11; Linux zbov) Presto/2.11.355 Version/12.10", "Linux", "Unknown", "Unknown", "Unknown", "Unknown", "Opera", "12.10", "None", "None"},
      {"124", "Mozilla/5.0 (X11; ) AppleWebKit/534.24 (KHTML, like Gecko) Chrome/11.0.696.34 Safari/534.24", "Linux", "Unknown", "Unknown", "Unknown", "Unknown", "Chrome", "11.0.696.34", "None", "None"},
      {"125", "Mozilla/5.0 (X11; Linux armv7l) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/40.0.2214.115 Safari/537.36", "Linux", "Unknown", "Unknown", "Unknown", "Unknown", "Chrome", "40.0.2214.115", "None", "None"},
      {"126", "Mozilla/5.0 (X11; Ubuntu; Linux i686; rv:33.0) Gecko/20100101 Firefox/33.0", "Linux", "Unknown", "Unknown", "Unknown", "PC", "Firefox", "33.0", "None", "None"},
      {"127", "Mozilla/5.0 (X11; Linux i686; rv:14.0) Gecko/20100101 Firefox/14.0.1", "Linux", "Unknown", "Unknown", "Unknown", "PC", "Firefox", "14.0.1", "None", "None"},
      {"128", "Mozilla/5.0 (X11; Linux i686) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/39.0.2171.95 Safari/537.36", "Linux", "Unknown", "Unknown", "Unknown", "Unknown", "Chrome", "39.0.2171.95", "None", "None"},
      {"129", "Mozilla/5.0 (X11; Linux i686 (x86_64)) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/40.0.2214.115 Safari/537.36", "Linux", "Unknown", "Unknown", "Unknown", "Unknown", "Chrome", "40.0.2214.115", "None", "None"},
      {"130", "Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/534.24 (KHTML, like Gecko) Chrome/11.0.696.34 Safari/534.24", "Linux", "Unknown", "Unknown", "Unknown", "Unknown", "Chrome", "11.0.696.34", "None", "None"},
      {"131", "Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 (KHTML, like Gecko) Ubuntu Chromium/40.0.2214.111 Chrome/40.0.2214.111 Safari/537.36", "Linux", "Unknown", "Unknown", "Unknown", "Unknown", "Chromium", "40.0.2214.111", "None", "None"},
      {"132", "Mozilla/5.0 (X11; Ubuntu; Linux x86_64; rv:36.0) Gecko/20100101 Firefox/36.0", "Linux", "Unknown", "Unknown", "Unknown", "PC", "Firefox", "36.0", "None", "None"},
      {"133", "Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 (KHTML, like Gecko) Ubuntu Chromium/34.0.1847.116 Chrome/34.0.1847.116 Safari/537.36", "Linux", "Unknown", "Unknown", "Unknown", "Unknown", "Chromium", "34.0.1847.116", "None", "None"},
      {"134", "Mozilla/5.0 (X11; Linux x86_64; HTCONE RoboForm-A/4.2.1) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/39.0.2171.93 Safari/537.36", "Linux", "Unknown", "Unknown", "Unknown", "Unknown", "Chrome", "39.0.2171.93", "None", "None"},
      {"135", "Mozilla/5.0 (X11; Linux x86_64; rv:31.0) Gecko/20100101 Firefox/31.0 Iceweasel/31.2.0", "Linux", "Unknown", "Unknown", "Unknown", "PC", "Iceweasel", "31.2.0", "None", "None"},
      {"136", "Mozilla/5.0 (X11; Linux i686; rv:27.0) Gecko/20100101 Firefox/27.0 Iceweasel/27.0 Jumpshot/2.2", "Linux", "Unknown", "Unknown", "Unknown", "PC", "Iceweasel", "27.0", "None", "None"},
      {"137", "Mozilla/5.0 (X11; Linux x86_64; rv:10.0) Gecko/20100101 Firefox/10.0 (Chrome)", "Linux", "Unknown", "Unknown", "Unknown", "PC", "Firefox", "10.0", "None", "None"},
      {"138", "Mozilla/5.0 (X11; Linux x86_64; U; en-us) AppleWebKit/537.36 (KHTML, like Gecko) Silk/3.46 like Chrome/37.0.2026.117 Safari/537.36", "Linux", "Unknown", "Unknown", "Unknown", "Unknown", "Silk", "3.46", "en", "us"},
      {"139", "Mozilla/5.0 (X11; Linux x86_64; rv:12.0) Gecko/20120501 Firefox/12.0 SeaMonkey/2.9.1 Lightning/1.4", "Linux", "Unknown", "Unknown", "Unknown", "Unknown", "SeaMonkey", "2.9.1", "None", "None"},
      {"140", "Mozilla/5.0 (Linux; U; Android 4.4.2; en-us; HTCONE Build/KOT49H) AppleWebKit/534.30 (KHTML, like Gecko) Version/4.0 Mobile Safari/534.30", "Android", "4.4.2", "HTC", "One", "Smartphone", "Mobile Safari", "534.30", "en", "us"},
      {"141", "Mozilla/5.0 (X11; Linux x86_64; Ubuntu 12.04.5 LTS) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/33.0.1750.0 Maxthon/1.0.3.10 Safari/537.36", "Linux", "Unknown", "Unknown", "Unknown", "Unknown", "Maxthon", "1.0.3.10", "None", "None"},
      {"142", "Mozilla/5.0 (Linux; U; Android 4.1.1; en-us; HTC One X Build/JRO03C) AppleWebKit/534.30 (KHTML, like Gecko) Version/4.0 Mobile Safari/534.30 MxBrowser/4.3.1.2000", "Android", "4.1.1", "HTC", "One X", "Smartphone", "Maxthon", "4.3.1.2000", "en", "us"},
      {"143", "Mozilla/5.0 (X11; Linux i686) AppleWebKit/538.1 (KHTML, like Gecko) qutebrowser/0.0.0 Safari/538.1", "Linux", "Unknown", "Unknown", "Unknown", "Unknown", "qutebrowser", "0.0.0", "None", "None"},
      {"144", "Mozilla/5.0 (Linux; Ubuntu 14.04) AppleWebKit/537.36 Chromium/35.0.1870.2 Safari/537.36", "Linux", "Unknown", "Unknown", "Unknown", "Unknown", "Chromium", "35.0.1870.2", "None", "None"},
      {"145", "Mozilla/5.0 (DirectFB; Linux; ko-KR) AppleWebKit/534.26+ (KHTML, like Gecko) Version/5.0 Safari/534.26+", "Linux", "Unknown", "Unknown", "Unknown", "Unknown", "Safari", "534.26", "ko", "kr"},
      {"146", "Mozilla/5.0 (X11; Linux) AppleWebKit/535.22 (KHTML, like Gecko) Chrome/18.0.1025.133 Safari/535.22 Midori/0.5", "Linux", "Unknown", "Unknown", "Unknown", "Unknown", "Midori", "0.5", "None", "None"},
      {"147", "Mozilla/5.0 (Linux x86_64) AppleWebKit/537.6+ (KHTML, like Gecko) WebKitGTK+/1.10.2 luakit/0d5f4", "Linux", "Unknown", "Unknown", "Unknown", "Unknown", "LuaKit", "0d5f4", "None", "None"},
      {"148", "Mozilla/5.0 (Linux x86_64) AppleWebKit/538.15+ (KHTML, like Gecko) WebKitGTK+/2.4.2 luakit/2012.09.13", "Linux", "Unknown", "Unknown", "Unknown", "Unknown", "LuaKit", "2012.09.13", "None", "None"},
      {"149", "Mozilla/5.0 (Linux x86_64) AppleWebKit/535.4+ (KHTML, like Gecko) WebKitGTK+/1.6.1 luakit", "Linux", "Unknown", "Unknown", "Unknown", "Unknown", "LuaKit", "Unknown", "None", "None"},
      {"150", "Mozilla/5.0 (QtEmbedded; Linux; en-US) AppleWebKit/537.4 (KHTML, like Gecko) Qt/4.8.3 Safari/534.34", "Linux", "Unknown", "Unknown", "Unknown", "Unknown", "Qt", "4.8.3", "en", "us"},
      {"151", "Mozilla/5.0 (X11; Linux i686) AppleWebKit/534.34 (KHTML, like Gecko) Qt/4.8.0 Safari/534.34 AutoZone/1.0 (Znet)", "Linux", "Unknown", "Unknown", "Unknown", "Unknown", "Qt", "4.8.0", "None", "None"},
      {"152", "Mozilla/5.0 (X11; Linux i686) AppleWebKit/537.21 (KHTML, like Gecko) QupZilla/1.4.1 Safari/537.21", "Linux", "Unknown", "Unknown", "Unknown", "Unknown", "QupZilla", "1.4.1", "None", "None"},
      {"153", "Mozilla/5.0 (X11; U; Linux x86_64; en-us) AppleWebKit/537.36 (KHTML, like Gecko)  Chrome/30.0.1599.114 Safari/537.36 Puffin/4.0.4.931AP", "Android", "Unknown", "Unknown", "Unknown", "Smartphone", "Puffin", "4.0.4.931", "en", "us"},
      {"154", "Mozilla/5.0 (X11; U; Linux x86_64; en-US) AppleWebKit/537.36 (KHTML, like Gecko)  Chrome/30.0.1599.114 Safari/537.36 Puffin/4.1.2IT", "iOS", "Unknown", "Unknown", "Unknown", "Tablet", "Puffin", "4.1.2", "en", "us"},
      {"155", "Mozilla/5.0 (X11; U; Linux x86_64; en-US) AppleWebKit/537.36 (KHTML, like Gecko)  Chrome/30.0.1599.114 Safari/537.36 Puffin/4.1.2IP", "iOS", "Unknown", "Unknown", "Unknown", "Smartphone", "Puffin", "4.1.2", "en", "us"},
      {"156", "Mozilla/5.0 (X11; U; Linux x86_64; en-us) AppleWebKit/537.36 (KHTML, like Gecko)  Chrome/30.0.1599.114 Safari/537.36 Puffin/4.0.4.931AT", "Android", "Unknown", "Unknown", "Unknown", "Tablet", "Puffin", "4.0.4.931", "en", "us"},
      {"157", "Mozilla/5.0 (X11; U; Linux i686; en-gb) AppleWebKit/534.35 (KHTML, like Gecko)  Chrome/11.0.696.65 Safari/534.35 Puffin/2.0.5603M", "Linux", "Unknown", "Unknown", "Unknown", "Mobile", "Puffin", "2.0.5603", "en", "gb"},
      {"158", "Mozilla/5.0 (X11; U; Linux i686; en-gb) AppleWebKit/534.35 (KHTML, like Gecko)  Chrome/11.0.696.65 Safari/534.35 Puffin/2.0.5603", "Linux", "Unknown", "Unknown", "Unknown", "Unknown", "Puffin", "2.0.5603", "en", "gb"},
      {"159", "Mozilla/5.0 (compatible; Konqueror/3.1; Linux 2.4.22-10mdk; X11; i686; fr, fr_FR)", "Linux", "Unknown", "Unknown", "Unknown", "Unknown", "Konqueror", "3.1", "fr", "fr"},
      {"160", "Mozilla/5.0 (X11; Linux x86_64) KHTML/4.14.3 (like Gecko) Konqueror/4.14", "Linux", "Unknown", "Unknown", "Unknown", "Unknown", "Konqueror", "4.14", "None", "None"},
      {"161", "Mozilla/5.0 (Macintosh; ARM Mac OS X) AppleWebKit/538.15 (KHTML, like Gecko) Safari/538.15 Version/6.0 Debian/7.8 (3.8.2.0-0rpi18rpi1) Epiphany/3.8.2", "Macintosh", "Unknown", "Unknown", "Unknown", "Unknown", "Epiphany", "3.8.2", "None", "None"},
      {"162", "Mozilla/5.0 (Macintosh; Intel Mac OS X 10.10; rv:37.0) Gecko/20100101 Firefox/37.0", "Macintosh", "Unknown", "Unknown", "Unknown", "PC", "Firefox", "37.0", "None", "None"},
      {"163", "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_10) AppleWebKit/537.16 (KHTML, like Gecko) Version/8.0 Safari/537.16", "Macintosh", "Unknown", "Unknown", "Unknown", "Unknown", "Safari", "537.16", "None", "None"},
      {"164", "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_10) AppleWebKit/600.1.25 (KHTML, like Gecko)", "Macintosh", "Unknown", "Unknown", "Unknown", "Unknown", "Other", "Unknown", "None", "None"},
      {"165", "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_10_0) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/31.0.1650.63 Safari/537.36", "Macintosh", "Unknown", "Unknown", "Unknown", "Unknown", "Chrome", "31.0.1650.63", "None", "None"},
      {"166", "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_10_1) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/39.0.2171.95 Safari/537.36 OPR/26.0.1656.60", "Macintosh", "Unknown", "Unknown", "Unknown", "Unknown", "Opera", "26.0.1656.60", "None", "None"},
      {"167", "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_7_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/40.0.2214.94 Safari/537.36", "Macintosh", "Unknown", "Unknown", "Unknown", "Unknown", "Chrome", "40.0.2214.94", "None", "None"},
      {"168", "Mozilla/5.0 (Macintosh; Intel Mac OS X) AppleWebKit/538.1 (KHTML, like Gecko) qutebrowser/0.1.2 Safari/538.1", "Macintosh", "Unknown", "Unknown", "Unknown", "Unknown", "qutebrowser", "0.1.2", "None", "None"},
      {"169", "Mozilla/5.0 (Macintosh; PPC Mac OS X 10.4; rv:31.0) Gecko/20100101 Firefox/31.0 TenFourFox/7450", "Macintosh", "Unknown", "Unknown", "Unknown", "PC", "TenFourFox", "7450", "None", "None"},
      {"170", "Mozilla/5.0 (Macintosh; PPC Mac OS X 10.4; rv:17.0) Gecko/20131113 Firefox/17.0 TenFourFox/G5", "Macintosh", "Unknown", "Unknown", "Unknown", "Unknown", "TenFourFox", "G5", "None", "None"},
      {"171", "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_8_5) AppleWebKit/536.30.1 (KHTML, like Gecko) Maxthon/4.4.0", "Macintosh", "Unknown", "Unknown", "Unknown", "Unknown", "Maxthon", "4.4.0", "None", "None"},
      {"172", "Mozilla/5.0 (Macintosh; Intel Ma2; SAMSUNG-SM-G870A Build/KOT49H) AppleWebKit/537.36 (KHTML, like Gecko) Version/4.0 Chrome/30.0.0.0 Mobile Safari/537.36", "Macintosh", "Unknown", "Samsung", "Galaxy S5 Active", "Smartphone", "Chrome", "30.0.0.0", "None", "None"},
      {"173", "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_6_8) AppleWebKit/534.59.10 (KHTML, like Gecko) Version/5.1 Safari/6534.59.10 Sleipnir/4.5.1", "Macintosh", "Unknown", "Unknown", "Unknown", "Unknown", "Sleipnir", "4.5.1", "None", "None"},
      {"174", "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_9_2) AppleWebKit/537.51.2 (KHTML, like Gecko) Version/7.0.3 Safari/537.75.14 OPiOS/8.0.3.82195", "iOS", "Unknown", "Unknown", "Unknown", "Unknown", "Safari", "537.75.14", "None", "None"},
      {"175", "Mozilla/5.0 (Macintosh; Intel Mac OS X 10.8; rv:32.0) Gecko/20100101 Firefox/32.0 SeaMonkey/2.29.1", "Macintosh", "Unknown", "Unknown", "Unknown", "PC", "SeaMonkey", "2.29.1", "None", "None"},
      {"176", "Mozilla/5.0 (Macintosh; U; Intel Mac OS X 10_7_5; en-US) AppleWebKit/533.21.1+(KHTML, like Gecko, Safari/533.19.4) Version/5.11 OmniWeb/622.16.0", "Macintosh", "Unknown", "Unknown", "Unknown", "Unknown", "OmniWeb", "622.16.0", "en", "us"},
      {"177", "Mozilla/5.0 (iPad; CPU OS 7_1_2 like Mac OS X) AppleWebKit/537.51.2 (KHTML like Gecko) CriOS/36.0.1985.49 Mobile/11D257 Safari/9537.53 (000883)", "iOS", "Unknown", "Unknown", "Unknown", "Tablet", "Safari", "9537.53", "None", "None"},
      {"178", "Mozilla/5.0 (Macintosh; U; Intel Mac OS X 10_5_7; en-us) AppleWebKit/530.17 (KHTML, like Gecko) Version/4.0 Safari/530.17 Skyfire/2.0", "Macintosh", "Unknown", "Unknown", "Unknown", "Unknown", "Skyfire", "2.0", "en", "us"},
      {"179", "Mozilla/5.0 (Macintosh; U; Intel Mac OS X; en-us) AppleWebKit/537+ (KHTML, like Gecko) Version/5.0 Safari/537.6+ Midori/0.4", "Macintosh", "Unknown", "Unknown", "Unknown", "Unknown", "Midori", "0.4", "en", "us"},
      {"180", "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_9_4) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/33.0.1750.146 Safari/537.36 QQBrowser/3.0.2313.400", "Macintosh", "Unknown", "Unknown", "Unknown", "Unknown", "QQBrowser", "3.0.2313.400", "None", "None"},
      {"181", "Mozilla/5.0 (Macintosh; Intel Mac OS X 10.8; rv:27.0) Gecko/20100101537.51.2 (KHTML, like Gecko) Version/7.0 Mobile/11D257 Safari/9537.53", "Macintosh", "Unknown", "Unknown", "Unknown", "PC", "Safari", "9537.53", "None", "None"},
      {"182", "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_10_1) AppleWebKit/600.1.25 (KHTML, like Gecko)", "Macintosh", "Unknown", "Unknown", "Unknown", "Unknown", "Other", "Unknown", "None", "None"},
      {"183", "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_8_5) AppleWebKit/536.30.1 (KHTML, like Gecko, Safari/8536.30.1) ADM/763", "Macintosh", "Unknown", "Unknown", "Unknown", "Unknown", "Safari", "8536.30.1", "None", "None"},
      {"184", "Mozilla/5.0 (Macintosh; Intel Mac OS X 10.9; rv:5.0.1) Gecko/20100101 Firefox/5.0.1", "Macintosh", "Unknown", "Unknown", "Unknown", "PC", "Firefox", "5.0.1", "None", "None"},
      {"185", "Mozilla/5.0 (Macintosh; U; Intel Mac OS X 10_6_3; en-us; Silk/1.0.22.153_10033210) AppleWebKit/533.16 (KHTML, like Gecko) Version/5.0 Safari/533.16 Silk-Accelerated=true", "Macintosh", "Unknown", "Unknown", "Unknown", "Unknown", "Silk", "1.0.22.153", "en", "us"},
      {"186", "Mozilla/5.0 (iPad; CPU iPhone OS 6_1_3 like Mac OS X) AppleWebKit/536.26 (KHTML, like Gecko) Version/6.0 Mobile/10B329 Safari/8536.25", "iOS", "Unknown", "Unknown", "Unknown", "Tablet", "Safari", "8536.25", "None", "None"},
      {"187", "Mozilla/5.0 (iPad; CPU OS 8_1 like Mac OS X) AppleWebKit/600.1.4 (K Gecko) Chrome/40.0.2214.91 Safari/537.36", "iOS", "Unknown", "Unknown", "Unknown", "Tablet", "Chrome", "40.0.2214.91", "None", "None"},
      {"188", "Mozilla/5.0 (iPad; U; CPU OS 4_3_2 like Mac OS X) AppleWebKit/533.17.9 (KHTML, like Gecko) Mercury/7.2 Mobile/8H7 Safari/6533.18.5", "iOS", "Unknown", "Unknown", "Unknown", "Tablet", "Mercury", "7.2", "None", "None"},
      {"189", "Mozilla/5.0 (iPad; U; CPU OS 5_1 like Mac OS X) AppleWebKit/531.21.10 (KHTML, like Gecko) Version/4.0.4 Mobile/7B367 Safari/531.21.10 UCBrowser/3.4.1.483", "iOS", "Unknown", "Unknown", "Unknown", "Tablet", "UCBrowser", "3.4.1.483", "None", "None"},
      {"190", "Mozilla/5.0 (iPad; U; CPU OS 7_1_2 like Mac OS X; en-US) AppleWebKit/537.36 (KHTML, like Gecko)  Chrome/30.0.1599.114 Safari/537.36 Puffin/4.0.0IT Mobile", "iOS", "Unknown", "Unknown", "Unknown", "Tablet", "Puffin", "4.0.0", "en", "us"},
      {"191", "Mozilla/5.0 (iPhone 5SGSM; CPU iPhone OS 7_1_1 like Mac OS X) AppleWebKit/537.51.2 (KHTML, like Gecko) Version/6.0 MQQBrowser/5.6 Mobile/11D201 Safari/8536.25", "iOS", "Unknown", "Unknown", "Unknown", "Smartphone", "MQQBrowser", "5.6", "None", "None"},
      {"192", "Mozilla/5.0 (iPhone; CPU iPhone OS 6_0_1 like Mac OS X) AppleWebKit/536.26 (KHTML, like Gecko) Mercury/8.0.1 Mobile/10A523 Safari/8536.25", "iOS", "Unknown", "Unknown", "Unknown", "Smartphone", "Mercury", "8.0.1", "None", "None"},
      {"193", "Mozilla/5.0 (iPhone; CPU iPhone OS 7_0_4 like Mac OS X) AppleWebKit/537.51.1 (KHTML, like Gecko) Coast/4.01.88243 Mobile/11B554a Safari/7534.48.3", "iOS", "Unknown", "Unknown", "Unknown", "Smartphone", "Coast", "4.01.88243", "None", "None"},
      {"194", "Mozilla/5.0 (iPhone; CPU iPhone OS 8_1_3 like Mac OS X) AppleWebKit/600.1.4 (KHTML, like Gecko) OPiOS/9.1.0.86723 Mobile/12B466 Safari/9537.53", "iOS", "Unknown", "Unknown", "Unknown", "Smartphone", "Safari", "9537.53", "None", "None"},
      {"195", "Mozilla/5.0 (iPod; CPU iPhone OS 8_1_3 like Mac OS X) AppleWebKit/600.1.4 (KHTML, like Gecko) GSA/5.1.42378 Mobile/12B466 Safari/600.1.4", "iOS", "Unknown", "Unknown", "Unknown", "Smartphone", "Safari", "600.1.4", "None", "None"},
      {"196", "Mozilla/5.0 (Windows NTU iPhone OS 7_1_2 like Mac OS X) AppleWebKit/537.51.2 (KHTML, like Gecko) Version/7.0 Mobile/11D257 Safari/9537.53", "iOS", "Unknown", "Unknown", "Unknown", "Smartphone", "Safari", "9537.53", "None", "None"},
      {"197", "Mozilla/5.0 (iPhone; CPU iPhone OS 7_0_2 like Mac OS X) AppleWebKit/537.51.1 (KHTML, like Gecko) Mobile/11A501 bline/1.09 (iPhone OS 7.0.2, iPhone)", "iOS", "Unknown", "Unknown", "Unknown", "Smartphone", "Other", "Unknown", "None", "None"},
      {"198", "Mozilla/5.0 (iPhone; CPU iPhone OS 7_1_2 like Mac OS X) AppleWebKit/537.51.2 (KHTML, like Gecko) Mobile/11D257 iPhone4,1 BingWeb/5.1.1.1643.20141031", "iOS", "Unknown", "Unknown", "Unknown", "Smartphone", "Other", "Unknown", "None", "None"},
      {"199", "Mozilla/5.0 (iPhone; CPU iPhone OS 7_1_2 like Mac OS X) AppleWebKit/537.51.2 (KHTML, like Gecko) Mobile/11D257 NAVER(inapp; search; 370; 5.7.2; 4S)", "iOS", "Unknown", "Unknown", "Unknown", "Smartphone", "Other", "Unknown", "None", "None"},
      {"200", "Mozilla/5.0 (iPad; CPU OS 7_1_1 like Mac OS X) AppleWebKit/537.51.2 (KHTML, like Gecko) Mobile/11D201 AolApp/3.1.4.6", "iOS", "Unknown", "Unknown", "Unknown", "Tablet", "Other", "Unknown", "None", "None"},
      {"201", "Mozilla/5.0 (iPad; CPU OS 6_1_3 like Mac OS X) AppleWebKit/534.46 (KHTML, like Gecko) BaiduHD/2.6.2 Mobile/10A406 Safari/8536.25", "iOS", "Unknown", "Unknown", "Unknown", "Tablet", "Baidu", "2.6.2", "None", "None"},
      {"202", "Mozilla/5.0 (iPhone; CPU iPhone OS 7_0_4 like Mac OS X) AppleWebKit/537.51.1 (KHTML, like Gecko) Mobile/11B554a baiduboxapp/0_0.2.0.6_enohpi_069_046/4.0.7_1C2%254enohPi/1099a/E2D4929F76764E45B43E6DA175C8F08293210193BONKKFOGOLJ/1", "iOS", "Unknown", "Unknown", "Unknown", "Smartphone", "Baidu", "Unknown", "None", "None"},
      {"203", "Mozilla/5.0 (iPhone; CPU iPhone OS 7_1_1 like Mac OS X) AppleWebKit/537.51.2 (KHTML, like Gecko) Mobile/11D201 Twitter for iPhone", "iOS", "Unknown", "Unknown", "Unknown", "Smartphone", "Other", "Unknown", "None", "None"},
      {"204", "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_10_1) AppleWebKit/600.1.25 (KHTML, like Gecko) QuickLook/5.0", "Macintosh", "Unknown", "Unknown", "Unknown", "Unknown", "Other", "Unknown", "None", "None"},
      {"205", "Mozilla/5.0 (BlackBerry; U; BlackBerry 9300; en-US) AppleWebKit/534.8+ (KHTML, like Gecko) Version/6.0.0.706 Mobile Safari/534.8+", "BlackBerry", "Unknown", "BlackBerry", "Curve", "Smartphone", "Mobile Safari", "534.8", "en", "us"},
      {"206", "Mozilla/5.0 (BlackBerry; U; BlackBerry 9310; en-US) AppleWebKit/534.11+ (KHTML, like Gecko) Version/7.1.0.768 Mobile Safari/534.11+", "BlackBerry", "Unknown", "BlackBerry", "Curve", "Smartphone", "Mobile Safari", "534.11", "en", "us"},
      {"207", "Mozilla/5.0 (BlackBerry; U; BlackBerry 9330; en-US) AppleWebKit/534.8+ (KHTML, like Gecko) Version/6.0.0.706 Mobile Safari/534.8+", "BlackBerry", "Unknown", "BlackBerry", "Curve", "Smartphone", "Mobile Safari", "534.8", "en", "us"},
      {"208", "Mozilla/5.0 (BlackBerry; U; BlackBerry 9360; en-US) AppleWebKit/534.11+ (KHTML, like Gecko) Version/7.0.0.586 Mobile Safari/534.11+", "BlackBerry", "Unknown", "BlackBerry", "Curve", "Smartphone", "Mobile Safari", "534.11", "en", "us"},
      {"209", "Mozilla/5.0 (BlackBerry; U; BlackBerry 9700; en-US) AppleWebKit/534.8+ (KHTML, like Gecko) Version/6.0.0.448 Mobile Safari/534.8+", "BlackBerry", "Unknown", "BlackBerry", "Bold", "Smartphone", "Mobile Safari", "534.8", "en", "us"},
      {"210", "Mozilla/5.0 (BlackBerry; U; BlackBerry 9800; en-US) AppleWebKit/534.1+ (KHTML, like Gecko) Version/6.0.0.246 Mobile Safari/534.1+", "BlackBerry", "Unknown", "BlackBerry", "Torch", "Smartphone", "Mobile Safari", "534.1", "en", "us"},
      {"211", "Mozilla/5.0 (BlackBerry; U; BlackBerry 9810; en-US) AppleWebKit/534.11+ (KHTML, like Gecko) Version/7.1.0.694 Mobile Safari/534.11+", "BlackBerry", "Unknown", "BlackBerry", "Torch", "Smartphone", "Mobile Safari", "534.11", "en", "us"},
      {"212", "Mozilla/5.0 (BlackBerry; U; BlackBerry 9900; en-US) AppleWebKit/534.11+ (KHTML, like Gecko) Version/7.0.0.261 Mobile Safari/534.11+", "BlackBerry", "Unknown", "BlackBerry", "Bold", "Smartphone", "Mobile Safari", "534.11", "en", "us"},
      {"213", "Mozilla/5.0 (BlackBerry; U; BlackBerry 9930; en-US) AppleWebKit/534.11+ (KHTML, like Gecko) Version/7.1.0.991 Mobile Safari/534.11+", "BlackBerry", "Unknown", "BlackBerry", "Bold", "Smartphone", "Mobile Safari", "534.11", "en", "us"},
      {"214", "Mozilla/5.0 (BB10; Kbd) AppleWebKit/537.35+ (KHTML, like Gecko) Version/10.2.1.3337 Mobile Safari/537.35+", "BlackBerry", "Unknown", "BlackBerry", "Unknown", "Smartphone", "Mobile Safari", "537.35", "None", "None"},
      {"215", "Mozilla/5.0 (BB10; Touch) AppleWebKit/537.10+ (KHTML, like Gecko) Version/10.1.0.1485 Mobile Safari/537.10+", "BlackBerry", "Unknown", "BlackBerry", "Unknown", "Smartphone", "Mobile Safari", "537.10", "None", "None"},
      {"216", "Mozilla/5.0 (PlayBook; U; RIM Tablet OS 2.1.0; en-US) AppleWebKit/536.2+ (KHTML, like Gecko) Version/7.2.1.0 Mobile Safari/536.2+", "BlackBerry", "Unknown", "BlackBerry", "PlayBook", "Tablet", "Mobile Safari", "536.2", "en", "us"},
      {"217", "Mozilla/5.0 (PlayBook; U; Android 2.3.3; en-gb; PlayBook Build/2.1.0.147) AppleWebKit/533.1+ (KHTML, like Gecko) Version/4.0 Mobile Safari/533.1+", "Android", "2.3.3", "BlackBerry", "PlayBook", "Tablet", "Mobile Safari", "533.1", "en", "gb"},
      {"218", "Mozilla/5.0 (hp-tablet; Linux; hpwOS/3.0.5; U; en-US) AppleWebKit/534.6 (KHTML, like Gecko) wOSBrowser/234.83 Safari/534.6 TouchPad/1.0", "webOS", "Unknown", "Unknown", "TouchPad", "Tablet", "wOSBrowser", "Unknown", "en", "us"},
      {"219", "Mozilla/5.0 (Series40; Nokia200/10.60; Profile/MIDP-2.1 Configuration/CLDC-1.1) Gecko/20100401 S40OviBrowser/5.0.0.0.31", "Other", "Unknown", "Unknown", "Asha", "Smartphone", "Other", "Unknown", "None", "None"},
      {"220", "Mozilla/5.0 (Series40; Nokia305/05.92; Profile/MIDP-2.1 Configuration/CLDC-1.1) Gecko/20100401 S40OviBrowser/5.0.0.0.31", "Other", "Unknown", "Unknown", "Asha", "Smartphone", "Other", "Unknown", "None", "None"},
      {"221", "Mozilla/5.0 (Windows NT 6.2; ARM; Trident/7.0; Touch; rv:11.0; WPDesktop; Lumia 1520) like Gecko", "Windows", "8", "Unknown", "Lumia", "Smartphone", "IE", "11", "None", "None"},
      {"222", "Mozilla/5.0 (Windows NT 6.2; ARM; Trident/7.0; Touch; rv:11.0; WPDesktop; NOKIA; 909) like Gecko", "Windows", "8", "Unknown", "Lumia", "Smartphone", "IE", "11", "None", "None"},
      {"223", "Mozilla/5.0 (Windows NT 6.2; ARM; Trident/7.0; Touch; rv:11.0; WPDesktop; 909) like Gecko", "Windows", "8", "Unknown", "Lumia", "Smartphone", "IE", "11", "None", "None"},
      {"224", "Mozilla/5.0 (Windows NT 6.2; ARM; Trident/7.0; Touch; rv:11.0; WPDesktop; NOKIA; Lumia 925) like Gecko", "Windows", "8", "Unknown", "Lumia", "Smartphone", "IE", "11", "None", "None"},
      {"225", "Mozilla/5.0 (Linux; U; Android 2.3.6; en-gb; GT-S6802 Build/GINGERBREAD) AppleWebKit/533.1 (KHTML, like Gecko) Version/4.0 Mobile Safari/533.1", "Android", "2.3.6", "Samsung", "Galaxy Ace Duos", "Smartphone", "Mobile Safari", "533.1", "en", "gb"},
      {"226", "Mozilla/5.0 (Linux; U; Android 2.3.4; en-ca; GT-S5830D-parrot Build/GINGERBREAD) AppleWebKit/533.1 (KHTML, like Gecko) Version/4.0 Mobile Safari/533.1", "Android", "2.3.4", "Samsung", "Galaxy Ace", "Smartphone", "Mobile Safari", "533.1", "en", "ca"},
      {"227", "Mozilla/5.0 (Linux; U; Android 2.3.6; en-ca; SCH-S720C Build/GINGERBREAD) AppleWebKit/533.1 (KHTML, like Gecko) Version/4.0 Mobile Safari/533.1", "Android", "2.3.6", "Samsung", "Proclaim", "Smartphone", "Mobile Safari", "533.1", "en", "ca"},
      {"228", "Mozilla/5.0 (Linux; U; Android 2.3.6; en-us; SAMSUNG-SGH-I827 Build/GINGERBREAD) AppleWebKit/533.1 (KHTML, like Gecko) Version/4.0 Mobile Safari/533.1", "Android", "2.3.6", "Samsung", "Galaxy Appeal", "Smartphone", "Mobile Safari", "533.1", "en", "us"},
      {"229", "Mozilla/5.0 (Linux; Android 4.4.2; zh-cn; SAMSUNG SM-G386T1 Build/KOT49H) AppleWebKit/537.36 (KHTML, like Gecko) Version/1.6 Chrome/28.0.1500.94 Mobile Safari/537.36", "Android", "4.4.2", "Samsung", "Galaxy Avant", "Smartphone", "Chrome", "28.0.1500.94", "zh", "cn"},
      {"230", "Mozilla/5.0 (Linux; U; Android 2.3.6; en-us; SGH-T769 Build/GINGERBREAD) AppleWebKit/533.1 (KHTML, like Gecko) Version/4.0 Mobile Safari/533.1", "Android", "2.3.6", "Samsung", "Galaxy S Blaze", "Smartphone", "Mobile Safari", "533.1", "en", "us"},
      {"231", "Mozilla/5.0 (Linux; U; Android 4.1.2; en-us; SGH-I897 Build/IML74K) AppleWebKit/534.30 (KHTML, like Gecko) Version/4.0 Mobile Safari/534.30", "Android", "4.1.2", "Samsung", "Captivate", "Smartphone", "Mobile Safari", "534.30", "en", "us"},
      {"232", "Mozilla/5.0 (Linux; U; Android 4.0.4; en-us; SCH-S738C Build/IMM76D) AppleWebKit/534.30 (KHTML, like Gecko) Version/4.0 Mobile Safari/534.30", "Android", "4.0.4", "Samsung", "Galaxy Centura", "Smartphone", "Mobile Safari", "534.30", "en", "us"},
      {"233", "Mozilla/5.0 (Linux; U; Android 2.3.6; en-us; SCH-I510 4G Build/FP8) AppleWebKit/533.1 (KHTML, like Gecko) Version/4.0 Mobile Safari/533.1", "Android", "2.3.6", "Samsung", "Droid Charge", "Smartphone", "Mobile Safari", "533.1", "en", "us"},
      {"234", "Mozilla/5.0 (Linux; U; Android 4.0.4; en-gb; GT-B5330L Build/IMM76D) AppleWebKit/534.30 (KHTML, like Gecko) Version/4.0 Mobile Safari/534.30", "Android", "4.0.4", "Samsung", "Galaxy Chat", "Smartphone", "Mobile Safari", "534.30", "en", "gb"},
      {"235", "Mozilla/5.0 (Linux; U; Android 2.3.6; en-us; SPH-D600 Build/GINGERBREAD) AppleWebKit/533.1 (KHTML, like Gecko) Version/4.0 Mobile Safari/533.1", "Android", "2.3.6", "Samsung", "Conquer", "Smartphone", "Mobile Safari", "533.1", "en", "us"},
      {"236", "Mozilla/5.0 (Linux; U; Android 2.2.2; en-us; SCH-I400 Build/FROYO) AppleWebKit/533.1 (KHTML, like Gecko) Version/4.0 Mobile Safari/533.1", "Android", "2.2.2", "Samsung", "Continuum", "Smartphone", "Mobile Safari", "533.1", "en", "us"},
      {"237", "Mozilla/5.0 (Linux; Android 4.4.2; SM-G355M Build/KOT49H) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/38.0.2125.114 Mobile Safari/537.36", "Android", "4.4.2", "Samsung", "Galaxy Core 2 Duos", "Smartphone", "Chrome", "38.0.2125.114", "None", "None"},
      {"238", "Mozilla/5.0 (Linux; U; Android 2.2.2; en-us; SGH-T499 Build/FROYO) AppleWebKit/533.1 (KHTML, like Gecko) Version/4.0 Mobile Safari/533.1", "Android", "2.2.2", "Samsung", "Dart", "Smartphone", "Mobile Safari", "533.1", "en", "us"},
      {"239", "Mozilla/5.0 (Linux; U; Android 4.1.2; en-us; SCH-R740C Build/JZO54K) AppleWebKit/534.30 (KHTML, like Gecko) Version/4.0 Mobile Safari/534.30", "Android", "4.1.2", "Samsung", "Galaxy Discover", "Smartphone", "Mobile Safari", "534.30", "en", "us"},
      {"240", "Mozilla/5.0 (Linux; U; Android 2.3.6; en-us; SPH-D700 Build/GINGERBREAD) AppleWebKit/533.1 (KHTML, like Gecko) Version/4.0 Mobile Safari/533.1", "Android", "2.3.6", "Samsung", "Epic", "Smartphone", "Mobile Safari", "533.1", "en", "us"},
      {"241", "Mozilla/5.0 (Linux; U; Android 4.1.2; es-us; SGH-T599N Build/JZO54K) AppleWebKit/534.30 (KHTML, like Gecko) Version/4.0 Mobile Safari/534.30", "Android", "4.1.2", "Samsung", "Galaxy Exhibit", "Smartphone", "Mobile Safari", "534.30", "es", "us"},
      {"242", "Mozilla/5.0 (Linux; U; Android 4.0.4; en-us; SAMSUNG-SGH-I577 Build/IMM76D) AppleWebKit/534.30 (KHTML, like Gecko) Version/4.0 Mobile Safari/534.30", "Android", "4.0.4", "Samsung", "Exhilarate", "Smartphone", "Mobile Safari", "534.30", "en", "us"},
      {"243", "Mozilla/5.0 (Linux; U; Android 4.2.2; en-us; SAMSUNG SM-G3815/G3815XXUBMK5 Build/JDQ39) AppleWebKit/534.30 (KHTML, like Gecko) Version/4.0 Mobile Safari/534.30", "Android", "4.2.2", "Samsung", "Galaxy Express", "Smartphone", "Mobile Safari", "534.30", "en", "us"},
      {"244", "Mozilla/5.0 (Linux; U; Android 2.2.1; en-us; SCH-I500 Build/FROYO) AppleWebKit/533.1 (KHTML, like Gecko) Version/4.0 Mobile Safari/533.1", "Android", "2.2.1", "Samsung", "Fascinate", "Smartphone", "Mobile Safari", "533.1", "en", "us"},
      {"245", "Mozilla/5.0 (Linux; U; Android 4.2.2; en-us; GT-I9060 Build/JDQ39) AppleWebKit/534.30 (KHTML, like Gecko) Version/4.0 Mobile Safari/534.30", "Android", "4.2.2", "Samsung", "Galaxy Grand Neo", "Smartphone", "Mobile Safari", "534.30", "en", "us"},
      {"246", "Mozilla/5.0 (Linux; U; Android 2.2.1; en-us; SAMSUNG-SGH-I997 Build/FROYO) AppleWebKit/533.1 (KHTML, like Gecko) Version/4.0 Mobile Safari/533.1", "Android", "2.2.1", "Samsung", "Infuse", "Smartphone", "Mobile Safari", "533.1", "en", "us"},
      {"247", "Mozilla/5.0 (Linux; U; Android 2.3.5; en-us; SCH-I110 Build/GINGERBREAD) AppleWebKit/533.1 (KHTML, like Gecko) Version/4.0 Mobile Safari/533.1", "Android", "2.3.5", "Samsung", "Illusion", "Smartphone", "Mobile Safari", "533.1", "en", "us"},
      {"248", "Mozilla/5.0 (Linux; U; Android 2.2.2; en-us; SPH-M910 Build/FROYO) AppleWebKit/533.1 (KHTML, like Gecko) Version/4.0 Mobile Safari/533.1", "Android", "2.2.2", "Samsung", "Intercept", "Smartphone", "Mobile Safari", "533.1", "en", "us"},
      {"249", "Mozilla/5.0 (Linux; U; Android 4.1.2; es-us; SCH-I200PP Build/JZO54K) AppleWebKit/534.30 (KHTML, like Gecko) Version/4.0 Mobile Safari/534.30", "Android", "4.1.2", "Samsung", "Galaxy Legend", "Smartphone", "Mobile Safari", "534.30", "es", "us"},
      {"250", "Mozilla/5.0 (Linux; Android 4.4.2; es-us; SAMSUNG SGH-T399N Build/KOT49H) AppleWebKit/537.36 (KHTML, like Gecko) Version/1.5 Chrome/28.0.1500.94 Mobile Safari/537.36", "Android", "4.4.2", "Samsung", "Galaxy Light", "Smartphone", "Chrome", "28.0.1500.94", "es", "us"},
      {"251", "Mozilla/5.0 (Linux; Android 4.4.2; es-us; SAMSUNG-SGH-I527 Build/KOT49H) AppleWebKit/537.36 (KHTML, like Gecko) Version/1.5 Chrome/28.0.1500.94", "Android", "4.4.2", "Samsung", "Galaxy Mega", "Smartphone", "Chrome", "28.0.1500.94", "es", "us"},
      {"252", "Mozilla/5.0 (Linux; U; Android 4.1.2; en-us; GT-S6012B Build/JZO54K) AppleWebKit/534.30 (KHTML, like Gecko) Version/4.0 Mobile Safari/534.30", "Android", "4.1.2", "Samsung", "Galaxy Music Duos", "Smartphone", "Mobile Safari", "534.30", "en", "us"},
      {"253", "Mozilla/5.0 (Linux; U; Android 4.3; en-gb; SAMSUNG-SGH-I317 Build/JSS15J) AppleWebKit/534.30 (KHTML, like Gecko) Version/4.0 Mobile Safari/534.30", "Android", "4.3", "Samsung", "Galaxy Note 2", "Smartphone", "Mobile Safari", "534.30", "en", "gb"},
      {"254", "Mozilla/5.0 (Linux; Android 4.3; en-au; SAMSUNG SM-N9005 Build/JSS15J) AppleWebKit/537.36 (KHTML, like Gecko) Version/1.5 Chrome/28.0.1500.94 Mobile Safari/537.36", "Android", "4.3", "Samsung", "Galaxy Note 3", "Smartphone", "Chrome", "28.0.1500.94", "en", "au"},
      {"255", "Mozilla/5.0 (Linux; U; Android 4.3; zh-cn; GT-N7102 Build/JSS15J) AppleWebKit/534.30 (KHTML, like Gecko) Version/4.0 Mobile Safari/534.30", "Android", "4.3", "Samsung", "Galaxy Note 2 Duos", "Smartphone", "Mobile Safari", "534.30", "zh", "cn"},
      {"256", "Mozilla/5.0 (Linux; U; Android 2.3.6; en-gb; YP-GI1 Build/GINGERBREAD) AppleWebKit/533.1 (KHTML, like Gecko) Version/4.0 Mobile Safari/533.1", "Android", "2.3.6", "Samsung", "Galaxy Player", "Smartphone", "Mobile Safari", "533.1", "en", "gb"},
      {"257", "Mozilla/5.0 (Linux; U; Android 2.2.2; en-us; SCH-M828C[2035102674] Build/FROYO) AppleWebKit/533.1 (KHTML, like Gecko) Version/4.0 Mobile Safari", "Android", "2.2.2", "Samsung", "Galaxy Precedent", "Smartphone", "Mobile Safari", "Unknown", "en", "us"},
      {"258", "Mozilla/5.0 (Linux; U; Android 2.3.6; en-us; SPH-M820-BST Build/GINGERBREAD) AppleWebKit/533.1 (KHTML, like Gecko) Version/4.0 Mobile Safari/533.1", "Android", "2.3.6", "Samsung", "Galaxy Prevail", "Smartphone", "Mobile Safari", "533.1", "en", "us"},
      {"259", "Mozilla/5.0 (Linux; U; Android 2.3.6; en-us; SPH-M580BST Build/GINGERBREAD) AppleWebKit/533.1 (KHTML, like Gecko) Version/4.0 Mobile Safari/533.1", "Android", "2.3.6", "Samsung", "Replenish", "Smartphone", "Mobile Safari", "533.1", "en", "us"},
      {"260", "Mozilla/5.0 (Linux; U; Android 4.1.2; en-us; SPH-M950 Build/JZO54K) AppleWebKit/534.30 (KHTML, like Gecko) Version/4.0 Mobile Safari/534.30", "Android", "4.1.2", "Samsung", "Galaxy Reverb", "Smartphone", "Mobile Safari", "534.30", "en", "us"},
      {"261", "Mozilla/5.0 (Linux; U; Android 4.1.2; es-us; SPH-M840 Build/JZO54K) AppleWebKit/534.30 (KHTML, like Gecko) Version/4.0 Mobile Safari/534.30", "Android", "4.1.2", "Samsung", "Galaxy Ring", "Smartphone", "Mobile Safari", "534.30", "es", "us"},
      {"262", "Mozilla/5.0 (Linux; U; Android 4.1.2; en-us; SAMSUNG-SGH-I547 Build/JZO54K) AppleWebKit/534.30 (KHTML, like Gecko) Version/4.0 Mobile Safari/534.30", "Android", "4.1.2", "Samsung", "Galaxy Ruby Pro", "Smartphone", "Mobile Safari", "534.30", "en", "us"},
      {"263", "Mozilla/5.0 (Linux; U; Android 2.3.6; en-us; SAMSUNG-SGH-I847 Build/GINGERBREAD) AppleWebKit/533.1 (KHTML, like Gecko) Version/4.0 Mobile Safari/533.1", "Android", "2.3.6", "Samsung", "Rugby Smart", "Smartphone", "Mobile Safari", "533.1", "en", "us"},
      {"264", "Mozilla/5.0 (Linux; U; Android 4.1.2; en-us; SPH-M830 Build/JZO54K) AppleWebKit/534.30 (KHTML, like Gecko) Version/4.0 Mobile Safari/534.30", "Android", "4.1.2", "Samsung", "Galaxy Rush", "Smartphone", "Mobile Safari", "534.30", "en", "us"},
      {"265", "Mozilla/5.0 (Linux; U; Android 4.0.4; en-ph; GT-S7562 Build/IMM76I) AppleWebKit/534.30 (KHTML, like Gecko) Version/4.0 Mobile Safari/534.30", "Android", "4.0.4", "Samsung", "Galaxy S Duos", "Smartphone", "Mobile Safari", "534.30", "en", "ph"},
      {"266", "Mozilla/5.0 (Linux; Android 4.4.4; d2lte Build/KTU84Q) AppleWebKit/537.36 (KHTML, like Gecko) Version/4.0 Chrome/33.0.0.0 Mobile Safari/537.36", "Android", "4.4.4", "Samsung", "Galaxy S LTE", "Smartphone", "Chrome", "33.0.0.0", "None", "None"},
      {"267", "Mozilla/5.0 (Linux; U; Android 2.3.6; en-; SAMSUNG-SGH-I727 Build/GINGERBREAD) AppleWebKit/533.1 (KHTML, like Gecko) Version/4.0 Mobile Safari/533.1", "Android", "2.3.6", "Samsung", "Galaxy S2 Skyrocket", "Smartphone", "Mobile Safari", "533.1", "en", "None"},
      {"268", "Mozilla/5.0 (Linux; U; Android 2.3.6; es-es; SGH-S959G Build/GINGERBREAD) AppleWebKit/533.1 (KHTML, like Gecko) Version/4.0 Mobile Safari/533.1", "Android", "2.3.6", "Samsung", "Galaxy S2", "Smartphone", "Mobile Safari", "533.1", "es", "es"},
      {"269", "Mozilla/5.0 (Linux; U; Android 4.1.2; de-de; SAMSUNG GT-I8190/I8190XXANR6 Build/JZO54K) AppleWebKit/534.30 (KHTML, like Gecko) Version/4.0 Mobile Safari/534.30", "Android", "4.1.2", "Samsung", "Galaxy S3 Mini", "Smartphone", "Mobile Safari", "534.30", "de", "de"},
      {"270", "Mozilla/5.0 (Linux; U; Android 4.3; ar-ae; GT-I9300 Build/JSS15J) AppleWebKit/534.30 (KHTML, like Gecko) Version/4.0 Mobile Safari/534.30", "Android", "4.3", "Samsung", "Galaxy S3", "Smartphone", "Mobile Safari", "534.30", "ar", "ae"},
      {"271", "Mozilla/5.0 (Linux; Android 4.2.2; GT-I9300-JB2 Build/JDQ39E) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/37.0.2062.117 Mobile Safari/537.36", "Android", "4.2.2", "Samsung", "Galaxy S3", "Smartphone", "Chrome", "37.0.2062.117", "None", "None"},
      {"272", "Mozilla/5.0 (Linux; U; Android 4.1.1; it-it; SAMSUNG-SGH-I747 Build/JRO03L) AppleWebKit/534.30 (KHTML, like Gecko) Version/4.0 Mobile Safari/534.30", "Android", "4.1.1", "Samsung", "Galaxy S3", "Smartphone", "Mobile Safari", "534.30", "it", "it"},
      {"273", "Mozilla/5.0 (Linux; U; Android 4.4.2; en-ca; SGH-T999V Build/KOT49H) AppleWebKit/534.30 (KHTML, like Gecko) Version/4.0 Mobile Safari/534.30", "Android", "4.4.2", "Samsung", "Galaxy S3", "Smartphone", "Mobile Safari", "534.30", "en", "ca"},
      {"274", "Mozilla/5.0 (Linux; Android 4.4.2; fr-fr; SAMSUNG-SGH-I257 Build/KOT49H) AppleWebKit/537.36 (KHTML, like Gecko) Version/1.5 Chrome/28.0.1500.94", "Android", "4.4.2", "Samsung", "Galaxy S4 Mini", "Smartphone", "Chrome", "28.0.1500.94", "fr", "fr"},
      {"275", "Mozilla/5.0 (Linux; Android 4.4.2; fr-ca; SGH-I257M-parrot Build/KOT49H) AppleWebKit/537.36 (KHTML, like Gecko) Version/1.5 Chrome/28.0.1500.94 Mobile Safari/537.36", "Android", "4.4.2", "Samsung", "Galaxy S4 Mini", "Smartphone", "Chrome", "28.0.1500.94", "fr", "ca"},
      {"276", "Mozilla/5.0 (Linux; Android 4.2.2; en-za; SAMSUNG-SGH-I337 Build/JDQ39) AppleWebKit/535.19 (KHTML, like Gecko) Version/1.0 Chrome/18.0.1025.308", "Android", "4.2.2", "Samsung", "Galaxy S4", "Smartphone", "Chrome", "18.0.1025.308", "en", "za"},
      {"277", "Mozilla/5.0 (Linux; Android 4.4.2; ko-kr; SAMSUNG-SM-G900A Build/KOT49H) AppleWebKit/537.36 (KHTML, like Gecko) Version/1.6 Chrome/28.0.1500.94", "Android", "4.4.2", "Samsung", "Galaxy S5", "Smartphone", "Chrome", "28.0.1500.94", "ko", "kr"},
      {"278", "Mozilla/5.0 (Linux; Android 4.4.2; zh-cn; SAMSUNG SM-G900T1 Build/KOT49H) AppleWebKit/537.36 (KHTML, like Gecko) Version/1.6 Chrome/28.0.1500.9", "Android", "4.4.2", "Samsung", "Galaxy S5", "Smartphone", "Chrome", "28.0.1500.9", "zh", "cn"},
      {"279", "Mozilla/5.0 (Linux; U; Android 2.2.1; en-us; SGH-T839 Build/FROYO) AppleWebKit/533.1 (KHTML, like Gecko) Version/4.0 Mobile Safari/533.1", "Android", "2.2.1", "Samsung", "Sidekick", "Smartphone", "Mobile Safari", "533.1", "en", "us"},
      {"280", "Mozilla/5.0 (Linux; U; Android 4.1.2; en-us; GT-S7262 Build/JZO54K) AppleWebKit/534.30 (KHTML, like Gecko) Version/4.0 UCBrowser/9.9.2.467 U3/0.8.0 Mobile Safari/534.30", "Android", "4.1.2", "Samsung", "Galaxy Star Pro", "Smartphone", "UCBrowser", "9.9.2.467", "en", "us"},
      {"281", "Mozilla/5.0 (Linux; U; Android 4.1.2; en-us; SCH-I200 Build/JZO54K) AppleWebKit/534.30 (KHTML, like Gecko) Version/4.0 Mobile Safari/534.30", "Android", "4.1.2", "Samsung", "Galaxy Stellar", "Smartphone", "Mobile Safari", "534.30", "en", "us"},
      {"282", "Mozilla/5.0 (Linux; U; Android 2.3.6; en-us; SCH-I405 4G Build/GC1) AppleWebKit/533.1 (KHTML, like Gecko) Version/4.0 Mobile Safari/533.1", "Android", "2.3.6", "Samsung", "Galaxy Stratosphere", "Smartphone", "Mobile Safari", "533.1", "en", "us"},
      {"283", "Mozilla/5.0 (Linux; U; Android 2.3.6; en-us; SPH-M930BST Build/GINGERBREAD) AppleWebKit/533.1 (KHTML, like Gecko) Version/4.0 Mobile Safari/533.1", "Android", "2.3.6", "Samsung", "Transform Ultra", "Smartphone", "Mobile Safari", "533.1", "en", "us"},
      {"284", "Mozilla/5.0 (Linux; U; Android 2.3.6; es-es; SGH-T959V Build/GINGERBREAD) AppleWebKit/533.1 (KHTML, like Gecko) Version/4.0 Mobile Safari/533.1", "Android", "2.3.6", "Samsung", "Vibrant", "Smartphone", "Mobile Safari", "533.1", "es", "es"},
      {"285", "Mozilla/5.0 (Linux; U; Android 4.1.2; en-us; SPH-L300 Build/JZO54K) AppleWebKit/534.30 (KHTML, like Gecko) Version/4.0 Mobile Safari/534.30", "Android", "4.1.2", "Samsung", "Galaxy Victory", "Smartphone", "Mobile Safari", "534.30", "en", "us"},
      {"286", "Mozilla/5.0 (Linux; U; Android 2.3.6; en-us; GT-S6102B Build/GINGERBREAD) AppleWebKit/533.1 (KHTML, like Gecko) Version/4.0 Mobile Safari/533.1", "Android", "2.3.6", "Samsung", "Galaxy Y Duos", "Smartphone", "Mobile Safari", "533.1", "en", "us"},
      {"287", "Mozilla/5.0 (Linux; U; Android 4.0.4; en-us; SCH-S735C Build/IMM76D) AppleWebKit/534.30 (KHTML, like Gecko) Version/4.0 Mobile Safari/534.30", "Android", "4.0.4", "Samsung", "Unknown", "Smartphone", "Mobile Safari", "534.30", "en", "us"},
      {"288", "Mozilla/5.0 (Linux; Android 4.4.2; GT-N5100 Build/KVT49L) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/39.0.2171.93 Safari/537.36", "Android", "4.4.2", "Samsung", "Galaxy Note", "Tablet", "Chrome", "39.0.2171.93", "None", "None"},
      {"289", "Mozilla/5.0 (Li SM-P600 Build/JSS15J) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/40.0.2214.89 Safari/537.36nux; Android 4.3; SM-P600 Build/JSS15J) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/40.0.2214.89 Safari/537.36", "Android", "4.3", "Samsung", "Galaxy Note Tab", "Tablet", "Chrome", "40.0.2214.89", "None", "None"},
      {"290", "Mozilla/5.0 (Linux; U; Android 4.2.2; pt-br; GT-P5113 Build/JDQ39) AppleWebKit/534.30 (KHTML, like Gecko) Version/4.0 Safari/534.30", "Android", "4.2.2", "Samsung", "Galaxy Tab 2", "Tablet", "Safari", "534.30", "pt", "br"},
      {"291", "Mozilla/5.0 (Linux; U; Android 4.1.2; ko-kr; SAMSUNG-SGH-I497 Build/JZO54K) AppleWebKit/534.30 (KHTML, like Gecko) Version/4.0 Safari/534.30", "Android", "4.1.2", "Samsung", "Galaxy Tab 2", "Tablet", "Safari", "534.30", "ko", "kr"},
      {"292", "Mozilla/5.0 (Linux; Android 4.4.2; fr-ca; SAMSUNG SM-T230NU Build/KOT49H) AppleWebKit/537.36 (KHTML, like Gecko) Version/1.5 Chrome/28.0.1500.94 Safari/537.36", "Android", "4.4.2", "Samsung", "Galaxy Tab 4", "Tablet", "Chrome", "28.0.1500.94", "fr", "ca"},
      {"293", "Mozilla/5.0 (Linux; Android 4.4.2; ko-kr; SAMSUNG SM-T900 Build/KOT49H) AppleWebKit/537.36 (KHTML, like Gecko) Version/1.5 Chrome/28.0.1500.94 Safari/537.36", "Android", "4.4.2", "Samsung", "Galaxy Tab Pro", "Tablet", "Chrome", "28.0.1500.94", "ko", "kr"},
      {"294", "Dalvik/1.6.0 (Linux; U; Android 4.4.2; SM-T900 Build/KOT49H)", "Android", "4.4.2", "Samsung", "Galaxy Tab Pro", "Tablet", "Dalvik", "1.6.0", "None", "None"},
      {"295", "Mozilla/5.0 (Linux; U; Android 4.2.2; en-us; AT7-B Build/JDQ39) AppleWebKit/534.30 (KHTML, like Gecko) Version/4.0 Safari/534.30", "Android", "4.2.2", "Toshiba", "Excite", "Tablet", "Safari", "534.30", "en", "us"},
      {"296", "Mozilla/5.0 (Linux; Android 4.4.2; AT7-C Build/KOT49H) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/39.0.2171.93 Safari/537.36", "Android", "4.4.2", "Toshiba", "Excite", "Tablet", "Chrome", "39.0.2171.93", "None", "None"},
      {"297", "Mozilla/5.0 (Linux; U; Android 4.2.1; en-us; AT10-A Build/JOP40D) AppleWebKit/534.30 (KHTML, like Gecko) Version/4.0 Safari/534.30", "Android", "4.2.1", "Toshiba", "Excite", "Tablet", "Safari", "534.30", "en", "us"},
      {"298", "Mozilla/5.0 (Linux; U; Android 3.2.1; es-es; AT100 Build/HTK55D) AppleWebKit/534.13 (KHTML, like Gecko) Version/4.0 Safari/534.13", "Android", "3.2.1", "Toshiba", "Excite", "Tablet", "Safari", "534.13", "es", "es"},
      {"299", "Mozilla/5.0 (Linux; Android 4.1.1; AT300SE Build/JRO03C) AppleWebKit/535.19 (KHTML, like Gecko) Chrome/18.0.1025.166  Safari/535.19", "Android", "4.1.1", "Toshiba", "Excite", "Tablet", "Chrome", "18.0.1025.166", "None", "None"},
      {"300", "Mozilla/5.0 (Linux; U; Android 4.0.4; en-us; MZ617 4G Build/7.7.1-85_MZ617-27) AppleWebKit/534.30 (KHTML, like Gecko) Version/4.0 Safari/534.30", "Android", "4.0.4", "Motorola", "Droid", "Tablet", "Safari", "534.30", "en", "us"},
      {"301", "Mozilla/5.0 (Linux; U; Android 4.0.3; en-us; MZ604 Build/I.7.1-34) AppleWebKit/534.30 (KHTML, like Gecko) Version/4.0 Safari/534.30", "Android", "4.0.3", "Motorola", "Xoom", "Tablet", "Safari", "534.30", "en", "us"},
      {"302", "Mozilla/5.0 (Linux; U; Android 4.0.3; en-us; Xoom Build/IML77) AppleWebKit/534.30 (KHTML, like Gecko) Version/4.0 Safari/534.30", "Android", "4.0.3", "Motorola", "Xoom", "Tablet", "Safari", "534.30", "en", "us"},
      {"303", "Mozilla/5.0 (Linux; U; Android 2.3.6; en-us; MB865 Build/5.5.1-175_EDMR1.25) AppleWebKit/533.1 (KHTML, like Gecko) Version/4.0 Mobile Safari/533.1", "Android", "2.3.6", "Motorola", "Atrix", "Smartphone", "Mobile Safari", "533.1", "en", "us"},
      {"304", "Mozilla/5.0 (Linux; U; Android 2.2.2; en-us; MB520 Build/Blur_Version.38.6.0.MB520.Generic.en.US Flex/P002) AppleWebKit/533.1 (KHTML, like Gecko) Version/4.0 Mobile Safari/533.1", "Android", "2.2.2", "Motorola", "Bravo", "Smartphone", "Mobile Safari", "533.1", "en", "us"},
      {"305", "Mozilla/5.0 (Linux; U; Android 2.3.7; en-us; XT555C Build/V1.67D) AppleWebKit/533.1 (KHTML, like Gecko) Version/4.0 Mobile Safari/533.1", "Android", "2.3.7", "Motorola", "Defy", "Smartphone", "Mobile Safari", "533.1", "en", "us"},
      {"306", "Dalvik/1.6.0 (Linux; U; Android 4.4.4; XT1254 Build/KDF21.196-8)", "Android", "4.4.4", "Motorola", "Droid Turbo", "Smartphone", "Dalvik", "1.6.0", "None", "None"},
      {"307", "Mozilla/5.0 (Linux; Android 4.4.4; XT830C Build/KXC21.5-40) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/34.0.1847.114 Mobile Safari/537.36", "Android", "4.4.4", "Motorola", "Moto", "Smartphone", "Chrome", "34.0.1847.114", "None", "None"},
      {"308", "Mozilla/5.0 (Linux; Android 4.4.2; XT1028 Build/KXB20.9-1.10-1.20) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/30.0.1599.92 Mobile Safari/537", "Android", "4.4.2", "Motorola", "Moto", "Smartphone", "Chrome", "30.0.1599.92", "None", "None"},
      {"309", "Mozilla/5.0 (Linux; U; Android 2.3.4; en-us; MB855 Build/4.5.1A-1_SUN-198_6) AppleWebKit/533.1 (KHTML, like Gecko) Version/4.0 Mobile Safari/533.1", "Android", "2.3.4", "Motorola", "Photon", "Smartphone", "Mobile Safari", "533.1", "en", "us"},
      {"310", "Mozilla/5.0 (Linux; U; Android 4.2.2; en-us; Q9H Build/JDQ39) AppleWebKit/534.30 (KHTML, like Gecko) Version/4.0 Safari/534.30", "Android", "4.2.2", "Motorola", "Q9H", "Smartphone", "Safari", "534.30", "en", "us"},
      {"311", "Mozilla/5.0 (Linux; U; Android 4.0.4; en-gb; MOT-XT910 Build/6.7.3-94_SPI-324) AppleWebKit/534.30 (KHTML, like Gecko) Version/4.0 Mobile Safari/534.30", "Android", "4.0.4", "Motorola", "RAZR", "Smartphone", "Mobile Safari", "534.30", "en", "gb"},
      {"312", "Mozilla/5.0 (Linux; Android 4.4.2; TC70 Build/02-23245-K-07-04-01-G0-080514) AppleWebKit/537.36 (KHTML, like Gecko) Version/4.0 Chrome/30.0.0.0 Mobile Safari/537.36", "Android", "4.4.2", "Motorola", "Symbol", "Smartphone", "Chrome", "30.0.0.0", "None", "None"},
      {"313", "Mozilla/5.0 (Linux; U; Android 2.2.2; en-us; MOTWX435KT Build/FROYO) AppleWebKit/533.1 (KHTML, like Gecko) Version/4.0 Mobile Safari/533.1", "Android", "2.2.2", "Motorola", "Triumph", "Smartphone", "Mobile Safari", "533.1", "en", "us"},
      {"314", "Mozilla/5.0 (Linux; U; Android 2.2.3; en-us; Droid Build/FRK76) AppleWebKit/533.1 (KHTML, like Gecko) Version/4.0 Mobile Safari/533.1", "Android", "2.2.3", "Motorola", "Droid", "Smartphone", "Mobile Safari", "533.1", "en", "us"},
      {"315", "Mozilla/5.0 (Linux; U; Android 4.0.4; en-us; DROID BIONIC 4G Build/6.7.2-223_DBN_M4-23) AppleWebKit/534.30 (KHTML, like Gecko) Version/4.0 Mobi", "Android", "4.0.4", "Motorola", "Droid", "Smartphone", "Unknown", "Unknown", "en", "us"},
      {"316", "Mozilla/5.0 (Linux; Android 4.4.4; DROID MAXX Build/KTU84Q) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/36.0.1985.135 Mobile Safari/537.36", "Android", "4.4.4", "Motorola", "Droid", "Smartphone", "Chrome", "36.0.1985.135", "None", "None"},
      {"317", "Mozilla/5.0 (Linux; U; Android 2.3.4; en-us; DROID Pro Build/4.5.1-110-VNS-35) AppleWebKit/533.1 (KHTML, like Gecko) Version/4.0 Mobile Safari/533.1", "Android", "2.3.4", "Motorola", "Droid", "Smartphone", "Mobile Safari", "533.1", "en", "us"},
      {"318", "Mozilla/5.0 (Linux; U; Android 2.2.1; en-us; DROIDX Build/VZW) AppleWebKit/533.1 (KHTML, like Gecko) Version/4.0 Mobile Safari/533.1 480X854 motorola DROIDX", "Android", "2.2.1", "Motorola", "Droid", "Smartphone", "Mobile Safari", "533.1", "en", "us"},
      {"319", "Mozilla/5.0 (Linux; U; Android 2.3.4; en-us; DROID2 GLOBAL Build/4.5.1_57_D2GA-59) AppleWebKit/533.1 (KHTML, like Gecko) Version/4.0 Mobile Safari/533.1", "Android", "2.3.4", "Motorola", "Droid 2 Global", "Smartphone", "Mobile Safari", "533.1", "en", "us"},
      {"320", "Mozilla/5.0 (Linux; Android 4.2.2; Lenovo A369i Build/JDQ39) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/28.0.1500.94 Mobile Safari/537.36", "Android", "4.2.2", "Lenovo", "A369i", "Smartphone", "Chrome", "28.0.1500.94", "None", "None"},
      {"321", "Mozilla/5.0 (Linux; Android 4.4.2; Lenovo S960 Build/KOT49H) AppleWebKit/537.36 (KHTML, like Gecko) Version/4.0 Chrome/30.0.0.0 Mobile Safari/537.36 MxBrowser/4.3.2.2000", "Android", "4.4.2", "Lenovo", "Vibe", "Smartphone", "Maxthon", "4.3.2.2000", "None", "None"},
      {"322", "Mozilla/5.0 (Linux; U; Android 4.2.2; en-us; Lenovo A7600-F Build/JDQ39) AppleWebKit/534.30 (KHTML, like Gecko) Version/4.0 Mobile Safari/534.30", "Android", "4.2.2", "Lenovo", "IdeaTab", "Tablet", "Mobile Safari", "534.30", "en", "us"},
      {"323", "Mozilla/5.0 (Linux; U; Android 4.1.2; en-us; IdeaTabA1000L-F Build/JZO54K) AppleWebKit/534.30 (KHTML, like Gecko) Version/4.0 Safari/534.30", "Android", "4.1.2", "Lenovo", "IdeaTab", "Tablet", "Safari", "534.30", "en", "us"},
      {"324", "Mozilla/5.0 (Linux; U; Android 4.0.3; en-us; IdeaTab A2107A-F Build/IML74K) AppleWebKit/534.30 (KHTML, like Gecko) Version/4.0 Safari/534.30", "Android", "4.0.3", "Lenovo", "IdeaTab", "Tablet", "Safari", "534.30", "en", "us"},
      {"325", "Mozilla/5.0 (Linux; Android 4.4.2; YOGA Tablet 2 Pro-1380F Build/KOT49H) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/39.0.2171.93 Safari/537.36", "Android", "4.4.2", "Lenovo", "Yoga", "Tablet", "Chrome", "39.0.2171.93", "None", "None"},
      {"326", "Mozilla/5.0 (Linux; Android 4.4.2; Lenovo TAB S8-50F Build/BMAIN) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/39.0.2171.59 Safari/537.36", "Android", "4.4.2", "Lenovo", "S8", "Tablet", "Chrome", "39.0.2171.59", "None", "None"},
      {"327", "Mozilla/5.0 (Linux; U; Android 4.0.3; en-us; ThinkPad Tablet Build/ThinkPadTablet_A400_03) AppleWebKit/534.30 (KHTML, like Gecko) Version/4.0 Safari/534.30", "Android", "4.0.3", "Lenovo", "ThinkPad", "Tablet", "Safari", "534.30", "en", "us"},
      {"328", "Mozilla/5.0 (Linux; Android 4.1.1; Z992 Build/JRO03C) AppleWebKit/535.19 (KHTML, like Gecko) Chrome/18.0.1025.166 Mobile Safari/535.19", "Android", "4.1.1", "ZTE", "Avail", "Smartphone", "Chrome", "18.0.1025.166", "None", "None"},
      {"329", "Mozilla/5.0 (Linux; Android 4.0.4; ZTE N9120 Build/IMM76I) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/34.0.1847.114 Mobile Safari/537.36", "Android", "4.0.4", "ZTE", "Avid 4G", "Smartphone", "Chrome", "34.0.1847.114", "None", "None"},
      {"330", "Mozilla/5.0 (Linux; U; Android 2.3.7; en-us; ZTE V768 Build/GINGERBREAD) AppleWebKit/533.1 (KHTML, like Gecko) Version/4.0 Mobile Safari/533.1", "Android", "2.3.7", "ZTE", "Concord", "Smartphone", "Mobile Safari", "533.1", "en", "us"},
      {"331", "Mozilla/5.0 (Linux; U; Android 2.3.7; en-us; Z768G Build/GINGERBREAD) AppleWebKit/533.1 (KHTML, like Gecko) Version/4.0 Mobile Safari/533.1", "Android", "2.3.7", "ZTE", "Midnight", "Smartphone", "Mobile Safari", "533.1", "en", "us"},
      {"332", "Mozilla/5.0 (Linux; U; Android 2.3.4; en-us; ZTE-X500 Build/FRG83) AppleWebKit/533.1 (KHTML, like Gecko) Version/4.0 Mobile Safari/533.1", "Android", "2.3.4", "ZTE", "Score", "Smartphone", "Mobile Safari", "533.1", "en", "us"},
      {"333", "Mozilla/5.0 (Linux; U; Android 4.2.2; en-us; V5 Build/JDQ39) AppleWebKit/534.30 (KHTML, like Gecko) Version/4.0 Mobile Safari/534.30", "Android", "4.2.2", "ZTE", "V5", "Smartphone", "Mobile Safari", "534.30", "en", "us"},
      {"334", "Mozilla/5.0 (Linux; U; Android 2.3.6; en-us; X501_USA_Cricket Build/GRK39F) AppleWebKit/533.1 (KHTML, like Gecko) Version/4.0 Mobile Safari/533.1", "Android", "2.3.6", "ZTE", "Groove", "Smartphone", "Mobile Safari", "533.1", "en", "us"},
      {"335", "Mozilla/5.0 (Linux; Android 4.4.2; Z830 Build/KVT49L) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/38.0.2125.102 Mobile Safari/537.36", "Android", "4.4.2", "Toshiba", "Satellite", "PC", "Chrome", "38.0.2125.102", "None", "None"},
      {"336", "Mozilla/5.0 (Linux; Android 4.1.2; Z750C Build/JZO54K) AppleWebKit/537.31 (KHTML, like Gecko) Chrome/26.0.1410.58 Mobile Safari/537.31", "Android", "4.1.2", "Sony", "Z750C", "Smartphone", "Chrome", "26.0.1410.58", "None", "None"},
      {"337", "Mozilla/5.0 (Linux; U; Android 4.1.1; en-us; Nexus S 4G Build/JRO03R) AppleWebKit/534.30 (KHTML, like Gecko) Version/4.0 Mobile Safari/534.30", "Android", "4.1.1", "Samsung", "Nexus S", "Smartphone", "Mobile Safari", "534.30", "en", "us"},
      {"338", "Mozilla/5.0 (Linux; U; Android 4.3; en-us; Galaxy Nexus Build/JWR66Y) AppleWebKit/534.30 (KHTML, like Gecko) Version/4.0 Mobile Safari/534.30", "Android", "4.3", "Samsung", "Galaxy Nexus", "Smartphone", "Mobile Safari", "534.30", "en", "us"},
      {"339", "Dalvik/2.1.0 (Linux; U; Android 5.0.1; Nexus 4 Build/LRX22C)", "Android", "5.0.1", "LG", "Nexus 4", "Smartphone", "Dalvik", "2.1.0", "None", "None"},
      {"340", "Mozilla/5.0 (Linux; Android 4.2.1; en-us; Nexus 5 Build/JOP40D) AppleWebKit/535.19 (KHTML, like Gecko; Google Wireless Transcoder) Chrome/38.0.1025.166 Mobile Safari/535.19", "Android", "4.2.1", "LG", "Nexus 5", "Smartphone", "Chrome", "38.0.1025.166", "en", "us"},
      {"341", "Mozilla/5.0 (Linux; Android 5.0.1; Nexus 6 Build/LRX22C) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/39.0.2171.93 Mobile Safari/537.36", "Android", "5.0.1", "Motorola", "Nexus 6", "Smartphone", "Chrome", "39.0.2171.93", "None", "None"},
      {"342", "Mozilla/5.0 (Linux; U; Android 4.2.1; en-us; Nexus 7 Build/JOP40D) AppleWebKit/534.30 (KHTML, like Gecko) Version/4.0 Safari/534.30", "Android", "4.2.1", "Asus", "Nexus 7", "Tablet", "Safari", "534.30", "en", "us"},
      {"343", "Mozilla/5.0 (Linux; Android 4.4.4; Nexus 7 2013 Build/KTU84Q) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/37.0.2062.117 Safari/537.36", "Android", "4.4.4", "Asus", "Nexus 7", "Tablet", "Chrome", "37.0.2062.117", "None", "None"},
      {"344", "Mozilla/5.0 (Linux; Android 5.0; Nexus 9 Build/LRX21R) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/38.0.2125.509 Safari/537.36", "Android", "5.0", "HTC", "Nexus 9", "Tablet", "Chrome", "38.0.2125.509", "None", "None"},
      {"345", "Mozilla/5.0 (Linux; Android 5.0; Nexus 10 Build/LRX21P) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/39.0.2171.59 Safari/537.36", "Android", "5.0", "Samsung", "Nexus 10", "Tablet", "Chrome", "39.0.2171.59", "None", "None"},
      {"346", "Mozilla/5.0 (Linux; U; Android 4.3; en-us; ASUS_T00F Build/JSS15Q) AppleWebKit/534.30 (KHTML, like Gecko) Version/4.0 Mobile Safari/534.30", "Android", "4.3", "Asus", "ZenPhone", "Smartphone", "Mobile Safari", "534.30", "en", "us"},
      {"347", "Mozilla/5.0 (Linux; Android 4.4.2; ASUS PadFone X Build/KOT49H) AppleWebKit/537.36 (KHTML, like Gecko) Version/4.0 Chrome/30.0.0.0 Mobile Safari/537.36", "Android", "4.4.2", "Asus", "PadFone", "Smartphone", "Chrome", "30.0.0.0", "None", "None"},
      {"348", "Mozilla/5.0 (Linux; U; Android 4.0.3; en-us; Transformer TF101 Build/IML74K) AppleWebKit/534.30 (KHTML, like Gecko) Version/4.0 Safari/534.30", "Android", "4.0.3", "Asus", "Transformer", "Tablet", "Safari", "534.30", "en", "us"},
      {"349", "Mozilla/5.0 (Linux; U; Android 4.2.1; en-us; ASUS Transformer Pad TF300T Build/JOP40D) AppleWebKit/534.30 (KHTML, like Gecko) Version/4.0 Safari/534.30", "Android", "4.2.1", "Asus", "Transformer Pad", "Tablet", "Safari", "534.30", "en", "us"},
      {"350", "Mozilla/5.0 (Linux; U; Android 4.1.1; en-us; Transformer Prime TF201 Build/JRO03C) AppleWebKit/534.30 (KHTML, like Gecko) Version/4.0 Safari/534.30", "Android", "4.1.1", "Asus", "Transformer Prime", "Tablet", "Safari", "534.30", "en", "us"},
      {"351", "Mozilla/5.0 (Linux; Android 4.4.2; K00C Build/KOT49H) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/37.0.2062.117 Safari/537.36", "Android", "4.4.2", "Asus", "Transformer Pad", "Tablet", "Chrome", "37.0.2062.117", "None", "None"},
      {"352", "Mozilla/5.0 (Linux; Android 4.4.2; K010 Build/KOT49H) AppleWebKit/537.36 (KHTML, like Gecko) Version/4.0 Chrome/30.0.0.0 Safari/537.36", "Android", "4.4.2", "Asus", "Transformer Pad", "Tablet", "Chrome", "30.0.0.0", "None", "None"},
      {"353", "Mozilla/5.0 (Linux; Android 4.2.2; K00F Build/JDQ39) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/40.0.2214.89 Safari/537.36", "Android", "4.2.2", "Asus", "MeMO Pad", "Tablet", "Chrome", "40.0.2214.89", "None", "None"},
      {"354", "Mozilla/5.0 (Linux; U; Android 4.3; en-us; K01A Build/JSS15Q) AppleWebKit/534.30 (KHTML, like Gecko) Version/4.0 Safari/534.30", "Android", "4.3", "Asus", "MeMO Pad", "Tablet", "Safari", "534.30", "en", "us"},
      {"355", "Mozilla/5.0 (Linux; Android 4.4.2; K011 Build/KOT49H) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/37.0.2062.117 Safari/537.36", "Android", "4.4.2", "Asus", "MeMO Pad", "Tablet", "Chrome", "37.0.2062.117", "None", "None"},
      {"356", "Mozilla/5.0 (Linux; U; Android 4.1.1; en-us; ME172V Build/JRO03H) AppleWebKit/534.30 (KHTML, like Gecko) Version/4.0 Safari/534.30", "Android", "4.1.1", "Asus", "MeMO Pad", "Tablet", "Safari", "534.30", "en", "us"},
      {"357", "Mozilla/5.0 (Linux; U; Android 4.2.2; es-es; A1-810 Build/JDQ39) AppleWebKit/534.30 (KHTML, like Gecko) Version/4.0 Safari/534.30", "Android", "4.2.2", "Acer", "Iconia", "Tablet", "Safari", "534.30", "es", "es"},
      {"358", "Mozilla/5.0 (Linux; Android 4.4.2; A3-A10 Build/KOT49H) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/36.0.1985.135 Safari/537.36", "Android", "4.4.2", "Acer", "Iconia", "Tablet", "Chrome", "36.0.1985.135", "None", "None"},
      {"359", "Mozilla/5.0 (Linux; U; Android 4.1.2; en-US; B1-710 Build/JZO54K) AppleWebKit/534.30 (KHTML, like Gecko) Version/4.1 Safari/534.30", "Android", "4.1.2", "Acer", "Iconia", "Tablet", "Safari", "534.30", "en", "us"},
      {"360", "Mozilla/5.0 (Linux; Android 4.4.2; b1-720 Build/KOT49H) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/40.0.2214.89 Safari/537.36", "Android", "4.4.2", "Acer", "Iconia", "Tablet", "Chrome", "40.0.2214.89", "None", "None"},
      {"361", "Mozilla/5.0 (Linux; Android 4.2.2; B1-730HD Build/JDQ39) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/39.0.2171.59 Safari/537.36", "Android", "4.2.2", "Acer", "Iconia One", "Tablet", "Chrome", "39.0.2171.59", "None", "None"},
      {"362", "Mozilla/5.0 (Linux; Android 4.0.4; DA220HQL Build/IMM76D) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/37.0.2062.117 Safari/537.36", "Android", "4.0.4", "Acer", "DA220HQL", "PC", "Chrome", "37.0.2062.117", "None", "None"},
      {"363", "Mozilla/5.0 (Linux; U; Android 4.2.2; en-US; A70H Build/JDQ39) AppleWebKit/533.1 (KHTML, like Gecko) Version/4.0 UCBrowser/10.0.0.488 U3/0.8.0 Mobile Safari/533.1", "Android", "4.2.2", "Teclast", "A70H", "Tablet", "UCBrowser", "10.0.0.488", "en", "us"},
      {"364", "Mozilla/5.0 (Linux; Android 4.4.2; A93 Build/KVT49L) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/39.0.2171.93 Safari/537.36", "Android", "4.4.2", "Micromax", "Canvas Elanza", "Smartphone", "Chrome", "39.0.2171.93", "None", "None"},
      {"365", "Mozilla/5.0 (Linux; U; Android 4.1.2; en-US; A111 Build/JZO54K) AppleWebKit/533.1 (KHTML, like Gecko) Version/4.0 UCBrowser/10.0.0.488 U3/0.8.0 Mobile Safari/533.1", "Android", "4.1.2", "Micromax", "Canvas Doodle", "Smartphone", "UCBrowser", "10.0.0.488", "en", "us"},
      {"366", "Mozilla/5.0 (Linux; Android 5.0.2; A0001 Build/LRX22G) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/39.0.2171.93 Mobile Safari/537.36", "Android", "5.0.2", "OnePlus", "One", "Smartphone", "Chrome", "39.0.2171.93", "None", "None"},
      {"367", "Mozilla/5.0 (Linux; U; Android 4.1.1; en-us; A1 Build/IMM76D) AppleWebKit/534.30 (KHTML, like Gecko) Version/4.0 Mobile Safari/534.30", "Android", "4.1.1", "Dragon", "Touch", "Tablet", "Mobile Safari", "534.30", "en", "us"},
      {"368", "Mozilla/5.0 (Linux; Android 4.4.2; A1X Build/KOT49H) AppleWebKit/537.36 (KHTML, like Gecko) Version/4.0 Chrome/30.0.0.0 Safari/537.36", "Android", "4.4.2", "Dragon", "Touch", "Tablet", "Chrome", "30.0.0.0", "None", "None"},
      {"369", "Mozilla/5.0 (Linux; Android 4.4.2; A912 Build/KOT49H) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/34.0.1847.114 Safari/537.36", "Android", "4.4.2", "Asto", "Queo", "Tablet", "Chrome", "34.0.1847.114", "None", "None"},
      {"370", "Mozilla/5.0 (Linux; U; Android 4.2.2; en-us; A727 Build/JDQ39) AppleWebKit/534.30 (KHTML, like Gecko) Version/4.0 Safari/534.30", "Android", "4.2.2", "Azpen", "Innovation", "Tablet", "Safari", "534.30", "en", "us"},
      {"371", "Mozilla/5.0 (Linux; Android 4.2.2; A1023 Build/JDQ39) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/39.0.2171.93 Safari/537.36", "Android", "4.2.2", "Azpen", "Innovation", "Tablet", "Chrome", "39.0.2171.93", "None", "None"},
      {"372", "Mozilla/5.0 (Linux; Android 4.4.2; A1040 Build/KOT49H) AppleWebKit/537.36 (KHTML, like Gecko) Version/4.0 Chrome/30.0.0.0 Safari/537.36", "Android", "4.4.2", "Azpen", "Azpa", "Tablet", "Chrome", "30.0.0.0", "None", "None"},
      {"373", "Mozilla/5.0 (Linux; Android 4.4.2; LGL31L Build/KOT49I.L31L10d) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/31.0.1650.59 Mobile Safari/537.36", "Android", "4.4.2", "LG", "Optimus Access", "Smartphone", "Chrome", "31.0.1650.59", "None", "None"},
      {"374", "Mozilla/5.0 (Linux; U; Android 2.2.1; en-us; Ally Build/FRG83D) AppleWebKit/533.1 (KHTML, like Gecko) Version/4.0 Mobile Safari/533.1", "Android", "2.2.1", "LG", "Ally", "Smartphone", "Mobile Safari", "533.1", "en", "us"},
      {"375", "Mozilla/5.0 (Linux; U; Android 2.3.4; en-us; LG-C729 Build/GRJ22) AppleWebKit/533.1 (KHTML, like Gecko) Version/4.0 Mobile Safari/533.1 MMS/LG-Android-MMS-V1.0/1.2", "Android", "2.3.4", "LG", "DoublePlay", "Smartphone", "Mobile Safari", "533.1", "en", "us"},
      {"376", "Mozilla/5.0 (Linux; Android 4.4.2; VS890 4G Build/KOT49I.VS89022A) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/34.0.1847.114 Mobile Safari/537.36", "Android", "4.4.2", "LG", "Enact", "Smartphone", "Chrome", "34.0.1847.114", "None", "None"},
      {"377", "Mozilla/5.0 (Linux; U; Android 2.3.4; en-us; LG-VS700 Build/GRJ22) AppleWebKit/533.1 (KHTML, like Gecko) Version/4.0 Mobile Safari/533.1", "Android", "2.3.4", "LG", "Enlighten", "Smartphone", "Mobile Safari", "533.1", "en", "us"},
      {"378", "Mozilla/5.0 (Linux; U; Android 4.0.4; en-us; LG-P870/P87010i Build/IMM76I) AppleWebKit/534.30 (KHTML, like Gecko) Version/4.0 Mobile Safari/534.30", "Android", "4.0.4", "LG", "Escape", "Smartphone", "Mobile Safari", "534.30", "en", "us"},
      {"379", "Mozilla/5.0 (Linux; U; Android 2.3.4; en-us; LG-MS910 Build/GINGERBREAD) AppleWebKit/533.1 (KHTML, like Gecko) Version/4.0 Mobile Safari/533.1", "Android", "2.3.4", "LG", "Esteem", "Smartphone", "Mobile Safari", "533.1", "en", "us"},
      {"380", "Mozilla/5.0 (Linux; U; Android 4.0.3; en-us; LG-L40G/V100 Build/IML74K) AppleWebKit/534.30 (KHTML, like Gecko) Version/4.0 Mobile Safari/534.30", "Android", "4.0.3", "LG", "Extreme", "Smartphone", "Mobile Safari", "534.30", "en", "us"},
      {"381", "Mozilla/5.0 (Linux; U; Android 4.4.2; en-us; LG-D950/D95020b Build/KOT49I.D95020b) AppleWebKit/537.36 (KHTML, like Gecko) Version/4.0 Chrome/30.0.1599.103 Mobile Safari/537.36", "Android", "4.4.2", "LG", "G Flex", "Smartphone", "Chrome", "30.0.1599.103", "en", "us"},
      {"382", "Mozilla/5.0 (Linux; U; Android 4.4.2; en-us; LG-V400 Build/KOT49I.A1399997689) AppleWebKit/537.36 (KHTML, like Gecko) Version/4.0 Chrome/30.0.1599.103 Safari/537.36", "Android", "4.4.2", "LG", "G Pad", "Tablet", "Chrome", "30.0.1599.103", "en", "us"},
      {"383", "Mozilla/5.0 (Linux; U; Android 4.4.2; es-us; LG-V410/V41010d Build/KOT49I.V41010d) AppleWebKit/537.36 (KHTML, like Gecko) Version/4.0 Chrome/30.0.1599.103 Safari/537.36", "Android", "4.4.2", "LG", "G Pad", "Tablet", "Chrome", "30.0.1599.103", "es", "us"},
      {"384", "Mozilla/5.0 (Linux; Android 4.4.2; VK410 Build/KOT49I.VK41010A) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/40.0.2214.109 Safari/537.36", "Android", "4.4.2", "LG", "G Pad", "Tablet", "Chrome", "40.0.2214.109", "None", "None"},
      {"385", "Mozilla/5.0 (Linux; Android 4.2.2; L-01F Build/JDQ39B) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/28.0.1500.94 Mobile Safari/537.36", "Android", "4.2.2", "LG", "G2", "Smartphone", "Chrome", "28.0.1500.94", "None", "None"},
      {"386", "Mozilla/5.0 (Linux; U; Android 4.4.2; es; LG-D801 Build/KOT49I.D80120e) AppleWebKit/537.36 (KHTML, like Gecko) Version/4.0 Chrome/30.0.1599.103", "Android", "4.4.2", "LG", "G2", "Smartphone", "Chrome", "30.0.1599.103", "es", "None"},
      {"387", "Mozilla/5.0 (Linux; U; Android 4.4.2; en-za; LG-LS980 Build/KOT49I.LS980ZVE) AppleWebKit/537.36 (KHTML, like Gecko) Version/4.0 Chrome/30.0.1599.103 Mobile Safari/537.36", "Android", "4.4.2", "LG", "G2", "Smartphone", "Chrome", "30.0.1599.103", "en", "za"},
      {"388", "Mozilla/5.0 (Linux; U; Android 2.3.4; en-us; T-Mobile G2 Build/GRJ22) AppleWebKit/533.1 (KHTML, like Gecko) Version/4.0 Mobile Safari/533.1", "Android", "2.3.4", "LG", "G2", "Smartphone", "Mobile Safari", "533.1", "en", "us"},
      {"389", "Mozilla/5.0 (Linux; U; Android 4.4.2; en-au; LG-D851 Build/KVT49L.D85110m) AppleWebKit/537.36 (KHTML, like Gecko) Version/4.0 Chrome/34.0.1847.118 Mobile Safari/537.36", "Android", "4.4.2", "LG", "G3", "Smartphone", "Chrome", "34.0.1847.118", "en", "au"},
      {"390", "Mozilla/5.0 (Linux; Android 4.4.4; LG-ls990 Build/KTU84Q) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/39.0.2171.59 Mobile Safari/537.36", "Android", "4.4.4", "LG", "G3", "Smartphone", "Chrome", "39.0.2171.59", "None", "None"},
      {"391", "Mozilla/5.0 (Linux; Android 4.2.2; LG Google TV TV Build/JDQ39) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/29.0.1547.80 Safari/537.36", "Android", "4.2.2", "LG", "Google TV", "Other", "Chrome", "29.0.1547.80", "None", "None"},
      {"392", "Mozilla/5.0 (Linux; U; Android 4.0.4; en-us; VS840PP Build/IMM76D) AppleWebKit/534.30 (KHTML, like Gecko) Version/4.0 Mobile Safari/534.30", "Android", "4.0.4", "LG", "Lucid", "Smartphone", "Mobile Safari", "534.30", "en", "us"},
      {"393", "Mozilla/5.0 (Linux; U; Android 2.3.4; en-us; LG-LG855 Build/GRJ22) AppleWebKit/533.1 (KHTML, like Gecko) Version/4.0 Mobile Safari/533.1", "Android", "2.3.4", "LG", "Marquee", "Smartphone", "Mobile Safari", "533.1", "en", "us"},
      {"394", "Mozilla/5.0 (Linux; U; Android 4.4.2; en; LG-E980/E98020h Build/KOT49I.E98020h) AppleWebKit/537.36 (KHTML, like Gecko) Version/4.0 Chrome/30.0.1599.103 Mobile Safari/537.36", "Android", "4.4.2", "LG", "Optimus", "Smartphone", "Chrome", "30.0.1599.103", "en", "None"},
      {"395", "Mozilla/5.0 (Linux; U; Android 4.4.2; en-us; LG-F240K/20g Build/KOT49I.F240K20g) AppleWebKit/537.36 (KHTML, like Gecko) Version/4.0 Chrome/30.0", "Android", "4.4.2", "LG", "Optimus", "Smartphone", "Chrome", "30.0", "en", "us"},
      {"396", "Mozilla/5.0 (Linux; U; Android 2.3.6; en-us; LG-L38C Build/GRK39F) AppleWebKit/533.1 (KHTML, like Gecko) Version/4.0 Mobile Safari/533.1 MMS/LG", "Android", "2.3.6", "LG", "Optimus", "Smartphone", "Mobile Safari", "533.1", "en", "us"},
      {"397", "Mozilla/5.0 (Linux; U; Android 2.3.3; en-us; LS670 Build/GRI40) AppleWebKit/533.1 (KHTML, like Gecko) Version/4.0 Mobile Safari/533.1", "Android", "2.3.3", "LG", "Optimus", "Smartphone", "Mobile Safari", "533.1", "en", "us"},
      {"398", "Mozilla/5.0 (Linux; U; Android 4.1.2; es-mx; LGMS500 Build/JZO54K) AppleWebKit/534.30 (KHTML, like Gecko) Version/4.0 Mobile Safari/534.30", "Android", "4.1.2", "LG", "Optimus", "Smartphone", "Mobile Safari", "534.30", "es", "mx"},
      {"399", "Mozilla/5.0 (Linux; U; Android 2.3.4; en-us; LG-VM701 Build/GRJ22) AppleWebKit/533.1 (KHTML, like Gecko) Version/4.0 Mobile Safari/533.1", "Android", "2.3.4", "LG", "Optimus", "Smartphone", "Mobile Safari", "533.1", "en", "us"},
      {"400", "Mozilla/5.0 (Linux; U; Android 2.2.1; en-us; VM670 Build/FRG83) AppleWebKit/533.1 (KHTML, like Gecko) Version/4.0 Mobile Safari/533.1", "Android", "2.2.1", "LG", "Optimus", "Smartphone", "Mobile Safari", "533.1", "en", "us"},
      {"401", "Mozilla/5.0 (Linux; Android 4.4.2; VS415PP Build/KOT49I.VS415PP1) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/31.0.1650.59 Mobile Safari/537.36", "Android", "4.4.2", "LG", "Optimus", "Smartphone", "Chrome", "31.0.1650.59", "None", "None"},
      {"402", "Mozilla/5.0 (Linux; U; Android 3.1; en-us; LG-V909 Build/HMJ37) AppleWebKit/534.13 (KHTML, like Gecko) Version/4.0 Safari/534.13", "Android", "3.1", "LG", "Optimus", "Tablet", "Safari", "534.13", "en", "us"},
      {"403", "Mozilla/5.0 (Linux; U; Android 4.4.2; fr-fr; LGLS740 Build/KOT49I.LS740ZV4) AppleWebKit/537.36 (KHTML, like Gecko) Version/4.0 Chrome/30.0.1599.103 Mobile Safari/537.36", "Android", "4.4.2", "LG", "Volt", "Smartphone", "Chrome", "30.0.1599.103", "fr", "fr"},
      {"404", "Mozilla/5.0 (Linux; U; Android 4.0.3; zh-cn; Amaze_4G Build/IML74K) AppleWebKit/534.30 (KHTML, like Gecko) Version/4.0 Mobile Safari/534.30", "Android", "4.0.3", "HTC", "Amaze", "Smartphone", "Mobile Safari", "534.30", "zh", "cn"},
      {"405", "Mozilla/5.0 (Linux; U; Android 4.4.2; en-us; HTCDESIRE Build/KOT49H) AppleWebKit/534.30 (KHTML, like Gecko) Version/4.0 Mobile Safari/534.30", "Android", "4.4.2", "HTC", "Desire", "Smartphone", "Mobile Safari", "534.30", "en", "us"},
      {"406", "Mozilla/5.0 (Linux; U; Android 4.4.2; fr-ca; HTC_Desire_601-parrot Build/KOT49H) AppleWebKit/534.30 (KHTML, like Gecko) Version/4.0 Mobile Safari/534.30", "Android", "4.4.2", "HTC", "Desire", "Smartphone", "Mobile Safari", "534.30", "fr", "ca"},
      {"407", "Mozilla/5.0 (Linux; U; Android 2.3.3; en-us; Desire HD Build/GRI40) AppleWebKit/533.1 (KHTML, like Gecko) Version/4.0 Mobile Safari/533.1", "Android", "2.3.3", "HTC", "Desire", "Smartphone", "Mobile Safari", "533.1", "en", "us"},
      {"408", "Mozilla/5.0 (Linux; U; Android 2.3.3; en-us; pcdadr6350 Build/GRI40) AppleWebKit/533.1 (KHTML, like Gecko) Version/4.0 Mobile Safari/533.1", "Android", "2.3.3", "HTC", "Droid", "Smartphone", "Mobile Safari", "533.1", "en", "us"},
      {"409", "Mozilla/5.0 (Linux; U; Android 4.1.1; en-us; EVO Build/JRO03C) AppleWebKit/534.30 (KHTML, like Gecko) Version/4.0 Mobile Safari/534.30", "Android", "4.1.1", "HTC", "Evo", "Smartphone", "Mobile Safari", "534.30", "en", "us"},
      {"410", "Mozilla/5.0 (Linux; U; Android 4.0.3; en-us; Sprint APC715CKT Build/IML74K) AppleWebKit/534.30 (KHTML, like Gecko) Version/4.0 Mobile Safari/534.30", "Android", "4.0.3", "HTC", "Evo Design", "Smartphone", "Mobile Safari", "534.30", "en", "us"},
      {"411", "Mozilla/5.0 (Linux; Android 4.2.2; C525c Build/JDQ39) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/28.0.1500.94 Mobile Safari/537.36", "Android", "4.2.2", "HTC", "One", "Smartphone", "Chrome", "28.0.1500.94", "None", "None"},
      {"412", "Mozilla/5.0 (Linux; U; Android 4.4.2; pt-us; HTC_PN07120/5.12.502.2 Build/KOT49H) AppleWebKit/534.30 (KHTML, like Gecko) Version/4.0 Mobile Safari/534.30", "Android", "4.4.2", "HTC", "One M7", "Smartphone", "Mobile Safari", "534.30", "pt", "us"},
      {"413", "Mozilla/5.0 (Linux; U; Android 4.1.1; es-us; M7 Build/JRO03H) AppleWebKit/534.30 (KHTML, like Gecko) Version/4.0 Safari/534.30", "Android", "4.1.1", "HTC", "One M7", "Smartphone", "Safari", "534.30", "es", "us"},
      {"414", "Mozilla/5.0 (Linux; U; Android 2.3.5; en-fr; HTC_Rhyme_S510b Build/GRJ90) AppleWebKit/533.1 (KHTML, like Gecko) Version/4.0 Mobile Safari/533.1", "Android", "2.3.5", "HTC", "Rhyme", "Smartphone", "Mobile Safari", "533.1", "en", "fr"},
      {"415", "Mozilla/5.0 (Linux; U; Android 4.4.2; en-us; 0PAJ5 Build/KOT49H) AppleWebKit/534.30 (KHTML, like Gecko) Version/4.0 Mobile Safari/534.30", "Android", "4.4.2", "HTC", "One M8", "Smartphone", "Mobile Safari", "534.30", "en", "us"},
      {"416", "Mozilla/5.0 (Linux; Android 4.1.2; Nokia_XL Build/JZO54K) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/30.0.1599.82 Mobile Safari/537.36 NokiaBrowser/1.0.1.54", "Android", "4.1.2", "Nokia", "XL", "Smartphone", "NokiaBrowser", "1.0.1.54", "None", "None"},
      {"417", "Mozilla/5.0 (Linux; U; Android 4.1.2; en-us; N800 Build/JZO54K) AppleWebKit/534.30 (KHTML, like Gecko) Version/4.0 Mobile Safari/534.30", "Android", "4.1.2", "Nokia", "N800", "Tablet", "Mobile Safari", "534.30", "en", "us"},
      {"418", "Mozilla/5.0 (Linux; U; Android 4.3; en-us; N9002 Build/JDQ39) AppleWebKit/534.30 (KHTML, like Gecko) Version/4.0 Mobile Safari/534.30", "Android", "4.3", "Samsung", "Galaxy Note", "Smartphone", "Mobile Safari", "534.30", "en", "us"},
      {"419", "Mozilla/5.0 (Linux; U; Android 2.3.5; en-us; N860 Build/GINGERBREAD) AppleWebKit/533.1 (KHTML, like Gecko) Version/4.0 Mobile Safari/533.1", "Android", "2.3.5", "ZTE", "Warp", "Smartphone", "Mobile Safari", "533.1", "en", "us"},
      {"420", "Mozilla/5.0 (Linux; U; Android 4.3; en-us; HUAWEI Y336-A1 Build/HuaweiY336-A1) AppleWebKit/534.30 (KHTML, like Gecko) Version/4.0 Mobile Safari/534.30", "Android", "4.3", "Huawei", "Ascend", "Smartphone", "Mobile Safari", "534.30", "en", "us"},
      {"421", "Mozilla/5.0 (Linux; U; Android 4.1.1; en-us; Orange Daytona Build/C224B197) AppleWebKit/534.30 (KHTML, like Gecko) Version/4.0 Mobile Safari/534.30", "Android", "4.1.1", "Huawei", "Orange Daytona", "Smartphone", "Mobile Safari", "534.30", "en", "us"},
      {"422", "Mozilla/5.0 (Linux; U; Android 4.0.3; en-us; SpringBoard Build/HuaweiMediaPad) AppleWebKit/534.30 (KHTML, like Gecko) Version/4.0 Safari/534.30", "Android", "4.0.3", "Huawei", "SpringBoard", "Smartphone", "Safari", "534.30", "en", "us"},
      {"423", "Mozilla/5.0 (Linux; U; Android 2.3.4; en-; IM-A760S Build/GINGERBREAD) AppleWebKit/533.1 (KHTML, like Gecko) Version/4.0 Mobile Safari/533.1", "Android", "2.3.4", "Pantech", "Sky Vega Racer", "Smartphone", "Mobile Safari", "533.1", "en", "None"},
      {"424", "Mozilla/5.0 (Linux; U; Android 2.2.1; en-us; PantechP8000 Build/FRG83) AppleWebKit/533.1 (KHTML, like Gecko) Version/4.0 Mobile Safari/533.1", "Android", "2.2.1", "Pantech", "Crossover Adventure", "Smartphone", "Mobile Safari", "533.1", "en", "us"},
      {"425", "Mozilla/5.0 (Linux; Android 4.1.1; Le Pan S Build/JRO03L) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/39.0.2171.93 Safari/537.36", "Android", "4.1.1", "Matsunichi", "Le Pan S", "Tablet", "Chrome", "39.0.2171.93", "None", "None"},
      {"426", "Mozilla/5.0 (Linux; Android 4.1.1; M97 Build/JRO03L) AppleWebKit/535.19 (KHTML, like Gecko) Chrome/18.0.1025.166  Safari/535.19", "Android", "4.1.1", "Matsunichi", "Le Pan", "Tablet", "Chrome", "18.0.1025.166", "None", "None"},
      {"427", "Mozilla/5.0 (Linux; Android 4.2.2; HG-9041 Build/JDQ39) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/28.0.1500.94 Safari/537.36", "Android", "4.2.2", "Haier", "HG-9041", "Tablet", "Chrome", "28.0.1500.94", "None", "None"},
      {"428", "Mozilla/5.0 (Linux; U; Android 4.2.2; en-us; ALCATEL 4015T Build/JDQ39) AppleWebKit/534.30 (KHTML, like Gecko) Version/4.2 Mobile Safari/534.30", "Android", "4.2.2", "Alcatel", "C1", "Smartphone", "Mobile Safari", "534.30", "en", "us"},
      {"429", "Mozilla/5.0 (Linux; U; Android 4.2.2; en-us; ALCATEL ONE TOUCH Fierce Build/JDQ39) AppleWebKit/533.1 (KHTML, like Gecko) Version/4.0 UCBrowser/9.9.2.467 U3/0.8.0 Mobile Safari/533.1", "Android", "4.2.2", "Alcatel", "OneTouch", "Smartphone", "UCBrowser", "9.9.2.467", "en", "us"},
      {"430", "Mozilla/5.0 (Linux; U; Android 4.2.2; en-us; ALCATEL ONETOUCH P310A Build/JDQ39) AppleWebKit/534.30 (KHTML, like Gecko) Version/4.2 Mobile Safari/534.30", "Android", "4.2.2", "Alcatel", "OneTouch", "Tablet", "Mobile Safari", "534.30", "en", "us"},
      {"431", "Dalvik/1.6.0 (Linux; U; Android 4.4.2; Venue 7 3730 Build/KOT49H)", "Android", "4.4.2", "Dell", "Venue", "Tablet", "Dalvik", "1.6.0", "None", "None"},
      {"432", "Mozilla/5.0 (Linux; Android 4.4.4; Venue7 3740 Build/KTU84P) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/35.0.1916.141 Safari/537.36", "Android", "4.4.4", "Dell", "Venue", "Tablet", "Chrome", "35.0.1916.141", "None", "None"},
      {"433", "Mozilla/5.0 (Linux; U; Android 4.2.2; en-us; Venue 8 3830 Build/JDQ39) AppleWebKit/534.30 (KHTML, like Gecko) Version/4.0 Safari/534.30", "Android", "4.2.2", "Dell", "Venue", "Tablet", "Safari", "534.30", "en", "us"},
      {"434", "Mozilla/5.0 (Linux; Android 4.4.4; Venue8 3840 Build/KTU84P) AppleWebKit/537.36 (KHTML, like Gecko) Version/4.0 Chrome/33.0.0.0 Safari/537.36", "Android", "4.4.4", "Dell", "Venue", "Tablet", "Chrome", "33.0.0.0", "None", "None"},
      {"435", "Dalvik/1.6.0 (Linux; U; Android 4.4.4; SGP612 Build/23.0.1.A.0.167)", "Android", "4.4.4", "Sony", "Xperia Z3", "Tablet", "Dalvik", "1.6.0", "None", "None"},
      {"436", "Mozilla/5.0 (Linux; U; Android 4.0.3; en-us; SGPT12 Build/TISU0105) AppleWebKit/534.30 (KHTML, like Gecko) Version/4.0 Safari/534.30", "Android", "4.0.3", "Sony", "Xperia S", "Tablet", "Safari", "534.30", "en", "us"},
      {"437", "Mozilla/5.0 (Linux; U; Android 2.3.4; en-us; SonyEricssonLT18i Build/4.0.2.A.0.62) AppleWebKit/533.1 (KHTML, like Gecko) Version/4.0 Mobile Safari/533.1", "Android", "2.3.4", "Sony", "Xperia Arc S", "Smartphone", "Mobile Safari", "533.1", "en", "us"},
      {"438", "Mozilla/5.0 (Linux; U; Android 2.3.4; en-us; SonyEricssonLT18i-o Build/4.0.2.A.0.62) AppleWebKit/533.1 (KHTML, like Gecko) Version/4.0 Mobile Safari/533.1", "Android", "2.3.4", "Sony", "Xperia Arc S", "Smartphone", "Mobile Safari", "533.1", "en", "us"},
      {"439", "Mozilla/5.0 (Linux; U; Android 2.3.4; en-us; SonyEricssonR800x Build/4.0.2.E.0.57) AppleWebKit/533.1 (KHTML, like Gecko) Version/4.0 Mobile Safari/533.1", "Android", "2.3.4", "Sony", "Xperia Play", "Smartphone", "Mobile Safari", "533.1", "en", "us"},
      {"440", "Mozilla/5.0 (Linux; U; Android 2.3.7; en-us; SonyEricssonLT28at Build/6.0.C.1.257) AppleWebKit/533.1 (KHTML, like Gecko) Version/4.0 Mobile Safari/533.1", "Android", "2.3.7", "Sony", "Xperia Ion LTE", "Smartphone", "Mobile Safari", "533.1", "en", "us"},
      {"441", "Mozilla/5.0 (Linux; U; Android 2.3.7; en-us; SonyEricssonST25a Build/6.0.B.3.184) AppleWebKit/533.1 (KHTML, like Gecko) Version/4.0 Mobile Safari/533.1", "Android", "2.3.7", "Sony", "Xperia U", "Smartphone", "Mobile Safari", "533.1", "en", "us"},
      {"442", "Mozilla/5.0 (Linux; Android 4.0.3; Sony Tablet S Build/TISU0143) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/34.0.1847.114 Safari/537.36", "Android", "4.0.3", "Sony", "Xperia S", "Tablet", "Chrome", "34.0.1847.114", "None", "None"},
      {"443", "Mozilla/5.0 (Linux; U; Android 4.0.4; en-us; SonyST21a Build/11.0.A.4.22) AppleWebKit/534.30 (KHTML, like Gecko) Version/4.0 Mobile Safari/534.30", "Android", "4.0.4", "Sony", "Xperia Tipo", "Smartphone", "Mobile Safari", "534.30", "en", "us"},
      {"444", "Mozilla/5.0 (Linux; U; Android 4.1.2; en-us; SonyLT26ii Build/6.2.B.1.96) AppleWebKit/534.30 (KHTML, like Gecko) Version/4.0 Mobile Safari/534.30", "Android", "4.1.2", "Sony", "Xperia SL", "Smartphone", "Mobile Safari", "534.30", "en", "us"},
      {"445", "Mozilla/5.0 (Linux; U; Android 4.1.2; en-us; SonyLT30at Build/9.1.F.1.120) AppleWebKit/534.30 (KHTML, like Gecko) Version/4.0 Mobile Safari/534.30", "Android", "4.1.2", "Sony", "Xperia TL", "Smartphone", "Mobile Safari", "534.30", "en", "us"},
      {"446", "Mozilla/5.0 (Linux; Android 4.1.2; C2104 Build/15.0.A.2.17) AppleWebKit/537.31 (KHTML, like Gecko) Chrome/26.0.1410.58 Mobile Safari/537.31", "Android", "4.1.2", "Sony", "Xperia", "Smartphone", "Chrome", "26.0.1410.58", "None", "None"},
      {"447", "Mozilla/5.0 (Linux; Android 4.2.2; C2105 Build/15.3.A.1.14) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/28.0.1500.94 Mobile Safari/537.36", "Android", "4.2.2", "Sony", "Xperia", "Smartphone", "Chrome", "28.0.1500.94", "None", "None"},
      {"448", "Mozilla/5.0 (Linux; Android 5.0; C6806_GPe Build/LRX21P.S3) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/39.0.2171.93 Mobile Safari/537.36", "Android", "5.0", "Sony", "Z Ultra", "Smartphone", "Chrome", "39.0.2171.93", "None", "None"},
      {"449", "Mozilla/5.0 (Linux; Android 4.1.2; LT22i Build/6.2.A.1.100) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/40.0.2214.89 Mobile Safari/537.36", "Android", "4.1.2", "Sony", "Xperia", "Smartphone", "Chrome", "40.0.2214.89", "None", "None"},
      {"450", "Mozilla/5.0 (Linux; Android 4.0.4; LT28at Build/6.1.C.1.111) AppleWebKit/535.19 (KHTML, like Gecko) Chrome/18.0.1025.166 Mobile Safari/535.19", "Android", "4.0.4", "Sony", "Xperia", "Smartphone", "Chrome", "18.0.1025.166", "None", "None"},
      {"451", "Mozilla/5.0 (Linux; Android 4.1.2; LT30at Build/9.1.F.1.120) AppleWebKit/535.19 (KHTML, like Gecko) Chrome/18.0.1025.166 Mobile Safari/535.19", "Android", "4.1.2", "Sony", "Xperia", "Smartphone", "Chrome", "18.0.1025.166", "None", "None"},
      {"452", "Mozilla/5.0 (Linux; Android 4.1.2; ST26a Build/11.2.A.0.31) AppleWebKit/535.19 (KHTML, like Gecko) Chrome/18.0.1025.166 Mobile Safari/535.19", "Android", "4.1.2", "Sony", "Xperia", "Smartphone", "Chrome", "18.0.1025.166", "None", "None"},
      {"453", "Mozilla/5.0 (Linux; Android 4.1.2; ST26i Build/11.2.A.0.31) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/39.0.2171.93 Mobile Safari/537.36", "Android", "4.1.2", "Sony", "Xperia", "Smartphone", "Chrome", "39.0.2171.93", "None", "None"},
      {"454", "Mozilla/5.0 (Linux; Android 4.4.2; D5316 Build/19.1.A.0.486) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/39.0.2171.93 Mobile Safari/537.36", "Android", "4.4.2", "Sony", "Xperia T2", "Smartphone", "Chrome", "39.0.2171.93", "None", "None"},
      {"455", "Mozilla/5.0 (Linux; Android 4.2.2; Trio AXS 3G Build/JDQ39) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/37.0.2062.117 Safari/537.36", "Android", "4.2.2", "Mach Speed", "AXS 3G", "Tablet", "Chrome", "37.0.2062.117", "None", "None"},
      {"456", "Mozilla/5.0 (Linux; U; Android 4.2.2; en-us; Trio AXS 4G Build/JDQ39) AppleWebKit/534.30 (KHTML, like Gecko) Version/4.0 Safari/534.30", "Android", "4.2.2", "Mach Speed", "AXS 4G", "Tablet", "Safari", "534.30", "en", "us"},
      {"457", "Mozilla/5.0 (Linux; Android 4.4.2; Trio 7.85 vQ Build/Trio_7.85_vQ) AppleWebKit/537.36 (KHTML, like Gecko) Version/4.0 Chrome/30.0.0.0 Safari/537.36", "Android", "4.4.2", "Mach Speed", "Trio Stealth G4", "Tablet", "Chrome", "30.0.0.0", "None", "None"},
      {"458", "Mozilla/5.0 (Linux; Android 4.4.2; Trio Stealth G4 7 Build/KOT49H) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/31.0.1650.59 Safari/537.36", "Android", "4.4.2", "Mach Speed", "Trio Stealth G4", "Tablet", "Chrome", "31.0.1650.59", "None", "None"},
      {"459", "Mozilla/5.0 (Linux; Android 4.4.2; Trio Stealth G4 7 v2 Build/KOT49H) AppleWebKit/537.36 (KHTML, like Gecko) Version/4.0 Chrome/30.0.0.0 Safari/537.36", "Android", "4.4.2", "Mach Speed", "Trio Stealth G4", "Tablet", "Chrome", "30.0.0.0", "None", "None"},
      {"460", "Mozilla/5.0 (Linux; Android 4.4.2; TRIO-7.85 Build/KVT49L) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/35.0.1916.141 Safari/537.36", "Android", "4.4.2", "Mach Speed", "Trio Stealth G4", "Tablet", "Chrome", "35.0.1916.141", "None", "None"},
      {"461", "Mozilla/5.0 (Linux; Android 4.4.2; Trio-Stealth G4 10.1 Build/KOT49H) AppleWebKit/537.36 (KHTML, like Gecko) Version/4.0 Chrome/30.0.0.0 Safari/537.36", "Android", "4.4.2", "Mach Speed", "Trio Stealth G4", "Tablet", "Chrome", "30.0.0.0", "None", "None"},
      {"462", "Mozilla/5.0 (Linux; U; Android 4.1.1; en-us; Trio Stealth_10 Build/JR003C.20130630) AppleWebKit/534.30 (KHTML, like Gecko) Version/4.0 Safari/534.30", "Android", "4.1.1", "Mach Speed", "Trio Stealth G2", "Tablet", "Safari", "534.30", "en", "us"},
      {"463", "Mozilla/5.0 (Linux; U; Android 4.1.1; en-us; Trio Stealth_8 Build/JR003C.20131024) AppleWebKit/534.30 (KHTML, like Gecko) Version/4.0 Safari/534.30", "Android", "4.1.1", "Mach Speed", "Trio Stealth G2", "Tablet", "Safari", "534.30", "en", "us"},
      {"464", "Mozilla/5.0 (Linux; Android 4.4.2; JLab PRO-7 Build/KOT49H) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/35.0.1916.141 Safari/537.36", "Android", "4.4.2", "Mach Speed", "JLab Pro", "Tablet", "Chrome", "35.0.1916.141", "None", "None"},
      {"465", "Mozilla/5.0 (Linux; Android 4.4.2; X-treme Play Tab Build/KOT49H) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/39.0.2171.93 Safari/537.36", "Android", "4.4.2", "Mach Speed", "Xtreme Play Tab", "Tablet", "Chrome", "39.0.2171.93", "None", "None"},
      {"466", "Mozilla/5.0 (Linux; Android 4.1.1; HP Slate 7 Build/JRO03H) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/40.0.2214.109 Safari/537.36", "Android", "4.1.1", "HP", "Slate 7", "Tablet", "Chrome", "40.0.2214.109", "None", "None"},
      {"467", "Mozilla/5.0 (Linux; Android 4.2.2; HP 7 Plus Build/1.1.5_WW-ILEX-11) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/28.0.1500.94 Safari/537.36", "Android", "4.2.2", "HP", "7 G2", "Tablet", "Chrome", "28.0.1500.94", "None", "None"},
      {"468", "Mozilla/5.0 (Linux; U; Android 4.2.2; en-us; HP Slate 10 HD Build/JDQ39) AppleWebKit/534.30 (KHTML, like Gecko) Version/4.0 Safari/534.30", "Android", "4.2.2", "HP", "Slate 10", "Tablet", "Safari", "534.30", "en", "us"},
      {"469", "Mozilla/5.0 (Linux; Android 4.2.2; HP Slate 7 HD Build/JDQ39) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/28.0.1500.94 Safari/537.36", "Android", "4.2.2", "HP", "Slate 7", "Tablet", "Chrome", "28.0.1500.94", "None", "None"},
      {"470", "Mozilla/5.0 (Linux; U; Android 4.2.2; en-us; HP Slate 7 Plus Build/JDQ39) AppleWebKit/534.30 (KHTML, like Gecko) Version/4.0 Safari/534.30", "Android", "4.2.2", "HP", "Slate 7", "Tablet", "Safari", "534.30", "en", "us"},
      {"471", "Mozilla/5.0 (Linux; Android 4.2.2; Slate 21 Build/JDQ39) AppleWebKit/537.31 (KHTML, like Gecko) Chrome/26.0.1410.58 Safari/537.31", "Android", "4.2.2", "HP", "Slate 21", "PC", "Chrome", "26.0.1410.58", "None", "None"},
      {"472", "Mozilla/5.0 (Linux; U; Android 4.3; en-us; Slate 21 Pro Build/JSS15J) AppleWebKit/534.30 (KHTML, like Gecko) Version/4.0 Safari/534.30", "Android", "4.3", "HP", "Slate 21", "PC", "Safari", "534.30", "en", "us"},
      {"473", "Mozilla/5.0 (Linux; Android 4.3; HP SlateBook 10 x2 PC Build/4.3-17r20-05-24) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/38.0.2125.102 Safari/537.36", "Android", "4.3", "HP", "SlateBook 10", "PC", "Chrome", "38.0.2125.102", "None", "None"},
      {"474", "Mozilla/5.0 (Linux; Android 4.3; HP SlateBook 14 PC Build/4.3-17r21-15-15) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/38.0.2125.102 Safari/537.36", "Android", "4.3", "HP", "SlateBook 14", "PC", "Chrome", "38.0.2125.102", "None", "None"},
      {"475", "Mozilla/5.0 (Linux; Android 4.4.2; HP 10 Build/KOT49H) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/40.0.2214.109 Safari/537.36", "Android", "4.4.2", "HP", "10", "Tablet", "Chrome", "40.0.2214.109", "None", "None"},
      {"476", "Mozilla/5.0 (Linux; Android 4.4.2; HP 10 Plus Build/KOT49H) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/39.0.2171.93 Safari/537.36", "Android", "4.4.2", "HP", "10 Plus", "Tablet", "Chrome", "39.0.2171.93", "None", "None"},
      {"477", "Mozilla/5.0 (Linux; Android 4.4.2; HP 7 G2 Build/KVT49L) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/40.0.2214.89 Safari/537.36", "Android", "4.4.2", "HP", "G2", "Tablet", "Chrome", "40.0.2214.89", "None", "None"},
      {"478", "Mozilla/5.0 (Linux; Android 4.4.2; HP 8 G2 Build/KVT49L) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/39.0.2171.93 Safari/537.36", "Android", "4.4.2", "HP", "G2", "Tablet", "Chrome", "39.0.2171.93", "None", "None"},
      {"479", "Mozilla/5.0 (Linux; Android 4.4.2; HP Slate 7 Beats Special Edition Build/KOT49H) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/31.0.1650.59 Safari/537.36", "Android", "4.4.2", "HP", "Slate 7", "Tablet", "Chrome", "31.0.1650.59", "None", "None"},
      {"480", "Mozilla/5.0 (Linux; Android 4.4.2; HP Slate7 Extreme Build/KOT49H) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/36.0.1985.135 Safari/537.36", "Android", "4.4.2", "HP", "Slate 7 Extreme", "Tablet", "Chrome", "36.0.1985.135", "None", "None"},
      {"481", "Mozilla/5.0 (Linux; Android 4.4.4; TouchPad Build/KTU84Q) AppleWebKit/537.36 (KHTML, like Gecko) Version/4.0 Chrome/33.0.0.0 Safari/537.36", "Android", "4.4.4", "HP", "TouchPad", "Tablet", "Chrome", "33.0.0.0", "None", "None"},
      {"482", "Mozilla/5.0 (Linux; U; Android 4.1.1; en-us; HP Slate 7 Build/JRO03H) AppleWebKit/534.30 (KHTML, like Gecko) Version/4.0 Safari/534.30", "Android", "4.1.1", "HP", "Slate 7", "Tablet", "Safari", "534.30", "en", "us"},
      {"483", "Mozilla/5.0 (Linux; U; Android 4.1.2; en-us; HP 7 Build/JZO54K) AppleWebKit/534.30 (KHTML, like Gecko) Version/4.0 Safari/534.30", "Android", "4.1.2", "HP", "7", "Tablet", "Safari", "534.30", "en", "us"},
      {"484", "Mozilla/5.0 (Linux; U; Android 4.0.3; en-us; cm_tenderloin Build/GWK74) AppleWebKit/534.30 (KHTML, like Gecko) Version/4.0 Safari/534.30", "Android", "4.0.3", "HP", "TouchPad", "Tablet", "Safari", "534.30", "en", "us"},
      {"485", "Mozilla/5.0 (Linux; Android 4.4.2; E6782 Build/KOT49H) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/35.0.1916.122 Mobile Safari/537.36", "Android", "4.4.2", "Kyocera", "Brigadier", "Smartphone", "Chrome", "35.0.1916.122", "None", "None"},
      {"486", "Mozilla/5.0 (Linux; Android 4.4.2; KYOCERA-E6560 Build/KVT49L) AppleWebKit/537.36 (KHTML, like Gecko) Version/4.0 Chrome/30.0.0.0 Mobile Safari/537.36", "Android", "4.4.2", "Kyocera", "DuraForce", "Smartphone", "Chrome", "30.0.0.0", "None", "None"},
      {"487", "Mozilla/5.0 (Linux; U; Android 4.0.4; en-us; C5170 Build/IML77) AppleWebKit/534.30 (KHTML, like Gecko) Version/4.0 Mobile Safari/534.30", "Android", "4.0.4", "Kyocera", "Hydro", "Smartphone", "Mobile Safari", "534.30", "en", "us"},
      {"488", "Mozilla/5.0 (Linux; U; Android 4.1.2; en-us; C5215 Build/JZO54K) AppleWebKit/534.30 (KHTML, like Gecko) Version/4.0 Mobile Safari/534.30", "Android", "4.1.2", "Kyocera", "Hydro", "Smartphone", "Mobile Safari", "534.30", "en", "us"},
      {"489", "Mozilla/5.0 (Linux; U; Android 4.1.2; es-us; C6522N Build/JZO54K) AppleWebKit/534.30 (KHTML, like Gecko) Version/4.0 Mobile Safari/534.30", "Android", "4.1.2", "Kyocera", "Hydro", "Smartphone", "Mobile Safari", "534.30", "es", "us"},
      {"490", "Mozilla/5.0 (Linux; Android 4.3; C6530 Build/JLS36C) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/37.0.2062.117 Mobile Safari/537.36", "Android", "4.3", "Kyocera", "Hydro Life", "Smartphone", "Chrome", "37.0.2062.117", "None", "None"},
      {"491", "Mozilla/5.0 (Linux; U; Android 4.3; en-us; C6530N Build/JLS36C) AppleWebKit/534.30 (KHTML, like Gecko) Version/4.0 Mobile Safari/534.30", "Android", "4.3", "Kyocera", "Hydro Life", "Smartphone", "Mobile Safari", "534.30", "en", "us"},
      {"492", "Mozilla/5.0 (Linux; U; Android 4.3; en-us; C6725 Build/JLS36C) AppleWebKit/534.30 (KHTML, like Gecko) Version/4.0 Mobile Safari/534.30", "Android", "4.3", "Kyocera", "Hydro Vibe", "Smartphone", "Mobile Safari", "534.30", "en", "us"},
      {"493", "Mozilla/5.0 (Linux; U; Android 4.3; en-us; C6730 Build/JLS36C) AppleWebKit/534.30 (KHTML, like Gecko) Version/4.0 Mobile Safari/534.30", "Android", "4.3", "Kyocera", "Hydro Icon", "Smartphone", "Mobile Safari", "534.30", "en", "us"},
      {"494", "Mozilla/5.0 (Linux; Android 4.1.2; C6750 Build/JZO54K) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/28.0.1500.94 Mobile Safari/537.36", "Android", "4.1.2", "Kyocera", "Hydro Elite", "Smartphone", "Chrome", "28.0.1500.94", "None", "None"},
      {"495", "Mozilla/5.0 (Linux; U; Android 2.3.6; en-us; C5120 Build/GRK39F) AppleWebKit/533.1 (KHTML, like Gecko) Version/4.0 Mobile Safari/533.1", "Android", "2.3.6", "Kyocera", "Milano", "Smartphone", "Mobile Safari", "533.1", "en", "us"},
      {"496", "Mozilla/5.0 (Linux; U; Android 2.3.4; en-us; C5121 Build/GINGERBREAD) AppleWebKit/533.1 (KHTML, like Gecko) Version/4.0 Mobile Safari/533.1", "Android", "2.3.4", "Kyocera", "Milano", "Smartphone", "Mobile Safari", "533.1", "en", "us"},
      {"497", "Mozilla/5.0 (Linux; U; Android 4.0.4; en-us; C5155 Build/IML77) AppleWebKit/534.30 (KHTML, like Gecko) Version/4.0 Mobile Safari/534.30", "Android", "4.0.4", "Kyocera", "Rise", "Smartphone", "Mobile Safari", "534.30", "en", "us"},
      {"498", "Mozilla/5.0 (Macintosh; U; Intel Mac OS X 10.5; en; rv:1.9.0.18) Gecko/2010021619 Camino/2.0.2 (like Firefox/3.0.18)", "Macintosh", "Unknown", "Unknown", "Unknown", "Unknown", "Camino", "2.0.2", "en", "None"},
      {"499", "Mozilla/5.0 (Windows NT 6.1; rv:11.0) Gecko/20100101 Firefox/11.0 CometBird/11.0", "Windows", "7", "Unknown", "Unknown", "PC", "CometBird", "11.0", "None", "None"},
      {"500", "Mozilla/5.0 (Windows NT 6.0) AppleWebKit/537.36 (KHTML, like Gecko) Dragon/36.1.1.21 Chrome/36.0.1985.97 Safari/537.36", "Windows", "Vista", "Unknown", "Unknown", "PC", "Dragon", "36.1.1.21", "None", "None"},
      {"501", "Mozilla/5.0 (Windows NT 6.1) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/40.0.2214.115 YaBrowser/15.2.2214.3645 Safari/537.36", "Windows", "7", "Unknown", "Unknown", "PC", "YaBrowser", "15.2.2214.3645", "None", "None"},
      {"502", "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/39.0.2100.0 Iron/39.0.2100.0 Safari/537.36", "Windows", "7", "Unknown", "Unknown", "PC", "Iron", "39.0.2100.0", "None", "None"},
      {"503", "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Diglo/28.0.1479.327 Chrome/28.0.1479.0 Safari/537.36", "Windows", "7", "Unknown", "Unknown", "PC", "Diglo", "28.0.1479.327", "None", "None"},
      {"504", "Mozilla/5.0 (Linux; Android 4.1.2; zu-ZA; Nokia_XL Build/JZO54K) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/30.0.1599.82 Mobile Safari/537.36 NokiaBrowser/1.0.1.54", "Android", "4.1.2", "Nokia", "XL", "Smartphone", "NokiaBrowser", "1.0.1.54", "zu", "za"},
      {"505", "Mozilla/5.0 (Linux; Android 5.0.2; en-ZW; SAMSUNG SM-G920P Build/LRX22G) AppleWebKit/537.36 (KHTML, like Gecko) SamsungBrowser/3.0 Chrome/38.0.2125.102 Mobile Safari/537.36", "Android", "5.0.2", "Samsung", "Galaxy S6", "Smartphone", "SamsungBrowser", "3.0", "en", "zw"},
      {"506", "Mozilla/5.0 (Linux; Android 4.4.4; ru-RU; GT-P3110 Build/KTU84Q) AppleWebKit/537.36 (KHTML, like Gecko) Version/4.0 Chrome/33.0.0.0 Safari/537.36 baidubrowser/5.2.2.1 (Baidu; P1 4.4.4)", "Android", "4.4.4", "Samsung", "Galaxy Tab 2", "Tablet", "Baidu", "5.2.2.1", "ru", "ru"},
      {"507", "Mozilla/5.0 (Windows Phone 10.0; Android 4.2.1; NOKIA; Lumia 830) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/39.0.2171.71 Mobile Safari/537.36 Edge/12.0", "Windows Phone", "10.0", "Unknown", "Lumia", "Smartphone", "Edge", "12.0", "None", "None"},
    });
  }

  @Test
  public void testOS() {
    uap.parse(ua);
    assertEquals(os, uap.getOperatingSystem());
  }

  @Test
  public void testOSVersion() {
    uap.parse(ua);
    assertEquals(osv, uap.getOsVersion());
  }

  @Test
  public void testMake() {
    uap.parse(ua);
    assertEquals(make, uap.getProductMake());
  }

  @Test
  public void testModel() {
    uap.parse(ua);
    assertEquals(model, uap.getProductModel());
  }

  @Test
  public void testDevice() {
    uap.parse(ua);
    assertEquals(device, uap.getDeviceType());
  }

  @Test
  public void testBrowser() {
    uap.parse(ua);
    assertEquals(browser, uap.getBrowserName());
  }

  @Test
  public void testBrowserVersion() {
    uap.parse(ua);
    assertEquals(bv, uap.getBrowserVersion());
  }

  @Test
  public void testLang() {
    uap.parse(ua);
    assertEquals(lang, uap.getLanguage());
  }

  @Test
  public void testCountry() {
    uap.parse(ua);
    assertEquals(country, uap.getCountry());
  }
}
