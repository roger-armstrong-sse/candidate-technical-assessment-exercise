package com.gaggle.rarmstrong.contactsearch.models;

public class Contact {
	private String id;
	private String name;
	
	public Contact(String id, String name) {
		this.id = id;
		this.name = name;
	}
	
	public String getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}
	
	//return a JSON-formatted string of the data
	@Override
	public String toString() {
		return "{ \"id\": \"" + id + "\", \"name\": \"" + name + "\" }";
	}
}
