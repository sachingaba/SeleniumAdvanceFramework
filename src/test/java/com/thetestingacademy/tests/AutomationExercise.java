package com.thetestingacademy.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import static org.openqa.selenium.support.locators.RelativeLocator.with;

public class AutomationExercise {

    @Test
    public void getPrice(){

        WebDriver driver = new ChromeDriver();
        driver.get("https://automationexercise.com/");
        driver.manage().window().maximize();
        Actions actions = new Actions(driver);
        actions.scrollByAmount(500,50000);


        WebElement name = driver.findElement(By.xpath("//div[@class=\"single-products\"]/div/p[contains(text( ),\"Blue Top\")]"));
        System.out.println(name.getText());

        WebElement price = driver.findElement(with(By.tagName("h2")).above(name)) ;

        System.out.println("Price is:");

        System.out.println(price.getText());

driver.quit();
    }
}
