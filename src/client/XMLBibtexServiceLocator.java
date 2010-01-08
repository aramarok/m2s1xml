/**
 * XMLBibtexServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package client;

public class XMLBibtexServiceLocator extends org.apache.axis.client.Service
		implements client.XMLBibtexService {

	public XMLBibtexServiceLocator() {
	}

	public XMLBibtexServiceLocator(org.apache.axis.EngineConfiguration config) {
		super(config);
	}

	public XMLBibtexServiceLocator(java.lang.String wsdlLoc,
			javax.xml.namespace.QName sName)
			throws javax.xml.rpc.ServiceException {
		super(wsdlLoc, sName);
	}

	// Use to get a proxy class for XMLBibtex
	private java.lang.String XMLBibtex_address = "http://localhost:8080/m2s1xml/services/XMLBibtex";

	public java.lang.String getXMLBibtexAddress() {
		return XMLBibtex_address;
	}

	// The WSDD service name defaults to the port name.
	private java.lang.String XMLBibtexWSDDServiceName = "XMLBibtex";

	public java.lang.String getXMLBibtexWSDDServiceName() {
		return XMLBibtexWSDDServiceName;
	}

	public void setXMLBibtexWSDDServiceName(java.lang.String name) {
		XMLBibtexWSDDServiceName = name;
	}

	public client.XMLBibtex getXMLBibtex()
			throws javax.xml.rpc.ServiceException {
		java.net.URL endpoint;
		try {
			endpoint = new java.net.URL(XMLBibtex_address);
		} catch (java.net.MalformedURLException e) {
			throw new javax.xml.rpc.ServiceException(e);
		}
		return getXMLBibtex(endpoint);
	}

	public client.XMLBibtex getXMLBibtex(java.net.URL portAddress)
			throws javax.xml.rpc.ServiceException {
		try {
			client.XMLBibtexSoapBindingStub _stub = new client.XMLBibtexSoapBindingStub(
					portAddress, this);
			_stub.setPortName(getXMLBibtexWSDDServiceName());
			return _stub;
		} catch (org.apache.axis.AxisFault e) {
			return null;
		}
	}

	public void setXMLBibtexEndpointAddress(java.lang.String address) {
		XMLBibtex_address = address;
	}

	/**
	 * For the given interface, get the stub implementation. If this service has
	 * no port for the given interface, then ServiceException is thrown.
	 */
	public java.rmi.Remote getPort(Class serviceEndpointInterface)
			throws javax.xml.rpc.ServiceException {
		try {
			if (client.XMLBibtex.class
					.isAssignableFrom(serviceEndpointInterface)) {
				client.XMLBibtexSoapBindingStub _stub = new client.XMLBibtexSoapBindingStub(
						new java.net.URL(XMLBibtex_address), this);
				_stub.setPortName(getXMLBibtexWSDDServiceName());
				return _stub;
			}
		} catch (java.lang.Throwable t) {
			throw new javax.xml.rpc.ServiceException(t);
		}
		throw new javax.xml.rpc.ServiceException(
				"There is no stub implementation for the interface:  "
						+ (serviceEndpointInterface == null ? "null"
								: serviceEndpointInterface.getName()));
	}

	/**
	 * For the given interface, get the stub implementation. If this service has
	 * no port for the given interface, then ServiceException is thrown.
	 */
	public java.rmi.Remote getPort(javax.xml.namespace.QName portName,
			Class serviceEndpointInterface)
			throws javax.xml.rpc.ServiceException {
		if (portName == null) {
			return getPort(serviceEndpointInterface);
		}
		java.lang.String inputPortName = portName.getLocalPart();
		if ("XMLBibtex".equals(inputPortName)) {
			return getXMLBibtex();
		} else {
			java.rmi.Remote _stub = getPort(serviceEndpointInterface);
			((org.apache.axis.client.Stub) _stub).setPortName(portName);
			return _stub;
		}
	}

	public javax.xml.namespace.QName getServiceName() {
		return new javax.xml.namespace.QName("http://m2s1xml",
				"XMLBibtexService");
	}

	private java.util.HashSet ports = null;

	public java.util.Iterator getPorts() {
		if (ports == null) {
			ports = new java.util.HashSet();
			ports.add(new javax.xml.namespace.QName("http://m2s1xml",
					"XMLBibtex"));
		}
		return ports.iterator();
	}

	/**
	 * Set the endpoint address for the specified port name.
	 */
	public void setEndpointAddress(java.lang.String portName,
			java.lang.String address) throws javax.xml.rpc.ServiceException {

		if ("XMLBibtex".equals(portName)) {
			setXMLBibtexEndpointAddress(address);
		} else { // Unknown Port Name
			throw new javax.xml.rpc.ServiceException(
					" Cannot set Endpoint Address for Unknown Port" + portName);
		}
	}

	/**
	 * Set the endpoint address for the specified port name.
	 */
	public void setEndpointAddress(javax.xml.namespace.QName portName,
			java.lang.String address) throws javax.xml.rpc.ServiceException {
		setEndpointAddress(portName.getLocalPart(), address);
	}

}
