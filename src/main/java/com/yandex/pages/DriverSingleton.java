package com.yandex.pages;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class DriverSingleton {

    private static DriverSingleton browserInstance = null;
    private WebDriver driver;

    private DriverSingleton() {
        WebDriverManager.chromedriver().setup();
        //driver = new ChromeDriver();
        ChromeOptions chromeOptions = new ChromeOptions();
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setBrowserName("chrome");

        try{
            driver = new RemoteWebDriver(new URL("http://localhost:4444"),desiredCapabilities);
        }catch (MalformedURLException e){
            e.printStackTrace();
        }
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