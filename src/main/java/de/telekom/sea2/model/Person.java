package de.telekom.sea2.model;


public class Person {
	
	private long id;
	private Salutation salutation;
	private String firstname;
	private String lastname;
	

	
	
	public Person (long id, Salutation salutation, String firstname, String lastname) {
		this.id=id;
		this.salutation=salutation;
		this.firstname=firstname;
		this.lastname=lastname;
	}
		
	
	public Person (long id, String salutation, String firstname, String lastname) {
		this.id=id;
		this.salutation=Salutation.fromString(salutation);
		this.firstname=firstname;
		this.lastname=lastname;
	}

	
		
	// Getters and Setters
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	
	public Salutation getSalutation() {
		return salutation;
	}
	public void setSalutation(String string) {
		this.salutation = Salutation.fromString(string);
	}

	
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	
	
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}	
	
	
	
}

























