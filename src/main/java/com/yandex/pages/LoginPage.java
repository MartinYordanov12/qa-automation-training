package com.yandex.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage {

    private static final By USER_NAME_FIELD = By.id("passp-field-login");
    private static final By PASSWORD_FIELD = By.id("passp-field-passwd");
    private static final By LOGIN_BUTTON = By.id("passp:sign-in");
    private static final String username = "yordanovm";
    private static final String password = "Dieselron";


    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public LoginPage login() {
        fillField(USER_NAME_FIELD, username);
        clickElement(LOGIN_BUTTON);
        fillField(PASSWORD_FIELD, password);
        clickElement(LOGIN_BUTTON);
        return this;
    }

}