package com.herokuapp.pages;

import com.herokuapp.core.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class DropdownListPage extends BasePage {
    public DropdownListPage(WebDriver driver) {
        super(driver);
    }


    @FindBy(id = "dropdown")
    WebElement dropdownField;

    public DropdownListPage selectOptionByValue(String number) {
        new Select(dropdownField).selectByValue(number);
        return this;
    }

    public String getSelectedOptionText() {
        return new Select(dropdownField).getFirstSelectedOption().getText();
    }
}
