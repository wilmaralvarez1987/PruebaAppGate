package co.com.PruebaAppGate.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import java.sql.SQLException;
import java.util.Map;

import static co.com.PruebaAppGate.integration.SqlQueries.contarTodosEmpleados;

public class VerificarTodosEmpleados implements Question<Boolean> {
    private Map<String, String> resultado;
    @Override
    public Boolean answeredBy(Actor actor) {
        try {
            resultado = contarTodosEmpleados();
            System.out.println("La cantidad de empleados son:"+ resultado);
            return true;

        } catch (SQLException e) {
            e.printStackTrace();

        }
        return false;

    }

    public static VerificarTodosEmpleados resultado( ){
        return new VerificarTodosEmpleados();

    }
}
