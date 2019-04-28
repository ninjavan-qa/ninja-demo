package co.nvqa.ninja_demo.pages;

import co.nvqa.ninja_demo.config.ConfigProperties;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginForm extends Page {

    @FindBy(xpath = "//form[not(@style='display: none;')]//*[text()='Username']/following::input[1]")
    private WebElement inputUsername;

    @FindBy(xpath = "//form[not(@style='display: none;')]//*[text()='Password']/following::input[1]")
    private WebElement inputPassword;

    @FindBy(xpath = "//form[not(@style='display: none;')]//button[text()='Login']")
    private WebElement buttonLogin;

    private final String formInvisibleXpath = "//form[@style='display: none;']";
    @FindBy(xpath = formInvisibleXpath)
    private WebElement form;

    public LoginForm() {
        PageFactory.initElements(driver, this);
    }

    public void open() {
        driver.get(ConfigProperties.getBaseUrl());
        waitForPresenceOfElement(formInvisibleXpath);
    }

    public void enterUserName(String text) {
        inputUsername.sendKeys(text);
    }

    public void enterPassword(String text) {
        inputPassword.sendKeys(text);
    }

    public LoginMessage clickLoginButton() {
        buttonLogin.click();
        return new LoginMessage();
    }
}
