package com.gaggle.rarmstrong.contactsearch;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
public interface ContactService {

	@WebMethod
	public String GetContactByID(String request);
	
	@WebMethod
	public String GetContactsBySearch(String request);
}
