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
public class Student {

//object elements
    private String id;
    private String name;
    private String email;
    private String contact;
    private String courseName;
    private String bday;
    private String password;
    private String subjects;//enrolled subject ids
    private String subNames;//enrolled subject names

    //constructor
    public Student(String id, String name, String email, String contact, String courseName, String bday, String password, String subjects, String subNames) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.contact = contact;
        this.courseName = courseName;
        this.bday = bday;
        this.password = password;
        this.subjects = subjects;
        this.subNames = subNames;
    }

    /**
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(String id) {
        this.id = id;
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
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the contact
     */
    public String getContact() {
        return contact;
    }

    /**
     * @param contact the contact to set
     */
    public void setContact(String contact) {
        this.contact = contact;
    }

    /**
     * @return the courseName
     */
    public String getCourseName() {
        return courseName;
    }

    /**
     * @param courseName the courseName to set
     */
    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    /**
     * @return the bday
     */
    public String getBday() {
        return bday;
    }

    /**
     * @param bday the bday to set
     */
    public void setBday(String bday) {
        this.bday = bday;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return the subjects
     */
    public String getSubjects() {
        return subjects;
    }

    /**
     * @param subjects the subjects to set
     */
    public void setSubjects(String subjects) {
        this.subjects = subjects;
    }

    /**
     * @return the subNames
     */
    public String getSubNames() {
        return subNames;
    }

    /**
     * @param subNames the subNames to set
     */
    public void setSubNames(String subNames) {
        this.subNames = subNames;
    }

}
