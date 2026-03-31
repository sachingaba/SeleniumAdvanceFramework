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

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.time.Duration;
import java.util.List;
import java.util.Objects;
import java.util.Set;

public class AmazonLinks {

    @Severity(SeverityLevel.CRITICAL)
    @Test
public void testAmazonLinks(){
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.amazon.in/");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id=\"twotabsearchtextbox\"]")));
        WebElement searchBox = driver.findElement(By.xpath("//input[@id=\"twotabsearchtextbox\"]"));
        searchBox.sendKeys("Nothing mobile Phone");

        WebElement searchbtn = driver.findElement(By.id("nav-search-submit-button"));
        searchbtn.click();

       List<WebElement> phones = driver.findElements(By.xpath("//div[@data-cy=\"title-recipe\"]/a"));
Actions actions = new Actions(driver);
        String parent = driver.getWindowHandle();
  String path = System.getProperty("user.dir")+ "/src/test/java/com/thetestingacademy/tests/AmazonSearch.txt";
        try {
            Writer writer = new FileWriter(path);


        for(WebElement phone:phones){
           System.out.println(phone.getAttribute("href"));
           writer.write(phone.getAttribute("href"));
           writer.write("\n");
           if(phone.getText().equals("CMF Phone 2 Pro 5G (White, 8GB RAM, 128GB Storage)")){
               System.out.println("Entered Here");
               actions.moveToElement(phone).keyDown(Keys.SHIFT).click().build().perform();
               WaitHelpers.waitJVM(5000);
           }
       }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Set<String> tabs = driver.getWindowHandles();

        driver.switchTo().window(parent);



driver.quit();
}
}
