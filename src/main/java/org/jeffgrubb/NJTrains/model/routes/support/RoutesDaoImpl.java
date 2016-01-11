package org.jeffgrubb.NJTrains.model.routes.support;

import org.jeffgrubb.NJTrains.Connection;
import org.jeffgrubb.NJTrains.model.DaoBase;
import org.jeffgrubb.NJTrains.model.routes.Route;
import org.jeffgrubb.NJTrains.model.routes.RoutesDao;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * Created by jgrubb on 1/10/16.
 */
public class RoutesDaoImpl extends DaoBase implements RoutesDao {

    public RoutesDaoImpl(Connection connection) { super(connection); }

    public ArrayList<Route> getRoutesFromCsv(InputStream stream) {

        InputStreamReader is = new InputStreamReader(stream);
        BufferedReader reader = new BufferedReader(is);

        ArrayList<Route> retValue = new ArrayList<Route>();

        try {
            int cnt = 0;
            for(String line; (line = reader.readLine()) != null; ) {

                // ignore first line
                if(cnt++ == 0) continue;

                String[] tokens = line.split("[,]");

                if(tokens.length != 6) {
                    System.out.println("Invalid input reading agencies from file. Length: " + tokens.length);
                }

                int i = 0;
                Route route = new Route();
                route.setId(Integer.parseInt(tokens[i++].replace("\"", "")));
                route.setAgencyId(tokens[i++].replace("\"", ""));
                route.setShortName(tokens[i++].replace("\"", ""));
                route.setLongName(tokens[i++].replace("\"", ""));
                route.setType(Integer.parseInt(tokens[i++].replace("\"", "")));
                route.setUrl(tokens[i++].replace("\"", ""));
                //route.setColor(tokens[i++].replace("\"", "")); not yet implemented

                retValue.add(route);
            }
        }
        catch(IOException ex) {
            System.out.println("Caught IOException while reading agencies from file. Exception: " + ex.toString());
            ex.printStackTrace();
            retValue.clear();
        }

        return retValue;
    }

    public void saveRoute(Route route) {

    }

    @Override
    protected String getTableName() {
        return "routes";
    }

    @Override
    protected String getTableDefinition() {
        return super.getTableDef("routes.sql");
    }
}
