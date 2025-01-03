package com.example;

import com.example.utils.ApplicationProperties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import java.time.Duration;


public class BaseTest {

    protected WebDriver driver ;
    public long beforeTime =0;
    public long afterTime =0;
    public String username = ApplicationProperties.INSTANCE.getUsername();
    public String password = ApplicationProperties.INSTANCE.getPassword();
    Logger log = LoggerFactory.getLogger(BaseTest.class);

    @BeforeSuite
    public void beforeSuite() {
        beforeTime = System.currentTimeMillis();
        log.info("Start");
    }

    @BeforeTest
    public void beforeTest() {
    }


    public void waitWebElement(WebElement element,WebDriver driver){
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public WebDriver getWebDriver () {

//        System.setProperty("webDriver.Chrome.driver","src/main/resources/chromedriver.exe");
//        ChromeOptions option = new ChromeOptions();
//        option.addArguments("--remote-allow-origins =*");
//        //     option.setHeadless(Boolean.parseBoolean(ApplicationProperties.INSTANCE.setHeadless()));
//        driver = new ChromeDriver(option);
//        return driver;
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");

        ChromeOptions option = new ChromeOptions();
        option.addArguments("--remote-allow-origins=*");

        // option.setHeadless(Boolean.parseBoolean(ApplicationProperties.INSTANCE.setHeadless()));
        driver = new ChromeDriver(option);

        return driver;

    }

}

// ChromeOptions options = new ChromeOptions();
//options.addArguments("--headless=new");
//    WebDriver driver = new ChromeDriver(options);
// driver.get("https://selenium.dev);
//       driver.quit();