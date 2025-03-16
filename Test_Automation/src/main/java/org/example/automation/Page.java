package org.example.automation;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class Page {
  WebDriver driver;
  @Before
  public void beforetest()
  {
    System.setProperty("webdriver.chrome.driver","Y:/Automation/chromedriver-win64/chromedriver.exe");

  // WebDriverManager.chromedriver.setup();
    ChromeOptions options= new ChromeOptions();
    options.addArguments("headless");
    driver =new ChromeDriver(options);
    driver.get("https://www.saucedemo.com");
    driver.manage().window().maximize();
    driver.manage().window().minimize();
  }

  @Test
  public void ValidateTitle()
  {
    String title= driver.getTitle();
    Assert.assertTrue(title.equals("Swag Labs"));
  }

  @Test
  public void validatelogin()
  {
    driver.findElement(By.xpath("//input[@id=\"user-name\"]")).sendKeys("standard_user");
    driver.findElement(By.xpath("//input[@id=\"password\"]")).sendKeys("secret_sauce");
    driver.findElement(By.id("login-button")).click();
    String url= driver.getCurrentUrl();
    Assert.assertTrue(url.equals("https://www.saucedemo.com/inventory.html"));
    System.out.println();
  }

  @Test
  public void useractionclass() throws InterruptedException {
    Actions action= new Actions(driver);
    WebElement element =driver.findElement(By.xpath("//input[@id=\"user-name\"]"));
    action.moveToElement(element).click(element).sendKeys(element,"standard_user").doubleClick(element).contextClick(element).build().perform();

  }

  @Test
  public void useralert()
  {
    driver.navigate().to("https://only-testing-blog.blogspot.com/");
    driver.findElement(By.xpath("//input[@value=\"Show Me Alert\"]")).click();
    driver.switchTo().alert().accept();

  }

  @After
  public void aftertest()
  {
    driver.close();
  }


}
