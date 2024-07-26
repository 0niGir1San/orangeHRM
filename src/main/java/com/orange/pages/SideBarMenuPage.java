package com.orange.pages;

import com.orange.enums.SideBarMenuEnum;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SideBarMenuPage extends BasePage {

    @FindBy(className = "oxd-topbar-body")
    public WebElement topBarBody;

    public SideBarMenuPage(WebDriver driver) {
        super(driver);
    }

    public void chooseSideBarMenu(SideBarMenuEnum sideBarMenuEnum, WebElement topBarBody) {
        topBarBody.findElement(By.xpath("//ul[@class='oxd-main-menu']//li/a/span[text()='" + sideBarMenuEnum.getMenu() + "']")).click();
    }

    public SideBarMenuPage chooseSideBarMenu(SideBarMenuEnum sideBarMenuEnum) {
        chooseSideBarMenu(sideBarMenuEnum, topBarBody);
        return this;
    }
}
