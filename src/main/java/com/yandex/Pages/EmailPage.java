package com.yandex.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class EmailPage extends BasePage {

    private static final By EMAIL_ICON = By.className("PSHeaderIcon_Mail");

    private static final By USERNAME = By.cssSelector(".user-account_has-subname_yes span.user-account__name");
    private static final By LOGOUT_BUTTON = By.xpath("//span[text() = 'Log out' ]");
    private static final By USER_ICON = By.className("user-account__name");
    private static final By USERNAME_ICON = By.cssSelector(".user-account_left-name");

    public EmailPage(WebDriver driver) {
        super(driver);
    }

    public boolean isEmailPageOpen(String userName) {
        String actualResult = driver.findElement(USERNAME).getText();
        System.out.println(actualResult);
        return driver.findElement(USERNAME).getText().contains(userName);
    }

    public WebElement getEmailPageIcon() {
        return driver.findElement(EMAIL_ICON);
    }

    public EmailPage clickOnDropdownMenu() {
        clickElement(USERNAME_ICON);
        return this;
    }

    public LoginPage clickLogOutButton() {
        clickElement(USER_ICON);
        clickElement(LOGOUT_BUTTON);
        return new LoginPage(driver);
    }
}