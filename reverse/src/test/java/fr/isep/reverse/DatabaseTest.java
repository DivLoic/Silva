package fr.isep.reverse;

import fr.isep.reverse.Database;
import fr.isep.reverse.JDBCDriversNames;
import fr.isep.reverse.MysqlDatabase;
import fr.isep.reverse.Table;
import junit.framework.TestCase;
import java.io.File;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;

/**
 * Created by LoicMDIVAD on 27/12/2015.
 */
public class DatabaseTest extends TestCase {

    private Database db = null;
    private Connection co = null;
    private final File resourceFolder = new File("src/test/resources");

    public void setUp() throws Exception {
        super.setUp();
        /* HERE WE MOCK A DATABASE WITH A SQLITE FILE */
        co = DriverManager.getConnection("jdbc:sqlite:" +
                resourceFolder.getAbsolutePath()
                + "/Test.sqlite"
        );

    }

    public void testConnect() throws Exception {
        /* will aromatically fail*/
    }

    public void testFactory() throws Exception {
        db = Database.factory(JDBCDriversNames.mysql.toString(),
                "127.0.0.1", "8080", "mysql", "root", "mydb");

        assert db.getClass() == MysqlDatabase.class;

        DatabaseMetaData meta = co.getMetaData();
        db.getComponents(meta);

        assertEquals(3, db.getTables().size());
        assertEquals("admin", db.getTables().get(0).getName());
        assertEquals("annonce", db.getTables().get(1).getName());
        assertEquals("utilisateur", db.getTables().get(2).getName());
    }

    public void testComponents() throws Exception{
        db = Database.factory(JDBCDriversNames.mysql.toString(),
                "127.0.0.1", "8080", "mysql", "root", "mydb");

        DatabaseMetaData meta = co.getMetaData();
        db.getComponents(meta);

        for(Table t : db.getTables()){
            t.getComponents(meta);
            assertNotNull(t.getColumns());
            assertNotNull(t.getForeignKeys());
            assertNotNull(t.getIndices());
        }

    }

    public void tearDown() throws Exception{
        super.tearDown();
        co.close();
    }
}