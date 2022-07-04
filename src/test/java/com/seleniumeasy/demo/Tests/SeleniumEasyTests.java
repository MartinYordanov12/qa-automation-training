package com.seleniumeasy.demo.Tests;

import com.seleniumeasy.demo.AlertPage;
import com.seleniumeasy.demo.Person;
import com.seleniumeasy.demo.RefreshPage;
import com.seleniumeasy.demo.TablePage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SeleniumEasyTests extends BaseTest {

    private static final By DROPDOWN = By.id("multi-select");

    @Test
    @DisplayName("Select Multiple Options from Dropdown")
    void selectMultipleOptionsTest() {
        driver.navigate().to("https://demo.seleniumeasy.com/basic-select-dropdown-demo.html");

        Select multiSelect = new Select(driver.findElement(DROPDOWN));
        Random random = new Random();
        List<Integer> number = random
                .ints(0, 7)
                .limit(3)
                .boxed()
                .collect(Collectors.toList());

        List<String> expectedList = new ArrayList<>();
        if (multiSelect.isMultiple()) {
            for (Integer index : number) {
                multiSelect.selectByIndex(index);
                Select select = new Select(driver.findElement(DROPDOWN));
                expectedList = select.getAllSelectedOptions().stream().map(WebElement::getText).collect(Collectors.toList());
            }
        }

        List<String> actualList = multiSelect.getAllSelectedOptions().stream().map(WebElement::getText).collect(Collectors.toList());
        assertTrue(actualList.containsAll(expectedList));
    }

    @Test
    void acceptJavaScriptConfirmBoxTest() {
        AlertPage alertPage = new AlertPage(driver);
        alertPage.navigateToAlertPage();
        alertPage.clickAcceptButtonJavaScriptConfirmBox();
        String actualMessage = alertPage.getTextMessageFromJavaScriptConfirmBox();
        assertEquals("You pressed OK!", actualMessage);
    }

    @Test
    void dismissJavaScriptConfirmBoxTest() {
        AlertPage alertPage = new AlertPage(driver);
        alertPage.navigateToAlertPage();
        alertPage.clickDismissButtonJavaScriptConfirmBox();
        assertEquals("You pressed Cancel!", alertPage.getTextMessageFromJavaScriptConfirmBox());
    }

    @Test
    void enterNameJavaScriptAlertBoxTest() {
        AlertPage alertPage = new AlertPage(driver);
        alertPage.navigateToAlertPage();
        alertPage.enterNameAndClickOnOKButtonJavaScriptAlertBox();
        String actualResult = alertPage.getNameJavaScriptAlertBox();
        assertEquals("You have entered 'Martin' !", actualResult);
    }


    @Test
    void refreshTest() {
        RefreshPage refreshPage = new RefreshPage(driver);
        refreshPage.navigateToRefreshPage();
        refreshPage.clickDownloadButton();
        refreshPage.checkPageOnFiftyPercentOfLoadBar();
        driver.navigate().refresh();
    }

    @Test
    void tableTest() {
        TablePage tablePage = new TablePage(driver);
        tablePage.navigateToBaseURL();
        tablePage.selectOptionFromDropDown("10");
        List<Person> allPeopleWithAgeAndSalary = tablePage.getUsersWithConditions(30, 200000);
        for (int i = 0; i <= allPeopleWithAgeAndSalary.size() - 1; i++) {
            Person index = allPeopleWithAgeAndSalary.get(i);
            System.out.println(index);
        }
    }
}