package taskN_3.test;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import taskN_3.driver.DriverSingleton;

public class CommonConditions {
    protected WebDriver driver;

    @BeforeMethod()
    public void setup(){
        driver = DriverSingleton.getDriver();

    }

    @AfterMethod(alwaysRun = true)
    public void stopBrowser () {DriverSingleton.closeDriver();}
}
