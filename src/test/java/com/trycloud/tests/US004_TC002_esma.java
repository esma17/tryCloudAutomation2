package com.trycloud.tests;

import com.trycloud.tests.base.TestBase;
import com.trycloud.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

public class US004_TC002_esma extends TestBase {
    @Test
    public void t1() {
        login();
        WebElement buttonActivity = Driver.getDriver().findElement(By.xpath("(//a[@aria-label='Activity'])[1]"));
        buttonActivity.click();
        Assert.assertTrue(Driver.getDriver().getTitle().startsWith("Activity"), "You didn't land to Activity page");


    }

    @AfterClass
    public void teardown() {
        Driver.closeDriver();
    }


}
