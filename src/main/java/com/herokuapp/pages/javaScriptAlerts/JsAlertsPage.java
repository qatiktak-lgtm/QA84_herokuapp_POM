package com.herokuapp.pages.javaScriptAlerts;

import com.herokuapp.core.BasePage;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.Alert;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class JsAlertsPage extends BasePage {
    public JsAlertsPage(WebDriver driver) {
        super(driver);
    }


    @FindBy(css = "button[onclick='jsAlert()']")
    WebElement buttonJsAlert;

    public JsAlertsPage clickAlertButton() {
        click(buttonJsAlert);
        return this;
    }

    public boolean isAlertPresent(int time) {
        try {
            Alert alert = new WebDriverWait(driver, Duration.ofSeconds(time))
                    .until(ExpectedConditions.alertIsPresent());
            alert.accept();
            logger.info("Alert found and accepted");
            return true;
        } catch (Exception e) {
            logger.info("Alert not found within " + time + " seconds");
            return false;
        }
    }

    @FindBy(css = "button[onclick='jsConfirm()']")
    WebElement buttonJsConfirm;

    public JsAlertsPage clickConfirmButton() {
        click(buttonJsConfirm);
        return this;
    }

    public JsAlertsPage clickOnResult(String result) {
        if (result != null && result.equalsIgnoreCase("OK")) {
            driver.switchTo().alert().accept();
            logger.info("Prompt - OK clicked");
        } else if (result != null && result.equalsIgnoreCase("Cancel")) {
            driver.switchTo().alert().dismiss();
            logger.info("Prompt - Cancel clicked");
        }
        return this;
    }

    @FindBy(id = "result")
    WebElement confirmResult;
    public JsAlertsPage verifyResult(String text) {
        Assertions.assertTrue(isContainsText(text, confirmResult));
        logger.info("Result verified: " + text);
        return this;
    }

    @FindBy(css = "button[onclick='jsPrompt()']")
    WebElement buttonJsPrompt;
    public JsAlertsPage clickPromptButton() {
        click(buttonJsPrompt);
        return this;
    }

    public JsAlertsPage manualDataEntry(String text, String action) {
        Alert alert = new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.alertIsPresent());
        alert.sendKeys(text);
        logger.info("Text entered: " + text);
        if ("OK".equalsIgnoreCase(action)) {
            alert.accept();
            logger.info("Prompt - OK clicked");
        } else if ("Cancel".equalsIgnoreCase(action)) {
            alert.dismiss();
            logger.info("Prompt - Cancel clicked");
        }
        return this;
    }
}
