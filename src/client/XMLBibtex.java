/**
 * XMLBibtex.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package client;

public interface XMLBibtex extends java.rmi.Remote {
    public boolean add(java.lang.String bibtexEntryId, java.lang.String bibtexEntryType, java.util.HashMap bittexEntryDetails) throws java.rmi.RemoteException;
    public boolean remove(java.lang.String bibtexEntryId) throws java.rmi.RemoteException;
    public java.lang.String search(java.lang.String searchBy, java.lang.String value) throws java.rmi.RemoteException;
    public byte[] getPDFReport() throws java.rmi.RemoteException;
}
