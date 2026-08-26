package com.herokuapp.pages;

import com.herokuapp.core.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class HomePage extends BasePage {

    public HomePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//*[contains(text(), 'Powered by')]")
    private WebElement poweredByText;

    private static final String ELEMENTAL_SELENIUM_URL =
            "http://elementalselenium.com/";

    @FindBy(xpath = "//a[contains(text(), 'Elemental Selenium')]")
    private WebElement elementalSeleniumLink;

    public String getElementalSeleniumHref() {
        return getAttribute(elementalSeleniumLink, "href");
    }

    public boolean isElementalSeleniumLinkCorrect() {
        String href = getElementalSeleniumHref();
        return href.equals(ELEMENTAL_SELENIUM_URL);
    }

    public boolean isPoweredByTextPresent() {
        return isElementPresent(poweredByText);
    }

    public void verifyPoweredBySection() {
        assertTrue(isPoweredByTextPresent(),
                "'Powered by' inscription not found!");
        assertTrue(isElementalSeleniumLinkCorrect(),
                "The link does not lead to: " + ELEMENTAL_SELENIUM_URL);
        System.out.println("~".repeat(90));
        System.out.println("The link is valid and leads to: " + ELEMENTAL_SELENIUM_URL + "The Tsar—the real one!");
    }

    @FindBy(css = "a[href='/javascript_alerts']")
    WebElement itemJavaScriptAlerts;

    public boolean isElementJavaScriptAlertsPresent() {
        return isElementPresent(itemJavaScriptAlerts);
    }

    public void clickJavaScriptAlerts() {
        click(itemJavaScriptAlerts);
    }

    @FindBy(css = "a[href='/windows']")
    WebElement windows;

    public void clickMultipleWindows() {
        click(windows);
    }

    @FindBy(css = "a[href='/frames']")
    WebElement frames;

    public void clickFrames() {
        click(frames);
    }

    @FindBy(css = "a[href='/dropdown']")
    WebElement dropdownLocator;

    public DropdownListPage clickDropdown() {
        click(dropdownLocator);
        return new DropdownListPage(driver);
    }

    @FindBy(css = "a[href='/drag_and_drop']")
    WebElement drag_and_drop;
    public Drag_DropPage clickDragDrop() {
        click(drag_and_drop);
        return new Drag_DropPage(driver);
    }
}
