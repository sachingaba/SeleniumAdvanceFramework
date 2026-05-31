package com.thetestingacademy.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

public class SauceDemo {


    @Test
    public void getAllLinks(){
        ChromeOptions options = new ChromeOptions();

        Map<String, Object> prefs = new HashMap<>();
        prefs.put("credentials_enable_service", false);
        prefs.put("profile.password_manager_enabled", false);
        prefs.put("safebrowsing.enabled", true);          // keep safe browsing
        prefs.put("safebrowsing.password_protection_enabled", 0);
        prefs.put("profile.encrypted_passwords", false);  // depending on the Chrome version may be ignored

        options.setExperimentalOption("prefs", prefs);


        WebDriver driver = new ChromeDriver(options);
        driver.get("https://www.saucedemo.com/");

        driver.manage().window().maximize();

        WebElement userName = driver.findElement(By.xpath("//input[@data-test=\"username\"]"));
        WebElement password = driver.findElement(By.xpath("//input[@data-test=\"password\"]"));

        userName.sendKeys("visual_user");
        password.sendKeys("secret_sauce");

        WebElement log_btn = driver.findElement(By.xpath("//input[@data-test=\"login-button\"]"));
        log_btn.click();

//driver.switchTo().alert().accept();


    }
}
