package com.yandex.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class EmailPage extends BasePage {

    private static String username = "//div[@class = 'PSHeader-User']/descendant::span[text() = '%s'][1]";
    private static final By EMAIL_ICON = By.className("PSHeaderIcon_Mail");
    private static final By DROPDOWN_MENU = By.xpath(username);
    private static final By LOGOUT_BUTTON = By.xpath("//span[text() = 'Log out' ]");
    private static final By USERNAME_DROPDOWN = By.className("user-account__name");

    public EmailPage(WebDriver driver) {
        super(driver);
    }

    public boolean isEmailPageOpen(String name) {
        username = String.format(username, name);
        return driver.findElement(USERNAME_DROPDOWN).isDisplayed();
    }

    public WebElement getEmailPageIcon() {
        return driver.findElement(EMAIL_ICON);
    }

    public EmailPage clickOnDropdownMenu() {
        clickElement(DROPDOWN_MENU);
        return this;
    }

    public LoginPage clickLogOutButton() {
        clickElement(USERNAME_DROPDOWN);
        clickElement(LOGOUT_BUTTON);
        return new LoginPage(driver);
    }
}