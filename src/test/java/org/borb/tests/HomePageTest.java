package org.borb.tests;

import pageobjects.HomePage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class HomePageTest extends BasePageTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(HomePageTest.class);

    private HomePage homePage;

    @BeforeClass
    public void setUp() {
        this.homePage = new HomePage(getDriverInstance());
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
        Assert.assertTrue(homePage.isSucessfullyLoggedIn());
    }
    }
