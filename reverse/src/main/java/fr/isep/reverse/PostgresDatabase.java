package fr.isep.reverse;

import org.json.JSONObject;

import java.sql.DatabaseMetaData;
import java.sql.SQLException;

/**
 * Created by LoicMDIVAD on 26/12/2015.
 */
public class PostgresDatabase extends Database {

    public static final Class driver = org.postgresql.Driver.class;
    public static final String scheme = "jdbc:postgresql://";

    public PostgresDatabase(String host, String port, String schema, String user, String password) {
        super(host, port, schema, user, password);
        setUrl(scheme + getHost()+":"+getPort()+"/"+getSchema());
    }

    public void getComponents(DatabaseMetaData meta) throws SQLException {

    }

    public String getSql() {
        return null;
    }

    public String getCvs() {
        return null;
    }

    public JSONObject getJson() {
        return null;
    }
}
