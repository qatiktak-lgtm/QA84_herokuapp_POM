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
        new HomePage(driver).clickDragDrop();
        dragdrop = new Drag_DropPage(driver);
    }

    @Test
    public void dragDropTest(){
        dragdrop.dragAndDrop()
                .verifyDragDrop("A");

    }
}
