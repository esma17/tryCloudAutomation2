package com.trycloud.tests;

import com.trycloud.tests.base.TestBase;
import com.trycloud.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class US006_TC001_002_jamila extends TestBase {


    @Test
    public void t1() {

//Test case #1 - verify users can access to NOtes module
//1. Login as a user
        login();
//2. Click “Notes” module
        WebElement buttonNotification = Driver.getDriver().findElement(By.xpath("//div[@class='notifications-button menutoggle']"));
                buttonNotification.click();
//3. Verify the page tile/URL is Notes module’s tile
        String actualTitle= Driver.getDriver().getTitle();
        String expectedTitle= "No notifications";
        Assert.assertFalse(Boolean.parseBoolean(actualTitle),expectedTitle);


    }

    @Test
    public void tc2() {
//1. Login as a user
        login();

//2. Click notes module
        WebElement buttonNotification = Driver.getDriver().findElement(By.xpath("//div[@class='notifications-button menutoggle']"));
        buttonNotification.click();
//3. Click “New Note” button

//4. Write a message/Note

//5. Verify the note is added on the note list


    }
}
