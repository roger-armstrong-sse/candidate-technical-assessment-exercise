/**
 * ContactServiceImplServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.gaggle.rarmstrong.contactsearch;

public class ContactServiceImplServiceLocator extends org.apache.axis.client.Service implements com.gaggle.rarmstrong.contactsearch.ContactServiceImplService {

    public ContactServiceImplServiceLocator() {
    }


    public ContactServiceImplServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public ContactServiceImplServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for ContactServiceImpl
    private java.lang.String ContactServiceImpl_address = "http://localhost:8080/ContactSearchService/services/ContactServiceImpl";

    public java.lang.String getContactServiceImplAddress() {
        return ContactServiceImpl_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String ContactServiceImplWSDDServiceName = "ContactServiceImpl";

    public java.lang.String getContactServiceImplWSDDServiceName() {
        return ContactServiceImplWSDDServiceName;
    }

    public void setContactServiceImplWSDDServiceName(java.lang.String name) {
        ContactServiceImplWSDDServiceName = name;
    }

    public com.gaggle.rarmstrong.contactsearch.ContactServiceImpl getContactServiceImpl() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(ContactServiceImpl_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getContactServiceImpl(endpoint);
    }

    public com.gaggle.rarmstrong.contactsearch.ContactServiceImpl getContactServiceImpl(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            com.gaggle.rarmstrong.contactsearch.ContactServiceImplSoapBindingStub _stub = new com.gaggle.rarmstrong.contactsearch.ContactServiceImplSoapBindingStub(portAddress, this);
            _stub.setPortName(getContactServiceImplWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setContactServiceImplEndpointAddress(java.lang.String address) {
        ContactServiceImpl_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (com.gaggle.rarmstrong.contactsearch.ContactServiceImpl.class.isAssignableFrom(serviceEndpointInterface)) {
                com.gaggle.rarmstrong.contactsearch.ContactServiceImplSoapBindingStub _stub = new com.gaggle.rarmstrong.contactsearch.ContactServiceImplSoapBindingStub(new java.net.URL(ContactServiceImpl_address), this);
                _stub.setPortName(getContactServiceImplWSDDServiceName());
                return _stub;
            }
        }
        catch (java.lang.Throwable t) {
            throw new javax.xml.rpc.ServiceException(t);
        }
        throw new javax.xml.rpc.ServiceException("There is no stub implementation for the interface:  " + (serviceEndpointInterface == null ? "null" : serviceEndpointInterface.getName()));
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(javax.xml.namespace.QName portName, Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        if (portName == null) {
            return getPort(serviceEndpointInterface);
        }
        java.lang.String inputPortName = portName.getLocalPart();
        if ("ContactServiceImpl".equals(inputPortName)) {
            return getContactServiceImpl();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://contactsearch.rarmstrong.gaggle.com", "ContactServiceImplService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://contactsearch.rarmstrong.gaggle.com", "ContactServiceImpl"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("ContactServiceImpl".equals(portName)) {
            setContactServiceImplEndpointAddress(address);
        }
        else 
{ // Unknown Port Name
            throw new javax.xml.rpc.ServiceException(" Cannot set Endpoint Address for Unknown Port" + portName);
        }
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(javax.xml.namespace.QName portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        setEndpointAddress(portName.getLocalPart(), address);
    }

}
