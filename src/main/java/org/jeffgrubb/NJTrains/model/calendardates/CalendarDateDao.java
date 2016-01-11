package org.jeffgrubb.NJTrains.model.calendardates;

import org.jeffgrubb.NJTrains.model.DatabaseModel;
import java.io.InputStream;
import java.util.ArrayList;

/**
 * Created by jgrubb on 1/10/16.
 */
public interface CalendarDateDao extends DatabaseModel {
    ArrayList<CalendarDate> getCalendarDatesFromCsv(InputStream stream);
    void saveCalendarDate(CalendarDate date);
}
