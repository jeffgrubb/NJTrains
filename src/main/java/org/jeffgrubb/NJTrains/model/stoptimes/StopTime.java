package org.jeffgrubb.NJTrains.model.stoptimes;

/**
 * Created by jgrubb on 1/10/16.
 */

import java.sql.Timestamp;

public class StopTime {
    private int stopTimeId;
    private int tripId;
    private Timestamp arrivalTime;
    private Timestamp departureTime;
    private int stopId;
    private int stopSequence;
    private int pickupType;
    private int dropOffType;
    private double shapeDistanceTraveled;

    public int getStopTimeId() { return stopTimeId; }
    public int getTripId() { return tripId; }
    public Timestamp getArrivalTime() { return arrivalTime; }
    public Timestamp getDepartureTime() { return departureTime; }
    public int getStopId() { return stopId; }
    public int getStopSequence() { return stopSequence; }
    public int getPickupType() { return pickupType; }
    public int getDropOffType() { return dropOffType; }
    public double getShapeDistanceTraveled() { return shapeDistanceTraveled; }

    public void setStopTimeId(int stopTimeId) { this.stopTimeId = stopTimeId; }
    public void setTripId(int tripId) { this.tripId = tripId; }
    public void setArrivalTime(Timestamp arrivalTime) { this.arrivalTime = arrivalTime; }
    public void setDepartureTime(Timestamp departureTime) { this.departureTime = departureTime; }
    public void setStopId(int stopId) { this.stopId = stopId; }
    public void setStopSequence(int stopSequence) { this.stopSequence = stopSequence; }
    public void setPickupType(int pickupType) { this.pickupType = pickupType; }
    public void setDropOffType(int dropOffType) { this.dropOffType = dropOffType; }
    public void setShapeDistanceTraveled(int shapeDistanceTraveled) { this.shapeDistanceTraveled = shapeDistanceTraveled; }
}
