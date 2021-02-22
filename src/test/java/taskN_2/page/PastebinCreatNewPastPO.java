package taskN_2.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class PastebinCreatNewPastPO {
    private WebDriver driver;
    private static final String HOME_URL = "https://pastebin.com";
    @FindBy(id = "postform-text")
    private WebElement inputText;
    @FindBy(xpath = "//*[@id='select2-postform-format-container']/following-sibling::*[@class='select2-selection__arrow']")
    private WebElement syntaxBash;

    private final By additionalSelectionList = By.xpath("//ul[@class='select2-results__options']");
    @FindBy(xpath = "//li[text()='Bash']")
    private WebElement bashClick;
    @FindBy(xpath = "//*[@id='select2-postform-expiration-container']/following-sibling::*[@class='select2-selection__arrow']")
    private WebElement choiceExpiration;
    @FindBy(xpath = "//li[text()='10 Minutes']")
    private WebElement choiceTenMinutes;
    @FindBy(xpath = "//input[@id='postform-name']")
    private WebElement nameOfTitle;
    @FindBy(xpath = "//button[text()='Create New Paste']")
    private WebElement buttonCreateNewPaste;


    public PastebinCreatNewPastPO(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public PastebinCreatNewPastPO openBrowser(){
        driver.get(HOME_URL);
        return this;
    }
    public PastebinCreatNewPastPO fillText(String text){
        inputText.sendKeys(text);
        return this;
    }
    public PastebinCreatNewPastPO choseSyntax (){
        syntaxBash.click();
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.presenceOfElementLocated(additionalSelectionList));
        bashClick.click();
        return this;

    }
    public PastebinCreatNewPastPO chooseTenMinutesToPasteExpiration(){
        choiceExpiration.click();
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.presenceOfElementLocated(additionalSelectionList));
        choiceTenMinutes.click();
        return this;
    }
    public PastebinCreatNewPastPO introduceTitleName(String title){
        nameOfTitle.sendKeys(title);
        return this;
    }
    public PastebinCreatNewPastPO pushButtonCreateNewPaste(){
        buttonCreateNewPaste.click();
        return new PastebinCreatNewPastPO(driver);
    }


}




