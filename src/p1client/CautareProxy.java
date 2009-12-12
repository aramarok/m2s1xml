package p1client;

public class CautareProxy implements p1client.Cautare {
	private String _endpoint = null;
	private p1client.Cautare cautare = null;

	public CautareProxy() {
		_initCautareProxy();
	}

	public CautareProxy(String endpoint) {
		_endpoint = endpoint;
		_initCautareProxy();
	}

	private void _initCautareProxy() {
		try {
			cautare = (new p1client.CautareServiceLocator()).getCautare();
			if (cautare != null) {
				if (_endpoint != null)
					((javax.xml.rpc.Stub) cautare)
							._setProperty(
									"javax.xml.rpc.service.endpoint.address",
									_endpoint);
				else
					_endpoint = (String) ((javax.xml.rpc.Stub) cautare)
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
		if (cautare != null)
			((javax.xml.rpc.Stub) cautare)._setProperty(
					"javax.xml.rpc.service.endpoint.address", _endpoint);

	}

	public p1client.Cautare getCautare() {
		if (cautare == null)
			_initCautareProxy();
		return cautare;
	}

	public java.util.HashMap search(java.lang.String searchBy,
			java.lang.String value) throws java.rmi.RemoteException {
		if (cautare == null)
			_initCautareProxy();
		return cautare.search(searchBy, value);
	}

}