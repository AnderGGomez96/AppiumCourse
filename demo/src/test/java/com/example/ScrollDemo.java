package com.example;

import org.testng.Assert;
import org.testng.annotations.Test;


import io.appium.java_client.AppiumBy;


public class ScrollDemo extends BaseTest {
    @Test
    public void ScrollDemoTest(){
        driver.findElement(AppiumBy.accessibilityId("Views")).click();
        driver.findElement(AppiumBy.androidUIAutomator(
            scrollAction("WebView")
        ));

        String text = driver.findElement(AppiumBy.accessibilityId("WebView")).getText();

        Assert.assertEquals(text, "WebView");
    }

}
