package com.thetestingacademy.baseTest;

import com.thetestingacademy.driver.DriverManager;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;

public class CommonToAllTest {

    @BeforeMethod
    public void Start(){
        DriverManager.init();

    }


    @AfterMethod
    public void End(){
DriverManager.down();

    }
}
