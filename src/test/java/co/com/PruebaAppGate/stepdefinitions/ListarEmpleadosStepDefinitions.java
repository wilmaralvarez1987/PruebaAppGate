package co.com.PruebaAppGate.stepdefinitions;


import co.com.PruebaAppGate.exceptions.ResultadoNoEncontrado;
import co.com.PruebaAppGate.questions.VerificarTodosEmpleados;
import co.com.PruebaAppGate.tasks.ListarEmpleados;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static co.com.PruebaAppGate.exceptions.ResultadoNoEncontrado.OTROS_RESULTADOS_ENCONTRADOS;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class ListarEmpleadosStepDefinitions {

    @When("^El usuario consulta todos los empleados en su api$")
    public void elUsuarioConsultaTodosLosEmpleadosEnSuApi() {
        theActorInTheSpotlight().attemptsTo(
                ListarEmpleados.consultarEmpleados()

        );

    }


    @Then("^El usuario verifica la cantidad de empleados en total en la bd$")
    public void elUsuarioVerificaLaCantidadDeEmpleadosEnTotalEnLaBd() {

        theActorInTheSpotlight().should(
                seeThat(VerificarTodosEmpleados.resultado()).orComplainWith(ResultadoNoEncontrado.class,OTROS_RESULTADOS_ENCONTRADOS)

        );

    }
}
