package com.herokuapp.pages;

import com.herokuapp.core.BasePage;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class Drag_DropPage extends BasePage {
    public Drag_DropPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id="column-a")
    WebElement source;
    @FindBy(id="column-b")
    WebElement target;

    public Drag_DropPage dragAndDrop() {
        Actions actions = new Actions(driver);
        actions.dragAndDrop(source, target).perform();
        return this;
    }

    public Drag_DropPage verifyDragDrop() {
        Assertions.assertEquals("A", target.getText());
        return this;
    }
}
