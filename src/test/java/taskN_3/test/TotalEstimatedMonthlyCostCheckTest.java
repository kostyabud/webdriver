
package taskN_3.test;

import org.openqa.selenium.By;

import org.testng.Assert;

import org.testng.annotations.Test;
import taskN_3.page.TenMinuteMailPageObj;

public class TotalEstimatedMonthlyCostCheckTest extends CommonConditions{



    @Test
    public void test(){
        setCalculatorPage();

        String monthlyCostCheck = driver.findElement(By.xpath("//h3[text()='USD 1,082.77']")).getText();
        String expectedMonthlyCost = "USD 1,082.77";
        Assert.assertEquals(monthlyCostCheck, expectedMonthlyCost);

    }

}
