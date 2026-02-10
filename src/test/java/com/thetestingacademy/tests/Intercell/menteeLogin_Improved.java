package com.thetestingacademy.tests.Intercell;

import com.thetestingacademy.baseTest.CommonToAllTest;
import com.thetestingacademy.driver.DriverManager;
import com.thetestingacademy.pages.menteeLoginpage;
import com.thetestingacademy.utils.PropertiesReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.apache.poi.ss.formula.CollaboratingWorkbooksEnvironment.setup;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class menteeLogin_Improved extends CommonToAllTest {


    @Test
    public void verifyCredentials_Error() {

        //Page Object Model
        menteeLoginpage l1 = new menteeLoginpage(DriverManager.getDriver());
        String error_msg = l1.loginToIC_Invalid(PropertiesReader.readKey("user"),PropertiesReader.readKey("invalid_pass"));

        //Assertions
        assertThat(error_msg).isNotNull().isNotEmpty().isNotBlank();
        Assert.assertEquals(error_msg,PropertiesReader.readKey("login_error_msg"));

    }
    @Test
    public void verifyCredentials_Valid() {


        //Page Object Model
        menteeLoginpage l2 = new menteeLoginpage(DriverManager.getDriver());
l2.loginToIC_Valid(PropertiesReader.readKey("user"),PropertiesReader.readKey("pass"));

        //Assertions

        Assert.assertEquals(DriverManager.driver.getCurrentUrl(),PropertiesReader.readKey("login_dashboard_url"));

    }
}
