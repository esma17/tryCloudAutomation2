package com.trycloud.tests;


import com.trycloud.tests.base.TestBase;
import com.trycloud.utilities.BrowserUtils;
import com.trycloud.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class US_003_TC005_Adnan extends TestBase {

    @Test
    public void test() {

        login();
        WebElement fileButton = Driver.getDriver().findElement(By.xpath("(//a[@aria-label='Files'])[1]"));
        fileButton.click();

        BrowserUtils.sleep(2);

        WebElement plusIcon = Driver.getDriver().findElement(By.xpath("//a[@class='button new']"));
        plusIcon.click();

        WebElement uploadFileButton = Driver.getDriver().findElement(By.xpath("//label[@for='file_upload_start']"));

        uploadFileButton.sendKeys("C:\\Users\\ADNAN\\Desktop\\Screenshot 2021-02-04 193055.png"+ Keys.ENTER);


        BrowserUtils.sleep(2);

    }


}
