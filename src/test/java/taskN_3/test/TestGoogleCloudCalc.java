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
                .setupNumberOfGPU()
                .setupGPUType()
                .installCapacitySSD()
                .installDataCenterLocation()
                .selectCommittedUsage()
                .clickAddToEstimate();




    }

    @Test
    public void testCorrectInstanceType(){
        String instanceType = driver
                .findElement(By.xpath("//*[@id='compute']/md-list/md-list-item[3]/div")).getText();
        Assert.assertEquals(instanceType, "Instance type: n1-standard-8");
    }

    @Test
    public void testCorrectRegion(){
        String region = driver
                .findElement(By.xpath("//*[@id='compute']/md-list/md-list-item[4]/div")).getText();
        Assert.assertEquals(region, "Region: Frankfurt");
    }

    @Test
    public void testCorrectLocalSSD(){
        String capacitySSD = driver
                .findElement(By.xpath("//*[@id='compute']/md-list/md-list-item[5]/div")).getText();
        Assert.assertEquals(capacitySSD, "Total available local SSD space 2x375 GiB");
    }

    @Test
    public void testCorrectCommittedTerm(){
        String committedTerm = driver
                .findElement(By.xpath("//*[@id='compute']/md-list/md-list-item[6]/div")).getText();
        Assert.assertEquals(committedTerm, "Commitment term: 1 Year");
    }

    @Test
    public void testCorrectVMClass(){
      String vmClass = driver.findElement(By.xpath("//*[@id='compute']/md-list/md-list-item[2]/div"))
                .getText();
        Assert.assertEquals(vmClass, "VM class: regular");

    }

    @AfterMethod (alwaysRun = true)
    public void closeBrowser(){
        driver.quit();
        driver = null;
    }




}
