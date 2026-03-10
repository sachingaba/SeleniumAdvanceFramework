package com.thetestingacademy.tests;

import com.thetestingacademy.utils.WaitHelpers;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Objects;

public class FlipkartSearch {

    @Severity(SeverityLevel.CRITICAL)
    @Test
    public void testNextButton() throws IOException {

        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.navigate().to("https://www.flipkart.com/");

        // form[@class='lilxh_ header-form-search isa71P']//input[@placeholder='Search
        // for Products, Brands and More']
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(7));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class=\"b3wTlE\"]")));

        WebElement cross = driver.findElement(By.xpath("//span[@class=\"b3wTlE\"]"));
        cross.click();
        WebElement searchBox = driver.findElement(By.name("q"));

        Actions actions = new Actions(driver);
        actions.moveToElement(searchBox).click().sendKeys("Nokia phones").sendKeys(Keys.ENTER).build().perform();

        WebElement next = driver.findElement(By.xpath("//a[@class=\"jgg0SZ\" and span=\"Next\"]"));

        while (next.isDisplayed()) {
            List<WebElement> lists = driver.findElements(By.xpath("//div[@class=\"k7wcnx\"]"));

            for (WebElement list : lists) {
                wait.until(ExpectedConditions.visibilityOf(list));
                System.out.println(list.getText());
                String file = "C:\\Users\\devin\\IdeaProjects\\SeleniumAdvanceFramework\\src\\test\\java\\com\\thetestingacademy\\tests\\FlipkartSearch1.txt";

                FileWriter writer = new FileWriter(file);
                writer.write(list.getText());
                writer.close();


            }
            wait.until(ExpectedConditions.visibilityOf(next)).isDisplayed();
            actions.moveToElement(next).click().build().perform();

        }

    }
}
