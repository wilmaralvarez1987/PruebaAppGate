package co.com.PruebaAppGate.exceptions;

public class ResultadoNoEncontrado extends AssertionError {


    public static final String OTROS_RESULTADOS_ENCONTRADOS = "El resultyado no es valido";

    public ResultadoNoEncontrado(String message, Throwable cause){
        super(message, cause);

    }

}
