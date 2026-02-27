package com.thetestingacademy.listeners;

import com.thetestingacademy.driver.DriverManagerTL;
import io.qameta.allure.Allure;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class ScreeshotListener implements ITestListener {

    @Override
    public void onTestFailure(ITestResult result) {
        WebDriver driver = DriverManagerTL.getDriver();
        String methodName = result.getName();

        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss");

        if (driver != null) {
            File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

            String screenshotPath = "FailureScreenshot/TTA/" + methodName + "_" +
                    simpleDateFormat.format(calendar.getTime()) + ".png";

            try {
                FileUtils.copyFile(scrFile, new File(screenshotPath));

                // Add Screenshot link to TESTNG report
                org.testng.Reporter.log("<a href='" + screenshotPath + "'> Screenshot</a>");

                // Attach screenshot to Allure report using FileInputStream
                Allure.addAttachment("Screenshot", "image/png",
                        new FileInputStream(new File(screenshotPath)), "png");
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("[ScreeshotListener] Driver is NULL - cannot take screenshot for: " + methodName);
        }
    }
}
