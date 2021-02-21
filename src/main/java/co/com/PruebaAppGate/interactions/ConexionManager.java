package co.com.PruebaAppGate.interactions;

import co.com.PruebaAppGate.interactions.SqlServerConexionManager;

import java.sql.Connection;

public class ConexionManager {

    private ConexionManager() {
        throw new IllegalStateException("No se debe instanciar la clase");
    }

    public static Connection getSqlServerConexion() {
        return SqlServerConexionManager.getConexion();
    }









}
