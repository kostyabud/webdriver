package taskN_3.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import taskN_3.page.GoogleCloudPageObject;
import taskN_3.page.GoogleCloudPricingCalculatorPage;

import java.util.concurrent.TimeUnit;

public class TestGoogleCloudCalc {
    private WebDriver driver;
    private String searchTerms = "Google Cloud Platform Pricing Calculator";

    @BeforeMethod (alwaysRun = true)
    public void openPageGooglePricingCalculatorAndFillingForm (){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        GoogleCloudPageObject pageObject = new GoogleCloudPageObject(driver);
        pageObject.openPage()
                .enterSearchTerm(searchTerms)
                .openPagePricingCalculator();
        GoogleCloudPricingCalculatorPage calculatorPage = new GoogleCloudPricingCalculatorPage(driver);
        calculatorPage
                .enterValuesInstances(4)
                .enterValueMachineFamily()
                .selectMachineType()
                .pushAddGPU()
                .setupGPUType()
//                .setupNumberOfGPU()
                .installCapacitySSD()
                .installDataCenterLocation()
                .selectCommittedUsage();


    }
    @Test
    public void Test(){

    }
}
