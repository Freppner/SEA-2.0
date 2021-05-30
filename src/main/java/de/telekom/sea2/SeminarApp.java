package de.telekom.sea2;

import java.sql.SQLException;
import java.util.ArrayList;

import de.telekom.sea2.gui.MenuDeleteAll;
import de.telekom.sea2.gui.MenuDeleteOne;
import de.telekom.sea2.gui.MenuInput;
import de.telekom.sea2.gui.MenuOutputAll;
import de.telekom.sea2.gui.MenuOutputOne;
import de.telekom.sea2.gui.MenuUpdateOne;
import de.telekom.sea2.gui.Menue;
import de.telekom.sea2.model.Person;
import de.telekom.sea2.persistence.PersonRepository;



public class SeminarApp {
	
	
	private static SeminarApp seminarApp;
	PersonRepository personRepository = new PersonRepository();
	
	
	public SeminarApp () {
		seminarApp=this;
	}
	
	
	public static SeminarApp getSeminarApp () {
		return seminarApp;
	}
		
	
	public PersonRepository getPersonRepository() {
		return personRepository;
	}
	
	
	
	
	
	
	
	public void run (String[] args) throws SQLException {

		
		
		

			try {
				personRepository.dbInit();
			} catch (ClassNotFoundException | SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		
		/*
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

			
/*
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
		
		

			// Loeschen aller Eintraege
			try {
				boolean result = personRepository.deleteAll();

			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			
			
			
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
				long id=			26L;
				String salutation=	"MR";
				String firstName=	"Karl";
				String lastName=	"Tool";

				Person person = new Person (id, salutation, firstName, lastName);
				boolean result = personRepository.update(person);

			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			*/
		
			/*---------------------------------------------------------------------------------------------------------			
			/*---------------------------------------------------------------------------------------------------------
	
	
	
	
	
			/* Umgesetzte und nur auskommentiert
			
			
			// Anlegen einer neuen Person
			MenuInput menuInput= new MenuInput(personRepository);
			menuInput.inputPerson();
			
			
			// Ausgeben einer einzelnen Person
			MenuOutputOne  menuOutputOne = new MenuOutputOne (personRepository);
			menuOutputOne.outputPerson();
			
			
			// Ausgeben aller Personen
			MenuOutputAll menuOutputAll= new MenuOutputAll(personRepository);
			menuOutputAll.outputAllPersons();
						
			*/
			
			
			
			
			// Aendern einer einzelnen Person
			MenuUpdateOne  menuUpdateOne = new MenuUpdateOne ();
			menuUpdateOne.updatePerson();
			
			/*
			// Ausgeben aller Personen
			MenuOutputAll menuOutputAll= new MenuOutputAll(personRepository);
			menuOutputAll.outputAllPersons();
			
	
			// Loeschen einer Personen
			MenuDeleteOne menuDeleteOne= new MenuDeleteOne(personRepository);
			menuDeleteOne.deletePerson();
			
			
		
			// Loeschen aller Peronen in der Tabelle
			MenuDeleteAll menuDeleteAll= new MenuDeleteAll(personRepository);
			menuDeleteAll.deleteAllPersons();
			
			
			
			
			// Loeschen einer einzlenen Person
			
*/
			
						
			
			
			
			
			

			
			
			//Menue menue = new Menue(personRepository );									// Sicherungsseil für Fehler try-with-ressources
																					// es wird das Close in der Klasse Menue ausgeführt
			//menue.keppAsking();
		
		
		
		
	}

}
