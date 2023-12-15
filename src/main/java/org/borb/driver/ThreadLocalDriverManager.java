package org.borb.driver;

import org.openqa.selenium.WebDriver;

public final class ThreadLocalDriverManager {

    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    private ThreadLocalDriverManager() {
        //utility class
    }

    public static WebDriver getDriver() {
        return driver.get();
    }

    static void setDriver(WebDriver webDriver) {
        driver.set(webDriver);
    }
}