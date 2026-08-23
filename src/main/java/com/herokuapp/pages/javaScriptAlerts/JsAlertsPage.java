package com.herokuapp.pages.javaScriptAlerts;

import com.herokuapp.core.BasePage;
import com.herokuapp.pages.HomePage;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.Alert;
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
    public JsAlertsPage getAlerts() {
        click(buttonJsAlert);
        return this;
    }

    public JsAlertsPage clickOnButton(String button) {

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
}
