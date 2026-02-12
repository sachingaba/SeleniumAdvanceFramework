package com.thetestingacademy.pages;

import com.thetestingacademy.utils.WaitHelpers;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

import static com.thetestingacademy.driver.DriverManager.driver;
import static org.openqa.selenium.support.locators.RelativeLocator.with;

public class UpcomingSessionPage {
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
    private By viewMore = By.xpath("//span[@class=\"meta\"]/following-sibling::span");

    public void viewUpcomingSession() {
        WaitHelpers.checkVisibility(driver, upcomingSession);
        driver.findElement(upcomingSession).click();

        driver.findElement(upcomingViewList).click();
        List<WebElement> lists = driver.findElements(viewMore);
        System.out.println("came here");
        for (WebElement list : lists) {
            System.out.println(list.getText());
            if (list.getText().equals("Ankit Gupta")) {
                System.out.println("Reached here");
                WaitHelpers.waitJVM(4000);
                driver.findElement(with(By.tagName("button")).toRightOf(list)).click();
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
