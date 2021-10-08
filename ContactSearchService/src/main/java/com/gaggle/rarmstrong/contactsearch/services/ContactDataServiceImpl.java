package com.gaggle.rarmstrong.contactsearch.services;

import java.sql.*;
import org.h2.jdbcx.JdbcDataSource;

import com.gaggle.rarmstrong.contactsearch.models.Contact;
import com.gaggle.rarmstrong.contactsearch.models.ContactList;

public class ContactDataServiceImpl implements ContactDataService {

	public void LoadRecords() {
		Connection conn = null;
		Statement stmt = null;
		try {
			conn = getConnection();
			if (conn != null) {
				stmt = conn.createStatement();
				
				String sql = "CREATE TABLE Contacts (id varchar(10) not null, name varchar(50), PRIMARY KEY (id))";
				stmt.executeUpdate(sql);
		
				sql = "INSERT INTO Contacts VALUES('BW2152','Bruce Wayne')";
				stmt.executeUpdate(sql);
		
				sql = "INSERT INTO Contacts VALUES('CK0029','Clark Kent')";
				stmt.executeUpdate(sql);
		
				sql = "INSERT INTO Contacts VALUES('BA3333','Barry Allen')";
				stmt.executeUpdate(sql);
		
				sql = "INSERT INTO Contacts VALUES('DP4301','Diana Prince')";
				stmt.executeUpdate(sql);
		
				sql = "INSERT INTO Contacts VALUES('AC1033','Arthur Curry')";
				stmt.executeUpdate(sql);
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {
				if (stmt != null) { stmt.close(); }
				if (conn != null) { conn.close(); }
			} 
			catch (SQLException e) { }
		}
	}
	
	public void DestroyRecords() {
		Connection conn = null;
		Statement stmt = null;
		try {
			conn = getConnection();
			if (conn != null) {
				stmt = conn.createStatement();
				
				String sql = "DROP TABLE Contacts";
				stmt.executeUpdate(sql);
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {
				if (stmt != null) { stmt.close(); }
				if (conn != null) { conn.close(); }
			} 
			catch (SQLException e) { }
		}
	}

	@Override
	public String GetRecordByID(String id) {
		Connection conn = null;
		PreparedStatement stmt = null;
		try {
			conn = getConnection();
			if (conn != null) {
				String sql = "SELECT id, name FROM Contacts WHERE id = ?";
				stmt = conn.prepareStatement(sql);
				stmt.setString(1, id);
				
				ResultSet rs = stmt.executeQuery();
				
				if (rs.first()) {
					Contact c = new Contact(rs.getString("id"), rs.getString("name"));
					return c.toString();
				} else {
					return "{}";
				}				
			} else {
				return null;
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		finally {
			try {
				if (stmt != null) { stmt.close(); }
				if (conn != null) { conn.close(); }
			} 
			catch (SQLException e) { }
		}
	}

	@Override
	public String GetRecordsBySearch(String searchTerm) {
		Connection conn = null;
		PreparedStatement stmt = null;
		try {
			conn = getConnection();
			if (conn != null) {
				String sql = "SELECT id, name FROM Contacts WHERE LOWER(name) LIKE ? ORDER BY id";
				stmt = conn.prepareStatement(sql);
				stmt.setString(1, "%" + searchTerm.toLowerCase() + "%");
				
				ResultSet rs = stmt.executeQuery();
				
				ContactList contacts = new ContactList();
				while(rs.next()) {
					contacts.add(new Contact(rs.getString("id"), rs.getString("name")));
				}
				
				return "{ \"results\": " + contacts.toString() + " }";				
			} else {
				return null;
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		finally {
			try {
				if (stmt != null) { stmt.close(); }
				if (conn != null) { conn.close(); }
			} 
			catch (SQLException e) { }
		}
	}

	private Connection getConnection() {
		try {
			JdbcDataSource ds = new JdbcDataSource();
			ds.setURL("jdbc:h2:~/ContactsDatabase");
			ds.setUser("sa");
			ds.setPassword("");		
			return ds.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
}
