package com.yandex.Tests;

import com.yandex.pages.EmailPage;
import com.yandex.pages.HomePage;
import io.qameta.allure.Allure;
import io.qameta.allure.AllureId;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import jdk.jfr.Description;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(TestWatcherResult.class)
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
        Allure.addAttachment("Browser name", browserName);
        Allure.addAttachment("Browser version", browserVersion);
    }

    @Test
    @Story("User tries to login with valid credentials")
    @Description("Valid login Test with valid username and password")
    @AllureId("1")
    void loginTest() {
        emailPage.clickOnDropdownMenu();
        assertTrue(emailPage.isEmailPageOpen(USERNAME));
    }

    @Test
    @Story("User tries to logout")
    @Description("Click on logout button and verify that the user is logout")
    @AllureId("2")
    void logOut() {
        emailPage.clickOnDropdownMenu();
        emailPage.clickOnLogOutButton();
        Assertions.assertEquals("Google", driver.getTitle());

    }
}