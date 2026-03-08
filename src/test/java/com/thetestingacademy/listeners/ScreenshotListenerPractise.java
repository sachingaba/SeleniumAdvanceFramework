package com.thetestingacademy.listeners;

import com.thetestingacademy.driver.DriverManagerTL;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ScreenshotListenerPractise implements ITestListener {
    @Override
    public void onTestFailure(ITestResult result) {
        WebDriver driver = DriverManagerTL.getDriver();
        String methodName = result.getName();

        if (driver != null) {
            String time = LocalDateTime.now().format(DateTimeFormatter.ofPattern("ddMMyyyy__HHmm"));
            String path = System.getProperty("user.dir") + "/screenshots/practise/failed_" + methodName + "_" + time
                    + ".png";

            File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

            try {
                FileUtils.copyFile(screenshot, new File(path));
                System.out.println("[ScreenshotListenerPractise] Saved failure screenshot to: " + path);
            } catch (IOException e) {
                System.err.println("[ScreenshotListenerPractise] Failed to save screenshot: " + e.getMessage());
            }
        } else {
            System.err.println(
                    "[ScreenshotListenerPractise] WebDriver is null, cannot take screenshot for: " + methodName);
        }
    }
}
