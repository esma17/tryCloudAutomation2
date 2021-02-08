package com.trycloud.tests;

import com.github.javafaker.Faker;
import com.trycloud.tests.base.TestBase;
import com.trycloud.utilities.BrowserUtils;
import com.trycloud.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import java.util.List;

public class US004_TC002_esma extends TestBase {
    WebDriver driver = Driver.getDriver();

    @Test(description = "Validation of users can send message via Talk module by searching name")
    public void t1() {
//        1. Login as a user
        login();
//        2. Click Talks module
        WebElement buttonTalk = driver.findElement(By.xpath("(//a[@aria-label='Talk'])[1]"));
        buttonTalk.click();
        BrowserUtils.sleep(3);
//        3. Search a user from search box on the left
        WebElement searchBox = driver.findElement(By.xpath("//input[contains(@placeholder,'Search conversations')]"));
        String searchInput = "User10";
        searchBox.sendKeys(searchInput);
        BrowserUtils.sleep(3);
        //When you search All the users  are in the same format so I stored the locator as String
        String searchResult = "//a[@aria-label='Conversation, %s']";
        //with String.format method I passed as xpath (searchIResult) and instead of %s it will pass--> searchInput
        WebElement user = driver.findElement(By.xpath(String.format(searchResult, searchInput)));
        //click to the user
        user.click();

        BrowserUtils.sleep(3);
//        4. Write a message
        Faker faker = new Faker();
        String message = faker.harryPotter().character();
        WebElement messageBox = driver.findElement(By.xpath("//div[contains(@placeholder,'Write')]"));
        messageBox.sendKeys(message);
//        5. Click submit button
        WebElement buttonSubmit = driver.findElement(By.xpath("//button[@aria-label='Send message']"));
        buttonSubmit.click();
//        6. Verify the message is displayed on the conversation log

        //this list  of WebElements will get ALL the messages appear in the chat
        List<WebElement> allMessages = driver.findElements(By.xpath("(//div[@class='messages'])[2]/div"));
        //to verify that the message I send appears in chat, I get the LAST element from allMessages
        // and assign to 'actualResult'
        WebElement actualResult = allMessages.get(allMessages.size() - 1);
        //I validate the last sent message is displayed or not
        Assert.assertTrue(actualResult.isDisplayed());
        //I want to assert that the actualResult is equals to the message we sent
        Assert.assertEquals(actualResult.getText(), (message));
        BrowserUtils.sleep(3);

    }

    @AfterClass
    public void teardown() {
        Driver.closeDriver();
    }
}
