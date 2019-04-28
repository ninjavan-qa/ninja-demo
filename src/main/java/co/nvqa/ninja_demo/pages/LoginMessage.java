package co.nvqa.ninja_demo.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginMessage extends Page {

    @FindBy(xpath = "//*[@id='result']")
    private WebElement inputPassword;

    public LoginMessage() {
        PageFactory.initElements(driver, this);
    }

    public String getMessageDisplayed() {
        return inputPassword.getText();
    }
}
