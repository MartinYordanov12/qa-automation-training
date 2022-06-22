package com.yandex.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {


    private static final By LOGIN_BUTTON = By.cssSelector(".HeadBanner-Button-Enter.with-shadow");
    private static final String BASE_URL = "https://mail.yandex.com";
    private static final By HOME_PAGE_HEADER_TEXT =By.xpath("//div[text() = 'Sincerely yours' ]");

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

    public boolean isHomePagePresented() {
        return isElementPresented(HOME_PAGE_HEADER_TEXT);
    }
}