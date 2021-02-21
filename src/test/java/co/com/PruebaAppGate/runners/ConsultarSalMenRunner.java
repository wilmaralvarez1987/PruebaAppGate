package co.com.PruebaAppGate.runners;


import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;


@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = "src/test/resources/features/consultar_sal_men.feature",
        glue = "co.com.PruebaAppGate.stepdefinitions",
        snippets = SnippetType.CAMELCASE
)



public class ConsultarSalMenRunner {
}
