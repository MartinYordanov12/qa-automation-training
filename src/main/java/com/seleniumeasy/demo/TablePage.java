package com.seleniumeasy.demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;

public class TablePage extends BasePage {
    private static final String BASE_URL = "https://demo.seleniumeasy.com/table-sort-search-demo.html";
    private static final By DROP_DOWN = By.name("example_length");

    public TablePage(WebDriver driver) {
        super(driver);
    }

    public void navigateToBaseURL() {
        navigateTo(BASE_URL);
    }

    public void selectOptionFromDropDown(String value) {
        Select select = new Select(driver.findElement(DROP_DOWN));
        select.selectByValue(value);
    }

    public List<Person> getUsersWithConditions(int minAge, int maxSalary) {
        List<Person> person = new ArrayList<>();
        do {
            WebElement nextButton = driver.findElement(By.cssSelector(".next"));
            collectUsersWithConditions(person, minAge, maxSalary);
            nextButton.click();
        } while (driver.findElement(By.cssSelector(".next")).getAttribute("class").contains("disabled"));
        return person;
    }

    private void collectUsersWithConditions(List<Person> users, int minAge, int maxSalary) {
        List<WebElement> rows = driver.findElements(By.cssSelector("tbody tr"));
        rows.forEach(row -> {
            int salary = Integer.parseInt(row.findElement(By.xpath("td[6]")).getAttribute("data-order"));
            int age = Integer.parseInt(row.findElement(By.xpath("td[4]")).getText());
            if (salary <= maxSalary && age > minAge) {
                String name = row.findElement(By.xpath("td[1]")).getText();
                String position = row.findElement(By.xpath("td[2]")).getText();
                String office = row.findElement(By.xpath("td[3]")).getText();
                users.add(new Person(name, position, office));
            }
        });
    }
}