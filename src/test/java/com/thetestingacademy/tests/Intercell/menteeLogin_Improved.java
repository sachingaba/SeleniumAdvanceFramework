package com.thetestingacademy.tests.Intercell;

import com.thetestingacademy.baseTest.CommonToAllTest;
import com.thetestingacademy.driver.DriverManager;
import com.thetestingacademy.listeners.RetryAnalyzer;
import com.thetestingacademy.pages.menteeLoginpage;
import com.thetestingacademy.utils.PropertiesReader;
import io.qameta.allure.Attachment;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class menteeLogin_Improved extends CommonToAllTest {

    public static final Logger logger = LogManager.getLogger(menteeLogin_Improved.class);

    @Owner("Sachin Gaba")
    @Description("Verify that with invalid email, pass, error message is shown on the website")
    @Attachment(value = "Profile screenshot", type = "image/png")
    @Test(retryAnalyzer = RetryAnalyzer.class)
    public void verifyCredentials_Error() {

        // Page Object Model
        logger.info("login to Intercell Website");
        logger.info("Hello");

        Assert.fail();

        menteeLoginpage l1 = new menteeLoginpage(DriverManager.getDriver());
        String error_msg = l1.loginToIC_Invalid(PropertiesReader.readKey("user"),
                PropertiesReader.readKey("invalid_pass"));

        // Assertions
        logger.info("Asserting Conditions");
        assertThat(error_msg).isNotNull().isNotEmpty().isNotBlank();
        Assert.assertEquals(error_msg, PropertiesReader.readKey("login_error_msg"));

    }

    @Owner("Sachin Gaba")
    @Test(retryAnalyzer = RetryAnalyzer.class)
    public void verifyCredentials_Valid() {

        logger.info("Starting verifyCredentials_Valid");

        Assert.fail();

        // Page Object Model
        menteeLoginpage l2 = new menteeLoginpage(DriverManager.getDriver());
        l2.loginToIC_Valid(PropertiesReader.readKey("user"), PropertiesReader.readKey("pass"));

        // Assertions

        Assert.assertEquals(DriverManager.driver.getCurrentUrl(), PropertiesReader.readKey("login_dashboard_url"));

    }
}
