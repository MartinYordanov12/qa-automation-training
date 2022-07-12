package com.yandex.Tests;

import com.yandex.pages.EmailPage;
import com.yandex.pages.HomePage;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import jdk.jfr.Description;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

@Epic("Login Tests")
@Feature("Login and logout tests")

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
    @Story("User tries to login with valid credentials")
    @Description("Valid login Test with valid username and password")
    @DisplayName("Login in mail.yandex.com and validate page open")
    void loginTest() {
        emailPage.clickOnDropdownMenu();
        assertTrue(emailPage.isEmailPageOpen(USERNAME));
    }

    @Test
    @Story("User tries to logout")
    @Description("Click on logout button and verify that the user is logout")
    @DisplayName("Logout from mail.yandex.com and validate it")
    void logOut() {
        emailPage.clickOnDropdownMenu();
        emailPage.clickOnLogOutButton();
        assertTrue(homePage.isLoginButtonPresented());
    }
}