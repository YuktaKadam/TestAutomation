package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.testng.BaseTest;
import org.example.testng.PajeObjects.LoginPage;
import org.example.testng.utils.PropertiesUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.time.Duration;
import java.util.Properties;


public class Loginstepdefinition  {



  WebDriver driver = BaseTest.driver;
  Properties properties= PropertiesUtil.loadapplicationproperties();

  public Loginstepdefinition() throws IOException {
  }


  @Given("User enters valid username field")
  public void userEntersValidUsernameField() {
   String username=properties.get("username").toString();
    LoginPage.enterusername(username);
//    WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(20));
//    WebElement emailfield=  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("input-email")));
//   emailfield.sendKeys(username);
    //driver.findElement(By.xpath("//*[@id=\"input-email\"]")).sendKeys("yukta12@gmail.com");
  }

  @And("User enters valid password field")
  public void userEntersValidPasswordField() {
    String password=properties.get("password").toString();
    LoginPage.enterpassword(password);
    //driver.findElement(By.id("input-password")).sendKeys(password);
  }

  @When("User clicks on the Submit Button")
  public void userClicksOnTheSubmitButton() {
    LoginPage.clickonloginbtn();
    //driver.findElement(By.xpath("//input[@type=\"submit\"]")).click();
  }

  @Then("User is logged in Successfully.")
  public void userIsLoggedInSuccessfully() {
    String nxturl=driver.getCurrentUrl();
    String acturl="https://tutorialsninja.com/demo/index.php?route=account/account";
    if(nxturl.equals(acturl))
    {
      System.out.println("Login Successfull");
    }
    else{
      System.out.println("Login Failed");
    }
  }

  @Given("User enters invalid username field")
  public void userEntersInvalidUsernameField() {
    driver.findElement(By.id("input-email")).sendKeys("yukta@gmail.com");
  }

  @And("User enters invalid password field")
  public void userEntersInvalidPasswordField() {
    driver.findElement(By.id("input-password")).sendKeys("Yufeb@2000");
  }

  @Then("Error message is displayed.")
  public void errorMessageIsDisplayed() {
    String Errormsg=driver.findElement(By.xpath("//*[@id=\"account-login\"]/div[1]")).getText();
    System.out.println(Errormsg);
  }
}
