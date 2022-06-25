package com.seleniumeasy.demo;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

public class BasePage {
    WebDriver driver;


    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    void navigateTo(String URL){
        driver.navigate().to(URL);
    }

    void clickElement(By element){
        driver.findElement(element).click();
    }

    void fillField(String name, By by){
        driver.findElement(by).sendKeys(name);
    }

    public boolean isElementPresented(By element){
        try{
            driver.findElement(element);
            return true;
        }catch (NoSuchElementException e){
            return false;
        }
    }


}
