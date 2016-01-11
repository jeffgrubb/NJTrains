package org.jeffgrubb.NJTrains.model;

/**
 * Created by jgrubb on 1/10/16.
 */

import org.jeffgrubb.NJTrains.Connection;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.sql.SQLException;

public abstract class DaoBase implements DatabaseModel {
    protected Connection connection;

    public DaoBase() {}
    public DaoBase(Connection connection) {
        this.connection = connection;
    }

    protected String getTableDef(String sqlFileName) {
        InputStream stream = getResource(sqlFileName);

        if(stream == null) {
            System.out.println("Could not locate " + sqlFileName + " file in classpath");
            return null;
        }

        InputStreamReader reader = new InputStreamReader(stream);

        char[] buffer = new char[1024];
        int read = 0;

        String tableDef = "";

        try {
            while((read = reader.read(buffer, 0, 1024)) > 0) {
                tableDef += String.copyValueOf(buffer, 0, read);
            }
            reader.close();
        } catch(IOException ex) {
            System.out.println("Caught IO exception reading through file " + sqlFileName + ". Exception: " + ex.toString());
            ex.printStackTrace();
            tableDef = "";
        }

        return tableDef;
    }

    protected InputStream getResource(String resourceFileName) {
        InputStream stream = Thread.currentThread().getContextClassLoader().getResourceAsStream(resourceFileName);
        return stream;
    }

    protected abstract String getTableName();
    protected abstract String getTableDefinition();

    public void drop() {
        try {
            String sqlCmd = "drop table " + this.getTableName() + ";";
            System.out.println("Executing: " +  sqlCmd);
            this.connection.execute(sqlCmd);
        } catch(SQLException ex) {
            System.out.println("Caught exception dropping table : " + this.getTableName() + ". Exception: " + ex.toString());
        }
    }

    public void create() {
        try {
            String sqlCmd = this.getTableDefinition();
            System.out.println("Executing: " +  sqlCmd);
            this.connection.execute(sqlCmd);
        } catch(Exception ex) {
            System.out.println("Caught exception creating " + this.getTableName() + " table: " + ex.toString());
            ex.printStackTrace();
        }
    }
}
