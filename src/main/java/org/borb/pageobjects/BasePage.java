package org.borb.pageobjects;

import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class BasePage {

    private static final Logger LOGGER = LoggerFactory.getLogger(BasePage.class);

    private WebDriver driver;

    BasePage(WebDriver driver) {
        this.driver = driver;
    }

    /**
     * Get the {@link WebDriver} instance and maximize the browser window.
     * @return the {@link WebDriver} instance
     */
    public WebDriver getDriver() {
        driver.manage().window().maximize();
        return driver;
    }

    /**
     * Launch the specified page.
     * @param url the URL of the page to be opened.
     */
    void launchPage(String url) {
        LOGGER.info("Starting browser.");
        LOGGER.info("Maximizing browser window.");
        LOGGER.info("Launching page: {}", url);
        getDriver().get(url);
    }
}
