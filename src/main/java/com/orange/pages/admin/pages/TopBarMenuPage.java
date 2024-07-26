package com.orange.pages.admin.pages;

import com.orange.drivers.DriverManager;
import com.orange.helper.WebElementActions;
import com.orange.pages.BasePage;
import com.orange.pages.admin.enums.TopBarMenuEnum;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.Random;

public class TopBarMenuPage extends BasePage {

    private WebElementActions webElementActions;

    public TopBarMenuPage(WebDriver driver, WebElementActions webElementActions) {
        super(driver);
        this.webElementActions = webElementActions;
    }

    @FindBy(className = "oxd-topbar-body")
    public WebElement topBarBody;

    /**
     * Метод для выбора и клика по пункту меню.
     *
     * @param topBarMenuName Наименование меню для выбора
     * @return Текущий экземпляр страницы
     */
    public TopBarMenuPage chooseAndClickMenu(TopBarMenuEnum topBarMenuName) {
        WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(10));
        WebElement menuElement = null;

        // Попробуем найти элемент меню с использованием тега <span>
        try {
            menuElement = topBarBody.findElement(By.xpath(".//nav/ul/li/span[contains(text(), '" + topBarMenuName.getMenu() + "')]"));
        } catch (Exception e) {
            // Если не нашли, попробуем найти элемент с использованием тега <a>
            try {
                menuElement = topBarBody.findElement(By.xpath(".//nav/ul/li/a[text()='" + topBarMenuName.getMenu() + "']"));
            } catch (Exception ex) {
                // Если элемент не найден, выбрасываем исключение
                throw new RuntimeException("Пункт меню не найден: " + topBarMenuName.getMenu(), ex);
            }
        }

        // Кликаем по найденному элементу меню
        menuElement.click();

        // Обработка выпадающего меню, если оно присутствует
        try {
            List<WebElement> dropdownItems = DriverManager.getDriver().findElements(By.xpath("//ul[@class='oxd-dropdown-menu']/li"));

            if (!dropdownItems.isEmpty()) {
                Random random = new Random();
                WebElement randomItem = dropdownItems.get(random.nextInt(dropdownItems.size()));
                webElementActions.click(randomItem);
                System.out.println(randomItem.getText());
            }
        } catch (StaleElementReferenceException e) {
            // Если элемент устарел, повторяем попытку
            List<WebElement> dropdownItems = DriverManager.getDriver().findElements(By.xpath("//ul[@class='oxd-dropdown-menu']/li"));
            if (!dropdownItems.isEmpty()) {
                Random random = new Random();
                WebElement randomItem = dropdownItems.get(random.nextInt(dropdownItems.size()));
                webElementActions.click(randomItem);
                System.out.println(randomItem.getText());
            }
        }
        return this;
    }
}
