package org.jeffgrubb.NJTrains;

/**
 * Created by jgrubb on 1/1/16.
 */

import java.util.Date;

public class Configuration {
    private String version;
    private Date released;
    private DatabaseProperties databaseProperties;

    public Date getReleased() {
        return released;
    }

    public void setReleased(Date released) {
        this.released = released;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public DatabaseProperties getDatabaseProperties() {
        return databaseProperties;
    }

    public void setDatabaseProperties(DatabaseProperties properties) {
        this.databaseProperties = properties;
    }

    @Override
    public String toString() {
        return new StringBuilder()
                .append( String.format( "Version: %s\n", version ) )
                .append( String.format( "Released: %s\n", released ) )
                .append( String.format( "Connecting to database: %s\n", databaseProperties.getUrl() ) )
                .toString();
    }
}
