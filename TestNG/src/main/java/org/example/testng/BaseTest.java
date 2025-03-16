package org.example.testng;

import org.example.testng.utils.PropertiesUtil;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.IOException;
import java.util.Properties;

public class BaseTest {
    public static WebDriver driver;

    public static void initializedriver() throws IOException {
      Properties properties= PropertiesUtil.loadapplicationproperties();
      String url=properties.get("application.url").toString();
      System.setProperty("webdriver.chrome.driver", "Y:/Automation/chromedriver-win64/chromedriver.exe");
      driver = new ChromeDriver();
      driver.manage().window().maximize();
      driver.get(url);
    }


  public static void closedriver()
  {
    driver.quit();
  }
}


