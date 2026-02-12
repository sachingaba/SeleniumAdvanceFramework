package com.thetestingacademy.tests.Intercell;

import com.thetestingacademy.base.CommonToALL;
import com.thetestingacademy.baseTest.CommonToAllTest;
import com.thetestingacademy.driver.DriverManager;
import com.thetestingacademy.pages.menteeLoginpage;
import com.thetestingacademy.pages.profilePage;
import com.thetestingacademy.utils.PropertiesReader;
import io.qameta.allure.Owner;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MenteeProfile_Improved extends CommonToAllTest {

    @Owner("Sachin Gaba")
    @Test
    public void menteeProfileUpdate() {

        menteeLoginpage login = new menteeLoginpage(DriverManager.getDriver());
        login.loginToIC_Valid(PropertiesReader.readKey("user"), PropertiesReader.readKey("pass"));

        Assert.assertEquals(DriverManager.driver.getCurrentUrl(), PropertiesReader.readKey("login_dashboard_url"));

        profilePage p1 = new profilePage(DriverManager.driver);
        p1.updateProfile();

    }
}
