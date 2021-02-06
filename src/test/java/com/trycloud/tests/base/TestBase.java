package com.trycloud.tests.base;

import com.trycloud.utilities.ConfigurationReader;
import com.trycloud.utilities.Driver;
import org.openqa.selenium.By;


public abstract class TestBase {

    public void login() {

        Driver.getDriver().get(ConfigurationReader.getProperty("url"));
        String username = ConfigurationReader.getProperty("username23");
        String password = ConfigurationReader.getProperty("password");
        Driver.getDriver().findElement(By.xpath("//input[@id='user']")).sendKeys(username);
        Driver.getDriver().findElement(By.xpath("//input[@id='password']")).sendKeys(password);
        Driver.getDriver().findElement(By.xpath("//input[@id='submit-form']")).click();


    }


}
