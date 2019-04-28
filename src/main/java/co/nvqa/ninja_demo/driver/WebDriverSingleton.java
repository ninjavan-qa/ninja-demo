package co.nvqa.ninja_demo.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebDriverSingleton {

    private static WebDriver webDriver;

    private WebDriverSingleton() {
    }

    public static WebDriver getInstance() {
        if (webDriver == null) {
            webDriver = createWebDriver();
        }
        return webDriver;
    }

    private static WebDriver createWebDriver() {
        return new ChromeDriver();
    }
}
