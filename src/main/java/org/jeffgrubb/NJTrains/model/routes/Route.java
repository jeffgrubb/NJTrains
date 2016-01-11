package org.jeffgrubb.NJTrains.model.routes;

/**
 * Created by jgrubb on 1/10/16.
 */

import org.jeffgrubb.NJTrains.model.ModelBase;

public class Route {
    private int routeId;
    private String agencyId;
    private String routeShortName;
    private String routeLongName;
    private int routeType;
    private String routeUrl;
    private String routeColor;

    public int getId() { return routeId; }
    public String getAgencyId() { return agencyId; }
    public String getShortName() { return routeShortName; }
    public String getLongName() { return routeLongName; }
    public int getType() { return routeType; }
    public String getUrl() { return routeUrl; }
    public String getColor() { return routeColor; }

    public void setId(int routeId) { this.routeId = routeId; }
    public void setAgencyId(String agencyId) { this.agencyId = agencyId; }
    public void setShortName(String routeShortName) { this.routeShortName = routeShortName; }
    public void setLongName(String routeLongName) { this.routeLongName = routeLongName; }
    public void setType(int routeType) { this.routeType = routeType; }
    public void setUrl(String routeUrl) { this.routeUrl = routeUrl; }
    public void setColor(String routeColor) { this.routeColor = routeColor; }

    @Override
    public String toString() {
        return new StringBuilder()
                .append("Route\n")
                .append("---------------\n")
                .append( String.format( "Id: %s\n", routeId ) )
                .append( String.format( "Agency: %s\n", agencyId ) )
                .append( String.format( "ShortName: %s\n", routeShortName) )
                .append( String.format( "LongName: %s\n", routeLongName) )
                .append( String.format( "Type: %s\n", routeType) )
                .append( String.format( "Url: %s\n", routeUrl) )
                .append( String.format( "Color: %s\n", routeColor) )
                .toString();
    }
}
