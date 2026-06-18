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
        // Handling the login popup if it appears
        try {
            wait.until(ExpectedConditions
                    .visibilityOfElementLocated(By.xpath("//span[text()='✕' or @class='_30XB9F' or @class='b3wTlE']")));
            WebElement cross = driver
                    .findElement(By.xpath("//span[text()='✕' or @class='_30XB9F' or @class='b3wTlE']"));
            cross.click();
        } catch (Exception e) {
            System.out.println("Login popup did not appear or was already closed.");
        }

        WebElement searchBox = driver.findElement(By.name("q"));
        Actions actions = new Actions(driver);
        actions.moveToElement(searchBox).click().sendKeys("Nokia phones").sendKeys(Keys.ENTER).build().perform();

        String filePath = "C:\\Users\\devin\\IdeaProjects\\SeleniumAdvanceFramework\\src\\test\\java\\com\\thetestingacademy\\tests\\FlipkartSearch.txt";

        try (FileWriter writer = new FileWriter(filePath)) {
            boolean hasNext = true;
            while (hasNext) {
                // Wait for search results to load
                //wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("div[@class=\"RG5Slk\"]")));

                // Find all product title elements on the current page
                List<WebElement> productElements = driver.findElements(By.className("RG5Slk"));


                System.out.println("Found " + productElements.size() + " products on this page.");

                for (WebElement product : productElements) {
                    try {
                        String text = product.getText();

                        System.out.println(text);
                        writer.write(text + System.lineSeparator());

                    } catch (Exception e) {
                        System.err.println("Error reading product text: " + e.getMessage());
                    }
                }

                // Check for 'Next' button and click it
                try {
                   WebElement nextButtons = driver
                            .findElement(By.xpath("//a[span[text()='Next']] | //a[contains(@class, 'jgg0SZ')]"));
                    if (nextButtons.isDisplayed()) {

                        actions.moveToElement(nextButtons).click().build().perform();
                        // Wait for page transition

                        wait.until(ExpectedConditions.visibilityOf(nextButtons));
                    } else {
                        hasNext = false;
                        System.out.println("No more pages found.");
                    }
                } catch (Exception e) {
                    System.out.println("Pagination ended or error occurred: " + e.getMessage());
                    hasNext = false;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            driver.quit();
        }

            }
        }
