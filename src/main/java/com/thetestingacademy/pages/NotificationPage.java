package com.thetestingacademy.pages;

import com.thetestingacademy.driver.DriverManagerTL;
import com.thetestingacademy.utils.WaitHelpers;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class NotificationPage {
    public WebDriver getDriver() {
        return driver;
    }

    public NotificationPage(WebDriver driver) {
        this.driver = driver;
    }

    public void setDriver(WebDriver driver) {
        this.driver = driver;
    }

    WebDriver driver;


    private By noti_Tab = By.xpath("//div[@id=\"notification_top\"]");
    private By noti_read = By.xpath("//div[@class=\"row\"]/following::ul/*");


    public void viewNotifications(){

        WaitHelpers.implicitWait(DriverManagerTL.getDriver(),3);
        DriverManagerTL.getDriver().findElement(noti_Tab).click();

        List<WebElement> notifications = driver.findElements(noti_read);

        for(WebElement notification:notifications){
            System.out.println(notification.getText());
        }

    }

}

