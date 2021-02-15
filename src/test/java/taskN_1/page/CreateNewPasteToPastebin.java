package taskN_1.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CreateNewPasteToPastebin {
    public static void main(String[] args) throws InterruptedException {
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
