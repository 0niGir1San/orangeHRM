package com.orange.pages;

import com.orange.drivers.DriverManager;
import com.orange.enums.SideBarMenuEnum;
import com.orange.helper.BrowserHelper;
import com.orange.helper.DropDownHelper;
import com.orange.helper.WebElementActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class BasePage {

    protected WebDriver driver;
    protected WebElementActions webElementActions;
    protected BrowserHelper browserHelper;

    public BasePage() {
        this.driver = DriverManager.getDriver();
        this.webElementActions = new WebElementActions(driver);
        this.browserHelper = new BrowserHelper(driver);
        PageFactory.initElements(driver, this);
    }

    public DropDownHelper dropDownHelper = new DropDownHelper(DriverManager.getDriver());


    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
}

