package com.yandex.pages;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class DriverSingleton {

    private static DriverSingleton browserInstance = null;
    private WebDriver driver;
    private static final String URL = "\"https://oauth-martinyordanov95-0343e:353422ab-62ba-4f22-aadd-532eec6eebbe@ondemand.eu-central-1.saucelabs.com:443/wd/hub\"";
    private static final String BROWSER_NAME = "chrome";
    private static final String BROWSER_VERSION = "88";
    private DriverSingleton() throws MalformedURLException {

        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setBrowserName(BROWSER_NAME);
        desiredCapabilities.setPlatform(Platform.WIN10);
        desiredCapabilities.setVersion(BROWSER_VERSION);

        URL url = new URL(URL);
        driver = new RemoteWebDriver(url, desiredCapabilities);
    }

    public WebDriver getDriver() {
        return driver;
    }


    public static DriverSingleton getInstance() {
        if (browserInstance == null) {
            try {
                browserInstance = new DriverSingleton();
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
        }
        return browserInstance;
    }

    public void closeDriver() {
        browserInstance = null;
        driver.close();
    }
}