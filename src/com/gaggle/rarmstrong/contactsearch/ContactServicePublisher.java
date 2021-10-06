package com.gaggle.rarmstrong.contactsearch;

import javax.xml.ws.Endpoint;

import com.gaggle.rarmstrong.contactsearch.services.ContactDataServiceImpl;

public class ContactServicePublisher {
	public static void main(String[] args) {
        Endpoint.publish("http://localhost:8080/contactservice", new ContactServiceImpl(new ContactDataServiceImpl()));
    }
}
