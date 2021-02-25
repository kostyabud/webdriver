package taskN_3.page;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;



public class GoogleCloudPricingCalculatorPage extends AbstractPage {

    private final By downloadList = By.xpath("//div[@class='md-select-menu-container md-active md-clickable']");
    private final By  setGPUType = By.xpath("//md-option[@value='NVIDIA_TESLA_V100']/child::div[@class='md-text ng-binding']");
    private final By waitingOptionChoose = By.xpath("//md-option[@value='1' and @ng-repeat='item in listingCtrl.supportedGpuNumbers[listingCtrl.computeServer.gpuType]']/div");
    private final By waitingButtonSeries = By.xpath("//md-select[@placeholder='Series']/descendant::span[@class]");
    private final By chooseMachineType = By.xpath("//md-select[@placeholder='Instance type']/descendant::span[@class]");
    private final By  setMachineType = By.xpath("//*[@value='CP-COMPUTEENGINE-VMIMAGE-N1-STANDARD-8']");
//    private final By buttonGpu = By.xpath("//*[@class='ng-scope layout-row']/descendant::div[@class='md-ripple-container']");
    private final By elemForScroll = By.xpath("//md-select[@placeholder='VM Class']/descendant::span[@class]");
    @FindBy (xpath = "//md-option[@value='n1']/div")
    private WebElement setSeriesFamilyMachine;
    @FindBy (xpath = "//input[@ng-model='listingCtrl.computeServer.quantity']")
    private WebElement numberOfInstances;
    @FindBy (xpath = "//md-select[@placeholder='Series']/descendant-or-self::md-select-value")
    private WebElement buttonSeriesMF;
    @FindBy (xpath = "//md-checkbox[@aria-label='Add GPUs' and @ng-model='listingCtrl.computeServer.addGPUs']/child::div[@class='md-container md-ink-ripple']")
    private WebElement choiceAddGPU;
    @FindBy (xpath = "//md-select[@placeholder='Number of GPUs']/descendant::div")
    private WebElement listNumberOfGPU;
    @FindBy (xpath = "//md-option[@value='1' and @ng-repeat='item in listingCtrl.supportedGpuNumbers[listingCtrl.computeServer.gpuType]']/div")
    private WebElement choiceNumberOfGPU;
    @FindBy (xpath = "//md-select[@placeholder='GPU type']/descendant::span[@class]")
    private WebElement getChooseGPUType;
    @FindBy (xpath = "//md-select[@placeholder='Local SSD' and @ng-model='listingCtrl.computeServer.ssd']/descendant::span[@class]")
    private WebElement chooseCapacitySSD;
    @FindBy (xpath = "//md-option[@value='2' and @ng-repeat='item in listingCtrl.supportedSsd']/div[@class='md-text ng-binding']")
    private WebElement setCapacitySSD;
    @FindBy (xpath = "//md-select[@placeholder='Datacenter location' and @ng-model='listingCtrl.computeServer.location']/descendant::span[@class]")
    private WebElement chooseDataCenterLocation;
    @FindBy (xpath = "//*[@id=\"select_option_206\"]/div[contains(text(),'Frankfurt')]")
    private WebElement setDataCenterLocation;
    @FindBy (xpath = "//md-select[@placeholder='Committed usage' and @aria-label='Committed usage: None']/descendant::span")
    private WebElement choiceCommittedUsage;
    @FindBy (xpath = "//*[@id=\"select_option_98\"]/div[contains(text(),'1 Year')]")
    private WebElement setCommittedUsage;
    @FindBy (xpath = "//button[@aria-label='Add to Estimate']")
    private WebElement buttonAddToEstimate;
    @FindBy (xpath = "//button[@id='email_quote']")
    private WebElement buttonEmailEstimate;



    public GoogleCloudPricingCalculatorPage(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public GoogleCloudPricingCalculatorPage enterValuesInstances(Integer number){
        driver.switchTo().frame(0);
        driver.switchTo().frame("myFrame");
        numberOfInstances.sendKeys(number.toString());
        return this;
    }

    public GoogleCloudPricingCalculatorPage enterValueSeriesMachineFamily(){

        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.elementToBeClickable(waitingButtonSeries));
        buttonSeriesMF.click();
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.presenceOfElementLocated(downloadList));
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.visibilityOf(setSeriesFamilyMachine));
       setSeriesFamilyMachine.click();
                WebElement element = driver.findElement(elemForScroll);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
        return this;
    }

    public GoogleCloudPricingCalculatorPage selectMachineType (){

        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.elementToBeClickable(chooseMachineType));
        driver.findElement(chooseMachineType).click();
        new WebDriverWait(driver, 10).until(ExpectedConditions.presenceOfElementLocated(downloadList));
        new WebDriverWait(driver, 10).until(ExpectedConditions.presenceOfElementLocated(setMachineType));
        driver.findElement(setMachineType).click();
        return this;
    }
    public GoogleCloudPricingCalculatorPage clickAddGPU(){
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.visibilityOf(choiceAddGPU));
        choiceAddGPU.click();
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.presenceOfElementLocated(waitingOptionChoose));
        return this;
    }

    public GoogleCloudPricingCalculatorPage setupNumberOfGPU(){
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.elementToBeClickable(listNumberOfGPU));
        listNumberOfGPU.click();
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.presenceOfElementLocated(downloadList));
        choiceNumberOfGPU.click();
        return this;
    }
    public GoogleCloudPricingCalculatorPage setupGPUType(){
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.elementToBeClickable(getChooseGPUType));
        getChooseGPUType.click();
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.presenceOfElementLocated(downloadList));
        driver.findElement(setGPUType).click();
        return this;
    }

    public GoogleCloudPricingCalculatorPage introduceCapacitySSD(){
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.elementToBeClickable(chooseCapacitySSD));
        chooseCapacitySSD.click();
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.presenceOfElementLocated(downloadList));
        setCapacitySSD.click();
        return this;
    }

    public GoogleCloudPricingCalculatorPage chooseDataCenterLocation(){
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.elementToBeClickable(chooseDataCenterLocation));
        chooseDataCenterLocation.click();
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.presenceOfElementLocated(downloadList));
        setDataCenterLocation.click();
        return this;
    }
    public GoogleCloudPricingCalculatorPage selectCommittedUsage(){
        choiceCommittedUsage.click();
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.presenceOfElementLocated(downloadList));
        setCommittedUsage.click();
        return this;
    }
    public GoogleCloudPricingCalculatorPage clickAddToEstimate(){
        buttonAddToEstimate.click();
        return this;
    }

    public GoogleCloudPricingCalculatorPage clickEmailEstimate(){
        buttonEmailEstimate.click();
        return this;
    }

}
