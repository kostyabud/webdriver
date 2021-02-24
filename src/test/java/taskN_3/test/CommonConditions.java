package taskN_3.test;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import taskN_3.driver.DriverSingleton;
import taskN_3.page.GoogleCloudPageObject;
import taskN_3.page.GoogleCloudPricingCalculatorPage;
import taskN_3.page.TenMinuteMailPageObj;
import taskN_3.util.TestListener;

@Listeners({TestListener.class})
public class CommonConditions {
    protected WebDriver driver;
    private final String searchTerms = "Google Cloud Platform Pricing Calculator";
    @BeforeMethod()
    public void setup() {
        driver = DriverSingleton.getDriver();
    }

    public void openPricingCalculator() {
        GoogleCloudPageObject pageObject = new GoogleCloudPageObject(driver);
        pageObject.openPage()
                .enterSearchTerm(searchTerms)
                .openPagePricingCalculator();
    }
    public void fillFormToPricingCalculator() {
        GoogleCloudPricingCalculatorPage calculatorPage = new GoogleCloudPricingCalculatorPage(driver)
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
    }
    public void getTempEmailAndReadLetter() {
        TenMinuteMailPageObj email = new TenMinuteMailPageObj(driver)
                .openNewTab()
                .selectTempMail()
                .insertEmailToReceiveCost()
                .clickButtonSendEmail()
                .transitionToTempMailForAssert();


    }

    @AfterMethod(alwaysRun = true)
    public void stopBrowser () {DriverSingleton.closeDriver();}
}
