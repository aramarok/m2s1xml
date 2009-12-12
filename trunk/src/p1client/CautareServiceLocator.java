/**
 * CautareServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package p1client;

public class CautareServiceLocator extends org.apache.axis.client.Service
		implements p1client.CautareService {

	public CautareServiceLocator() {
	}

	public CautareServiceLocator(org.apache.axis.EngineConfiguration config) {
		super(config);
	}

	public CautareServiceLocator(java.lang.String wsdlLoc,
			javax.xml.namespace.QName sName)
			throws javax.xml.rpc.ServiceException {
		super(wsdlLoc, sName);
	}

	// Use to get a proxy class for Cautare
	private java.lang.String Cautare_address = "http://localhost:8080/m2s1xml/services/Cautare";

	public java.lang.String getCautareAddress() {
		return Cautare_address;
	}

	// The WSDD service name defaults to the port name.
	private java.lang.String CautareWSDDServiceName = "Cautare";

	public java.lang.String getCautareWSDDServiceName() {
		return CautareWSDDServiceName;
	}

	public void setCautareWSDDServiceName(java.lang.String name) {
		CautareWSDDServiceName = name;
	}

	public p1client.Cautare getCautare() throws javax.xml.rpc.ServiceException {
		java.net.URL endpoint;
		try {
			endpoint = new java.net.URL(Cautare_address);
		} catch (java.net.MalformedURLException e) {
			throw new javax.xml.rpc.ServiceException(e);
		}
		return getCautare(endpoint);
	}

	public p1client.Cautare getCautare(java.net.URL portAddress)
			throws javax.xml.rpc.ServiceException {
		try {
			p1client.CautareSoapBindingStub _stub = new p1client.CautareSoapBindingStub(
					portAddress, this);
			_stub.setPortName(getCautareWSDDServiceName());
			return _stub;
		} catch (org.apache.axis.AxisFault e) {
			return null;
		}
	}

	public void setCautareEndpointAddress(java.lang.String address) {
		Cautare_address = address;
	}

	/**
	 * For the given interface, get the stub implementation. If this service has
	 * no port for the given interface, then ServiceException is thrown.
	 */
	public java.rmi.Remote getPort(Class serviceEndpointInterface)
			throws javax.xml.rpc.ServiceException {
		try {
			if (p1client.Cautare.class
					.isAssignableFrom(serviceEndpointInterface)) {
				p1client.CautareSoapBindingStub _stub = new p1client.CautareSoapBindingStub(
						new java.net.URL(Cautare_address), this);
				_stub.setPortName(getCautareWSDDServiceName());
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
		if ("Cautare".equals(inputPortName)) {
			return getCautare();
		} else {
			java.rmi.Remote _stub = getPort(serviceEndpointInterface);
			((org.apache.axis.client.Stub) _stub).setPortName(portName);
			return _stub;
		}
	}

	public javax.xml.namespace.QName getServiceName() {
		return new javax.xml.namespace.QName("http://p1", "CautareService");
	}

	private java.util.HashSet ports = null;

	public java.util.Iterator getPorts() {
		if (ports == null) {
			ports = new java.util.HashSet();
			ports.add(new javax.xml.namespace.QName("http://p1", "Cautare"));
		}
		return ports.iterator();
	}

	/**
	 * Set the endpoint address for the specified port name.
	 */
	public void setEndpointAddress(java.lang.String portName,
			java.lang.String address) throws javax.xml.rpc.ServiceException {

		if ("Cautare".equals(portName)) {
			setCautareEndpointAddress(address);
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
