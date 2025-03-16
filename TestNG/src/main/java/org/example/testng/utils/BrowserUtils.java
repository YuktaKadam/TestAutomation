package org.example.testng.utils;

import com.fasterxml.jackson.databind.ser.Serializers;
import org.example.testng.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class BrowserUtils extends BaseTest {

  static Properties props;

  static {
    try {
      props = PropertiesUtil.loadframeworkproperties();
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }

  public BrowserUtils() throws IOException {
  }

  public static void entertext(String element, String text)
  {
    driver.findElement(By.xpath(element)).sendKeys(text);
  }

  public static void clickonbtn(String element)
  {
    findandwaitforelement(element);
    //driver.findElement(By.xpath(element)).click();
  }

  public static WebElement findandwaitforelement(String xpath)
  {
    //int timedoutsec= Integer.parseInt(props.get("timeout.maximum").toString());
    String timeout=props.getProperty("timeout.maximum");
    WebElement element= null;
    try {
      WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(Long.parseLong(timeout)));
      element=wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(xpath))));
    }
    catch (Exception e)
    {
      System.out.println("Element not found");
    }
    return element;
  }
}
