package com.herokuapp.tests;

import com.herokuapp.core.TestBase;
import com.herokuapp.pages.HomePage;
import com.herokuapp.pages.MultipleWinPage;
import com.herokuapp.pages.javaScriptAlerts.NewWindowsPage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MultipleWinPageTest extends TestBase {

    MultipleWinPage multiWin;


    @BeforeEach
    public void precondition() {
        new HomePage(driver).clickMultipleWindows();
        multiWin = new MultipleWinPage(driver);
    }

    @Test
    public void newWindow(){
        multiWin.verifyHeder("Opening a new window")
                .clickOnLink();
        new NewWindowsPage(driver).switchToNewTab(1)
                .verifyWindowTitle("New Window");
    }

}
