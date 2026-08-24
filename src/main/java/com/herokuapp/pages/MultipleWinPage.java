package com.herokuapp.pages;

import com.herokuapp.core.BasePage;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MultipleWinPage extends BasePage {
    public MultipleWinPage(WebDriver driver) {
        super(driver);
    }


    @FindBy(css = "div[class='example'] h3")
    WebElement header;
    public MultipleWinPage verifyHeder(String text) {
        Assertions.assertTrue(isContainsText(text, header));
        logger.info("Result verified: " + text);
        return this;
    }

    @FindBy(css = "a[href='/windows/new']")
    WebElement clickHere;

    public MultipleWinPage clickOnLink() {
        click(clickHere);
        return this;
    }
}

