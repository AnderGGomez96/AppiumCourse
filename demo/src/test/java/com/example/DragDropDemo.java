package com.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;


import io.appium.java_client.AppiumBy;

public class DragDropDemo extends BaseTest {

    @Test
    public void DragDropTest() {
        driver.findElement(AppiumBy.accessibilityId("Views")).click();
        driver.findElement(AppiumBy.accessibilityId("Drag and Drop")).click();

        WebElement source = driver.findElement(By.id("io.appium.android.apis:id/drag_dot_1"));

        dragDropGesture(source, 627, 600);

       String resultText = driver.findElement(By.id("io.appium.android.apis:id/drag_result_text")).getText();
       Assert.assertEquals(resultText, "Dropped!");     
    }

}
