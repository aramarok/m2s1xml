/**
 * CautareService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package p1client;

public interface CautareService extends javax.xml.rpc.Service {
	public java.lang.String getCautareAddress();

	public p1client.Cautare getCautare() throws javax.xml.rpc.ServiceException;

	public p1client.Cautare getCautare(java.net.URL portAddress)
			throws javax.xml.rpc.ServiceException;
}
