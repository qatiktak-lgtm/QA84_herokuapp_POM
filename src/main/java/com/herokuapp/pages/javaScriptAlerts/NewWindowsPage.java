package com.herokuapp.pages.javaScriptAlerts;

import com.herokuapp.core.BasePage;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import java.util.ArrayList;
import java.util.List;

public class NewWindowsPage extends BasePage {
    public NewWindowsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "div[class='example'] h3")
    WebElement title;

    public NewWindowsPage verifyWindowTitle(String text) {
        Assertions.assertTrue(isContainsText(text, title));
        logger.info("Result verified: " + text);
        return this;
    }

    public NewWindowsPage switchToNewTab(int index) {
        List<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(index));
        return this;
    }
}
