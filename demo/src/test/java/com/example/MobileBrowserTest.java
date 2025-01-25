package com.example;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MobileBrowserTest extends BrowserBaseTest {

    @Test
    public void OpenBrowser() throws InterruptedException {
        driver.get("https://rahulshettyacademy.com/angularAppdemo/");
        System.out.println(driver.getTitle());

        driver.findElement(By.xpath("//button[@class='navbar-toggler']")).click();
        driver.findElement(By.xpath("//a[@routerlink='/products' and @class='nav-link']")).click();
        String titlePage = driver.findElement(By.xpath("//h1[@class='display-4']")).getText();
        Assert.assertEquals(titlePage, "Product List");

        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0,1000)");
        
        driver.findElement(By.xpath("//a[@href='/angularAppdemo/products/3']")).click();
        String productTitle = driver.findElement(By.xpath("//h3[@class='product-title']")).getText();
        Assert.assertEquals(productTitle, "DEVOPS");
    }


}
