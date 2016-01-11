package org.jeffgrubb.NJTrains.model.trips;

import org.jeffgrubb.NJTrains.model.DatabaseModel;
import org.jeffgrubb.NJTrains.model.stoptimes.StopTime;

import java.io.InputStream;
import java.util.ArrayList;

/**
 * Created by jgrubb on 1/10/16.
 */
public interface TripsDao extends DatabaseModel {
    ArrayList<Trip> getTripsFromCsv(InputStream stream);
    void saveTrip(Trip trip);
}
