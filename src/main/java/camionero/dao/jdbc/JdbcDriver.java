package camionero.dao.jdbc;

import camionero.model.Driver;
import camionero.model.Truck;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JdbcDriver extends JdbcBase<Driver, Integer> {

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
        driver.setLicenseCategory(rs.getString("license_category"));
        driver.setCellPhone(rs.getString("cellphone"));
        return driver;
    }

    @Override
    public boolean insert(Driver newEntity) {
        return false;
    }

    @Override
    public boolean update(Integer id, Driver updatedEntity) {
        return false;
    }
}
