package co.com.PruebaAppGate.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import java.sql.SQLException;
import java.util.Map;

import static co.com.PruebaAppGate.integration.SqlQueries.verificarCantidad;


public class VerificarCantidadEmpleados implements Question<Boolean> {
    private int salario;
    private int meses;
    private Map<String, String> resultado;

    public VerificarCantidadEmpleados(int salario, int meses) {
        this.salario=salario;this.meses=meses;
    }


    @Override
    public Boolean answeredBy(Actor actor) {

        try {
            resultado = verificarCantidad(salario, meses);
            System.out.println("Cantidad de empleados con salario y meses requeridos"+ resultado);
            return true;

        } catch (SQLException e) {
            e.printStackTrace();

        }
        return false;

        }


    public static VerificarCantidadEmpleados resultado(int salario, int meses){
        return new VerificarCantidadEmpleados(salario,meses);

    }
}
