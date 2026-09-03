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
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;


public abstract class BasePage {
    protected WebDriver driver;
    protected WebDriverWait wait;
    protected static final Logger logger =
            LoggerFactory.getLogger(BasePage.class);
    protected JavascriptExecutor js;
    protected SoftAssertions softly;
    protected Actions actions;

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


    protected void verifyLink(String imageUrl) {
        try {
            HttpURLConnection connection = (HttpURLConnection) new URL(imageUrl).openConnection();
            connection.setConnectTimeout(5000);
            connection.setInstanceFollowRedirects(true);

            int statusCode = connection.getResponseCode();

            if (statusCode >= 400) {
                softly.fail(imageUrl + " --> " + connection.getResponseMessage());
            }
        } catch (MalformedURLException e) {
            softly.fail(imageUrl + " --> Invalid URL: " + e.getMessage());
        } catch (IOException e) {
            softly.fail(imageUrl + " --> Network error: " + e.getMessage());
        }
    }

    protected boolean isImageLoaded(WebElement image) {
        try {
            return (Boolean) js.executeScript(
                    "return (typeof arguments[0].naturalWidth!=undefined && arguments[0].naturalWidth>0);",
                    image);
        } catch (Exception e) {
            return false;
        }
    }
}
