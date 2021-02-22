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
    private final By additionalSelectionList = By.xpath("//ul[@class='select2-results__options']");

    @FindBy(id = "postform-text")
    private WebElement inputText;
    @FindBy(xpath = "//*[@id='select2-postform-expiration-container']/following-sibling::*[@class='select2-selection__arrow']")
    private WebElement clickExpiration;
    @FindBy(xpath = "//li[text()='10 Minutes']")
    private WebElement chooseTenMinutes;
    @FindBy(xpath = "//input[@id='postform-name']")
    private WebElement enterNameOfTitle;
    @FindBy(xpath = "//button[text()='Create New Paste']")
    private WebElement buttonCreateNewPaste;


    public CreatingNewPastePageObject openPage (){
        driver.get(HOME_URL);
        return this;
    }
    public CreatingNewPastePageObject(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public CreatingNewPastePageObject inputText(String text){
        inputText.sendKeys(text);
        return this;
    }
    public CreatingNewPastePageObject selectTenMinutesToPasteExpiration(){
        clickExpiration.click();
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.presenceOfElementLocated(additionalSelectionList));
        chooseTenMinutes.click();
        return this;
    }
    public CreatingNewPastePageObject enterTitleName(String title){
        enterNameOfTitle.sendKeys(title);
        return this;
    }
    public CreatingNewPastePageObject pushButtonCreateNewPaste(){
        buttonCreateNewPaste.click();
        return new CreatingNewPastePageObject(driver);
    }



}
