package fr.isep.reverse;

import org.json.JSONObject;

/**
 * Created by LoicMDIVAD on 23/12/2015.
 */
public class MysqlColumn extends Column {

    public MysqlColumn(String name, String type, int size, Boolean nullable, Boolean inc, String bydefault) {
        super(name, type, size, nullable, inc, bydefault);
    }

    /**
     * Overriding here make us able to introduce mysql column syntax
     * if we one day move for a postgres sql database
     * we will overriding the getStirng of PostgreTbales
     * @return
     */
    @Override
    public String getSql() {
        String statement  = "\t" + getName();

        // add types
        if(getType().equals("VARCHAR")){
            statement += " " + getType()+"("+getSize()+")";
        } else {
            statement += " " + getType();
        }
        // -- is null ?
        if (!getNullable()) {
            statement += " NOT NULL";
        }
        // -- is default null ?
        if(!getNullable() && getBydefault() == null){

        } else if(getNullable() && getBydefault() == null){
            statement += " DEFAULT NULL";
        } else {
            statement += " DEFAULT " + getBydefault();
        }
        // -- is auto increment ?
        if(getAutoInc()){
            statement += " AUTO_INCREMENT";
        }

        return statement += ",";
    }

    @Override
    public JSONObject getJson() {
        return null;
    }

    public String getCvs() {
        return null;
    }
}
