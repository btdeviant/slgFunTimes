package com.slg.selenium;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HomePageTest {

    /**
     * Filthy but fast - bt
     **/


    private String slgHome = "http://superleague.com";
    private String slgTitle = "Homepage - Super League Gaming";


    private void driverProperties() {
        System.setProperty("webdriver.chrome.driver", "/Users/brandon/Downloads/chromedriver");
    }

    @Test
    public void assertHomeTitle() {
        driverProperties();
        WebDriver driver = new ChromeDriver();
        driver.get(slgHome);
        String title = driver.getTitle();
        Assert.assertEquals("Current Page Title", slgTitle, title);
        driver.quit();
    }



}
