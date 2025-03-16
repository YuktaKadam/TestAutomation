package org.example.testng.PajeObjects;


import org.example.testng.BaseTest;
import org.example.testng.utils.BrowserUtils;
import org.openqa.selenium.By;

public class LoginPage extends BaseTest {

  private static String Username="//input[@id='input-email']";
  private static String Password="//input[@id='input-password']";
  private static String Loginbtn="//input[@type='submit']";
  private static String forgetpassword="//*[@id=\"content\"]/div/div[2]/div/form/div[2]/a";

  public static void enterusername(String  username)
    {
      BrowserUtils.entertext(Username, username);
    }

  public static void enterpassword(String  password)
  {
    BrowserUtils.entertext(Password,password);
  }
  public static void clickonloginbtn()
  {
    BrowserUtils.clickonbtn(Loginbtn);
    //driver.findElement(By.xpath(Loginbtn)).click();
  }

  public static void clickonforgetpassword()
  {
    BrowserUtils.clickonbtn(forgetpassword);
    //driver.findElement(By.xpath(forgetpassword)).click();
  }


}
