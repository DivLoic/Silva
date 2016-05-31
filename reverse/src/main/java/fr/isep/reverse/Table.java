package fr.isep.reverse;

import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by LoicMDIVAD on 22/12/2015.
 */
public abstract class Table implements Structure {

    private String name;
    private String type;
    private String primary;

    /*here is 3 types of relational components*/
    private List<Column> columns;
    private List<Index> indices;
    private List<ForeignKey> foreignKeys;

    public Table(String name, String type){
        setName(name);
        setType(type);
        this.columns = new ArrayList<Column>();
        this.indices = new ArrayList<Index>();
        this.foreignKeys = new ArrayList<ForeignKey>();
    }

    public void getComponents(DatabaseMetaData meta) throws SQLException {
        fetchColumns(meta);
        fetchPrimary(meta);
        fetchIndices(meta);
        fetchForeignKeys(meta);
    }

    public void fetchPrimary(DatabaseMetaData meta) throws SQLException {
        ResultSet rs = meta.getPrimaryKeys(null, null, getName());
        if(rs.next()) setPrimary(rs.getString("COLUMN_NAME"));
    }

    // -- a few abstracts,

    public abstract void fetchColumns(DatabaseMetaData meta) throws SQLException;

    public abstract void fetchIndices(DatabaseMetaData meta) throws SQLException;

    public abstract void fetchForeignKeys(DatabaseMetaData meta) throws SQLException;

    // -- setters

    public void setName(String name) {
        this.name = name;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setPrimary(String primary) {
        this.primary = primary;
    }

    public void setColumns(Column columns) {
        this.columns.add(columns);
    }

    public void setIndices(Index indices) {
        this.indices.add(indices);
    }

    public void setForeignKeys(ForeignKey foreignKeys) {
        this.foreignKeys.add(foreignKeys);
    }

    // -- getters

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public String getPrimary() {
        return primary;
    }

    public List<Column> getColumns() {
        return columns;
    }

    public List<Index> getIndices() {
        return indices;
    }

    public List<ForeignKey> getForeignKeys() {
        return foreignKeys;
    }
}
