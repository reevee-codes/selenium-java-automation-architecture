package driver;

import org.openqa.selenium.WebDriver;

public final class ThreadLocalDriverManager {

    private static final ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    private ThreadLocalDriverManager() {
    }

    public static WebDriver getDriver() {
        return driver.get();
    }

    static void setDriver(WebDriver webDriver) {
        driver.set(webDriver);
    }
}