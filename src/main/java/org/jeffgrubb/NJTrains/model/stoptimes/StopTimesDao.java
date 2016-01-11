package org.jeffgrubb.NJTrains.model.stoptimes;

import org.jeffgrubb.NJTrains.model.DatabaseModel;
import java.io.InputStream;
import java.util.ArrayList;

/**
 * Created by jgrubb on 1/10/16.
 */
public interface StopTimesDao extends DatabaseModel {
    ArrayList<StopTime> getStopTimesFromCsv(InputStream stream);
    void saveStopTime(StopTime stopTime);
}
