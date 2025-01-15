package com.example;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;

public class LongPress extends BaseTest {

    @Test
    public void LongPressGesture() throws InterruptedException {

        driver.findElement(AppiumBy.accessibilityId("Views")).click();
        driver.findElement(AppiumBy.accessibilityId("Expandable Lists")).click();
        driver.findElement(AppiumBy.accessibilityId("1. Custom Adapter")).click();
        WebElement element = driver.findElement(By.xpath("//android.widget.TextView[@text='People Names']"));
        longPressAction(element);

        String text = driver
                .findElement(By.xpath(
                        "//android.widget.TextView[@resource-id=\"android:id/title\" and @text=\"Sample menu\"]"))
                .getText();

        Assert.assertEquals(text, "Sample menu");
        
        Assert.assertTrue(driver
                .findElement(By.xpath(
                        "//android.widget.TextView[@resource-id=\"android:id/title\" and @text=\"Sample menu\"]"))
                .isDisplayed());

    }
}
