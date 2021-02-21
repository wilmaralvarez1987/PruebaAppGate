package co.com.PruebaAppGate.tasks;


import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;

import java.sql.SQLException;
import java.util.Map;

import static co.com.PruebaAppGate.integration.SqlQueries.consultarSalaMen;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class ConsultarSalmen implements Task {


    private Map<String, String> resultado;
    private int salario;
    private int meses;

    public ConsultarSalmen(int salario, int meses){this.salario=salario; this.meses=meses;}

    @Override
    public <T extends Actor> void performAs(T actor) {

        try {
            resultado = consultarSalaMen(salario,meses);

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }


    public static Performable consultarSalMen(int salario, int meses){
        return instrumented(ConsultarSalmen.class, salario, meses);
    }
}
