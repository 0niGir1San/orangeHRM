package com.orange.drivers;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.managers.OperaDriverManager;
import org.openqa.selenium.WebDriver;

import java.time.Duration;

public class OperaWebDriver {

    public static WebDriver loadOperaDriver(){
        WebDriverManager.operadriver().setup(); // Установка драйвера через WebDriverManager
        WebDriver driver = (WebDriver) new OperaDriverManager(); // Создание экземпляра OperaDriver
        driver.manage().window().maximize(); // Максимизация окна браузера
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15)); // Установка времени ожидания
        return driver;
    }
}
