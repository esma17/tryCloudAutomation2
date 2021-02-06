package com.trycloud.pages;

import com.trycloud.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import sun.java2d.loops.DrawRect;

class LogInPagePOM {
    WebElement buttonDashbord= Driver.getDriver().findElement(By.xpath("//ul[@id='appmenu']/li[1]"));
    WebElement buttonFile = Driver.getDriver().findElement(By.xpath("//ul[@id='appmenu']/li[2]"));
    WebElement buttonPicture = Driver.getDriver().findElement(By.xpath("//ul[@id='appmenu']/li[3]"));
    WebElement buttonActivity = Driver.getDriver().findElement(By.xpath( "//ul[@id='appmenu']/li[4]"));
    WebElement buttonTalk = Driver.getDriver().findElement(By.xpath("//ul[@id='appmenu']/li[5]"));
    WebElement buttonMail = Driver.getDriver().findElement(By.xpath("//ul[@id='appmenu']/li[6]"));
    WebElement buttonContacts= Driver.getDriver().findElement(By.xpath("//ul[@id='appmenu']/li[7]"));
    WebElement buttonCircle=Driver.getDriver().findElement(By.xpath("//ul[@id='appmenu']/li[8]"));
    WebElement buttonCalendar= Driver.getDriver().findElement(By.xpath("//ul[@id='appmenu']/li[9]"));
    WebElement buttonDeck= Driver.getDriver().findElement(By.xpath("//ul[@id='appmenu']/li[10]/a"));

    WebElement buttonSearch= Driver.getDriver().findElement(By.xpath("//div[@class='header-menu unified-search']"));
    WebElement buttonNotification= Driver.getDriver().findElement(By.xpath("//div[@class='notifications-button menutoggle']"));
    WebElement buttonContactMenu= Driver.getDriver().findElement(By.xpath("icon-contacts menutoggle"));
    WebElement buttonMenuToggle = Driver.getDriver().findElement(By.xpath("//div[@class='menutoggle']"));
    WebElement buttonTryCloudLogo = Driver.getDriver().findElement(By.xpath("//div[@class='logo logo-icon']"));

    public void buttonDashbordClick(){ buttonDashbord.click(); }
    public void buttonFileClick(){ buttonFileClick();}
    public void buttonPictureClick(){ buttonPictureClick();}
    public void buttonActivityClick() {
        buttonActivity.click();
    }
    public void buttonTalkClick() {
        buttonTalk.click();
    }
    public void buttonMailClick() { buttonMail.click();}
    public void buttonContactsClick(){ buttonContacts.click();}
    public void buttonCircleClick(){ buttonCircle.click();}
    public void buttonCalendarClick() {
        buttonCalendar.click();
    }
    public void buttonDeckClick() {
        buttonDeck.click();
    }

   public void buttonSearchClick(){ buttonSearch.click();}

    public void buttonNotificationClick() {
        buttonNotification.click();
    }
    public void buttonContactMenuClick() {
        buttonContactMenu.click();
    }
    public void buttonMenuToggleClick(){ buttonMenuToggle.click();}




}
