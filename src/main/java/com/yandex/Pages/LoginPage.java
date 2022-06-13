package com.yandex.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {
    private final By USER_NAME_FIELD = By.id("passp-field-login");
    private final By PASSWORD_FIELD = By.id("passp-field-passwd");
    private final By LOGIN_BUTTON = By.id("passp:sign-in");
    private final By LOGIN_WITH_TEXT = By.className("AuthSocialBlock-title");
    private final By PREVIOUS_STEP_BUTTON = By.className("PreviousStepButton");


    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public LoginPage fillUserNameField(String username) {
        fillField(USER_NAME_FIELD, username);
        return this;
    }

    public LoginPage fillPasswordField(String password) {
        fillField(PASSWORD_FIELD, password);
        return this;
    }

    public LoginPage clickUsernameFormLoginButton() {
        clickElement(LOGIN_BUTTON);
        return this;
    }

    public EmailPage clickPasswordFormLoginButton() {
        clickElement(LOGIN_BUTTON);
        return new EmailPage(driver);
    }

    public HomePage clickOnUserNameFormBackButton() {
        clickElement(PREVIOUS_STEP_BUTTON);
        return new HomePage(driver);
    }

    public LoginPage clickOnPasswordFormBackButton() {
        clickElement(PREVIOUS_STEP_BUTTON);
        return this;
    }

    public boolean isLoginPagePresented() {
        return isElementPresented(LOGIN_WITH_TEXT);
    }

}