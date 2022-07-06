package com.yandex.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EmailPage extends BasePage {

    private static final String USERNAME = "yordanovm";

    @FindBy(css = ".user-account_left-name .user-account__name")
    private WebElement user_account_name;

    @FindBy(css = ".user-account_left-name")
    private WebElement username_icon;

    @FindBy(css = "a[aria-label='Log out'] span[class='menu__text']")
    private WebElement logout_button;

    public EmailPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public boolean isEmailPageOpen() {
        return user_account_name.getText().contains(USERNAME);
    }

    public void clickOnDropdownMenu() {
        username_icon.click();
    }

    public void clickOnLogOutButton() {
        logout_button.click();
    }
}