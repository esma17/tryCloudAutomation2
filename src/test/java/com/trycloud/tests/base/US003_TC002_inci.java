package com.trycloud.tests.base;

import com.trycloud.utilities.BrowserUtils;
import com.trycloud.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

public class US003_TC002_inci extends TestBase{
    @Test(priority =1,description = "verify users can select all the uploaded files from the page ")
    public void test1(){
      //1.login as a user
        login();
        //2.open Files module
        WebElement fileModuleButton= Driver.getDriver().findElement(By.xpath("//li[@data-id='files']"));
        fileModuleButton.click();
        BrowserUtils.sleep(3);
      //3.click the top lef checkbox of the table
        WebElement leftCheckboxButton=Driver.getDriver().findElement(By.xpath("//label[@for='select_all_files']"));
        leftCheckboxButton.click();
      //4.Assert all the files are selected
        WebElement allSelectedFiles=Driver.getDriver().findElement(By.xpath("//*[@class='selection']"));
        Assert.assertTrue(allSelectedFiles.isDisplayed());
    }
    @AfterClass
    public void teardown() {
        Driver.closeDriver();
    }
}
