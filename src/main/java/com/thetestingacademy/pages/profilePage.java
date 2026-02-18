package com.thetestingacademy.pages;

import com.thetestingacademy.utils.PropertiesReader;
import com.thetestingacademy.utils.WaitHelpers;
import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class profilePage {
    public profilePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    WebDriver driver;

    @FindBy(name ="firstName")
    private WebElement username;

    @FindBy(xpath = "//li[@id=\"menuProfile\"]")
    private WebElement myProfile;

   // private By myProfile = By.xpath("//li[@id=\"menuProfile\"]");
    private By viewProfile = By.id("view_profile");
    private By firstName = By.name("firstName");
    private By lastName = By.name("lastName");
    private By chooseGender = By.xpath("//select[@name=\"gender\"]");
    private By chooseCountry = By.xpath("//select[@name=\"country\"]");
    private By chooseState = By.xpath("//select[@name=\"stateId\"]");
    private By chooseCity = By.xpath("//select[@name=\"cityId\"]");
    private By dob = By.xpath("//button[@class=\"mat-icon-button\"]");
    private By openYear = By.xpath("//button[@aria-label=\"Choose month and year\"]");
    private By chooseYear = By.xpath("//table[@class=\"mat-calendar-table\"]/tbody/tr[1]/td[4]");

    private By chooseMonth = By.xpath("//table[@class=\"mat-calendar-table\"]/tbody/tr[2]/td[2]");
    private By chooseDate = By.xpath("//table[@class=\"mat-calendar-table\"]/tbody/tr[2]/td[3]");
    private By experience = By.xpath("//select[@name=\"experience\"]");
    private By submitProfile = By.xpath("//button[@id=\"edit\"]");


    public void updateProfile() {


        myProfile.click();

        driver.findElement(viewProfile).click();
        driver.findElement(firstName).clear();
        driver.findElement(firstName).sendKeys(PropertiesReader.readKey("firstname"));
        driver.findElement(lastName).clear();
        driver.findElement(lastName).sendKeys(PropertiesReader.readKey("lastname"));
        //Drop-Downs
        WebElement Gender = driver.findElement(chooseGender);
        Select selectGender = new Select(Gender);
        selectGender.selectByVisibleText(PropertiesReader.readKey("Gender"));

        WebElement Country = driver.findElement(chooseCountry);
        Select selectCountry = new Select(Country);
        selectCountry.selectByVisibleText(PropertiesReader.readKey("Country"));

        WebElement State = driver.findElement(chooseState);
        Select selectState = new Select(State);
        selectState.selectByVisibleText(PropertiesReader.readKey("State"));

        WebElement City = driver.findElement(chooseCity);
        Select selectCity = new Select(City);
        selectCity.selectByVisibleText(PropertiesReader.readKey("City"));

        driver.findElement(dob).click();
      //  WebElement chooseyearTable = driver.findElement(chooseYear);
     //   List<WebElement> rows_table = chooseyearTable.findElements(By.tagName("tr"));

        driver.findElement(openYear).click();

WaitHelpers.checkVisibility(driver,chooseYear);

    /*    for (int i = 1; i < rows_table.size(); i++) {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table[@class=\"mat-calendar-table\"]/tbody/tr[1]/td[4]")));
            List<WebElement> col_table = rows_table.get(i).findElements(By.tagName("td"));
            System.out.println("here");
            for (WebElement col : col_table) {

                if (PropertiesReader.readKey("year").equals(col.getText())) {

                    col.click();
                    System.out.println(col.getText());
                    }
                }*/


driver.findElement(chooseYear).click();
                driver.findElement(chooseMonth).click();
                driver.findElement(chooseDate).click();

              WebElement ex=  driver.findElement(experience);
              ex.click();
        Select selectExperience = new Select(ex);
        selectExperience.selectByVisibleText(PropertiesReader.readKey("Experience"));

                driver.findElement(submitProfile).click();


            }

        }