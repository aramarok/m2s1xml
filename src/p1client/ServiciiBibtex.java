/**
 * ServiciiBibtex.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package p1client;

public interface ServiciiBibtex extends java.rmi.Remote {
    public java.lang.String add(java.lang.String entryXML) throws java.rmi.RemoteException;
    public java.lang.String remove(java.lang.String bibtexEntryId) throws java.rmi.RemoteException;
    public java.lang.String search(java.lang.String searchBy, java.lang.String value) throws java.rmi.RemoteException;
}
