package com.yandex.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "passp-field-login")
    private WebElement USER_NAME_FIELD;

    @FindBy(id = "passp-field-passwd")
    private WebElement PASSWORD_FIELD;

    @FindBy(id = "passp:sign-in")
    private WebElement LOGIN_BUTTON;

    public LoginPage fillLoginFields(String username, String password) {
        fillField((By) USER_NAME_FIELD, username);
        clickElement((By) LOGIN_BUTTON);
        fillField((By) PASSWORD_FIELD, password);
        clickElement((By) LOGIN_BUTTON);
        return this;
    }
}