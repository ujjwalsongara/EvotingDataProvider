package com.example.pages;

import com.example.utils.ApplicationProperties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class LoginPage extends BasePage{

    @FindBy(xpath = "//*[@id=\":r2:\"]")
    private WebElement email;

    @FindBy(xpath = "//*[@id=\":r3:\"]")
    private WebElement pass;

    @FindBy(id = ":r4:")
    private WebElement loginButton;


    public LoginPage(WebDriver driver, String url) {
        super(driver);
        PageFactory.initElements(getWebDriver(),this);
        getWebDriver().manage().window().maximize();

        if (url ==null){
            getWebDriver().get(ApplicationProperties.INSTANCE.getBaseUrl());
        }else {
            getWebDriver().get(url);
        }
    }

    public void login (String username , String password) throws InterruptedException {
        Thread.sleep(4000);
        email.clear();
        email.sendKeys(username);

        pass.clear();
        pass.sendKeys(password);

        loginButton.click();

        Thread.sleep(5000);

    }

}
