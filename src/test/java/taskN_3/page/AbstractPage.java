package taskN_3.page;

import org.openqa.selenium.WebDriver;

public  class AbstractPage {
    protected WebDriver driver;


    protected final int WAIT_TIMEOUT_SECONDS = 10;

    protected AbstractPage(WebDriver driver)
    {
        this.driver = driver;
    }
}
