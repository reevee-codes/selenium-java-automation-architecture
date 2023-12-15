package org.borb.pageobjects;

import org.borb.driver.ElementFinder;
import org.borb.view.HomePageElements;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BasePage {

    private WebDriver driver;

    public HomePage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void launchHomePage() {
        launchPage("https://www.saucedemo.com/");
    }

    public boolean isHomePageDisplayed() {
        return ElementFinder.isElementDisplayed(
                driver.findElement(By.xpath("//div[@class='login_logo']")));
    }
}

