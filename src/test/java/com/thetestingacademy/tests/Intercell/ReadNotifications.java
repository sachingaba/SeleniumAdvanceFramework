package com.thetestingacademy.tests.Intercell;

import com.thetestingacademy.baseTest.CommonToAllTest;
import com.thetestingacademy.driver.DriverManagerTL;
import com.thetestingacademy.pages.NotificationPage;
import com.thetestingacademy.pages.menteeLoginpage;
import com.thetestingacademy.utils.PropertiesReader;
import org.testng.annotations.Test;

public class ReadNotifications extends CommonToAllTest {

@Test
    public void verifyNotifications() {

        menteeLoginpage l1 = new menteeLoginpage(DriverManagerTL.getDriver());

        l1.loginToIC_Valid(PropertiesReader.readKey("user"), PropertiesReader.readKey("pass"));

    NotificationPage n1 = new NotificationPage(DriverManagerTL.getDriver());
    n1.viewNotifications();


    }
}
