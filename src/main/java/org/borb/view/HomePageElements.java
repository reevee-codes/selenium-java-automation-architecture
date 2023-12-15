package org.borb.view;

import org.openqa.selenium.By;

public final class HomePageElements {

    public static By loginLogo = By.xpath("//div[@class='login_logo']");
    public static By usernameInput = By.xpath("//input[@id='user-name']");
    public static By passwordInput = By.xpath("//input[@id='password']");
    public static By loginButton = By.xpath("//input[@id='login-button']");
    public static String testUser1 = "standard_user";
    public static String pass = "secret_sauce";
    private HomePageElements() {
    }
}