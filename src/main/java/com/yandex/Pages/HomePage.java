package com.yandex.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {

    private final By LOGIN_BUTTON = By.cssSelector(".HeadBanner-Button-Enter.with-shadow");

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public HomePage clickOnLoginButton() {
        clickElement(LOGIN_BUTTON);
        return this;
    }

    public HomePage navigateToHomePage() {
        String baseURL = "https://mail.yandex.com";
        navigateTo(baseURL);
        return this;
    }
}