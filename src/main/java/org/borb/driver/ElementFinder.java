package org.borb.driver;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class ElementFinder {

    private static final Logger LOGGER = LoggerFactory.getLogger(ElementFinder.class);
    private static final long DEFAULT_WAIT_TIME = 10;

    private ElementFinder() {
        //utility class
    }

    /**
     * A wrapper method to wait for the {@link WebElement} to be displayed.
     *
     * @param driver the {@link WebDriver} instance
     * @param element the {@link WebElement} to wait for
     * @return the {@link WebElement} if displayed
     * @see ExpectedConditions#visibilityOf(WebElement)
     */
    public static WebElement waitForElementDisplayed(WebDriver driver, WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver,  Duration.ofMillis(500L));
        wait.until(ExpectedConditions.visibilityOf(element));
        return element;
    }


    /**
     * A wrapper method to wait for the {@link WebElement} to be displayed.
     *
     * @param driver the {@link WebDriver} instance
     * @param elements a {@link List} of {@link WebElement} to wait for
     * @return a {@link List} of {@link WebElement} if displayed
     * @see ExpectedConditions#visibilityOfAllElements(List)
     */
    public static List<WebElement> waitForElementsDisplayed(WebDriver driver,
                                                            List<WebElement> elements) {
        WebDriverWait wait = new WebDriverWait(driver,  Duration.ofMillis(500L));
        wait.until(ExpectedConditions.visibilityOfAllElements(elements));
        return elements;
    }

    /**
     * A wrapper method to wait for the {@link WebElement} to be clickable.
     *
     * @param driver the {@link WebDriver} instance
     * @param element the {@link WebElement} to wait for
     * @return the {@link WebElement} if clickable
     * @see ExpectedConditions#visibilityOf(WebElement)
     */
    public static WebElement waitForElementClickable(WebDriver driver, WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver,  Duration.ofMillis(500L));
        wait.until(ExpectedConditions.elementToBeClickable(element));
        return element;
    }

    /**
     * Checks if the {@link WebElement} is displayed and catches the {@link NoSuchElementException} or
     * the {@link StaleElementReferenceException} if the element not displayed.
     *
     * @param element the {@link WebElement} to check the presence of
     * @return true if the {@link WebElement} displayed
     */
    public static boolean isElementDisplayed(WebElement element) {
        boolean isDisplayed = false;
        try {
            isDisplayed = element.isDisplayed();
        } catch (NoSuchElementException | StaleElementReferenceException e) {
            LOGGER.debug("Element is not displayed");
        }
        return isDisplayed;
    }

    /**
     * Wait the specified time in seconds.
     *
     * @param timeInSec wait time
     */
    public static void waitForTimeElapsed(int timeInSec) {
        try {
            Thread.sleep(TimeUnit.SECONDS.toMillis(timeInSec));
        } catch (InterruptedException e) {
            LOGGER.error(e.getMessage());
            Thread.currentThread().interrupt();
        }
    }

    /**
     * Wait until the given element list is disappeared.
     *
     * @param element is the element list to be disappeared.
     * @return true if the element list is disappeared.
     */
    public boolean areElementsDisappeared(WebDriver driver, List<WebElement> element, int timeInSec) {
        WebDriverWait wait = new WebDriverWait(driver,  Duration.ofMillis(500L));
        return wait.until(ExpectedConditions.invisibilityOfAllElements(element));
    }
}
