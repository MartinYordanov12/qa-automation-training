package com.seleniumeasy.demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class MultiSelectPage extends BasePage{
    private static final String BASE_URL = "https://demo.seleniumeasy.com/basic-select-dropdown-demo.html";
    private static final By DROPDOWN = By.id("multi-select");
    private static final By GET_ALL_SELECTED_BUTTON = By.id("printAll");
    private static final By OPTIONS_SELECTED_ARE = By.className("getall-selected");
    Random random = new Random();


    public MultiSelectPage(WebDriver driver) {
        super(driver);
    }

    public MultiSelectPage navigateToSelectMultipleDropdownOptions(){
        navigateTo(BASE_URL);
        return this;
    }

    public boolean selectThreeRandomOptions(){
        Select select = new Select(driver.findElement(DROPDOWN));
        List<WebElement> webElements = select.getOptions();
        List<Integer> randomNumber = random
                .ints(0,webElements.size() - 1)
                .distinct()
                .limit(3)
                .boxed()
                .collect(Collectors.toList());
        /*List<String> expectedText = randomNumber.stream().map(index -> webElements.get(index).getText()).sorted().collect(Collectors.toList());*/
        select.selectByIndex(randomNumber.get(0));
        select.selectByIndex(randomNumber.get(1));
        select.selectByIndex(randomNumber.get(2));
        List<String> selectedOptions = select
                .getAllSelectedOptions()
                .stream()
                .map(webElement -> webElement.getText())
                .collect(Collectors.toList());
        List<String> actualOptions = new ArrayList<>();
        actualOptions.add(webElements.get(randomNumber.get(0)).getText());
        actualOptions.add(webElements.get(randomNumber.get(1)).getText());
        actualOptions.add(webElements.get(randomNumber.get(2)).getText());
        Collections.sort(actualOptions);
        selectedOptions.forEach(System.out::println);
        System.out.println("-------------------");
        actualOptions.forEach(System.out::println);

        if(actualOptions.equals(selectedOptions)){
            return true;
        }
        return false;
    }
}