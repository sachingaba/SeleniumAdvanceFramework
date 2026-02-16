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

        String browser = PropertiesReader.readKey("browser");
        browser = browser.toLowerCase();

        switch (browser) {
            case "chrome":
                System.out.println("You Chose --> Chrome");
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.addArguments("--start--maximize");
                chromeOptions.addArguments("--guest");
                chromeOptions.addArguments("--headerless=new");
                WebDriver driver = new ChromeDriver(chromeOptions);
                setDriver(driver);

                break;
            case "edge":
                System.out.println("You Chose --> Edge");
                EdgeOptions edgeOptions = new EdgeOptions();
                edgeOptions.addArguments("--start--maximize");
                edgeOptions.addArguments("--guest");
                driver = new EdgeDriver(edgeOptions);
                setDriver(driver);
                break;
            case "firefox":
                System.out.println("You Chose --> Firefox");
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                firefoxOptions.addArguments("--start--maximize");
                firefoxOptions.addArguments("--guest");
                driver = new FirefoxDriver(firefoxOptions);
                setDriver(driver);
                break;
            default:
                System.out.println("NO Browser Selected !!!!");

        }
    }

    public static void down() {
        if (DriverManagerTL.getDriver() != null) {
            getDriver().quit();

        }

    }
}
