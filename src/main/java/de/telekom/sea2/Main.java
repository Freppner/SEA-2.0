package de.telekom.sea2;

import java.sql.SQLException;

public class Main {

	public static void main(String[] args) {
		SeminarApp seminarApp = new SeminarApp();	// Erzeugt die erste Objektinstanz.
		try {
			seminarApp.run(args);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}						// Ruft die Methode run der Instanz seminarApp auf.
	}
}
