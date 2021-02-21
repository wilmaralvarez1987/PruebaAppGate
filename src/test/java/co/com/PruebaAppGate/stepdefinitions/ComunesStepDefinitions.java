package co.com.PruebaAppGate.stepdefinitions;

import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;

import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;

public class ComunesStepDefinitions {

    @Before
    public void prepareStage(){
        OnStage.setTheStage(new OnlineCast());
    }


    @Given("^Que el usuario desea probar su api$")
    public void queElUsuarioDeseaProbarSuApi() {
        theActorCalled("actor").attemptsTo(

        );

    }
}
