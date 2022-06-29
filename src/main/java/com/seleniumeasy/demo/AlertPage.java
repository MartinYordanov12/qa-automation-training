package com.seleniumeasy.demo;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class AlertPage extends BasePage{

    public static final String BASE_URL = "https://demo.seleniumeasy.com/javascript-alert-box-demo.html";
    public static final By ALERT_CLICK_BOX = By.cssSelector("[onclick='myAlertFunction\\(\\)']");
    public static final By CONFIRM_ALERT_BOX = By.xpath("//p[@id=\"confirm-demo\"]//preceding-sibling::button");
    public static final By CONFIRM_RESULT = By.cssSelector("p#confirm-demo");
    public static final By PROMPT_ALERT_BOX = By.xpath("//p[@id=\"prompt-demo\"]//preceding-sibling::button");
    public static final By PROMPT_RESULT = By.cssSelector("p#prompt-demo");
    public static final By ALERT_BOX_RESULT = By.cssSelector("[class] .panel-primary:nth-child(4) .panel-body");
    private static String INPUT = "Martin";

    public AlertPage(WebDriver driver) {
        super(driver);
    }

    public AlertPage navigateToAlertPage(){
        navigateTo(BASE_URL);
        return this;
    }

    public boolean javaScriptAlertBox(){
        driver.findElement(ALERT_CLICK_BOX).click();
        Alert alert = driver.switchTo().alert();
        alert.accept();
        String actualMessage = driver.findElement(ALERT_BOX_RESULT).getText();
        System.out.println(actualMessage);
        String expectedMessage = "When an alert box pops up, user have to click \"OK\" button to proceed.\n" +
                "\n" +
                "Click the button to display an alert box:\n" +
                "Click me!";
        return actualMessage.contains(expectedMessage);

    }

    public boolean javaScriptConfirmBoxAccept(){
        driver.findElement(CONFIRM_ALERT_BOX).click();
        Alert alert = driver.switchTo().alert();
        alert.accept();
        String actualMessage =driver.findElement(CONFIRM_RESULT).getText();
        System.out.println(actualMessage);
        String expectedMessage = "You pressed OK!";
        return actualMessage.contains(expectedMessage);
    }

    public boolean javaScriptConfirmBoxDismiss(){
        driver.findElement(CONFIRM_ALERT_BOX).click();
        Alert alert = driver.switchTo().alert();
        alert.dismiss();
        String actualMessage = driver.findElement(CONFIRM_RESULT).getText();
        String expectedMessage = "You pressed Cancel!";
        return actualMessage.contains(expectedMessage);
    }

    public boolean javaScriptAlertBoxNameCheck(){
        driver.findElement(PROMPT_ALERT_BOX).click();
        Alert promptAlert = driver.switchTo().alert();
        promptAlert.sendKeys(INPUT);
        promptAlert.accept();
        String actualMessage = driver.findElement(PROMPT_RESULT).getText();
        String expectedMessage = String.format("You have entered '%s' !", INPUT);
        System.out.println(actualMessage);
        return actualMessage.contains(expectedMessage);
    }



}
