package fr.isep.reverse;

import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by LoicMDIVAD on 22/12/2015.
 */
public abstract class Database implements Structure{

    // -- properties
    private String url;
    private String host;
    private String port;
    private String schema;
    private String user;
    private String password;

    protected List<Table> tables;

    // -- constructors

    public Database(String host, String port, String schema, String user, String password) {
        setHost(host);
        setPort(port);
        setSchema(schema);
        setUser(user);
        setPassword(password);
    }

    /**
     * All database can send a connection object by passing
     * theire properties
     * @return java.sql.Connection to the database
     */
    public Connection connect(){
        try {
            return DriverManager.getConnection(getUrl(), getUser(), getPassword());
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("La connection à la base de donnée ne peut pas être établie!");
            System.out.println("Assurez vous que le pom.xml (l.61-l.66) soit bien configuré");
            System.out.println("--- [ ARRET DU PROGRAMME ] ---");
            System.exit(1); // the only goal is to buid the database, so we stop here
            return null;
        }
    }

    /**
     * takes the name of the connector, test the existence of the class
     * by looping on the enum fr.isep.reverse.JDBCDriversNames. if it match, the subclasse of
     * fr.isep.reverse.Database if use to instantiate a database <br/>
     * then return an associeted database
     * @return
     */
    public static Database factory(String driver, String host, String port,
                                   String schema, String user, String password) throws TooLazyStudentException {

        // -- All database sub class has 5 Stings param constructor
        Class[] args =  new Class[5];
        for(int i=0; i<5; i++){args[i]= String.class;}

        for(JDBCDriversNames d : JDBCDriversNames.values()){
            if(d.toString().equals(driver)){

                //TODO: Delete this when more databe will be take in charge
                if(!d.toString().equals(MysqlDatabase.driver.toString().substring(6))){
                    System.out.println("YOU ARE TRYING TO USE THE " +d.toString()+ " DRIVER.");
                    throw new TooLazyStudentException();
                }

                try {
                    return (Database) d.getDatabase().getDeclaredConstructor(args)
                            .newInstance(host, port, schema, user, password);
                } catch (InstantiationException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                } catch (NoSuchMethodException e) {
                    e.printStackTrace();
                }
            }
        }

        // No such driver name
        System.out.println("THEIR IS NO SUCH DRIVER NAME : " + driver);
        System.out.println("SEE THE AVAILABLE LIST OF DRIVER IN THE README.md");
        throw new TooLazyStudentException();
    }

    // -- setters

    public void setUrl(String url) {
        this.url = url;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public void setPort(String port) {
        this.port = port;
    }

    public void setSchema(String schema) {
        this.schema = schema;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setTables(Table tables) {
        this.tables.add(tables);
    }

    // -- getters


    public String getUser() {
        return user;
    }

    public String getUrl() {
        return url;
    }

    public String getPassword() {
        return password;
    }

    public String getHost() {
        return host;
    }

    public String getPort() {
        return port;
    }

    public String getSchema() {
        return schema;
    }

    public List<Table> getTables() {
        return tables;
    }
}
