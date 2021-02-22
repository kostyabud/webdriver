package taskN_2.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import taskN_2.page.PastebinCreatNewPastPO;


public class WebDriverPastebinTest {
    private WebDriver driver;
    private String textCode = "git config --global user.name  \"New Sheriff in Town\"\n" +
            "git reset $(git commit-tree HEAD^{tree} -m \"Legacy code\")\n" +
            "git push origin master --force";

    private String title = "how to gain dominance among developers";
    private   PastebinCreatNewPastPO creatNewPastPO;

    @BeforeMethod(alwaysRun = true)
    public void browserSetup(){
        System.setProperty("webdriver.chrome.driver", "src\\test\\resources\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        creatNewPastPO = new PastebinCreatNewPastPO(driver);
        creatNewPastPO.openBrowser()
                .fillText(textCode)
                .choseSyntax()
                .chooseTenMinutesToPasteExpiration()
                .introduceTitleName(title)
                .pushButtonCreateNewPaste();
        new WebDriverWait(driver, 10).until(ExpectedConditions.titleContains(title));

    }

    @Test
    public void testTitlePageBrowserMatchPasteName (){
        Assert.assertTrue(driver.getTitle().startsWith(title));
    }

    @Test
    public void compareEnteredCodeWithReceived(){
        final String code = driver.findElement(By.xpath("//textarea[@class='textarea']")).getText();
        Assert.assertEquals(code, textCode);
    }

    @Test
    public void assertSyntaxIsBash (){
        final String syntaxHighlighting = driver.findElement(By.xpath("//ol[@class='bash']"))
                .getAttribute("class");
        Assert.assertEquals(syntaxHighlighting, "bash");

    }

    @AfterMethod (alwaysRun = true)
    public void closeBrowser(){
        driver.quit();
        driver = null;

    }

}

