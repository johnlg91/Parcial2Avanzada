package camionero.dao.jdbc;

import camionero.dao.interfaces.CRUD;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static java.lang.String.format;

public abstract class JdbcBase<T, PK> implements CRUD<T, PK> {

    private final Connection connection;

    public JdbcBase(Connection connection) {
        this.connection = connection;
    }

    abstract String getTableName();

    abstract String getPKColumnName();

    abstract T toModel(ResultSet rs) throws SQLException;

    @Override
    public boolean delete(PK id) {
        return false;
    }

    @Override
    public T find(PK id) {
        // ejemplo: "select * from truck where plate_number = " + id
        // "select * from " + getTableName() + " where " + getPKColumnName() + " = ?"

        try (
                PreparedStatement statement = connection.prepareStatement(
                        format("select * from %s where %s = ?", getTableName(), getPKColumnName())
                )
        ) {
            statement.setObject(1, id);

            final ResultSet rs = statement.executeQuery();
            if (rs.next())
                return toModel(rs);
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
        return null;
    }

    @Override
    public List<T> list() {
        final List<T> result = new ArrayList<>();
        try (
                Statement statement = connection.createStatement()
        ) {
            final ResultSet rs = statement.executeQuery(format("select * from %s", getTableName()));
            while (rs.next())
                result.add(toModel(rs));
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
        return result;
    }
}
