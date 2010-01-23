package util;

import java.io.IOException;
import java.util.HashMap;
import java.util.Set;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 * @author Flavius
 *
 */
public class XMLParserMenuItems extends DefaultHandler {

	HashMap<String, MenuItem> hmMenuItems;
	MenuItem mi;
	String strId;
	private String strTempVal;

	@Override
	public void endElement(String uri, String localName, String qName)
			throws SAXException {
		if (qName.equalsIgnoreCase("menuItems")) {
			// Do nothing
		} else if (qName.equalsIgnoreCase("menuItem")) {
			// Do nothing
		}

	}

	@Override
	public void startElement(String uri, String localName, String qName,
			Attributes attributes) throws SAXException {
		if (qName.equalsIgnoreCase("menuItems")) {
			hmMenuItems = new HashMap<String, MenuItem>();
		} else if (qName.equalsIgnoreCase("menuItem")) {
			strId = attributes.getValue("id");
			MenuItem mi = new MenuItem();
			mi.setName(attributes.getValue("name"));
			mi.setLink(attributes.getValue("link"));
			hmMenuItems.put(strId, mi);
		}

	}

	@Override
	public void characters(char[] ch, int start, int length)
			throws SAXException {
		strTempVal = new String(ch, start, length);
	}

	public HashMap<String, MenuItem> parseDocument(String document) {
		// get a factory
		SAXParserFactory spf = SAXParserFactory.newInstance();
		try {
			// get a new instance of parser
			SAXParser sp = spf.newSAXParser();
			// parse the file and also register this class for call backs
			sp.parse(document, this);
			// Return result
		} catch (SAXException se) {
			se.printStackTrace();
		} catch (ParserConfigurationException pce) {
			pce.printStackTrace();
		} catch (IOException ie) {
			ie.printStackTrace();
		}
		return hmMenuItems;

	}

	/**
	 * @param args
	 */
	public static void main(String args[]) {
		XMLParserMenuItems xmlp = new XMLParserMenuItems();
		HashMap<String, MenuItem> mitems = xmlp
				.parseDocument("D:\\Programe\\eclipse\\Workspace\\"
						+ "m2s1xml\\WebContent\\pages\\menu\\menuItems.xml");
		Set<String> keys = mitems.keySet();
		for (String key : keys) {
			System.out.println("name: " + mitems.get(key).getName() + " link: "
					+ mitems.get(key).getLink());
		}
	}
}
