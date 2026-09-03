package com.herokuapp.tests;

import com.herokuapp.core.TestBase;
import com.herokuapp.pages.DropdownListPage;
import com.herokuapp.pages.HomePage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class DropdownPageTests extends TestBase {

    DropdownListPage dropdown;

    @BeforeEach
    public void precondition() {
        dropdown = new HomePage(driver).clickDropdown();
    }

    @ParameterizedTest
    @CsvSource({
            "1, Option 1",
            "2, Option 2"
    })
    public void dropdownTest(String value, String expectedText) {
        dropdown.selectOptionByValue(value);
        String text = dropdown.getSelectedOptionText();
        Assertions.assertEquals(expectedText, text);
    }
}
