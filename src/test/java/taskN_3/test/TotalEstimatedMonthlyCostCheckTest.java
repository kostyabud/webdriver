/*
            Task "Hardcor"
 */

package taskN_3.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import taskN_3.page.GoogleCloudPageObject;
import taskN_3.page.GoogleCloudPricingCalculatorPage;
import taskN_3.page.TenMinuteMailPageObj;

public class TotalEstimatedMonthlyCostCheckTest {

    private WebDriver driver;
    private String searchTerms = "Google Cloud Platform Pricing Calculator";
    @BeforeMethod(alwaysRun = true)
    public void openPageGooglePricingCalculatorAndFillingForm (){
        System.setProperty("webdriver.chrome.driver", "src\\test\\resources\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        GoogleCloudPageObject pageObject = new GoogleCloudPageObject(driver);
        pageObject.openPage()
                .enterSearchTerm(searchTerms)
                .openPagePricingCalculator();
        GoogleCloudPricingCalculatorPage calculatorPage = new GoogleCloudPricingCalculatorPage(driver);
        calculatorPage
                .enterValuesInstances(4)
                .enterValueSeriesMachineFamily()
                .selectMachineType()
                .clickAddGPU()
                .setupNumberOfGPU()
                .setupGPUType()
                .introduceCapacitySSD()
                .chooseDataCenterLocation()
                .selectCommittedUsage()
                .clickAddToEstimate()
                .clickEmailEstimate();
        TenMinuteMailPageObj email = new TenMinuteMailPageObj(driver);
        email.openTempMail()
                .selectTempMail()
                .insertEmailToReceiveCost()
                .clickButtonSendEmail()
                .transitionToTempMailForAssert();
    }

    @Test
    public void test(){
        String monthlyCostCheck = driver.findElement(By.xpath("//h3[text()='USD 1,082.77']")).getText();
        Assert.assertEquals(monthlyCostCheck,"USD 1,082.77");

    }
    @AfterMethod(alwaysRun = true)
    public void closeBrowser() {
        driver.quit();
        driver = null;
    }
}
