package com.thetestingacademy.tests.Intercell;

import com.thetestingacademy.base.CommonToALL;
import com.thetestingacademy.baseTest.CommonToAllTest;
import com.thetestingacademy.baseTest.WaitHelpers;
import com.thetestingacademy.driver.DriverManager;
import com.thetestingacademy.pages.SessionBookingPage;
import com.thetestingacademy.pages.menteeLoginpage;
import com.thetestingacademy.utils.PropertiesReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

import static com.thetestingacademy.driver.DriverManager.driver;


public class Session_Booking extends CommonToAllTest {

    @Test
    public void createSession(){
        menteeLoginpage l1 = new menteeLoginpage(DriverManager.getDriver());
        l1.loginToIC_Valid(PropertiesReader.readKey("user"),PropertiesReader.readKey("pass"));
        Assert.assertEquals(driver.getCurrentUrl(),PropertiesReader.readKey("login_dashboard_url"));
        SessionBookingPage s1 = new SessionBookingPage(DriverManager.getDriver());
        s1.sessionBooking();



        WebElement noti_tab = driver.findElement(By.xpath("//div[@id=\"notification_top\"]"));
                //a[@href=\"/account/notifications\"]
        WebDriverWait webDriverWait = new WebDriverWait(driver,Duration.ofSeconds(15));
        webDriverWait.until(ExpectedConditions.elementToBeClickable(noti_tab));
        noti_tab.click();

        WebElement noti_read_accept = driver.findElement(By.xpath("//span[contains(text(),\"Your session request has been submitted\")]"));
        boolean requestHasBeenSubmitted = noti_read_accept.getText().contains("request has been submitted");
            System.out.println(requestHasBeenSubmitted);
            noti_read_accept.click();
    //    Assert.assertEquals(noti_read_accept.getText(),"Your session request has been submitted to Ankit Jain");


        //Upcoming Session view


        WebElement upcomingSession = driver.findElement(By.xpath("//span[contains(text(),\"Sessions\")]"));
        upcomingSession.click();
        WaitHelpers.checkVisibility(driver,By.xpath("//a[@data-target=\"#list_view\"]"));
        WebElement upcomingViewList = driver.findElement(By.xpath("//a[@data-target=\"#list_view\"]"));
        upcomingViewList.click();


        WebElement viewSession = driver.findElement(By.xpath("//div[contains(@class,'float-right')]//button[contains(text(),'View More')][1]"));
        WaitHelpers.checkVisibility(driver,By.xpath("//div[contains(@class,'float-right')]//button[contains(text(),'View More')][1]"));
viewSession.click();

WebElement cancelSession = driver.findElement(By.xpath("//button[@data-target=\"#menteecancel\"]"));
cancelSession.click();


            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

            // 1. Find dropdown
            WebElement dropdown = wait.until(ExpectedConditions.presenceOfElementLocated(
                    By.xpath("//*[@id=\"menteecancel\"]/div/div/div/form/div[1]/div/select")));
            dropdown.click();
        Select select = new Select(dropdown);
        select.selectByVisibleText("Unavailable to take the session");





WebElement cancel_confirm = driver.findElement(By.xpath("//button[@id='cancel_confirm' and contains(@class,'btn-squared')]"));
cancel_confirm.click();

//OK POP-UP
        wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//button[text()='OK']")));
        WebElement ok_btn = driver.findElement(By.xpath("//button[text()=\"OK\"]"));
        ok_btn.click();


        // Notification

     //   WebElement noti_tab = driver.findElement(By.xpath("//a[@href=\"/account/notifications\"]"));
        WaitHelpers.checkVisibility(driver,By.xpath("//span[@class=\"intercell_tab_text_remove\" and text()=\"Notifications\"]"));
        WebElement noti_tab2 = driver.findElement(By.xpath("//span[@class=\"intercell_tab_text_remove\" and text()=\"Notifications\"]"));
       wait.until(ExpectedConditions.elementToBeClickable(noti_tab2));
        noti_tab2.click();

        //Reading notification
      WebElement noti_read_cancel = driver.findElement(By.xpath("//span[text()=\"Session cancellation success\"]"));
        noti_read_cancel.click();
        noti_read_cancel.getText();
        Assert.assertEquals(noti_read_cancel.getText(),"Session cancellation success");








    }
}
