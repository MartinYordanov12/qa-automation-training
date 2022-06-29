package com.seleniumeasy.demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class RefreshPage extends BasePage {
    private static final String BASE_URL = "https://demo.seleniumeasy.com/bootstrap-download-progress-demo.html";
    private static final By DOWNLOAD_BUTTON = By.id("cricle-btn");
    private static final String PERCENT_TEXT = ".percenttext";
    private static final By CIRCLE_INPUT = By.id("\"cricleinput\"");

    public RefreshPage(WebDriver driver) {
        super(driver);
    }

    public RefreshPage navigateToRefreshPage() {
        navigateTo(BASE_URL);
        return this;
    }

    public RefreshPage clickDownloadButton() {
        clickElement(DOWNLOAD_BUTTON);
        return this;
    }

    public void refreshPageOnFiftyPercentOfLoadBar() {
        //WebDriverWait wait = new WebDriverWait(driver, TimeUnit.SECONDS.toSeconds(10));

        WebDriverWait wait = new WebDriverWait(driver, TimeUnit.SECONDS.toSeconds(12));
        wait.until(driver -> {
            String percentText = driver.findElement(By.cssSelector(PERCENT_TEXT)).getText();
            String replacePercent = percentText.replaceAll("%$", "");
            int actualPercent = Integer.parseInt(replacePercent);
            return actualPercent >= 50;

        });

        //wait.until((WebDriver dr) -> dr.findElement(By.cssSelector(PERCENT_TEXT)).getText().equals("50%") || Integer.parseInt(dr.findElement(CIRCLE_INPUT).getAttribute("value")) >= 50);
        /*driver.navigate().refresh();
        Thread.sleep(2000);*/

    }

    public String getLoadBarValue() {
        return driver.findElement(By.cssSelector(PERCENT_TEXT)).getText();

    }
}