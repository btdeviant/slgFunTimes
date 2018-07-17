package com.slg.selenium;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class HomePageTest {

    /**
     * Filthy but fast - bt
     **/


    private String slgTitle = "Super League Gaming: Homepage";
    private String googleURL = "http://google.com";
    private String googleSearchBarLocator = "lst-ib";
    private String slgGoogleSearchString = "Super League Gaming";


    public void driverProperties() {
        System.setProperty("webdriver.chrome.driver", "/Users/brandon/Downloads/chromedriver");

    }


    @Test
    public void assertSLGTopOfGoogleSearch() {
        driverProperties();
        WebDriver driver = new ChromeDriver();
        System.out.print("Navigate to: " + googleURL + "\n");
        driver.get(googleURL);
        System.out.print("Sending keys: " + slgGoogleSearchString + "\n");
        driver.findElement(By.id(googleSearchBarLocator)).sendKeys(slgGoogleSearchString);
        driver.findElement(By.id(googleSearchBarLocator)).sendKeys(Keys.ENTER);
        System.out.print("Creating list of result titles" + "\n");

        List<WebElement> resultTitleList = ((ChromeDriver) driver).findElementsByClassName("r");
        System.out.print("Checking to see if " + slgTitle + " is the first element in the list." + "\n");

        if (!resultTitleList.isEmpty() && resultTitleList.get(0).getText().contains(slgTitle)) {
            System.out.println(slgTitle + " is at the top of the list" + "\n");
            driver.close();
        } else {
            System.out.println(slgTitle + " is not at the top of the search results. Check your SEO!");
            driver.close();
        }
    }
}

