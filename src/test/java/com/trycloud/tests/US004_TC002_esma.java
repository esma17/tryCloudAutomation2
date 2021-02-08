package com.trycloud.tests;

import com.github.javafaker.Faker;
import com.trycloud.tests.base.TestBase;
import com.trycloud.utilities.BrowserUtils;
import com.trycloud.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;


public class US004_TC002_esma extends TestBase {
    WebDriver driver = Driver.getDriver();

    @Test(description = "Validation of users can send message via Talk module by searching name")
    public void t1() {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 15);
//        1. Login as a user
        login();
//        2. Click Talks module
        WebElement buttonTalk = driver.findElement(By.xpath("(//a[@aria-label='Talk'])[1]"));
        buttonTalk.click();

        // 3. Search a user from search box on the left
        WebElement searchBox = driver.findElement(By.xpath("//input[contains(@placeholder,'Search conversations')]"));
        String searchInput = "User60";
        //used dynamic wait for sending searInput
        sendTheKeys(searchBox, 15, searchInput);

        //When you search All the users  are in the same format so I stored the locator as String
        String searchResult = "//a[@aria-label='Conversation, %s']";
        //with String.format method I passed as xpath (searchIResult) and instead of %s it will pass--> searchInput
        WebElement user = driver.findElement(By.xpath(String.format(searchResult, searchInput)));
        //click to the user
        user.click();
//        4. Write a message
        Faker faker = new Faker();
        String message = faker.ancient().hero();
        WebElement messageBox = driver.findElement(By.xpath("//div[contains(@placeholder,'Write')]"));
        sendTheKeys(messageBox, 15, message);
//        5. Click submit button
        WebElement buttonSubmit = driver.findElement(By.xpath("//button[@aria-label='Send message']"));
        // ****I tried to use dynamic wait but didnt work with the ones I found***
        BrowserUtils.sleep(6);
        buttonSubmit.click();
//        6. Verify the message is displayed on the conversation log

//        The message that we send it displayed with this locator %s--> will be the text we sent
        String messageSentText = "//div[.='%s']";
        // again used String format to put the message as text instead of %s
        WebElement messageSent = driver.findElement(By.xpath(String.format(messageSentText, message)));
        //will get the text as string from the webelement to verify with message
        String actualResult = messageSent.getText();
        // ****I tried to use dynamic wait but didnt work with the ones I found***
        BrowserUtils.sleep(6);
        //I want to assert that the actualResult is equals to the message we sent
        Assert.assertEquals(actualResult, (message));

    }

//dynamic wait for sending keys
    public static void sendTheKeys(WebElement element, int timeout, String text) {
        final WebDriverWait wait = new WebDriverWait(Driver.getDriver(), timeout);
        wait.until(ExpectedConditions.refreshed(
                ExpectedConditions.elementToBeClickable(element)));
        element.sendKeys(text);
    }
}
