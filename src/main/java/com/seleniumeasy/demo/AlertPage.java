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

    public void openAlert() {
        driver.findElement(CONFIRM_ALERT_BOX).click();

    }

    public void acceptAlert() {
        Alert alert = driver.switchTo().alert();
        alert.accept();
    }

    public void dismissAlert() {
        Alert alert = driver.switchTo().alert();
        alert.dismiss();
    }

    public String getTextMessageFromJavaScriptConfirmBox() {
        return driver.findElement(CONFIRM_RESULT).getText();
    }

    public void openPromptAlert() {
        driver.findElement(PROMPT_ALERT_BOX).click();

    }

    public void fillAlertTextField(String INPUT) {
        Alert promptAlert = driver.switchTo().alert();
        promptAlert.sendKeys(INPUT);

    }

    public void acceptPromptAlert() {
        Alert promptAlert = driver.switchTo().alert();
        promptAlert.accept();
    }

    public String getPromptAlertBoxText() {
        return driver.findElement(PROMPT_RESULT).getText();
    }
}