package com.trycloud.tests;

import com.github.javafaker.Faker;
import com.trycloud.tests.base.TestBase;
import com.trycloud.utilities.BrowserUtils;
import com.trycloud.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import java.util.List;

public class US004_TC002_esma extends TestBase {
    @Test(description = "Validation of users can send message via Talk module by searching name")
    public void t1() {
//        1. Login as a user
        login();
//        2. Click Talks module
        WebElement buttonTalk = Driver.getDriver().findElement(By.xpath("(//a[@aria-label='Talk'])[1]"));
        buttonTalk.click();
        BrowserUtils.sleep(3);
//        3. Search a user from search box on the left
        WebElement searchBox = Driver.getDriver().findElement(By.xpath("//input[contains(@placeholder,'Search conversations')]"));
        String searchInput = "User100";
        searchBox.sendKeys(searchInput);
        BrowserUtils.sleep(3);
        List<WebElement> searchOutputs = Driver.getDriver().findElements(By.xpath("//a[contains(@aria-label,'Conversation,')]"));

        searchOutputs.get(0).click();
        BrowserUtils.sleep(3);
//        4. Write a message
        Faker faker = new Faker();
        String message = faker.harryPotter().character();
        WebElement messageBox = Driver.getDriver().findElement(By.xpath("//div[contains(@placeholder,'Write')]"));
        messageBox.sendKeys(message);
//        5. Click submit button
        WebElement buttonSubmit=Driver.getDriver().findElement(By.xpath("//button[@aria-label='Send message']"));
        buttonSubmit.click();
//        6. Verify the message is displayed on the conversation log
        List<WebElement> allMessages=Driver.getDriver().findElements(By.xpath("(//div[@class='messages'])[2]/div"));
        WebElement actualResult= allMessages.get(allMessages.size() - 1);
        Assert.assertTrue(actualResult.isDisplayed());
        BrowserUtils.sleep(3);

    }

    @AfterClass
    public void teardown() {
        Driver.closeDriver();
    }
}
