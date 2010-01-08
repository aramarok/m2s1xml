package m2s1xml;

import java.util.Iterator;

import javax.xml.XMLConstants;
import javax.xml.namespace.NamespaceContext;

public class BibTexPrefix implements NamespaceContext {
	public String getNamespaceURI(String prefix) {
		if (prefix.equals("bibtex"))
			return "http://bibtexml.sf.net/";
		else
			return XMLConstants.NULL_NS_URI;
	}

	public String getPrefix(String namespace) {
		if (namespace.equals("http://bibtexml.sf.net/"))
			return "bibtex";
		else
			return null;
	}

	@SuppressWarnings("unchecked")
	public Iterator getPrefixes(String namespaceURI) {
		return null;
	}
}