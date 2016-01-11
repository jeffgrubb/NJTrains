package org.jeffgrubb.NJTrains;

/**
 * Created by jgrubb on 1/2/16.
 */

import java.sql.SQLException;

public class ConnectionFactory {

    public static Connection getConnection(DatabaseProperties props) throws SQLException {

        System.out.println("Looking for connection: " + props.getName());
        if(props.getName().equalsIgnoreCase("PostgreSQL")) {
            return new PostgresConnection(props);
        }
        return null;
    }
}

