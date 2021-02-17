package taskN_3.page;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

public class GoogleCloudPageObject {
    private WebDriver driver;
    private static final String GOOGLE_CLOUD_URL = "https://cloud.google.com/";

    @FindBy (xpath = "//input[@name='q']")
    private WebElement searchTerm;

    @FindBy (xpath = "//b[text()='Google Cloud Platform Pricing Calculator']")
    private WebElement resultSearch;
    //b[text()='Google Cloud Platform Pricing Calculator']
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
        new WebDriverWait(driver, 20)
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//b[text()='Google Cloud Platform Pricing Calculator']")));
        return new GoogleCloudPageObject(driver);
    }
    public GoogleCloudPricingCalculatorPage openPagePricingCalculator(){
      resultSearch =  driver.findElement((By.xpath("//b[text()='Google Cloud Platform Pricing Calculator']")));
      resultSearch.click();
        return new GoogleCloudPricingCalculatorPage(driver);
    }
}

