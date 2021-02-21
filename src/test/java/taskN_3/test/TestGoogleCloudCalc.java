package taskN_3.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import taskN_3.page.GoogleCloudPricingCalculatorPage;
import taskN_3.page.GoogleCloudPageObject;


public class TestGoogleCloudCalc {
    private WebDriver driver;
    private String searchTerms = "Google Cloud Platform Pricing Calculator";
    @BeforeMethod (alwaysRun = true)
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
                .pushAddGPU()
                .setupNumberOfGPU()
                .setupGPUType()
                .installCapacitySSD()
                .installDataCenterLocation()
                .selectCommittedUsage()
                .clickAddToEstimate();

    }


    @Test
    public void comparisonOfTheReceivedPrice(){
        String manualCheck = "Total Estimated Cost: USD 1,082.77 per 1 month";
        String automatedCheck = driver
                .findElement(By.xpath("//h2[@class='md-title']/b")).getText();
        Assert.assertEquals(manualCheck, automatedCheck);
    }

    @Test
    public void testCorrectInstanceType(){
        String instanceType = driver
                .findElement(By.xpath("//div[@class='md-list-item-text ng-binding' and contains(text(),'Instance type: n1-standard-8')]")).getText();
        Assert.assertEquals(instanceType, "Instance type: n1-standard-8");
    }

    @Test
    public void testCorrectRegion(){
        String region = driver
                .findElement(By.xpath("//div[@class='md-list-item-text ng-binding' and contains(text(),'Region: Frankfurt')]")).getText();
        Assert.assertEquals(region, "Region: Frankfurt");
    }

    @Test
    public void testCorrectLocalSSD(){
        String capacitySSD = driver
                .findElement(By.xpath("//div[@class='md-list-item-text ng-binding' and contains(text(),'Total')]")).getText();
        Assert.assertEquals(capacitySSD, "Total available local SSD space 2x375 GiB");
    }

    @Test
    public void testCorrectCommittedTerm(){
        String committedTerm = driver
                .findElement(By.xpath("//div[@class='md-list-item-text ng-binding' and contains(text(),'Year')]")).getText();
        Assert.assertEquals(committedTerm, "Commitment term: 1 Year");
    }

    @Test
    public void testCorrectVMClass(){
      String vmClass = driver.findElement(By.xpath("//div[@class='md-list-item-text ng-binding' and contains(text(),'VM class: regular')]"))
                .getText();
        Assert.assertEquals(vmClass, "VM class: regular");

    }
    @AfterMethod(alwaysRun = true)
        public void closeBrowser(){
            driver.quit();
            driver = null;
    }

}




