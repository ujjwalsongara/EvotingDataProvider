//package com.example;
//
//import io.appium.java_client.AppiumDriver;
//import io.appium.java_client.MobileElement;
//import io.appium.java_client.android.AndroidDriver;
//import org.openqa.selenium.By;
//import org.testng.Assert;
//import org.testng.annotations.AfterClass;
//import org.testng.annotations.BeforeClass;
//import org.testng.annotations.Test;
//import org.openqa.selenium.remote.DesiredCapabilities;
//
//import java.net.MalformedURLException;
//import java.net.URL;
//
//public class AppiumTest<MobileElement> {
//    AppiumDriver driver;
//
//    @BeforeClass
//    public void setUp() throws MalformedURLException {
//        DesiredCapabilities capabilities = new DesiredCapabilities();
//        capabilities.setCapability("platformName", "Android");
//        capabilities.setCapability("platformVersion", "11.0");
//        capabilities.setCapability("deviceName", "Pixel_4_API_30");
//        capabilities.setCapability("appPackage", "com.example.myapp");
//        capabilities.setCapability("appActivity", "com.example.myapp.MainActivity");
//        capabilities.setCapability("automationName", "UiAutomator2");
//
//        driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
//    }
//
//    @Test
//    public void testLogin() {
//        MobileElement usernameField = (MobileElement) driver.findElement(By.id("com.example.myapp:id/username"));
//        usernameField.sendKeys("testuser");
//
//        MobileElement passwordField = (MobileElement) driver.findElement(By.id("com.example.myapp:id/password"));
//        passwordField.sendKeys("password123");
//
//        MobileElement loginButton = (MobileElement) driver.findElement(By.id("com.example.myapp:id/login_button"));
//        loginButton.click();
//
//        MobileElement welcomeMessage = (MobileElement) driver.findElement(By.id("com.example.myapp:id/welcome_message"));
//        Assert.assertTrue(welcomeMessage.isDisplayed(), "Login failed or Welcome message not found!");
//    }
//
//    @AfterClass
//    public void tearDown() {
//        if (driver != null) {
//            driver.quit();
//        }
//    }
//}
