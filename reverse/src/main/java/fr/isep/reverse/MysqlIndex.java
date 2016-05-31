package fr.isep.reverse;

import org.json.JSONObject;
import java.sql.DatabaseMetaData;
import java.sql.SQLException;

/**
 * Created by LoicMDIVAD on 23/12/2015.
 */
public class MysqlIndex extends Index {

    public MysqlIndex(String name, String key, String ascending) {
        super(name, key, ascending);
    }

    public void getComponents(DatabaseMetaData meta) throws SQLException {}

    public String getSql() {
        if(getName() != null )return "KEY "+getName()+" ("+getKey()+")";
        return "\tKEY ("+getKey()+")";

    }

    public String getCvs() {
        return null;
    }

    public JSONObject getJson() {
        Boolean asc = (getAscending() != null && getAscending().equals("A")) ? true : false;
        JSONObject js = new JSONObject();
        js.put("index", getName());
        js.put("key", getKey());
        js.put("ascending", asc);
        return js;
    }
}
