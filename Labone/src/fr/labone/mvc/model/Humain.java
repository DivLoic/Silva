package fr.labone.mvc.model;

/**
 * Session Bean implementation class Humain
 */

public class Humain {

    /**
     * Default constructor. 
     */
    public Humain() {
        // TODO Auto-generated constructor stub
    }
    
    public Humain(String firstName, String lastName, String birthDay, String sex) {

    	this.setFirstName(firstName);
    	this.setLastName(lastName);
    	this.setBirthDay(birthDay);
    	this.setSex(sex);
    }
    
    /**
     * Attribute. 
     */
    
    private String firstName;
    private String lastName;
    private String birthDay;
    private String sex;
    
    /**
     * Method. 
     */
    
	public String getFirstName() {
		return firstName;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public String getBirthDay() {
		return birthDay;
	}
	
	public void setBirthDay(String birthDay) {
		this.birthDay = birthDay;
	}
	
	public String getSex() {
		return sex;
	}
	
	public void setSex(String sex) {
		this.sex = sex;
	}
    

}
