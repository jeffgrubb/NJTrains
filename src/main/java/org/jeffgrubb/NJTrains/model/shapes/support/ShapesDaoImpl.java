package org.jeffgrubb.NJTrains.model.shapes.support;

import org.jeffgrubb.NJTrains.Connection;
import org.jeffgrubb.NJTrains.model.DaoBase;
import org.jeffgrubb.NJTrains.model.shapes.Shape;
import org.jeffgrubb.NJTrains.model.shapes.ShapesDao;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by jgrubb on 1/10/16.
 */
public class ShapesDaoImpl extends DaoBase implements ShapesDao {

    public ShapesDaoImpl(Connection connection) { super(connection); }

    public ArrayList<Shape> getShapesFromCsv(InputStream stream) {

        InputStreamReader is = new InputStreamReader(stream);
        BufferedReader reader = new BufferedReader(is);

        ArrayList<Shape> retValue = new ArrayList<Shape>();

        try {
            int cnt = 0;
            for(String line; (line = reader.readLine()) != null; ) {

                // ignore first line
                if(cnt++ == 0) continue;

                String[] tokens = line.split("[,]");

                if(tokens.length != 5) {
                    System.out.println("Invalid input reading agencies from file. Length: " + tokens.length);
                }

                int i = 0;
                Shape shape = new Shape();
                shape.setShapeId(Integer.parseInt(tokens[i++]));
                shape.setShapePointLatitude(Double.parseDouble(tokens[i++]));
                shape.setShapePointLongitudue(Double.parseDouble(tokens[i++]));
                shape.setShapeSequence(Integer.parseInt(tokens[i++]));
                shape.setShapeDistanceTraveled(Double.parseDouble(tokens[i++]));


                retValue.add(shape);
            }
        }
        catch(IOException ex) {
            System.out.println("Caught IOException while reading agencies from file. Exception: " + ex.toString());
            ex.printStackTrace();
            retValue.clear();
        }

        return retValue;
    }

    public void saveShape(Shape shape) {
        try {
            PreparedStatement ps = this.connection.prepareStatement("insert into agency\n" +
                    "(agency_id, agency_name, agency_url, agency_timezone, agency_lang, agency_phone)\n" +
                    "values (?, ?, ?, ?, ?, ?)");

            int i = 1;

            /*ps.setString(i++, agency.getId());
            ps.setString(i++, agency.getName());
            ps.setString(i++, agency.getUrl());
            ps.setString(i++, agency.getTimezone());
            ps.setString(i++, agency.getLang());
            ps.setString(i++, agency.getPhone());*/

            ps.executeUpdate();

        } catch(SQLException ex) {
            System.out.println("Caught SQLException trying to insert agency into the database. Exception: " + ex.toString());
            ex.printStackTrace();
        }
    }

    @Override
    protected String getTableName() {
        return "shapes";
    }

    @Override
    protected String getTableDefinition() {
        return super.getTableDef("shapes.sql");
    }
}
