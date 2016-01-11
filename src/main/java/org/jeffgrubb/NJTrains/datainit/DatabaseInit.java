/**
 * Created by jgrubb on 12/13/15.
 */

package org.jeffgrubb.NJTrains.datainit;

import org.jeffgrubb.NJTrains.Connection;
import org.jeffgrubb.NJTrains.model.ModelFactory;
import org.jeffgrubb.NJTrains.model.routes.RoutesDao;
import org.jeffgrubb.NJTrains.model.routes.Route;

import org.jeffgrubb.NJTrains.model.calendardates.CalendarDateDao;
import org.jeffgrubb.NJTrains.model.calendardates.CalendarDate;
import org.jeffgrubb.NJTrains.model.shapes.ShapesDao;
import org.jeffgrubb.NJTrains.model.shapes.Shape;
import org.jeffgrubb.NJTrains.model.stops.StopsDao;
import org.jeffgrubb.NJTrains.model.stops.Stop;


import java.io.InputStream;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;

public class DatabaseInit
{
    private Connection connection;

    public DatabaseInit(Connection connection) {
        this.connection = connection;
    }

    public void initDatabase() throws SQLException {
        // drop the tables if they already exist..

        ModelFactory factory = new ModelFactory(this.connection);

        StopsDao stopsData = factory.getStopsDao();

        ArrayList<Stop> stops = stopsData.getStopsFromCsv(getResource("stops.csv"));

        Iterator<Stop> it = stops.iterator();
        while(it.hasNext()) {
            Stop stop = it.next();
            System.out.println(stop.toString());
        }


        /*
        ShapesDao shapesData = factory.getShapesDao();

        ArrayList<Shape> shapes = shapesData.getShapesFromCsv(getResource("shapes.csv"));

        Iterator<Shape> it = shapes.iterator();
        while(it.hasNext()) {
            Shape shape = it.next();
            System.out.println(shape.toString());
        }

        CalendarDateDao calendarData = factory.getCalendarDatesDao();

        ArrayList<CalendarDate> agencies = calendarData.getCalendarDatesFromCsv(getResource("calendar_dates.csv"));

        Iterator<CalendarDate> it = agencies.iterator();
        while(it.hasNext()) {
            CalendarDate date = it.next();
            System.out.println(date.toString());
        }

        AgencyDao agencyData = factory.getAgencyDao();
        agencyData.drop();
        agencyData.create();

        ArrayList<Agency> agencies = agencyData.getAgenciesFromCsv(getResource("agency.csv"));

        Iterator<Agency> it = agencies.iterator();
        while(it.hasNext()) {
            Agency age = it.next();
            System.out.println(age.toString());
            agencyData.saveAgency(age);
        }

        RoutesDao routesDao = factory.getRouteDao();
        routesDao.drop();
        routesDao.create();

        ArrayList<Route> routes = routesDao.getRoutesFromCsv(getResource("routes.csv"));

        Iterator<Route> it = routes.iterator();
        while(it.hasNext()) {
            Route route = it.next();
            System.out.println(route.toString());
        }*/
    }

    private InputStream getResource(String resourceFileName) {
        InputStream stream = Thread.currentThread().getContextClassLoader().getResourceAsStream(resourceFileName);
        return stream;
    }
}
