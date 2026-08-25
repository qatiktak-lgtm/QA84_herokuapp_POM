package com.herokuapp.pages;

import com.herokuapp.core.BasePage;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.Locale;

public class FrameSetPage extends BasePage {
    public FrameSetPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//frameset")
    List<WebElement> framesets;
    public FrameSetPage verifyIsFrameSetPage() {
        Assertions.assertFalse(framesets.isEmpty(), "Тег frameset не найден на странице!");
        return this;
    }


    @FindBy (css = "frame[name='frame-top']")
    WebElement topFrame;
    public FrameSetPage verifyTopFrame(String text) {
        Assertions.assertEquals(text, topFrame.getAttribute("name"));
        logger.info("Frame successfully verified: "
                + topFrame + " with the text: " + text);
        return this;

    }

    public FrameSetPage verifyFrameByText(String frameName) {
        try {
        driver.switchTo().frame("frame-top");
        String findFrameName = "frame-" + frameName.toLowerCase();
        driver.switchTo().frame(findFrameName);
        WebElement body = driver.findElement(By.tagName("body"));
        String expectedText = frameName.toUpperCase();
        Assertions.assertTrue(isContainsText(expectedText, body),
                "Text '" + expectedText
                        + "' not found in the frame " + findFrameName);
        logger.info("Frame successfully verified: "
                + findFrameName + " with the text: " + expectedText);
    } finally {
                driver.switchTo().defaultContent();
    }
        return this;
    }


    public FrameSetPage verifyBottomFrame(String text) {
        driver.switchTo().frame("frame-bottom");
        String nameFrame = driver.findElement(By.cssSelector("body")).getText();
        Assertions.assertEquals(text, nameFrame);
        logger.info("Frame successfully verified: "
                + nameFrame + " with the text: " + text);
        return this;
    }
}
