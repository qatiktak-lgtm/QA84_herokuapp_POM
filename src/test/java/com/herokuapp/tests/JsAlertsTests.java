package com.herokuapp.tests;

import com.herokuapp.core.TestBase;
import com.herokuapp.pages.HomePage;
import com.herokuapp.pages.javaScriptAlerts.JsAlertsPage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

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
        alerts.getAlerts();
       boolean result = alerts.isAlertPresent(2);
       assertTrue(result);

    }
}
