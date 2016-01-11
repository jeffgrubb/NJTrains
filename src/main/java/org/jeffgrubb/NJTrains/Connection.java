package org.jeffgrubb.NJTrains;

import java.sql.SQLException;
import java.sql.PreparedStatement;

/**
 * Created by jgrubb on 1/2/16.
 */
public interface Connection {
    void open() throws SQLException;
    void close() throws SQLException;
    void execute(String statement) throws SQLException;
    PreparedStatement prepareStatement(String cmd) throws SQLException;
}
