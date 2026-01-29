package com.thetestingacademy.tests.Intercell;

import com.thetestingacademy.CommonToALL;
import com.thetestingacademy.ex_07_Wait_Helper.WaitHelpers;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;


public class Session_Booking extends CommonToALL {

    @Test
    public void createSession(){
        WebDriver driver = new ChromeDriver();
        openBrowser(driver,"https://test.intercellworld.com/");

        //Email
        WebElement email_Input_Box = driver.findElement(By.xpath("//*[@id=\"myAnchor\"]/div/div[1]/div/div[2]/form/div/div[1]/input"));
        email_Input_Box.sendKeys("iamsachingaba@gmail.com");
        // Password
        WebElement password_Input_Box = driver.findElement(By.xpath("//*[@id=\"show_hide_password\"]/input"));
        password_Input_Box.sendKeys("intercell@123");
        //Click Sign-In
        WebElement clickSignIn = driver.findElement(By.id("confim_login"));
        clickSignIn.click();
customWait(3000);
        //Speak to a Mentor
        WebElement book_level1 = driver.findElement(By.xpath("//a[@href=\"/account/book-session\"]"));
        book_level1.click();

        customWait(3000);

        //Sales
        WebElement book_level2 = driver.findElement(By.xpath("//h4[text()=\"Advertising\"]/following::button[18]"));
        book_level2.click();

        customWait(3000);

        WebElement dropSpec = driver.findElement(By.xpath("//span[text()=\"Choose Specialization in Sales\"]"));
        dropSpec.click();

       //WebElement selectSpec = driver.findElement(By.xpath("//*[@id=\"Grid\"]/div[1]/ng-multiselect-dropdown/div/div[2]/ul[1]/li[1]/div/text()"));
        WebElement selectSpec = driver.findElement(By.xpath("//div[text()=\"Select All\"]"));
        selectSpec.click();

        WebElement saveSelect = driver.findElement(By.xpath("//button[@class=\"btn btn-primary\"]"));
        saveSelect.click();


        // Xpath == //h4[@class='card-title' and contains(text(),'Karun Dube')]/../following-sibling::div//a[text()='Speak to this Mentor']
        // Xpath for first speak button -- //h4[@class='card-title']/following::a[text()='Speak to this Mentor'][1]

        WebElement firstSpeakBtn = driver.findElement(By.xpath("//h4[@class='card-title']/following::a[text()='Speak to this Mentor'][1]"));
        firstSpeakBtn.click();

        WebElement firstTimeSlot = driver.findElement(By.xpath("//span[@class=\"ng-star-inserted\" ]/following::a[@style=\"color: #fff\"][1]"));
        firstTimeSlot.click();

        //Accept the Slot
        WebElement slot_Accept = driver.findElement(By.xpath("//button[text()=\"Yes\"]"));
        slot_Accept.click();

        // form fill
        WebElement input1 = driver.findElement(By.xpath("//textarea[@id=\"mentee_check_2\"]"));
        input1.sendKeys("Enter some test here");

        WebElement input2 = driver.findElement(By.xpath("//textarea[@id=\"mentee_check_3\"]"));
        input2.sendKeys("Enter some test here");

        WebElement input3 = driver.findElement(By.xpath("//textarea[@id=\"mentee_check_4\"]"));
        input3.sendKeys("Enter some test here");

        WebElement input4 = driver.findElement(By.xpath("//textarea[@id=\"mentee_check_5\"]"));
        input4.sendKeys("Enter some test here");

        WebElement input5 = driver.findElement(By.xpath("//textarea[@id=\"mentee_check_6\"]"));
        input5.sendKeys("Enter some test here");

        //CheckBox

        WebElement checkBox_listed = driver.findElement(By.xpath("//input[@id=\"listed_question\"]"));
        checkBox_listed.click();

        //Save and Continue

        WebElement save = driver.findElement(By.xpath("//button[text()=\" Save and continue \"]"));
        save.click();

        /*//Report checkBox

        WebElement report_check = driver.findElement(By.xpath("//input[@id='career_question']\n"));

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.elementToBeClickable(report_check));

        report_check.click();

        //Mentoring ecertificate check

        WebElement ecert_check = driver.findElement(By.id("ecertificate_question"));
        ecert_check.click();*/

        //Confirm

        WebElement confirmClick = driver.findElement(By.id("booking_confirm"));
        confirmClick.click();

        WebElement confirmYes = driver.findElement(By.xpath("//button[@id=\"booking_confirm_final\"]"));
        confirmYes.click();

        WebElement successMsg = driver.findElement(By.xpath("//h2[text()=\"Your request has been sent to the Mentor\"]"));
        Assert.assertEquals(successMsg.getText(),"Your request has been sent to the Mentor");


        WebElement popUpClose = driver.findElement(By.xpath("//button[text()=\"OK\"]"));
        popUpClose.click();

        WebElement noti_tab = driver.findElement(By.xpath("//div[@id=\"notification_top\"]"));
                //a[@href=\"/account/notifications\"]
        WebDriverWait webDriverWait = new WebDriverWait(driver,Duration.ofSeconds(15));
        webDriverWait.until(ExpectedConditions.elementToBeClickable(noti_tab));
        noti_tab.click();

        WebElement noti_read_accept = driver.findElement(By.xpath("//span[contains(text(),\"Your session request has been submitted\")]"));
        boolean requestHasBeenSubmitted = noti_read_accept.getText().contains("request has been submitted");
            System.out.println(requestHasBeenSubmitted);
            noti_read_accept.click();
    //    Assert.assertEquals(noti_read_accept.getText(),"Your session request has been submitted to Ankit Jain");


        //Upcoming Session view


        WebElement upcomingSession = driver.findElement(By.xpath("//span[contains(text(),\"Sessions\")]"));
        upcomingSession.click();
        WaitHelpers.checkVisibility(driver,By.xpath("//a[@data-target=\"#list_view\"]"));
        WebElement upcomingViewList = driver.findElement(By.xpath("//a[@data-target=\"#list_view\"]"));
        upcomingViewList.click();


        WebElement viewSession = driver.findElement(By.xpath("//div[contains(@class,'float-right')]//button[contains(text(),'View More')][1]"));
        WaitHelpers.checkVisibility(driver,By.xpath("//div[contains(@class,'float-right')]//button[contains(text(),'View More')][1]"));
viewSession.click();

WebElement cancelSession = driver.findElement(By.xpath("//button[@data-target=\"#menteecancel\"]"));
cancelSession.click();


            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

            // 1. Find dropdown
            WebElement dropdown = wait.until(ExpectedConditions.presenceOfElementLocated(
                    By.xpath("//*[@id=\"menteecancel\"]/div/div/div/form/div[1]/div/select")));
            dropdown.click();
        Select select = new Select(dropdown);
        select.selectByVisibleText("Unavailable to take the session");





WebElement cancel_confirm = driver.findElement(By.xpath("//button[@id='cancel_confirm' and contains(@class,'btn-squared')]"));
cancel_confirm.click();

//OK POP-UP
        wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//button[text()='OK']")));
        WebElement ok_btn = driver.findElement(By.xpath("//button[text()=\"OK\"]"));
        ok_btn.click();


        // Notification

     //   WebElement noti_tab = driver.findElement(By.xpath("//a[@href=\"/account/notifications\"]"));
        WaitHelpers.checkVisibility(driver,By.xpath("//span[@class=\"intercell_tab_text_remove\" and text()=\"Notifications\"]"));
        WebElement noti_tab2 = driver.findElement(By.xpath("//span[@class=\"intercell_tab_text_remove\" and text()=\"Notifications\"]"));
       wait.until(ExpectedConditions.elementToBeClickable(noti_tab2));
        noti_tab2.click();

        //Reading notification
      WebElement noti_read_cancel = driver.findElement(By.xpath("//span[text()=\"Session cancellation success\"]"));
        noti_read_cancel.click();
        noti_read_cancel.getText();
        Assert.assertEquals(noti_read_cancel.getText(),"Session cancellation success");

        closeBrowser(driver);






    }
}
