package co.com.PruebaAppGate.stepdefinitions;

import co.com.PruebaAppGate.exceptions.ResultadoNoEncontrado;
import co.com.PruebaAppGate.questions.VerificarEmpleadoExistente;
import co.com.PruebaAppGate.tasks.ActualizarEmpleado;
import co.com.PruebaAppGate.tasks.InsertarEmpleado;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import java.util.List;

import static co.com.PruebaAppGate.exceptions.ResultadoNoEncontrado.OTROS_RESULTADOS_ENCONTRADOS;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class ActualizarEmpleadoStepDefinitions {


    @When("^El usuario desea actualizar el empleado (.*) en su api$")
    public void elUsuarioDeseaActualizarElEmpleadoEnSuApi(int idEmpleado, List<String> data) {

        theActorInTheSpotlight().attemptsTo(
                ActualizarEmpleado.actualizarEmpleado(idEmpleado,data)
        );

    }


    @Then("^El usuario verifica la actualizacion del empleado en la bd$")
    public void elUsuarioVerificaLaActualizacionDelEmpleadoEnLaBd(List<String> data) {
        theActorInTheSpotlight().should(
                seeThat(VerificarEmpleadoExistente.resultado(data)).orComplainWith(ResultadoNoEncontrado.class,OTROS_RESULTADOS_ENCONTRADOS)

        );

    }



}
