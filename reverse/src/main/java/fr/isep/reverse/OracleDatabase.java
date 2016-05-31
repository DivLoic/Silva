package fr.isep.reverse;

import org.json.JSONObject;

import java.sql.DatabaseMetaData;
import java.sql.SQLException;

/**
 * Created by LoicMDIVAD on 26/12/2015.
 */
public class OracleDatabase extends Database{

    public static final Class driver = null;
    // null oracle class driver since tht src is private
    public static final String scheme = "jdbc:oracle://";

    public OracleDatabase(String host, String port, String schema, String user, String password) {
        super(host, port, schema, user, password);
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
