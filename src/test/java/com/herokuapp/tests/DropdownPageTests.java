package com.herokuapp.tests;

import com.herokuapp.core.TestBase;
import com.herokuapp.pages.DropdownListPage;
import com.herokuapp.pages.HomePage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class DropdownPageTests extends TestBase {

    DropdownListPage dropdown;

    @BeforeEach
    public void precondition(){
        new HomePage(driver).clickDropdown();
        dropdown = new DropdownListPage(driver);
    }

    @Test
    public void dropdownTest(){
        dropdown.selectOptionByValue("2");
        String text = dropdown.getSelectedOptionText();
        Assertions.assertEquals("Option 2", text);
    }
}
