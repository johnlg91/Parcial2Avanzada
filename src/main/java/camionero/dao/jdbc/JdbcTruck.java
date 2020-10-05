package camionero.dao.jdbc;

import camionero.dao.interfaces.TruckDAO;
import camionero.model.Truck;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JdbcTruck extends JdbcBase<Truck, Integer> implements TruckDAO {

    public JdbcTruck(Connection connection) {
        super(connection);
    }

    @Override
    String getTableName() {
        return "truck";
    }

    @Override
    String getPKColumnName() {
        return "plate_number";
    }

    @Override
    Truck toModel(ResultSet rs) throws SQLException {
        final Truck truck = new Truck(rs.getInt(getPKColumnName()));
        truck.setBrand(rs.getString("brand"));
        truck.setModel(rs.getString("model"));
        truck.setMaxTons(rs.getInt("max_tons"));
        truck.setTankCapacity(rs.getInt("tank_capacity"));
        truck.setConsumption(rs.getInt("consumption"));
        return truck;
    }

    @Override
    public boolean insert(Truck newEntity) {
        return false;
    }

    @Override
    public boolean update(Integer id, Truck updatedEntity) {
        return false;
    }
}
