package camionero.dao;

import camionero.dao.interfaces.TruckDAO;
import camionero.dao.interfaces.UserDAO;
import camionero.dao.jdbc.JdbcTruck;
import camionero.dao.jdbc.JdbcUser;

import java.sql.Connection;


public class DB {

    private final UserDAO userDAO;
    private final TruckDAO truckDAO;

    public DB(Connection connection) {
        userDAO = new JdbcUser(connection);
        truckDAO = new JdbcTruck(connection);
    }

    public UserDAO getUserDAO() {
        return userDAO;
    }

    public TruckDAO getTruckDAO() {
        return truckDAO;
    }

    private static DB connector = null;

    public static DB getInstance() {
        if (connector == null) {
            connector = new DB(DBConnector.getConnection());
        }
        return connector;
    }
}
