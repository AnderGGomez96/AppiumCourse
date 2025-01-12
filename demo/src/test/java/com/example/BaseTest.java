package com.example;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;


public class BaseTest {
    public AppiumDriverLocalService service;
    public AndroidDriver driver;

    @BeforeClass
    public void ConfigureAppiumServer() throws MalformedURLException, URISyntaxException {
        service = new AppiumServiceBuilder().withAppiumJS(new File("C:\\Users\\ASUS\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js"))
        .withIPAddress("127.0.0.1")
        .usingPort(4723).build();

        service.start();

        UiAutomator2Options options = new UiAutomator2Options();
        options.setDeviceName("motorola moto g31");
        options.setApp("C:\\Users\\ASUS\\Documents\\Appium\\AppiumCourse\\demo\\src\\test\\java\\com\\example\\resources\\ApiDemos-debug.apk");

        driver = new AndroidDriver(new URI("http://127.0.0.1:4723").toURL(), options);
    }

    @AfterClass
    public void tearDowm() {
        driver.quit();
        service.stop();
    }
}
