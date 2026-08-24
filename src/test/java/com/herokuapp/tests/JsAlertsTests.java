package com.herokuapp.tests;

import com.herokuapp.core.TestBase;
import com.herokuapp.pages.HomePage;
import com.herokuapp.pages.javaScriptAlerts.JsAlertsPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class JsAlertsTests extends TestBase {

    JsAlertsPage alerts;

    @BeforeEach
    public void precondition(){
        new HomePage(driver).clickJavaScriptAlerts();
        alerts = new JsAlertsPage(driver);
    }

    @Test
    public void CheckJsAlertButton(){
        alerts.clickAlertButton();
        //Thread.sleep(3000);
        boolean result = alerts.isAlertPresent(5);
       assertTrue(result);
    }

    @Test
    public void CheckJsConfirmButtonWithOk() {
        alerts.clickConfirmButton();
        alerts.clickOnResult("OK").verifyResult("Ok");
    }
    @Test
    public void CheckJsConfirmButtonWithCancel() {
        alerts.clickConfirmButton();
        alerts.clickOnResult("Cancel").verifyResult("Cancel");
    }


    @Test
    public void CheckJsPromptButtonWithOk(){
        alerts.clickPromptButton();
        alerts.manualDataEntry("~~A=B^C'7", "Ok")
        .verifyResult("~~A=B^C'7");
    }
    @Test
    public void CheckJsPromptButtonWithOkWithoutText(){
        alerts.clickPromptButton();
        alerts.manualDataEntry("", "Ok")
                .verifyResult("");
    }

    @Test
    public void CheckJsPromptButtonWithCancel(){
        alerts.clickPromptButton();
        alerts.manualDataEntry("ABC7", "Cancel")
                .verifyResult("null");
    }


}
