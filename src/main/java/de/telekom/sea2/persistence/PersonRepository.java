package de.telekom.sea2.persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import de.telekom.sea2.model.Person;
import de.telekom.sea2.model.Salutation;




public class PersonRepository {
	
	
	final static String DRIVER = "org.mariadb.jdbc.Driver";
	final static String URL = "jdbc:mysql://localhost:3306/seadb?user=seauser&password=seapass";
	
	Connection connection;
	Statement statment;
	ResultSet resultSet;

	
	
	
	
	public void dbInit() throws ClassNotFoundException, SQLException {
		Class.forName(DRIVER);				// Java sucht die Klasse für den übergebenen String "DRIVER" heraus.
											// Für den Fall das die Suche fehlschlägt, muß einen Exception vorgesehen werden.
											// ClassNotFoundException
		
		connection = DriverManager.getConnection(URL);	// Für den Fall das die Verbindung fehlschägt muß einen Exception vorgesehen werden.
														// SQLException
	}
	
	
	
	public boolean create(Person person) throws SQLException {
		Statement statement = connection.createStatement();
		
		return false;
	}
	
	
		
	
	
	
	public Person get(long id) throws SQLException {
		Statement statement = connection.createStatement();							// Öffnet ein Abfragekanal zur Datenbank für genau ein Statment
		resultSet = statement.executeQuery( "select * from personen where id="+id);
		if (resultSet.next()) {
			Person person = new Person (
					resultSet.getLong(1), 
					Salutation.fromByte(resultSet.getByte(2)), 
					resultSet.getString(3), 
					resultSet.getString(4));
			
			return person;
		}else {
			return null;	
		}
	}
	
	
	public ArrayList getAll() throws SQLException {
		Statement statement = connection.createStatement();							// Öffnet ein Abfragekanal zur Datenbank für genau ein Statment
		resultSet = statement.executeQuery( "select * from personen");
		ArrayList arrayList= new ArrayList();
		
		while (resultSet.next()) {
			Person person = new Person (
					resultSet.getLong(1), 
					Salutation.fromByte(resultSet.getByte(2)), 
					resultSet.getString(3), 
					resultSet.getString(4));
			
			arrayList.add(person);
		}		
			return arrayList;	
	}
	
	
	
	public boolean update(Person person) {
		return false;
	}
	
	
	
	public boolean delete(Person person) throws SQLException {
		long id = person.getId();
		return delete(id);
	}

	
	public boolean delete(long id) throws SQLException {
		Statement statement = connection.createStatement();							// Öffnet ein Abfragekanal zur Datenbank für genau ein Statment
		boolean result = statement.execute( "delete from personen where id="+id);
		System.out.println(result);
		return result;
	}

	
	
	
}
