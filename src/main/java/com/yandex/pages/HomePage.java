package com.yandex.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BasePage {

    private static final String BASE_URL = "https://mail.yandex.com";

    @FindBy(css = ".HeadBanner-Button-Enter.with-shadow")
    private WebElement login_button;

    public HomePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public LoginPage clickOnLoginButton() {
        login_button.click();
        return new LoginPage(driver);
    }

    public HomePage navigateToHomePage() {
        navigateTo(BASE_URL);
        return this;
    }

    public boolean isLoginButtonPresented() {
return login_button.isDisplayed();
    }
}