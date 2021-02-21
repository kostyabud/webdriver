package taskN_3.page;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GoogleCloudPageObject {

    private WebDriver driver;
    private static final String GOOGLE_CLOUD_URL = "https://cloud.google.com/";

    @FindBy (xpath = "//input[@name='q']")
    private WebElement searchTerm;

    @FindBy (xpath = "//a[@class='gs-title' and contains(@data-ctorig,'calculator')]/child::b")
    private WebElement resultSearch;

    public GoogleCloudPageObject(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public GoogleCloudPageObject openPage (){
        driver.get(GOOGLE_CLOUD_URL);
        return this;
    }
    public GoogleCloudPageObject enterSearchTerm(String text){
        searchTerm.click();
        searchTerm.sendKeys(text);
        searchTerm.sendKeys(Keys.RETURN);
        return new GoogleCloudPageObject(driver);
    }
    public GoogleCloudPricingCalculatorPage openPagePricingCalculator(){
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='gsc-expansionArea']")));
        new WebDriverWait(driver, 20)
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[@class='gs-title' and contains(@data-ctorig,'calculator')]/child::b")));
      resultSearch.click();
        return new GoogleCloudPricingCalculatorPage(driver);
    }
}

