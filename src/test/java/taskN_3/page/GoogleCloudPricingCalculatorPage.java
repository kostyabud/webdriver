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
    @FindBy (xpath = "//input[@id='input_63']")
    private WebElement numberOfInstances;
    @FindBy (xpath = "//*[@id='select_value_label_59']/span[2]")
    private WebElement buttonSeriesMF;
    @FindBy (xpath = "//*[@id='select_option_188']/div[1]")
    private WebElement setFamilyMachine;
    @FindBy (xpath = "//*[@id='select_value_label_60']/span[2]")
    private WebElement chooseMachineType;
    @FindBy (xpath = "//*[@id='select_option_360']/div[1]")
    private WebElement setMachineType;
    @FindBy (xpath = "//*[@id='mainForm']/div[2]/div/md-card/md-card-content/div/div[1]/form/div[8]/div[1]/md-input-container/md-checkbox/div[1]")
    private WebElement setAddGPU;
    @FindBy (xpath = "//*[@id='select_value_label_392']/span[2]")
    private WebElement getChooseNumberOfGPU;
    @FindBy (xpath = "//*[@id=\"select_option_399\"]/div[1]")
    private WebElement setNumberOfGPU;
    @FindBy (xpath = "//*[@id='select_value_label_393']/span[2]")
    private WebElement getChooseGPUType;
    @FindBy (xpath = "//*[@id='select_option_406']/div[1]")
    private WebElement setGPUType;
    @FindBy (xpath = "//*[@id='select_value_label_354']/span[2]")
    private WebElement chooseCapacitySSD;
    @FindBy (xpath = "//*[@id='select_option_381']/div[1]")
    private WebElement setCapacitySSD;
    @FindBy(xpath = "//*[@id='select_value_label_61']/span[2]")
    private WebElement chooseDataCenterLocation;
    @FindBy (xpath = "//*[@id='select_option_205']/div[1]")
    private WebElement setDataCenterLocation;
    @FindBy (xpath = "//*[@id='select_value_label_62']/span[2]")
    private WebElement chooseCommittedUsage;
    @FindBy (xpath = "//*[@id='select_option_97']/div[1]")
    private WebElement setCommittedUsage;
    @FindBy (xpath = "//*[@id='mainForm']/div[2]/div/md-card/md-card-content/div/div[1]/form/div[15]/button")
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

    public GoogleCloudPricingCalculatorPage enterValueMachineFamily(){
        buttonSeriesMF.click();
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='select_option_188']/div[1]")));
        setFamilyMachine.click();
        return this;
    }

    public GoogleCloudPricingCalculatorPage selectMachineType (){
        chooseMachineType.click();
        new WebDriverWait(driver, 10).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='select_option_360']/div[1]")));
        setMachineType.click();
        return this;
    }
    public GoogleCloudPricingCalculatorPage pushAddGPU (){
        setAddGPU.click();
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions
                        .presenceOfElementLocated(By.xpath("/html/body/md-content/md-card/div/md-card-content[1]/div[2]/div/md-card/md-card-content/div/div[1]/form/div[9]/div[1]/div[1]/div[1]/md-input-container[1]/label")));
        return this;
    }

    public GoogleCloudPricingCalculatorPage setupNumberOfGPU(){
        getChooseNumberOfGPU.click();
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body")));
        setNumberOfGPU.click();
        return this;
    }
    public GoogleCloudPricingCalculatorPage setupGPUType(){
        getChooseGPUType.click();
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='select_option_406']/div[1]")));
        setGPUType.click();
        return this;
    }

    public GoogleCloudPricingCalculatorPage installCapacitySSD(){
        chooseCapacitySSD.click();
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='select_option_381']/div[1]")));
        setCapacitySSD.click();
        return this;
    }

    public GoogleCloudPricingCalculatorPage installDataCenterLocation(){
        chooseDataCenterLocation.click();
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='select_option_205']/div[1]")));
        setDataCenterLocation.click();
        return this;
    }
    public GoogleCloudPricingCalculatorPage selectCommittedUsage(){
        chooseCommittedUsage.click();
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='select_option_97']/div[1]")));
        setCommittedUsage.click();
        return this;
    }
    public GoogleCloudPricingCalculatorPage clickAddToEstimate(){
        buttonAddToEstimate.click();
        return this;
    }

}
