package com.yandex.Tests;

import com.yandex.pages.EmailPage;
import com.yandex.pages.HomePage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class LoginTest extends BaseTest {

    private static final String USERNAME = "yordanovm";
    private static final String PASSWORD = "Dieselron";
    private EmailPage emailPage;
    private HomePage homePage;

    @BeforeEach
    void login() {
        homePage = new HomePage(driver);
        emailPage = new EmailPage(driver);
        homePage
                .navigateToHomePage()
                .clickOnLoginButton()
                .login(USERNAME, PASSWORD);
    }

    @Test
    @DisplayName("Login in mail.yandex.com and validate page open")
    void loginTest() {
        emailPage.clickOnDropdownMenu();
        assertTrue(emailPage.isEmailPageOpen(USERNAME));
    }

    @Test
    @DisplayName("Logout from mail.yandex.com and validate it")
    void logOut() {
        emailPage.clickOnDropdownMenu();
        emailPage.clickOnLogOutButton();
        assertTrue(homePage.isLoginButtonPresented());
        homePage.makeScreenShot();
    }
}