package com.trycloud.tests;

import com.github.javafaker.Faker;
import com.trycloud.tests.base.TestBase;
import com.trycloud.utilities.BrowserUtils;
import com.trycloud.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class US_003_TC006_Adnan extends TestBase {


    @Test
    public void test() {

        login();

        WebElement fileButton = Driver.getDriver().findElement(By.xpath("(//a[@aria-label='Files'])[1]"));
        fileButton.click();

        BrowserUtils.sleep(2);

        WebElement plusIcon = Driver.getDriver().findElement(By.xpath("//a[@class='button new']"));
        plusIcon.click();

        WebElement newFolderButton = Driver.getDriver().findElement(By.xpath("//a[.='New folder']"));

        newFolderButton.click();

        WebElement folderName = Driver.getDriver().findElement(By.xpath("//input[@id='view13-input-folder']"));
        BrowserUtils.sleep(2);
        folderName.sendKeys(Keys.BACK_SPACE);

        BrowserUtils.sleep(1);

        Faker faker = new Faker();
        String name = faker.country().name();
        folderName.sendKeys(name + Keys.ENTER);

        // if new folder name is same as one of the existed ones then aready exist text should be display.
        String existingFolderName = Driver.getDriver().findElement(By.xpath("//a[@class='name']")).getText();
        if (name.equals(existingFolderName)) {

            String alreadyExistText = Driver.getDriver().findElement(By.xpath("//div[@class='tooltip-inner']")).getText();
            Assert.assertEquals(alreadyExistText, name + " already exist");

        }
        BrowserUtils.sleep(2);


        WebElement addedFolder = Driver.getDriver().findElement(By.xpath("//div[@class='thumbnail']"));

        Assert.assertTrue(addedFolder.isDisplayed());
    }
}
