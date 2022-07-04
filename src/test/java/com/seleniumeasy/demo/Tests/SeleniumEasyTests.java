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
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SeleniumEasyTests extends BaseTest {

    @Test
    @DisplayName("Select Multiple Options from Dropdown")
    void selectMultipleOptionsTest() {
        driver.navigate().to("https://demo.seleniumeasy.com/basic-select-dropdown-demo.html");
        Random random = new Random();
        Select select = new Select(driver.findElement(By.id("multi-select")));
        List<WebElement> webElements = select.getOptions();
        List<Integer> randomNumber = random
                .ints(0, webElements.size() - 1)
                .distinct()
                .limit(3)
                .boxed()
                .collect(Collectors.toList());
        List<String> selectedOptions = randomNumber.stream().map(index -> webElements.get(index).getText()).sorted().collect(Collectors.toList());
        List<String> actualOptions = new ArrayList<>();
        actualOptions.add(webElements.get(randomNumber.get(0)).getText());
        actualOptions.add(webElements.get(randomNumber.get(1)).getText());
        actualOptions.add(webElements.get(randomNumber.get(2)).getText());
        Collections.sort(actualOptions);
        assertEquals(actualOptions, selectedOptions);

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