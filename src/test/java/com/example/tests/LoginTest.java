package com.example.tests;

import com.example.BaseTest;
import com.example.pages.DataProvider.DataPage;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;
import java.time.Instant;


public class LoginTest extends BaseTest {
    Instant start = Instant.now();

    @Test(dataProvider = "excelData", dataProviderClass = DataPage.class)
//    @Test
    public void testLogin(String username ,String password) throws InterruptedException {

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-gpu");
        options.addArguments("--remote-allow-origins=*");
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().setSize(new Dimension(1920, 1080));
        driver.get("https://admin.vosp.io/");


        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement emailField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("email")));
        emailField.sendKeys(username);

        WebElement passwordField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("password")));
        passwordField.sendKeys(password);

        WebElement loginButton = wait.until(ExpectedConditions.elementToBeClickable(By.id(":r4:")));
        loginButton.click();
//
//        WebDriverWait waitt = new WebDriverWait(driver, Duration.ofSeconds(10));
//        WebElement userButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"root__layout\"]/div[1]/div/div[1]/div[2]/div/div/div/nav/ul/li[2]/a")));
//        userButton.click();

        Thread.sleep(3000);
        System.out.println("username: " + username + ", password: " + password);

        Instant end = Instant.now();
        long duration = Duration.between(start, end).toMillis();
        System.out.println("Page load time: " + duration + " ms");

        driver.quit();
    }
}

//        driver.findElement(By.name("email")).sendKeys(username);
//
//        driver.findElement(By.name("password")).sendKeys(password);
//
//        driver.findElement(By.id(":r4:")).click();