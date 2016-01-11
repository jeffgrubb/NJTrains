package org.jeffgrubb.NJTrains.model.trips;

/**
 * Created by jgrubb on 1/10/16.
 */

public class Trip {
    private int tripId;
    private int routeId;
    private int serviceId;
    private String tripHeadsign;
    private int directionId;
    private String blockId;
    private int shapeId;

    public int getTripId() { return tripId; }
    public int getRouteId() { return routeId; }
    public int getServiceId() { return serviceId; }
    public String getTripHeadsign() { return tripHeadsign; }
    public int getDirectionId() { return directionId; }
    public String getBlockId() { return blockId; }
    public int getShapeId() { return shapeId; }

    public void setTripId(int tripId) { this.tripId = tripId; }
    public void setRouteId(int routeId) { this.routeId = routeId; }
    public void setServiceId(int serviceId) { this.serviceId = serviceId; }
    public void setTripHeadsign(String tripHeadsign) { this.tripHeadsign = tripHeadsign; }
    public void setDirectionId(int directionId) { this.directionId = directionId; }
    public void setBlockId(String blockId) { this.blockId = blockId; }
    public void setShapeId(int shapeId) { this.shapeId = shapeId; }
}
