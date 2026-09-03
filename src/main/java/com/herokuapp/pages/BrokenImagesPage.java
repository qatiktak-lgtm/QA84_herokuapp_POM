package com.herokuapp.pages;

import com.herokuapp.core.BasePage;
import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import java.util.ArrayList;
import java.util.List;

public class BrokenImagesPage extends BasePage {

    public BrokenImagesPage(WebDriver driver) {
        super(driver);
    }

    private SoftAssertions softly = new SoftAssertions();

    @FindBy(css = "img")
    List<WebElement> images;

    public BrokenImagesPage checkBrokenImages() {
        List<String> brokenImages = new ArrayList<>();
        System.out.println("Total images on the page = " + images.size());
        for (WebElement image : images) {
            String imageUrl = image.getDomAttribute("src");
            String imageName = image.getDomAttribute("alt");

            System.out.println("Image name: " + imageName + " | URL: " + imageUrl);
            verifyLink(imageUrl);

            if (!isImageLoaded(image)) {
                brokenImages.add(imageUrl);
            }
        }
        if (!brokenImages.isEmpty()) {
            softly.fail("Broken links images found: " + brokenImages);
            System.out.println("~".repeat(90));
        }
        softly.assertAll();
        return this;
    }
}
