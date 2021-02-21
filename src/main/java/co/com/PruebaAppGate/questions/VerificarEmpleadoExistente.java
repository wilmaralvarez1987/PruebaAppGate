package co.com.PruebaAppGate.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;


import java.sql.SQLException;
import java.util.List;
import java.util.Map;


import static co.com.PruebaAppGate.integration.SqlQueries.verificarEmpleado;
import static java.lang.Integer.parseInt;

public class VerificarEmpleadoExistente implements Question<Boolean> {

    private List<String> datos;
    private Map<String, String> resultado;

    public VerificarEmpleadoExistente(List<String> datos) {
        this.datos=datos;
    }

    @Override
    public Boolean answeredBy(Actor actor) {


        try {
            resultado = verificarEmpleado(parseInt(datos.get(0)));

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultado.containsValue(datos.get(0)+'-' + datos.get(1)+'-'+ datos.get(2)+'-' + datos.get(3).toString());
    }

    public static VerificarEmpleadoExistente resultado(List<String> datos){
        return new VerificarEmpleadoExistente(datos);

    }
}
