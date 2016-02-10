package fr.isep.reverse;

import org.json.JSONObject;

import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by LoicMDIVAD on 22/12/2015.
 */
public class MysqlDatabase extends Database {

    public static final Class driver = com.mysql.jdbc.Driver.class;
    public static final String scheme = "jdbc:mysql://";

    public MysqlDatabase(String host, String port,
                         String schema, String user, String password){
        super(host, port, schema, user, password);
        setUrl(scheme + getHost()+":"+getPort()+"/"+getSchema());
        this.tables = new ArrayList<Table>();

    }

    public void getComponents(DatabaseMetaData meta) throws SQLException {
        // here the param stand for filtering
        // since we want all tables we just fill with "null"
        String[] types = {"TABLE"};
        ResultSet rs = meta.getTables(null, null, null, types);
        while(rs.next()){
            Table t = new MysqlTable(rs.getString("TABLE_NAME"), rs.getString("TABLE_TYPE"));
            //t.getComponents(meta);
            this.setTables(t);
        }
        try{
            rs.close();
        } catch (Exception ignored){
        } finally { rs.close(); /*Anyway*/ }
    }

    public String getSql() {

        String script = "DROP SCHEMA IF EXISTS "+getSchema()+";" +
                "\nCREATE SCHEMA sakila;\nUSE "+getSchema()+";\n\n";

        for(Table t : getTables()){
            script += "-- \n";
            script += "-- Billy & Loic proposition for `"+t.getName()+"` structure\n";
            script += "-- \n\n";
            script+= t.getSql();
        }
        return script;
    }

    public String getCvs() {
        return null;
    }

    public JSONObject getJson() {
        JSONObject js = new JSONObject();
        js.put("schema", getSchema());
        for(Table t : getTables()){
            js.append("tables", t.getName());
        }
        return js;
    }
}
