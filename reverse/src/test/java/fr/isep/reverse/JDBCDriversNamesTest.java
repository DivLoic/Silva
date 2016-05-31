package fr.isep.reverse;

import fr.isep.reverse.JDBCDriversNames;
import fr.isep.reverse.MysqlDatabase;
import fr.isep.reverse.PostgresDatabase;
import junit.framework.TestCase;

/**
 * Created by LoicMDIVAD on 26/12/2015.
 */
public class JDBCDriversNamesTest extends TestCase {

    public void setUp() throws Exception {
        super.setUp();
    }

    public void testToString() throws Exception {
        assertEquals("com.mysql.jdbc.Driver", JDBCDriversNames.mysql.toString());
        assertEquals("org.postgresql.Driver", JDBCDriversNames.postgres.toString());
        assertEquals("org.sqlite.JDBC", JDBCDriversNames.sqllite.toString());
        assertEquals("oracle.jdbc.driver.OracleDriver", JDBCDriversNames.oracle.toString());

        assertEquals(MysqlDatabase.driver.toString().substring(6), JDBCDriversNames.mysql.toString());
    }

    public void testGetDatabase() throws Exception {
        Class wrapper1 = JDBCDriversNames.mysql.getDatabase();
        assertEquals(wrapper1, MysqlDatabase.class);

        Class wrapper2 = JDBCDriversNames.postgres.getDatabase();
        assertEquals(wrapper2, PostgresDatabase.class);
    }
}