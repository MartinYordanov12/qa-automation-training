package com.seleniumeasy.demo.Tests;

import com.seleniumeasy.demo.AlertPage;
import com.seleniumeasy.demo.MultiSelectPage;
import com.seleniumeasy.demo.Person;
import com.seleniumeasy.demo.RefreshPage;
import com.seleniumeasy.demo.TablePage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MultiSelectTest extends BaseTest {
    @Test
    @DisplayName("Select Multiple Options from Dropdown")
    void selectMultipleOptions() {
        MultiSelectPage multiSelectPage = new MultiSelectPage(driver);
        multiSelectPage.navigateToSelectMultipleDropdownOptions();
        assertTrue(multiSelectPage.selectThreeRandomOptions());

    }

    @Test
    void alertTests() {
        AlertPage alertPage = new AlertPage(driver);
        alertPage.navigateToAlertPage();
        assertAll(() -> assertTrue(alertPage.javaScriptAlertBox(), "Ok button is not clicked"),
        () -> assertTrue(alertPage.javaScriptConfirmBoxAccept(), "Ok button is not clicked"),
        () -> assertTrue(alertPage.javaScriptConfirmBoxDismiss(), "Cancel button is not clicked"),
        () ->assertTrue(alertPage.javaScriptAlertBoxNameCheck(), "Name is not entered"));

    }
    @Test
    void refreshTest() throws InterruptedException {
        RefreshPage refreshPage = new RefreshPage(driver);
        refreshPage.navigateToRefreshPage();
        refreshPage.clickDownloadButton();
        refreshPage.refreshPageOnFiftyPercentOfLoadBar();
        driver.navigate().refresh();
        Thread.sleep(2000);
        assertEquals("0%", refreshPage.getLoadBarValue());
    }

    @Test
    void tableTest(){
        TablePage tablePage = new TablePage(driver);
        tablePage.navigateToBaseURL();
        tablePage.selectOptionFromDropDown("10");
        List<Person> allPeopleWithAgeAndSalary = tablePage.getAllPeopleWithAgeAndSalary(30, 100.000);
        for (int i =0; i <= allPeopleWithAgeAndSalary.size() - 1; i++){
            Person index = allPeopleWithAgeAndSalary.get(i);
            System.out.println(index);
        }
    }
}