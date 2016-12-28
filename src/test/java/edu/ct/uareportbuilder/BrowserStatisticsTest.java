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

import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.BeforeClass;

/**
 *
 * @author Steve
 */
public class BrowserStatisticsTest {
  private static BrowserStatistics stats = new BrowserStatistics();
  private static UserAgentParser uap = new UserAgentParser();
  
  @BeforeClass
  public static void testSetup() {
    // 1. IE11 on Windows 7
    String header = "Mozilla/5.0 (Windows NT 6.1; Trident/7.0; rv:11.0) like Gecko";
    uap.parse(header);
    stats.analyze(uap.getBrowserDetails());
    
    // 2. IE11 on 64-bit Windows 8.1 Update
    header = "Mozilla/5.0 (Windows NT 6.3; Win64, x64; Trident/7.0; Touch; rv:11.0) like Gecko";
    uap.parse(header);
    stats.analyze(uap.getBrowserDetails());
    
    // 3. IE11 for the desktop on 64-bit Windows 8.1 Update
    header = "Mozilla/5.0 (Windows NT 6.3; WOW64; Trident/7.0; Touch; rv:11.0) like Gecko";
    uap.parse(header);
    stats.analyze(uap.getBrowserDetails());
    
    // 4. IE11 version number defined by rv attribute
    header = "Mozilla/5.0 (Windows NT 6.1; WOW64; Trident/7.0; rv:11.0) like Gecko";
    uap.parse(header);
    stats.analyze(uap.getBrowserDetails());
    
    // 5. IE11 on Windows Phone
    header = "Mozilla/5.0 (Windows Phone 8.1; ARM; Trident/7.0; Touch; rv:11.0; IEMobile/11.0; NOKIA; Lumia 928) like Gecko";
    uap.parse(header);
    stats.analyze(uap.getBrowserDetails());
    
    // 6. IE11 on Windows Phone with WebBrowser 8.1
    header = "Mozilla/5.0 (Windows Phone 8.1; ARM; Trident/7.0; Touch; rv:11.0; WebBrowser/8.1; IEMobile/11.0; NOKIA; Lumia 1520) like Gecko";
    uap.parse(header);
    stats.analyze(uap.getBrowserDetails());
  
    // 7. IE10 Edge document mode
    header = "Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/39.0.2171.71 Safari/537.36 Edge/12.0";
    uap.parse(header);
    stats.analyze(uap.getBrowserDetails());
    
    // 8. IE10 for touch-enabled device
    header = "Mozilla/5.0 (compatible; MSIE 10.0; Windows NT 6.2; Trident/6.0; Touch)";
    uap.parse(header);
    stats.analyze(uap.getBrowserDetails());
    
    // 9. IE10 on Windows 7 (64 bit)
    header = "Mozilla/5.0 (compatible; MSIE 10.0; Windows NT 6.1; WOW64; Trident/6.0)";
    uap.parse(header);
    stats.analyze(uap.getBrowserDetails());
    
    // 10. IE10 on Windows 7 (64 bit) with "Enhanced Protection Mode" on
    header = "Mozilla/5.0 (compatible; MSIE 10.0; Windows NT 6.1; Win64; x64; Trident/6.0)";
    uap.parse(header);
    stats.analyze(uap.getBrowserDetails());
    
    // 11. IE10 on Windows 7 (64 bit) with "Enhanced Protection Mode" on
    header = "Mozilla/5.0 (compatible; MSIE 10.0; Windows NT 6.1; Win64; x64; Trident/6.0)";
    uap.parse(header);
    stats.analyze(uap.getBrowserDetails());
    
    // 12. IE on a Lumia 920 running Windows Phone 8.0, desktop version
    header = "Mozilla/5.0 (compatible; MSIE 10.0; Windows NT 6.2; Trident/6.0; ARM; Touch)";
    uap.parse(header);
    stats.analyze(uap.getBrowserDetails());
    
    // 13. IE on Xbox One
    header = "Mozilla/5.0 (compatible; MSIE 10.0; Windows NT 6.2; Trident/6.0; Xbox; Xbox One)";
    uap.parse(header);
    stats.analyze(uap.getBrowserDetails());
    
    // 14. Firefox 33 on Windows 7
    header = "Mozilla/5.0 (compatible; MSIE 10.0; Windows NT 6.1; Tri0101 Firefox/33.0";
    uap.parse(header);
    stats.analyze(uap.getBrowserDetails());
    
    // 15. IE10 on Windows Phone
    header = "Mozilla/5.0 (compatible; MSIE 10.0; Windows Phone 8.0; Trident/6.0; IEMobile/10.0; ARM; Touch; SAMSUNG; SPH-I800; SPRINT)";
    uap.parse(header);
    stats.analyze(uap.getBrowserDetails());
    
    // 16. IE9
    header = "Mozilla/5.0 (compatible; MSIE 9.0; Windows NT 6.1; Trident/5.0)";
    uap.parse(header);
    stats.analyze(uap.getBrowserDetails());
    
    // 17. IE9 on XBox
    header = "Mozilla/5.0 (compatible; MSIE 9.0; Windows NT 6.1; Trident/5.0; Xbox)";
    uap.parse(header);
    stats.analyze(uap.getBrowserDetails());
    
    // 18. IE9 on Windows 8
    header = "Mozilla/5.0 (compatible; MSIE 9.0; AOL 9.7; AOLBuild 4343.55; Windows NT 6.2; WOW64; Trident/7.0)";
    uap.parse(header);
    stats.analyze(uap.getBrowserDetails());
    
    // 19. IE9 on Windows 8
    header = "Mozilla/5.0 (compatible; MSIE 9.0; qdesk 2.4.1264.203; Windows NT 6.2; WOW64; Trident/6.0)";
    uap.parse(header);
    stats.analyze(uap.getBrowserDetails());
    
    // 20. IE9 on Windows 8.1 with Touch
    header = "Mozilla/5.0 (compatible; MSIE 9.0; Windows NT 6.3; WOW64; Trident/7.0; Touch; LCJB)";
    uap.parse(header);
    stats.analyze(uap.getBrowserDetails());
    
    // 21. IE8
    header = "Mozilla/4.0(compatible; MSIE 8.0; Windows NT 6.1; Trident/4.0; SLCC2; .NET CLR 2.0.50727)";
    uap.parse(header);
    stats.analyze(uap.getBrowserDetails());
    
    // 22. IE11 for the desktop on 64-bit Windows 8.1 Update with enterprise mode enabled
    header = "Mozilla/4.0 (compatible; MSIE 8.0; Windows NT 6.1; Trident/4.0; Tablet PC 2.0)";
    uap.parse(header);
    stats.analyze(uap.getBrowserDetails());
    
    // 23. IE8
    header = "Mozilla/4.0(compatible; MSIE 8.0; Windows NT 5.1; Trident/4.0; .NET CLR 1.0.3705; .NET CLR 1.1.4322; Media Center PC 4.0)";
    uap.parse(header);
    stats.analyze(uap.getBrowserDetails());
    
    // 24. 64-bit IE8 on 64-bit Windows
    header = "Mozilla/4.0 (compatible; MSIE 8.0; Windows NT 6.0; Win64; x64; Trident/4.0)";
    uap.parse(header);
    stats.analyze(uap.getBrowserDetails());
    
    // 25. 32-bit IE8 on 64-bit Windows
    header = "Mozilla/4.0(compatible; MSIE 8.0; Windows NT 6.0; WOW64; Trident/4.0; SLCC1; .NET CLR 2.0.50727; .NET CLR 3.5.30729; .NET CLR 3.0.30729; MS-RTC LM 8; MS-RTC EA 2)";
    uap.parse(header);
    stats.analyze(uap.getBrowserDetails());
    
    // 26. IE 8 (running in IE8 compatatbility mode)
    header = "Mozilla/4.0(compatible; MSIE 8.0; Windows NT 6.1; Win64; x64; Trident/4.0; .NET CLR 2.0.50727; SLCC2; .NET CLR 3.5.30729; .NET CLR 3.0.30729; .NET4.0C; .NET4.0E; InfoPath.3)";
    uap.parse(header);
    stats.analyze(uap.getBrowserDetails());
    
    // 27. IE8 on Windows XP with Google's Chrome Frame plugin to add HTML5 features
    header = "Mozilla/4.0(compatible; MSIE 8.0; Windows NT 5.1; Trident/4.0; chromeframe/15.0.874.102; .NET CLR 2.0.50727; .NET CLR 3.0.4506.2152; .NET CLR 3.5.30729)";
    uap.parse(header);
    stats.analyze(uap.getBrowserDetails());
    
    // 28. IE8 on Windows 7 Enterprize
    header = "Mozilla/4.0(compatible; MSIE 8.0; Windows NT 6.1; Trident/4.0; SLCC2; .NET CLR 2.0.50727; .NET CLR 3.5.30729; .NET CLR 3.0.30729; Media Center PC 6.0; Tablet PC 2.0; InfoPath.1)";
    uap.parse(header);
    stats.analyze(uap.getBrowserDetails());
    
    // 29. IE8 on Windows 7 (64 bit) Dell Studio 1555
    header = "Mozilla/4.0(compatible; MSIE 8.0; Windows NT 6.1; WOW64; Trident/4.0; SLCC2; .NET CLR 2.0.50727; .NET CLR 3.5.30729; .NET CLR 3.0.30729; Media Center PC 6.0; MDDC; .NET4.0C)";
    uap.parse(header);
    stats.analyze(uap.getBrowserDetails());
    
    // 30. IE8 on Windows 7 (64 bit) Dell Studio 1555 with Tablet PC attribute
    header = "Mozilla/4.0 (compatible; MSIE 8.0; Windows NT 6.1; Win64; x64; Trident/4.0; .NET CLR 2.0.50727; SLCC2; .NET CLR 3.5.30729; .NET CLR 3.0.30729; Media Center PC 6.0; MDDC; Tablet PC 2.0)";
    uap.parse(header);
    stats.analyze(uap.getBrowserDetails());
    
    // 31. IE8 on a Vista Business Tablet PC
    header = "Mozilla/4.0 (compatible; MSIE 8.0; Windows NT 6.0; SLCC1; .NET CLR 2.0.50727; .NET CLR 3.0.04506; Tablet PC 2.0; InfoPath.2)";
    uap.parse(header);
    stats.analyze(uap.getBrowserDetails());
    
    // 32. IE8 on Windows XP with Hotel and SiteKiosk references
    header = "Mozilla/4.0 (compatible; MSIE 8.0; Windows NT 5.1; Trident/4.0; Hotel; .NET CLR 1.1.4322; .NET CLR 1.0.3705; .NET CLR 2.0.50727; .NET CLR 3.0.04506.30; .NET CLR 3.0.04506.648; .NET CLR 3.0.4506.2152; .NET CLR 3.5.30729; Hotel; Hotel; SiteKiosk 7.7 Build 313)";
    uap.parse(header);
    stats.analyze(uap.getBrowserDetails());
    
    // 33. IE8 on Windows XP Comcast Install
    header = "Mozilla/4.0 (compatible; MSIE 8.0; Windows NT 5.1; Trident/4.0; Comcast Install 1.0; .NET CLR 1.1.4322; .NET CLR 2.0.50727; .NET CLR 3.0.4506.2152; .NET CLR 3.5.30729)";
    uap.parse(header);
    stats.analyze(uap.getBrowserDetails());
    
    // 34. IE8 on Windows XP East Hartford Public Schools
    header = "Mozilla/4.0 (compatible; MSIE 8.0; Windows NT 5.1; Trident/4.0; East Hartford Public Schools; .NET CLR 2.0.50727; .NET CLR 3.0.04506.30; .NET CLR 1.1.4322; .NET CLR 3.0.4506.2152; .NET CLR 3.5.30729; .NET4.0C; .NET4.0E)";
    uap.parse(header);
    stats.analyze(uap.getBrowserDetails());
    
    // 35. IE8 Windows 7 with chromeframe
    header = "Mozilla/4.0 (compatible; MSIE 8.0; Windows NT 6.1; WOW64; Trident/4.0; chromeframe/17.0.963.56; SLCC2; .NET CLR 2.0.50727; .NET CLR 3.5.30729; .NET CLR 3.0.30729; Media Center PC 6.0; InfoPath.3; .NET4.0C; .NET4.0E)";
    uap.parse(header);
    stats.analyze(uap.getBrowserDetails());
    
    // 36. IE7 on Windows Vista
    header = "Mozilla/4.0(compatible; MSIE 7.0; Windows NT 6.0; WOW64; SLCC1; .NET CLR 2.0.50727; .NET CLR 3.0.04506)";
    uap.parse(header);
    stats.analyze(uap.getBrowserDetails());
    
    // 37. IE7 with Zune 2.0 on XP
    header = "Mozilla/4.0 (compatible; MSIE 7.0; Windows NT 5.1; winfx; .NET CLR 1.1.4322; .NET CLR 2.0.50727; Zune 2.0)";
    uap.parse(header);
    stats.analyze(uap.getBrowserDetails());
    
    // 38. IE9 in compatability mode
    header = "Mozilla/4.0 (compatible; MSIE 7.0; Windows NT 6.0; Trident/5.0)";
    uap.parse(header);
    stats.analyze(uap.getBrowserDetails());
    
    // 39. IE7 on Windows XP
    header = "Mozilla/4.0 (compatible; MSIE 7.0; Windows NT 5.1)";
    uap.parse(header);
    stats.analyze(uap.getBrowserDetails());
    
    // 40. IE7 (running in IE7 compatibility mode)
    header = "Mozilla/4.0(compatible; MSIE 7.0; Windows NT 6.1; Win64; x64; Trident/5.0; .NET CLR 2.0.50727; SLCC2; .NET CLR 3.5.30729; .NET CLR 3.0.30729; Media Center PC 6.0)";
    uap.parse(header);
    stats.analyze(uap.getBrowserDetails());
    
    // 41. IE7 running on Windows Vista with MS Tablet PC emulator
    header = "Mozilla/4.0 (compatible; MSIE 7.0; Windows NT 6.0; SU 3.1; SLCC1; .NET CLR 2.0.50727; .NET CLR 3.0.04506; .NET CLR 1.1.4322; Tablet PC 2.0; .NET CLR 3.5.21022)";
    uap.parse(header);
    stats.analyze(uap.getBrowserDetails());
    
    // 42. IE6 request from InfoPath or MS product
    header = "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1; SV1; InfoPath.1)";
    uap.parse(header);
    stats.analyze(uap.getBrowserDetails());
    
    // 43. IE6 on XP with a skin from neos.tv
    header = "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1; SV1; NeosBrowser; .NET CLR 1.1.4322; .NET CLR 2.0.50727)";
    uap.parse(header);
    stats.analyze(uap.getBrowserDetails());
    
    // 44. IE6 on XP with Netscape attribute
    header = "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1) Netscape/8.0.4";
    uap.parse(header);
    stats.analyze(uap.getBrowserDetails());
    
    // 45. IE6 64 bit version using XP 64 on the AMD64
    header = "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.2; Win64; AMD64)";
    uap.parse(header);
    stats.analyze(uap.getBrowserDetails());
    
    // 47. IE11 on a Lumia 928 running Windows Phone 8.1, mobile version
    header = "Mozilla/5.0 (Windows Phone 8.1; ARM; Trident/7.0; Touch; rv:11; IEMobile/11.0; NOKIA; Lumia 928) like Gecko";
    uap.parse(header);
    stats.analyze(uap.getBrowserDetails());
    
    // 48. IE on a Lumia 920 running Windows Phone 8.0, mobile version
    header = "Mozilla/5.0 (compatible; MSIE 10.0; Windows Phone 8.0; Trident/6.0; IEMobile/10.0; ARM; Touch; rv:11; NOKIA; Lumia 920) like Gecko";
    uap.parse(header);
    stats.analyze(uap.getBrowserDetails());
    
    // 49. Maxthon on Windows XP all caps
    header = "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1; SV1; .NET CLR 2.0.50727; MAXTHON 2.0);";
    uap.parse(header);
    stats.analyze(uap.getBrowserDetails());
    
    // 50. Unknown IE on Macintosh
    header = "Mozilla/4.0 (compatible; MSIE 5.23; Mac_PowerPC)";
    uap.parse(header);
    stats.analyze(uap.getBrowserDetails());
    
    // 51. Avant browser on Windows XP (ignoring Avant for now)
    header = "Mozilla/4.0 (compatible; MSIE 7.0; Windows NT 5.1; {39CDB7E2-F3B1-8ED2-9BE7-3C9290A510DA}; Avant Browser; .NET CLR 1.1.4322)";
    uap.parse(header);
    stats.analyze(uap.getBrowserDetails());
    
    // 52. Safari on Windows Phone running on Android 4.0
    header = "Mozilla/5.0 (Mobile; Windows Phone 8.1; Android 4.0; ARM; Trident/7.0; Touch; rv:11.0; IEMobile/11.0; NOKIA; Lumia 929) like iPhone OS 7_0_3 Mac OS X AppleWebKit/537 (KHTML, like Gecko) Mobile Safari/537";
    uap.parse(header);
    stats.analyze(uap.getBrowserDetails());
    
    // 53. SiteKiosk on Windows 7
    header = "Mozilla/5.0 (Windows NT 6.1; Trident/7.0; rv:11.0; SiteKiosk 7.8 Build 332)";
    uap.parse(header);
    stats.analyze(uap.getBrowserDetails());
    
    // 54. SlimBrowser on Windows 7
    header = "Mozilla/5.0 (Windows NT 6.1; Trident/7.0; rv:11.0; SlimBrowser/6.01.101)";
    uap.parse(header);
    stats.analyze(uap.getBrowserDetails());
    
    // 55. Waterfox on Windows 7
    header = "Mozilla/5.0 (Windows NT 6.1; Win64; x64; rv:33.0) Gecko/20100101 Firefox/33.0.2 Waterfox/33.0";
    uap.parse(header);
    stats.analyze(uap.getBrowserDetails());
    
    // 56. Cyberfox on Windows 7
    header = "Mozilla/5.0 (Windows NT 6.1; Win64; x64; rv:34.0) Gecko/20100101 Firefox/34.0 Cyberfox/34.0.5";
    uap.parse(header);
    stats.analyze(uap.getBrowserDetails());
    
    // 57. IceDragon on Windows 7
    header = "Mozilla/5.0 (Windows NT 6.1; WOW64; rv:26.0) Gecko/20100101 Firefox/26.0 IceDragon/26.0.0.2";
    uap.parse(header);
    stats.analyze(uap.getBrowserDetails());
    
    // 58. RockMelt on Windows 7
    header = "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/535.7 (KHTML, like Gecko) RockMelt/0.16.91.483 Chrome/16.0.912.77 Safari/535.7";
    uap.parse(header);
    stats.analyze(uap.getBrowserDetails());
    
    // 59. QQBrowser on Windows 8.1
    header = "Mozilla/5.0 (Windows NT 6.3; Trident/7.0; rv:11.0; QQBrowser/8.0.3197.400) like Gecko";
    uap.parse(header);
    stats.analyze(uap.getBrowserDetails());
    
    // 60. PaleMoon on Windows 8
    header = "Mozilla/5.0 (Windows NT 6.2; WOW64) KHTML/4.11 Gecko/20130308 Firefox/23.0 (PaleMoon/20.3)";
    uap.parse(header);
    stats.analyze(uap.getBrowserDetails());
    
    // 61. Photon on Windows 8
    header = "Mozilla/5.0 (Windows NT 6.2; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/30.0.1599.101 Safari/537.36 Photon/4.0";
    uap.parse(header);
    stats.analyze(uap.getBrowserDetails());
    
    // 62. Midori on Windows 7
    header = "Mozilla/5.0 (Windows NT 6.1) AppleWebKit/538.1 (KHTML, like Gecko) Chrome/18.0.1025.133 Safari/538.1 Midori/0.5";
    uap.parse(header);
    stats.analyze(uap.getBrowserDetails());
    
    // 63. WhiteHat Aviator on Windows 8.1
    header = "Mozilla/5.0 (Windows NT 6.3; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) WhiteHat Aviator/35.0.1916.114 Chrome/35.0.1916.114 Safari/537.36";
    uap.parse(header);
    stats.analyze(uap.getBrowserDetails());
    
    // 64. Mozilla Firebird on Windows 2000
    header = "Mozilla/5.0 (Windows; U; Windows NT 5.0; en-US; rv:1.4b) Gecko/20030516 Mozilla Firebird/0.6";
    uap.parse(header);
    stats.analyze(uap.getBrowserDetails());
    
    // 65. Fast_Browser on Windows 8.1
    header = "Mozilla/5.0 (Windows NT 6.3; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Fast_Browser/34.0.1848.0 Chrome/34.0.1848.0 Safari/537.36";
    uap.parse(header);
    stats.analyze(uap.getBrowserDetails());
    
    // 66. Coc Coc browser on Windows 8.1
    header = "Mozilla/5.0 (Windows NT 6.3; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) coc_coc_browser/44.0 Chrome/38.0.2125.105 Safari/537.36";
    uap.parse(header);
    stats.analyze(uap.getBrowserDetails());
    
    // 67. USPortal?!? on Windows 8.1
    header = "Mozilla/5.0 (Windows NT 6.3; WOW64; Trident/7.0; Touch; USPortal; rv:11.0) like Gecko";
    uap.parse(header);
    stats.analyze(uap.getBrowserDetails());
    
    // 68. Chrome on Windows 7 with Zemana Anti Logger Antimalware???
    header = "Mozilla/5.0 (Windows; U; Windows NT 6.1; en-US) AppleWebKit/534.7 (KHTML, like Gecko) Chrome/7.0.517.44 Safari/534.7 ZemanaAID/FFFF00A0";
    uap.parse(header);
    stats.analyze(uap.getBrowserDetails());
    
    // 69. PlayFreeBrowser on Windows 7
    header = "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/20.0.1207.0 PlayFreeBrowser/4.0.3.7 Safari/537.36";
    uap.parse(header);
    stats.analyze(uap.getBrowserDetails());
    
    // 70. BoBrowser on Windows 8
    header = "Mozilla/5.0 (Windows NT 6.2; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/36.0.1985.125 Chrome/36.0.1985.125 BoBrowser/36.0.1985.136 Safari/537.36";
    uap.parse(header);
    stats.analyze(uap.getBrowserDetails());
    
    // 71. Kindle Fire Phone
    header = "Mozilla/5.0 (Linux; U; Android 4.2.2; en-us; SD4930UR Build/JDQ39) AppleWebKit/537.36 (KHTML, like Gecko) Silk/3.41 like Chrome/37.0.2026.117 Mobile Safari/537.36";
    uap.parse(header);
    stats.analyze(uap.getBrowserDetails());
    
    // 72. Kindle Fire
    header = "Mozilla/5.0 (Linux; U; Android 2.3.4; en-us; Kindle Fire Build/GINGERBREAD) AppleWebKit/533.1 (KHTML, like Gecko) Version/4.0 Mobile Safari/533.1";
    uap.parse(header);
    stats.analyze(uap.getBrowserDetails());
    
    // 73. Kindle Fire
    header = "Mozilla/5.0 (Linux; U; Android 4.0.3; en-us; KFOT Build/IML74K) AppleWebKit/537.36 (KHTML, like Gecko) Silk/3.44 like Chrome/37.0.2026.117 Safari/537.36";
    uap.parse(header);
    stats.analyze(uap.getBrowserDetails());
    
    // 74. Kindle Fire HD
    header = "Mozilla/5.0 (Linux; U; Android 4.4.3; en-us; KFTT Build/IML74K) AppleWebKit/535.19 (KHTML, like Gecko) Silk/3.4 like Safari/535.19 Silk-Accelerated=true";
    uap.parse(header);
    stats.analyze(uap.getBrowserDetails());
    
    // 75. Kindle Fire HD
    header = "Mozilla/5.0 (Linux; U; en-us; KFJWI Build/IMM76D) AppleWebKit/535.19 (KHTML, like Gecko) Silk/3.21 like Safari/535.19 Silk-Accelerated=true";
    uap.parse(header);
    stats.analyze(uap.getBrowserDetails());
    
    // 76. Kindle Fire HD
    header = "Mozilla/5.0 (Linux; U; Android 4.2.2; en-gb; KFSOWI Build/JDQ39) AppleWebKit/537.36 (KHTML, like Gecko) Silk/3.23 like Chrome/34.0.1847.137 Safari/537.36";
    uap.parse(header);
    stats.analyze(uap.getBrowserDetails());
    
    // 77. Kindle Fire HD 8.9
    header = "Mozilla/5.0 (Linux; U; Android 4.0.4; en-us; KFJWA Build/IMM76D) AppleWebKit/534.30 (KHTML, like Gecko) Version/4.0 Safari/534.30 UCBrowser/2.4.2.348";
    uap.parse(header);
    stats.analyze(uap.getBrowserDetails());
    
    // 78. Fire HD 7
    header = "Mozilla/5.0 (Linux; U; Android 4.4.3; en-us; KFASWI Build/KTU84M) AppleWebKit/537.36 (KHTML, like Gecko) Silk/3.46 like Chrome/37.0.2026.117 Safari/537.36";
    uap.parse(header);
    stats.analyze(uap.getBrowserDetails());
    
    // 79. Kindle Fire HDX 7
    header = "Mozilla/5.0 (Linux; U; Android 4.2.2; en-us; KFTHWI Build/JDQ39) AppleWebKit/534.30 (KHTML, like Gecko) Version/4.0 Safari/534.30";
    uap.parse(header);
    stats.analyze(uap.getBrowserDetails());
    
    // 80. Kindle Fire HDX 7 4G
    header = "Mozilla/5.0 (Linux; U; Android 4.2.2; en-us; KFTHWA Build/JDQ39) AppleWebKit/534.30 (KHTML, like Gecko) Version/4.0 Safari/534.30";
    uap.parse(header);
    stats.analyze(uap.getBrowserDetails());
    
    // 81. Kindle Fire HDX 8.9
    header = "Mozilla/5.0 (Linux; U; en-us; KFAPWI Build/JDQ39) AppleWebKit/535.19 (KHTML, like Gecko) Silk/3.13 Safari/535.19 Silk-Accelerated=true";
    uap.parse(header);
    stats.analyze(uap.getBrowserDetails());
    
    // 82. Fire HDX 8.9
    header = "Mozilla/5.0 (Linux; U; Android 4.4; en-us; KFSAWI Build/KTU84M) AppleWebKit/537.36 (KHTML, like Gecko) Silk/3.40 like Chrome/37.0.2026.117 Safari/537.36";
    uap.parse(header);
    stats.analyze(uap.getBrowserDetails());
    
    // Fire HDX 8.9
    header = "Mozilla/5.0 (Linux; Android 4.4.3; en-us; KFSAWA Build/KTU84M) AppleWebKit/537.36 (KHTML, like Gecko) Version/4.0 Chrome/34.0.0.0 Safari/537.36";
    uap.parse(header);
    stats.analyze(uap.getBrowserDetails());
    
    // 83. Kindle Fire HDX 8.9 4G
    header = "Mozilla/5.0 (Linux; U; en-us; KFAPWA Build/JDQ39) AppleWebKit/535.19 (KHTML, like Gecko) Silk/3.8 Safari/535.19 Silk-Accelerated=true";
    uap.parse(header);
    stats.analyze(uap.getBrowserDetails());
    
    // 84. Silk on unknown device
    header = "Mozilla/5.0 (Linux; U; Android 2.3.4; en-us; Silk/1.0.143.1-Gen4_11004910) AppleWebKit/533.1 (KHTML, like Gecko) Version/4.0 Mobile Safari/533.1 Silk-Accelerated=true";
    uap.parse(header);
    stats.analyze(uap.getBrowserDetails());
    
    // 85. Kindle appears near end of string
    header = "Mozilla/5.0 (X11; U; Linux armv7l like Android; en-us) AppleWebKit/531.2+ (KHTML, like Gecko) Version/5.0 Safari/533.2+ Kindle/3.0+";
    uap.parse(header);
    stats.analyze(uap.getBrowserDetails());
    
    // Silk on Macintosh
    //header = "(Macintosh; U; Intel Mac OS X 10_6_3; en-us; Silk/1.0.143.1-Gen4_11004910) AppleWebKit/533.16 (KHTML, like Gecko) Version/5.0 Safari/533.16 Silk-Accelerated=false";
    //uap.parse(header);
    //stats.analyze(uap.getBrowserDetails());
    
    // Silk on PlayStation
    //header = "Mozilla/5.0 (PlayStation Vita 3.36) AppleWebKit/537.73 (KHTML, like Gecko) Silk/3.2";
    //uap.parse(header);
    //stats.analyze(uap.getBrowserDetails());
    
    // 86. Silk on Macintosh
    header = "Mozilla/5.0 (Macintosh; U; Intel Mac OS X 10_6_3; en-us; Silk/1.0.143.1-Gen4_11004910) AppleWebKit/533.16 (KHTML, like Gecko) Version/5.0 Safari/533.16 Silk-Accelerated=false";
    uap.parse(header);
    stats.analyze(uap.getBrowserDetails());
    
    // 87. Android 2.2.2 on Dell 001DL
    header = "Mozilla/5.0 (Linux; U; Android 2.2.2; ja-jp; 001DL Build/FRG83G) AppleWebKit/533.1 (KHTML, like Gecko) Version/4.0 Mobile Safari/533.1";
    uap.parse(header);
    stats.analyze(uap.getBrowserDetails());
    
    // 88. Android 2.3.3 on HTC 001HT
    header = "Mozilla/5.0 (Linux; U; Android 2.3.3; ja-jp; 001HT Build/GRI40) AppleWebKit/533.1 (KHTML, like Gecko) Version/4.0 Mobile Safari/533.1";
    uap.parse(header);
    stats.analyze(uap.getBrowserDetails());
    
    // 89. Android 2.3.4 on ZTE 009Z
    header = "Mozilla/5.0 (Linux; U; Android 2.3.4; ja-jp; 009Z Build/GINGERBREAD) AppleWebKit/533.1 (KHTML, like Gecko) Version/4.0 Mobile Safari/533.1";
    uap.parse(header);
    stats.analyze(uap.getBrowserDetails());
    
    // 90. Android 2.3.5 on Panasonic 101P
    header = "Mozilla/5.0 (Linux; U; Android 2.3.5; ja-jp; 101P Build/GRJ90) AppleWebKit/533.1 (KHTML, like Gecko) Version/4.0 Mobile Safari/533.1";
    uap.parse(header);
    stats.analyze(uap.getBrowserDetails());
    
    // 91. Android 2.3.4 on Lenovo A1_07
    header = "Mozilla/5.0 (Linux; U; Android 2.3.4; ja-jp; A1_07 Build/GRJ22) AppleWebKit/533.1 (KHTML, like Gecko) Version/4.0 Mobile Safari/533.1";
    uap.parse(header);
    stats.analyze(uap.getBrowserDetails());
    
    // 92. Android 3.2.1 on Sharp A01SH
    header = "Mozilla/5.0 (Linux; U; Android 3.2.1; es-es; A01SH Build/HTK55D) AppleWebKit/533.1 (KHTML, like Gecko) Version/4.0 Safari/533.1";
    uap.parse(header);
    stats.analyze(uap.getBrowserDetails());
    
    // 93. Android 3.0.1 on Acer A500
    header = "Mozilla/5.0 (Linux; U; Android 3.0.1; ja-jp; A500 Build/HRI66) AppleWebKit/534.13 (KHTML, like Gecko) Version/4.0 Safari/534.13";
    uap.parse(header);
    stats.analyze(uap.getBrowserDetails());
    
    // 94. Android 4.0.4 on Acer A700
    header = "Mozilla/5.0 (Linux; U; Android 4.0.4; ja-jp; A700 Build/IMM76D) AppleWebKit/534.30 (KHTML, like Gecko) Version/4.0 Safari/534.30";
    uap.parse(header);
    stats.analyze(uap.getBrowserDetails());
    
    // 95. Android 4.0.4 on Toshiba AT100
    header = "Mozilla/5.0 (Linux; U; Android 4.0.4; en-us; AT100 Build/IMM76D) AppleWebKit/534.30 (KHTML, like Gecko) Version/4.0 Safari/534.30";
    uap.parse(header);
    stats.analyze(uap.getBrowserDetails());
    
    // 96. Android 4.1.1 on Amazon Kindle Fire
    header = "Mozilla/5.0 (Linux; U; Android 4.1.1; zh-tw; Amazon Kindle Fire Build/JRO03L; CyanogenMod-cmot20120817 cobe123) AppleWebKit/534.30 (KHTML, like Gecko) Version/4.0 Mobile Safari/534.30";
    uap.parse(header);
    stats.analyze(uap.getBrowserDetails());
    
    // 97. Android 4.0.1 on Galaxy Nexus
    header = "Mozilla/5.0 (Linux; U; Android 4.0.1; ja-jp; Galaxy Nexus Build/ITL41D) AppleWebKit/534.30 (KHTML, like Gecko) Version/4.0 Mobile Safari/534.30";
    uap.parse(header);
    stats.analyze(uap.getBrowserDetails());
    
    // 98. Android 4.0.2 on Samsung Galaxy Nexus
    header = "Mozilla/5.0 (Linux; U; Android 4.0.2; ja-jp; Galaxy Nexus Build/ICL53F) AppleWebKit/534.30 (KHTML, like Gecko) Version/4.0 Mobile Safari/534.30";
    uap.parse(header);
    stats.analyze(uap.getBrowserDetails());
    
    // 99. Android 4.4.4 on Asus Nexus 7
    header = "Mozilla/5.0 (Linux; Android 4.4.4; Nexus 7 Build/KTU84P) AppleWebKit/537.36 (KHTML, like Gecko) Version/4.0 Chrome/32.0.1700.99 Safari/537.36";
    uap.parse(header);
    stats.analyze(uap.getBrowserDetails());
    
    // 100. Android without version number - mobile
    header = "Mozilla/5.0 (Android; Mobile; rv:36.0) Gecko/36.0 Firefox/36.0";
    uap.parse(header);
    stats.analyze(uap.getBrowserDetails());
    
    // 101. Android without version number - tablet
    header = "Mozilla/5.0 (Android; Tablet; rv:35.0) Gecko/35.0 Firefox/35.0";
    uap.parse(header);
    stats.analyze(uap.getBrowserDetails());
    
    // 102. Android without space between U and Android
    header = "Mozilla/5.0 (Linux; U;Android 4.4.2; LGLS990 Build/KVT49L.LS990ZV6) AppleWebKit/537.36 (KHTML, like Gecko) Version/4.0 Chrome/34.0.1847.118 Mobile Safari/537.36";
    uap.parse(header);
    stats.analyze(uap.getBrowserDetails());
    
    // 103. Android 4.1.2 with Nokia browser on Nokia XL
    header = "Mozilla/5.0 (Linux; Android 4.1.2; Nokia_XL Build/JZO54K) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/30.0.1599.82 Mobile Safari/537.36 NokiaBrowser/1.0.1.54";
    uap.parse(header);
    stats.analyze(uap.getBrowserDetails());
    
    // 104. Android 4.4.2 on LG-D800 with Opera 27
    header = "Mozilla/5.0 (Linux; Android 4.4.2; LG-D800 Build/KOT49I.F410S10f) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/40.0.2214.89 Mobile Safari/537.36 OPR/27.0.1698.89115";
    uap.parse(header);
    stats.analyze(uap.getBrowserDetails());
    
    // Android 4.4.2 on Samsung Galaxy Tab with Bing browser
    //header = "Mozilla/5.0 (Linux; Android; SM-T230NU Build/KOT49H) AppleWebKit/537.36 (KHTML, like Gecko) Version/4.0 Chrome/30.0.0.0 Mobile Safari/537.36 BingWeb/5.2.0.20140710";
    //uap.parse(header);
    //stats.analyze(uap.getBrowserDetails());
    
    // 105. Android Android 5.0.1 on Nexus 5 with Opera 27
    header = "Mozilla/5.0 (Linux; Android 5.0.1; Nexus 5 Build/LRX22C) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/40.0.2214.89 Mobile Safari/537.36 OPR/27.0.1698.89115";
    uap.parse(header);
    stats.analyze(uap.getBrowserDetails());
    
    
    // 106. Android 4.1.2 on LGMS769 running Mobile Safari with weird version
    header = "Mozilla/5.0 (Linux; U; Android 4.1.2; en-us; LGMS769 Build/JZO54K) AppleWebKit/534.30 (KHTML, like Gecko) Version/4.0 Mobile Safari/534.30/TansoDL";
    uap.parse(header);
    stats.analyze(uap.getBrowserDetails());
    
    // 107. Chrome on Android 4.4.2 with unknown homerun element
    header = "Mozilla/5.0 (Linux; Android 4.4.2; SCH-I435 Build/KOT49H) AppleWebKit/537.36 (KHTML, like Gecko) Version/4.0 Chrome/30.0.0.0 Mobile Safari/537.36 homerun/4.2.5";
    uap.parse(header);
    stats.analyze(uap.getBrowserDetails());
    
    // 108. UCBrowser on Android 4.0.4
    header = "Mozilla/5.0 (Linux; U; Android 4.0.4; en-US; ADR6410LVW Build/IMM76D) AppleWebKit/534.30 (KHTML, like Gecko) Version/4.0 UCBrowser/10.0.1.512 U3/0.8.0 Mobile Safari/534.30";
    uap.parse(header);
    stats.analyze(uap.getBrowserDetails());
    
    // 109. Android 2.2.2 on Dell 001DL
    header = "Dalvik/1.2.0 (Linux; U; Android 2.2.2; 001DL Build/FRG83G)";
    uap.parse(header);
    stats.analyze(uap.getBrowserDetails());
    
    // 110. Android 2.3.3 on HTC 001HT
    header = "Dalvik/1.4.0 (Linux; U; Android 2.3.3; 001HT Build/GRI40)";
    uap.parse(header);
    stats.analyze(uap.getBrowserDetails());
    
    // 111. Android 2.3.4 on ZTE 009Z
    header = "Dalvik/1.4.0 (Linux; U; Android 2.3.4; 009Z Build/GINGERBREAD)";
    uap.parse(header);
    stats.analyze(uap.getBrowserDetails());
    
    // 112. Android 4.1.1 on Amazon Kindle Fire
    header = "Dalvik/1.6.0 (Linux; U; Android 4.1.1; Amazon Kindle Fire Build/JRO03L)";
    uap.parse(header);
    stats.analyze(uap.getBrowserDetails());
    
    // 113.
    header = "Dalvik/1.6.0 (Linux; U; Android 4.4.4; XT1030 Build/SU6-7)";
    uap.parse(header);
    stats.analyze(uap.getBrowserDetails());
    
    // 114.
    header = "Dalvik/1.6.0 (Linux; U; Android 4.4.2; LGMS323 Build/KOT49I.MS32310c)";
    uap.parse(header);
    stats.analyze(uap.getBrowserDetails());
    
    // 115.
    header = "Dalvik/1.6.0 (Linux; U; Android 4.3; SAMSUNG-SGH-I747 Build/JSS15J)";
    uap.parse(header);
    stats.analyze(uap.getBrowserDetails());
    
    // 116.
    header = "Dalvik/2.1.0 (Linux; U; Android 5.0.1; Nexus 4 Build/LRX22C)";
    uap.parse(header);
    stats.analyze(uap.getBrowserDetails());
    
    // 117. Opera 12 on Windows XP
    header = "Opera/9.80 (Windows NT 5.1; Edition United States Local) Presto/2.12.388 Version/12.17";
    uap.parse(header);
    stats.analyze(uap.getBrowserDetails());
    
    // 118. Opera Mini 7 on Android
    header = "Opera/9.80 (Android; Opera Mini/7.6.40234/35.7108; U; en) Presto/2.8.119 Version/11.10";
    uap.parse(header);
    stats.analyze(uap.getBrowserDetails());
    
    // 119. Opera 12 on Android 4.0.4
    header = "Opera/9.80 (Android 4.0.4; Linux; Opera Mobi/ADR-1309251116) Presto/2.11.355 Version/12.10";
    uap.parse(header);
    stats.analyze(uap.getBrowserDetails());
    
    // 120. Opera 12 on Macintosh
    header = "Opera/9.80 (Macintosh; Intel Mac OS X 10.6.8) Presto/2.12.388 Version/12.16";
    uap.parse(header);
    stats.analyze(uap.getBrowserDetails());
    
    // 121. Opera Mini using SpreadTrum ChipSet
    header = "Opera/9.80 (SpreadTrum; Opera Mini/4.4.31492/35.7598; U; en) Presto/2.8.119 Version/11.10";
    uap.parse(header);
    stats.analyze(uap.getBrowserDetails());
    
    // 122. Opera 9 on Macintosh
    header = "Opera/9.26 (Macintosh; Intel Mac OS X; U; en)";
    uap.parse(header);
    stats.analyze(uap.getBrowserDetails());
    
    // 123. Opera
    header = "Opera/9.80 (X11; Linux zbov) Presto/2.11.355 Version/12.10";
    uap.parse(header);
    stats.analyze(uap.getBrowserDetails());
    
    // 124. Linux bare-bones UA with Chrome 11
    header = "Mozilla/5.0 (X11; ) AppleWebKit/534.24 (KHTML, like Gecko) Chrome/11.0.696.34 Safari/534.24";
    uap.parse(header);
    stats.analyze(uap.getBrowserDetails());
    
    // 125. Chrome 40 on Linux 
    header = "Mozilla/5.0 (X11; Linux armv7l) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/40.0.2214.115 Safari/537.36";
    uap.parse(header);
    stats.analyze(uap.getBrowserDetails());
    
    // 126. Firefox 33 on Linux desktop
    header = "Mozilla/5.0 (X11; Ubuntu; Linux i686; rv:33.0) Gecko/20100101 Firefox/33.0";
    uap.parse(header);
    stats.analyze(uap.getBrowserDetails());
    
    // 127. Firefox 14 on Linux desktop
    header = "Mozilla/5.0 (X11; Linux i686; rv:14.0) Gecko/20100101 Firefox/14.0.1";
    uap.parse(header);
    stats.analyze(uap.getBrowserDetails());
    
    // 128. Chrome 39 on Linux 
    header = "Mozilla/5.0 (X11; Linux i686) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/39.0.2171.95 Safari/537.36";
    uap.parse(header);
    stats.analyze(uap.getBrowserDetails());
    
    // 129. Chrome 40 on Linux 
    header = "Mozilla/5.0 (X11; Linux i686 (x86_64)) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/40.0.2214.115 Safari/537.36";
    uap.parse(header);
    stats.analyze(uap.getBrowserDetails());
    
    // 130. Chrome 11 on Linux 
    header = "Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/534.24 (KHTML, like Gecko) Chrome/11.0.696.34 Safari/534.24";
    uap.parse(header);
    stats.analyze(uap.getBrowserDetails());
    
    // 131. Chrome 40 on Linux 
    header = "Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 (KHTML, like Gecko) Ubuntu Chromium/40.0.2214.111 Chrome/40.0.2214.111 Safari/537.36";
    uap.parse(header);
    stats.analyze(uap.getBrowserDetails());
    
    // 132. Firefox on Linux desktop
    header = "Mozilla/5.0 (X11; Ubuntu; Linux x86_64; rv:36.0) Gecko/20100101 Firefox/36.0";
    uap.parse(header);
    stats.analyze(uap.getBrowserDetails());
    
    // 133. Chromium 34 running on Linux 
    header = "Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 (KHTML, like Gecko) Ubuntu Chromium/34.0.1847.116 Chrome/34.0.1847.116 Safari/537.36";
    uap.parse(header);
    stats.analyze(uap.getBrowserDetails());
    
    // 134. Chrome 39 on Linux 
    header = "Mozilla/5.0 (X11; Linux x86_64; HTCONE RoboForm-A/4.2.1) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/39.0.2171.93 Safari/537.36";
    uap.parse(header);
    stats.analyze(uap.getBrowserDetails());
    
    // 135. Iceweasel 31 (Firefox) on Linux 
    header = "Mozilla/5.0 (X11; Linux x86_64; rv:31.0) Gecko/20100101 Firefox/31.0 Iceweasel/31.2.0";
    uap.parse(header);
    stats.analyze(uap.getBrowserDetails());
    
    // 136. Iceweasel 27 on Linux with Jumpshot anti-virus
    header = "Mozilla/5.0 (X11; Linux i686; rv:27.0) Gecko/20100101 Firefox/27.0 Iceweasel/27.0 Jumpshot/2.2";
    uap.parse(header);
    stats.analyze(uap.getBrowserDetails());
    
    // 137. Firefox 10 on Linux with weird Chrome at end
    header = "Mozilla/5.0 (X11; Linux x86_64; rv:10.0) Gecko/20100101 Firefox/10.0 (Chrome)";
    uap.parse(header);
    stats.analyze(uap.getBrowserDetails());
    
    // 138. Silk 3 on Linux 
    header = "Mozilla/5.0 (X11; Linux x86_64; U; en-us) AppleWebKit/537.36 (KHTML, like Gecko) Silk/3.46 like Chrome/37.0.2026.117 Safari/537.36";
    uap.parse(header);
    stats.analyze(uap.getBrowserDetails());
    
    // 139. Linux with SeaMonkey and Firefox 
    header = "Mozilla/5.0 (X11; Linux x86_64; rv:12.0) Gecko/20120501 Firefox/12.0 SeaMonkey/2.9.1 Lightning/1.4";
    uap.parse(header);
    stats.analyze(uap.getBrowserDetails());
    
    // 140. Linux 
    header = "Mozilla/5.0 (Linux; U; Android 4.4.2; en-us; HTCONE Build/KOT49H) AppleWebKit/534.30 (KHTML, like Gecko) Version/4.0 Mobile Safari/534.30";
    uap.parse(header);
    stats.analyze(uap.getBrowserDetails());
    
    // 141. Maxthon on Linux 
    header = "Mozilla/5.0 (X11; Linux x86_64; Ubuntu 12.04.5 LTS) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/33.0.1750.0 Maxthon/1.0.3.10 Safari/537.36";
    uap.parse(header);
    stats.analyze(uap.getBrowserDetails());
    
    // 142. Maxthon on Linux
    header = "Mozilla/5.0 (Linux; U; Android 4.1.1; en-us; HTC One X Build/JRO03C) AppleWebKit/534.30 (KHTML, like Gecko) Version/4.0 Mobile Safari/534.30 MxBrowser/4.3.1.2000";
    uap.parse(header);
    stats.analyze(uap.getBrowserDetails());
    
    // 143. Qutebrowser on Linux
    header = "Mozilla/5.0 (X11; Linux i686) AppleWebKit/538.1 (KHTML, like Gecko) qutebrowser/0.0.0 Safari/538.1";
    uap.parse(header);
    stats.analyze(uap.getBrowserDetails());
    
    // 144. Chromium on Ubuntu Linux
    header = "Mozilla/5.0 (Linux; Ubuntu 14.04) AppleWebKit/537.36 Chromium/35.0.1870.2 Safari/537.36";
    uap.parse(header);
    stats.analyze(uap.getBrowserDetails());
    
    // 145. Safari on Linux indentifying as DirectFB
    header = "Mozilla/5.0 (DirectFB; Linux; ko-KR) AppleWebKit/534.26+ (KHTML, like Gecko) Version/5.0 Safari/534.26+";
    uap.parse(header);
    stats.analyze(uap.getBrowserDetails());
    
    // 146. Midori on Linux
    header = "Mozilla/5.0 (X11; Linux) AppleWebKit/535.22 (KHTML, like Gecko) Chrome/18.0.1025.133 Safari/535.22 Midori/0.5";
    uap.parse(header);
    stats.analyze(uap.getBrowserDetails());
    
    // 147. luakit on Linux
    header = "Mozilla/5.0 (Linux x86_64) AppleWebKit/537.6+ (KHTML, like Gecko) WebKitGTK+/1.10.2 luakit/0d5f4";
    uap.parse(header);
    stats.analyze(uap.getBrowserDetails());
    
    // 148. luakit on Linux
    header = "Mozilla/5.0 (Linux x86_64) AppleWebKit/538.15+ (KHTML, like Gecko) WebKitGTK+/2.4.2 luakit/2012.09.13";
    uap.parse(header);
    stats.analyze(uap.getBrowserDetails());
    
    // 149. luakit on Linux
    header = "Mozilla/5.0 (Linux x86_64) AppleWebKit/535.4+ (KHTML, like Gecko) WebKitGTK+/1.6.1 luakit";
    uap.parse(header);
    stats.analyze(uap.getBrowserDetails());
    
    // 150. Qt?!? on Linux (supposed to be a linux broswer)
    header = "Mozilla/5.0 (QtEmbedded; Linux; en-US) AppleWebKit/537.4 (KHTML, like Gecko) Qt/4.8.3 Safari/534.34";
    uap.parse(header);
    stats.analyze(uap.getBrowserDetails());
    
    // 151. Qt?!? on Linux (supposed to be a linux broswer)
    header = "Mozilla/5.0 (X11; Linux i686) AppleWebKit/534.34 (KHTML, like Gecko) Qt/4.8.0 Safari/534.34 AutoZone/1.0 (Znet)";
    uap.parse(header);
    stats.analyze(uap.getBrowserDetails());
    
    // 152. QupZilla on Linux
    header = "Mozilla/5.0 (X11; Linux i686) AppleWebKit/537.21 (KHTML, like Gecko) QupZilla/1.4.1 Safari/537.21";
    uap.parse(header);
    stats.analyze(uap.getBrowserDetails());
    
    // 153. Puffin 4 on Linux (Android) Smartphone 
    header = "Mozilla/5.0 (X11; U; Linux x86_64; en-us) AppleWebKit/537.36 (KHTML, like Gecko)  Chrome/30.0.1599.114 Safari/537.36 Puffin/4.0.4.931AP";
    uap.parse(header);
    stats.analyze(uap.getBrowserDetails());
    
    // 154. Puffin 4 on iOS Tablet
    header = "Mozilla/5.0 (X11; U; Linux x86_64; en-US) AppleWebKit/537.36 (KHTML, like Gecko)  Chrome/30.0.1599.114 Safari/537.36 Puffin/4.1.2IT";
    uap.parse(header);
    stats.analyze(uap.getBrowserDetails());
    
    // 155. Puffin 4 on iOS Smartphone 
    header = "Mozilla/5.0 (X11; U; Linux x86_64; en-US) AppleWebKit/537.36 (KHTML, like Gecko)  Chrome/30.0.1599.114 Safari/537.36 Puffin/4.1.2IP";
    uap.parse(header);
    stats.analyze(uap.getBrowserDetails());
    
    // 156. Puffin 4 on Linux (Android) Tablet 
    header = "Mozilla/5.0 (X11; U; Linux x86_64; en-us) AppleWebKit/537.36 (KHTML, like Gecko)  Chrome/30.0.1599.114 Safari/537.36 Puffin/4.0.4.931AT";
    uap.parse(header);
    stats.analyze(uap.getBrowserDetails());
    
    // 157. Older Puffin with 'M' for mobile
    header = "Mozilla/5.0 (X11; U; Linux i686; en-gb) AppleWebKit/534.35 (KHTML, like Gecko)  Chrome/11.0.696.65 Safari/534.35 Puffin/2.0.5603M";
    uap.parse(header);
    stats.analyze(uap.getBrowserDetails());
    
    // 158. Puffin with no device code
    header = "Mozilla/5.0 (X11; U; Linux i686; en-gb) AppleWebKit/534.35 (KHTML, like Gecko)  Chrome/11.0.696.65 Safari/534.35 Puffin/2.0.5603";
    uap.parse(header);
    stats.analyze(uap.getBrowserDetails());
    
    // Puffin 3 on iPod
    //header = "Mozilla/5.0 (iPod; U; CPU iPhone OS 6_1 like Mac OS X; en-HK) AppleWebKit/534.35 (KHML, like Gecko) Chrome/11.0.696.65 Safari/534.35 Puffin/3.9174IP Mobile";
    //uap.parse(header);
    //stats.analyze(uap.getBrowserDetails());
    
    // Puffin 3 on iPhone
    //header = "Mozilla/5.0 (iPhone; U; CPU iPhone OS 7_0_4 like Mac OS X; en-US) AppleWebKit/534.35 (KHTML, like Gecko) Chrome/11.0.696.65 Safari/534.35 Puffin/3.11505IP Mobile";
    //uap.parse(header);
    //stats.analyze(uap.getBrowserDetails());
    
    // 159.
    header = "Mozilla/5.0 (compatible; Konqueror/3.1; Linux 2.4.22-10mdk; X11; i686; fr, fr_FR)";
    uap.parse(header);
    stats.analyze(uap.getBrowserDetails());
    
    // 160.
    header = "Mozilla/5.0 (X11; Linux x86_64) KHTML/4.14.3 (like Gecko) Konqueror/4.14";
    uap.parse(header);
    stats.analyze(uap.getBrowserDetails());
    
    // 161. Epiphany 3 on Macintosh
    header = "Mozilla/5.0 (Macintosh; ARM Mac OS X) AppleWebKit/538.15 (KHTML, like Gecko) Safari/538.15 Version/6.0 Debian/7.8 (3.8.2.0-0rpi18rpi1) Epiphany/3.8.2";
    uap.parse(header);
    stats.analyze(uap.getBrowserDetails());
    
    // 162. Firefox 37 on Macintosh
    header = "Mozilla/5.0 (Macintosh; Intel Mac OS X 10.10; rv:37.0) Gecko/20100101 Firefox/37.0";
    uap.parse(header);
    stats.analyze(uap.getBrowserDetails());
    
    // 163. Safari on Macintosh
    header = "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_10) AppleWebKit/537.16 (KHTML, like Gecko) Version/8.0 Safari/537.16";
    uap.parse(header);
    stats.analyze(uap.getBrowserDetails());
    
    // 164. Unidentifiable? on Macintosh
    header = "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_10) AppleWebKit/600.1.25 (KHTML, like Gecko)";
    uap.parse(header);
    stats.analyze(uap.getBrowserDetails());
    
    // 165. Chrome 31 on Macintosh
    header = "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_10_0) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/31.0.1650.63 Safari/537.36";
    uap.parse(header);
    stats.analyze(uap.getBrowserDetails());
    
    // 166. Opera 26 on Macintosh
    header = "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_10_1) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/39.0.2171.95 Safari/537.36 OPR/26.0.1656.60";
    uap.parse(header);
    stats.analyze(uap.getBrowserDetails());
    
    // 167. Chrome 40 on Macintosh
    header = "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_7_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/40.0.2214.94 Safari/537.36";
    uap.parse(header);
    stats.analyze(uap.getBrowserDetails());
    
    // 168. Qutebrowser on Macintosh
    header = "Mozilla/5.0 (Macintosh; Intel Mac OS X) AppleWebKit/538.1 (KHTML, like Gecko) qutebrowser/0.1.2 Safari/538.1";
    uap.parse(header);
    stats.analyze(uap.getBrowserDetails());
    
    // 169. TenFourFox on Macintosh
    header = "Mozilla/5.0 (Macintosh; PPC Mac OS X 10.4; rv:31.0) Gecko/20100101 Firefox/31.0 TenFourFox/7450";
    uap.parse(header);
    stats.analyze(uap.getBrowserDetails());
    
    // 170. TenFourFox on Macintosh alphanumeric version number
    header = "Mozilla/5.0 (Macintosh; PPC Mac OS X 10.4; rv:17.0) Gecko/20131113 Firefox/17.0 TenFourFox/G5";
    uap.parse(header);
    stats.analyze(uap.getBrowserDetails());
    
    // 171. Maxthon 4 on Macintosh
    header = "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_8_5) AppleWebKit/536.30.1 (KHTML, like Gecko) Maxthon/4.4.0";
    uap.parse(header);
    stats.analyze(uap.getBrowserDetails());
    
    // 172. Mobile Safari on Macintosh
    header = "Mozilla/5.0 (Macintosh; Intel Ma2; SAMSUNG-SM-G870A Build/KOT49H) AppleWebKit/537.36 (KHTML, like Gecko) Version/4.0 Chrome/30.0.0.0 Mobile Safari/537.36";
    uap.parse(header);
    stats.analyze(uap.getBrowserDetails());
    
    // 173. Sleipnir on Macintosh
    header = "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_6_8) AppleWebKit/534.59.10 (KHTML, like Gecko) Version/5.1 Safari/6534.59.10 Sleipnir/4.5.1";
    uap.parse(header);
    stats.analyze(uap.getBrowserDetails());
    
    // 174. OPiOS (iOS) running Safari
    header = "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_9_2) AppleWebKit/537.51.2 (KHTML, like Gecko) Version/7.0.3 Safari/537.75.14 OPiOS/8.0.3.82195";
    uap.parse(header);
    stats.analyze(uap.getBrowserDetails());
    
    // 175. SeaMonkey on Macintosh
    header = "Mozilla/5.0 (Macintosh; Intel Mac OS X 10.8; rv:32.0) Gecko/20100101 Firefox/32.0 SeaMonkey/2.29.1";
    uap.parse(header);
    stats.analyze(uap.getBrowserDetails());
    
    // 176. OmniWeb on Macintosh
    header = "Mozilla/5.0 (Macintosh; U; Intel Mac OS X 10_7_5; en-US) AppleWebKit/533.21.1+(KHTML, like Gecko, Safari/533.19.4) Version/5.11 OmniWeb/622.16.0";
    uap.parse(header);
    stats.analyze(uap.getBrowserDetails());
    
    // 177. Safari on CriOS
    header = "Mozilla/5.0 (iPad; CPU OS 7_1_2 like Mac OS X) AppleWebKit/537.51.2 (KHTML like Gecko) CriOS/36.0.1985.49 Mobile/11D257 Safari/9537.53 (000883)";
    uap.parse(header);
    stats.analyze(uap.getBrowserDetails());
    
    // 178. Skyfire on Macintosh (mobile browser for Android platform)
    header = "Mozilla/5.0 (Macintosh; U; Intel Mac OS X 10_5_7; en-us) AppleWebKit/530.17 (KHTML, like Gecko) Version/4.0 Safari/530.17 Skyfire/2.0";
    uap.parse(header);
    stats.analyze(uap.getBrowserDetails());
    
    // 179. Midori on Macintosh
    header = "Mozilla/5.0 (Macintosh; U; Intel Mac OS X; en-us) AppleWebKit/537+ (KHTML, like Gecko) Version/5.0 Safari/537.6+ Midori/0.4";
    uap.parse(header);
    stats.analyze(uap.getBrowserDetails());
    
    // 180. QQBrowser on Macintosh
    header = "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_9_4) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/33.0.1750.146 Safari/537.36 QQBrowser/3.0.2313.400";
    uap.parse(header);
    stats.analyze(uap.getBrowserDetails());
    
    // 181. Safari on Macintosh with Mobile element
    header = "Mozilla/5.0 (Macintosh; Intel Mac OS X 10.8; rv:27.0) Gecko/20100101537.51.2 (KHTML, like Gecko) Version/7.0 Mobile/11D257 Safari/9537.53";
    uap.parse(header);
    stats.analyze(uap.getBrowserDetails());
    
    // 182. Unknown browser on Macintosh
    header = "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_10_1) AppleWebKit/600.1.25 (KHTML, like Gecko)";
    uap.parse(header);
    stats.analyze(uap.getBrowserDetails());
    
    // 183. Safari on Macintosh
    header = "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_8_5) AppleWebKit/536.30.1 (KHTML, like Gecko, Safari/8536.30.1) ADM/763";
    uap.parse(header);
    stats.analyze(uap.getBrowserDetails());
    
    // 184. Firefox 5 on Macintosh
    header = "Mozilla/5.0 (Macintosh; Intel Mac OS X 10.9; rv:5.0.1) Gecko/20100101 Firefox/5.0.1";
    uap.parse(header);
    stats.analyze(uap.getBrowserDetails());
    
    // 185. Silk on Macintosh
    header = "Mozilla/5.0 (Macintosh; U; Intel Mac OS X 10_6_3; en-us; Silk/1.0.22.153_10033210) AppleWebKit/533.16 (KHTML, like Gecko) Version/5.0 Safari/533.16 Silk-Accelerated=true";
    uap.parse(header);
    stats.analyze(uap.getBrowserDetails());
    
    // 186. Safari on iPad
    header = "Mozilla/5.0 (iPad; CPU iPhone OS 6_1_3 like Mac OS X) AppleWebKit/536.26 (KHTML, like Gecko) Version/6.0 Mobile/10B329 Safari/8536.25";
    uap.parse(header);
    stats.analyze(uap.getBrowserDetails());
    
    // 187. Safari on iPad
    header = "Mozilla/5.0 (iPad; CPU OS 8_1 like Mac OS X) AppleWebKit/600.1.4 (K Gecko) Chrome/40.0.2214.91 Safari/537.36";
    uap.parse(header);
    stats.analyze(uap.getBrowserDetails());
    
    // 188. Mercury on iPad
    header = "Mozilla/5.0 (iPad; U; CPU OS 4_3_2 like Mac OS X) AppleWebKit/533.17.9 (KHTML, like Gecko) Mercury/7.2 Mobile/8H7 Safari/6533.18.5";
    uap.parse(header);
    stats.analyze(uap.getBrowserDetails());
    
    // 189. UCBrowser on iPad
    header = "Mozilla/5.0 (iPad; U; CPU OS 5_1 like Mac OS X) AppleWebKit/531.21.10 (KHTML, like Gecko) Version/4.0.4 Mobile/7B367 Safari/531.21.10 UCBrowser/3.4.1.483";
    uap.parse(header);
    stats.analyze(uap.getBrowserDetails());
    
    // 190. Puffin on iPad
    header = "Mozilla/5.0 (iPad; U; CPU OS 7_1_2 like Mac OS X; en-US) AppleWebKit/537.36 (KHTML, like Gecko)  Chrome/30.0.1599.114 Safari/537.36 Puffin/4.0.0IT Mobile";
    uap.parse(header);
    stats.analyze(uap.getBrowserDetails());
    
    // 191. Safari on iPhone with MQQBrowser framework
    header = "Mozilla/5.0 (iPhone 5SGSM; CPU iPhone OS 7_1_1 like Mac OS X) AppleWebKit/537.51.2 (KHTML, like Gecko) Version/6.0 MQQBrowser/5.6 Mobile/11D201 Safari/8536.25";
    uap.parse(header);
    stats.analyze(uap.getBrowserDetails());
    
    // 192. Mercury on iPhone
    header = "Mozilla/5.0 (iPhone; CPU iPhone OS 6_0_1 like Mac OS X) AppleWebKit/536.26 (KHTML, like Gecko) Mercury/8.0.1 Mobile/10A523 Safari/8536.25";
    uap.parse(header);
    stats.analyze(uap.getBrowserDetails());
    
    // 193. Opera Coast browser on iPhone
    header = "Mozilla/5.0 (iPhone; CPU iPhone OS 7_0_4 like Mac OS X) AppleWebKit/537.51.1 (KHTML, like Gecko) Coast/4.01.88243 Mobile/11B554a Safari/7534.48.3";
    uap.parse(header);
    stats.analyze(uap.getBrowserDetails());
    
    // 194. Safari on iPhone
    header = "Mozilla/5.0 (iPhone; CPU iPhone OS 8_1_3 like Mac OS X) AppleWebKit/600.1.4 (KHTML, like Gecko) OPiOS/9.1.0.86723 Mobile/12B466 Safari/9537.53";
    uap.parse(header);
    stats.analyze(uap.getBrowserDetails());
    
    // 195. Safari on iPod
    header = "Mozilla/5.0 (iPod; CPU iPhone OS 8_1_3 like Mac OS X) AppleWebKit/600.1.4 (KHTML, like Gecko) GSA/5.1.42378 Mobile/12B466 Safari/600.1.4";
    uap.parse(header);
    stats.analyze(uap.getBrowserDetails());
    
    // 196. Safari on iPhone?!?
    header = "Mozilla/5.0 (Windows NTU iPhone OS 7_1_2 like Mac OS X) AppleWebKit/537.51.2 (KHTML, like Gecko) Version/7.0 Mobile/11D257 Safari/9537.53";
    uap.parse(header);
    stats.analyze(uap.getBrowserDetails());
    
    // 197. B-line video app on iPhone
    header = "Mozilla/5.0 (iPhone; CPU iPhone OS 7_0_2 like Mac OS X) AppleWebKit/537.51.1 (KHTML, like Gecko) Mobile/11A501 bline/1.09 (iPhone OS 7.0.2, iPhone)";
    uap.parse(header);
    stats.analyze(uap.getBrowserDetails());
    
    // 198. Bing search app on iPhone
    header = "Mozilla/5.0 (iPhone; CPU iPhone OS 7_1_2 like Mac OS X) AppleWebKit/537.51.2 (KHTML, like Gecko) Mobile/11D257 iPhone4,1 BingWeb/5.1.1.1643.20141031";
    uap.parse(header);
    stats.analyze(uap.getBrowserDetails());
    
    // 199. Naver (S. Korean search portal) on iPhone
    header = "Mozilla/5.0 (iPhone; CPU iPhone OS 7_1_2 like Mac OS X) AppleWebKit/537.51.2 (KHTML, like Gecko) Mobile/11D257 NAVER(inapp; search; 370; 5.7.2; 4S)";
    uap.parse(header);
    stats.analyze(uap.getBrowserDetails());
    
    // 200. AOL app on iPad
    header = "Mozilla/5.0 (iPad; CPU OS 7_1_1 like Mac OS X) AppleWebKit/537.51.2 (KHTML, like Gecko) Mobile/11D201 AolApp/3.1.4.6";
    uap.parse(header);
    stats.analyze(uap.getBrowserDetails());
    
    // 201. Baidu HD browser?!? on iPad
    header = "Mozilla/5.0 (iPad; CPU OS 6_1_3 like Mac OS X) AppleWebKit/534.46 (KHTML, like Gecko) BaiduHD/2.6.2 Mobile/10A406 Safari/8536.25";
    uap.parse(header);
    stats.analyze(uap.getBrowserDetails());
    
    // 202. Baidu box app on iPhone
    header = "Mozilla/5.0 (iPhone; CPU iPhone OS 7_0_4 like Mac OS X) AppleWebKit/537.51.1 (KHTML, like Gecko) Mobile/11B554a baiduboxapp/0_0.2.0.6_enohpi_069_046/4.0.7_1C2%254enohPi/1099a/E2D4929F76764E45B43E6DA175C8F08293210193BONKKFOGOLJ/1";
    uap.parse(header);
    stats.analyze(uap.getBrowserDetails());
    
    // 203. Twitter app on iPhone
    header = "Mozilla/5.0 (iPhone; CPU iPhone OS 7_1_1 like Mac OS X) AppleWebKit/537.51.2 (KHTML, like Gecko) Mobile/11D201 Twitter for iPhone";
    uap.parse(header);
    stats.analyze(uap.getBrowserDetails());
    
    // 204. QuickLook?!? on Macintosh
    header = "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_10_1) AppleWebKit/600.1.25 (KHTML, like Gecko) QuickLook/5.0";
    uap.parse(header);
    stats.analyze(uap.getBrowserDetails());
    stats.dumpStats();
    
    // 205. BlackBerry 9300 (Curve 3G Smartphone)
    header = "Mozilla/5.0 (BlackBerry; U; BlackBerry 9300; en-US) AppleWebKit/534.8+ (KHTML, like Gecko) Version/6.0.0.706 Mobile Safari/534.8+";
    uap.parse(header);
    stats.analyze(uap.getBrowserDetails());
    stats.dumpStats();
    
    
    // 206. BlackBerry 9310 (Curve Smartphone)
    header = "Mozilla/5.0 (BlackBerry; U; BlackBerry 9310; en-US) AppleWebKit/534.11+ (KHTML, like Gecko) Version/7.1.0.768 Mobile Safari/534.11+";
    uap.parse(header);
    stats.analyze(uap.getBrowserDetails());
    stats.dumpStats();
    
    // 207. BlackBerry 9330 (Curve 3G Smartphone)
    header = "Mozilla/5.0 (BlackBerry; U; BlackBerry 9330; en-US) AppleWebKit/534.8+ (KHTML, like Gecko) Version/6.0.0.706 Mobile Safari/534.8+";
    uap.parse(header);
    stats.analyze(uap.getBrowserDetails());
    stats.dumpStats();
    
    // 208. BlackBerry 9360 (Curve Smartphone)
    header = "Mozilla/5.0 (BlackBerry; U; BlackBerry 9360; en-US) AppleWebKit/534.11+ (KHTML, like Gecko) Version/7.0.0.586 Mobile Safari/534.11+";
    uap.parse(header);
    stats.analyze(uap.getBrowserDetails());
    stats.dumpStats();
    
    // 209. BlackBerry 9700 (Bold Smartphone)
    header = "Mozilla/5.0 (BlackBerry; U; BlackBerry 9700; en-US) AppleWebKit/534.8+ (KHTML, like Gecko) Version/6.0.0.448 Mobile Safari/534.8+";
    uap.parse(header);
    stats.analyze(uap.getBrowserDetails());
    stats.dumpStats();
    
    // 210. BlackBerry 9800 (Torch Smartphone)
    header = "Mozilla/5.0 (BlackBerry; U; BlackBerry 9800; en-US) AppleWebKit/534.1+ (KHTML, like Gecko) Version/6.0.0.246 Mobile Safari/534.1+";
    uap.parse(header);
    stats.analyze(uap.getBrowserDetails());
    stats.dumpStats();
    
    // 211. BlackBerry 9810 (Torch Smartphone)
    header = "Mozilla/5.0 (BlackBerry; U; BlackBerry 9810; en-US) AppleWebKit/534.11+ (KHTML, like Gecko) Version/7.1.0.694 Mobile Safari/534.11+";
    uap.parse(header);
    stats.analyze(uap.getBrowserDetails());
    stats.dumpStats();
    
    // 212. BlackBerry 9900 (Bold Smartphone)
    header = "Mozilla/5.0 (BlackBerry; U; BlackBerry 9900; en-US) AppleWebKit/534.11+ (KHTML, like Gecko) Version/7.0.0.261 Mobile Safari/534.11+";
    uap.parse(header);
    stats.analyze(uap.getBrowserDetails());
    stats.dumpStats();
    
    // 213. BlackBerry 9930 (Bold Smartphone)
    header = "Mozilla/5.0 (BlackBerry; U; BlackBerry 9930; en-US) AppleWebKit/534.11+ (KHTML, like Gecko) Version/7.1.0.991 Mobile Safari/534.11+";
    uap.parse(header);
    stats.analyze(uap.getBrowserDetails());
    stats.dumpStats();
    
    // 214. BlackBerry 10
    header = "Mozilla/5.0 (BB10; Kbd) AppleWebKit/537.35+ (KHTML, like Gecko) Version/10.2.1.3337 Mobile Safari/537.35+";
    uap.parse(header);
    stats.analyze(uap.getBrowserDetails());
    stats.dumpStats();
    
    // 215. BlackBerry 10
    header = "Mozilla/5.0 (BB10; Touch) AppleWebKit/537.10+ (KHTML, like Gecko) Version/10.1.0.1485 Mobile Safari/537.10+";
    uap.parse(header);
    stats.analyze(uap.getBrowserDetails());
    stats.dumpStats();
    
    // 216. BlackBerry PlayBook Tablet on BlackBerry OS
    header = "Mozilla/5.0 (PlayBook; U; RIM Tablet OS 2.1.0; en-US) AppleWebKit/536.2+ (KHTML, like Gecko) Version/7.2.1.0 Mobile Safari/536.2+";
    uap.parse(header);
    stats.analyze(uap.getBrowserDetails());
    stats.dumpStats();
    
    // 217. BlackBerry PlayBook Tablet on Android
    header = "Mozilla/5.0 (PlayBook; U; Android 2.3.3; en-gb; PlayBook Build/2.1.0.147) AppleWebKit/533.1+ (KHTML, like Gecko) Version/4.0 Mobile Safari/533.1+";
    uap.parse(header);
    stats.analyze(uap.getBrowserDetails());
    stats.dumpStats();
    
    // 218. HP TouchPad
    header = "Mozilla/5.0 (hp-tablet; Linux; hpwOS/3.0.5; U; en-US) AppleWebKit/534.6 (KHTML, like Gecko) wOSBrowser/234.83 Safari/534.6 TouchPad/1.0";
    uap.parse(header);
    stats.analyze(uap.getBrowserDetails());
    stats.dumpStats();
    
    // 219. Nokia Asha 200 Series 40 Smartphone
    header = "Mozilla/5.0 (Series40; Nokia200/10.60; Profile/MIDP-2.1 Configuration/CLDC-1.1) Gecko/20100401 S40OviBrowser/5.0.0.0.31";
    uap.parse(header);
    stats.analyze(uap.getBrowserDetails());
    stats.dumpStats();
    
    // 220. Nokia Asha 305 Series 40 Smartphone
    header = "Mozilla/5.0 (Series40; Nokia305/05.92; Profile/MIDP-2.1 Configuration/CLDC-1.1) Gecko/20100401 S40OviBrowser/5.0.0.0.31";
    uap.parse(header);
    stats.analyze(uap.getBrowserDetails());
    stats.dumpStats();
    
    // 221. Nokia Lumia 1520 Windows phone on Windows 8
    header = "Mozilla/5.0 (Windows NT 6.2; ARM; Trident/7.0; Touch; rv:11.0; WPDesktop; Lumia 1520) like Gecko";
    uap.parse(header);
    stats.analyze(uap.getBrowserDetails());
    stats.dumpStats();
    
    // 222. Nokia Lumia 1020 (Shows as 909) Windows phone on Windows 8
    header = "Mozilla/5.0 (Windows NT 6.2; ARM; Trident/7.0; Touch; rv:11.0; WPDesktop; NOKIA; 909) like Gecko";
    uap.parse(header);
    stats.analyze(uap.getBrowserDetails());
    stats.dumpStats();
    
    // 223. Nokia Lumia 1020 (Shows as 909) Windows phone on Windows 8 w/o NOKIA token
    header = "Mozilla/5.0 (Windows NT 6.2; ARM; Trident/7.0; Touch; rv:11.0; WPDesktop; 909) like Gecko";
    uap.parse(header);
    stats.analyze(uap.getBrowserDetails());
    stats.dumpStats();
    
    // 224. Nokia Lumia 925 Windows phone on Windows 8
    header = "Mozilla/5.0 (Windows NT 6.2; ARM; Trident/7.0; Touch; rv:11.0; WPDesktop; NOKIA; Lumia 925) like Gecko";
    uap.parse(header);
    stats.analyze(uap.getBrowserDetails());
    stats.dumpStats();
    
    // 225.
    header = "Mozilla/5.0 (Linux; U; Android 2.3.6; en-gb; GT-S6802 Build/GINGERBREAD) AppleWebKit/533.1 (KHTML, like Gecko) Version/4.0 Mobile Safari/533.1";
    uap.parse(header);
    stats.analyze(uap.getBrowserDetails());
    stats.dumpStats();
    
    // 226.
    header = "Mozilla/5.0 (Linux; U; Android 2.3.4; en-ca; GT-S5830D-parrot Build/GINGERBREAD) AppleWebKit/533.1 (KHTML, like Gecko) Version/4.0 Mobile Safari/533.1";
    uap.parse(header);
    stats.analyze(uap.getBrowserDetails());
    stats.dumpStats();
    
    // 227.
    header = "Mozilla/5.0 (Linux; U; Android 2.3.6; en-ca; SCH-S720C Build/GINGERBREAD) AppleWebKit/533.1 (KHTML, like Gecko) Version/4.0 Mobile Safari/533.1";
    uap.parse(header);
    stats.analyze(uap.getBrowserDetails());
    stats.dumpStats();
    
    // 228.
    header = "Mozilla/5.0 (Linux; U; Android 2.3.6; en-us; SAMSUNG-SGH-I827 Build/GINGERBREAD) AppleWebKit/533.1 (KHTML, like Gecko) Version/4.0 Mobile Safari/533.1";
    uap.parse(header);
    stats.analyze(uap.getBrowserDetails());
    stats.dumpStats();
    
    // 229.
    header = "Mozilla/5.0 (Linux; Android 4.4.2; zh-cn; SAMSUNG SM-G386T1 Build/KOT49H) AppleWebKit/537.36 (KHTML, like Gecko) Version/1.6 Chrome/28.0.1500.94 Mobile Safari/537.36";
    uap.parse(header);
    stats.analyze(uap.getBrowserDetails());
    stats.dumpStats();
    
    // 230.
    header = "Mozilla/5.0 (Linux; U; Android 2.3.6; en-us; SGH-T769 Build/GINGERBREAD) AppleWebKit/533.1 (KHTML, like Gecko) Version/4.0 Mobile Safari/533.1";
    uap.parse(header);
    stats.analyze(uap.getBrowserDetails());
    stats.dumpStats();
    
    // 231.
    header = "Mozilla/5.0 (Linux; U; Android 4.1.2; en-us; SGH-I897 Build/IML74K) AppleWebKit/534.30 (KHTML, like Gecko) Version/4.0 Mobile Safari/534.30";
    uap.parse(header);
    stats.analyze(uap.getBrowserDetails());
    stats.dumpStats();
    
    // 232.
    header = "Mozilla/5.0 (Linux; U; Android 4.0.4; en-us; SCH-S738C Build/IMM76D) AppleWebKit/534.30 (KHTML, like Gecko) Version/4.0 Mobile Safari/534.30";
    uap.parse(header);
    stats.analyze(uap.getBrowserDetails());
    stats.dumpStats();
    
    // 233.
    header = "Mozilla/5.0 (Linux; U; Android 2.3.6; en-us; SCH-I510 4G Build/FP8) AppleWebKit/533.1 (KHTML, like Gecko) Version/4.0 Mobile Safari/533.1";
    uap.parse(header);
    stats.analyze(uap.getBrowserDetails());
    stats.dumpStats();
    
    // 234.
    header = "Mozilla/5.0 (Linux; U; Android 4.0.4; en-gb; GT-B5330L Build/IMM76D) AppleWebKit/534.30 (KHTML, like Gecko) Version/4.0 Mobile Safari/534.30";
    uap.parse(header);
    stats.analyze(uap.getBrowserDetails());
    stats.dumpStats();
    
    // 235.
    header = "Mozilla/5.0 (Linux; U; Android 2.3.6; en-us; SPH-D600 Build/GINGERBREAD) AppleWebKit/533.1 (KHTML, like Gecko) Version/4.0 Mobile Safari/533.1";
    uap.parse(header);
    stats.analyze(uap.getBrowserDetails());
    stats.dumpStats();
    
    // 236.
    header = "Mozilla/5.0 (Linux; U; Android 2.2.2; en-us; SCH-I400 Build/FROYO) AppleWebKit/533.1 (KHTML, like Gecko) Version/4.0 Mobile Safari/533.1";
    uap.parse(header);
    stats.analyze(uap.getBrowserDetails());
    stats.dumpStats();
    
    // 237.
    header = "Mozilla/5.0 (Linux; Android 4.4.2; SM-G355M Build/KOT49H) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/38.0.2125.114 Mobile Safari/537.36";
    uap.parse(header);
    stats.analyze(uap.getBrowserDetails());
    stats.dumpStats();
    
    // 238.
    header = "Mozilla/5.0 (Linux; U; Android 2.2.2; en-us; SGH-T499 Build/FROYO) AppleWebKit/533.1 (KHTML, like Gecko) Version/4.0 Mobile Safari/533.1";
    uap.parse(header);
    stats.analyze(uap.getBrowserDetails());
    stats.dumpStats();
    
    // 239.
    header = "Mozilla/5.0 (Linux; U; Android 4.1.2; en-us; SCH-R740C Build/JZO54K) AppleWebKit/534.30 (KHTML, like Gecko) Version/4.0 Mobile Safari/534.30";
    uap.parse(header);
    stats.analyze(uap.getBrowserDetails());
    stats.dumpStats();
    
    // 240.
    header = "Mozilla/5.0 (Linux; U; Android 2.3.6; en-us; SPH-D700 Build/GINGERBREAD) AppleWebKit/533.1 (KHTML, like Gecko) Version/4.0 Mobile Safari/533.1";
    uap.parse(header);
    stats.analyze(uap.getBrowserDetails());
    stats.dumpStats();
    
    // 241.
    header = "Mozilla/5.0 (Linux; U; Android 4.1.2; es-us; SGH-T599N Build/JZO54K) AppleWebKit/534.30 (KHTML, like Gecko) Version/4.0 Mobile Safari/534.30";
    uap.parse(header);
    stats.analyze(uap.getBrowserDetails());
    stats.dumpStats();
    
    // 242.
    header = "Mozilla/5.0 (Linux; U; Android 4.0.4; en-us; SAMSUNG-SGH-I577 Build/IMM76D) AppleWebKit/534.30 (KHTML, like Gecko) Version/4.0 Mobile Safari/534.30";
    uap.parse(header);
    stats.analyze(uap.getBrowserDetails());
    stats.dumpStats();
    
    // 243.
    header = "Mozilla/5.0 (Linux; U; Android 4.2.2; en-us; SAMSUNG SM-G3815/G3815XXUBMK5 Build/JDQ39) AppleWebKit/534.30 (KHTML, like Gecko) Version/4.0 Mobile Safari/534.30";
    uap.parse(header);
    stats.analyze(uap.getBrowserDetails());
    stats.dumpStats();
    
    // 244.
    header = "Mozilla/5.0 (Linux; U; Android 2.2.1; en-us; SCH-I500 Build/FROYO) AppleWebKit/533.1 (KHTML, like Gecko) Version/4.0 Mobile Safari/533.1";
    uap.parse(header);
    stats.analyze(uap.getBrowserDetails());
    stats.dumpStats();
    
    // 245.
    header = "Mozilla/5.0 (Linux; U; Android 4.2.2; en-us; GT-I9060 Build/JDQ39) AppleWebKit/534.30 (KHTML, like Gecko) Version/4.0 Mobile Safari/534.30";
    uap.parse(header);
    stats.analyze(uap.getBrowserDetails());
    stats.dumpStats();
    
    // 246.
    header = "Mozilla/5.0 (Linux; U; Android 2.2.1; en-us; SAMSUNG-SGH-I997 Build/FROYO) AppleWebKit/533.1 (KHTML, like Gecko) Version/4.0 Mobile Safari/533.1";
    uap.parse(header);
    stats.analyze(uap.getBrowserDetails());
    stats.dumpStats();
    
    // 247.
    header = "Mozilla/5.0 (Linux; U; Android 2.3.5; en-us; SCH-I110 Build/GINGERBREAD) AppleWebKit/533.1 (KHTML, like Gecko) Version/4.0 Mobile Safari/533.1";
    uap.parse(header);
    stats.analyze(uap.getBrowserDetails());
    stats.dumpStats();
    
    // 248.
    header = "Mozilla/5.0 (Linux; U; Android 2.2.2; en-us; SPH-M910 Build/FROYO) AppleWebKit/533.1 (KHTML, like Gecko) Version/4.0 Mobile Safari/533.1";
    uap.parse(header);
    stats.analyze(uap.getBrowserDetails());
    stats.dumpStats();
    
    // 249.
    header = "Mozilla/5.0 (Linux; U; Android 4.1.2; es-us; SCH-I200PP Build/JZO54K) AppleWebKit/534.30 (KHTML, like Gecko) Version/4.0 Mobile Safari/534.30";
    uap.parse(header);
    stats.analyze(uap.getBrowserDetails());
    stats.dumpStats();
    
    // 250.
    header = "Mozilla/5.0 (Linux; Android 4.4.2; es-us; SAMSUNG SGH-T399N Build/KOT49H) AppleWebKit/537.36 (KHTML, like Gecko) Version/1.5 Chrome/28.0.1500.94 Mobile Safari/537.36";
    uap.parse(header);
    stats.analyze(uap.getBrowserDetails());
    stats.dumpStats();
    
    // 251.
    header = "Mozilla/5.0 (Linux; Android 4.4.2; es-us; SAMSUNG-SGH-I527 Build/KOT49H) AppleWebKit/537.36 (KHTML, like Gecko) Version/1.5 Chrome/28.0.1500.94";
    uap.parse(header);
    stats.analyze(uap.getBrowserDetails());
    stats.dumpStats();
    
    // 252.
    header = "Mozilla/5.0 (Linux; U; Android 4.1.2; en-us; GT-S6012B Build/JZO54K) AppleWebKit/534.30 (KHTML, like Gecko) Version/4.0 Mobile Safari/534.30";
    uap.parse(header);
    stats.analyze(uap.getBrowserDetails());
    stats.dumpStats();
    
    // 253.
    header = "Mozilla/5.0 (Linux; U; Android 4.3; en-gb; SAMSUNG-SGH-I317 Build/JSS15J) AppleWebKit/534.30 (KHTML, like Gecko) Version/4.0 Mobile Safari/534.30";
    uap.parse(header);
    stats.analyze(uap.getBrowserDetails());
    stats.dumpStats();
    
    // 254.
    header = "Mozilla/5.0 (Linux; Android 4.3; en-au; SAMSUNG SM-N9005 Build/JSS15J) AppleWebKit/537.36 (KHTML, like Gecko) Version/1.5 Chrome/28.0.1500.94 Mobile Safari/537.36";
    uap.parse(header);
    stats.analyze(uap.getBrowserDetails());
    stats.dumpStats();
    
    // 255.
    header = "Mozilla/5.0 (Linux; U; Android 4.3; zh-cn; GT-N7102 Build/JSS15J) AppleWebKit/534.30 (KHTML, like Gecko) Version/4.0 Mobile Safari/534.30";
    uap.parse(header);
    stats.analyze(uap.getBrowserDetails());
    stats.dumpStats();
    
    // 256.
    header = "Mozilla/5.0 (Linux; U; Android 2.3.6; en-gb; YP-GI1 Build/GINGERBREAD) AppleWebKit/533.1 (KHTML, like Gecko) Version/4.0 Mobile Safari/533.1";
    uap.parse(header);
    stats.analyze(uap.getBrowserDetails());
    stats.dumpStats();
    
    // 257.
    header = "Mozilla/5.0 (Linux; U; Android 2.2.2; en-us; SCH-M828C[2035102674] Build/FROYO) AppleWebKit/533.1 (KHTML, like Gecko) Version/4.0 Mobile Safari";
    uap.parse(header);
    stats.analyze(uap.getBrowserDetails());
    stats.dumpStats();
    
    // 258.
    header = "Mozilla/5.0 (Linux; U; Android 2.3.6; en-us; SPH-M820-BST Build/GINGERBREAD) AppleWebKit/533.1 (KHTML, like Gecko) Version/4.0 Mobile Safari/533.1";
    uap.parse(header);
    stats.analyze(uap.getBrowserDetails());
    stats.dumpStats();
    
    // 259.
    header = "Mozilla/5.0 (Linux; U; Android 2.3.6; en-us; SPH-M580BST Build/GINGERBREAD) AppleWebKit/533.1 (KHTML, like Gecko) Version/4.0 Mobile Safari/533.1";
    uap.parse(header);
    stats.analyze(uap.getBrowserDetails());
    stats.dumpStats();
    
    // 260.
    header = "Mozilla/5.0 (Linux; U; Android 4.1.2; en-us; SPH-M950 Build/JZO54K) AppleWebKit/534.30 (KHTML, like Gecko) Version/4.0 Mobile Safari/534.30";
    uap.parse(header);
    stats.analyze(uap.getBrowserDetails());
    stats.dumpStats();
    
    // 261.
    header = "Mozilla/5.0 (Linux; U; Android 4.1.2; es-us; SPH-M840 Build/JZO54K) AppleWebKit/534.30 (KHTML, like Gecko) Version/4.0 Mobile Safari/534.30";
    uap.parse(header);
    stats.analyze(uap.getBrowserDetails());
    stats.dumpStats();
    
    // 262.
    header = "Mozilla/5.0 (Linux; U; Android 4.1.2; en-us; SAMSUNG-SGH-I547 Build/JZO54K) AppleWebKit/534.30 (KHTML, like Gecko) Version/4.0 Mobile Safari/534.30";
    uap.parse(header);
    stats.analyze(uap.getBrowserDetails());
    stats.dumpStats();
    
    // 263.
    header = "Mozilla/5.0 (Linux; U; Android 2.3.6; en-us; SAMSUNG-SGH-I847 Build/GINGERBREAD) AppleWebKit/533.1 (KHTML, like Gecko) Version/4.0 Mobile Safari/533.1";
    uap.parse(header);
    stats.analyze(uap.getBrowserDetails());
    stats.dumpStats();
    
    // 264.
    header = "Mozilla/5.0 (Linux; U; Android 4.1.2; en-us; SPH-M830 Build/JZO54K) AppleWebKit/534.30 (KHTML, like Gecko) Version/4.0 Mobile Safari/534.30";
    uap.parse(header);
    stats.analyze(uap.getBrowserDetails());
    stats.dumpStats();
    
    // 265.
    header = "Mozilla/5.0 (Linux; U; Android 4.0.4; en-ph; GT-S7562 Build/IMM76I) AppleWebKit/534.30 (KHTML, like Gecko) Version/4.0 Mobile Safari/534.30";
    uap.parse(header);
    stats.analyze(uap.getBrowserDetails());
    stats.dumpStats();
    
    // 266.
    header = "Mozilla/5.0 (Linux; Android 4.4.4; d2lte Build/KTU84Q) AppleWebKit/537.36 (KHTML, like Gecko) Version/4.0 Chrome/33.0.0.0 Mobile Safari/537.36";
    uap.parse(header);
    stats.analyze(uap.getBrowserDetails());
    stats.dumpStats();
    
    // 267.
    header = "Mozilla/5.0 (Linux; U; Android 2.3.6; en-; SAMSUNG-SGH-I727 Build/GINGERBREAD) AppleWebKit/533.1 (KHTML, like Gecko) Version/4.0 Mobile Safari/533.1";
    uap.parse(header);
    stats.analyze(uap.getBrowserDetails());
    stats.dumpStats();
    
    // 268.
    header = "Mozilla/5.0 (Linux; U; Android 2.3.6; es-es; SGH-S959G Build/GINGERBREAD) AppleWebKit/533.1 (KHTML, like Gecko) Version/4.0 Mobile Safari/533.1";
    uap.parse(header);
    stats.analyze(uap.getBrowserDetails());
    stats.dumpStats();
    
    // 269.
    header = "Mozilla/5.0 (Linux; U; Android 4.1.2; de-de; SAMSUNG GT-I8190/I8190XXANR6 Build/JZO54K) AppleWebKit/534.30 (KHTML, like Gecko) Version/4.0 Mobile Safari/534.30";
    uap.parse(header);
    stats.analyze(uap.getBrowserDetails());
    stats.dumpStats();
    
    // 270.
    header = "Mozilla/5.0 (Linux; U; Android 4.3; ar-ae; GT-I9300 Build/JSS15J) AppleWebKit/534.30 (KHTML, like Gecko) Version/4.0 Mobile Safari/534.30";
    uap.parse(header);
    stats.analyze(uap.getBrowserDetails());
    stats.dumpStats();
    
    // 271.
    header = "Mozilla/5.0 (Linux; Android 4.2.2; GT-I9300-JB2 Build/JDQ39E) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/37.0.2062.117 Mobile Safari/537.36";
    uap.parse(header);
    stats.analyze(uap.getBrowserDetails());
    stats.dumpStats();
    
    // 272.
    header = "Mozilla/5.0 (Linux; U; Android 4.1.1; it-it; SAMSUNG-SGH-I747 Build/JRO03L) AppleWebKit/534.30 (KHTML, like Gecko) Version/4.0 Mobile Safari/534.30";
    uap.parse(header);
    stats.analyze(uap.getBrowserDetails());
    stats.dumpStats();
    
    // 273.
    header = "Mozilla/5.0 (Linux; U; Android 4.4.2; en-ca; SGH-T999V Build/KOT49H) AppleWebKit/534.30 (KHTML, like Gecko) Version/4.0 Mobile Safari/534.30";
    uap.parse(header);
    stats.analyze(uap.getBrowserDetails());
    stats.dumpStats();
    
    // 274.
    header = "Mozilla/5.0 (Linux; Android 4.4.2; fr-fr; SAMSUNG-SGH-I257 Build/KOT49H) AppleWebKit/537.36 (KHTML, like Gecko) Version/1.5 Chrome/28.0.1500.94";
    uap.parse(header);
    stats.analyze(uap.getBrowserDetails());
    stats.dumpStats();
    
    // 275.
    header = "Mozilla/5.0 (Linux; Android 4.4.2; fr-ca; SGH-I257M-parrot Build/KOT49H) AppleWebKit/537.36 (KHTML, like Gecko) Version/1.5 Chrome/28.0.1500.94 Mobile Safari/537.36";
    uap.parse(header);
    stats.analyze(uap.getBrowserDetails());
    stats.dumpStats();
    
    // 276.
    header = "Mozilla/5.0 (Linux; Android 4.2.2; en-za; SAMSUNG-SGH-I337 Build/JDQ39) AppleWebKit/535.19 (KHTML, like Gecko) Version/1.0 Chrome/18.0.1025.308";
    uap.parse(header);
    stats.analyze(uap.getBrowserDetails());
    stats.dumpStats();
    
    // 277.
    header = "Mozilla/5.0 (Linux; Android 4.4.2; ko-kr; SAMSUNG-SM-G900A Build/KOT49H) AppleWebKit/537.36 (KHTML, like Gecko) Version/1.6 Chrome/28.0.1500.94";
    uap.parse(header);
    stats.analyze(uap.getBrowserDetails());
    stats.dumpStats();
    
    // 278.
    header = "Mozilla/5.0 (Linux; Android 4.4.2; zh-cn; SAMSUNG SM-G900T1 Build/KOT49H) AppleWebKit/537.36 (KHTML, like Gecko) Version/1.6 Chrome/28.0.1500.9";
    uap.parse(header);
    stats.analyze(uap.getBrowserDetails());
    stats.dumpStats();
    
    // 279.
    header = "Mozilla/5.0 (Linux; U; Android 2.2.1; en-us; SGH-T839 Build/FROYO) AppleWebKit/533.1 (KHTML, like Gecko) Version/4.0 Mobile Safari/533.1";
    uap.parse(header);
    stats.analyze(uap.getBrowserDetails());
    stats.dumpStats();
    
    // 280.
    header = "Mozilla/5.0 (Linux; U; Android 4.1.2; en-us; GT-S7262 Build/JZO54K) AppleWebKit/534.30 (KHTML, like Gecko) Version/4.0 UCBrowser/9.9.2.467 U3/0.8.0 Mobile Safari/534.30";
    uap.parse(header);
    stats.analyze(uap.getBrowserDetails());
    stats.dumpStats();
    
    // 281.
    header = "Mozilla/5.0 (Linux; U; Android 4.1.2; en-us; SCH-I200 Build/JZO54K) AppleWebKit/534.30 (KHTML, like Gecko) Version/4.0 Mobile Safari/534.30";
    uap.parse(header);
    stats.analyze(uap.getBrowserDetails());
    stats.dumpStats();
    
    // 282.
    header = "Mozilla/5.0 (Linux; U; Android 2.3.6; en-us; SCH-I405 4G Build/GC1) AppleWebKit/533.1 (KHTML, like Gecko) Version/4.0 Mobile Safari/533.1";
    uap.parse(header);
    stats.analyze(uap.getBrowserDetails());
    stats.dumpStats();
    
    // 283.
    header = "Mozilla/5.0 (Linux; U; Android 2.3.6; en-us; SPH-M930BST Build/GINGERBREAD) AppleWebKit/533.1 (KHTML, like Gecko) Version/4.0 Mobile Safari/533.1";
    uap.parse(header);
    stats.analyze(uap.getBrowserDetails());
    stats.dumpStats();
    
    // 284.
    header = "Mozilla/5.0 (Linux; U; Android 2.3.6; es-es; SGH-T959V Build/GINGERBREAD) AppleWebKit/533.1 (KHTML, like Gecko) Version/4.0 Mobile Safari/533.1";
    uap.parse(header);
    stats.analyze(uap.getBrowserDetails());
    stats.dumpStats();
    
    // 285.
    header = "Mozilla/5.0 (Linux; U; Android 4.1.2; en-us; SPH-L300 Build/JZO54K) AppleWebKit/534.30 (KHTML, like Gecko) Version/4.0 Mobile Safari/534.30";
    uap.parse(header);
    stats.analyze(uap.getBrowserDetails());
    stats.dumpStats();
    
    // 286.
    header = "Mozilla/5.0 (Linux; U; Android 2.3.6; en-us; GT-S6102B Build/GINGERBREAD) AppleWebKit/533.1 (KHTML, like Gecko) Version/4.0 Mobile Safari/533.1";
    uap.parse(header);
    stats.analyze(uap.getBrowserDetails());
    stats.dumpStats();
    
    // 287.
    header = "Mozilla/5.0 (Linux; U; Android 4.0.4; en-us; SCH-S735C Build/IMM76D) AppleWebKit/534.30 (KHTML, like Gecko) Version/4.0 Mobile Safari/534.30";
    uap.parse(header);
    stats.analyze(uap.getBrowserDetails());
    stats.dumpStats();
    
    // 288.
    header = "Mozilla/5.0 (Linux; Android 4.4.2; GT-N5100 Build/KVT49L) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/39.0.2171.93 Safari/537.36";
    uap.parse(header);
    stats.analyze(uap.getBrowserDetails());
    stats.dumpStats();
    
    // 289.
    header = "Mozilla/5.0 (Linux; Android 4.3; SM-P600 Build/JSS15J) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/40.0.2214.89 Safari/537.36";
    uap.parse(header);
    stats.analyze(uap.getBrowserDetails());
    stats.dumpStats();
    
    // 290.
    header = "Mozilla/5.0 (Linux; U; Android 4.2.2; pt-br; GT-P5113 Build/JDQ39) AppleWebKit/534.30 (KHTML, like Gecko) Version/4.0 Safari/534.30";
    uap.parse(header);
    stats.analyze(uap.getBrowserDetails());
    stats.dumpStats();
    
    // 291.
    header = "Mozilla/5.0 (Linux; U; Android 4.1.2; ko-kr; SAMSUNG-SGH-I497 Build/JZO54K) AppleWebKit/534.30 (KHTML, like Gecko) Version/4.0 Safari/534.30";
    uap.parse(header);
    stats.analyze(uap.getBrowserDetails());
    stats.dumpStats();
    
    // 292.
    header = "Mozilla/5.0 (Linux; Android 4.4.2; fr-ca; SAMSUNG SM-T230NU Build/KOT49H) AppleWebKit/537.36 (KHTML, like Gecko) Version/1.5 Chrome/28.0.1500.94 Safari/537.36";
    uap.parse(header);
    stats.analyze(uap.getBrowserDetails());
    stats.dumpStats();
    
    // 293.
    header = "Mozilla/5.0 (Linux; Android 4.4.2; ko-kr; SAMSUNG SM-T900 Build/KOT49H) AppleWebKit/537.36 (KHTML, like Gecko) Version/1.5 Chrome/28.0.1500.94 Safari/537.36";
    uap.parse(header);
    stats.analyze(uap.getBrowserDetails());
    stats.dumpStats();
    
    // 294.
    header = "Dalvik/1.6.0 (Linux; U; Android 4.4.2; SM-T900 Build/KOT49H)";
    uap.parse(header);
    stats.analyze(uap.getBrowserDetails());
    stats.dumpStats();
    
    // 295.
    header = "Mozilla/5.0 (Linux; U; Android 4.2.2; en-us; AT7-B Build/JDQ39) AppleWebKit/534.30 (KHTML, like Gecko) Version/4.0 Safari/534.30";
    uap.parse(header);
    stats.analyze(uap.getBrowserDetails());
    stats.dumpStats();
    
    // 296.
    header = "Mozilla/5.0 (Linux; Android 4.4.2; AT7-C Build/KOT49H) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/39.0.2171.93 Safari/537.36";
    uap.parse(header);
    stats.analyze(uap.getBrowserDetails());
    stats.dumpStats();
    
    // 297.
    header = "Mozilla/5.0 (Linux; U; Android 4.2.1; en-us; AT10-A Build/JOP40D) AppleWebKit/534.30 (KHTML, like Gecko) Version/4.0 Safari/534.30";
    uap.parse(header);
    stats.analyze(uap.getBrowserDetails());
    stats.dumpStats();
    
    // 298.
    header = "Mozilla/5.0 (Linux; U; Android 3.2.1; es-es; AT100 Build/HTK55D) AppleWebKit/534.13 (KHTML, like Gecko) Version/4.0 Safari/534.13";
    uap.parse(header);
    stats.analyze(uap.getBrowserDetails());
    stats.dumpStats();
    
    // 299.
    header = "Mozilla/5.0 (Linux; Android 4.1.1; AT300SE Build/JRO03C) AppleWebKit/535.19 (KHTML, like Gecko) Chrome/18.0.1025.166  Safari/535.19";
    uap.parse(header);
    stats.analyze(uap.getBrowserDetails());
    stats.dumpStats();
    
    // 300.
    header = "Mozilla/5.0 (Linux; U; Android 4.0.4; en-us; MZ617 4G Build/7.7.1-85_MZ617-27) AppleWebKit/534.30 (KHTML, like Gecko) Version/4.0 Safari/534.30";
    uap.parse(header);
    stats.analyze(uap.getBrowserDetails());
    stats.dumpStats();
    
    // 301.
    header = "Mozilla/5.0 (Linux; U; Android 4.0.3; en-us; MZ604 Build/I.7.1-34) AppleWebKit/534.30 (KHTML, like Gecko) Version/4.0 Safari/534.30";
    uap.parse(header);
    stats.analyze(uap.getBrowserDetails());
    stats.dumpStats();
    
    // 302.
    header = "Mozilla/5.0 (Linux; U; Android 4.0.3; en-us; Xoom Build/IML77) AppleWebKit/534.30 (KHTML, like Gecko) Version/4.0 Safari/534.30";
    uap.parse(header);
    stats.analyze(uap.getBrowserDetails());
    stats.dumpStats();
    
    // 303.
    header = "Mozilla/5.0 (Linux; U; Android 2.3.6; en-us; MB865 Build/5.5.1-175_EDMR1.25) AppleWebKit/533.1 (KHTML, like Gecko) Version/4.0 Mobile Safari/533.1";
    uap.parse(header);
    stats.analyze(uap.getBrowserDetails());
    stats.dumpStats();
    
    // 304.
    header = "Mozilla/5.0 (Linux; U; Android 2.2.2; en-us; MB520 Build/Blur_Version.38.6.0.MB520.Generic.en.US Flex/P002) AppleWebKit/533.1 (KHTML, like Gecko) Version/4.0 Mobile Safari/533.1";
    uap.parse(header);
    stats.analyze(uap.getBrowserDetails());
    stats.dumpStats();
    
    // 305.
    header = "Mozilla/5.0 (Linux; U; Android 2.3.7; en-us; XT555C Build/V1.67D) AppleWebKit/533.1 (KHTML, like Gecko) Version/4.0 Mobile Safari/533.1";
    uap.parse(header);
    stats.analyze(uap.getBrowserDetails());
    stats.dumpStats();
    
    // 306.
    header = "Dalvik/1.6.0 (Linux; U; Android 4.4.4; XT1254 Build/KDF21.196-8)";
    uap.parse(header);
    stats.analyze(uap.getBrowserDetails());
    stats.dumpStats();
    
    // 307.
    header = "Mozilla/5.0 (Linux; Android 4.4.4; XT830C Build/KXC21.5-40) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/34.0.1847.114 Mobile Safari/537.36";
    uap.parse(header);
    stats.analyze(uap.getBrowserDetails());
    stats.dumpStats();
    
    // 308.
    header = "Mozilla/5.0 (Linux; Android 4.4.2; XT1028 Build/KXB20.9-1.10-1.20) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/30.0.1599.92 Mobile Safari/537";
    uap.parse(header);
    stats.analyze(uap.getBrowserDetails());
    stats.dumpStats();
    
    // 309.
    header = "Mozilla/5.0 (Linux; U; Android 2.3.4; en-us; MB855 Build/4.5.1A-1_SUN-198_6) AppleWebKit/533.1 (KHTML, like Gecko) Version/4.0 Mobile Safari/533.1";
    uap.parse(header);
    stats.analyze(uap.getBrowserDetails());
    stats.dumpStats();
    
    // 310.
    header = "Mozilla/5.0 (Linux; U; Android 4.2.2; en-us; Q9H Build/JDQ39) AppleWebKit/534.30 (KHTML, like Gecko) Version/4.0 Safari/534.30";
    uap.parse(header);
    stats.analyze(uap.getBrowserDetails());
    stats.dumpStats();
    
    // 311.
    header = "Mozilla/5.0 (Linux; U; Android 4.0.4; en-gb; MOT-XT910 Build/6.7.3-94_SPI-324) AppleWebKit/534.30 (KHTML, like Gecko) Version/4.0 Mobile Safari/534.30";
    uap.parse(header);
    stats.analyze(uap.getBrowserDetails());
    stats.dumpStats();
    
    // 312.
    header = "Mozilla/5.0 (Linux; Android 4.4.2; TC70 Build/02-23245-K-07-04-01-G0-080514) AppleWebKit/537.36 (KHTML, like Gecko) Version/4.0 Chrome/30.0.0.0 Mobile Safari/537.36";
    uap.parse(header);
    stats.analyze(uap.getBrowserDetails());
    stats.dumpStats();
    
    // 313.
    header = "Mozilla/5.0 (Linux; U; Android 2.2.2; en-us; MOTWX435KT Build/FROYO) AppleWebKit/533.1 (KHTML, like Gecko) Version/4.0 Mobile Safari/533.1";
    uap.parse(header);
    stats.analyze(uap.getBrowserDetails());
    stats.dumpStats();
    
    // 314.
    header = "Mozilla/5.0 (Linux; U; Android 2.2.3; en-us; Droid Build/FRK76) AppleWebKit/533.1 (KHTML, like Gecko) Version/4.0 Mobile Safari/533.1";
    uap.parse(header);
    stats.analyze(uap.getBrowserDetails());
    stats.dumpStats();
    
    // 315.
    header = "Mozilla/5.0 (Linux; U; Android 4.0.4; en-us; DROID BIONIC 4G Build/6.7.2-223_DBN_M4-23) AppleWebKit/534.30 (KHTML, like Gecko) Version/4.0 Mobi";
    uap.parse(header);
    stats.analyze(uap.getBrowserDetails());
    stats.dumpStats();
    
    // 316.
    header = "Mozilla/5.0 (Linux; Android 4.4.4; DROID MAXX Build/KTU84Q) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/36.0.1985.135 Mobile Safari/537.36";
    uap.parse(header);
    stats.analyze(uap.getBrowserDetails());
    stats.dumpStats();
    
    // 317.
    header = "Mozilla/5.0 (Linux; U; Android 2.3.4; en-us; DROID Pro Build/4.5.1-110-VNS-35) AppleWebKit/533.1 (KHTML, like Gecko) Version/4.0 Mobile Safari/533.1";
    uap.parse(header);
    stats.analyze(uap.getBrowserDetails());
    stats.dumpStats();
    
    // 318.
    header = "Mozilla/5.0 (Linux; U; Android 2.2.1; en-us; DROIDX Build/VZW) AppleWebKit/533.1 (KHTML, like Gecko) Version/4.0 Mobile Safari/533.1 480X854 motorola DROIDX";
    uap.parse(header);
    stats.analyze(uap.getBrowserDetails());
    stats.dumpStats();
    
    // 319.
    header = "Mozilla/5.0 (Linux; U; Android 2.3.4; en-us; DROID2 GLOBAL Build/4.5.1_57_D2GA-59) AppleWebKit/533.1 (KHTML, like Gecko) Version/4.0 Mobile Safari/533.1";
    uap.parse(header);
    stats.analyze(uap.getBrowserDetails());
    stats.dumpStats();
    
    // 320.
    header = "Mozilla/5.0 (Linux; Android 4.2.2; Lenovo A369i Build/JDQ39) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/28.0.1500.94 Mobile Safari/537.36";
    uap.parse(header);
    stats.analyze(uap.getBrowserDetails());
    stats.dumpStats();
    
    // 321.
    header = "Mozilla/5.0 (Linux; Android 4.4.2; Lenovo S960 Build/KOT49H) AppleWebKit/537.36 (KHTML, like Gecko) Version/4.0 Chrome/30.0.0.0 Mobile Safari/537.36 MxBrowser/4.3.2.2000";
    uap.parse(header);
    stats.analyze(uap.getBrowserDetails());
    stats.dumpStats();
    
    // 322.
    header = "Mozilla/5.0 (Linux; U; Android 4.2.2; en-us; Lenovo A7600-F Build/JDQ39) AppleWebKit/534.30 (KHTML, like Gecko) Version/4.0 Mobile Safari/534.30";
    uap.parse(header);
    stats.analyze(uap.getBrowserDetails());
    stats.dumpStats();
    
    // 323.
    header = "Mozilla/5.0 (Linux; U; Android 4.1.2; en-us; IdeaTabA1000L-F Build/JZO54K) AppleWebKit/534.30 (KHTML, like Gecko) Version/4.0 Safari/534.30";
    uap.parse(header);
    stats.analyze(uap.getBrowserDetails());
    stats.dumpStats();
    
    // 324.
    header = "Mozilla/5.0 (Linux; U; Android 4.0.3; en-us; IdeaTab A2107A-F Build/IML74K) AppleWebKit/534.30 (KHTML, like Gecko) Version/4.0 Safari/534.30";
    uap.parse(header);
    stats.analyze(uap.getBrowserDetails());
    stats.dumpStats();
    
    // 325.
    header = "Mozilla/5.0 (Linux; Android 4.4.2; YOGA Tablet 2 Pro-1380F Build/KOT49H) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/39.0.2171.93 Safari/537.36";
    uap.parse(header);
    stats.analyze(uap.getBrowserDetails());
    stats.dumpStats();
    
    // 326.
    header = "Mozilla/5.0 (Linux; Android 4.4.2; Lenovo TAB S8-50F Build/BMAIN) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/39.0.2171.59 Safari/537.36";
    uap.parse(header);
    stats.analyze(uap.getBrowserDetails());
    stats.dumpStats();
    
    // 327.
    header = "Mozilla/5.0 (Linux; U; Android 4.0.3; en-us; ThinkPad Tablet Build/ThinkPadTablet_A400_03) AppleWebKit/534.30 (KHTML, like Gecko) Version/4.0 Safari/534.30";
    uap.parse(header);
    stats.analyze(uap.getBrowserDetails());
    stats.dumpStats();
    
    // 328.
    header = "Mozilla/5.0 (Linux; Android 4.1.1; Z992 Build/JRO03C) AppleWebKit/535.19 (KHTML, like Gecko) Chrome/18.0.1025.166 Mobile Safari/535.19";
    uap.parse(header);
    stats.analyze(uap.getBrowserDetails());
    stats.dumpStats();
    
    // 329.
    header = "Mozilla/5.0 (Linux; Android 4.0.4; ZTE N9120 Build/IMM76I) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/34.0.1847.114 Mobile Safari/537.36";
    uap.parse(header);
    stats.analyze(uap.getBrowserDetails());
    stats.dumpStats();
    
    // 330.
    header = "Mozilla/5.0 (Linux; U; Android 2.3.7; en-us; ZTE V768 Build/GINGERBREAD) AppleWebKit/533.1 (KHTML, like Gecko) Version/4.0 Mobile Safari/533.1";
    uap.parse(header);
    stats.analyze(uap.getBrowserDetails());
    stats.dumpStats();
    
    // 331.
    header = "Mozilla/5.0 (Linux; U; Android 2.3.7; en-us; Z768G Build/GINGERBREAD) AppleWebKit/533.1 (KHTML, like Gecko) Version/4.0 Mobile Safari/533.1";
    uap.parse(header);
    stats.analyze(uap.getBrowserDetails());
    stats.dumpStats();
    
    // 332.
    header = "Mozilla/5.0 (Linux; U; Android 2.3.4; en-us; ZTE-X500 Build/FRG83) AppleWebKit/533.1 (KHTML, like Gecko) Version/4.0 Mobile Safari/533.1";
    uap.parse(header);
    stats.analyze(uap.getBrowserDetails());
    stats.dumpStats();
    
    // 333.
    header = "Mozilla/5.0 (Linux; U; Android 4.2.2; en-us; V5 Build/JDQ39) AppleWebKit/534.30 (KHTML, like Gecko) Version/4.0 Mobile Safari/534.30";
    uap.parse(header);
    stats.analyze(uap.getBrowserDetails());
    stats.dumpStats();
    
    // 334.
    header = "Mozilla/5.0 (Linux; U; Android 2.3.6; en-us; X501_USA_Cricket Build/GRK39F) AppleWebKit/533.1 (KHTML, like Gecko) Version/4.0 Mobile Safari/533.1";
    uap.parse(header);
    stats.analyze(uap.getBrowserDetails());
    stats.dumpStats();
    
    // 335.
    header = "Mozilla/5.0 (Linux; Android 4.4.2; Z830 Build/KVT49L) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/38.0.2125.102 Mobile Safari/537.36";
    uap.parse(header);
    stats.analyze(uap.getBrowserDetails());
    stats.dumpStats();
    
    // 336.
    header = "Mozilla/5.0 (Linux; Android 4.1.2; Z750C Build/JZO54K) AppleWebKit/537.31 (KHTML, like Gecko) Chrome/26.0.1410.58 Mobile Safari/537.31";
    uap.parse(header);
    stats.analyze(uap.getBrowserDetails());
    stats.dumpStats();
    
    // 337.
    header = "Mozilla/5.0 (Linux; U; Android 4.1.1; en-us; Nexus S 4G Build/JRO03R) AppleWebKit/534.30 (KHTML, like Gecko) Version/4.0 Mobile Safari/534.30";
    uap.parse(header);
    stats.analyze(uap.getBrowserDetails());
    stats.dumpStats();
    
    // 338.
    header = "Mozilla/5.0 (Linux; U; Android 4.3; en-us; Galaxy Nexus Build/JWR66Y) AppleWebKit/534.30 (KHTML, like Gecko) Version/4.0 Mobile Safari/534.30";
    uap.parse(header);
    stats.analyze(uap.getBrowserDetails());
    stats.dumpStats();
    
    // 339.
    header = "Dalvik/2.1.0 (Linux; U; Android 5.0.1; Nexus 4 Build/LRX22C)";
    uap.parse(header);
    stats.analyze(uap.getBrowserDetails());
    stats.dumpStats();
    
    // 340.
    header = "Mozilla/5.0 (Linux; Android 4.2.1; en-us; Nexus 5 Build/JOP40D) AppleWebKit/535.19 (KHTML, like Gecko; Google Wireless Transcoder) Chrome/38.0.1025.166 Mobile Safari/535.19";
    uap.parse(header);
    stats.analyze(uap.getBrowserDetails());
    stats.dumpStats();
    
    // 341.
    header = "Mozilla/5.0 (Linux; Android 5.0.1; Nexus 6 Build/LRX22C) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/39.0.2171.93 Mobile Safari/537.36";
    uap.parse(header);
    stats.analyze(uap.getBrowserDetails());
    stats.dumpStats();
    
    // 342.
    header = "Mozilla/5.0 (Linux; U; Android 4.2.1; en-us; Nexus 7 Build/JOP40D) AppleWebKit/534.30 (KHTML, like Gecko) Version/4.0 Safari/534.30";
    uap.parse(header);
    stats.analyze(uap.getBrowserDetails());
    stats.dumpStats();
    
    // 343.
    header = "Mozilla/5.0 (Linux; Android 4.4.4; Nexus 7 2013 Build/KTU84Q) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/37.0.2062.117 Safari/537.36";
    uap.parse(header);
    stats.analyze(uap.getBrowserDetails());
    stats.dumpStats();
    
    // 344.
    header = "Mozilla/5.0 (Linux; Android 5.0; Nexus 9 Build/LRX21R) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/38.0.2125.509 Safari/537.36";
    uap.parse(header);
    stats.analyze(uap.getBrowserDetails());
    stats.dumpStats();
    
    // 345.
    header = "Mozilla/5.0 (Linux; Android 5.0; Nexus 10 Build/LRX21P) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/39.0.2171.59 Safari/537.36";
    uap.parse(header);
    stats.analyze(uap.getBrowserDetails());
    stats.dumpStats();
    
    // 346.
    header = "Mozilla/5.0 (Linux; U; Android 4.3; en-us; ASUS_T00F Build/JSS15Q) AppleWebKit/534.30 (KHTML, like Gecko) Version/4.0 Mobile Safari/534.30";
    uap.parse(header);
    stats.analyze(uap.getBrowserDetails());
    stats.dumpStats();
    
    // 347.
    header = "Mozilla/5.0 (Linux; Android 4.4.2; ASUS PadFone X Build/KOT49H) AppleWebKit/537.36 (KHTML, like Gecko) Version/4.0 Chrome/30.0.0.0 Mobile Safari/537.36";
    uap.parse(header);
    stats.analyze(uap.getBrowserDetails());
    stats.dumpStats();
    
    // 348.
    header = "Mozilla/5.0 (Linux; U; Android 4.0.3; en-us; Transformer TF101 Build/IML74K) AppleWebKit/534.30 (KHTML, like Gecko) Version/4.0 Safari/534.30";
    uap.parse(header);
    stats.analyze(uap.getBrowserDetails());
    stats.dumpStats();
    
    // 349.
    header = "Mozilla/5.0 (Linux; U; Android 4.2.1; en-us; ASUS Transformer Pad TF300T Build/JOP40D) AppleWebKit/534.30 (KHTML, like Gecko) Version/4.0 Safari/534.30";
    uap.parse(header);
    stats.analyze(uap.getBrowserDetails());
    stats.dumpStats();
    
    // 350.
    header = "Mozilla/5.0 (Linux; U; Android 4.1.1; en-us; Transformer Prime TF201 Build/JRO03C) AppleWebKit/534.30 (KHTML, like Gecko) Version/4.0 Safari/534.30";
    uap.parse(header);
    stats.analyze(uap.getBrowserDetails());
    stats.dumpStats();
    
    // 351.
    header = "Mozilla/5.0 (Linux; Android 4.4.2; K00C Build/KOT49H) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/37.0.2062.117 Safari/537.36";
    uap.parse(header);
    stats.analyze(uap.getBrowserDetails());
    stats.dumpStats();
    
    // 352.
    header = "Mozilla/5.0 (Linux; Android 4.4.2; K010 Build/KOT49H) AppleWebKit/537.36 (KHTML, like Gecko) Version/4.0 Chrome/30.0.0.0 Safari/537.36";
    uap.parse(header);
    stats.analyze(uap.getBrowserDetails());
    stats.dumpStats();
    
    // 353.
    header = "Mozilla/5.0 (Linux; Android 4.2.2; K00F Build/JDQ39) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/40.0.2214.89 Safari/537.36";
    uap.parse(header);
    stats.analyze(uap.getBrowserDetails());
    stats.dumpStats();
    
    // 354.
    header = "Mozilla/5.0 (Linux; U; Android 4.3; en-us; K01A Build/JSS15Q) AppleWebKit/534.30 (KHTML, like Gecko) Version/4.0 Safari/534.30";
    uap.parse(header);
    stats.analyze(uap.getBrowserDetails());
    stats.dumpStats();
    
    // 355.
    header = "Mozilla/5.0 (Linux; Android 4.4.2; K011 Build/KOT49H) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/37.0.2062.117 Safari/537.36";
    uap.parse(header);
    stats.analyze(uap.getBrowserDetails());
    stats.dumpStats();
    
    // 356.
    header = "Mozilla/5.0 (Linux; U; Android 4.1.1; en-us; ME172V Build/JRO03H) AppleWebKit/534.30 (KHTML, like Gecko) Version/4.0 Safari/534.30";
    uap.parse(header);
    stats.analyze(uap.getBrowserDetails());
    stats.dumpStats();
    
    // 357.
    header = "Mozilla/5.0 (Linux; U; Android 4.2.2; es-es; A1-810 Build/JDQ39) AppleWebKit/534.30 (KHTML, like Gecko) Version/4.0 Safari/534.30";
    uap.parse(header);
    stats.analyze(uap.getBrowserDetails());
    stats.dumpStats();
    
    // 358.
    header = "Mozilla/5.0 (Linux; Android 4.4.2; A3-A10 Build/KOT49H) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/36.0.1985.135 Safari/537.36";
    uap.parse(header);
    stats.analyze(uap.getBrowserDetails());
    stats.dumpStats();
    
    // 359.
    header = "Mozilla/5.0 (Linux; U; Android 4.1.2; en-US; B1-710 Build/JZO54K) AppleWebKit/534.30 (KHTML, like Gecko) Version/4.1 Safari/534.30";
    uap.parse(header);
    stats.analyze(uap.getBrowserDetails());
    stats.dumpStats();
    
    // 360.
    header = "Mozilla/5.0 (Linux; Android 4.4.2; b1-720 Build/KOT49H) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/40.0.2214.89 Safari/537.36";
    uap.parse(header);
    stats.analyze(uap.getBrowserDetails());
    stats.dumpStats();
    
    // 361.
    header = "Mozilla/5.0 (Linux; Android 4.2.2; B1-730HD Build/JDQ39) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/39.0.2171.59 Safari/537.36";
    uap.parse(header);
    stats.analyze(uap.getBrowserDetails());
    stats.dumpStats();
    
    // 362.
    header = "Mozilla/5.0 (Linux; Android 4.0.4; DA220HQL Build/IMM76D) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/37.0.2062.117 Safari/537.36";
    uap.parse(header);
    stats.analyze(uap.getBrowserDetails());
    stats.dumpStats();
    
    // 363.
    header = "Mozilla/5.0 (Linux; U; Android 4.2.2; en-US; A70H Build/JDQ39) AppleWebKit/533.1 (KHTML, like Gecko) Version/4.0 UCBrowser/10.0.0.488 U3/0.8.0 Mobile Safari/533.1";
    uap.parse(header);
    stats.analyze(uap.getBrowserDetails());
    stats.dumpStats();
    
    // 364.
    header = "Mozilla/5.0 (Linux; Android 4.4.2; A93 Build/KVT49L) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/39.0.2171.93 Safari/537.36";
    uap.parse(header);
    stats.analyze(uap.getBrowserDetails());
    stats.dumpStats();
    
    // 365.
    header = "Mozilla/5.0 (Linux; U; Android 4.1.2; en-US; A111 Build/JZO54K) AppleWebKit/533.1 (KHTML, like Gecko) Version/4.0 UCBrowser/10.0.0.488 U3/0.8.0 Mobile Safari/533.1";
    uap.parse(header);
    stats.analyze(uap.getBrowserDetails());
    stats.dumpStats();
    
    // 366.
    header = "Mozilla/5.0 (Linux; Android 5.0.2; A0001 Build/LRX22G) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/39.0.2171.93 Mobile Safari/537.36";
    uap.parse(header);
    stats.analyze(uap.getBrowserDetails());
    stats.dumpStats();
    
    // 367.
    header = "Mozilla/5.0 (Linux; U; Android 4.1.1; en-us; A1 Build/IMM76D) AppleWebKit/534.30 (KHTML, like Gecko) Version/4.0 Mobile Safari/534.30";
    uap.parse(header);
    stats.analyze(uap.getBrowserDetails());
    stats.dumpStats();
    
    // 368.
    header = "Mozilla/5.0 (Linux; Android 4.4.2; A1X Build/KOT49H) AppleWebKit/537.36 (KHTML, like Gecko) Version/4.0 Chrome/30.0.0.0 Safari/537.36";
    uap.parse(header);
    stats.analyze(uap.getBrowserDetails());
    stats.dumpStats();
    
    // 369.
    header = "Mozilla/5.0 (Linux; Android 4.4.2; A912 Build/KOT49H) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/34.0.1847.114 Safari/537.36";
    uap.parse(header);
    stats.analyze(uap.getBrowserDetails());
    stats.dumpStats();
    
    // 370.
    header = "Mozilla/5.0 (Linux; U; Android 4.2.2; en-us; A727 Build/JDQ39) AppleWebKit/534.30 (KHTML, like Gecko) Version/4.0 Safari/534.30";
    uap.parse(header);
    stats.analyze(uap.getBrowserDetails());
    stats.dumpStats();
    
    // 371.
    header = "Mozilla/5.0 (Linux; Android 4.2.2; A1023 Build/JDQ39) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/39.0.2171.93 Safari/537.36";
    uap.parse(header);
    stats.analyze(uap.getBrowserDetails());
    stats.dumpStats();
    
    // 372.
    header = "Mozilla/5.0 (Linux; Android 4.4.2; A1040 Build/KOT49H) AppleWebKit/537.36 (KHTML, like Gecko) Version/4.0 Chrome/30.0.0.0 Safari/537.36";
    uap.parse(header);
    stats.analyze(uap.getBrowserDetails());
    stats.dumpStats();
    
    // 373.
    header = "Mozilla/5.0 (Linux; Android 4.4.2; LGL31L Build/KOT49I.L31L10d) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/31.0.1650.59 Mobile Safari/537.36";
    uap.parse(header);
    stats.analyze(uap.getBrowserDetails());
    stats.dumpStats();
    
    // 374.
    header = "Mozilla/5.0 (Linux; U; Android 2.2.1; en-us; Ally Build/FRG83D) AppleWebKit/533.1 (KHTML, like Gecko) Version/4.0 Mobile Safari/533.1";
    uap.parse(header);
    stats.analyze(uap.getBrowserDetails());
    stats.dumpStats();
    
    // 375.
    header = "Mozilla/5.0 (Linux; U; Android 2.3.4; en-us; LG-C729 Build/GRJ22) AppleWebKit/533.1 (KHTML, like Gecko) Version/4.0 Mobile Safari/533.1 MMS/LG-Android-MMS-V1.0/1.2";
    uap.parse(header);
    stats.analyze(uap.getBrowserDetails());
    stats.dumpStats();
    
    // 376.
    header = "Mozilla/5.0 (Linux; Android 4.4.2; VS890 4G Build/KOT49I.VS89022A) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/34.0.1847.114 Mobile Safari/537.36";
    uap.parse(header);
    stats.analyze(uap.getBrowserDetails());
    stats.dumpStats();
    
    // 377.
    header = "Mozilla/5.0 (Linux; U; Android 2.3.4; en-us; LG-VS700 Build/GRJ22) AppleWebKit/533.1 (KHTML, like Gecko) Version/4.0 Mobile Safari/533.1";
    uap.parse(header);
    stats.analyze(uap.getBrowserDetails());
    stats.dumpStats();
    
    // 378.
    header = "Mozilla/5.0 (Linux; U; Android 4.0.4; en-us; LG-P870/P87010i Build/IMM76I) AppleWebKit/534.30 (KHTML, like Gecko) Version/4.0 Mobile Safari/534.30";
    uap.parse(header);
    stats.analyze(uap.getBrowserDetails());
    stats.dumpStats();
    
    // 379.
    header = "Mozilla/5.0 (Linux; U; Android 2.3.4; en-us; LG-MS910 Build/GINGERBREAD) AppleWebKit/533.1 (KHTML, like Gecko) Version/4.0 Mobile Safari/533.1";
    uap.parse(header);
    stats.analyze(uap.getBrowserDetails());
    stats.dumpStats();
    
    // 380.
    header = "Mozilla/5.0 (Linux; U; Android 4.0.3; en-us; LG-L40G/V100 Build/IML74K) AppleWebKit/534.30 (KHTML, like Gecko) Version/4.0 Mobile Safari/534.30";
    uap.parse(header);
    stats.analyze(uap.getBrowserDetails());
    stats.dumpStats();
    
    // 381.
    header = "Mozilla/5.0 (Linux; U; Android 4.4.2; en-us; LG-D950/D95020b Build/KOT49I.D95020b) AppleWebKit/537.36 (KHTML, like Gecko) Version/4.0 Chrome/30.0.1599.103 Mobile Safari/537.36";
    uap.parse(header);
    stats.analyze(uap.getBrowserDetails());
    stats.dumpStats();
    
    // 382.
    header = "Mozilla/5.0 (Linux; U; Android 4.4.2; en-us; LG-V400 Build/KOT49I.A1399997689) AppleWebKit/537.36 (KHTML, like Gecko) Version/4.0 Chrome/30.0.1599.103 Safari/537.36";
    uap.parse(header);
    stats.analyze(uap.getBrowserDetails());
    stats.dumpStats();
    
    // 383.
    header = "Mozilla/5.0 (Linux; U; Android 4.4.2; es-us; LG-V410/V41010d Build/KOT49I.V41010d) AppleWebKit/537.36 (KHTML, like Gecko) Version/4.0 Chrome/30.0.1599.103 Safari/537.36";
    uap.parse(header);
    stats.analyze(uap.getBrowserDetails());
    stats.dumpStats();
    
    // 384.
    header = "Mozilla/5.0 (Linux; Android 4.4.2; VK410 Build/KOT49I.VK41010A) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/40.0.2214.109 Safari/537.36";
    uap.parse(header);
    stats.analyze(uap.getBrowserDetails());
    stats.dumpStats();
    
    // 385.
    header = "Mozilla/5.0 (Linux; Android 4.2.2; L-01F Build/JDQ39B) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/28.0.1500.94 Mobile Safari/537.36";
    uap.parse(header);
    stats.analyze(uap.getBrowserDetails());
    stats.dumpStats();
    
    // 386.
    header = "Mozilla/5.0 (Linux; U; Android 4.4.2; es; LG-D801 Build/KOT49I.D80120e) AppleWebKit/537.36 (KHTML, like Gecko) Version/4.0 Chrome/30.0.1599.103";
    uap.parse(header);
    stats.analyze(uap.getBrowserDetails());
    stats.dumpStats();
    
    // 387.
    header = "Mozilla/5.0 (Linux; U; Android 4.4.2; en-za; LG-LS980 Build/KOT49I.LS980ZVE) AppleWebKit/537.36 (KHTML, like Gecko) Version/4.0 Chrome/30.0.1599.103 Mobile Safari/537.36";
    uap.parse(header);
    stats.analyze(uap.getBrowserDetails());
    stats.dumpStats();
    
    // 388.
    header = "Mozilla/5.0 (Linux; U; Android 2.3.4; en-us; T-Mobile G2 Build/GRJ22) AppleWebKit/533.1 (KHTML, like Gecko) Version/4.0 Mobile Safari/533.1";
    uap.parse(header);
    stats.analyze(uap.getBrowserDetails());
    stats.dumpStats();
    
    // 389.
    header = "Mozilla/5.0 (Linux; U; Android 4.4.2; en-au; LG-D851 Build/KVT49L.D85110m) AppleWebKit/537.36 (KHTML, like Gecko) Version/4.0 Chrome/34.0.1847.118 Mobile Safari/537.36";
    uap.parse(header);
    stats.analyze(uap.getBrowserDetails());
    stats.dumpStats();
    
    // 390.
    header = "Mozilla/5.0 (Linux; Android 4.4.4; LG-ls990 Build/KTU84Q) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/39.0.2171.59 Mobile Safari/537.36";
    uap.parse(header);
    stats.analyze(uap.getBrowserDetails());
    stats.dumpStats();
    
    // 391.
    header = "Mozilla/5.0 (Linux; Android 4.2.2; LG Google TV TV Build/JDQ39) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/29.0.1547.80 Safari/537.36";
    uap.parse(header);
    stats.analyze(uap.getBrowserDetails());
    stats.dumpStats();
    
    // 392.
    header = "Mozilla/5.0 (Linux; U; Android 4.0.4; en-us; VS840PP Build/IMM76D) AppleWebKit/534.30 (KHTML, like Gecko) Version/4.0 Mobile Safari/534.30";
    uap.parse(header);
    stats.analyze(uap.getBrowserDetails());
    stats.dumpStats();
    
    // 393.
    header = "Mozilla/5.0 (Linux; U; Android 2.3.4; en-us; LG-LG855 Build/GRJ22) AppleWebKit/533.1 (KHTML, like Gecko) Version/4.0 Mobile Safari/533.1";
    uap.parse(header);
    stats.analyze(uap.getBrowserDetails());
    stats.dumpStats();
    
    // 394.
    header = "Mozilla/5.0 (Linux; U; Android 4.4.2; en; LG-E980/E98020h Build/KOT49I.E98020h) AppleWebKit/537.36 (KHTML, like Gecko) Version/4.0 Chrome/30.0.1599.103 Mobile Safari/537.36";
    uap.parse(header);
    stats.analyze(uap.getBrowserDetails());
    stats.dumpStats();
    
    // 395.
    header = "Mozilla/5.0 (Linux; U; Android 4.4.2; en-us; LG-F240K/20g Build/KOT49I.F240K20g) AppleWebKit/537.36 (KHTML, like Gecko) Version/4.0 Chrome/30.0";
    uap.parse(header);
    stats.analyze(uap.getBrowserDetails());
    stats.dumpStats();
    
    // 396.
    header = "Mozilla/5.0 (Linux; U; Android 2.3.6; en-us; LG-L38C Build/GRK39F) AppleWebKit/533.1 (KHTML, like Gecko) Version/4.0 Mobile Safari/533.1 MMS/LG";
    uap.parse(header);
    stats.analyze(uap.getBrowserDetails());
    stats.dumpStats();
    
    // 397.
    header = "Mozilla/5.0 (Linux; U; Android 2.3.3; en-us; LS670 Build/GRI40) AppleWebKit/533.1 (KHTML, like Gecko) Version/4.0 Mobile Safari/533.1";
    uap.parse(header);
    stats.analyze(uap.getBrowserDetails());
    stats.dumpStats();
    
    // 398.
    header = "Mozilla/5.0 (Linux; U; Android 4.1.2; es-mx; LGMS500 Build/JZO54K) AppleWebKit/534.30 (KHTML, like Gecko) Version/4.0 Mobile Safari/534.30";
    uap.parse(header);
    stats.analyze(uap.getBrowserDetails());
    stats.dumpStats();
    
    // 399.
    header = "Mozilla/5.0 (Linux; U; Android 2.3.4; en-us; LG-VM701 Build/GRJ22) AppleWebKit/533.1 (KHTML, like Gecko) Version/4.0 Mobile Safari/533.1";
    uap.parse(header);
    stats.analyze(uap.getBrowserDetails());
    stats.dumpStats();
    
    // 400.
    header = "Mozilla/5.0 (Linux; U; Android 2.2.1; en-us; VM670 Build/FRG83) AppleWebKit/533.1 (KHTML, like Gecko) Version/4.0 Mobile Safari/533.1";
    uap.parse(header);
    stats.analyze(uap.getBrowserDetails());
    stats.dumpStats();
    
    // 401.
    header = "Mozilla/5.0 (Linux; Android 4.4.2; VS415PP Build/KOT49I.VS415PP1) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/31.0.1650.59 Mobile Safari/537.36";
    uap.parse(header);
    stats.analyze(uap.getBrowserDetails());
    stats.dumpStats();
    
    // 402.
    header = "Mozilla/5.0 (Linux; U; Android 3.1; en-us; LG-V909 Build/HMJ37) AppleWebKit/534.13 (KHTML, like Gecko) Version/4.0 Safari/534.13";
    uap.parse(header);
    stats.analyze(uap.getBrowserDetails());
    stats.dumpStats();
    
    // 403.
    header = "Mozilla/5.0 (Linux; U; Android 4.4.2; fr-fr; LGLS740 Build/KOT49I.LS740ZV4) AppleWebKit/537.36 (KHTML, like Gecko) Version/4.0 Chrome/30.0.1599.103 Mobile Safari/537.36";
    uap.parse(header);
    stats.analyze(uap.getBrowserDetails());
    stats.dumpStats();
    
    // 404.
    header = "Mozilla/5.0 (Linux; U; Android 4.0.3; zh-cn; Amaze_4G Build/IML74K) AppleWebKit/534.30 (KHTML, like Gecko) Version/4.0 Mobile Safari/534.30";
    uap.parse(header);
    stats.analyze(uap.getBrowserDetails());
    stats.dumpStats();
    
    // 405.
    header = "Mozilla/5.0 (Linux; U; Android 4.4.2; en-us; HTCDESIRE Build/KOT49H) AppleWebKit/534.30 (KHTML, like Gecko) Version/4.0 Mobile Safari/534.30";
    uap.parse(header);
    stats.analyze(uap.getBrowserDetails());
    stats.dumpStats();
    
    // 406.
    header = "Mozilla/5.0 (Linux; U; Android 4.4.2; fr-ca; HTC_Desire_601-parrot Build/KOT49H) AppleWebKit/534.30 (KHTML, like Gecko) Version/4.0 Mobile Safari/534.30";
    uap.parse(header);
    stats.analyze(uap.getBrowserDetails());
    stats.dumpStats();
    
    // 407.
    header = "Mozilla/5.0 (Linux; U; Android 2.3.3; en-us; Desire HD Build/GRI40) AppleWebKit/533.1 (KHTML, like Gecko) Version/4.0 Mobile Safari/533.1";
    uap.parse(header);
    stats.analyze(uap.getBrowserDetails());
    stats.dumpStats();
    
    // 408.
    header = "Mozilla/5.0 (Linux; U; Android 2.3.3; en-us; pcdadr6350 Build/GRI40) AppleWebKit/533.1 (KHTML, like Gecko) Version/4.0 Mobile Safari/533.1";
    uap.parse(header);
    stats.analyze(uap.getBrowserDetails());
    stats.dumpStats();
    
    // 409.
    header = "Mozilla/5.0 (Linux; U; Android 4.1.1; en-us; EVO Build/JRO03C) AppleWebKit/534.30 (KHTML, like Gecko) Version/4.0 Mobile Safari/534.30";
    uap.parse(header);
    stats.analyze(uap.getBrowserDetails());
    stats.dumpStats();
    
    // 410.
    header = "Mozilla/5.0 (Linux; U; Android 4.0.3; en-us; Sprint APC715CKT Build/IML74K) AppleWebKit/534.30 (KHTML, like Gecko) Version/4.0 Mobile Safari/534.30";
    uap.parse(header);
    stats.analyze(uap.getBrowserDetails());
    stats.dumpStats();
    
    // 411.
    header = "Mozilla/5.0 (Linux; Android 4.2.2; C525c Build/JDQ39) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/28.0.1500.94 Mobile Safari/537.36";
    uap.parse(header);
    stats.analyze(uap.getBrowserDetails());
    stats.dumpStats();
    
    // 412.
    header = "Mozilla/5.0 (Linux; U; Android 4.4.2; pt-us; HTC_PN07120/5.12.502.2 Build/KOT49H) AppleWebKit/534.30 (KHTML, like Gecko) Version/4.0 Mobile Safari/534.30";
    uap.parse(header);
    stats.analyze(uap.getBrowserDetails());
    stats.dumpStats();
    
    // 413.
    header = "Mozilla/5.0 (Linux; U; Android 4.1.1; es-us; M7 Build/JRO03H) AppleWebKit/534.30 (KHTML, like Gecko) Version/4.0 Safari/534.30";
    uap.parse(header);
    stats.analyze(uap.getBrowserDetails());
    stats.dumpStats();
    
    // 414.
    header = "Mozilla/5.0 (Linux; U; Android 2.3.5; en-fr; HTC_Rhyme_S510b Build/GRJ90) AppleWebKit/533.1 (KHTML, like Gecko) Version/4.0 Mobile Safari/533.1";
    uap.parse(header);
    stats.analyze(uap.getBrowserDetails());
    stats.dumpStats();
    
    // 415.
    header = "Mozilla/5.0 (Linux; U; Android 4.4.2; en-us; 0PAJ5 Build/KOT49H) AppleWebKit/534.30 (KHTML, like Gecko) Version/4.0 Mobile Safari/534.30";
    uap.parse(header);
    stats.analyze(uap.getBrowserDetails());
    stats.dumpStats();
    
    // 416.
    header = "Mozilla/5.0 (Linux; Android 4.1.2; Nokia_XL Build/JZO54K) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/30.0.1599.82 Mobile Safari/537.36 NokiaBrowser/1.0.1.54";
    uap.parse(header);
    stats.analyze(uap.getBrowserDetails());
    stats.dumpStats();
    
    // 417.
    header = "Mozilla/5.0 (Linux; U; Android 4.1.2; en-us; N800 Build/JZO54K) AppleWebKit/534.30 (KHTML, like Gecko) Version/4.0 Mobile Safari/534.30";
    uap.parse(header);
    stats.analyze(uap.getBrowserDetails());
    stats.dumpStats();
    
    // 418.
    header = "Mozilla/5.0 (Linux; U; Android 4.3; en-us; N9002 Build/JDQ39) AppleWebKit/534.30 (KHTML, like Gecko) Version/4.0 Mobile Safari/534.30";
    uap.parse(header);
    stats.analyze(uap.getBrowserDetails());
    stats.dumpStats();
    
    // 419.
    header = "Mozilla/5.0 (Linux; U; Android 2.3.5; en-us; N860 Build/GINGERBREAD) AppleWebKit/533.1 (KHTML, like Gecko) Version/4.0 Mobile Safari/533.1";
    uap.parse(header);
    stats.analyze(uap.getBrowserDetails());
    stats.dumpStats();
    
    // 420.
    header = "Mozilla/5.0 (Linux; U; Android 4.3; en-us; HUAWEI Y336-A1 Build/HuaweiY336-A1) AppleWebKit/534.30 (KHTML, like Gecko) Version/4.0 Mobile Safari/534.30";
    uap.parse(header);
    stats.analyze(uap.getBrowserDetails());
    stats.dumpStats();
    
    // 421.
    header = "Mozilla/5.0 (Linux; U; Android 4.1.1; en-us; Orange Daytona Build/C224B197) AppleWebKit/534.30 (KHTML, like Gecko) Version/4.0 Mobile Safari/534.30";
    uap.parse(header);
    stats.analyze(uap.getBrowserDetails());
    stats.dumpStats();
    
    // 422.
    header = "Mozilla/5.0 (Linux; U; Android 4.0.3; en-us; SpringBoard Build/HuaweiMediaPad) AppleWebKit/534.30 (KHTML, like Gecko) Version/4.0 Safari/534.30";
    uap.parse(header);
    stats.analyze(uap.getBrowserDetails());
    stats.dumpStats();
    
    // 423.
    header = "Mozilla/5.0 (Linux; U; Android 2.3.4; en-; IM-A760S Build/GINGERBREAD) AppleWebKit/533.1 (KHTML, like Gecko) Version/4.0 Mobile Safari/533.1";
    uap.parse(header);
    stats.analyze(uap.getBrowserDetails());
    stats.dumpStats();
    
    // 424.
    header = "Mozilla/5.0 (Linux; U; Android 2.2.1; en-us; PantechP8000 Build/FRG83) AppleWebKit/533.1 (KHTML, like Gecko) Version/4.0 Mobile Safari/533.1";
    uap.parse(header);
    stats.analyze(uap.getBrowserDetails());
    stats.dumpStats();
    
    // 425.
    header = "Mozilla/5.0 (Linux; Android 4.1.1; Le Pan S Build/JRO03L) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/39.0.2171.93 Safari/537.36";
    uap.parse(header);
    stats.analyze(uap.getBrowserDetails());
    stats.dumpStats();
    
    // 426.
    header = "Mozilla/5.0 (Linux; Android 4.1.1; M97 Build/JRO03L) AppleWebKit/535.19 (KHTML, like Gecko) Chrome/18.0.1025.166  Safari/535.19";
    uap.parse(header);
    stats.analyze(uap.getBrowserDetails());
    stats.dumpStats();
    
    // 427.
    header = "Mozilla/5.0 (Linux; Android 4.2.2; HG-9041 Build/JDQ39) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/28.0.1500.94 Safari/537.36";
    uap.parse(header);
    stats.analyze(uap.getBrowserDetails());
    stats.dumpStats();
    
    // 428.
    header = "Mozilla/5.0 (Linux; U; Android 4.2.2; en-us; ALCATEL 4015T Build/JDQ39) AppleWebKit/534.30 (KHTML, like Gecko) Version/4.2 Mobile Safari/534.30";
    uap.parse(header);
    stats.analyze(uap.getBrowserDetails());
    stats.dumpStats();
    
    // 429.
    header = "Mozilla/5.0 (Linux; U; Android 4.2.2; en-us; ALCATEL ONE TOUCH Fierce Build/JDQ39) AppleWebKit/533.1 (KHTML, like Gecko) Version/4.0 UCBrowser/9.9.2.467 U3/0.8.0 Mobile Safari/533.1";
    uap.parse(header);
    stats.analyze(uap.getBrowserDetails());
    stats.dumpStats();
    
    // 430.
    header = "Mozilla/5.0 (Linux; U; Android 4.2.2; en-us; ALCATEL ONETOUCH P310A Build/JDQ39) AppleWebKit/534.30 (KHTML, like Gecko) Version/4.2 Mobile Safari/534.30";
    uap.parse(header);
    stats.analyze(uap.getBrowserDetails());
    stats.dumpStats();
    
    // 431.
    header = "Dalvik/1.6.0 (Linux; U; Android 4.4.2; Venue 7 3730 Build/KOT49H)";
    uap.parse(header);
    stats.analyze(uap.getBrowserDetails());
    stats.dumpStats();
    
    // 432.
    header = "Mozilla/5.0 (Linux; Android 4.4.4; Venue7 3740 Build/KTU84P) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/35.0.1916.141 Safari/537.36";
    uap.parse(header);
    stats.analyze(uap.getBrowserDetails());
    stats.dumpStats();
    
    // 433.
    header = "Mozilla/5.0 (Linux; U; Android 4.2.2; en-us; Venue 8 3830 Build/JDQ39) AppleWebKit/534.30 (KHTML, like Gecko) Version/4.0 Safari/534.30";
    uap.parse(header);
    stats.analyze(uap.getBrowserDetails());
    stats.dumpStats();
    
    // 434.
    header = "Mozilla/5.0 (Linux; Android 4.4.4; Venue8 3840 Build/KTU84P) AppleWebKit/537.36 (KHTML, like Gecko) Version/4.0 Chrome/33.0.0.0 Safari/537.36";
    uap.parse(header);
    stats.analyze(uap.getBrowserDetails());
    stats.dumpStats();
    
    // 435.
    header = "Dalvik/1.6.0 (Linux; U; Android 4.4.4; SGP612 Build/23.0.1.A.0.167)";
    uap.parse(header);
    stats.analyze(uap.getBrowserDetails());
    stats.dumpStats();
    
    // 436.
    header = "Mozilla/5.0 (Linux; U; Android 4.0.3; en-us; SGPT12 Build/TISU0105) AppleWebKit/534.30 (KHTML, like Gecko) Version/4.0 Safari/534.30";
    uap.parse(header);
    stats.analyze(uap.getBrowserDetails());
    stats.dumpStats();
    
    // 437.
    header = "Mozilla/5.0 (Linux; U; Android 2.3.4; en-us; SonyEricssonLT18i Build/4.0.2.A.0.62) AppleWebKit/533.1 (KHTML, like Gecko) Version/4.0 Mobile Safari/533.1";
    uap.parse(header);
    stats.analyze(uap.getBrowserDetails());
    stats.dumpStats();
    
    // 438.
    header = "Mozilla/5.0 (Linux; U; Android 2.3.4; en-us; SonyEricssonLT18i-o Build/4.0.2.A.0.62) AppleWebKit/533.1 (KHTML, like Gecko) Version/4.0 Mobile Safari/533.1";
    uap.parse(header);
    stats.analyze(uap.getBrowserDetails());
    stats.dumpStats();
    
    // 439.
    header = "Mozilla/5.0 (Linux; U; Android 2.3.4; en-us; SonyEricssonR800x Build/4.0.2.E.0.57) AppleWebKit/533.1 (KHTML, like Gecko) Version/4.0 Mobile Safari/533.1";
    uap.parse(header);
    stats.analyze(uap.getBrowserDetails());
    stats.dumpStats();
    
    // 440.
    header = "Mozilla/5.0 (Linux; U; Android 2.3.7; en-us; SonyEricssonLT28at Build/6.0.C.1.257) AppleWebKit/533.1 (KHTML, like Gecko) Version/4.0 Mobile Safari/533.1";
    uap.parse(header);
    stats.analyze(uap.getBrowserDetails());
    stats.dumpStats();
    
    // 441.
    header = "Mozilla/5.0 (Linux; U; Android 2.3.7; en-us; SonyEricssonST25a Build/6.0.B.3.184) AppleWebKit/533.1 (KHTML, like Gecko) Version/4.0 Mobile Safari/533.1";
    uap.parse(header);
    stats.analyze(uap.getBrowserDetails());
    stats.dumpStats();
    
    // 442.
    header = "Mozilla/5.0 (Linux; Android 4.0.3; Sony Tablet S Build/TISU0143) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/34.0.1847.114 Safari/537.36";
    uap.parse(header);
    stats.analyze(uap.getBrowserDetails());
    stats.dumpStats();
    
    // 443.
    header = "Mozilla/5.0 (Linux; U; Android 4.0.4; en-us; SonyST21a Build/11.0.A.4.22) AppleWebKit/534.30 (KHTML, like Gecko) Version/4.0 Mobile Safari/534.30";
    uap.parse(header);
    stats.analyze(uap.getBrowserDetails());
    stats.dumpStats();
    
    // 444.
    header = "Mozilla/5.0 (Linux; U; Android 4.1.2; en-us; SonyLT26ii Build/6.2.B.1.96) AppleWebKit/534.30 (KHTML, like Gecko) Version/4.0 Mobile Safari/534.30";
    uap.parse(header);
    stats.analyze(uap.getBrowserDetails());
    stats.dumpStats();
    
    // 445.
    header = "Mozilla/5.0 (Linux; U; Android 4.1.2; en-us; SonyLT30at Build/9.1.F.1.120) AppleWebKit/534.30 (KHTML, like Gecko) Version/4.0 Mobile Safari/534.30";
    uap.parse(header);
    stats.analyze(uap.getBrowserDetails());
    stats.dumpStats();
    
    // 446.
    header = "Mozilla/5.0 (Linux; Android 4.1.2; C2104 Build/15.0.A.2.17) AppleWebKit/537.31 (KHTML, like Gecko) Chrome/26.0.1410.58 Mobile Safari/537.31";
    uap.parse(header);
    stats.analyze(uap.getBrowserDetails());
    stats.dumpStats();
    
    // 447.
    header = "Mozilla/5.0 (Linux; Android 4.2.2; C2105 Build/15.3.A.1.14) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/28.0.1500.94 Mobile Safari/537.36";
    uap.parse(header);
    stats.analyze(uap.getBrowserDetails());
    stats.dumpStats();
    
    // 448.
    header = "Mozilla/5.0 (Linux; Android 5.0; C6806_GPe Build/LRX21P.S3) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/39.0.2171.93 Mobile Safari/537.36";
    uap.parse(header);
    stats.analyze(uap.getBrowserDetails());
    stats.dumpStats();
    
    // 449.
    header = "Mozilla/5.0 (Linux; Android 4.1.2; LT22i Build/6.2.A.1.100) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/40.0.2214.89 Mobile Safari/537.36";
    uap.parse(header);
    stats.analyze(uap.getBrowserDetails());
    stats.dumpStats();
    
    // 450.
    header = "Mozilla/5.0 (Linux; Android 4.0.4; LT28at Build/6.1.C.1.111) AppleWebKit/535.19 (KHTML, like Gecko) Chrome/18.0.1025.166 Mobile Safari/535.19";
    uap.parse(header);
    stats.analyze(uap.getBrowserDetails());
    stats.dumpStats();
    
    // 451.
    header = "Mozilla/5.0 (Linux; Android 4.1.2; LT30at Build/9.1.F.1.120) AppleWebKit/535.19 (KHTML, like Gecko) Chrome/18.0.1025.166 Mobile Safari/535.19";
    uap.parse(header);
    stats.analyze(uap.getBrowserDetails());
    stats.dumpStats();
    
    // 452.
    header = "Mozilla/5.0 (Linux; Android 4.1.2; ST26a Build/11.2.A.0.31) AppleWebKit/535.19 (KHTML, like Gecko) Chrome/18.0.1025.166 Mobile Safari/535.19";
    uap.parse(header);
    stats.analyze(uap.getBrowserDetails());
    stats.dumpStats();
    
    // 453.
    header = "Mozilla/5.0 (Linux; Android 4.1.2; ST26i Build/11.2.A.0.31) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/39.0.2171.93 Mobile Safari/537.36";
    uap.parse(header);
    stats.analyze(uap.getBrowserDetails());
    stats.dumpStats();
    
    // 454.
    header = "Mozilla/5.0 (Linux; Android 4.4.2; D5316 Build/19.1.A.0.486) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/39.0.2171.93 Mobile Safari/537.36";
    uap.parse(header);
    stats.analyze(uap.getBrowserDetails());
    stats.dumpStats();
    
    // 455.
    header = "Mozilla/5.0 (Linux; Android 4.2.2; Trio AXS 3G Build/JDQ39) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/37.0.2062.117 Safari/537.36";
    uap.parse(header);
    stats.analyze(uap.getBrowserDetails());
    stats.dumpStats();
    
    // 456.
    header = "Mozilla/5.0 (Linux; U; Android 4.2.2; en-us; Trio AXS 4G Build/JDQ39) AppleWebKit/534.30 (KHTML, like Gecko) Version/4.0 Safari/534.30";
    uap.parse(header);
    stats.analyze(uap.getBrowserDetails());
    stats.dumpStats();
    
    // 457.
    header = "Mozilla/5.0 (Linux; Android 4.4.2; Trio 7.85 vQ Build/Trio_7.85_vQ) AppleWebKit/537.36 (KHTML, like Gecko) Version/4.0 Chrome/30.0.0.0 Safari/537.36";
    uap.parse(header);
    stats.analyze(uap.getBrowserDetails());
    stats.dumpStats();
    
    // 458.
    header = "Mozilla/5.0 (Linux; Android 4.4.2; Trio Stealth G4 7 Build/KOT49H) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/31.0.1650.59 Safari/537.36";
    uap.parse(header);
    stats.analyze(uap.getBrowserDetails());
    stats.dumpStats();
    
    // 459.
    header = "Mozilla/5.0 (Linux; Android 4.4.2; Trio Stealth G4 7 v2 Build/KOT49H) AppleWebKit/537.36 (KHTML, like Gecko) Version/4.0 Chrome/30.0.0.0 Safari/537.36";
    uap.parse(header);
    stats.analyze(uap.getBrowserDetails());
    stats.dumpStats();
    
    // 460.
    header = "Mozilla/5.0 (Linux; Android 4.4.2; TRIO-7.85 Build/KVT49L) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/35.0.1916.141 Safari/537.36";
    uap.parse(header);
    stats.analyze(uap.getBrowserDetails());
    stats.dumpStats();
    
    // 461.
    header = "Mozilla/5.0 (Linux; Android 4.4.2; Trio-Stealth G4 10.1 Build/KOT49H) AppleWebKit/537.36 (KHTML, like Gecko) Version/4.0 Chrome/30.0.0.0 Safari/537.36";
    uap.parse(header);
    stats.analyze(uap.getBrowserDetails());
    stats.dumpStats();
    
    // 462.
    header = "Mozilla/5.0 (Linux; U; Android 4.1.1; en-us; Trio Stealth_10 Build/JR003C.20130630) AppleWebKit/534.30 (KHTML, like Gecko) Version/4.0 Safari/534.30";
    uap.parse(header);
    stats.analyze(uap.getBrowserDetails());
    stats.dumpStats();
    
    // 463.
    header = "Mozilla/5.0 (Linux; U; Android 4.1.1; en-us; Trio Stealth_8 Build/JR003C.20131024) AppleWebKit/534.30 (KHTML, like Gecko) Version/4.0 Safari/534.30";
    uap.parse(header);
    stats.analyze(uap.getBrowserDetails());
    stats.dumpStats();
    
    // 464.
    header = "Mozilla/5.0 (Linux; Android 4.4.2; JLab PRO-7 Build/KOT49H) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/35.0.1916.141 Safari/537.36";
    uap.parse(header);
    stats.analyze(uap.getBrowserDetails());
    stats.dumpStats();
    
    // 465.
    header = "Mozilla/5.0 (Linux; Android 4.4.2; X-treme Play Tab Build/KOT49H) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/39.0.2171.93 Safari/537.36";
    uap.parse(header);
    stats.analyze(uap.getBrowserDetails());
    stats.dumpStats();
    
    // 466.
    header = "Mozilla/5.0 (Linux; Android 4.1.1; HP Slate 7 Build/JRO03H) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/40.0.2214.109 Safari/537.36";
    uap.parse(header);
    stats.analyze(uap.getBrowserDetails());
    stats.dumpStats();
    
    // 467.
    header = "Mozilla/5.0 (Linux; Android 4.2.2; HP 7 Plus Build/1.1.5_WW-ILEX-11) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/28.0.1500.94 Safari/537.36";
    uap.parse(header);
    stats.analyze(uap.getBrowserDetails());
    stats.dumpStats();
    
    // 468.
    header = "Mozilla/5.0 (Linux; U; Android 4.2.2; en-us; HP Slate 10 HD Build/JDQ39) AppleWebKit/534.30 (KHTML, like Gecko) Version/4.0 Safari/534.30";
    uap.parse(header);
    stats.analyze(uap.getBrowserDetails());
    stats.dumpStats();
    
    // 469.
    header = "Mozilla/5.0 (Linux; Android 4.2.2; HP Slate 7 HD Build/JDQ39) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/28.0.1500.94 Safari/537.36";
    uap.parse(header);
    stats.analyze(uap.getBrowserDetails());
    stats.dumpStats();
    
    // 470.
    header = "Mozilla/5.0 (Linux; U; Android 4.2.2; en-us; HP Slate 7 Plus Build/JDQ39) AppleWebKit/534.30 (KHTML, like Gecko) Version/4.0 Safari/534.30";
    uap.parse(header);
    stats.analyze(uap.getBrowserDetails());
    stats.dumpStats();
    
    // 471.
    header = "Mozilla/5.0 (Linux; Android 4.2.2; Slate 21 Build/JDQ39) AppleWebKit/537.31 (KHTML, like Gecko) Chrome/26.0.1410.58 Safari/537.31";
    uap.parse(header);
    stats.analyze(uap.getBrowserDetails());
    stats.dumpStats();
    
    // 472.
    header = "Mozilla/5.0 (Linux; U; Android 4.3; en-us; Slate 21 Pro Build/JSS15J) AppleWebKit/534.30 (KHTML, like Gecko) Version/4.0 Safari/534.30";
    uap.parse(header);
    stats.analyze(uap.getBrowserDetails());
    stats.dumpStats();
    
    // 473.
    header = "Mozilla/5.0 (Linux; Android 4.3; HP SlateBook 10 x2 PC Build/4.3-17r20-05-24) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/38.0.2125.102 Safari/537.36";
    uap.parse(header);
    stats.analyze(uap.getBrowserDetails());
    stats.dumpStats();
    
    // 474.
    header = "Mozilla/5.0 (Linux; Android 4.3; HP SlateBook 14 PC Build/4.3-17r21-15-15) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/38.0.2125.102 Safari/537.36";
    uap.parse(header);
    stats.analyze(uap.getBrowserDetails());
    stats.dumpStats();
    
    // 475.
    header = "Mozilla/5.0 (Linux; Android 4.4.2; HP 10 Build/KOT49H) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/40.0.2214.109 Safari/537.36";
    uap.parse(header);
    stats.analyze(uap.getBrowserDetails());
    stats.dumpStats();
    
    // 476.
    header = "Mozilla/5.0 (Linux; Android 4.4.2; HP 10 Plus Build/KOT49H) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/39.0.2171.93 Safari/537.36";
    uap.parse(header);
    stats.analyze(uap.getBrowserDetails());
    stats.dumpStats();
    
    // 477.
    header = "Mozilla/5.0 (Linux; Android 4.4.2; HP 7 G2 Build/KVT49L) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/40.0.2214.89 Safari/537.36";
    uap.parse(header);
    stats.analyze(uap.getBrowserDetails());
    stats.dumpStats();
    
    // 478.
    header = "Mozilla/5.0 (Linux; Android 4.4.2; HP 8 G2 Build/KVT49L) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/39.0.2171.93 Safari/537.36";
    uap.parse(header);
    stats.analyze(uap.getBrowserDetails());
    stats.dumpStats();
    
    // 479.
    header = "Mozilla/5.0 (Linux; Android 4.4.2; HP Slate 7 Beats Special Edition Build/KOT49H) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/31.0.1650.59 Safari/537.36";
    uap.parse(header);
    stats.analyze(uap.getBrowserDetails());
    stats.dumpStats();
    
    // 480.
    header = "Mozilla/5.0 (Linux; Android 4.4.2; HP Slate7 Extreme Build/KOT49H) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/36.0.1985.135 Safari/537.36";
    uap.parse(header);
    stats.analyze(uap.getBrowserDetails());
    stats.dumpStats();
    
    // 481.
    header = "Mozilla/5.0 (Linux; Android 4.4.4; TouchPad Build/KTU84Q) AppleWebKit/537.36 (KHTML, like Gecko) Version/4.0 Chrome/33.0.0.0 Safari/537.36";
    uap.parse(header);
    stats.analyze(uap.getBrowserDetails());
    stats.dumpStats();
    
    // 482.
    header = "Mozilla/5.0 (Linux; U; Android 4.1.1; en-us; HP Slate 7 Build/JRO03H) AppleWebKit/534.30 (KHTML, like Gecko) Version/4.0 Safari/534.30";
    uap.parse(header);
    stats.analyze(uap.getBrowserDetails());
    stats.dumpStats();
    
    // 483.
    header = "Mozilla/5.0 (Linux; U; Android 4.1.2; en-us; HP 7 Build/JZO54K) AppleWebKit/534.30 (KHTML, like Gecko) Version/4.0 Safari/534.30";
    uap.parse(header);
    stats.analyze(uap.getBrowserDetails());
    stats.dumpStats();
    
    // 484.
    header = "Mozilla/5.0 (Linux; U; Android 4.0.3; en-us; cm_tenderloin Build/GWK74) AppleWebKit/534.30 (KHTML, like Gecko) Version/4.0 Safari/534.30";
    uap.parse(header);
    stats.analyze(uap.getBrowserDetails());
    stats.dumpStats();
    
    // 485.
    header = "Mozilla/5.0 (Linux; Android 4.4.2; E6782 Build/KOT49H) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/35.0.1916.122 Mobile Safari/537.36";
    uap.parse(header);
    stats.analyze(uap.getBrowserDetails());
    stats.dumpStats();
    
    // 486.
    header = "Mozilla/5.0 (Linux; Android 4.4.2; KYOCERA-E6560 Build/KVT49L) AppleWebKit/537.36 (KHTML, like Gecko) Version/4.0 Chrome/30.0.0.0 Mobile Safari/537.36";
    uap.parse(header);
    stats.analyze(uap.getBrowserDetails());
    stats.dumpStats();
    
    // 487.
    header = "Mozilla/5.0 (Linux; U; Android 4.0.4; en-us; C5170 Build/IML77) AppleWebKit/534.30 (KHTML, like Gecko) Version/4.0 Mobile Safari/534.30";
    uap.parse(header);
    stats.analyze(uap.getBrowserDetails());
    stats.dumpStats();
    
    // 488.
    header = "Mozilla/5.0 (Linux; U; Android 4.1.2; en-us; C5215 Build/JZO54K) AppleWebKit/534.30 (KHTML, like Gecko) Version/4.0 Mobile Safari/534.30";
    uap.parse(header);
    stats.analyze(uap.getBrowserDetails());
    stats.dumpStats();
    
    // 489.
    header = "Mozilla/5.0 (Linux; U; Android 4.1.2; es-us; C6522N Build/JZO54K) AppleWebKit/534.30 (KHTML, like Gecko) Version/4.0 Mobile Safari/534.30";
    uap.parse(header);
    stats.analyze(uap.getBrowserDetails());
    stats.dumpStats();
    
    // 490.
    header = "Mozilla/5.0 (Linux; Android 4.3; C6530 Build/JLS36C) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/37.0.2062.117 Mobile Safari/537.36";
    uap.parse(header);
    stats.analyze(uap.getBrowserDetails());
    stats.dumpStats();
    
    // 491.
    header = "Mozilla/5.0 (Linux; U; Android 4.3; en-us; C6530N Build/JLS36C) AppleWebKit/534.30 (KHTML, like Gecko) Version/4.0 Mobile Safari/534.30";
    uap.parse(header);
    stats.analyze(uap.getBrowserDetails());
    stats.dumpStats();
    
    // 492.
    header = "Mozilla/5.0 (Linux; U; Android 4.3; en-us; C6725 Build/JLS36C) AppleWebKit/534.30 (KHTML, like Gecko) Version/4.0 Mobile Safari/534.30";
    uap.parse(header);
    stats.analyze(uap.getBrowserDetails());
    stats.dumpStats();
    
    // 493.
    header = "Mozilla/5.0 (Linux; U; Android 4.3; en-us; C6730 Build/JLS36C) AppleWebKit/534.30 (KHTML, like Gecko) Version/4.0 Mobile Safari/534.30";
    uap.parse(header);
    stats.analyze(uap.getBrowserDetails());
    stats.dumpStats();
    
    // 494.
    header = "Mozilla/5.0 (Linux; Android 4.1.2; C6750 Build/JZO54K) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/28.0.1500.94 Mobile Safari/537.36";
    uap.parse(header);
    stats.analyze(uap.getBrowserDetails());
    stats.dumpStats();
    
    // 495.
    header = "Mozilla/5.0 (Linux; U; Android 2.3.6; en-us; C5120 Build/GRK39F) AppleWebKit/533.1 (KHTML, like Gecko) Version/4.0 Mobile Safari/533.1";
    uap.parse(header);
    stats.analyze(uap.getBrowserDetails());
    stats.dumpStats();
    
    // 496.
    header = "Mozilla/5.0 (Linux; U; Android 2.3.4; en-us; C5121 Build/GINGERBREAD) AppleWebKit/533.1 (KHTML, like Gecko) Version/4.0 Mobile Safari/533.1";
    uap.parse(header);
    stats.analyze(uap.getBrowserDetails());
    stats.dumpStats();
    
    // 497.
    header = "Mozilla/5.0 (Linux; U; Android 4.0.4; en-us; C5155 Build/IML77) AppleWebKit/534.30 (KHTML, like Gecko) Version/4.0 Mobile Safari/534.30";
    uap.parse(header);
    stats.analyze(uap.getBrowserDetails());
    stats.dumpStats();
  }
  
  
  // Device testing
  @Test
  public void testDesktopCount() {
    assertEquals(68, stats.getDesktopCount());
  }
  
  @Test
  public void testDesktopPercent() {
    assertEquals(Double.doubleToLongBits(13.68), Double.doubleToLongBits(stats.getDesktopPercent()));
  }
  
  @Test
  public void testTabletCount() {
    assertEquals(134, stats.getTabletCount());
  }
  
  @Test
  public void testTabletPercent() {
    assertEquals(Double.doubleToLongBits(26.96), Double.doubleToLongBits(stats.getTabletPercent()));
  }
  
  @Test
  public void testSmartPhoneCount() {
    assertEquals(239, stats.getSmartPhoneCount());
  }
  
  @Test
  public void testSmartPhonePercent() {
    assertEquals(Double.doubleToLongBits(48.09), Double.doubleToLongBits(stats.getSmartPhonePercent()));
  }
  
  @Test
  public void testMobileCount() {
    assertEquals(3, stats.getMobileCount());
  }
  
  @Test
  public void testMobilePercent() {
    assertEquals(Double.doubleToLongBits(0.60), Double.doubleToLongBits(stats.getMobilePercent()));
  }
  
  @Test
  public void testUnknownDeviceCount() {
    assertEquals(52, stats.getUnknownDeviceCount());
  }
  
  @Test
  public void testUnknownDevicePercent() {
    assertEquals(Double.doubleToLongBits(10.46), Double.doubleToLongBits(stats.getUnknownDevicePercent()));
  }
  
  @Test
  public void testTotalDeviceCount() {
    assertEquals(497, stats.getTotalDeviceCount());
  }
  
  @Test
  public void testAndroid2Count() {
    assertEquals(73, stats.getAndroid2OSCount());
  }
  
  @Test
  public void testAndroid3Count() {
    assertEquals(4, stats.getAndroid3OSCount());
  }
  
  @Test
  public void testAndroid4Count() {
    assertEquals(232, stats.getAndroid4OSCount());
  }
  
  @Test
  public void testAndroid5Count() {
    assertEquals(8, stats.getAndroid5OSCount());
  }
  
  @Test
  public void testAndroidOtherCount() {
    assertEquals(0, stats.getAndroidOtherOSCount());
  }
  
  @Test
  public void testAndroidUnknownCount() {
    assertEquals(5, stats.getAndroidUnknownOSCount());
  }
  
  @Test
  public void testAndroidTotalCount() {
    assertEquals(322, stats.getAndroidTotalOSCount());
  }
  
  @Test
  public void testUnixCount() {
    assertEquals(0, stats.getUnixOSCount());
  }
  
  @Test
  public void testLinuxCount() {
    assertEquals(36, stats.getLinuxOSCount());
  }
  
  @Test
  public void testNixCount() {
    assertEquals(358, stats.getNixOSCount());
  }
  
  @Test
  public void testNixPercent() {
    assertEquals(Double.doubleToLongBits(72.03), Double.doubleToLongBits(stats.getNixOSPercent()));
  }
  
  @Test
  public void testMacCount() {
    assertEquals(28, stats.getMacOSCount());
  }
  
  @Test
  public void testMacPercent() {
    assertEquals(Double.doubleToLongBits(5.63), Double.doubleToLongBits(stats.getMacOSPercent()));
  }
  
  @Test
  public void testCyanogenCount() {
    assertEquals(0, stats.getCyanogenOSCount());
  }
  
  @Test
  public void testIOSCount() {
    assertEquals(22, stats.getIOSCount());
  }
  
  @Test
  public void testIOSPercent() {
    assertEquals(Double.doubleToLongBits(4.43), Double.doubleToLongBits(stats.getIOSPercent()));
  }
  
  @Test
  public void testChromiumCount() {
    assertEquals(0, stats.getChromiumOSCount());
  }
  
  @Test
  public void testChromiumPercent() {
    assertEquals(Double.doubleToLongBits(0.00), Double.doubleToLongBits(stats.getChromiumOSPercent()));
  }
  
  @Test
  public void testXPCount() {
    assertEquals(14, stats.getWindowsXPOSCount());
  }
  
  // Percentage of XP of Total Windows OS
  @Test
  public void testXPPercent() {
    assertEquals(Double.doubleToLongBits(19.18), Double.doubleToLongBits(stats.getWindowsXPOSPercent()));
  }
  
  @Test
  public void testVistaCount() {
    assertEquals(6, stats.getWindowsVistaOSCount());
  }
  
  // Percentage of Vista of Total Windows OS
  @Test
  public void testVistaPercent() {
    assertEquals(Double.doubleToLongBits(8.22), Double.doubleToLongBits(stats.getWindowsVistaOSPercent()));
  }
  
  @Test
  public void testWin7Count() {
    assertEquals(25, stats.getWindows7OSCount());
  }
  
  // Percentage of Windows 7 of Total Windows OS
  @Test
  public void testWin7Percent() {
    assertEquals(Double.doubleToLongBits(34.25), Double.doubleToLongBits(stats.getWindows7OSPercent()));
  }
  
  @Test
  public void testWin8Count() {
    assertEquals(20, stats.getWindows8OSCount());
  }
  
  // Percentage of Windows 8 of Total Windows OS
  @Test
  public void testWin8Percent() {
    assertEquals(Double.doubleToLongBits(27.40), Double.doubleToLongBits(stats.getWindows8OSPercent()));
  }
  
  @Test
  public void testWin10Count() {
    assertEquals(1, stats.getWindows10OSCount());
  }
  
  // Percentage of Windows 10 of Total Windows OS
  @Test
  public void testWin10Percent() {
    assertEquals(Double.doubleToLongBits(1.37), Double.doubleToLongBits(stats.getWindows10OSPercent()));
  }
  
  @Test
  public void testWin80PhoneCount() {
    assertEquals(2, stats.getWindows80PhoneOSCount());
  }
  
  @Test
  public void testWin81PhoneCount() {
    assertEquals(4, stats.getWindows81PhoneOSCount());
  }
  
  @Test
  public void testWinOtherCount() {
    assertEquals(1, stats.getWindowsOtherOSCount());
  }
  
  @Test
  public void testWinUnknownCount() {
    assertEquals(0, stats.getWindowsUnknownOSCount());
  }
  
  @Test
  public void testWinTotalCount() {
    assertEquals(73, stats.getWindowsOSCount());
  }
  
  // Percentage of Windows OS of Total OS
  @Test
  public void testWinTotalPercent() {
    assertEquals(Double.doubleToLongBits(14.69), Double.doubleToLongBits(stats.getWindowsTotalOSPercent()));
  }
  
  @Test
  public void testMaemoCount() {
    assertEquals(0, stats.getMaemoOSCount());
  }
  
  @Test
  public void testOtherOSCount() {
    assertEquals(15, stats.getMiscOSCount());
  }
  
  @Test
  public void testOtherOSPercent() {
    assertEquals(Double.doubleToLongBits(3.02), Double.doubleToLongBits(stats.getMiscOSPercent()));
  }
  
  @Test
  public void testTotalOSCount() {
    assertEquals(497, stats.getOSTotal());
  }
  
  @Test
  public void testUnknownOSCount() {
    assertEquals(1, stats.getUnknownOSCount());
  }
  
  @Test
  public void testUnknownOSPercent() {
    assertEquals(Double.doubleToLongBits(0.20), Double.doubleToLongBits(stats.getUnknownOSPercent()));
  }
  
  /*
  * Browser testing
  */
  @Test
  public void testFirefoxCount() {
    assertEquals(9, stats.getFirefoxCount());
  }
  
  @Test
  public void testSeaMonkeyCount() {
    assertEquals(2, stats.getSeaMonkeyCount());
  }
  
  @Test
  public void testIceWeaselCount() {
    assertEquals(2, stats.getIceweaselCount());
  }
  
  @Test
  public void testPaleMoonCount() {
    assertEquals(1, stats.getPaleMoonCount());
  }
  
  @Test
  public void testTenFourFoxCount() {
    assertEquals(2, stats.getTenFourFoxCount());
  }
  
  @Test
  public void testWaterfoxCount() {
    assertEquals(1, stats.getWaterfoxCount());
  }
  
  @Test
  public void testCyberfoxCount() {
    assertEquals(1, stats.getCyberfoxCount());
  }
  
  @Test
  public void testIceDragonCount() {
    assertEquals(1, stats.getIcedragonCount());
  }
  
  @Test
  public void testOtherGeckoCount() {
    assertEquals(1, stats.getOtherGeckoCount());
  }
  
  @Test
  public void testGeckoCount() {
    assertEquals(20, stats.getGeckoCount());
  }
  
  @Test
  public void testGeckoPercent() {
    assertEquals(Double.doubleToLongBits(4.02), Double.doubleToLongBits(stats.getGeckoPercent()));
  }
  
  @Test
  public void testSafariCount() {
    assertEquals(52, stats.getSafariCount());
  }
  
  @Test
  public void testSafariMobileCount() {
    assertEquals(145, stats.getSafariMobileCount());
  }
  
  @Test
  public void testKindleCount() {
    assertEquals(0, stats.getKindleCount());
  }
  
  @Test
  public void testChromeCount() {
    assertEquals(124, stats.getChromeCount());
  }
  
  @Test
  public void testOperaCount() {
    assertEquals(8, stats.getOperaCount());
  }
  
  @Test
  public void testOperaMiniCount() {
    assertEquals(2, stats.getOperaMiniCount());
  }
  
  @Test
  public void testOperaCoastCount() {
    assertEquals(1, stats.getCoastCount());
  }
  
  @Test
  public void testPuffinCount() {
    assertEquals(7, stats.getPuffinCount());
  }
  
  @Test
  public void testDolphinCount() {
    assertEquals(0, stats.getDolphinCount());
  }
  
  @Test
  public void testKonquerorCount() {
    assertEquals(2, stats.getKonquerorCount());
  }
  
  @Test
  public void testOtherWebKitCount() {
    assertEquals(42, stats.getOtherWebKitCount());
  }
  
  @Test
  public void testWebKitCount() {
    assertEquals(383, stats.getWebKitCount());
  }
  
  @Test
  public void testWebKitPercent() {
    assertEquals(Double.doubleToLongBits(77.06), Double.doubleToLongBits(stats.getWebKitPercent()));
  }
  
  @Test
  public void testIE6Count() {
    assertEquals(4, stats.getIE6Count());
  }
  
  @Test
  public void testIE6Percent() {
    assertEquals(Double.doubleToLongBits(6.67), Double.doubleToLongBits(stats.getIE6Percent()));
  }
  
  @Test
  public void testIE7Count() {
    assertEquals(7, stats.getIE7Count());
  }
  
  @Test
  public void testIE7Percent() {
    assertEquals(Double.doubleToLongBits(11.67), Double.doubleToLongBits(stats.getIE7Percent()));
  }
  
  @Test
  public void testIE8Count() {
    assertEquals(14, stats.getIE8Count());
  }
  
  @Test
  public void testIE8Percent() {
    assertEquals(Double.doubleToLongBits(23.33), Double.doubleToLongBits(stats.getIE8Percent()));
  }
  
  @Test
  public void testIE9Count() {
    assertEquals(5, stats.getIE9Count());
  }
  
  @Test
  public void testIE9Percent() {
    assertEquals(Double.doubleToLongBits(8.33), Double.doubleToLongBits(stats.getIE9Percent()));
  }
  
  @Test
  public void testIE10Count() {
    assertEquals(8, stats.getIE10Count());
  }
  
  @Test
  public void testIE10Percent() {
    assertEquals(Double.doubleToLongBits(13.33), Double.doubleToLongBits(stats.getIE10Percent()));
  }
  
  @Test
  public void testIE11Count() {
    assertEquals(11, stats.getIE11Count());
  }
  
  @Test
  public void testIE11Percent() {
    assertEquals(Double.doubleToLongBits(18.33), Double.doubleToLongBits(stats.getIE11Percent()));
  }
  
  @Test
  public void testEdgeCount() {
    assertEquals(1, stats.getEdgeCount());
  }
  
  @Test
  public void testEdgePercent() {
    assertEquals(Double.doubleToLongBits(1.67), Double.doubleToLongBits(stats.getEdgePercent()));
  }
  
  @Test
  public void testSiteKioskCount() {
    assertEquals(2, stats.getSiteKioskCount());
  }
  
  @Test
  public void testSiteKioskPercent() {
    assertEquals(Double.doubleToLongBits(3.33), Double.doubleToLongBits(stats.getSiteKioskPercent()));
  }
  
  @Test
  public void testOtherTridentCount() {
    assertEquals(8, stats.getOtherTridentCount());
  }
  
  @Test
  public void testOtherTridentPercent() {
    assertEquals(Double.doubleToLongBits(13.33), Double.doubleToLongBits(stats.getOtherTridentPercent()));
  }
  
  @Test
  public void testTridentCount() {
    assertEquals(60, stats.getTridentCount());
  }
  
  @Test
  public void testTridentPercent() {
    assertEquals(Double.doubleToLongBits(12.07), Double.doubleToLongBits(stats.getTridentPercent()));
  }
  
  @Test
  public void testMiscBrowserCount() {
    assertEquals(33, stats.getMiscBrowserCount());
  }
  
  @Test
  public void testOtherBrowserPercent() {
    assertEquals(Double.doubleToLongBits(6.64), Double.doubleToLongBits(stats.getMiscBrowserPercent()));
  }
  
  @Test
  public void testUnknownBrowserCount() {
    assertEquals(1, stats.getUnknownBrowserCount());
  }
  
  @Test
  public void testUnknownBrowserPercent() {
    assertEquals(Double.doubleToLongBits(0.20), Double.doubleToLongBits(stats.getUnknownBrowserPercent()));
  }
  
  @Test
  public void testTotalBrowserCount() {
    assertEquals(497, stats.getTotalBrowserCount());
  }
  
  @Test
  public void testArabicLanguage() {
    assertEquals(1, stats.getLanguageTotal("Arabic"));
  }
  
  @Test
  public void testGermanLanguage() {
    assertEquals(1, stats.getLanguageTotal("German"));
  }
  
  @Test
  public void testEnglishLanguage() {
    assertEquals(202, stats.getLanguageTotal("English"));
  }
  
  @Test
  public void testSpanishLanguage() {
    assertEquals(15, stats.getLanguageTotal("Spanish"));
  }
  
  @Test
  public void testFrenchLanguage() {
    assertEquals(6, stats.getLanguageTotal("French"));
  }
  
  @Test
  public void testItalianLanguage() {
    assertEquals(1, stats.getLanguageTotal("Italian"));
  }
  
  @Test
  public void testJapaneseLanguage() {
    assertEquals(9, stats.getLanguageTotal("Japanese"));
  }
  
  @Test
  public void testKoreanLanguage() {
    assertEquals(4, stats.getLanguageTotal("Korean"));
  }
  
  @Test
  public void testPortugueseLanguage() {
    assertEquals(2, stats.getLanguageTotal("Portuguese"));
  }
  
  @Test
  public void testChineseLanguage() {
    assertEquals(5, stats.getLanguageTotal("Chinese"));
  }
  
  @Test
  public void testNonExistantLanguage() {
    assertEquals(0, stats.getLanguageTotal("Bogus"));
  }
  
  @Test
  public void testAustraliaCountry() {
    assertEquals(2, stats.getCountryTotal("Australia"));
  }
  
  @Test
  public void testBrazilCountry() {
    assertEquals(1, stats.getCountryTotal("Brazil"));
  }
  
  @Test
  public void testCanadaCountry() {
    assertEquals(6, stats.getCountryTotal("Canada"));
  }
  
  @Test
  public void testChinaCountry() {
    assertEquals(4, stats.getCountryTotal("China"));
  }
  
  @Test
  public void testFranceCountry() {
    assertEquals(4, stats.getCountryTotal("France"));
  }
  
  @Test
  public void testGermanyCountry() {
    assertEquals(1, stats.getCountryTotal("Germany"));
  }
  
  @Test
  public void testItalyCountry() {
    assertEquals(1, stats.getCountryTotal("Italy"));
  }
  
  @Test
  public void testJapanCountry() {
    assertEquals(9, stats.getCountryTotal("Japan"));
  }
  
  @Test
  public void testKoreaCountry() {
    assertEquals(4, stats.getCountryTotal("Republic of Korea"));
  }
  
  @Test
  public void testMexicoCountry() {
    assertEquals(1, stats.getCountryTotal("Mexico"));
  }
  
  @Test
  public void testPhilippinesCountry() {
    assertEquals(1, stats.getCountryTotal("Philippines"));
  }
  
  @Test
  public void testSouthAfricaCountry() {
    assertEquals(2, stats.getCountryTotal("South Africa"));
  }
  
  @Test
  public void testSpainCountry() {
    assertEquals(5, stats.getCountryTotal("Spain"));
  }
  
  @Test
  public void testTaiwanCountry() {
    assertEquals(1, stats.getCountryTotal("Taiwan"));
  }
  
  @Test
  public void testUAECountry() {
    assertEquals(1, stats.getCountryTotal("United Arab Emirates"));
  }
  
  @Test
  public void testUnitedKingdomCountry() {
    assertEquals(9, stats.getCountryTotal("United Kingdom"));
  }
  
  @Test
  public void testUSACountry() {
    assertEquals(187, stats.getCountryTotal("United States"));
  }
  
  @Test
  public void testNonExistantCountry() {
    assertEquals(0, stats.getCountryTotal("Bogus"));
  }
}
