package camionero.dao.jdbc;

import camionero.dao.interfaces.DriverDAO;
import camionero.model.Driver;

import java.sql.*;

public class JdbcDriver extends JdbcBase<Driver, Integer> implements DriverDAO {

    public JdbcDriver(Connection connection) {
        super(connection);
    }

    @Override
    String getTableName() {
        return "driver";
    }

    @Override
    String getPKColumnName() {
        return "dni";
    }

    @Override
    Driver toModel(ResultSet rs) throws SQLException {
        final Driver driver = new Driver(rs.getInt(getPKColumnName()));
        driver.setFirstName(rs.getString("first_name"));
        driver.setLastName(rs.getString("last_name"));
        driver.setBirthDate(rs.getDate("birth_date").toLocalDate());
        driver.setLicenseCategory(rs.getString("license_category"));
        driver.setCellphone(rs.getString("cellphone"));
        return driver;
    }


    //llama al insert y se le va pasando el valor uno por uno
    @Override
    public boolean insert(Driver driver) {
        try (PreparedStatement ps = connection.prepareStatement(
                "INSERT INTO driver(dni, first_name, last_name, birth_date, license_category, cellphone) VALUES (?, ?, ?, ?, ?, ?)")) {
            ps.setInt(1, driver.getDni());
            ps.setString(2, driver.getFirstName());
            ps.setString(3, driver.getLastName());
            ps.setDate(4, Date.valueOf(driver.getBirthDate()));
            ps.setString(5, driver.getLicenseCategory().name());
            ps.setString(6, driver.getCellphone());
            return executeUpdate(ps);
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean update(Integer id, Driver driver) {
        try (PreparedStatement ps = connection.prepareStatement(
                "UPDATE driver set license_category = ? WHERE dni = ?")) {
            ps.setInt(1, driver.getDni());
            ps.setInt(2, id);
            return executeUpdate(ps);
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }
}
