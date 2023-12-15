package org.borb.tests;

import org.borb.driver.DriverFactory;
import org.borb.pageobjects.HomePage;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class HomePageTest extends BasePageTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(HomePageTest.class);

    private HomePage homePage;


    @BeforeClass
    public void setUp() {
        WebDriver driver = DriverFactory.getDriver("chrome");
        this.homePage = new HomePage(driver);
        LOGGER.info("Launching home page.");
        homePage.launchHomePage();
    }

    @Test
    public void testIfHomePageIsDisplayed() {
        LOGGER.info("Verifying if the home page is displayed.");
        Assert.assertTrue(homePage.isHomePageDisplayed());
        LOGGER.info("The home page is displayed.");
    }

    @Test
    public void testIfLoginForStandardUserWorks() {
       //todo
    }
    }
