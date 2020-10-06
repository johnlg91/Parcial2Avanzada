package camionero.dao.interfaces;

import camionero.model.Trip;

import java.util.List;

public interface TripDAO extends CRUD<Trip, Integer> {
    List<Trip> listDriverTrips(int driverDNI);
}
