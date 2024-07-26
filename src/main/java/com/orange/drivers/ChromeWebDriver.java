package com.orange.drivers;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

import static com.orange.utils.ConfigReader.getValue;

public class ChromeWebDriver {

    public static WebDriver loadChromeWebDriver() {
        WebDriverManager.chromedriver().setup();

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*"); // Для запуска из удаленного сервера
        options.addArguments("--disable-extensions"); // Отключить расширения
        options.addArguments("--window-size=1920,1080"); // Размер окна
        options.addArguments("--no-sandbox"); // Отключить песочницу
        options.addArguments("--disable-dev-shm-usage"); // Отключить shared memory
        options.setPageLoadStrategy(PageLoadStrategy.NORMAL);

        // Проверка, если указано значение headless в конфигурации
        if (Boolean.parseBoolean(getValue("headless"))) {
            options.addArguments("--headless");
        }

        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        return driver;
    }
}
