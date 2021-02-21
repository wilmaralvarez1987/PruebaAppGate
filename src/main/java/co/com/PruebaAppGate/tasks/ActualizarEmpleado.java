package co.com.PruebaAppGate.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;

import java.sql.SQLException;
import java.util.List;

import static co.com.PruebaAppGate.integration.SqlQueries.actualizar;
import static java.lang.Integer.parseInt;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class ActualizarEmpleado implements Task {

    private int idEmpleado;
    private int resultado;
    private List<String> datos;
    public ActualizarEmpleado(int idEmpleado,List<String> datos){
        this.idEmpleado=idEmpleado;
        this.datos=datos;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        try {
            resultado = actualizar(datos.get(0), parseInt(datos.get(1)), parseInt(datos.get(2)),idEmpleado);


        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public static Performable actualizarEmpleado(int idEmpleado, List<String> datos){
        return instrumented(ActualizarEmpleado.class, idEmpleado,datos);
    }


}
