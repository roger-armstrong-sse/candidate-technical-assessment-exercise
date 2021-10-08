package com.gaggle.rarmstrong.contactsearch;

public class ContactServiceImplProxy implements com.gaggle.rarmstrong.contactsearch.ContactServiceImpl {
  private String _endpoint = null;
  private com.gaggle.rarmstrong.contactsearch.ContactServiceImpl contactServiceImpl = null;
  
  public ContactServiceImplProxy() {
    _initContactServiceImplProxy();
  }
  
  public ContactServiceImplProxy(String endpoint) {
    _endpoint = endpoint;
    _initContactServiceImplProxy();
  }
  
  private void _initContactServiceImplProxy() {
    try {
      contactServiceImpl = (new com.gaggle.rarmstrong.contactsearch.ContactServiceImplServiceLocator()).getContactServiceImpl();
      if (contactServiceImpl != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)contactServiceImpl)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)contactServiceImpl)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (contactServiceImpl != null)
      ((javax.xml.rpc.Stub)contactServiceImpl)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public com.gaggle.rarmstrong.contactsearch.ContactServiceImpl getContactServiceImpl() {
    if (contactServiceImpl == null)
      _initContactServiceImplProxy();
    return contactServiceImpl;
  }
  
  public java.lang.String getContactByID(java.lang.String request) throws java.rmi.RemoteException{
    if (contactServiceImpl == null)
      _initContactServiceImplProxy();
    return contactServiceImpl.getContactByID(request);
  }
  
  public java.lang.String getContactsBySearch(java.lang.String request) throws java.rmi.RemoteException{
    if (contactServiceImpl == null)
      _initContactServiceImplProxy();
    return contactServiceImpl.getContactsBySearch(request);
  }
  
  
}