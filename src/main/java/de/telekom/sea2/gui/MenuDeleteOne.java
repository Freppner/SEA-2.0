package de.telekom.sea2.gui;

import java.sql.SQLException;

import de.telekom.sea2.SeminarApp;
import de.telekom.sea2.model.Person;
import de.telekom.sea2.model.Salutation;
import de.telekom.sea2.persistence.PersonRepository;




public class MenuDeleteOne {

	private PersonRepository personRepository;
	private java.util.Scanner scanner;
	
	
	public MenuDeleteOne  (PersonRepository personRepository) {
		this.personRepository	=SeminarApp.getSeminarApp().getPersonRepository();
		this.scanner			=SeminarApp.getSeminarApp().getScanner();
	}

	

	
	public String inputZeile() {					// Nimmt die Usereingabe aus dem Hauptmenue entgegen
		var eingabe = scanner.next();
		return eingabe;
		}

	
	
	public void deletePerson() {
		String stringId;
		boolean result=false;

		System.out.println("ID Eingeben:");
		stringId= (this.inputZeile());
		int id = Integer.parseInt(stringId);
		Person person = new Person();
				
		try {
			person = personRepository.get(id);
			
			String string= String.format("%s %s %s %s", 
					person.getId(),
					person.getSalutation(),
					person.getFirstname(),
					person.getLastname()
					);
			System.out.println("___________________________________________________________________");	
			System.out.println(string);
			System.out.println("___________________________________________________________________");
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			result = personRepository.delete(id);	// ??? Ohne 'new' -> static ???
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
