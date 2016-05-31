package fr.isep.reverse;

/**
 * Created by LoicMDIVAD on 19/12/2015.
 * Enumeration mapping between driver and their fr.isep.reverse.Database wrapper
 * Maybe less flexibale code... but at least we try
 * TODO: REPLACE THIS WITH REFLEXION, see: https://github.com/ronmamo/reflections
 */
public enum JDBCDriversNames {
    mysql (MysqlDatabase.driver.toString(), MysqlDatabase.class),
    postgres (PostgresDatabase.driver.toString(), PostgresDatabase.class),
    oracle("class oracle.jdbc.driver.OracleDriver", OracleDatabase.class),
    sqllite (SqlliteDatabase.driver.toString(), SqlliteDatabase.class);

    private String driver = "";
    private Class dbClass = null;

    JDBCDriversNames(String driver, Class db){
        this.driver = driver;
        this.dbClass = db;
    }

    @Override
    public String toString() {
        return driver.substring(6);
    }

    public Class getDatabase(){
        return this.dbClass;
    }
}
