package com.yandex.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class EmailPage extends BasePage {

    private static final By USER_ACCOUNT_NAME = By.cssSelector(".user-account_left-name .user-account__name");
    private static final By USERNAME_ICON = By.cssSelector(".user-account_left-name");
    private static final By LOGOUT_BUTTON = By.cssSelector("a[aria-label='Log out'] span[class='menu__text']");


    public EmailPage(WebDriver driver) {
        super(driver);
    }

    public boolean isEmailPageOpen(String username) {
        return driver.findElement(USER_ACCOUNT_NAME).getText().contains(username);
    }

    public void clickOnDropdownMenu() {
        clickElement(USERNAME_ICON);
    }

    public void clickOnLogOutButton(){
        driver.findElement(LOGOUT_BUTTON).click();
    }
}