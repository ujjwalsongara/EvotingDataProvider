package com.example.tests;

import com.example.BaseTest;
import com.example.pages.DataProvider.DataPage;
import com.example.pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.log4testng.Logger;

public class DemoTest extends BaseTest {

    private LoginPage loginPage;

//    @Test(dataProvider = "excelData", dataProviderClass = DataPage.class)
//    @Test(dataProvider = "excelData")
    @Test
    @Parameters("url")
    public void eVotingTest(@Optional String url) throws InterruptedException {



        WebDriver driver = getWebDriver();

        loginPage = new LoginPage(driver, url);
        loginPage.login(username,password);


        if (driver != null) {
            driver.quit();  // This will close all open tabs and quit the driver
            }

    }

}