package com.yandex.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class EmailPage extends BasePage {
    private final By EMAIL_ICON = By.className("PSHeaderIcon_Mail");

    public EmailPage(WebDriver driver) {
        super(driver);
    }

    public boolean isEmailPageOpen() {
        return driver.findElement(EMAIL_ICON).isDisplayed();
    }

    public WebElement getEmailPageIcon() {
        return driver.findElement(EMAIL_ICON);
    }
}
