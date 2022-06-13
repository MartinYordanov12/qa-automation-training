package com.yandex.Tests;

import com.yandex.Pages.EmailPage;
import com.yandex.Pages.HomePage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class LoginTest extends BaseTest {

    @Test
    @DisplayName("Login in mail.yandex.com and validate page open")
    void loginTest() {
        HomePage homePage = new HomePage(driver);
        EmailPage emailPage = homePage
                .navigateToHomePage()
                .clickOnLoginButton()
                .fillUserNameField("yordanovm")
                .clickUsernameFormLoginButton()
                .fillPasswordField("Dieselron")
                .clickPasswordFormLoginButton();


        assertTrue(emailPage.isEmailPageOpen());
    }
}