package taskN_3.page;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;


public class TenMinuteMailPageObj {
   private WebDriver driver;
   private final String TEMP_MAIL_URL = "https://temp-mail.org/ru/";

   @FindBy (xpath = "//input[@id='mail']")
   private WebElement tempEmail;
   @FindBy (xpath = "//input[@name='description' and @type='email']")
   private WebElement insertEmail;
   @FindBy (xpath = "//div[@class='input-box-col hidden-xs-sm']/button")
   private WebElement copyEmail;
   @FindBy (xpath = "//button[@aria-label='Send Email']")
   private WebElement buttonSendEmail;
   @FindBy (xpath = "//a[text()='Google Cloud Platform Price Estimate']")
   private WebElement letterFromGoogle;
   private final By waitGeneratingMail = By.xpath("//input[@id='mail']");
   private final By waitingButtonSendEmail = By.xpath("//button[@aria-label='Send Email']");
   private final By mailWaiting = By.xpath("//span[@title='Google Cloud Sales '] ");



   public TenMinuteMailPageObj (WebDriver driver){
       this.driver = driver;
       PageFactory.initElements(driver,this);
   }


   public  TenMinuteMailPageObj openTempMail(){

       ((JavascriptExecutor)driver).executeScript("window.open()");
       ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
       String estimateHandle = String.valueOf(tabs.get(0));
       String mailTab = String.valueOf(tabs.get(1));
       driver.switchTo().window(mailTab);
       driver.get(TEMP_MAIL_URL);

       return new TenMinuteMailPageObj(driver);
   }

   public TenMinuteMailPageObj selectTempMail(){
       new WebDriverWait(driver, 10)
               .until(ExpectedConditions.presenceOfElementLocated(waitGeneratingMail));
       new WebDriverWait(driver, 20)
               .until(ExpectedConditions.elementToBeClickable(copyEmail));
       tempEmail.click();
       copyEmail.click();
       tempEmail.sendKeys(Keys.CONTROL+ "c");
       return this;
   }

   public TenMinuteMailPageObj insertEmailToReceiveCost() {
       ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
       String estimateHandle = String.valueOf(tabs.get(0));
       driver.switchTo().window(estimateHandle);

       driver.switchTo().frame(0);
       driver.switchTo().frame("myFrame");
       insertEmail.click();
       insertEmail.sendKeys(Keys.CONTROL+ "V");

       return new TenMinuteMailPageObj(driver);

   }

   public TenMinuteMailPageObj clickButtonSendEmail(){

       new WebDriverWait(driver, 10)
               .until(ExpectedConditions.presenceOfElementLocated(waitingButtonSendEmail));
       buttonSendEmail.click();
       return this;
   }

   public TenMinuteMailPageObj transitionToTempMailForAssert(){
       ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
       String estimateHandle = String.valueOf(tabs.get(0));
       String mailTab = String.valueOf(tabs.get(1));
       driver.switchTo().window(mailTab);
       new WebDriverWait(driver, 10)
               .until(ExpectedConditions.presenceOfElementLocated(mailWaiting));

      JavascriptExecutor jse = (JavascriptExecutor)driver;
      jse.executeScript("window.scroll(0,250)");
       new WebDriverWait(driver, 10)
               .until(ExpectedConditions.elementToBeClickable(letterFromGoogle));
       driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

       letterFromGoogle.click();
       return new TenMinuteMailPageObj(driver);

   }

}
