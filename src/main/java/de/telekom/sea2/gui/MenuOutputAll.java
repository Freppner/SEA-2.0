package de.telekom.sea2.gui;

import java.util.ArrayList;

import de.telekom.sea2.SeminarApp;
import de.telekom.sea2.model.Person;
import de.telekom.sea2.persistence.PersonRepository;



public class MenuOutputAll {
	
	
	private PersonRepository personRepository;
		
	public MenuOutputAll (PersonRepository personRepository) {
		this.personRepository=SeminarApp.getSeminarApp().getPersonRepository();	
	}
	
	
	
	public void outputAllPersons() {
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
	}
	

}
