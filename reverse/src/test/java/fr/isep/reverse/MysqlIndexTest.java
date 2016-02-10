package fr.isep.reverse;

import junit.framework.TestCase;
import org.json.JSONObject;

/**
 * Created by LoicMDIVAD on 26/12/2015.
 */
public class MysqlIndexTest extends TestCase {

    private MysqlIndex index1;
    private MysqlIndex index2;
    private MysqlIndex index3;
    private MysqlIndex index4;
    private String jsontxt = "{}";

    public void setUp() throws Exception {
        super.setUp();
        index1 = new MysqlIndex("idx_for_test_one", "id", "A");
        index2 = new MysqlIndex("idx_for_test_two", "position", "D");
        index3 = new MysqlIndex("idx_for_test_tree", "grades", "D");
        index4 = new MysqlIndex("idx_for_test_four", "awesomeness", null);
    }

    public void testGetComponents() throws Exception {
        // well... should we test a function which do nothing?...
    }

    public void testGetSql() throws Exception {
        assertEquals("KEY idx_for_test_two (position)", index2.getSql());
    }

    public void testGetCvs() throws Exception {

    }

    public void testGetJson() throws Exception {
        jsontxt = MainTest.testRead("idex.json", "{}");
        JSONObject answer = new JSONObject(jsontxt);
        JSONObject testdoc = index3.getJson();

        for(String key : answer.keySet()){
            assertTrue(testdoc.has(key));
            assertEquals(answer.get(key), testdoc.get(key));
        }
    }
}