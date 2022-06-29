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
    private static final By NEXT_BUTTON = By.id("example_next");
    private static final By TABLE = By.cssSelector("#example");
    private static final By TABLE_ROWS = By.cssSelector("#example tr.odd,tr.even");
    private static final By PAGE_COUNTER = By.className("paginate_button");

    public TablePage(WebDriver driver) {
        super(driver);
    }

    public TablePage navigateToBaseURL() {
        navigateTo(BASE_URL);
        return this;
    }

    public TablePage selectOptionFromDropDown(String value) {
        Select select = new Select(driver.findElement(DROP_DOWN));
        select.selectByValue(value);
        return this;
    }

    public List<Person> getAllPeopleWithAgeAndSalary(int age, double salary) {
        List<Person> result = new ArrayList<>();
        int pagesCounter = driver.findElements(PAGE_COUNTER).size();
        for (int i = 0; i <= pagesCounter - 2; i++) {
            List<WebElement> tableRows = driver.findElements(TABLE_ROWS);


            for (WebElement element : tableRows) {
                List<WebElement> listOfElements = element.findElements(By.tagName("td"));
                String salaryWithSymbols = listOfElements.get(5).getText();
                //DecimalFormat formatter = new DecimalFormat("#0.000");
                String subSalary = salaryWithSymbols.substring(salaryWithSymbols.indexOf('$') + 1, salaryWithSymbols.indexOf('/'))
                        .replace(',', '.');

                double salaryD = (subSalary.length() > 7) ?
                        Double.parseDouble(subSalary.replace(".", "")) : Double.parseDouble(subSalary);
                //String salaryWithoutSymbols = salaryWithSymbols.replaceAll("[/$y]", "").replace(",", ".");
                //Double salaryInDigit = Double.parseDouble(salaryWithoutSymbols);
                if (Integer.parseInt(listOfElements.get(3).getText()) > age && salaryD <= salary) {
                    String name = listOfElements.get(0).getText();
                    String position = listOfElements.get(1).getText();
                    String office = listOfElements.get(2).getText();
                    Person person = new Person(name, position, office);
                    result.add(person);

                }

            }
            driver.findElement(NEXT_BUTTON).click();
        }
        return result;
    }
}

