package p1client;

public class ServiciiBibtexProxy implements p1client.ServiciiBibtex {
  private String _endpoint = null;
  private p1client.ServiciiBibtex serviciiBibtex = null;
  
  public ServiciiBibtexProxy() {
    _initServiciiBibtexProxy();
  }
  
  public ServiciiBibtexProxy(String endpoint) {
    _endpoint = endpoint;
    _initServiciiBibtexProxy();
  }
  
  private void _initServiciiBibtexProxy() {
    try {
      serviciiBibtex = (new p1client.ServiciiBibtexServiceLocator()).getServiciiBibtex();
      if (serviciiBibtex != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)serviciiBibtex)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)serviciiBibtex)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (serviciiBibtex != null)
      ((javax.xml.rpc.Stub)serviciiBibtex)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public p1client.ServiciiBibtex getServiciiBibtex() {
    if (serviciiBibtex == null)
      _initServiciiBibtexProxy();
    return serviciiBibtex;
  }
  
  public java.lang.String add(java.lang.String entryXML) throws java.rmi.RemoteException{
    if (serviciiBibtex == null)
      _initServiciiBibtexProxy();
    return serviciiBibtex.add(entryXML);
  }
  
  public java.lang.String remove(java.lang.String bibtexEntryId) throws java.rmi.RemoteException{
    if (serviciiBibtex == null)
      _initServiciiBibtexProxy();
    return serviciiBibtex.remove(bibtexEntryId);
  }
  
  public java.lang.String search(java.lang.String searchBy, java.lang.String value) throws java.rmi.RemoteException{
    if (serviciiBibtex == null)
      _initServiciiBibtexProxy();
    return serviciiBibtex.search(searchBy, value);
  }
  
  
}