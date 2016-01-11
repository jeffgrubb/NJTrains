/**
 * Created by jgrubb on 12/13/15.
 */

package org.jeffgrubb.NJTrains;

import org.jeffgrubb.NJTrains.datainit.DatabaseInit;
import org.yaml.snakeyaml.Yaml;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

public class NJTrains {

    public static void main(String[] args) throws Exception {

        if(args.length < 2) {
            printUseage();
            return;
        }

        Yaml yaml = new Yaml();
        InputStream in = Files.newInputStream( Paths.get( args[0]) );

        Configuration config = yaml.loadAs(in, Configuration.class);
        System.out.println(config.toString());

        if(args[1].compareToIgnoreCase("init") == 0) {
            Connection connection = ConnectionFactory.getConnection(config.getDatabaseProperties());
            if(connection == null) {
                System.out.println("Database not found");
                return;
            }
            connection.open();
            DatabaseInit init = new DatabaseInit(connection);
            init.initDatabase();
            connection.close();
        } else {
            printUseage();
        }
    }

    public static void printUseage() {
        System.out.println("Useage: njtrains config.yaml [init | tbd]");
    }
}
