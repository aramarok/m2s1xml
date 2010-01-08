package client;

public class XMLBibtexProxy implements client.XMLBibtex {
	private String _endpoint = null;
	private client.XMLBibtex xMLBibtex = null;

	public XMLBibtexProxy() {
		_initXMLBibtexProxy();
	}

	public XMLBibtexProxy(String endpoint) {
		_endpoint = endpoint;
		_initXMLBibtexProxy();
	}

	private void _initXMLBibtexProxy() {
		try {
			xMLBibtex = (new client.XMLBibtexServiceLocator()).getXMLBibtex();
			if (xMLBibtex != null) {
				if (_endpoint != null)
					((javax.xml.rpc.Stub) xMLBibtex)
							._setProperty(
									"javax.xml.rpc.service.endpoint.address",
									_endpoint);
				else
					_endpoint = (String) ((javax.xml.rpc.Stub) xMLBibtex)
							._getProperty("javax.xml.rpc.service.endpoint.address");
			}

		} catch (javax.xml.rpc.ServiceException serviceException) {
		}
	}

	public String getEndpoint() {
		return _endpoint;
	}

	public void setEndpoint(String endpoint) {
		_endpoint = endpoint;
		if (xMLBibtex != null)
			((javax.xml.rpc.Stub) xMLBibtex)._setProperty(
					"javax.xml.rpc.service.endpoint.address", _endpoint);

	}

	public client.XMLBibtex getXMLBibtex() {
		if (xMLBibtex == null)
			_initXMLBibtexProxy();
		return xMLBibtex;
	}

	public boolean add(java.lang.String bibtexEntryId,
			java.lang.String bibtexEntryType,
			java.util.HashMap bittexEntryDetails)
			throws java.rmi.RemoteException {
		if (xMLBibtex == null)
			_initXMLBibtexProxy();
		return xMLBibtex
				.add(bibtexEntryId, bibtexEntryType, bittexEntryDetails);
	}

	public boolean remove(java.lang.String bibtexEntryId)
			throws java.rmi.RemoteException {
		if (xMLBibtex == null)
			_initXMLBibtexProxy();
		return xMLBibtex.remove(bibtexEntryId);
	}

	public java.lang.String search(java.lang.String searchBy,
			java.lang.String value) throws java.rmi.RemoteException {
		if (xMLBibtex == null)
			_initXMLBibtexProxy();
		return xMLBibtex.search(searchBy, value);
	}

	public byte[] getPDFReport() throws java.rmi.RemoteException {
		if (xMLBibtex == null)
			_initXMLBibtexProxy();
		return xMLBibtex.getPDFReport();
	}

}