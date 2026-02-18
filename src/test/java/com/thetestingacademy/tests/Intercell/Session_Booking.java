package com.thetestingacademy.tests.Intercell;

import com.thetestingacademy.base.CommonToALL;
import com.thetestingacademy.baseTest.CommonToAllTest;
import com.thetestingacademy.baseTest.WaitHelpers;
import com.thetestingacademy.driver.DriverManager;
import com.thetestingacademy.driver.DriverManagerTL;
import com.thetestingacademy.pages.SessionBookingPage;
import com.thetestingacademy.pages.menteeLoginpage;
import com.thetestingacademy.utils.PropertiesReader;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.qameta.allure.Owner;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import static com.thetestingacademy.driver.DriverManager.driver;

public class Session_Booking extends CommonToAllTest {

        @Owner("Sachin Gaba")
        @Test
        public void createSession() throws IOException {
                WebDriver driver = DriverManagerTL.getDriver();
                //LOGIN
                // LOGIN
                menteeLoginpage l1 = new menteeLoginpage(driver);
                l1.loginToIC_Valid(PropertiesReader.readKey("user"), PropertiesReader.readKey("pass"));
                Assert.assertEquals(driver.getCurrentUrl(), PropertiesReader.readKey("login_dashboard_url"));

                // Session Booking
                SessionBookingPage s1 = new SessionBookingPage(driver);

                // Screenshot
                File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
                String path = System.getProperty("user.dir") + "/FailureScreenshot/BookingScreenshots/booking.png";
                FileUtils.copyFile(src, new File(path));

                // Booking Done
                s1.sessionBooking();


                // Upcoming Session view
                WebElement upcomingSession = driver.findElement(By.xpath("//span[contains(text(),\"Sessions\")]"));
                upcomingSession.click();
                WaitHelpers.checkVisibility(driver, By.xpath("//a[@data-target=\"#list_view\"]"));
                WebElement upcomingViewList = driver.findElement(By.xpath("//a[@data-target=\"#list_view\"]"));
                upcomingViewList.click();

                WebElement viewSession = driver.findElement(By.xpath(
                        "//div[contains(@class,'float-right')]//button[contains(text(),'View More')][1]"));
                WaitHelpers.checkVisibility(driver, By.xpath(
                        "//div[contains(@class,'float-right')]//button[contains(text(),'View More')][1]"));
                viewSession.click();

                WebElement cancelSession = driver.findElement(By.xpath("//button[@data-target=\"#menteecancel\"]"));
                driver.manage().window().maximize();
                cancelSession.click();

                WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

                // 1. Find dropdown
                WebElement dropdown = wait.until(ExpectedConditions.presenceOfElementLocated(
                        By.xpath("//*[@id=\"menteecancel\"]/div/div/div/form/div[1]/div/select")));
                dropdown.click();
                Select select = new Select(dropdown);
                select.selectByVisibleText("Unavailable to take the session");

                WebElement cancel_confirm = driver.findElement(
                        By.xpath("//button[@id='cancel_confirm' and contains(@class,'btn-squared')]"));
                cancel_confirm.click();

                // OK POP-UP
                wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='OK']")));
                WebElement ok_btn = driver.findElement(By.xpath("//button[text()=\"OK\"]"));
                ok_btn.click();

                // Notification
                WaitHelpers.checkVisibility(driver,
                        By.xpath("//span[@class=\"intercell_tab_text_remove\" and text()=\"Notifications\"]"));
                WebElement noti_tab2 = driver.findElement(
                        By.xpath("//span[@class=\"intercell_tab_text_remove\" and text()=\"Notifications\"]"));
                wait.until(ExpectedConditions.elementToBeClickable(noti_tab2));
                noti_tab2.click();

                // Reading notification
                WebElement noti_read_cancel = driver.findElement(By.xpath("//span[text()=\"Session cancellation success\"]"));
                noti_read_cancel.click();
                Assert.assertEquals(noti_read_cancel.getText(), "Session cancellation success");
        }
        }
