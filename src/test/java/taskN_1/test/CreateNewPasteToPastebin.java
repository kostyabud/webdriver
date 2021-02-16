package taskN_1.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import taskN_1.page.CreatingNewPastePageObject;

public class CreateNewPasteToPastebin {
    @Test
    public  void testNewPast() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        CreatingNewPastePageObject pastebin = new CreatingNewPastePageObject(driver);
        pastebin.openPage()
                .fillingNewPaste("Hello from WebDriver")
                .installTenMinutesToPasteExpiration()
                .installTitle("helloweb")
                .pushButtonCreateNewPaste();

            Thread.sleep(4000); //чтобы наглядно увидеть результат
                driver.quit();
    }

}
