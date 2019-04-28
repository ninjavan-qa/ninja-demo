package co.nvqa.ninja_demo.glue;

import co.nvqa.ninja_demo.driver.WebDriverSingleton;
import co.nvqa.ninja_demo.pages.LoginForm;
import co.nvqa.ninja_demo.pages.LoginMessage;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.runtime.java.guice.ScenarioScoped;

import static org.junit.Assert.assertEquals;

@ScenarioScoped
public class LoginSteps {

    private LoginForm loginForm;
    private LoginMessage loginMessage;
    private static boolean initialized = false;

    @Before
    public void beforeAll() {
        WebDriverSingleton.getInstance();
        loginForm = new LoginForm();
        if (!initialized) {
            Runtime.getRuntime()
                    .addShutdownHook(new Thread(() -> WebDriverSingleton.getInstance().quit()));
            initialized = true;
        }
    }

    @Given("^I am on the main page$")
    public void iAmOnTheMainPage() {
        loginForm.open();
    }

    @When("^I enter \"(.*)\" into Username field$")
    public void iEnterTextIntoUsernameField(String text) {
        loginForm.enterUserName(text);
    }

    @When("^I enter \"(.*)\" into Password field$")
    public void iEnterTextIntoPasswordField(String text) {
        loginForm.enterPassword(text);
    }

    @And("^I click Login button$")
    public void iClickSubmitButton() {
        loginMessage = loginForm.clickLoginButton();
    }

    @Then("^I see \"(.*)\" message$")
    public void iSeeLoginSuccessMessage(String text) {
        assertEquals(text, loginMessage.getMessageDisplayed());
    }
}
