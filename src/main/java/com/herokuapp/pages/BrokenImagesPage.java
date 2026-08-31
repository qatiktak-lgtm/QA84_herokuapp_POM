package com.herokuapp.pages;

import com.herokuapp.core.BasePage;
import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
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
            String imageUrl = image.getAttribute("src");
            verifyLink(imageUrl);

            if (!isImageLoaded(image)) {
                brokenImages.add(imageUrl);
            }
        }
        if (!brokenImages.isEmpty()) {
            softly.fail("Broken images found: " + brokenImages);
        }
        softly.assertAll();
        return this;
    }

    private void verifyLink(String imageUrl) {
        try {
            HttpURLConnection connection = (HttpURLConnection) new URL(imageUrl).openConnection();
            connection.setConnectTimeout(5000);
            connection.setInstanceFollowRedirects(true);

            int statusCode = connection.getResponseCode();

            if (statusCode >= 400) {
                softly.fail(imageUrl + " --> " + connection.getResponseMessage());
            }
        } catch (MalformedURLException e) {
            softly.fail(imageUrl + " --> Invalid URL: " + e.getMessage());
        } catch (IOException e) {
            softly.fail(imageUrl + " --> Network error: " + e.getMessage());
        }
    }

    private boolean isImageLoaded(WebElement image) {
        try {
            return (Boolean) js.executeScript(
                    "return (typeof arguments[0].naturalWidth!=undefined && arguments[0].naturalWidth>0);",
                    image);
        } catch (Exception e) {
            return false;
        }
    }
    
    
}
