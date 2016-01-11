package org.jeffgrubb.NJTrains.model.stoptimes.support;

import org.jeffgrubb.NJTrains.Connection;
import org.jeffgrubb.NJTrains.model.DaoBase;
import org.jeffgrubb.NJTrains.model.stoptimes.StopTime;
import org.jeffgrubb.NJTrains.model.stoptimes.StopTimesDao;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.Date;

import java.util.ArrayList;

/**
 * Created by jgrubb on 1/10/16.
 */
public class StopTimesDaoImpl extends DaoBase implements StopTimesDao {

    public StopTimesDaoImpl(Connection connection) { super(connection); }

    public ArrayList<StopTime> getStopTimesFromCsv(InputStream stream) {

        InputStreamReader is = new InputStreamReader(stream);
        BufferedReader reader = new BufferedReader(is);

        ArrayList<StopTime> retValue = new ArrayList<StopTime>();

        try {
            int cnt = 0;
            for(String line; (line = reader.readLine()) != null; ) {

                // ignore first line
                if(cnt++ == 0) continue;

                String[] tokens = line.split("[,]");

                if(tokens.length != 8) {
                    System.out.println("Invalid input reading stoptimes from file. Length: " + tokens.length);
                }

                int i = 0;

                StopTime stopTime = new StopTime();
                stopTime.setTripId(Integer.parseInt(tokens[i++]));

                // todo - this is a 27 hour thing that I have to figure out how it works...
                /*
                String ts = tokens[i++];

                SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd", Locale.ENGLISH);
                Date d;


                try {
                    d = sdf.parse(dateString);
                } catch(java.text.ParseException ex) {
                    System.out.println("Caught exception parsing date: " + dateString + ", Exception: " + ex.toString());
                    continue;
                }

                stopTime.setStopId();

                retValue.add(stop);*/
            }
        }
        catch(IOException ex) {
            System.out.println("Caught IOException while reading stoptimes from file. Exception: " + ex.toString());
            ex.printStackTrace();
            retValue.clear();
        }

        return retValue;
    }

    public void saveStopTime(StopTime stopTime) {
        /*try {
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
        */
    }

    @Override
    protected String getTableName() {
        return "stop_times";
    }

    @Override
    protected String getTableDefinition() {
        return super.getTableDef("stop_times.sql");
    }
}
