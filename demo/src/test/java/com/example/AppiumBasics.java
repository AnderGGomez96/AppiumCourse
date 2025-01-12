package com.example;
import java.net.MalformedURLException;
import java.net.URISyntaxException;

import org.testng.annotations.Test;
import io.appium.java_client.AppiumBy;

public class AppiumBasics extends BaseTest {

    @Test
    public void WifiSettinsName() throws MalformedURLException, URISyntaxException {

        //AndroidDriver, IOSDriver
        // Appium Code -> Appium Server -> Mobile Device -> App -> Actions
        driver.findElement(AppiumBy.accessibilityId("Preference")).click();


    }
}
