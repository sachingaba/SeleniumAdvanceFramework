package com.thetestingacademy.tests.Intercell;

import com.thetestingacademy.CommonToALL;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MenteeProfile extends CommonToALL {

    @Test
    public void menteeProfileUpdate(){

        WebDriver driver = new ChromeDriver();

        openBrowser(driver,"https://test.intercellworld.com");

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

        WebElement myProfile = driver.findElement(By.xpath("//li[@id=\"menuProfile\"]"));
        myProfile.click();


        WebElement viewProfile = driver.findElement(By.id("view_profile"));
        viewProfile.click();
        System.out.println(driver.getCurrentUrl());
        System.out.println(driver.getTitle());
        Assert.assertEquals(driver.getCurrentUrl(),"https://test.intercellworld.com/account/meedit-profile");


        WebElement firstName = driver.findElement(By.name("firstName"));
        firstName.clear();
        firstName.sendKeys("SachinTest");

        WebElement lastName = driver.findElement(By.name("lastName"));
        lastName.clear();
        lastName.sendKeys("GabaTest");


        WebElement chooseGender = driver.findElement(By.xpath("//select[@name=\"gender\"]"));
        Select selectGender = new Select(chooseGender);
        selectGender.selectByVisibleText("Female");

        WebElement chooseCountry = driver.findElement(By.xpath("//select[@name=\"country\"]"));
        Select selectCountry = new Select(chooseCountry);
        selectCountry.selectByVisibleText("India");

        WebElement chooseState = driver.findElement(By.xpath("//select[@name=\"stateId\"]"));
        Select selectState = new Select(chooseState);
        selectState.selectByVisibleText("Haryana");

        WebElement chooseCity = driver.findElement(By.xpath("//select[@name=\"cityId\"]"));
        Select selectCity = new Select(chooseCity);
        selectCity.selectByVisibleText("Sirsa");

        WebElement dob = driver.findElement(By.xpath("//button[@class=\"mat-icon-button\"]"));
        dob.click();

WebElement openYear = driver.findElement(By.xpath("//button[@aria-label=\"Choose month and year\"]"));
openYear.click();

WebElement chooseYear = driver.findElement(By.xpath("//div[@class=\"mat-calendar-body-cell-content\" and text()=\"2005\"]"));
chooseYear.click();

        WebElement chooseMonth = driver.findElement(By.xpath("//div[@class=\"mat-calendar-body-cell-content\" and text()=\"FEB\"]"));
chooseMonth.click();

WebElement chooseDate = driver.findElement(By.xpath("//div[@class=\"mat-calendar-body-cell-content\" and text()=\"7\"]"));
        chooseDate.click();
//
//        WebElement chooseExperience = driver.findElement(By.xpath("//select[@name=\"experience\"]"));
//        Select selectExperience = new Select(chooseExperience);
//        System.out.println(selectExperience.getOptions());
//        selectState.selectByIndex(25);





        WebElement submitProfile = driver.findElement(By.xpath("//button[@id=\"edit\"]"));
        submitProfile.click();


        closeBrowser(driver);





    }
}
