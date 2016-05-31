package fr.isep.reverse;

import org.json.JSONObject;

import java.sql.DatabaseMetaData;
import java.sql.SQLException;

/**
 * Created by LoicMDIVAD on 22/12/2015.
 */
public abstract class Column implements Structure {

    private String name;
    private String type;
    private int size;
    private Boolean nullable;   // can be null
    private String bydefault;   // the default value
    private Boolean autoInc;    // is an autoincrement column

    public Column(String name, String type, int size, Boolean nullable, Boolean inc, String bydefault) {
        this.name = name;
        this.type = type;
        this.size = size;
        this.autoInc = inc;
        this.nullable = nullable;
        this.bydefault = bydefault;
    }

    public void getComponents(DatabaseMetaData meta) throws SQLException {
        // -- Here we don't do anything since columns
        // -- don't have sub components
    }

    // -- abstracts

    public abstract String getSql();

    public abstract JSONObject getJson();

    // -- setters

    public void setName(String name) {
        this.name = name;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public void setNullable(Boolean nullable) {
        this.nullable = nullable;
    }

    public void setBydefault(String bydefault) {
        this.bydefault = bydefault;
    }

    public void setAutoInc(Boolean autoInc) {
        this.autoInc = autoInc;
    }

    // -- getters

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public int getSize() {
        return size;
    }

    public Boolean getNullable() {
        return nullable;
    }

    public String getBydefault() {
        return bydefault;
    }

    public Boolean getAutoInc() {
        return autoInc;
    }
}
