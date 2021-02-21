package co.com.PruebaAppGate.stepdefinitions;

import co.com.PruebaAppGate.exceptions.ResultadoNoEncontrado;
import co.com.PruebaAppGate.questions.VerificarEmpleadoEliminado;
import co.com.PruebaAppGate.tasks.EliminarEmpleado;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static co.com.PruebaAppGate.exceptions.ResultadoNoEncontrado.OTROS_RESULTADOS_ENCONTRADOS;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class EliminarEmpleadoStepDefinitions {


    @When("^El usuario elimina el empleado (.*) en su api$")
    public void elUsuarioEliminaElEmpleadoEnSuApi(int idEmpleado) {
        theActorInTheSpotlight().attemptsTo(
                EliminarEmpleado.eliminar(idEmpleado)

        );

    }


    @Then("^El usuario verifica la eliminacion del empleado (.*)$")
    public void elUsuarioVerificaLaEliminacionDelEmpleado(int idEmpleado) {
        theActorInTheSpotlight().should(
                seeThat(VerificarEmpleadoEliminado.resultado(idEmpleado)).orComplainWith(ResultadoNoEncontrado.class,OTROS_RESULTADOS_ENCONTRADOS)

        );

    }

}
