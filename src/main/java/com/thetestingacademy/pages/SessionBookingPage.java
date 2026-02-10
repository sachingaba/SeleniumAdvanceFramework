package com.thetestingacademy.pages;

import com.thetestingacademy.utils.PropertiesReader;
import com.thetestingacademy.utils.WaitHelpers;
import io.qameta.allure.internal.shadowed.jackson.databind.annotation.JsonAppend;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import static org.openqa.selenium.support.locators.RelativeLocator.*;
import java.util.List;

public class SessionBookingPage {
    public WebDriver getDriver() {
        return driver;
    }

    public void setDriver(WebDriver driver) {
        this.driver = driver;
    }

    public SessionBookingPage(WebDriver driver) {
        this.driver = driver;
    }

    WebDriver driver;

    private By book_level1 = By.xpath("//a[@href=\"/account/book-session\"]");
    private By book_level2 = By.xpath("//h4[text()=\"Advertising\"]/following::button[18]");
    private By dropSpec = By.xpath("//span[text()=\"Choose Specialization in Sales\"]");
    private By  selectSpec = By.xpath("//div[text()=\"Select All\"]");
    private By saveSelect = By.xpath("//button[@class=\"btn btn-primary\"]");
    String mentorPath = "//h4[@class='card-title' and contains(text(),'" + PropertiesReader.readKey("Mentor") + "')]";

    private By firstSpeakBtn = By.xpath(mentorPath);
    //following::a[text()='Speak to this Mentor']"
    private By firstTimeSlot = By.xpath("//span[@class=\"ng-star-inserted\" ]/following::a[@style=\"color: #fff\"][1]");
    private By slot_Accept = By.xpath("//button[text()=\"Yes\"]");
    private By input1 = By.xpath("//textarea[@id=\"mentee_check_2\"]");
    private By input2 = By.xpath("//textarea[@id=\"mentee_check_3\"]");
    private By input3 = By.xpath("//textarea[@id=\"mentee_check_4\"]");
    private By input4 = By.xpath("//textarea[@id=\"mentee_check_5\"]");
    private By input5 = By.xpath("//textarea[@id=\"mentee_check_6\"]");
    private By checkBox_listed = By.xpath("//input[@id=\"listed_question\"]");
    //Save and Continue
    private By save = By.xpath("//button[text()=\" Save and continue \"]");
    private By confirmClick = By.id("booking_confirm");
    private By confirmYes = By.xpath("//button[@id=\"booking_confirm_final\"]");
    private By successMsg = By.xpath("//h2[text()=\"Your request has been sent to the Mentor\"]");
    private By popUpClose = By.xpath("//button[text()=\"OK\"]");

    public void sessionBooking(){
       driver.findElement(book_level1).click();
       //Sales
        WaitHelpers.checkVisibility(driver,book_level2);
        driver.findElement(book_level2).click();
        WaitHelpers.checkVisibility(driver,dropSpec);
        driver.findElement(dropSpec).click();
        driver.findElement(selectSpec).click();
        driver.findElement(saveSelect).click();
    //    driver.findElement(firstSpeakBtn).click();
        WaitHelpers.waitJVM(2000);
        System.out.println(mentorPath);

driver.findElement(with(By.tagName("a")).below(firstSpeakBtn)).click();



        WaitHelpers.checkVisibility(driver,firstTimeSlot);
        driver.findElement(firstTimeSlot).click();
        //Accept the Slot
        driver.findElement(slot_Accept).click();
        //Add details
        driver.findElement(input1).sendKeys(PropertiesReader.readKey("randomText1"));
        driver.findElement(input2).sendKeys(PropertiesReader.readKey("randomText2"));
        driver.findElement(input3).sendKeys(PropertiesReader.readKey("randomText3"));
        driver.findElement(input4).sendKeys(PropertiesReader.readKey("randomText4"));
        driver.findElement(input5).sendKeys(PropertiesReader.readKey("randomText5"));
        driver.findElement(checkBox_listed).click();
        //Save and Continue
        driver.findElement(save).click();
        WebElement confirmClick = driver.findElement(By.id("booking_confirm"));
        confirmClick.click();
        WaitHelpers.checkVisibility(driver,confirmYes);
        driver.findElement(confirmYes).click();
        WaitHelpers.waitJVM(5000);
        driver.findElement(successMsg);
        driver.findElement(popUpClose).click();

    }








}
