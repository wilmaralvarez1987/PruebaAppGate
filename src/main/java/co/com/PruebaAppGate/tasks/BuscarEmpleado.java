package co.com.PruebaAppGate.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;

import java.sql.SQLException;
import java.util.Map;

import static co.com.PruebaAppGate.integration.SqlQueries.buscarEmpleado;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class BuscarEmpleado implements Task {

    private Map<String, String> resultado;
    private int idEmpleado;


    public BuscarEmpleado(int idEmpleado){this.idEmpleado=idEmpleado; }


    @Override
    public <T extends Actor> void performAs(T actor) {

        try {
            resultado = buscarEmpleado(idEmpleado);

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
    public static Performable buscar(int idEmpleado){
        return instrumented(BuscarEmpleado.class, idEmpleado);
    }
}
