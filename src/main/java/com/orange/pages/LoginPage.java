package com.orange.pages;

import com.orange.utils.ConfigReader;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

    @FindBy(xpath = "//input[@name='username']")
    public WebElement userNameInput;

    @FindBy(xpath = "//input[@name='password']")
    public WebElement passwordInput;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement loginBtn;

    public void doLogin() {
        browserHelper.open(ConfigReader.getValue("baseURL"));
        webElementActions.sendKeys(userNameInput, ConfigReader.getValue("login"))
                .sendKeys(passwordInput, ConfigReader.getValue("password"))
                .click(loginBtn);
    }
}
