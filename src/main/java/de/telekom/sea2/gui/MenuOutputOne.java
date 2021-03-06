package de.telekom.sea2.gui;

import java.util.ArrayList;

import de.telekom.sea2.SeminarApp;
import de.telekom.sea2.model.Person;
import de.telekom.sea2.persistence.PersonRepository;



public class MenuOutputOne {
	
	private PersonRepository personRepository;
	java.util.Scanner scanner;
	
	
	public MenuOutputOne (PersonRepository personRepository) {
		this.personRepository	=SeminarApp.getSeminarApp().getPersonRepository();
		this.scanner			=SeminarApp.getSeminarApp().getScanner();
	}
	
	
	public String inputZeile() {					// Nimmt die Usereingabe aus dem Hauptmenue entgegen
		var eingabe = scanner.next();
		return eingabe;
		}

	
	
	public void outputPerson() {
		String stringId;

		System.out.println("ID Eingeben:");
		stringId= (this.inputZeile());
		int id = Integer.parseInt(stringId);
				
		try {
			Person person = personRepository.get(id);
			
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
	}
			

}
