package com.yandex.Tests;

import com.yandex.Pages.EmailPage;
import com.yandex.Pages.HomePage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class LoginTest extends BaseTest {

    @DisplayName("Login in mail.yandex.com and validate page open")
    @ParameterizedTest
    @CsvSource({"yordanovm, Dieselron", "yordanovm123, Dieselron"})
    void loginTest(String username, String password) {
        HomePage homePage = new HomePage(driver);
        EmailPage emailPage = new EmailPage(driver);
        homePage
                .navigateToHomePage()
                .clickOnLoginButton()
                .fillLoginFields(username, password);

        WebDriverWait webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(15).toSeconds(), Duration.ofMillis(50).toMillis());
        //explicit wait

        webDriverWait.until(ExpectedConditions.visibilityOf(emailPage.getEmailPageIcon()));
        emailPage.clickOnDropdownMenu();
        assertTrue(emailPage.isEmailPageOpen(username));
    }
}