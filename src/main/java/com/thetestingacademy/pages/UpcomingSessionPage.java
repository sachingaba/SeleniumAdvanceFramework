package com.thetestingacademy.pages;

import com.thetestingacademy.base.CommonToALL;
import com.thetestingacademy.driver.DriverManager;
import com.thetestingacademy.driver.DriverManagerTL;
import com.thetestingacademy.utils.PropertiesReader;
import com.thetestingacademy.utils.WaitHelpers;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

import static com.thetestingacademy.driver.DriverManager.driver;
import static org.openqa.selenium.support.locators.RelativeLocator.with;

public class UpcomingSessionPage extends CommonToALL {
    public UpcomingSessionPage(WebDriver driver) {
        this.driver = driver;
    }


    WebDriver driver;

    public WebDriver getDriver() {
        return driver;
    }

    public void setDriver(WebDriver driver) {
        this.driver = driver;
    }

    public By upcomingSession = By.xpath("//a[@href=\"/account/upcoming\" and span]");
    private By upcomingViewList = By.xpath("//a[@data-target=\"#list_view\"]");
    private By viewSession = By.xpath("//div[contains(@class,'float-right')]/button[contains(text(),'View More')]");
    private By viewMore = By.xpath("//div[@class='div-box']//span[contains(text(),'" + PropertiesReader.readKey("Mentor") + "')]");

    //span[@class=\"meta\"]/following-sibling::span
    //div[@class='div-box']//span[contains(text(),"Greenland")]

    public void viewUpcomingSession() {
        WebDriver driver = DriverManagerTL.getDriver();
        WaitHelpers.checkVisibility(driver, upcomingSession);
        driver.findElement(upcomingSession).click();

        driver.findElement(upcomingViewList).click();

        // driver.findElement(with(By.xpath("//button[contains(text(),'More')]")).near(viewMore)).click();
        List<WebElement> lists = driver.findElements(By.xpath("//div[@class='div-box']//span"));
        System.out.println("came here");
        System.out.println(viewMore);
        for (WebElement list : lists) {
            System.out.println(list.getText());
            WaitHelpers.implicitWait(driver,2);
            if (list.getText().equals(PropertiesReader.readKey("Mentor"))) {
                WebElement button = driver.findElement(By.xpath("//div[@id=\"profile\"]/ul/li/div/div/button"));
                System.out.println("Reached here");
WaitHelpers.implicitWait(driver,2);
                button.click();
                break;
            }

        }

        /*
         * WaitHelpers.checkVisibility(driver,viewSession);
         * if(driver.findElement(viewSession).isDisplayed()) {
         * driver.findElement(viewSession).click();
         * }
         */

    }
}


