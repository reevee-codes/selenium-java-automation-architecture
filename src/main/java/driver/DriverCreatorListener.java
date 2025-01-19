package driver;

import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class DriverCreatorListener implements ITestListener, ISuiteListener {

    private static final Logger LOGGER = LoggerFactory.getLogger(DriverCreatorListener.class);
    private long startTime;

    @Override
    public void onStart(ISuite suite) {
        startTime = System.currentTimeMillis();
    }

    @Override
    public void onFinish(ISuite suite) {
        double finishTime = (System.currentTimeMillis() - startTime);
        LOGGER.info("Suite execution took {} ms", finishTime);
    }

    @Override
    public void onStart(ITestContext context) {
        WebDriver driver = DriverFactory.getDriver();
        ThreadLocalDriverManager.setDriver(driver);
    }

    @Override
    public void onFinish(ITestContext context) {
        WebDriver driver = ThreadLocalDriverManager.getDriver();
        if (driver != null) {
            LOGGER.info("Closing the browser.");
            driver.quit();
        }
    }

    @Override
    public void onTestStart(ITestResult result) {
        //no action required for test start
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        //no action required for test success
    }

    @Override
    public void onTestFailure(ITestResult result) {
        //no action required for test failure
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        //no action required for test skipped
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        //no action required for test failure
    }
}