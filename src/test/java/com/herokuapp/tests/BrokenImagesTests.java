package com.herokuapp.tests;

import com.herokuapp.core.TestBase;
import com.herokuapp.pages.BrokenImagesPage;
import com.herokuapp.pages.HomePage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class BrokenImagesTests extends TestBase {

    BrokenImagesPage brokenImagesPage;

    @BeforeEach
    public void precondition() {
        brokenImagesPage = new BrokenImagesPage(driver);
        new HomePage(driver).getImagesPage();
    }

    @Test
    public void BrokenImagesTest() {
        brokenImagesPage.checkBrokenImages();
    }

}
