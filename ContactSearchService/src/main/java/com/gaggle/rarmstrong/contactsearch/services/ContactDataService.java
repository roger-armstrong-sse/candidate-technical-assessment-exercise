package com.gaggle.rarmstrong.contactsearch.services;

public interface ContactDataService {
	public String GetRecordByID(String id);
	
	public String GetRecordsBySearch(String searchTerm);
}
