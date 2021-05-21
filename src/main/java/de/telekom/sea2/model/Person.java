package de.telekom.sea2.model;


public class Person {
	
	private long id;
	private Salutation salutation;
	private String firstName;
	private String lastName;
	

	
	
	public Person (long id, Salutation salutation, String firstName, String lastName) {
		this.id			=id;
		this.salutation	=salutation;
		this.firstName	=firstName;
		this.lastName	=lastName;
	}
		
	
	public Person (long id, String salutation, String firstName, String lastName) {
		this.id			=id;
		this.salutation	=Salutation.fromString(salutation);
		this.firstName	=firstName;
		this.lastName	=lastName;
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
		return firstName;
	}
	public void setFirstname(String firstName) {
		this.firstName = firstName;
	}
	
	
	public String getLastname() {
		return lastName;
	}
	public void setLastname(String lastName) {
		this.lastName = lastName;
	}	
	
	
	
}

























