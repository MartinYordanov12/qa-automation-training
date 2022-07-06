package com.yandex.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BasePage {
    private static final String BASE_URL = "https://mail.yandex.com";

    public HomePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = ".HeadBanner-Button-Enter.with-shadow")
    private WebElement LOGIN_BUTTON;

    public LoginPage clickOnLoginButton() {
        clickElement((By) LOGIN_BUTTON);
        return new LoginPage(driver);
    }

    public HomePage navigateToHomePage() {
        navigateTo(BASE_URL);
        return this;
    }
}