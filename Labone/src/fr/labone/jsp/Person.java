package fr.labone.jsp;


/**
 * Session Bean implementation class Person
 */

public class Person {

    /**
     * Default constructor. 
     */
    public Person() {
        // TODO Auto-generated constructor stub
    }
    
    /**
     * property. 
     */
    private String firstName;
    private String lastName;
    private String date;
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
	
	public String getDate() {
		return date;
	}
	
	public void setDate(String date) {
		this.date = date;
	}
	
	public String getSex() {
		return sex;
	}
	
	public void setSex(String sex) {
		this.sex = sex;
	}
    

}
