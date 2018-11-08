package co.nvqa.ninja_demo.glue;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.runtime.java.guice.ScenarioScoped;
import org.junit.Assert;

/**
 *
 * @author Daniel Joi Partogi Hutapea
 */
@ScenarioScoped
public class Sample01Steps
{
    private String actualDay;
    private String myQuestionDay;
    private boolean expectedAnswer;

    public Sample01Steps()
    {
    }

    @Given("today is \"([^\"]*)\"")
    public void givenTodayIs(String param1)
    {
        this.actualDay = param1;
    }

    @When("I ask whether it's \"([^\"]*)\" yet")
    public void iAskWhetherItSFridayYet(String param1)
    {
        this.myQuestionDay = param1;
    }

    @Then("I should be told \"([^\"]*)\"")
    public void iShouldBeTold(String param1)
    {
        this.expectedAnswer = Boolean.parseBoolean(param1);

        boolean isActualDayIsTheSameAsMyQuestionDay = actualDay.equalsIgnoreCase(myQuestionDay);
        Assert.assertEquals("The answer is wrong.", expectedAnswer, isActualDayIsTheSameAsMyQuestionDay);
    }
}
