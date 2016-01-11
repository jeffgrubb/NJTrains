package org.jeffgrubb.NJTrains.model.stops;

import org.jeffgrubb.NJTrains.model.DatabaseModel;
import java.io.InputStream;
import java.util.ArrayList;

/**
 * Created by jgrubb on 1/10/16.
 */
public interface StopsDao extends DatabaseModel {
    ArrayList<Stop> getStopsFromCsv(InputStream stream);
    void saveStop(Stop stop);
}
