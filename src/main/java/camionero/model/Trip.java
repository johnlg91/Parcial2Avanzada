package camionero.model;

import camionero.dao.DB;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

public class Trip {

    private int tripId;
    private int driverDni;
    private int tuckPlate;
    private Location from;
    private Location to;
    private LocalDateTime start;
    private LocalDateTime end;

    public Trip(int tripId) {
        this.tripId = tripId;
    }

    public int getTripId() {
        return tripId;
    }

    public void setTripId(int tripId) {
        this.tripId = tripId;
    }

    public int getDriverDni() {
        return driverDni;
    }

    public void setDriverDni(int driverDni) {
        this.driverDni = driverDni;
    }

    public int getTuckPlate() {
        return tuckPlate;
    }

    public void setTuckPlate(int tuckPlate) {
        this.tuckPlate = tuckPlate;
    }

    public Location getFrom() {
        return from;
    }

    public void setFrom(Location from) {
        this.from = from;
    }

    public void setFrom(String from) {
        this.from = Location.valueOf(from);
    }

    public Location getTo() {
        return to;
    }

    public void setTo(Location to) {
        this.to = to;
    }

    public void setTo(String to) {
        this.to = Location.valueOf(to);
    }

    public LocalDateTime getStart() {
        return start;
    }

    public void setStart(LocalDateTime start) {
        this.start = start;
    }

    public void setStart(Date date) {
        if (date != null) {
            setStart(date.toInstant()
                    .atZone(ZoneId.systemDefault())
                    .toLocalDateTime());
        }
    }

    public LocalDateTime getEnd() {
        return end;
    }

    public void setEnd(LocalDateTime end) {
        this.end = end;
    }

    public void setEnd(Date date) {
        if (date != null) {
            setEnd(date.toInstant()
                    .atZone(ZoneId.systemDefault())
                    .toLocalDateTime());
        }
    }

    public int getDistance() {
        return from.getDistanceTo(to);
    }

    // da la cantidad de dias
    public double getTimeDays() {
        return getDistance() / 200;
    }

    // da la cantidad de tanques
    public double getTanks() {
        final Truck truck = DB.getInstance().getTruckDAO().find(getTuckPlate());
        if (truck == null) return 0;

        final int distance = getDistance(); // 100
        final int consumption = truck.getConsumption(); // 10 l/km
        final int tankCapacity = truck.getTankCapacity();

        final double litrosRequeridos = distance * consumption;
        return litrosRequeridos / tankCapacity;
    }
}
