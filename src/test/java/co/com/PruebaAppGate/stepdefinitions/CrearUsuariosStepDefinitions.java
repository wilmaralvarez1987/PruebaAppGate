package co.com.PruebaAppGate.stepdefinitions;

import co.com.PruebaAppGate.exceptions.ResultadoNoEncontrado;
import co.com.PruebaAppGate.questions.VerificarEmpleadoExistente;
import co.com.PruebaAppGate.tasks.InsertarEmpleado;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import java.util.List;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static  co.com.PruebaAppGate.exceptions.ResultadoNoEncontrado.OTROS_RESULTADOS_ENCONTRADOS;

public class CrearUsuariosStepDefinitions {



    @When("^El usuario crea el empleado en su api$")
    public void elUsuarioCreaElEmpleadoEnSuApi(List<String> data) {
        theActorInTheSpotlight().attemptsTo(
                InsertarEmpleado.crearEmpleado(data)
        );

    }

    @Then("^El usuario deberia ver reflejado en la bd el empleado exitosamente$")
    public void elUsuarioDeberiaVerReflejadoEnLaBdElEmpleadoExitosamente(List<String> data) {
        theActorInTheSpotlight().should(
                seeThat(VerificarEmpleadoExistente.resultado(data)).orComplainWith(ResultadoNoEncontrado.class,OTROS_RESULTADOS_ENCONTRADOS)

        );

    }
}
