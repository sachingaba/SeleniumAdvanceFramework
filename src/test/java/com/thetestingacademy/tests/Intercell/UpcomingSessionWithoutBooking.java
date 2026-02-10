package com.thetestingacademy.tests.Intercell;

import com.thetestingacademy.baseTest.CommonToAllTest;
import com.thetestingacademy.driver.DriverManager;
import com.thetestingacademy.pages.UpcomingSessionPage;
import com.thetestingacademy.pages.menteeLoginpage;
import com.thetestingacademy.utils.PropertiesReader;
import com.thetestingacademy.utils.WaitHelpers;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import static com.thetestingacademy.driver.DriverManager.driver;

public class UpcomingSessionWithoutBooking extends CommonToAllTest {

    @Test
    public void viewSession(){

        menteeLoginpage login = new menteeLoginpage(DriverManager.getDriver());
        login.loginToIC_Valid(PropertiesReader.readKey("user"),PropertiesReader.readKey("pass"));

        UpcomingSessionPage upcomingSessionPage = new UpcomingSessionPage(DriverManager.getDriver());
        upcomingSessionPage.viewUpcomingSession();
        WaitHelpers.checkVisibility(driver,By.xpath("//a[@href=\"/account/upcoming\" and span]"));
        WaitHelpers.waitJVM(3000);
        Assert.assertEquals(driver.findElement(By.xpath("//h1[text()=\"Session Details\"]")).getText(),"Session Details");
    }
}
