package com.yandex.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

abstract class BasePage {
    WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    void navigateTo(String URL) {
        driver.navigate().to(URL);
    }

    void clickElement(By element) {
        driver.findElement(element).click();
    }

    void fillField(By by, String text) {
        driver.findElement(by).sendKeys(text);
    }
}