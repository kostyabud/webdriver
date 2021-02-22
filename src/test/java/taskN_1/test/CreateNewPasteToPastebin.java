package taskN_1.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import taskN_1.page.CreatingNewPastePageObject;

public class CreateNewPasteToPastebin {
    @Test
    public  void testNewPast() throws InterruptedException {
      System.setProperty("webdriver.chrome.driver", "src\\test\\resources\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        CreatingNewPastePageObject pastebin = new CreatingNewPastePageObject(driver);
        pastebin.openPage()
                .inputText("Hello from WebDriver")
                .selectTenMinutesToPasteExpiration()
                .enterTitleName("helloweb")
                .pushButtonCreateNewPaste();

            Thread.sleep(4000); //чтобы наглядно увидеть результат
                driver.quit();
    }

}
