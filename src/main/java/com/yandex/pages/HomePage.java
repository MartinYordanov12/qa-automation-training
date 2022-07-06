package com.yandex.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BasePage {
    private static final By LOGIN_BUTTON = By.cssSelector(".HeadBanner-Button-Enter.with-shadow");
    private static final String BASE_URL = "https://mail.yandex.com";

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public LoginPage clickOnLoginButton() {
        clickElement(LOGIN_BUTTON);
        return new LoginPage(driver);
    }

    public HomePage navigateToHomePage() {
        navigateTo(BASE_URL);
        return this;
    }

    public boolean isLoginButtonPresented() {
        return driver.findElement(LOGIN_BUTTON).isDisplayed();
    }

}