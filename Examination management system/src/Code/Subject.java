/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Code;

/**
 *
 * @author Rajitha Shavinda
 */
public class Subject {

    //object elements
    private String ID;
    private String name;
    private String key;
    private String des;

    public Subject(String ID, String name, String key, String des) {//constructor
        this.ID = ID;
        this.name = name;
        this.key = key;
        this.des = des;
    }

    /**
     * @return the ID
     */
    public String getID() {
        return ID;
    }

    /**
     * @param ID the ID to set
     */
    public void setID(String ID) {
        this.ID = ID;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the key
     */
    public String getKey() {
        return key;
    }

    /**
     * @param key the key to set
     */
    public void setKey(String key) {
        this.key = key;
    }

    /**
     * @return the des
     */
    public String getDes() {
        return des;
    }

    /**
     * @param des the des to set
     */
    public void setDes(String des) {
        this.des = des;
    }

}
