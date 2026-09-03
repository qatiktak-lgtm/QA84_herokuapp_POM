package com.herokuapp.tests;

import com.herokuapp.core.TestBase;
import com.herokuapp.pages.Drag_DropPage;
import com.herokuapp.pages.HomePage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class Drag_DropPageTest extends TestBase {

    Drag_DropPage dragdrop;

    @BeforeEach
    public void precondition() {
        dragdrop = new HomePage(driver).clickDragDrop();
    }

    @Test
    public void dragDropLeftToRightTest(){
        dragdrop.dragAndDropLR()
                .verifyDragDrop("A");
    }

    @Test
    public void dragDropRightToLeftTest(){
        dragdrop.dragAndDropRL()
                .verifyDragDrop("A");
    }
}
