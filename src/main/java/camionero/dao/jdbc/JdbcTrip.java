package camionero.dao.jdbc;

import camionero.dao.interfaces.TripDAO;
import camionero.model.Trip;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class JdbcTrip extends JdbcBase<Trip, Integer> implements TripDAO {


    public JdbcTrip(Connection connection) {
        super(connection);
    }

    @Override
    String getTableName() {
        return "trip";
    }

    @Override
    String getPKColumnName() {
        return "trip_id";
    }

    @Override
    Trip toModel(ResultSet rs) throws SQLException {
        final Trip trip = new Trip(rs.getInt(getPKColumnName()));
        trip.setTripId(rs.getInt("trip_id"));
        trip.setDriverDni(rs.getInt("driver_dni"));
        trip.setTuckPlate(rs.getInt("truck_plate"));
        trip.setFrom(rs.getString("from_location"));
        trip.setTo(rs.getString("to_location"));
        trip.setStart(rs.getDate("start"));
        trip.setEnd(rs.getDate("end"));
        return trip;
    }

    @Override
    public List<Trip> listDriverTrips(int driverDNI) {
        final List<Trip> result = new ArrayList<>();

        try {
            final PreparedStatement ps = connection.prepareStatement(
                    "SELECT * FROM trip WHERE driver_dni = ?"
            );
            ps.setObject(1, driverDNI);

            final ResultSet rs = ps.executeQuery();
            while (rs.next())
                result.add(toModel(rs));
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
        return result;
    }

    @Override
    public boolean insert(Trip newEntity) {
        return false;
    }

    @Override
    public boolean update(Integer id, Trip updatedEntity) {
        return false;
    }
}
