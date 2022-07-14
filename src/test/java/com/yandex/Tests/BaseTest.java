package com.yandex.Tests;

import com.yandex.pages.DriverSingleton;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.util.concurrent.TimeUnit;

public class BaseTest {
    protected static WebDriver driver;
    protected String browserName;
    protected String browserVersion;

    @BeforeEach
    void setup() {
        DriverSingleton driverSingleton = DriverSingleton.getInstance();

        driver = driverSingleton.getDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        Capabilities caps = ((RemoteWebDriver) driver).getCapabilities();
        browserName = caps.getBrowserName();
        browserVersion = caps.getVersion();
    }

    @AfterEach
    void teardown() {
        DriverSingleton.getInstance().closeDriver();
    }
}