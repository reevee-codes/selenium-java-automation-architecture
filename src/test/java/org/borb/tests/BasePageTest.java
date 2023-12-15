package org.borb.tests;

import org.borb.driver.DriverCreatorListener;
import org.borb.driver.ThreadLocalDriverManager;
//import org.borb.reporting.ScreenshotListener;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Listeners;

@Listeners({DriverCreatorListener.class})
public abstract class BasePageTest {

    protected WebDriver getDriverInstance() {
        return ThreadLocalDriverManager.getDriver();
    }

}