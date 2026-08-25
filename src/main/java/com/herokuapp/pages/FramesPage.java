package com.herokuapp.pages;

import com.herokuapp.core.BasePage;
import com.herokuapp.pages.javaScriptAlerts.NewWindowsPage;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class FramesPage extends BasePage {
    public FramesPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "div[class='example'] h3")
    WebElement header;
    public FramesPage verifyHeader(String text) {
        Assertions.assertTrue(isContainsText(text, header));
        logger.info("Result verified: " + text);
        return this;
    }


    @FindBy(css = "a[href='/nested_frames']")
    WebElement nestedFrames;
    public FramesPage clickOnLink() {
        click(nestedFrames);
        return this;
    }

    public FramesPage switchToNewTab(int index) {
        List<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(index));
        return this;
    }
}
