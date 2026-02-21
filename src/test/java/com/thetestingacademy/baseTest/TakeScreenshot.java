package com.thetestingacademy.baseTest;

import com.thetestingacademy.driver.DriverManagerTL;
import com.thetestingacademy.utils.PropertiesReader;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;
import java.sql.Time;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class TakeScreenshot {

    public static void TakeScreenshot_IC(String Folder,String methodname) throws IOException {
        LocalDateTime now = LocalDateTime.now();
        System.out.println("Local time: " + now);  // 2026-02-19T19:14:30.123

// Format it
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy_HH_mm");

        String formattedTime = now.format(formatter);
        System.out.println("Formatted: " + formattedTime);  // 19-02-2026 19:14:30
        File src = ((TakesScreenshot) DriverManagerTL.getDriver()).getScreenshotAs(OutputType.FILE);
        String path = System.getProperty("user.dir") + "/FailureScreenshot/"+ Folder +"/" + methodname+"_"+formattedTime+".png";
        FileUtils.copyFile(src, new File(path));

    }
}
