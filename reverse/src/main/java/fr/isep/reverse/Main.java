package fr.isep.reverse;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

/**
 * Created by LoicMDIVAD on 22/12/2015.
 */
public class Main {

    public static void main(String[] args) throws TooLazyStudentException {

        final String HOST = args[0];
        final String PORT = args[1];
        final String SCHEMA = args[2];
        final String USER = args[3];
        final String PASSWD = args[4];
        final String DRIVER = args[5];

        Database bdd = null;
        Connection connection = null;
        PrintWriter printer = null;

        bdd = Database.factory(DRIVER, HOST, PORT, SCHEMA, USER, PASSWD);
        connection = bdd.connect(); //The programme will stop here if it's null

        // -- building the db representation
        try {
            DatabaseMetaData meta = connection.getMetaData();
            bdd.getComponents(meta);

            for(Table t : bdd.getTables()) {
                t.getComponents(meta);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        // -- writing
        try {
            File file = new File(bdd.getSchema()+"-structure.sql");
            file.createNewFile();
            printer = new PrintWriter(file.getAbsolutePath());
            printer.write(bdd.getSql());
        } catch (IOException e) {
            e.printStackTrace();
        }

        // -- closing
        try {
            connection.close();
            printer.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {connection.close();} catch (Exception e){/*Anyway*/}
            try {printer.close();} catch (Exception e){/*Anyway*/}
        }
    }
}
