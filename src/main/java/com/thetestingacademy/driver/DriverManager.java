package com.thetestingacademy.driver;

import com.thetestingacademy.utils.PropertiesReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class DriverManager {

    public static WebDriver getDriver() {
        return driver;
    }

    public static void setDriver(WebDriver driver) {
        DriverManager.driver = driver;
    }

    public static WebDriver driver;

    public static void init() {

        String browser = PropertiesReader.readKey("browser");
        browser = browser.toLowerCase();

        switch (browser) {
            case "chrome":
                System.out.println("You Chose --> Chrome");
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.addArguments("--start--maximize");
                chromeOptions.addArguments("--guest");
                chromeOptions.addArguments("--headerless=new");
                driver = new ChromeDriver(chromeOptions);

                break;
            case "edge":
                System.out.println("You Chose --> Edge");
                EdgeOptions edgeOptions = new EdgeOptions();
                edgeOptions.addArguments("--start--maximize");
                edgeOptions.addArguments("--guest");
                driver = new EdgeDriver(edgeOptions);
                break;
            case "firefox":
                System.out.println("You Chose --> Firefox");
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                firefoxOptions.addArguments("--start--maximize");
                firefoxOptions.addArguments("--guest");
                driver = new FirefoxDriver(firefoxOptions);
                break;
            default:
                System.out.println("NO Browser Selected !!!!");

        }
    }

    public static void down() {
        if (getDriver() != null) {
            driver.quit();
            driver = null;
        }

    }
}
