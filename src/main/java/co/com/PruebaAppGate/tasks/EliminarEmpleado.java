package co.com.PruebaAppGate.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;

import java.sql.SQLException;
import static co.com.PruebaAppGate.integration.SqlQueries.eliminarEmpleado;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class EliminarEmpleado implements Task {

    private int idEmpleado;
    private int resultado;
    public EliminarEmpleado(int idEmpleado){this.idEmpleado=idEmpleado;}


    @Override
    public <T extends Actor> void performAs(T actor) {

        try {
            resultado = eliminarEmpleado(idEmpleado);


        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public static Performable eliminar(int idEmpleado){
        return instrumented(EliminarEmpleado.class, idEmpleado);
    }
}
