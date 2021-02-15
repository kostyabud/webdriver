package taskN_1.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CreatingNewPastePageObject {
    private WebDriver driver;
    private static final String HOME_URL = "https://pastebin.com";
    @FindBy(id = "postform-text")
    private WebElement inputText;
    @FindBy(xpath = "//*[@id='w0']/div[5]/div[1]/div[2]/div/span/span[1]/span/span[2]")
    private WebElement clickExpiration;
    @FindBy(xpath = "//li[text()='10 Minutes']")
    private WebElement choseTenMinutes;
    @FindBy(xpath = "//input[@id='postform-name']")
    private WebElement installValueOfTitle;
    @FindBy(xpath = "//button[text()='Create New Paste']")
    private WebElement pushCreateNewPaste;


    public CreatingNewPastePageObject openPage (){
        driver.get(HOME_URL);
        return this;
    }
    public CreatingNewPastePageObject(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public CreatingNewPastePageObject fillingNewPaste(String text){
        inputText.sendKeys(text);
        return this;
    }
    public CreatingNewPastePageObject installTenMinutesToPasteExpiration (){
        clickExpiration.click();
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//li[text()='10 Minutes']")));
        choseTenMinutes.click();
        return this;
    }
    public CreatingNewPastePageObject installTitle (String title){
        installValueOfTitle.sendKeys(title);
        return this;
    }
    public CreatingNewPastePageObject pushButtonCreateNewPaste(){
        pushCreateNewPaste.click();
        return new CreatingNewPastePageObject(driver);
    }
}
