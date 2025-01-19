//package org.borb.reporting;
//import java.io.File;
//import java.io.IOException;
//import java.nio.file.Files;
//import java.nio.file.Path;
//import java.nio.file.Paths;
//import org.apache.commons.io.FileUtils;
//import org.openqa.selenium.OutputType;
//import org.openqa.selenium.TakesScreenshot;
//import org.openqa.selenium.WebDriver;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.testng.ITestContext;
//import org.testng.ITestListener;
//import org.testng.ITestResult;
//
//public class ScreenshotListener implements ITestListener {
//
//    private static final Logger LOGGER = LoggerFactory.getLogger(ScreenshotListener.class);
//    private static final String SCREENSHOT_FOLDER = "build/reports/tests/screenshots/";
//    private static final String FILE_EXTENSION = ".png";
//
//    @Override
//    public void onTestStart(ITestResult result) {
//        //no action required for test start
//    }
//
//    @Override
//    public void onTestSuccess(ITestResult result) {
//        //no action required for test success
//    }
//
//    @Override
//    public void onTestFailure(ITestResult result) {
//        String fileName = result.getName() + FILE_EXTENSION;
//        takeScreenshot(fileName);
//    }
//
//    private void takeScreenshot(String fileName) {
//        WebDriver driver = ThreadLocalDriverManager.getDriver();
//
//        LOGGER.info("Taking screenshot.");
//        File screenshotTemp = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
//
//        Path path = Paths.get(SCREENSHOT_FOLDER);
//        if (!path.toFile().exists()) {
//            LOGGER.debug("Creating folder for screenshots.");
//            try {
//                Files.createDirectories(path);
//                LOGGER.debug("Screenshots directory created.");
//            } catch (IOException e) {
//                LOGGER.error(e.getMessage());
//            }
//        }
//
//        File screenshot = new File(SCREENSHOT_FOLDER + fileName);
//        String absolutePathOfScreenshot = screenshot.getAbsolutePath();
//        try {
//            LOGGER.debug("Copying screenshot file to {}", absolutePathOfScreenshot);
//            FileUtils.copyFile(screenshotTemp, screenshot);
//        } catch (IOException e) {
//            LOGGER.error(e.getMessage());
//        }
//    }
//
//    @Override
//    public void onTestSkipped(ITestResult result) {
//        //no action required for test skipped
//    }
//
//    @Override
//    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
//        //no action required for test failure
//    }
//
//    @Override
//    public void onStart(ITestContext context) {
//        //no action required for start
//    }
//
//    @Override
//    public void onFinish(ITestContext context) {
//        //no action required for finish
//    }
//}
//
