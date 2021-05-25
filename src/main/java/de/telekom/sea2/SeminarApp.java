package de.telekom.sea2;

import java.sql.SQLException;
import java.util.ArrayList;

import de.telekom.sea2.gui.Menue;
import de.telekom.sea2.model.Person;
import de.telekom.sea2.persistence.PersonRepository;



public class SeminarApp {
	public void run (String[] args) {

		
		
		PersonRepository personRepository = new PersonRepository();
		

			try {
				personRepository.dbInit();
			} catch (ClassNotFoundException | SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		
		
			// Abruf einer einzelnen Person	
			try {
				Person person = personRepository.get(3);
				
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

			

			// Abruf aller Personen
			try {
				ArrayList personListAll = personRepository.getAll();
				
				System.out.println("___________________________________________________________________");
				for (int i = 0; i < personListAll.size(); i++) {
					Person person = (Person)personListAll.get(i);
						
					String string = String.format("%s %s %s %s",
						person.getId(),
						person.getSalutation(),
						person.getFirstname(),
						person.getLastname()
						);
				System.out.println(string);
				}
				System.out.println("___________________________________________________________________");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
	/*		
			// Löschen einer einzelner Person
			try {
				boolean result = personRepository.delete(1);
				
			}catch(Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		
/*
			// Loeschen aller Eintraege
			try {
				boolean result = personRepository.deleteAll();

			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			*/
			
			
 			// Person in die Datenbank eintragen
						
			try {
				long id=			-1L;
				String salutation=	"MR";
				String firstName=	"Roland";
				String lastName=	"Hoeppner";
	
				Person person = new Person (id, salutation, firstName, lastName);
				boolean result = personRepository.create(person);

			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			

			
 			// Person in die Datenbank ändern
				
			try {
				long id=			18L;
				String salutation=	"MR";
				String firstName=	"Karl";
				String lastName=	"Tool";

				Person person = new Person (id, salutation, firstName, lastName);
				boolean result = personRepository.update(person);

			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
					
			
			
	
		
		
		
		//Menue menue = new Menue();
		//menue.keppAsking();
		
	}

}
