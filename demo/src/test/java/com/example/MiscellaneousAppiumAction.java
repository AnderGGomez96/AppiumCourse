package com.example;

import org.openqa.selenium.By;
import org.openqa.selenium.DeviceRotation;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.Activity;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

public class MiscellaneousAppiumAction extends BaseTest {

    @Test
    public void MiscellaneousAppiumActionTest() {

        // App package & App Activity

        String activity = "io.appium.android.apis/io.appium.android.apis.preference.PreferenceDependencies";
        ((JavascriptExecutor) driver).executeScript(
            "mobile: startActivity", ImmutableMap.of(
                "intent", activity
            ));
        //driver.findElement(AppiumBy.accessibilityId("Preference")).click();
        //driver.findElement(By.xpath("//android.widget.TextView[@content-desc='3. Preference dependencies']")).click();
        
        
        driver.findElement(By.id("android:id/checkbox")).click();

        // Se rota el dispositivo
        DeviceRotation landScape = new DeviceRotation(0,0,90);
        driver.rotate(landScape);

        driver.findElement(By.xpath("(//android.widget.RelativeLayout)[2]")).click();

        // Se realiza una comparación de texto
        String alertTitle = driver.findElement(By.id("android:id/alertTitle")).getText();
        Assert.assertEquals(alertTitle, "WiFi settings");

        // Se copia un texto al portapapeles
        driver.setClipboardText(("Copy Wifi"));
        // Se pega el texto en el campo de texto
        driver.findElement(By.id("android:id/edit")).sendKeys(driver.getClipboardText());
        
        driver.pressKey((new KeyEvent(AndroidKey.ENTER)));
        driver.findElements(By.className("android.widget.Button")).get(1).click();
        driver.pressKey((new KeyEvent(AndroidKey.HOME)));
        driver.pressKey((new KeyEvent(AndroidKey.BACK)));
        
    
    }
}
