package org.jeffgrubb.NJTrains.model.stops;

/**
 * Created by jgrubb on 1/10/16.
 */

public class Stop {
    private int stopId;
    private int stopCode;
    private String stopName;
    private String stopDesc;
    private double stopLat;
    private double stopLon;
    private int zoneId;

    public int getId() { return stopId; }
    public int getCode() { return stopCode; }
    public String getName() { return stopName; }
    public String getDescription() { return stopDesc; }
    public double getLatitude() { return stopLat; }
    public double getLongitude() { return stopLon; }
    public int getZoneId() { return zoneId; }

    public void setId(int stopId) { this.stopId = stopId; }
    public void setCode(int stopCode) { this.stopCode = stopCode; }
    public void setName(String stopName) { this.stopName = stopName; }
    public void setDescription(String stopDesc) { this.stopDesc = stopDesc; }
    public void setLatitude(double stopLat) { this.stopLat = stopLat; }
    public void setLongitude(double stopLon) { this.stopLon = stopLon; }
    public void setZoneId(int zoneId) { this.zoneId = zoneId; }

    @Override
    public String toString() {
        return new StringBuilder()
                .append("Stop\n")
                .append("---------------\n")
                .append( String.format( "Id: %s\n", stopId ) )
                .append( String.format( "Code: %s\n", stopCode ) )
                .append( String.format( "Name: %s\n", stopName) )
                .append( String.format( "Description: %s\n", stopDesc) )
                .append( String.format( "Latitude: %s\n", stopLat) )
                .append( String.format( "Longitude: %s\n", stopLon) )
                .append( String.format( "ZoneId: %s\n", zoneId) )
                .toString();
    }
}
