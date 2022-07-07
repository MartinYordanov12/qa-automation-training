package com.yandex.pages;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.File;
import java.io.IOException;

public class HomePage extends BasePage {

    private static final String BASE_URL = "https://mail.yandex.com";

    @FindBy(css = ".HeadBanner-Button-Enter.with-shadow")
    private WebElement login_button;

    public HomePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public LoginPage clickOnLoginButton() {
        login_button.click();
        return new LoginPage(driver);
    }

    public HomePage navigateToHomePage() {
        navigateTo(BASE_URL);
        return this;
    }

    public boolean isLoginButtonPresented() {
        return login_button.isDisplayed();
    }

    public void makeScreenShot(){
        File screenshotAs = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(screenshotAs, new File("src/main/resources/screenShots/" +
                    "Screenshot.png"));
        } catch (IOException e){
            System.out.println("screenshot failed:" + e.getMessage());
        }
    }
}