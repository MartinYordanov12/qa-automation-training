package com.yandex.Tests;

import com.yandex.pages.EmailPage;
import com.yandex.pages.HomePage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class LoginTest extends BaseTest {

    @DisplayName("Login in mail.yandex.com and validate page open")
    @ParameterizedTest
    @CsvSource({"yordanovm, Dieselron"})
    void loginTest(String username, String password) throws InterruptedException {
        HomePage homePage = new HomePage(driver);
        EmailPage emailPage = new EmailPage(driver);
        homePage
                .navigateToHomePage()
                .clickOnLoginButton()
                .fillLoginFields(username, password);

        emailPage.clickOnDropdownMenu();
        assertTrue(emailPage.isEmailPageOpen(username));
        emailPage.clickOnLogOutButton();
        assertTrue(homePage.isLoginButtonPresented());
    }
}