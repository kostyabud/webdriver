
package taskN_3.test;

import org.openqa.selenium.By;

import org.testng.Assert;

import org.testng.annotations.Test;

public class TotalEstimatedMonthlyCostCheckTest extends CommonConditions{



    @Test
    public void test(){
        openPricingCalculator();
        fillFormToPricingCalculator();
        getTempEmailAndReadLetter();
        String monthlyCostCheck = driver.findElement(By.xpath("//h3[contains(text(),'USD')]")).getText();
        String expectedMonthlyCost = "USD 1,082.77";

        Assert.assertEquals(monthlyCostCheck, expectedMonthlyCost);

    }

}
