package com.example;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

public class eCommerce_tc_4_hybrid extends BaseTest {

        @Test
        public void ShoppingCart() throws InterruptedException {

                driver.findElement(By.id("com.androidsample.generalstore:id/nameField"))
                                .sendKeys("Andres Manuel Lopez Obrador");

                driver.hideKeyboard();

                driver.findElement(By.id("com.androidsample.generalstore:id/radioFemale"))
                                .click();

                driver.findElement(By.id("com.androidsample.generalstore:id/spinnerCountry"))
                                .click();

                driver.findElement(AppiumBy.androidUIAutomator(
                                scrollAction("Armenia")));

                driver.findElement(
                                By.xpath("//android.widget.TextView[@resource-id=\"android:id/text1\" and @text=\"Armenia\"]"))
                                .click();

                driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop"))
                                .click();

                driver.findElements(By.xpath("//android.widget.TextView[@text=\"ADD TO CART\"]")).get(0).click();
                driver.findElements(By.xpath("//android.widget.TextView[@text=\"ADD TO CART\"]")).get(0).click();

                driver.findElement(By.id("com.androidsample.generalstore:id/appbar_btn_cart"))
                                .click();       

                WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
                wait.until(ExpectedConditions.attributeContains(
                                driver.findElement(
                                By.xpath("//android.widget.TextView[@resource-id=\"com.androidsample.generalstore:id/toolbar_title\"]")),
                                "text",
                                "Cart"));

                List<WebElement> prices = driver.findElements(By.id("com.androidsample.generalstore:id/productPrice"));
                int priceSize = prices.size();
                double totalPrice = 0;

                for (int i = 0; i < priceSize; i++) {
                     String priceText = prices.get(i).getText();
                     double price = getFormattedPrice(priceText);
                     totalPrice += price;
                }

                String total = driver.findElement(By.id("com.androidsample.generalstore:id/totalAmountLbl")).getText();
                double totalAmount = getFormattedPrice(total);

                Assert.assertEquals(totalPrice, totalAmount);

                driver.findElement(By.className("android.widget.CheckBox")).click();

                WebElement terms = driver.findElement(By.id("com.androidsample.generalstore:id/termsButton"));

                longPressAction(terms);

                String textTerms = driver.findElement(By.id("com.androidsample.generalstore:id/alertTitle")).getText();

                Assert.assertEquals(textTerms, "Terms Of Conditions");

                driver.findElement(By.id("android:id/button1")).click();

                driver.findElement(By.id("com.androidsample.generalstore:id/btnProceed")).click();

                Thread.sleep(3000);

                driver.getContextHandles().forEach(context -> System.out.println(context));

                driver.context("WEBVIEW_com.androidsample.generalstore");
                driver.findElement(By.name("q")).sendKeys("Hello World");
                driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
                driver.pressKey(new KeyEvent(AndroidKey.BACK));
                driver.context("NATIVE_APP");
        }

}
