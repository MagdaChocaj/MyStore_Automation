package pl.coderslab.tests.mystore.cucumber;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/cucumber",
        plugin = {"pretty","html:out"})

public class Zadanie1_test {

}
