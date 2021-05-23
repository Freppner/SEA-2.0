package de.telekom.sea2.persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
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
	Statement statement;
	ResultSet resultSet;
	
	
	public void dbInit() throws ClassNotFoundException, SQLException {
		Class.forName(DRIVER);				// Java sucht die Klasse für den übergebenen String "DRIVER" heraus.
											// Für den Fall das die Suche fehlschlägt, muß einen Exception vorgesehen werden.
											// ClassNotFoundException
		
		connection = DriverManager.getConnection(URL);	// Für den Fall das die Verbindung fehlschägt muß einen Exception vorgesehen werden.
														// SQLException
	}
	
	
	
/* Statment	
	public boolean create(Person person) throws SQLException {
		
		long id=			person.getId();
		byte salutation =	person.getSalutation().toByte();	// es wird erst die Methode getSalutation und im Anschluss toByte aufgerufen
		String firstName=	person.getFirstname();
		String lastName=	person.getLastname();
		
		String sql=			("insert into personen ( ID, ANREDE, VORNAME, NACHNAME) values ("+id+","+salutation+",'"+firstName+"','"+lastName+"');");
		
  		Statement statement = connection.createStatement();
  		boolean result=		statement.execute(sql);
		
		return result;
	}
*/
	
	// Prepstatment	
	public boolean create(Person person) throws SQLException {
		
		long id=			person.getId();
		byte salutation =	person.getSalutation().toByte();	// es wird erst die Methode getSalutation und im Anschluss toByte aufgerufen
		String firstName=	person.getFirstname();
		String lastName=	person.getLastname();
		
		String sql=			("insert into personen ( ID, ANREDE, VORNAME, NACHNAME) values (?,?,?,?)");
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
  		
		preparedStatement.setLong(1, id);
		preparedStatement.setByte(2, salutation);
		preparedStatement.setString(3, firstName);
		preparedStatement.setString(4, lastName);
  		
  		boolean result=		preparedStatement.execute();
		
		return result;
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
		return result;
	}
	
	
	public boolean deleteAll() throws SQLException {	
		Statement statement = connection.createStatement();        
		boolean result = statement.execute("delete from personen");     
		return result;
	}
	
	
	
	
	
	
	
}
