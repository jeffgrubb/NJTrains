package org.jeffgrubb.NJTrains;

/**
 * Created by jgrubb on 1/2/16.
 */

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.lang.ClassNotFoundException;

public class PostgresConnection implements Connection {

    private java.sql.Connection connection;
    private DatabaseProperties properties;

    public PostgresConnection(DatabaseProperties props) {
        properties = props;
    }

    public void execute(String statement) throws SQLException {
        PreparedStatement ps = connection.prepareStatement(statement);
        ps.executeUpdate();
    }

    public void open() throws SQLException {
        try {
            Class.forName("org.postgresql.Driver");
        }
        catch(ClassNotFoundException ex) {
            throw new SQLException(ex);
        }
        connection = DriverManager.getConnection(properties.getUrl(), properties.getUser(), properties.getPassword());
    }

    public void close() throws SQLException {
        if(connection == null) return;
        connection.close();
        connection = null;
    }

    public PreparedStatement prepareStatement(String cmd) throws SQLException {
        if(connection == null) throw new SQLException("Connection was null");
        return connection.prepareStatement(cmd);
    }
}
