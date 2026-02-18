package com.thetestingacademy.tests.Intercell;

import com.thetestingacademy.base.CommonToALL;
import com.thetestingacademy.baseTest.CommonToAllTest;
import com.thetestingacademy.baseTest.WaitHelpers;
import com.thetestingacademy.driver.DriverManager;
import com.thetestingacademy.driver.DriverManagerTL;
import com.thetestingacademy.pages.menteeLoginpage;
import com.thetestingacademy.utils.PropertiesReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.qameta.allure.Owner;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

import java.time.Duration;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class menteeLogin extends CommonToAllTest {

    @Owner("Sachin Gaba")
    @Test
    public void verifyCredentials_Error() {

        menteeLoginpage l1 = new menteeLoginpage(DriverManager.getDriver());
        String error_msg = l1.loginToIC_Invalid(PropertiesReader.readKey("user"),
                PropertiesReader.readKey("invalid_pass"));

        // Assertions
        assertThat(error_msg).isNotNull().isNotEmpty().isNotBlank();
        Assert.assertEquals(error_msg, PropertiesReader.readKey("login_error_msg"));
        DriverManagerTL.getDriver().quit();
    }

    @Owner("Sachin Gaba")
    @Test
    public void verifyCredentials_Valid() {
        // Driver class
        WebDriver driver = new ChromeDriver();

        // Page Object Model
        menteeLoginpage l2 = new menteeLoginpage(driver);
        l2.loginToIC_Valid(PropertiesReader.readKey("user"), PropertiesReader.readKey("pass"));

        // Assertions

        Assert.assertEquals(driver.getCurrentUrl(), PropertiesReader.readKey("login_dashboard_url"));
        driver.quit();
    }
}
