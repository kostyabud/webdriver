
package taskN_3.test;

import org.openqa.selenium.By;

import org.testng.Assert;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TotalEstimatedMonthlyCostCheckTest extends CommonConditions{



    @Test
    public void test(){
        String monthlyCostCheck = driver.findElement(By.xpath("//h3[text()='USD 1,082.77']")).getText();
        String expectedMonthlyCost = "USD 1,082.77";
        Assert.assertEquals(monthlyCostCheck, expectedMonthlyCost);

    }

}
