package co.nvqa.ninja_demo;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

/**
 *
 * @author Daniel Joi Partogi Hutapea
 */
@RunWith(Cucumber.class)
@CucumberOptions(
    monochrome = true,
    plugin =
    {
        "pretty",
        "html:build/reports/html-output",
        "junit:build/reports/cucumber-junit/cucumber.xml"
    },
    glue = {"co.nvqa.ninja_demo.glue"},
    features =
    {
        "src/test/resources/features"
    },
        tags = "@Sample02"
)
public class CucumberRunner
{
}
