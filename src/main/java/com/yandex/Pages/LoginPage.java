package com.yandex.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {

    private final By USER_NAME_FIELD = By.id("passp-field-login");
    private final By PASSWORD_FIELD = By.id("passp-field-passwd");
    private final By LOGIN_BUTTON = By.id("passp:sign-in");
    private final By LOGIN_WITH_TEXT = By.className("AuthSocialBlock-title");
    private final By PREVIOUS_STEP_BUTTON = By.className("PreviousStepButton");
    private final By CURRENT_USERNAME = By.className("CurrentAccount");
    private final By ADD_ACCOUNT_BUTTON = By.className("AddAccountButton-text");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public LoginPage fillLoginFields(String username,String password) {
        fillField(USER_NAME_FIELD, username);
        clickElement(LOGIN_BUTTON);
        fillField(PASSWORD_FIELD, password);
        clickElement(LOGIN_BUTTON);
        return this;
    }

    public LoginPage changeCurrentAccount(){
        clickElement(CURRENT_USERNAME);
        isElementPresented(ADD_ACCOUNT_BUTTON);
        clickElement(ADD_ACCOUNT_BUTTON);
        return this;
    }

    /*public LoginPage fillPasswordField(String password) {
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
    }*/

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