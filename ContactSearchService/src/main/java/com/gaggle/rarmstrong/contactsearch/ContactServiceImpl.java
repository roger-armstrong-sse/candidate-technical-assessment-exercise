package com.gaggle.rarmstrong.contactsearch;

import org.json.*;

import com.gaggle.rarmstrong.contactsearch.services.ContactDataService;
import com.gaggle.rarmstrong.contactsearch.services.ContactDataServiceImpl;

public class ContactServiceImpl implements ContactService {
	private static ContactDataService _dataService;
	
	private static final String NO_MATCH_MESSAGE = "No records matched your search.";
	private static final String ERROR_MESSAGE = "There was an error accessing the data.";
	private static final String BAD_REQUEST = "Bad Request Format";
	
	public ContactServiceImpl() {
		_dataService = new ContactDataServiceImpl();		
	}
	
	public ContactServiceImpl(ContactDataService dataService) {
		_dataService = dataService;
	}
		
	@Override
	public String getContactByID(String request) {
		try {
			JSONObject obj = new JSONObject(request);
			String id = obj.getString("id");
		
			String response = _dataService.GetRecordByID(id);
			if (response == null) {
				return "{ \"error\": \"" + ERROR_MESSAGE + "\" }";
			}
		
			if (response == "{}") {
				return "{ \"error\": \"" + NO_MATCH_MESSAGE + "\" }";
			}
		
			return response;
		}
		catch (Exception e) {
			return "{ \"error\": \"" + BAD_REQUEST + "\" }";
		}
	}

	@Override
	public String getContactsBySearch(String request) {
		try {
			JSONObject obj = new JSONObject(request);
			String searchTerm = obj.getString("searchTerm");
		
			String response = _dataService.GetRecordsBySearch(searchTerm);
			if (response == null) {
				return "{ \"error\": \"" + ERROR_MESSAGE + "\" }";
			}
		
			obj = new JSONObject(response);
			JSONArray arr = obj.getJSONArray("results");
			if (arr.length() == 0) {
				return "{ \"error\": \"" + NO_MATCH_MESSAGE + "\" }";
			}
		
			return response;
		}
		catch (Exception e) {
			return "{ \"error\": \"" + BAD_REQUEST + "\" }";
		}
	}
}
