package com.thetestingacademy.baseTest;

import com.thetestingacademy.driver.DriverManager;
import com.thetestingacademy.driver.DriverManagerTL;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;

public class CommonToAllTest {

    @BeforeMethod
    public void Start(){
        DriverManagerTL.init();

    }


    @AfterMethod
    public void End(){
DriverManagerTL.down();

    }


}
