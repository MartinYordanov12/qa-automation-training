package com.yandex.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {

    private final By USER_NAME_FIELD = By.id("passp-field-login");
    private final By PASSWORD_FIELD = By.id("passp-field-passwd");
    private final By LOGIN_BUTTON = By.id("passp:sign-in");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public LoginPage fillLoginFields(String username, String password) {
        fillField(USER_NAME_FIELD, username);
        clickElement(LOGIN_BUTTON);
        fillField(PASSWORD_FIELD, password);
        clickElement(LOGIN_BUTTON);
        return this;
    }
}