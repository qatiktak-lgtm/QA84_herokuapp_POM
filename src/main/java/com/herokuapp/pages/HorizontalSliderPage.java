package com.herokuapp.pages;

import com.herokuapp.core.BasePage;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HorizontalSliderPage extends BasePage {
    public HorizontalSliderPage(WebDriver driver) {
        super(driver);
    }

@FindBy(css = "input[type='range']")
    WebElement rangeSlider;
    public HorizontalSliderPage moveSlider() {
        //actions.dragAndDropBy(rangeSlider,50,0).perform();
        rangeSlider.sendKeys(Keys.END);
        //rangeSlider.sendKeys(Keys.PAGE_UP);
        return this;
    }

    public HorizontalSliderPage moveSliderTo(double value) {
        rangeSlider.sendKeys(Keys.HOME);
        for (int i = 0; i < value*2; i++) {
            rangeSlider.sendKeys(Keys.ARROW_RIGHT);
        }
        return this;
    }


    @FindBy(xpath = "//span[@id='range']")
    WebElement sliderValue;
    public HorizontalSliderPage verifySliderValue(String number) {
        Assertions.assertEquals(number,getValue(sliderValue));
        return this;
    }

}
