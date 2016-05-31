package fr.isep.reverse;

/**
 * Created by LoicMDIVAD on 23/12/2015.
 */
public abstract class ForeignKey implements Structure{

    private String name;
    private Tuple<String, String> references;
    private int update;
    private int delete;

    public ForeignKey(String name, String tableRef, String colRef, int update, int delete) {
        this.name = name;
        this.references = new Tuple<String, String>(tableRef, colRef);
        this.update = update;
        this.delete = delete;
    }

    // -- setters

    public void setName(String name) {
        this.name = name;
    }

    public void setReferences(Tuple<String, String> references) {
        this.references = references;
    }

    public void setUpdate(int update) {
        this.update = update;
    }

    public void setDelete(int delete) {
        this.delete = delete;
    }

    // -- getter

    public String getName() {
        return name;
    }

    public Tuple<String, String> getReferences() {
        return references;
    }

    public int getUpdate() {
        return update;
    }

    public int getDelete() {
        return delete;
    }
}
