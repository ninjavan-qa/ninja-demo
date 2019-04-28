package co.nvqa.ninja_demo.pages;

import co.nvqa.ninja_demo.driver.WebDriverSingleton;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class Page {

    protected WebDriver driver = WebDriverSingleton.getInstance();

    protected void waitForPresenceOfElement(String xpath) {
        WebDriverWait wait = new WebDriverWait(driver, 3);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
    }
}
