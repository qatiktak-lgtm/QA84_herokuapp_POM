package com.herokuapp.tests;

import com.herokuapp.core.TestBase;
import com.herokuapp.pages.HomePage;
import com.herokuapp.pages.HorizontalSliderPage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class SliderTests extends TestBase {
    HorizontalSliderPage sliderPage;
    @BeforeEach
    public void precondition(){
        sliderPage = new HomePage(driver).getHorizontalSlider();
    }

    @Test
    public void sliderTest (){
        sliderPage.moveSlider()
                .verifySliderValue("5");
    }

    @Test
    public void sliderMoveToValue(){
        sliderPage.moveSliderTo(1.5)
                .verifySliderValue("1.5");
    }
}
