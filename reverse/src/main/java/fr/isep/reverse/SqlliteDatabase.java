package fr.isep.reverse;

import org.json.JSONObject;

import java.sql.DatabaseMetaData;
import java.sql.SQLException;

/**
 * Created by LoicMDIVAD on 26/12/2015.
 */
public class SqlliteDatabase extends Database {

    public static final Class driver = org.sqlite.JDBC.class;
    public static final String scheme = "jdbc:sqlite://";

    public SqlliteDatabase(String host, String port, String schema, String user, String password) {
        super(host, port, schema, user, password);
        setUrl(scheme + "/" +getSchema() + "/");
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
