package com.yandex.pages;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverSingleton {

    private static DriverSingleton instance = null;
    private WebDriver driver;

    private DriverSingleton() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    public WebDriver getDriver() {
        return driver;
    }

    public static DriverSingleton getInstance(){
        if (instance ==null){
            instance = new DriverSingleton();
        }
        return instance;
    }

    public void closeDriver() {
        instance = null;
        driver.close();
    }
}
