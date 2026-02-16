package com.thetestingacademy.pages;

import com.thetestingacademy.base.CommonToALL;
import com.thetestingacademy.driver.DriverManager;
import com.thetestingacademy.utils.PropertiesReader;
import com.thetestingacademy.utils.WaitHelpers;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class menteeLoginpage extends CommonToALL {

    WebDriver driver;

    public menteeLoginpage(WebDriver driver) {
        this.driver = driver;
    }


    //Step1 - Page Locators
    private By username_path = By.xpath("//input[@placeholder=\"Please Enter Email ID\"]");
    private By password_path = By.xpath("//input[@placeholder=\"Please Enter Password\"]");
    private By error_msg = By.xpath("//div[text()=\"Sorry! Username and Password not matching\"]");
    private By signin_btn = By.id("confim_login");
    //Step2  - Page Actions


    public String loginToIC_Invalid(String username , String password){
        System.out.println("Driver: " + driver);

        openIntercell();
        enterInput(username_path,username);
       // driver.findElement(username_path).sendKeys(username);
        enterInput(password_path,password);
      //  driver.findElement(password_path).sendKeys(password);
        clickElement(signin_btn);
        // driver.findElement(signin_btn).click();

        WaitHelpers.checkVisibility(driver,error_msg);

//        String error_msg_text = driver.findElement(error_msg).getText();
//        return error_msg_text;


        return getText(error_msg);

    }
    public void loginToIC_Valid(String username , String password){
        System.out.println("Driver: " + driver);
        driver.get(PropertiesReader.readKey("url"));
        driver.findElement(username_path).sendKeys(username);
        driver.findElement(password_path).sendKeys(password);
        driver.findElement(signin_btn).click();

        WaitHelpers.waitJVM(3000);
    }
}
