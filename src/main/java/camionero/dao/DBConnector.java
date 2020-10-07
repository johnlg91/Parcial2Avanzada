package camionero.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

//Clase Connector, establece la coneccion a la Basse de datos
class DBConnector {

    private static final String URL = "jdbc:mysql://localhost:3306/camionero";
    private static final String USER = "root";
    private static final String PASS = "juanma";

    //Devuelve la coneccion de la base de datos
    static Connection getConnection() {
        try {
            return DriverManager.getConnection(URL, USER, PASS);
        } catch (SQLException ex) {
            throw new RuntimeException("Error connecting to the database", ex);
        }
    }

    /**
     * Test Connection
     */
    public static void main(String[] args) {
        System.out.println((DBConnector.getConnection() != null) + " connection");
    }
}
