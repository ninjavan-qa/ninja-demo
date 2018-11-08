package co.nvqa.example_1.glue;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.runtime.java.guice.ScenarioScoped;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Allure;
import io.qameta.allure.Attachment;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

/**
 *
 * @author Daniel Joi Partogi Hutapea
 */
@SuppressWarnings("Duplicates")
@ScenarioScoped
public class Sample03Steps
{
    private static final long DELAY_IN_MILLIS = 1_000;
    private WebDriver webDriver;

    public Sample03Steps()
    {
    }

    @Before("@LaunchBrowserV2")
    public void launchBrowser()
    {
        WebDriverManager webDriverManager = WebDriverManager.chromedriver();
        webDriverManager.setup();

        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--disable-extensions");
        chromeOptions.addArguments("--window-size=1024,768");
        chromeOptions.addArguments("--window-position=0,0");

        webDriver = new ChromeDriver(chromeOptions);
    }

    @After("@CloseBrowserV2")
    public void closeBrowser()
    {
        if(webDriver!=null)
        {
            webDriver.quit();
        }
    }

    @Given("^I am on \"([^\"]*)\" - Allure$")
    public void iAmOn(String url)
    {
        webDriver.get(url);
        takesScreenshot();
        pause(DELAY_IN_MILLIS);
    }

    @When("^I type \"([^\"]*)\" on the search input - Allure$")
    public void iTypeOnTheSearchInput(String searchText)
    {
        WebElement searchInputWe = webDriver.findElement(By.xpath("//input[@id='searchInput']"));
        searchInputWe.sendKeys(searchText);
        Allure.addAttachment("User Interaction Info", "User typed on 'Search Input' field.");
        takesScreenshot();
        pause(DELAY_IN_MILLIS);
    }

    @And("^I click submit button - Allure$")
    public void iClickSubmitButton()
    {
        WebElement submitButtonWe = webDriver.findElement(By.xpath("//button[@type='submit']"));
        submitButtonWe.click();
        Allure.addAttachment("User Interaction Info", "User clicked 'Submit' button.");
        takesScreenshot();
        pause(DELAY_IN_MILLIS);
    }

    @Then("^I should see the title is \"([^\"]*)\" - Allure$")
    public void isShouldSeeTheTitleIs(String expectedPageTitle)
    {
        WebElement firstHeadingWe = webDriver.findElement(By.xpath("//h1[@id='firstHeading']"));
        String actualPageTitle = firstHeadingWe.getText();
        Allure.addAttachment("Page Info", "Page Title = "+actualPageTitle);
        Assert.assertEquals("Title is different.", expectedPageTitle, actualPageTitle);
        takesScreenshot();
        pause(DELAY_IN_MILLIS);
    }

    private void pause(long millis)
    {
        try
        {
            Thread.sleep(millis);
        }
        catch(InterruptedException ignored)
        {
        }
    }

    @Attachment(value = "Page screenshot", type = "image/png")
    private byte[] takesScreenshot()
    {
        return ((TakesScreenshot) webDriver).getScreenshotAs(OutputType.BYTES);
    }
}
