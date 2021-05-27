package de.telekom.sea2.gui;

import java.io.IOException;
import java.sql.SQLException;

import de.telekom.sea2.persistence.PersonRepository;

public class Menue {
	
	
	private PersonRepository personRepository;
	
	public Menue (PersonRepository personRepositrory) {
		this.personRepository=personRepository;	
	}
	

	
	java.util.Scanner scanner = new java.util.Scanner(System.in);
	
	public String inputMenue() {					// Nimmt die Usereingabe aus dem Hauptmenue entgegen
		var eingabe = scanner.next();
		return eingabe;
		}
	
	
	// Wird von aussen aufgerufemn
	public void keppAsking() {						// Wiederholt die aufgeführten Methoden
		String result="0";
		do {
			System.out.println(System.lineSeparator().repeat(20));
			this.showMenue();
			result=this.inputMenue();
			this.checkMenue(result);
		}while(!result.equals("0"));		
	}

	
	public void showMenue(){ // Zeigt das Hauptmenue an
		System.out.println(System.lineSeparator().repeat(1));	
		System.out.println("___________________________________________________________________");
		System.out.println(System.lineSeparator().repeat(1));	
		System.out.println("   Menu");
		System.out.println(System.lineSeparator().repeat(1));
		System.out.println("   1. Teilnehmer ausgeben.");
		System.out.println(System.lineSeparator().repeat(1));
		System.out.println("   2. Teilnehmer erfassen.");
		System.out.println(System.lineSeparator().repeat(1));
		System.out.println("   3. Teilnehmer löschen.");
		System.out.println(System.lineSeparator().repeat(1));
		System.out.println("   4. Alle Teilnehmer löschen");
		System.out.println(System.lineSeparator().repeat(1));
		System.out.println("   5. Teilnehmer suchen");
		System.out.println(System.lineSeparator().repeat(1));
		System.out.println("   6. Teilnehmerliste speichern");
		System.out.println(System.lineSeparator().repeat(1));
		System.out.println("   0. Exit");
		System.out.println(System.lineSeparator().repeat(0));
		System.out.println("___________________________________________________________________");
		System.out.print("");
	}
	
	
	public void checkMenue(String eingabe) throws SQLException  {;		// Wertet die Nutzereingabe aus dem  Hauptmenue aus
		switch (eingabe) {
			case "1":System.out.println("1. Teilnehmer ausgeben.");
				break;
			case "2":System.out.println("2. Teilnehmer erfassen.");
				MenuInput menuInput = new MenuInput(personRepository);
				menuInput.inputPerson();
				break;
			case "3":System.out.println("3. Teilnehmer löschen.");
				break;
			case "4":System.out.println("4. Alle Teilnehmer löschen.");
				break;
			case "5":System.out.println("5. Teilnehmer suchen.");
				break;
			case "6":System.out.println("6. Teilnehmerliste speichern.");
				break;	
			case "0":System.out.println("Exit");
				System.out.println("Und tschüss!!!!");
				break;
		}
	}
	

	
	
}
