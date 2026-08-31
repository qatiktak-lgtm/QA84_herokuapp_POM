package com.herokuapp.core;

import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeoutException;

public abstract class BasePage {
    protected WebDriver driver;
    protected WebDriverWait wait;
    protected static final Logger logger =
            LoggerFactory.getLogger(BasePage.class);
    public static JavascriptExecutor js;
    public static SoftAssertions softly;
    protected static Actions actions;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
        js = (JavascriptExecutor) driver;
        softly = new SoftAssertions();
        actions = new Actions(driver);
    }

    public void click(WebElement element) {
        element.click();
    }

    public void type(WebElement element, String text) {
        if (text != null) {
            click(element);
            element.clear();
            element.sendKeys(text);
            logger.info("Typed text: " + text);
        }
    }

    public boolean isElementPresent(WebElement element) {
        try {
            return element.isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }


    public String getAttribute(WebElement element, String attributeName) {
        return element.getAttribute(attributeName);
    }

    public boolean isContainsText(String text, WebElement element) {
        return wait.until(ExpectedConditions.textToBePresentInElement(element, text));
    }

    public String getValue(WebElement element) {
        return element.getText();
    }


}
