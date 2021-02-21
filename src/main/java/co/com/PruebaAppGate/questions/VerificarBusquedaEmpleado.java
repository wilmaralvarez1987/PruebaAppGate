package co.com.PruebaAppGate.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import java.sql.SQLException;
import java.util.Map;
import static co.com.PruebaAppGate.integration.SqlQueries.buscarEmpleado;


public class VerificarBusquedaEmpleado implements Question<Boolean> {

    private int idEmpleado;
    private Map<String, String> resultado;

    public VerificarBusquedaEmpleado(int idEmpleado) {
        this.idEmpleado=idEmpleado;
    }


    @Override
    public Boolean answeredBy(Actor actor) {
        try {
            resultado = buscarEmpleado(idEmpleado);

            if(resultado.get("IdEmpleado").equals(idEmpleado));
            {return true;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;

    }
    public static VerificarBusquedaEmpleado resultado(int idEmpleado){
        return new VerificarBusquedaEmpleado(idEmpleado);

    }
}
