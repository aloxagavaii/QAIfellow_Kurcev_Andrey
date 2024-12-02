package ru.iFellow;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue = {"ru.iFellow.steps","ru.iFellow"},
        plugin = { "pretty" },
        monochrome = true
)
public class TestClass {
}
