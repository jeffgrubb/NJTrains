package org.jeffgrubb.NJTrains.model;

import org.jeffgrubb.NJTrains.model.agency.AgencyDao;
import org.jeffgrubb.NJTrains.model.agency.support.AgencyDaoImpl;
import org.jeffgrubb.NJTrains.model.calendardates.CalendarDateDao;
import org.jeffgrubb.NJTrains.model.calendardates.support.CalendarDatesDaoImpl;
import org.jeffgrubb.NJTrains.model.routes.RoutesDao;
import org.jeffgrubb.NJTrains.model.routes.support.RoutesDaoImpl;
import org.jeffgrubb.NJTrains.model.shapes.ShapesDao;
import org.jeffgrubb.NJTrains.model.shapes.support.ShapesDaoImpl;
import org.jeffgrubb.NJTrains.model.stops.StopsDao;
import org.jeffgrubb.NJTrains.model.stops.support.StopsDaoImpl;
import org.jeffgrubb.NJTrains.Connection;

/**
 * Created by jgrubb on 1/10/16.
 */

public class ModelFactory {
    private Connection connection;

    public ModelFactory(Connection connection) {
        this.connection = connection;
    }

    public AgencyDao getAgencyDao() {
        return new AgencyDaoImpl(this.connection);
    }
    public CalendarDateDao getCalendarDatesDao() {
        return new CalendarDatesDaoImpl(this.connection);
    }
    public RoutesDao getRouteDao() { return new RoutesDaoImpl(this.connection); }
    public ShapesDao getShapesDao() { return new ShapesDaoImpl(this.connection); }
    public StopsDao getStopsDao() { return new StopsDaoImpl(this.connection); }
}