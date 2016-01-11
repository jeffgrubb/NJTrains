package org.jeffgrubb.NJTrains.model.shapes;

import org.jeffgrubb.NJTrains.model.DatabaseModel;
import java.io.InputStream;
import java.util.ArrayList;

/**
 * Created by jgrubb on 1/10/16.
 */
public interface ShapesDao extends DatabaseModel {
    ArrayList<Shape> getShapesFromCsv(InputStream stream);
    void saveShape(Shape shape);
}