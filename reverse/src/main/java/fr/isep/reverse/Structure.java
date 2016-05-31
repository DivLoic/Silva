package fr.isep.reverse;

import org.json.JSONObject;
import java.sql.DatabaseMetaData;
import java.sql.SQLException;

/**
 * Created by LoicMDIVAD on 22/12/2015.
 */
public interface Structure {

    /**
     * retrive substructure of sql element <br/>
     * fetch the table for a database <br/>
     * fetch the column for a table <br/>
     */
    public abstract void getComponents(DatabaseMetaData meta) throws SQLException;
    // TODO: Replace DatabaseMetadata by a ResultSet in the getComponents

    /**
     * convert a Relational element to a string
     * Mostly used in sql script
     * @return
     */
    public abstract String getSql();

    /**
     * convert a Relational element to csv,
     * this will be very used full for creating a mocking system
     * for the tests
     * @return
     */
    public abstract String getCvs();

    /**
     * convert a Relational element to a JSON Object <br/>
     * ... we never know, just in case.
     * @return
     */
    public abstract JSONObject getJson();

}
