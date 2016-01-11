package org.jeffgrubb.NJTrains.model.agency.support;

import org.jeffgrubb.NJTrains.Connection;
import org.jeffgrubb.NJTrains.model.agency.Agency;
import org.jeffgrubb.NJTrains.model.agency.AgencyDao;
import org.jeffgrubb.NJTrains.model.DaoBase;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.sql.PreparedStatement;
import java.sql.SQLException;


/**
 * Created by jgrubb on 1/10/16.
 */
public class AgencyDaoImpl extends DaoBase implements AgencyDao {

    public AgencyDaoImpl(Connection connection) { super(connection); }

    public ArrayList<Agency> getAgenciesFromCsv(InputStream stream) {

        InputStreamReader is = new InputStreamReader(stream);
        BufferedReader reader = new BufferedReader(is);

        ArrayList<Agency> retValue = new ArrayList<Agency>();

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
                Agency agency = new Agency();
                agency.setId(tokens[i++].replace("\"", ""));
                agency.setName(tokens[i++].replace("\"", ""));
                agency.setUrl(tokens[i++].replace("\"", ""));
                agency.setTimezone(tokens[i++].replace("\"", ""));
                agency.setLang(tokens[i++].replace("\"", ""));
                agency.setPhone(tokens[i++].replace("\"", ""));

                retValue.add(agency);
            }
        }
        catch(IOException ex) {
            System.out.println("Caught IOException while reading agencies from file. Exception: " + ex.toString());
            ex.printStackTrace();
            retValue.clear();
        }

        return retValue;
    }

    public void saveAgency(Agency agency) {
        try {
            PreparedStatement ps = this.connection.prepareStatement("insert into agency\n" +
                    "(agency_id, agency_name, agency_url, agency_timezone, agency_lang, agency_phone)\n" +
                    "values (?, ?, ?, ?, ?, ?)");

            int i = 1;

            ps.setString(i++, agency.getId());
            ps.setString(i++, agency.getName());
            ps.setString(i++, agency.getUrl());
            ps.setString(i++, agency.getTimezone());
            ps.setString(i++, agency.getLang());
            ps.setString(i++, agency.getPhone());

            ps.executeUpdate();

        } catch(SQLException ex) {
            System.out.println("Caught SQLException trying to insert agency into the database. Exception: " + ex.toString());
            ex.printStackTrace();
        }
    }

    @Override
    protected String getTableName() {
        return "agency";
    }

    @Override
    protected String getTableDefinition() {
        return super.getTableDef("agency.sql");
    }
}
