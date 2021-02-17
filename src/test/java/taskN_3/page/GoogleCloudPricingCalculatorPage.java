package taskN_3.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GoogleCloudPricingCalculatorPage {
    private WebDriver driver;
    @FindBy (xpath = "//input[@ng-model='listingCtrl.computeServer.quantity']")
    private WebElement numberOfInstances;
    @FindBy (xpath = "//md-select[@placeholder='Series']/descendant-or-self::md-select-value")
    private WebElement buttonSeriesMF;
    @FindBy (xpath = "//md-option[@value='n1']")
    private WebElement setFamilyMachine;
    @FindBy (xpath = "//md-select[@placeholder='Instance type']")
    private WebElement chooseMachineType;
    @FindBy (xpath = "//md-option[@ng-repeat='instance in typeInfo']/div[contains(text(),'n1-standard-8')]")
    private WebElement setMachineType;
    @FindBy (xpath = "//md-checkbox[@aria-label='Add GPUs' and @ng-model='listingCtrl.computeServer.addGPUs']/child::div[@class='md-container md-ink-ripple']")
    private WebElement setAddGPU;
    @FindBy (xpath = "//md-select[@placeholder='Number of GPUs']/descendant::div")
    private WebElement getChooseNumberOfGPU;
    @FindBy (xpath = "//md-option[@value='1' and @ng-repeat='item in listingCtrl.supportedGpuNumbers[listingCtrl.computeServer.gpuType]']/div")
    private WebElement setNumberOfGPU;
    @FindBy (xpath = "//md-select[@placeholder='GPU type']/descendant::span[@class]")
    private WebElement getChooseGPUType;
    @FindBy (xpath = "//md-option[@value='NVIDIA_TESLA_V100']/child::div[@class='md-text ng-binding']")
    private WebElement setGPUType;
    @FindBy (xpath = "//md-select[@placeholder='Local SSD' and @ng-model='listingCtrl.computeServer.ssd']/descendant::span[@class]")
    private WebElement chooseCapacitySSD;
@FindBy (xpath = "//md-option[@value='2' and @ng-repeat='item in listingCtrl.supportedSsd']/div[@class='md-text ng-binding']")
    private WebElement setCapacitySSD;
@FindBy (xpath = "//md-select[@placeholder='Datacenter location' and @ng-model='listingCtrl.computeServer.location']/descendant::span[@class]")
    private WebElement chooseDataCenterLocation;
@FindBy (xpath = "//*[@id='select_option_205']/div[@class='md-text ng-binding']")
    private WebElement setDataCenterLocation;
@FindBy (xpath = "//md-select[@placeholder='Committed usage' and @aria-label='Committed usage: None']/descendant::span")
    private WebElement chooseCommittedUsage;
@FindBy (xpath = "//md-option[@value='1' and @id='select_option_97']/child::div[@class='md-text']")
    private WebElement setCommittedUsage;
@FindBy (xpath = "//button[@aria-label='Add to Estimate']")
    private WebElement buttonAddToEstimate;




    public GoogleCloudPricingCalculatorPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public GoogleCloudPricingCalculatorPage enterValuesInstances(Integer number){
        driver.switchTo().frame(0);
        driver.switchTo().frame("myFrame");
        numberOfInstances.sendKeys(number.toString());
        return this;
    }

    public GoogleCloudPricingCalculatorPage enterValueSeriesMachineFamily(){
        buttonSeriesMF.click();
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//md-option[@value='n1']")));
        setFamilyMachine.click();
        return this;
    }

    public GoogleCloudPricingCalculatorPage selectMachineType (){
        chooseMachineType.click();
        setMachineType = driver.findElement(By.xpath("//md-option[@ng-repeat='instance in typeInfo']/div[contains(text(),'n1-standard-8')]"));
        new WebDriverWait(driver, 10).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//md-option[@ng-repeat='instance in typeInfo']/div[contains(text(),'n1-standard-8')]")));
        setMachineType.click();
        return this;
    }
    public GoogleCloudPricingCalculatorPage pushAddGPU (){
        setAddGPU.click();
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions
                        .presenceOfElementLocated(By.xpath("//md-option[@value='1' and @ng-repeat='item in listingCtrl.supportedGpuNumbers[listingCtrl.computeServer.gpuType]']/div")));
        return this;
    }

    public GoogleCloudPricingCalculatorPage setupNumberOfGPU(){
        getChooseNumberOfGPU.click();
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//md-option[@value='1' and @ng-repeat='item in listingCtrl.supportedGpuNumbers[listingCtrl.computeServer.gpuType]']/div")));
        setNumberOfGPU.click();
        return this;
    }
    public GoogleCloudPricingCalculatorPage setupGPUType(){
        getChooseGPUType.click();
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//md-option[@value='NVIDIA_TESLA_V100']/child::div[@class='md-text ng-binding']")));
        setGPUType.click();
        return this;
    }

    public GoogleCloudPricingCalculatorPage installCapacitySSD(){
        chooseCapacitySSD.click();
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//md-option[@value='2' and @ng-repeat='item in listingCtrl.supportedSsd']/div[@class='md-text ng-binding']")));
        setCapacitySSD.click();
        return this;
    }

    public GoogleCloudPricingCalculatorPage installDataCenterLocation(){
        chooseDataCenterLocation.click();
//        new WebDriverWait(driver, 10)
//                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//md-select[@id='select_92' and @aria-expanded='true']")));
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='select_option_205']/div[@class='md-text ng-binding']")));
        setDataCenterLocation.click();
        return this;
    }
    public GoogleCloudPricingCalculatorPage selectCommittedUsage(){
        chooseCommittedUsage.click();
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//md-option[@value='1' and @id='select_option_97']/child::div[@class='md-text']")));
        setCommittedUsage = driver.findElement(By.xpath("//md-option[@value='1' and @id='select_option_97']/child::div[@class='md-text']"));
        setCommittedUsage.click();
        return this;
    }
    public GoogleCloudPricingCalculatorPage clickAddToEstimate(){
        buttonAddToEstimate.click();
        return this;
    }

}
