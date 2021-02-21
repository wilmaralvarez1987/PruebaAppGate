package co.com.PruebaAppGate.stepdefinitions;


import co.com.PruebaAppGate.exceptions.ResultadoNoEncontrado;
import co.com.PruebaAppGate.questions.VerificarCantidadEmpleados;
import co.com.PruebaAppGate.tasks.ConsultarSalmen;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static co.com.PruebaAppGate.exceptions.ResultadoNoEncontrado.OTROS_RESULTADOS_ENCONTRADOS;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class ConsultarSalMenStepDefinitions {


    @When("^El usuario consulta los empleados con salario mayor a (.*) y menor tiempo (.*) en su api$")
    public void elUsuarioConsultaLosEmpleadosConSalarioMayorAYMenorTiempoEnSuApi(int salario, int meses) {

        theActorInTheSpotlight().attemptsTo(
                ConsultarSalmen.consultarSalMen(salario,meses)

        );

    }

    @Then("^El usuario verifica la cantidad de empleados con esa condiciones de (\\d+) y (\\d+) en la bd$")
    public void elUsuarioVerificaLaCantidadDeEmpleadosConEsaCondicionesDeYEnLaBd(int salario, int meses) {
        theActorInTheSpotlight().should(
                seeThat(VerificarCantidadEmpleados.resultado(salario,meses)).orComplainWith(ResultadoNoEncontrado.class,OTROS_RESULTADOS_ENCONTRADOS)

        );

    }




}
