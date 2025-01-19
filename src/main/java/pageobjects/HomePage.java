package pageobjects;

import driver.ElementFinder;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import static view.HomePageElements.*;
import static view.LoggedUserPageElements.appLogoOnLoggedInScreen;

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
                driver.findElement(loginLogo));
    }

    public boolean isSucessfullyLoggedIn() {
        ElementFinder.waitForElementClickable(driver,
                        driver.findElement(usernameInput))
                .sendKeys(testUser1);

        ElementFinder.waitForElementClickable(driver,
                        driver.findElement(passwordInput))
                .sendKeys(pass);

        ElementFinder.waitForElementClickable(driver,
                driver.findElement(loginButton)).click();

        ElementFinder.waitForElementDisplayed(driver, driver.findElement(appLogoOnLoggedInScreen));

        return ElementFinder.isElementDisplayed(driver.findElement(appLogoOnLoggedInScreen));
    }
}

