package co.com.PruebaAppGate.integration;

import co.com.PruebaAppGate.interactions.ConexionManager;
import co.com.PruebaAppGate.utils.QueryManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class SqlQueries {

    private SqlQueries() {
    }

    private static int resultado;

    public static final int insertarEmpleado(int IdEmpleado, String Nombre, int Meses, int Salario) throws SQLException {

        String sql = QueryManager.SQLSERVER.getString("SQL.CREAR_EMPLEADO");
        Connection connection = ConexionManager.getSqlServerConexion();
        try (
                PreparedStatement query = connection.prepareStatement(sql)) {
            query.setString(1, String.valueOf(IdEmpleado));
            query.setString(2, Nombre);
            query.setString(3, String.valueOf(Meses));
            query.setString(4, String.valueOf(Salario));
            resultado = query.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (connection != null) {
                connection.close();
            }
        }
        return resultado;

    }


    public static Map<String, String> verificarEmpleado(int IdEmpleado) throws SQLException {
        Map<String, String> resultado = new HashMap<>();
        ResultSet resultSet = null;
        String sql = QueryManager.SQLSERVER.getString("SQL.CONSULTAR_EMPLEADO");
        try (Connection connection = ConexionManager.getSqlServerConexion();
             PreparedStatement query = connection.prepareStatement(sql)) {
            query.setString(1, String.valueOf(IdEmpleado));
            resultSet = query.executeQuery();
            if (resultSet.isBeforeFirst() && resultSet.next()) {
                resultado.put("empleado", resultSet.getString("empleado"));

            }
        } finally {
            if (resultSet != null) {
                resultSet.close();
            }
        }
        return resultado;
    }

    public static Map<String, String> consultarSalaMen(int salario, int meses) throws SQLException {
        Map<String, String> resultado = new HashMap<String, String>();
        ResultSet resultSet = null;
        String sql = QueryManager.SQLSERVER.getString("SQL.CONSULTAR_EMPLEADOS_MAS_SALARIO");
        try (Connection connection = ConexionManager.getSqlServerConexion();
             PreparedStatement query = connection.prepareStatement(sql)) {
            query.setString(1, String.valueOf(salario));
            query.setString(2, String.valueOf(meses));
            resultSet = query.executeQuery();

            while (resultSet.next()) {
                resultado.put("IdEmpleado", resultSet.getString("IdEmpleado"));
                resultado.put("Nombre", resultSet.getString("Nombre"));
                resultado.put("Meses", resultSet.getString("Meses"));
                resultado.put("Salario", resultSet.getString("Salario"));
                System.out.println("Empleado: " + resultado.entrySet());

            }

        } finally {
            if (resultSet != null) {
                resultSet.close();
            }
        }
        return resultado;
    }

    public static Map<String, String> verificarCantidad(int salario, int meses) throws SQLException {
        Map<String, String> resultado = new HashMap<>();
        ResultSet resultSet = null;
        String sql = QueryManager.SQLSERVER.getString("SQL.CANTIDAD");
        try (Connection connection = ConexionManager.getSqlServerConexion();
             PreparedStatement query = connection.prepareStatement(sql)) {
            query.setString(1, String.valueOf(salario));
            query.setString(2, String.valueOf(meses));
            resultSet = query.executeQuery();
            if (resultSet.isBeforeFirst() && resultSet.next()) {
                resultado.put("cantidad", resultSet.getString("cantidad"));

            }
        } finally {
            if (resultSet != null) {
                resultSet.close();
            }
        }
        return resultado;
    }

    public static Map<String, String> consultarTodosEmpleados() throws SQLException {
        Map<String, String> resultado = new HashMap<String, String>();
        ResultSet resultSet = null;
        String sql = QueryManager.SQLSERVER.getString("SQL.CONSULTAR_TODOS_EMPLEADOS");
        try (Connection connection = ConexionManager.getSqlServerConexion();
             PreparedStatement query = connection.prepareStatement(sql)) {
            resultSet = query.executeQuery();

            while (resultSet.next()) {
                resultado.put("IdEmpleado", resultSet.getString("IdEmpleado"));
                resultado.put("Nombre", resultSet.getString("Nombre"));
                resultado.put("Meses", resultSet.getString("Meses"));
                resultado.put("Salario", resultSet.getString("Salario"));
                System.out.println("Empleado: " + resultado.entrySet());

            }

        } finally {
            if (resultSet != null) {
                resultSet.close();
            }
        }
        return resultado;
    }

    public static Map<String, String> contarTodosEmpleados() throws SQLException {
        Map<String, String> resultado = new HashMap<String, String>();
        ResultSet resultSet = null;
        String sql = QueryManager.SQLSERVER.getString("SQL.CONTAR_TODOS_EMPLEADOS");
        try (Connection connection = ConexionManager.getSqlServerConexion();
             PreparedStatement query = connection.prepareStatement(sql)) {
            resultSet = query.executeQuery();

            while (resultSet.next()) {
                resultado.put("cantidad", resultSet.getString("cantidad"));


            }

        } finally {
            if (resultSet != null) {
                resultSet.close();
            }
        }
        return resultado;
    }

    public static final int eliminarEmpleado(int IdEmpleado) throws SQLException {

        String sql = QueryManager.SQLSERVER.getString("SQL.ELIMINAR_EMPLEADO");
        Connection connection = ConexionManager.getSqlServerConexion();
        try (
                PreparedStatement query = connection.prepareStatement(sql)) {
            query.setString(1, String.valueOf(IdEmpleado));

            resultado = query.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (connection != null) {
                connection.close();
            }
        }
        return resultado;

    }

    public static final int actualizar(String Nombre, int Meses, int Salario, int IdEmpleado) throws SQLException {

        String sql = QueryManager.SQLSERVER.getString("SQL.ACTUALIZAR_EMPLEADO");
        Connection connection = ConexionManager.getSqlServerConexion();
        try (
                PreparedStatement query = connection.prepareStatement(sql)) {
            query.setString(1, Nombre);
            query.setString(2, String.valueOf(Meses));
            query.setString(3, String.valueOf(Salario));
            query.setString(4, String.valueOf(IdEmpleado));
            resultado = query.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (connection != null) {
                connection.close();
            }
        }
        return resultado;

    }

    public static Map<String, String> buscarEmpleado(int idEmpleado) throws SQLException {
        Map<String, String> resultado = new HashMap<String, String>();
        ResultSet resultSet = null;
        String sql = QueryManager.SQLSERVER.getString("SQL.BUSCAR_EMPLEADO");
        try (Connection connection = ConexionManager.getSqlServerConexion();
             PreparedStatement query = connection.prepareStatement(sql)) {
            query.setString(1, String.valueOf(idEmpleado));

            resultSet = query.executeQuery();

            while (resultSet.next()) {
                resultado.put("IdEmpleado", resultSet.getString("IdEmpleado"));
                resultado.put("Nombre", resultSet.getString("Nombre"));
                resultado.put("Meses", resultSet.getString("Meses"));
                resultado.put("Salario", resultSet.getString("Salario"));
                System.out.println("Empleado buscado: " + resultado.entrySet());

            }

        } finally {
            if (resultSet != null) {
                resultSet.close();
            }
        }
        return resultado;
    }

}

