package fr.isep.reverse;

import org.json.JSONObject;

import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by LoicMDIVAD on 23/12/2015.
 */
public class MysqlTable extends Table {

    public MysqlTable(String name, String type) {
        super(name, type);
    }

    /**
     * this is the implementation of the abstract fetchColomns from fr.isep.reverse.Table <br/>
     * Because the type column depend of the database used
     * @param meta
     * @throws SQLException
     */
    @Override
    public void fetchColumns(DatabaseMetaData meta) throws SQLException {
        // Here we are basically not interested with all columns
        // So we filter with the name of the table:this.name.
        Boolean inc  = null;
        ResultSet rs = meta.getColumns(null, null, getName(), null);
        while(rs.next()){
            /*let's fix shity bug on autoincrement*/
            try{inc=rs.getBoolean("IS_AUTOINCREMENT");}catch(Exception e){inc=false;}
            Column c = new MysqlColumn(rs.getString("COLUMN_NAME"),
                    rs.getString("TYPE_NAME"),
                    rs.getInt("COLUMN_SIZE"),
                    rs.getBoolean("NULLABLE"),inc,
                    rs.getString("COLUMN_DEF"));
            this.setColumns(c);
        }
        try {
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void fetchIndices(DatabaseMetaData meta) throws SQLException {
        ResultSet rs = meta.getIndexInfo(null, null, getName(), false, false);
        while (rs.next()){
            Index i = new MysqlIndex(rs.getString("INDEX_NAME"),
                    rs.getString("COLUMN_NAME"),
                    rs.getString("ASC_OR_DESC"));
            this.setIndices(i);
        }
        try{
            rs.close();
        } catch (SQLException ignored){
        } finally { rs.close(); /*Anyway*/ }
    }

    @Override
    public void fetchForeignKeys(DatabaseMetaData meta) throws SQLException {
        ResultSet rs = meta.getImportedKeys(null, null, getName());
        while (rs.next()){
            ForeignKey fk = new MysqlForeignKey(rs.getString("FK_NAME"),
                    rs.getString("PKTABLE_NAME"),
                    rs.getString("FKCOLUMN_NAME"),
                    rs.getInt("UPDATE_RULE"),
                    rs.getInt("DELETE_RULE"));
            this.setForeignKeys(fk);
        }
        try{
            rs.close();
        } catch (SQLException ignored){
        } finally { rs.close(); /*Anyway*/ }
    }


    /**
     * Overriding here make us able to introduice mysql syntax
     * if we one day move for a postgres sql database
     * we will overriding the getStirng of PostgreTbales
     * @return
     */
    public String getSql() {
        String statement = "CREATE TABLE "+getName()+" (";
        for(Column c : getColumns()){
            statement += "\n" + c.getSql();
        }
        if(getPrimary() != null) statement += "\n\tPRIMARY KEY ("+getPrimary()+"),";
        for(Index i : getIndices()){
            if(!i.getName().equals("PRIMARY"))statement += "\n\t" + i.getSql() + ",";
        }
        for(ForeignKey fk : getForeignKeys()){
            statement += "\n\t" + fk.getSql() + ",";
        }

        if(statement.charAt(statement.length() - 1) == ','){
            statement = statement.substring(0, statement.length() - 1);
        }

        statement += "\n); \n\n";

        return statement;
    }

    public String getCvs() {
        return null;
    }

    public JSONObject getJson() {
        return null;
    }
}
