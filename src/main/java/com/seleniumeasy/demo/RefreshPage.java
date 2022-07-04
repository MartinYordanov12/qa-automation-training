package com.seleniumeasy.demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class RefreshPage extends BasePage {
    private static final String BASE_URL = "https://demo.seleniumeasy.com/bootstrap-download-progress-demo.html";
    private static final By DOWNLOAD_BUTTON = By.id("cricle-btn");
    private static final String PERCENT_TEXT = ".percenttext";

    public RefreshPage(WebDriver driver) {
        super(driver);
    }

    public void navigateToRefreshPage() {
        navigateTo(BASE_URL);
    }

    public void clickDownloadButton() {
        clickElement(DOWNLOAD_BUTTON);
    }

    public void checkPageOnFiftyPercentOfLoadBar() {

        new WebDriverWait(driver, Duration.ofSeconds(15).toSeconds(), Duration.ofMillis(50).toMillis())
                .until(driver -> driver.findElement(By.cssSelector(".percenttext")).getText().equals("50%"));
    }
}