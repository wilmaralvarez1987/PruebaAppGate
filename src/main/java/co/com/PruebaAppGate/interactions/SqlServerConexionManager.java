package co.com.PruebaAppGate.interactions;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import co.com.PruebaAppGate.exceptions.ConexionExcepcions;
import co.com.PruebaAppGate.utils.PropertiesManager;

class SqlServerConexionManager {


    private SqlServerConexionManager() {
        throw new IllegalStateException("No se debe instanciar la clase");
    }

    static Connection getConexion() {
        Connection conexion = null;
        try {
            Properties dbProp = PropertiesManager.getDbProperties("./sqlserver-bd.properties");

            String strHost = dbProp.getProperty("HOST");
            String strUser = dbProp.getProperty("USER");
            String strPassword = dbProp.getProperty("PASS");
            String strPort = dbProp.getProperty("PORT");
            String strBd = dbProp.getProperty("BD");


            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
           String cadenaConexion = "jdbc:sqlserver://" + strHost + ":" + strPort + ";databaseName=" + strBd + ";user=" + strUser + ";password=" + strPassword + "";

            conexion = DriverManager.getConnection(cadenaConexion);

        } catch (SQLException var4) {
            throw new ConexionExcepcions("Error inesperado al conectase a la base de datos", var4);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return conexion;
    }


}
