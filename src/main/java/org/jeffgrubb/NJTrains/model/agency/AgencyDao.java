package org.jeffgrubb.NJTrains.model.agency;

import java.io.InputStream;
import java.util.ArrayList;
import org.jeffgrubb.NJTrains.model.DatabaseModel;

/**
 * Created by jgrubb on 1/10/16.
 */
public interface AgencyDao extends DatabaseModel {
    ArrayList<Agency> getAgenciesFromCsv(InputStream stream);
    void saveAgency(Agency agency);
}
