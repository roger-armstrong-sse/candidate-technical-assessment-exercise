package com.gaggle.rarmstrong.contactsearch;

import static org.junit.Assert.*;
import org.junit.*;
import org.json.*;

import com.gaggle.rarmstrong.contactsearch.services.ContactDataServiceImpl;

public class ContactServiceImplTest {

	private static ContactDataServiceImpl _dataService;
	
	private static final String NO_MATCH_MESSAGE = "No records matched your search.";
	private static final String ERROR_MESSAGE = "There was an error accessing the data.";
	
	@Before
	public void setUp() {
		_dataService = new ContactDataServiceImpl();
		_dataService.LoadRecords();
	}
	
	@Test
	public void testGetContactByID() {		
		ContactServiceImpl service = new ContactServiceImpl(_dataService);
		String request = "{ \"id\": \"BW2152\" }";
		String response = service.getContactByID(request);
		JSONObject obj = new JSONObject(response);
		
		assertEquals("Bruce Wayne", obj.getString("name"));
	}
	
	@Test
	public void testGetContactByID_NoResults() {
		ContactServiceImpl service = new ContactServiceImpl(_dataService);
		String request = "{ \"id\": \"SR0704\" }";
		String response = service.getContactByID(request);
		JSONObject obj = new JSONObject(response);
		
		assertEquals(NO_MATCH_MESSAGE, obj.getString("error"));
	}
	
	@Test
	public void testGetContactByID_Error() {
		ContactServiceImpl service = new ContactServiceImpl(_dataService);
		
		//destroy the table before accessing it
		_dataService.DestroyRecords();
		
		String request = "{ \"id\": \"BW2152\" }";
		String response = service.getContactByID(request);
		JSONObject obj = new JSONObject(response);
		
		assertEquals(ERROR_MESSAGE, obj.getString("error"));
	}

	@Test
	public void testGetContactsBySearch() {
		ContactServiceImpl service = new ContactServiceImpl(_dataService);
		String request = "{ \"searchTerm\": \"bru\" }";
		String response = service.getContactsBySearch(request);
		JSONObject obj = new JSONObject(response);		
		JSONArray arr = obj.getJSONArray("results");
		
		assertEquals(1, arr.length());
		assertEquals("Bruce Wayne", arr.getJSONObject(0).getString("name"));
	}

	@Test
	public void testGetContactsBySearch_NoResults() {
		ContactServiceImpl service = new ContactServiceImpl(_dataService);
		String request = "{ \"searchTerm\": \"Stark\" }";
		String response = service.getContactsBySearch(request);
		JSONObject obj = new JSONObject(response);
		
		assertEquals(NO_MATCH_MESSAGE, obj.getString("error"));
	}
	
	@Test
	public void testGetContactsBySearch_MultipleResults() {
		ContactServiceImpl service = new ContactServiceImpl(_dataService);
		String request = "{ \"searchTerm\": \"rry\" }";
		String response = service.getContactsBySearch(request);
		JSONObject obj = new JSONObject(response);		
		JSONArray arr = obj.getJSONArray("results");
		
		assertEquals(2, arr.length());
		assertEquals("Arthur Curry", arr.getJSONObject(0).getString("name"));
		assertEquals("Barry Allen", arr.getJSONObject(1).getString("name"));
	}
	
	@Test
	public void testGetContactsBySearch_Error() {
		ContactServiceImpl service = new ContactServiceImpl(_dataService);
		
		//destroy the table before accessing it
		_dataService.DestroyRecords();
				
		String request = "{ \"searchTerm\": \"Wayne\" }";
		String response = service.getContactsBySearch(request);
		JSONObject obj = new JSONObject(response);
		
		assertEquals(ERROR_MESSAGE, obj.getString("error"));
	}
	
	@After
	public void tearDown() {
		_dataService.DestroyRecords();
		_dataService = null;
	}
}
