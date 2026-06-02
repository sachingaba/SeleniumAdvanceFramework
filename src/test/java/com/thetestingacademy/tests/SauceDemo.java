package com.thetestingacademy.tests;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SauceDemo {


    @Test
    public void getAllLinks(){
        ChromeOptions options = new ChromeOptions();

//        Map<String, Object> prefs = new HashMap<>();
//        prefs.put("credentials_enable_service", false);
//        prefs.put("profile.password_manager_enabled", false);
//        prefs.put("safebrowsing.enabled", true);          // keep safe browsing
//        prefs.put("safebrowsing.password_protection_enabled", 0);
//        prefs.put("profile.encrypted_passwords", false);  // depending on the Chrome version may be ignored
//
//        options.setExperimentalOption("prefs", prefs);
        options.addArguments("--disable-features=PasswordManagerUI");

        WebDriver driver = new ChromeDriver(options);
        driver.get("https://www.saucedemo.com/");

        driver.manage().window().maximize();

        WebElement userName = driver.findElement(By.xpath("//input[@data-test=\"username\"]"));
        WebElement password = driver.findElement(By.xpath("//input[@data-test=\"password\"]"));

        userName.sendKeys("visual_user");
        password.sendKeys("secret_sauce");

        WebElement log_btn = driver.findElement(By.xpath("//input[@data-test=\"login-button\"]"));
        log_btn.click();

driver.navigate().to("https://www.saucedemo.com/inventory-item.html?id=4");
driver.navigate().to("https://www.saucedemo.com/inventory.html");
        Actions actions = new Actions(driver);

        actions.sendKeys(Keys.ENTER).build().perform();

       List<WebElement> products = driver.findElements(By.xpath("//div[@data-test=\"inventory-item-price\"]"));

       for(WebElement product: products){
           product.getText();
       }





    }
}
