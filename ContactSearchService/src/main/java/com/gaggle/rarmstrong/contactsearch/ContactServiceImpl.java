package com.gaggle.rarmstrong.contactsearch;

import org.json.*;

import com.gaggle.rarmstrong.contactsearch.services.ContactDataService;

public class ContactServiceImpl implements ContactService {
	private static ContactDataService _dataService;
	
	private static final String NO_MATCH_MESSAGE = "No records matched your search.";
	private static final String ERROR_MESSAGE = "There was an error accessing the data.";
	
	public ContactServiceImpl(ContactDataService dataService) {
		_dataService = dataService;
	}
		
	@Override
	public String GetContactByID(String request) {
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

	@Override
	public String GetContactsBySearch(String request) {
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
}
