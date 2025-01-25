package com.example;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class BrowserBaseTest {
    public AppiumDriverLocalService service;
    public AndroidDriver driver;

    @BeforeClass
    public void ConfigureAppiumServer() throws MalformedURLException, URISyntaxException {

        // Se configura el servicio de Appium
        service = new AppiumServiceBuilder()
                .withAppiumJS(
                        new File("C:\\Users\\ASUS\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js"))
                .withIPAddress("127.0.0.1")
                .usingPort(4723).build();

        // Se inicia el servicio de Appium
        service.start();

        // Se configura el driver de Appium
        UiAutomator2Options options = new UiAutomator2Options();
        options.setDeviceName("motorola moto g31");
        options.setChromedriverExecutable("C:\\Users\\ASUS\\Documents\\chromedriver-win32\\chromedriver.exe");
        
        options.setCapability("browserName","Chrome");

        driver = new AndroidDriver(new URI("http://127.0.0.1:4723").toURL(), options);

        // Se configura el tiempo de espera implicito
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }


    public double getFormattedPrice(String priceText) {
        return Double.parseDouble(priceText.substring(1));
    }

    @AfterClass
    public void tearDowm() {
        // Se cierra el driver y el servicio de Appium
        driver.quit();
        service.stop();
    }
}
