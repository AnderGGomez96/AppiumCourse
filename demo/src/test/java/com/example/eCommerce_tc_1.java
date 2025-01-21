package com.example;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;

public class eCommerce_tc_1 extends BaseTest {

    @Test
    public void FillForm() throws InterruptedException {

        driver.findElement(By.id("com.androidsample.generalstore:id/nameField"))
                .sendKeys("Andres Manuel Lopez Obrador");

        driver.hideKeyboard();

        driver.findElement(By.id("com.androidsample.generalstore:id/radioFemale"))
                .click();

        driver.findElement(By.id("com.androidsample.generalstore:id/spinnerCountry"))
                .click();

        driver.findElement(AppiumBy.androidUIAutomator(
                scrollAction("Colombia")));

        driver.findElement(
                By.xpath("//android.widget.TextView[@resource-id=\"android:id/text1\" and @text=\"Colombia\"]"))
                .click();

        driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop"))
                .click();

        driver.findElement(AppiumBy.androidUIAutomator(
            scrollAction("Jordan 6 Rings")
        ));

        List<WebElement> products = driver.findElements(By.id("com.androidsample.generalstore:id/productName"));
        
        int productsSize = products.size();

        for (int i = 0; i < productsSize; i++) {
            String productName = products.get(i).getText();
            if (productName.equalsIgnoreCase("Jordan 6 Rings")) {
                driver.findElements(By.id("com.androidsample.generalstore:id/productAddCart")).get(i).click();
                break;
            }
        }

        driver.findElement(By.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();
        Thread.sleep(3000);

        WebDriverWait wait =  new WebDriverWait(driver,Duration.ofSeconds(5));
        wait.until(
            ExpectedConditions.attributeContains(
                driver.findElement(By.id("com.androidsample.generalstore:id/toolbar_title")), 
                "text", 
                "Cart"
                )
        );
        
        String lastPageProduct = driver.findElement(By.id("com.androidsample.generalstore:id/productName")).getText();
        Assert.assertEquals(lastPageProduct, "Jordan 6 Rings");

    }

    @Test
    public void FillFormError() {

        driver.findElement(By.id("com.androidsample.generalstore:id/radioFemale"))
                .click();

        driver.findElement(By.id("com.androidsample.generalstore:id/spinnerCountry"))
                .click();

        driver.findElement(AppiumBy.androidUIAutomator(
                scrollAction("Colombia")));

        driver.findElement(
                By.xpath("//android.widget.TextView[@resource-id=\"android:id/text1\" and @text=\"Colombia\"]"))
                .click();

        driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop"))
                .click();

        String text = driver.findElement(By.xpath("//android.widget.Toast[1]"))
                .getText();

        Assert.assertEquals(text, "Please enter your name");

    }
}
