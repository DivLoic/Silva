package fr.isep.reverse;

import org.json.JSONObject;

import java.sql.DatabaseMetaData;
import java.sql.SQLException;

/**
 * Created by LoicMDIVAD on 24/12/2015.
 */
public class MysqlForeignKey extends ForeignKey {

    public MysqlForeignKey(String name, String tableRef, String colRef, int update, int delete) {
        super(name, tableRef, colRef, update, delete);
    }

    public void getComponents(DatabaseMetaData meta) throws SQLException {

    }

    public String getSql() {
        String statement = "CONSTRAINT";
        statement += " " + "`" +getName()+ "`";
        statement += " FOREIGN KEY (" + getReferences().getValue() + ")";
        statement += " REFERENCES " +getReferences().getKey()+ " ("+getReferences().getValue()+")";
        statement += " ON DELETE " +constraint(getDelete());
        statement += " ON UPDATE " +constraint(getUpdate());
        return statement;
    }

    public String getCvs() {
        return null;
    }

    public static String constraint(int rule){
        String referenceOption;
        switch (rule){
            case 0:
                referenceOption = "CASCADE";
                break;
            case 1:
                referenceOption = "NO ACTION";
                break;
            case 2:
                referenceOption = "SET NULL";
                break;
            case 3:
                referenceOption = "RESTRICT";
                break;
            case 4:
                referenceOption = "SET DEFAULT";
                break;
            default:
                referenceOption = "RESTRICT";
                break;

        }
        return referenceOption;
    }

    public JSONObject getJson() {
        JSONObject j = new JSONObject();
        j.put("constraint", getName());
        j.append("references", new JSONObject().put("table", getReferences().getKey()));
        j.append("references", new JSONObject().put("table", "id"));
        j.put("exported", getReferences().getKey());
        j.put("delete", constraint(getDelete()));
        j.put("update", constraint(getUpdate()));
        return j;
    }
}
