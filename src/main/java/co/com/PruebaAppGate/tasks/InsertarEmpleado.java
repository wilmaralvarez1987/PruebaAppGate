package co.com.PruebaAppGate.tasks;


import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;

import java.sql.SQLException;
import java.util.List;


import static co.com.PruebaAppGate.integration.SqlQueries.insertarEmpleado;
import static java.lang.Integer.*;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class InsertarEmpleado implements Task {

    private List<String> datos;
    private int resultado;
    public InsertarEmpleado(List<String> datos){this.datos=datos;}

    @Override
    public <T extends Actor> void performAs(T actor) {

        try {
               resultado = insertarEmpleado(parseInt(datos.get(0)),datos.get(1), parseInt(datos.get(2)), parseInt(datos.get(3)));


        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static Performable crearEmpleado(List<String> datos){
        return instrumented(InsertarEmpleado.class, datos);
    }
}
