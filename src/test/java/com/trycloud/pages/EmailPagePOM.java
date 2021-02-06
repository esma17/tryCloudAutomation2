package com.trycloud.pages;

import com.trycloud.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class EmailPagePOM {

    WebElement emailIcon= Driver.getDriver().findElement(By.xpath("//div[@class='icon-mail']"));
    WebElement contactYourMailAcccount = Driver.getDriver().findElement(By.xpath(" //div[@id='emptycontent']/h2"));
    WebElement autoTab= Driver.getDriver().findElement(By.xpath(" //li[@class='tabs-component-tab is-active']"));
    WebElement manualTab= Driver.getDriver().findElement(By.xpath("//li[@class='tabs-component-tab']"));

    WebElement nameTab= Driver.getDriver().findElement(By.xpath("/html/body/div[3]/div/form/div/div/section[1]/label[1]"));
    WebElement userInput= Driver.getDriver().findElement(By.id("//input[@id='auto-name']"));
    WebElement mailAddress = Driver.getDriver().findElement(By.id("//input[@id='auto-name']"));
    WebElement mailAddressTab= Driver.getDriver().findElement(By.id("//input[@id='auto-address']"));
    WebElement password= Driver.getDriver().findElement(By.id("//input[@id='auto-password']"));
    WebElement passwordTab= Driver.getDriver().findElement(By.id("//input[@id='auto-password']"));
    WebElement connectTab= Driver.getDriver().findElement(By.xpath("//input[@class='primary']"));





}
