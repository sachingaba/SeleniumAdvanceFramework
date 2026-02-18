package com.thetestingacademy.driver;

import com.thetestingacademy.utils.PropertiesReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class DriverManagerTL {

    public static final ThreadLocal<WebDriver> local = new ThreadLocal<>();

    public static WebDriver getDriver() {
        return local.get();
    }

    public static void setDriver(WebDriver driver) {
        local.set(driver);
    }

    public static void unload() {
        local.remove();
    }

    public static void init() {
        String browser = PropertiesReader.readKey("browser").toLowerCase();

        WebDriver driver = null;  // Declare OUTSIDE switch

        switch (browser) {
            case "chrome":
                System.out.println("You Chose --> Chrome");
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.addArguments("--start-maximized");  // Fixed typo
                chromeOptions.addArguments("--incognito");        // Fixed typo
                //  chromeOptions.addArguments("--headless=new");     // Fixed typo
                driver = new ChromeDriver(chromeOptions);
                System.out.println("Driver Assigned");
                break;

            case "edge":
                System.out.println("You Chose --> Edge");
                EdgeOptions edgeOptions = new EdgeOptions();
                edgeOptions.addArguments("--start-maximized");
                edgeOptions.addArguments("--inprivate");  // Edge uses "inprivate"
                driver = new EdgeDriver(edgeOptions);
                break;

            case "firefox":
                System.out.println("You Chose --> Firefox");
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                firefoxOptions.addArguments("--width=1920");
                firefoxOptions.addArguments("--height=1080");
                driver = new FirefoxDriver(firefoxOptions);
                break;

            default:
                throw new IllegalArgumentException("Invalid browser: " + browser);
        }

        DriverManagerTL.setDriver(driver);  // ✅ ThreadLocal usage PERFECT!
    }

    public static void down() {
        if (getDriver() != null) {
            DriverManagerTL.getDriver().quit();

        }
    }
}
