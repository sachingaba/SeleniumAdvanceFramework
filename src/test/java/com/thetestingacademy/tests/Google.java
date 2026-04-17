package com.thetestingacademy.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Google {


    @Test
    public void getValueInSearch(){

        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.get("https://www.google.com/");

        WebElement searchBox = driver.findElement(By.className("gLFyf"));
        searchBox.sendKeys("selenium");

        System.out.println("Attribute value: "+searchBox.getAttribute("value"));

        Assert.assertEquals(searchBox.getAttribute("value"),"selenium");


        driver.quit();

    }
}
