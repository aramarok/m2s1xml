package oldP1;

import java.io.File;
import java.util.HashMap;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

public class Cautare {

	private static String Q_AUTORI = "//bibtex:entry//*[bibtex:author[contains(upper-case(text()), upper-case('QPARAM'))]]";
	private static String Q_ANI = "//bibtex:entry//*[bibtex:year[text() = QPARAM]]";
	private static String Q_CUVINTE_CHEIE = "//bibtex:entry//*[bibtex:keywords[contains(upper-case(text()), upper-case('QPARAM'))]]";
	private static String Q_REVISTA = "//bibtex:entry//*[bibtex:publisher[contains(upper-case(text()), upper-case('QPARAM'))]]";
	private static String Q_EDITURA = "//bibtex:entry//*[bibtex:editor[contains(upper-case(text()), upper-case('QPARAM'))]]";

	public static void main(String[] args) {

		try {
			remove("Bergamaschi1999");

			// search("ANI", "1974");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static String add(final String bibtexEntryId,
			final String bibtexEntryType,
			final HashMap<String, String> bittexEntryDetails) {
		String outcome = null;

		return outcome;
	}

	public static String remove(final String bibtexEntryId) {
		String outcome = null;
		try {
			TransformerFactory transformerFactory = TransformerFactory
					.newInstance();

			Transformer transformer = transformerFactory
					.newTransformer(new StreamSource(
							OldConstants.BIBTEX_XSL_REMOVE));

			transformer.setParameter("removeEntryId", bibtexEntryId);

			transformer.transform(new StreamSource(new File(
					OldConstants.BIBTEX_XML_DB)), new StreamResult(new File(
					OldConstants.BIBTEX_XML_DB)));

		} catch (TransformerConfigurationException tce) {
			tce.printStackTrace();
		} catch (TransformerException te) {
			te.printStackTrace();
		}
		return outcome;
	}

	public static HashMap<String, String> search(final String searchBy,
			final String value) {

		HashMap<String, String> outcome = new HashMap<String, String>();

		String query = getQuery(searchBy, value);

		if (query != null) {

			DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory
					.newInstance();
			documentBuilderFactory.setNamespaceAware(true);

			DocumentBuilder documentBuilder = null;
			try {
				documentBuilder = documentBuilderFactory.newDocumentBuilder();
			} catch (ParserConfigurationException e) {
				e.printStackTrace();
			}

			Document document = null;
			try {
				document = documentBuilder.parse(OldConstants.BIBTEX_XML_DB);
			} catch (Exception e) {
				e.printStackTrace();
			}

			XPathFactory xPathFactory = XPathFactory.newInstance();
			XPath xPath = xPathFactory.newXPath();

			xPath.setNamespaceContext(new BibTexPrefix());

			XPathExpression xPathExpression = null;
			try {
				xPathExpression = xPath.compile(query);
			} catch (XPathExpressionException e) {
				e.printStackTrace();
			}

			Object object = null;
			try {
				object = xPathExpression.evaluate(document,
						XPathConstants.NODESET);
			} catch (XPathExpressionException e) {
				e.printStackTrace();
			}
			NodeList listaNoduri = (NodeList) object;
			for (int i = 0; i < listaNoduri.getLength(); i++) {
				System.out.println(listaNoduri.item(i).getTextContent());
				outcome.put(String.valueOf(i), listaNoduri.item(i)
						.getTextContent());
			}

		}

		return outcome;
	}

	private static String getQuery(String tip, String value) {

		String query = null;

		if ("AUTORI".equals(tip)) {
			query = Q_AUTORI;
		} else if ("ANI".equals(tip)) {
			query = Q_ANI;
		} else if ("CUVINTE_CHEIE".equals(tip)) {
			query = Q_CUVINTE_CHEIE;
		} else if ("REVISTA".equals(tip)) {
			query = Q_REVISTA;
		} else if ("EDITURA".equals(tip)) {
			query = Q_EDITURA;
		}

		if (query != null) {
			query = query.replace("QPARAM", value);
		}

		return query;
	}
}
