package org.borb.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeDriverService;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.GeckoDriverService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DriverFactory {

    private static final Logger LOGGER = LoggerFactory.getLogger(DriverFactory.class);

    private static final String BROWSER_FROM_BUILD_ARG = System.getProperty("browser");
    private static final String CHROME_DRIVER_PATH = "src/main/resources/drivers/chromedriver.exe";
    private static final String GECKO_DRIVER_PATH = "src/main/resources/drivers/geckodriver.exe";
    private static final String EDGE_DRIVER_PATH = "src/main/resources/drivers/MicrosoftEdgeDriver.exe";

    private DriverFactory() {
        //utility class
    }

    /**
     * Create {@link WebDriver} instance according to the browser type parameter.
     *
     * @param browserType the browser to start
     * @return the specific {@link WebDriver} instance
     */
    public static WebDriver getDriver(String browserType) {
        WebDriver driver;

        switch (browserType) {
            case "chrome":
                System.setProperty(ChromeDriverService.CHROME_DRIVER_EXE_PROPERTY, CHROME_DRIVER_PATH);
                driver = new ChromeDriver();
                break;
            case "firefox":
                System.setProperty(GeckoDriverService.GECKO_DRIVER_EXE_PROPERTY, GECKO_DRIVER_PATH);
                driver = new FirefoxDriver();
                break;
            case "edge":
                System.setProperty(EdgeDriverService.EDGE_DRIVER_EXE_PROPERTY, EDGE_DRIVER_PATH);
                driver = new EdgeDriver();
                break;
            default:
                String errorMessage = "Specify browser type";
                LOGGER.error(errorMessage);
                throw new IllegalArgumentException(errorMessage);
        }
        LOGGER.info("Initializing {} driver.", browserType);
        return driver;
    }

    public static WebDriver getDriver() {
        return getDriver("chrome");
    }
}
