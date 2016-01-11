package org.jeffgrubb.NJTrains.model.shapes;

/**
 * Created by jgrubb on 1/10/16.
 */

public class Shape {
    private int shapeId;
    private int shapeSequence;
    private double shapePtLat;
    private double shapePtLon;
    private double shapeDistTraveled;

    public int getShapeId() { return shapeId; }
    public int getShapeSequence() { return shapeSequence; }
    public double getShapePointLatitude() { return shapePtLat; }
    public double getShapePointLongitude() { return shapePtLon; }
    public double getShapeDistanceTraveled() { return shapeDistTraveled; }

    public void setShapeId(int shapeId) { this.shapeId = shapeId; }
    public void setShapeSequence(int shapeSequence) { this.shapeSequence = shapeSequence; }
    public void setShapePointLatitude(double shapePtLat) { this.shapePtLat = shapePtLat; }
    public void setShapePointLongitudue(double shapePtLon) { this.shapePtLon = shapePtLon; }
    public void setShapeDistanceTraveled(double shapeDistTraveled) { this.shapeDistTraveled = shapeDistTraveled; }

    @Override
    public String toString() {
        return new StringBuilder()
                .append("Shape\n")
                .append("---------------\n")
                .append( String.format( "Id: %s\n", shapeId ) )
                .append( String.format( "Sequence: %s\n", shapeSequence ) )
                .append( String.format( "Latitude: %s\n", shapePtLat) )
                .append( String.format( "Longitude: %s\n", shapePtLon) )
                .append( String.format( "Distance Traveled: %s\n", shapeDistTraveled) )
                .toString();
    }

}
