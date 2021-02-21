package co.com.PruebaAppGate.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;

import java.sql.SQLException;
import java.util.Map;

import static co.com.PruebaAppGate.integration.SqlQueries.consultarTodosEmpleados;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class ListarEmpleados implements Task {

    private Map<String, String> resultado;
    @Override
    public <T extends Actor> void performAs(T actor) {

        try {
            resultado = consultarTodosEmpleados();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
    public static Performable consultarEmpleados(){
        return instrumented(ListarEmpleados.class);
    }
}
