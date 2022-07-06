package com.yandex.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EmailPage extends BasePage {

    public EmailPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = ".user-account_left-name .user-account__name")
    private WebElement USER_ACCOUNT_NAME;

    @FindBy(css = ".user-account_left-name")
    private WebElement USERNAME_ICON;

    @FindBy(css = "a[aria-label='Log out']")
    private WebElement LOGOUT_BUTTON;

    public boolean isEmailPageOpen(String userName) {
        return driver.findElement((By) USER_ACCOUNT_NAME).getText().contains(userName);
    }

    public void clickOnDropdownMenu() {
        clickElement((By) USERNAME_ICON);
    }

    public void clickOnLogOutButton() {
        driver.findElement((By) LOGOUT_BUTTON).click();
    }
}