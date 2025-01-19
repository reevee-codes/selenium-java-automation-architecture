package org.borb.tests;

import driver.DriverCreatorListener;
import driver.ThreadLocalDriverManager;
//import org.borb.reporting.ScreenshotListener;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Listeners;

@Listeners({DriverCreatorListener.class})
public abstract class BasePageTest {

    protected WebDriver getDriverInstance() {
        return ThreadLocalDriverManager.getDriver();
    }
}