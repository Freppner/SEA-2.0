package de.telekom.sea2.model;

public enum Salutation {
		
		MR,
		MRS,
		OTHER;


	
	// Konstruktor zur Normierung der Salutation (MR, MRS, OTHER)
	public static Salutation fromString( String string ) {
		
		switch (string.toUpperCase()) {
			case "MR":
			case "MISTER":
			case "HERR":
					 return MR;
			
			case "MRS":
			case "MISSES":
			case "FRAU":
					 return MRS;
				 
			case "OTHER":
			case "DIVERS":
					 return OTHER;
			default: throw new IllegalArgumentException("Es wurde ein nicht definierter Wert in das Feld Salutation eingegeben: "+string);
		}
	}
	
	
	// Definition/ Formatierung des Rückgabe Werte für die toString-Methode
	@Override
	public String toString() {
		
		switch( this ) {
			case MR:return 		"Mister";
			case MRS:return		"Misses";
			case OTHER:return	"Other";
			
			default: throw new IllegalArgumentException("Es wurde ein nicht definierter Wert in dem Feld Salutation vorgefunden: "+this);
		}
	}
		
}
