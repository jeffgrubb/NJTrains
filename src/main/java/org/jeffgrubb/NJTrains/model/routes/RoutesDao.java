package org.jeffgrubb.NJTrains.model.routes;

import org.jeffgrubb.NJTrains.model.DatabaseModel;
import java.io.InputStream;
import java.util.ArrayList;

/**
 * Created by jgrubb on 1/10/16.
 */
public interface RoutesDao extends DatabaseModel {
    ArrayList<Route> getRoutesFromCsv(InputStream stream);
    void saveRoute(Route route);
}