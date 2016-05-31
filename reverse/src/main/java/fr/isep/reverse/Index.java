package fr.isep.reverse;

/**
 * Created by LoicMDIVAD on 23/12/2015.
 */
public abstract class Index implements Structure{

    private String name; // may be null
    private String key;
    private String ascending;

    public Index(String name, String key, String ascending) {
        this.name = name;
        this.key = key;
        this.ascending = ascending;
    }

    // --  setter

    public void setName(String name) {
        this.name = name;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public void setAscending(String ascending) {
        this.ascending = ascending;
    }

    // -- getter

    public String getName() {
        return name;
    }

    public String getKey() {
        return key;
    }

    public String getAscending() {
        return ascending;
    }
}
