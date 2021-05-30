package de.telekom.sea2.gui;

import java.util.ArrayList;

import de.telekom.sea2.SeminarApp;
import de.telekom.sea2.model.Person;
import de.telekom.sea2.persistence.PersonRepository;



public class MenuDeleteAll {
	
	
	private PersonRepository personRepository;
	
	public MenuDeleteAll () {
		this.personRepository=SeminarApp.getSeminarApp().getPersonRepository();	
	}
	
	
	
	public void deleteAllPersons() {
		boolean result;
		
		try {
			result = personRepository.deleteAll();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
	

}
