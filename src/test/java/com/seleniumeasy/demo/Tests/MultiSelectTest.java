package com.seleniumeasy.demo.Tests;

import com.seleniumeasy.demo.MultiSelectPage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MultiSelectTest extends BaseTest{
    @Test
    @DisplayName("Select Multiple Options from Dropdown")
    void selectMultipleOptions(){
        MultiSelectPage multiSelectPage= new MultiSelectPage(driver);
        multiSelectPage.navigateToSelectMultipleDropdownOptions();
        assertTrue(multiSelectPage.selectThreeRandomOptions());

    }
}
