package camionero.dao.jdbc;

import camionero.dao.interfaces.DriverDAO;
import camionero.model.Driver;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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
        driver.setBirthDate(rs.getDate("birth_date"));
        driver.setLicenseCategory(rs.getInt("license_category"));
        driver.setCellPhone(rs.getString("cellphone"));
        return driver;
    }

    @Override
    public boolean insert(Driver driver) {
        try (PreparedStatement ps = connection.prepareStatement(
                "INSERT INTO driver(dni, first_name, last_name, birth_date, license_category, cellphone) VALUES (?, ?, ?, ?)")) {
            ps.setInt(1, driver.getDni());
            ps.setString(2, driver.getFirstName());
            ps.setString(3, driver.getLastName());
            ps.setDate(4, new java.sql.Date(driver.getBirthDate().getTime()));
            ps.setInt(5, driver.getLicenseCategory());
            ps.setString(6, driver.getCellPhone());
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
