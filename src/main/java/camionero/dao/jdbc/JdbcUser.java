package camionero.dao.jdbc;

import camionero.dao.interfaces.UserDAO;
import camionero.model.User;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JdbcUser extends JdbcBase<User, String> implements UserDAO {

    public JdbcUser(Connection connection) {
        super(connection);
    }

    @Override
    String getTableName() {
        return "user";
    }

    @Override
    String getPKColumnName() {
        return "user_name";
    }

    @Override
    User toModel(ResultSet rs) throws SQLException {
        final User user = new User(rs.getString(getPKColumnName()));
        user.setPassword(rs.getString("password"));
        user.setDni(rs.getInt("dni"));
        user.setAdmin(rs.getBoolean("admin"));
        return user;
    }

    @Override
    public boolean insert(User newEntity) {
        return false;
    }

    @Override
    public boolean update(String id, User updatedEntity) {
        return false;
    }
}