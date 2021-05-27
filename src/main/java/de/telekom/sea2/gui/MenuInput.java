package de.telekom.sea2.gui;


import de.telekom.sea2.model.Salutation;
import de.telekom.sea2.model.Person;
import de.telekom.sea2.persistence.PersonRepository;

import java.sql.SQLException;


public class MenuInput {
	
	private PersonRepository personRepository;
	
	
	public MenuInput(PersonRepository personRepository) {
		this.personRepository=personRepository;
	}

	
	
	java.util.Scanner scanner = new java.util.Scanner(System.in);
	
	public String inputMenue() {					// Nimmt die Usereingabe aus dem Hauptmenue entgegen
		var eingabe = scanner.next();
		return eingabe;
		}

	
	
	
	public void inputPerson() throws SQLException{// Neue Person ueber die StdIn erfassen
		Person person = new Person();
		boolean result=false;
		
		/*
		System.out.println("Anrede eingeben:");
		try {
			person.setSalutation(this.inputMenue());
		}
		catch (Exception e) {
			System.out.println("Falsche Eingabe... nur MR/MRS/OTHERS erlaubt");
			return;
		}*/
		
		String salutation;
		do{
			System.out.println("Anrede eingeben:");
			salutation=this.inputMenue();
			System.out.println(salutation);

			if (!salutation.equals("MR") && !salutation.equals("MRS") && !salutation.equals("OTHER") ) {
				System.out.println("Falsche Eingabe... nur MR/MRS/OTHERS erlaubt");
			};
		}while(!salutation.equals("MR") && !salutation.equals("MRS") && !salutation.equals("OTHER") );

		person.setSalutation(salutation);
		System.out.println("Vorname eingeben:");
		person.setFirstname (this.inputMenue());
		System.out.println("Nachname eingeben:");
		person.setLastname(this.inputMenue());
		
		try {
			result = personRepository.create(person);	// ??? Ohne 'new' -> static ???
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		};
		if (result == true) {
			System.out.println("Teilnehmer wurde erfolgreich angelegt.");
		} else {
			System.out.println("Teilnehmer wurde nicht angelegt!");
		}
				
	}
	
	

}
