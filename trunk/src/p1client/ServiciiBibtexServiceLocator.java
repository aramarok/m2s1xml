/**
 * ServiciiBibtexServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package p1client;

public class ServiciiBibtexServiceLocator extends
		org.apache.axis.client.Service implements
		p1client.ServiciiBibtexService {

	private static final long serialVersionUID = 1L;

	public ServiciiBibtexServiceLocator() {
	}

	public ServiciiBibtexServiceLocator(
			org.apache.axis.EngineConfiguration config) {
		super(config);
	}

	public ServiciiBibtexServiceLocator(java.lang.String wsdlLoc,
			javax.xml.namespace.QName sName)
			throws javax.xml.rpc.ServiceException {
		super(wsdlLoc, sName);
	}

	// Use to get a proxy class for ServiciiBibtex
	private java.lang.String ServiciiBibtex_address = "http://localhost:8080/m2s1xml/services/ServiciiBibtex";

	public java.lang.String getServiciiBibtexAddress() {
		return ServiciiBibtex_address;
	}

	// The WSDD service name defaults to the port name.
	private java.lang.String ServiciiBibtexWSDDServiceName = "ServiciiBibtex";

	public java.lang.String getServiciiBibtexWSDDServiceName() {
		return ServiciiBibtexWSDDServiceName;
	}

	public void setServiciiBibtexWSDDServiceName(java.lang.String name) {
		ServiciiBibtexWSDDServiceName = name;
	}

	public p1client.ServiciiBibtex getServiciiBibtex()
			throws javax.xml.rpc.ServiceException {
		java.net.URL endpoint;
		try {
			endpoint = new java.net.URL(ServiciiBibtex_address);
		} catch (java.net.MalformedURLException e) {
			throw new javax.xml.rpc.ServiceException(e);
		}
		return getServiciiBibtex(endpoint);
	}

	public p1client.ServiciiBibtex getServiciiBibtex(java.net.URL portAddress)
			throws javax.xml.rpc.ServiceException {
		try {
			p1client.ServiciiBibtexSoapBindingStub _stub = new p1client.ServiciiBibtexSoapBindingStub(
					portAddress, this);
			_stub.setPortName(getServiciiBibtexWSDDServiceName());
			return _stub;
		} catch (org.apache.axis.AxisFault e) {
			return null;
		}
	}

	public void setServiciiBibtexEndpointAddress(java.lang.String address) {
		ServiciiBibtex_address = address;
	}

	/**
	 * For the given interface, get the stub implementation. If this service has
	 * no port for the given interface, then ServiceException is thrown.
	 */
	public java.rmi.Remote getPort(Class serviceEndpointInterface)
			throws javax.xml.rpc.ServiceException {
		try {
			if (p1client.ServiciiBibtex.class
					.isAssignableFrom(serviceEndpointInterface)) {
				p1client.ServiciiBibtexSoapBindingStub _stub = new p1client.ServiciiBibtexSoapBindingStub(
						new java.net.URL(ServiciiBibtex_address), this);
				_stub.setPortName(getServiciiBibtexWSDDServiceName());
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
		if ("ServiciiBibtex".equals(inputPortName)) {
			return getServiciiBibtex();
		} else {
			java.rmi.Remote _stub = getPort(serviceEndpointInterface);
			((org.apache.axis.client.Stub) _stub).setPortName(portName);
			return _stub;
		}
	}

	public javax.xml.namespace.QName getServiceName() {
		return new javax.xml.namespace.QName("http://p1",
				"ServiciiBibtexService");
	}

	private java.util.HashSet ports = null;

	public java.util.Iterator getPorts() {
		if (ports == null) {
			ports = new java.util.HashSet();
			ports.add(new javax.xml.namespace.QName("http://p1",
					"ServiciiBibtex"));
		}
		return ports.iterator();
	}

	/**
	 * Set the endpoint address for the specified port name.
	 */
	public void setEndpointAddress(java.lang.String portName,
			java.lang.String address) throws javax.xml.rpc.ServiceException {

		if ("ServiciiBibtex".equals(portName)) {
			setServiciiBibtexEndpointAddress(address);
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
