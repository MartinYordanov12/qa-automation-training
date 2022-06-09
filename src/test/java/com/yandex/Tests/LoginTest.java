package com.yandex.Tests;

import com.yandex.Pages.EmailPage;
import com.yandex.Pages.HomePage;
import com.yandex.Pages.LoginPage;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LoginTest extends BaseTest {
    LoginPage loginPage;
    HomePage homePage;
    EmailPage emailPage;

    public LoginTest() {
        loginPage = new LoginPage(driver);
        homePage = new HomePage(driver);
        emailPage = new EmailPage(driver);
    }

    @Test
    void loginTest() {
        homePage.navigateToHomePage()
                .clickOnLoginButton();

        loginPage.fillUserNameField("yordanovm")
                .clickLoginButton()
                .fillPasswordField("Dieselron")
                .clickLoginButton();

        WebDriverWait webDriverWait = new WebDriverWait(driver, 10);
        webDriverWait.until(ExpectedConditions.visibilityOf(emailPage.getEmailPageIcon()));

        assertTrue(emailPage.isEmailPageOpen());
    }
}