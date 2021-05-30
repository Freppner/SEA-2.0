package de.telekom.sea2.gui;

import java.sql.SQLException;

import de.telekom.sea2.SeminarApp;
import de.telekom.sea2.model.Person;
import de.telekom.sea2.model.Salutation;
import de.telekom.sea2.persistence.PersonRepository;



public class MenuUpdateOne {

		private PersonRepository personRepository;
		private java.util.Scanner scanner;
		
		
		
		public MenuUpdateOne () {
			this.personRepository	=SeminarApp.getSeminarApp().getPersonRepository();
			this.scanner			=SeminarApp.getSeminarApp().getScanner(); 
		}
		
		
		
		
		public String inputZeile() {					// Nimmt die Usereingabe entgegen
			var eingabe = scanner.next();
			return eingabe;
			}

		

	
	
		
		
		public void updatePerson() {
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
				result = personRepository.update(person);	// ??? Ohne 'new' -> static ???
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

			
	
		

