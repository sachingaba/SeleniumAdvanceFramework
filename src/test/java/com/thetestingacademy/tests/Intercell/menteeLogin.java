package com.thetestingacademy.tests.Intercell;

import com.thetestingacademy.baseTest.CommonToAllTest;
import com.thetestingacademy.driver.DriverManagerTL;
import com.thetestingacademy.pages.menteeLoginpage;
import com.thetestingacademy.utils.PropertiesReader;
import io.qameta.allure.Owner;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class menteeLogin extends CommonToAllTest {

    @Owner("Sachin Gaba")
    @Test
    public void verifyCredentials_Error() {
        menteeLoginpage l1 = new menteeLoginpage(DriverManagerTL.getDriver());
        String error_msg = l1.loginToIC_Invalid(
                PropertiesReader.readKey("user"),
                PropertiesReader.readKey("invalid_pass")
        );

        // Assertions
        assertThat(error_msg).isNotNull().isNotEmpty().isNotBlank();
        Assert.assertEquals(error_msg, PropertiesReader.readKey("login_error_msg"));
    }

    @Owner("Sachin Gaba")
    @Test
    public void verifyCredentials_Valid() {
        // Use the ThreadLocal driver — initialised by @BeforeMethod in CommonToAllTest
        menteeLoginpage l2 = new menteeLoginpage(DriverManagerTL.getDriver());
        l2.loginToIC_Valid(
                PropertiesReader.readKey("user"),
                PropertiesReader.readKey("pass")
        );

        // Assertions
        Assert.assertEquals(
                DriverManagerTL.getDriver().getCurrentUrl(),
                PropertiesReader.readKey("login_dashboard_url")
        );
        // ✅ Do NOT call driver.quit() here — @AfterMethod in CommonToAllTest handles it
    }
}
