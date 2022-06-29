package com.yandex.Tests;

import com.yandex.Pages.EmailPage;
import com.yandex.Pages.HomePage;
import com.yandex.Pages.LoginPage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class LoginTest extends BaseTest {

    @DisplayName("Login in mail.yandex.com and validate page open")
    @ParameterizedTest
    @ValueSource(strings = {"yordanovm Dieselron", "yordanovm123 Dieselron"})
    void loginTest(String credentials) {
        String username = credentials.split(" ")[0];
        String password = credentials.split(" ")[1];
        HomePage homePage = new HomePage(driver);
        EmailPage emailPage = new EmailPage(driver);
        LoginPage loginPage = homePage
                .navigateToHomePage()
                .clickOnLoginButton()
                .fillLoginFields(username, password);

        WebDriverWait webDriverWait = new WebDriverWait(driver, 10);
        //explicit wait
        webDriverWait.until(ExpectedConditions.visibilityOf(emailPage.getEmailPageIcon()));
        assertTrue(emailPage.isEmailPageOpen(username));

    }
}