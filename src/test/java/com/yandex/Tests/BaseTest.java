package com.yandex.Tests;

import com.yandex.pages.DriverSingleton;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class BaseTest {
    protected static  WebDriver driver;

    @BeforeEach
    void setup() {
        DriverSingleton driverSingleton = DriverSingleton.getInstance();
        driver = driverSingleton.getDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @AfterAll
    static void teardown() {
        DriverSingleton.getInstance().closeDriver();
    }
}