package com.yandex.pages;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverSingleton {

    private static DriverSingleton browserInstance = null;
    private final WebDriver driver;

    private DriverSingleton() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    public WebDriver getDriver() {
        return driver;
    }

    public static DriverSingleton getInstance() {
        if (browserInstance == null) {
            browserInstance = new DriverSingleton();
        }
        return browserInstance;
    }

    public void closeDriver() {
        browserInstance = null;
        driver.close();
    }
}