package com.herokuapp.tests;

import com.herokuapp.core.TestBase;
import com.herokuapp.pages.HomePage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class HomePageTest extends TestBase {

    private HomePage homePage;

    @BeforeEach
    public void setupHomePage(){
        homePage = new HomePage(driver);
    }

    @Test
    public void findJavaScriptAlertsItemPositiveTest() throws InterruptedException {
        if (homePage.isElementJavaScriptAlertsPresent()){
            System.out.println("The menu item 'JavaScript Alerts' is present");
            homePage.clickJavaScriptAlerts();

            //Thread.sleep(2000);
        }
    }
}
