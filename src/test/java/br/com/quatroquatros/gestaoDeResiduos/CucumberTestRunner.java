package br.com.quatroquatros.gestaoDeResiduos;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/test/resources/features"},
        glue = {"br.com.quatroquatros.gestaoDeResiduos.steps"},
        plugin = {"pretty"}
)
public class CucumberTestRunner {
}
