package com.yandex.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage {

    @FindBy(id = "passp-field-login")
    private WebElement user_name_field;

    @FindBy(id = "passp-field-passwd")
    private WebElement password_field;

    @FindBy(id = "passp:sign-in")
    private WebElement login_button;

    public LoginPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public LoginPage login(String username, String password) {
        user_name_field.sendKeys(username);
        login_button.click();
        password_field.sendKeys(password);
        login_button.click();
        return this;
    }
}