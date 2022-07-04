package com.seleniumeasy.demo;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AlertPage extends BasePage {

    private static final String BASE_URL = "https://demo.seleniumeasy.com/javascript-alert-box-demo.html";
    private static final By CONFIRM_ALERT_BOX = By.xpath("//p[@id=\"confirm-demo\"]//preceding-sibling::button");
    private static final By CONFIRM_RESULT = By.cssSelector("p#confirm-demo");
    private static final By PROMPT_ALERT_BOX = By.xpath("//p[@id=\"prompt-demo\"]//preceding-sibling::button");
    private static final By PROMPT_RESULT = By.cssSelector("p#prompt-demo");
    private static String INPUT = "Martin";

    public AlertPage(WebDriver driver) {
        super(driver);
    }

    public void navigateToAlertPage() {
        navigateTo(BASE_URL);
    }

    public void clickAcceptButtonJavaScriptConfirmBox() {
        driver.findElement(CONFIRM_ALERT_BOX).click();
        Alert alert = driver.switchTo().alert();
        alert.accept();
    }

    public String getTextMessageFromJavaScriptConfirmBox() {
        return driver.findElement(CONFIRM_RESULT).getText();
    }

    public void clickDismissButtonJavaScriptConfirmBox() {
        driver.findElement(CONFIRM_ALERT_BOX).click();
        Alert alert = driver.switchTo().alert();
        alert.dismiss();
    }

    public void enterNameAndClickOnOKButtonJavaScriptAlertBox() {
        driver.findElement(PROMPT_ALERT_BOX).click();
        Alert promptAlert = driver.switchTo().alert();
        promptAlert.sendKeys(INPUT);
        promptAlert.accept();
    }

    public String getNameJavaScriptAlertBox() {
        return driver.findElement(PROMPT_RESULT).getText();
    }
}