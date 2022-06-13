package com.yandex.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class EmailPage extends BasePage {
    private static final By EMAIL_ICON = By.className("PSHeaderIcon_Mail");
    private static final By DROPDOWN_MENU = By.xpath("//div[@class = 'PSHeader-User']/descendant::span[text() = 'yordanovm'][1]");
    private static final By LOGOUT_BUTTON = By.xpath("//span[text() = 'Log out' ]");

    public EmailPage(WebDriver driver) {
        super(driver);
    }

    public boolean isEmailPageOpen() {
        return driver.findElement(DROPDOWN_MENU).isDisplayed();
    }

    public WebElement getEmailPageIcon() {
        return driver.findElement(EMAIL_ICON);
    }

    public EmailPage clickOnDropdownMenu(){
        clickElement(DROPDOWN_MENU);
        return this;
    }

    public LoginPage clickLogOutButton(){
        clickElement(LOGOUT_BUTTON);
        return new LoginPage(driver);
    }
}
