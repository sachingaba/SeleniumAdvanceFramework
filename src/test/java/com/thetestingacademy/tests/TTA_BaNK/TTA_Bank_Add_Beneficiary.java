package com.thetestingacademy.tests.TTA_BaNK;

import com.thetestingacademy.CommonToALL;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TTA_Bank_Add_Beneficiary extends CommonToALL {

    @Owner("Sachin Gaba")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Verify the beneficiary is added successfully")
    @Test
public void test_add_beneficiary(){

        WebDriver driver = new ChromeDriver();
        openBrowser(driver,"https://tta-bank-digital-973242068062.us-west1.run.app/");

customWait(2000);

//Login User
//        WebElement login_input = driver.findElement(By.xpath("//input[@type=\"email\"]"));
//        login_input.clear();
//        login_input.sendKeys("sk@gmail.com");
//
//        WebElement pass_input = driver.findElement(By.xpath("//input[@type=\"password\"]"));
//        pass_input.sendKeys("sk");
//
//        WebElement login_btn = driver.findElement(By.xpath("//button[@type=\"submit\"]"));
//        login_btn.click();

//Sign-UP
        WebElement sign_Up_button = driver.findElement(By.xpath("//button[text() =\"Sign Up\"]"));
        sign_Up_button.click();



        WebElement sign_name = driver.findElement(By.xpath("//input[@placeholder=\"John Doe\"]"));
        sign_name.clear();
        sign_name.sendKeys("Sachin");

        WebElement sign_email = driver.findElement(By.xpath("//input[@type=\"email\"]"));
        sign_email.clear();
        sign_email.sendKeys("sk@gmail.com");

        WebElement sign_pass = driver.findElement(By.xpath("//input[@type=\"password\"]"));
        sign_pass.sendKeys("sk@123");

        WebElement SignIn_btn = driver.findElement(By.xpath("//button[@type=\"submit\"]"));
        SignIn_btn.click();




customWait(3000);


        WebElement verify_dash = driver.findElement(By.xpath("//h1[contains(text(),\"Dashboard\")]"));
        Assert.assertTrue(verify_dash.isDisplayed());

            WebElement transfer_btn = driver.findElement(By.xpath("//button[contains(text(),\"Transfer Funds\")]"));
            transfer_btn.click();


        WebElement add_ben = driver.findElement(By.xpath("//button[text()=\"Manage Beneficiaries\"]"));
        add_ben.click();

        WebElement name_ben=  driver.findElement(By.xpath("//input[@placeholder=\"e.g. John Doe\"]"));
        name_ben.sendKeys("Gurleen kaur");

        WebElement bankName_ben =  driver.findElement(By.xpath("//input[@placeholder=\"e.g. Citibank\"]"));
        bankName_ben.sendKeys("Axis bank");

        WebElement actNo_ben = driver.findElement(By.xpath("//input[@maxlength=\"12\"]"));
        actNo_ben.sendKeys("4546546548");

        WebElement save_ben = driver.findElement(By.xpath("//button[text()=\"Save Beneficiary\"]"));
        save_ben.click();

        customWait(2000);

            //WebElement add_ben = driver.findElement(By.xpath("//button[text()=\"Manage Beneficiaries\"]"));
            add_ben.click();

        WebElement verify_ben = driver.findElement(By.xpath("//p[contains(text(),\"Gurleen kaur\")]"));
        System.out.println(verify_ben.getText());
        Assert.assertEquals(verify_ben.getText(),"Gurleen kaur");


closeBrowser(driver);



}
}
