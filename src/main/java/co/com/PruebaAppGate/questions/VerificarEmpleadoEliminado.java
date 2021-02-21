package co.com.PruebaAppGate.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import java.sql.SQLException;
import java.util.Map;

import static co.com.PruebaAppGate.integration.SqlQueries.verificarEmpleado;


public class VerificarEmpleadoEliminado implements Question<Boolean> {

    private int idEmpleado;
    private Map<String, String> resultado;

    public VerificarEmpleadoEliminado(int idEmpleado) {
        this.idEmpleado=idEmpleado;
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        try {
            resultado = verificarEmpleado(idEmpleado);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultado.isEmpty();
    }

    public static VerificarEmpleadoEliminado resultado(int idEmpleado){
        return new VerificarEmpleadoEliminado(idEmpleado);

    }
}
