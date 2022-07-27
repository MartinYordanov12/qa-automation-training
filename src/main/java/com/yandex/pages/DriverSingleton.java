package com.yandex.pages;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.Augmenter;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Optional;

public class DriverSingleton {

    private static DriverSingleton browserInstance = null;
    private WebDriver driver;

    private static final String EDGE = "edge";
    private static final String FIREFOX = "firefox";
    private static final String CHROME = "chrome";


    private DriverSingleton() throws MalformedURLException {
        //WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setBrowserName("chrome");
        desiredCapabilities.setPlatform(Platform.WIN10);
        desiredCapabilities.setVersion("88");

        //desiredCapabilities.setVersion("latest");
        //Map<String, Object> sauceOptions = new HashMap<>();
        //sauceOptions.put("build", "75");
        //sauceOptions.put("name", "chrome");
        //desiredCapabilities.setCapability("sauce:options", sauceOptions);

        URL url = new URL("https://oauth-martinyordanov95-0343e:353422ab-62ba-4f22-aadd-532eec6eebbe@ondemand.eu-central-1.saucelabs.com:443/wd/hub");
        driver = new RemoteWebDriver(url, desiredCapabilities);
        driver = new Augmenter().augment(driver);




        /*try{
            driver = new RemoteWebDriver(new URL("http://localhost:4444"),desiredCapabilities);
        }catch (MalformedURLException e){
            e.printStackTrace();
        }*/
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