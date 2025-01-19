package driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
public class DriverFactory {
    private static final Logger LOGGER = LoggerFactory.getLogger(DriverFactory.class);

    private DriverFactory() {
    }
    public static WebDriver getDriver(String browserType) {
        WebDriver driver;

        switch (browserType) {
            case "chrome" -> {
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
            }
            case "firefox" -> {
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
            }
            case "edge" -> {
                WebDriverManager.edgedriver().setup();
                driver = new EdgeDriver();
            }
            default -> {
                String errorMessage = "Specify browser type";
                LOGGER.error(errorMessage);
                throw new IllegalArgumentException(errorMessage);
            }
        }
        LOGGER.info("Initializing {} driver.", browserType);
        return driver;
    }

    public static WebDriver getDriver() {
        return getDriver("edge");
    }
}
