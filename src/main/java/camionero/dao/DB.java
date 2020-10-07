package camionero.dao;

import camionero.dao.interfaces.DriverDAO;
import camionero.dao.interfaces.TripDAO;
import camionero.dao.interfaces.TruckDAO;
import camionero.dao.interfaces.UserDAO;
import camionero.dao.jdbc.JdbcDriver;
import camionero.dao.jdbc.JdbcTrip;
import camionero.dao.jdbc.JdbcTruck;
import camionero.dao.jdbc.JdbcUser;

import java.sql.Connection;

/**
 * Singleton, se encarga de crear los DAO para todas las tablas
 * cuando pido el getinstance lo inicaliza si no estaba creado pidiendole
 * la coneccion al DBConnector
 */
public class DB {

    private final UserDAO userDAO;
    private final TruckDAO truckDAO;
    private final TripDAO tripDAO;
    private final DriverDAO driverDAO;

    public DB(Connection connection) {
        userDAO = new JdbcUser(connection);
        truckDAO = new JdbcTruck(connection);
        tripDAO = new JdbcTrip(connection);
        driverDAO = new JdbcDriver(connection);
    }

    public UserDAO getUserDAO() {
        return userDAO;
    }

    public TruckDAO getTruckDAO() {
        return truckDAO;
    }

    public TripDAO getTripDAO() {
        return tripDAO;
    }

    public DriverDAO getDriverDAO() {
        return driverDAO;
    }

    private static DB connector = null;

    //Crea la instancia de DB la cual llama a la Connector para pedirle la coneccion
    public static DB getInstance() {
        if (connector == null) {
            connector = new DB(DBConnector.getConnection());
        }
        return connector;
    }
}
