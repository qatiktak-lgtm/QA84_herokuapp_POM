package com.herokuapp.tests;

import com.herokuapp.core.TestBase;
import com.herokuapp.pages.FrameSetPage;
import com.herokuapp.pages.FramesPage;
import com.herokuapp.pages.HomePage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class NestedFramesTests extends TestBase {

    FramesPage frames;
    FrameSetPage setFrames;

    @BeforeEach
    public void precondition() {
        new HomePage(driver).clickFrames();
        frames = new FramesPage(driver);
        setFrames = new FrameSetPage(driver);
    }

    @Test
    public void framesTest() {
        frames.verifyHeader("Frames")
                .clickOnLink()
                .switchToNewTab(0);
        setFrames.verifyIsFrameSetPage();
    }

    @Test
    public void nextFramesTest(){
        frames.clickOnLink().switchToNewTab(0);
                setFrames.verifyTopFrame("frame-top")
                .verifyFrameByText("LEFT")
                .verifyFrameByText("MIDDLE")
                .verifyFrameByText("RIGHT")
                .verifyBottomFrame("BOTTOM");
    }

}
