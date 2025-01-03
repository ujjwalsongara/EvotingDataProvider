package com.example.pages;

import com.example.BaseTest;
import org.openqa.selenium.WebDriver;


public class BasePage extends BaseTest {

    protected WebDriver driver;

    public BasePage(WebDriver driver){this.driver = driver;}

    public WebDriver getWebDriver() { return this.driver; }
}
