package com.thetestingacademy.tests.Intercell;

import com.thetestingacademy.base.CommonToALL;
import com.thetestingacademy.pages.menteeLoginpage;
import com.thetestingacademy.pages.profilePage;
import com.thetestingacademy.utils.PropertiesReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import io.qameta.allure.Owner;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MenteeProfile extends com.thetestingacademy.base.CommonToALL {

    @Owner("Sachin Gaba")
    @Test
    public void menteeProfileUpdate() {

        WebDriver driver = new ChromeDriver();

        menteeLoginpage l1 = new menteeLoginpage(driver);

        l1.loginToIC_Valid(PropertiesReader.readKey("user"), PropertiesReader.readKey("pass"));

        Assert.assertEquals(driver.getCurrentUrl(), PropertiesReader.readKey("login_dashboard_url"));

        profilePage p1 = new profilePage(driver);
        p1.updateProfile();

        driver.quit();

    }
}
