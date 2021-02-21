package co.com.PruebaAppGate.stepdefinitions;

import co.com.PruebaAppGate.exceptions.ResultadoNoEncontrado;
import co.com.PruebaAppGate.questions.VerificarBusquedaEmpleado;
import co.com.PruebaAppGate.tasks.BuscarEmpleado;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static co.com.PruebaAppGate.exceptions.ResultadoNoEncontrado.OTROS_RESULTADOS_ENCONTRADOS;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class BuscarEmpleadoStepDefinitions {


    @When("^El usuario busca el empleados con (.*) en su api$")
    public void elUsuarioBuscaElEmpleadosConEnSuApi(int idEmpleado) {
        theActorInTheSpotlight().attemptsTo(
                BuscarEmpleado.buscar(idEmpleado)

        );

    }


    @Then("^El usuario verifica la busqueda del empleado (.*) en la bd$")
    public void elUsuarioVerificaLaBusquedaDelEmpleadoEnLaBd(int idEmpleado) {
        theActorInTheSpotlight().should(
                seeThat(VerificarBusquedaEmpleado.resultado(idEmpleado)).orComplainWith(ResultadoNoEncontrado.class,OTROS_RESULTADOS_ENCONTRADOS)

        );

    }
}
