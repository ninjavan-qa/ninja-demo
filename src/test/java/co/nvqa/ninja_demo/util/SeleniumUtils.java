package co.nvqa.ninja_demo.util;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

/**
 * @author Daniel Joi Partogi Hutapea
 */
public interface SeleniumUtils
{
    static ChromeDriver createChromeDriver()
    {
        WebDriverManager webDriverManager = WebDriverManager.chromedriver();
        webDriverManager.setup();

        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--disable-extensions");
        chromeOptions.addArguments("--window-size=1024,768");
        chromeOptions.addArguments("--window-position=0,0");
        return new ChromeDriver(chromeOptions);
    }
}
