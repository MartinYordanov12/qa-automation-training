package com.yandex.Tests;

import com.yandex.pages.EmailPage;
import com.yandex.pages.HomePage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class LoginTest extends BaseTest {
    EmailPage emailPage = new EmailPage(driver);
    HomePage homePage = new HomePage(driver);

    @Test
    @DisplayName("Login in mail.yandex.com and validate page open")
    void loginTest() {
        HomePage homePage = new HomePage(driver);
        EmailPage emailPage = new EmailPage(driver);
        homePage
                .navigateToHomePage()
                .clickOnLoginButton()
                .login();

        emailPage.clickOnDropdownMenu();
        assertTrue(emailPage.isEmailPageOpen());
    }

    @Test
    @DisplayName("Logout from mail.yandex.com and validate it")
    void logOut() {
        emailPage.clickOnLogOutButton();
        assertTrue(homePage.isLoginButtonPresented());
    }
}