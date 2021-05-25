package de.telekom.sea2.model;

public enum Salutation {
		
		MR,
		MRS,
		OTHER;

	
	// Eine Methode zur Normierung der Salutation (MR, MRS, OTHER)
	// Static die Methode kann ohne Instanz aufgerufen werden.
	// Die Methode heißt fromString.
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
	
	
	public static Salutation fromByte( Byte bite ) {
		
		switch (bite) {
			case 0:
				return MR;

			case 1:
				 return MRS;

			case 2:
				 return OTHER;

			default: throw new IllegalArgumentException("Es wurde ein nicht definierter Wert in das Feld Salutation eingegeben: "+bite);
		}
	}
	
		
	
	// Definition/ Formatierung des Rückgabewertes für die toString-Methode
	@Override
	public String toString() {
		
		switch( this ) {
			case MR:return 		"Mister";
			case MRS:return		"Misses";
			case OTHER:return	"Other";
			
			default: throw new IllegalArgumentException("Es wurde ein nicht definierter Wert in dem Feld Salutation vorgefunden: "+this);
		}
	}
	

	public Byte toByte() {
		
		switch( this ) {
			case MR:return 		0;
			case MRS:return		1;
			case OTHER:return	2;
			
			default: throw new IllegalArgumentException("Es wurde ein nicht definierter Wert in dem Feld Salutation vorgefunden: "+this);
		}	
	}
			
}
