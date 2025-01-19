package driver;

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
    }

    public static WebElement waitForElementDisplayed(WebDriver driver, WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver,  Duration.ofMillis(500L));
        wait.until(ExpectedConditions.visibilityOf(element));
        return element;
    }


    public static List<WebElement> waitForElementsDisplayed(WebDriver driver,
                                                            List<WebElement> elements) {
        WebDriverWait wait = new WebDriverWait(driver,  Duration.ofMillis(500L));
        wait.until(ExpectedConditions.visibilityOfAllElements(elements));
        return elements;
    }

    public static WebElement waitForElementClickable(WebDriver driver, WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver,  Duration.ofMillis(500L));
        wait.until(ExpectedConditions.elementToBeClickable(element));
        return element;
    }

    public static boolean isElementDisplayed(WebElement element) {
        boolean isDisplayed = false;
        try {
            isDisplayed = element.isDisplayed();
        } catch (NoSuchElementException | StaleElementReferenceException e) {
            LOGGER.debug("Element is not displayed");
        }
        return isDisplayed;
    }

    public static void waitForTimeElapsed(int timeInSec) {
        try {
            Thread.sleep(TimeUnit.SECONDS.toMillis(timeInSec));
        } catch (InterruptedException e) {
            LOGGER.error(e.getMessage());
            Thread.currentThread().interrupt();
        }
    }

    public boolean areElementsDisappeared(WebDriver driver, List<WebElement> element, int timeInSec) {
        WebDriverWait wait = new WebDriverWait(driver,  Duration.ofMillis(500L));
        return wait.until(ExpectedConditions.invisibilityOfAllElements(element));
    }
}
