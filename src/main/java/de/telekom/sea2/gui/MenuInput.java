package de.telekom.sea2.gui;


import de.telekom.sea2.model.Salutation;
import de.telekom.sea2.SeminarApp;
import de.telekom.sea2.model.Person;
import de.telekom.sea2.persistence.PersonRepository;

import java.sql.SQLException;


public class MenuInput {
	
	private PersonRepository personRepository;
	private java.util.Scanner scanner;
	
	
	public MenuInput(PersonRepository personRepository) {
		this.personRepository	=SeminarApp.getSeminarApp().getPersonRepository();
		this.scanner			=SeminarApp.getSeminarApp().getScanner();
	}

	
	public String inputZeile() {					// Nimmt die Usereingabe aus dem Hauptmenue entgegen
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
			System.out.println("Anrede eingeben (MR/MRS/OTHER/ABBRUCH):");
			salutation=this.inputZeile();
			System.out.println(salutation);

			if (!Salutation.isOK(salutation) && !salutation.equals("ABBRUCH")) {
				System.out.println("Falsche Eingabe... nur MR/MRS/OTHERS/ABBRUCH erlaubt.");
				System.out.println();
				if (salutation.equals("ABBRUCH")) {
					return;
				}
				
			};
		}while(!Salutation.isOK(salutation));
				
		person.setSalutation(salutation);
		System.out.println("Vorname eingeben:");
		person.setFirstname (this.inputZeile());
		System.out.println("Nachname eingeben:");
		person.setLastname(this.inputZeile());
		
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
