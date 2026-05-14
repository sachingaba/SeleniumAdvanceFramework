package com.thetestingacademy.tests;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class chromeSettings {


    @Test
    public void getValueInSearch() throws InterruptedException {

        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.get("chrome://settings/");

        JavascriptExecutor js = (JavascriptExecutor) driver;



        WebElement searchBox = (WebElement) js.executeScript("return document.querySelector('settings-ui').shadowRoot.querySelector('cr-toolbar').shadowRoot.querySelector('div#centeredContent').querySelector('cr-toolbar-search-field#search').shadowRoot.querySelector('div#content').querySelector('div#searchTerm').querySelector('input#searchInput')");
        Assert.assertNotNull(searchBox);
        searchBox.sendKeys("selenium");
        Thread.sleep(10000);

        System.out.println("Attribute value: "+searchBox.getAttribute("value"));

        Assert.assertEquals(searchBox.getAttribute("value"),"selenium");


        driver.quit();
//.querySelector('settings-ui').shadowRoot.querySelector('cr-toolbar').shadowRoot.querySelector('div#centeredContent').querySelector('cr-toolbar-search-field#search').shadowRoot.querySelector('div#content').querySelector('div#searchTerm').querySelector('input#searchInput')
    }
}
