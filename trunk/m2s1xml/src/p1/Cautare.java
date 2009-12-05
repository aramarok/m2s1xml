package p1;

import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class Cautare {

	@SuppressWarnings("unused")
	private static String Q_AUTORI = "//bibtex:entry//*[bibtex:author[contains(upper-case(text()), upper-case('ca'))]]";
	@SuppressWarnings("unused")
	private static String Q_ANI = "//bibtex:entry//*[bibtex:year[text() = 2006]]";
	@SuppressWarnings("unused")
	private static String Q_CUVINTE_CHEIE = "//bibtex:entry//*[bibtex:keywords[contains(upper-case(text()), upper-case('mm'))]]";
	@SuppressWarnings("unused")
	private static String Q_REVISTA = "//bibtex:entry//*[bibtex:publisher[contains(upper-case(text()), upper-case('s'))]]";
	@SuppressWarnings("unused")
	private static String Q_EDITURA = "//bibtex:entry//*[bibtex:editor[contains(upper-case(text()), upper-case('be'))]]";

	public static void main(String[] args) throws ParserConfigurationException,
			SAXException, IOException, XPathExpressionException {

		DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory
				.newInstance();
		documentBuilderFactory.setNamespaceAware(true);

		DocumentBuilder documentBuilder = documentBuilderFactory
				.newDocumentBuilder();
		Document document = documentBuilder.parse(Constants.XML_PATH);

		XPathFactory xPathFactory = XPathFactory.newInstance();
		XPath xPath = xPathFactory.newXPath();

		xPath.setNamespaceContext(new BibTexPrefix());

		XPathExpression xPathExpression = xPath.compile(Q_ANI);

		Object object = xPathExpression.evaluate(document,
				XPathConstants.NODESET);
		NodeList listaNoduri = (NodeList) object;
		for (int i = 0; i < listaNoduri.getLength(); i++) {
			System.out.println(listaNoduri.item(i).getTextContent());
		}

	}
}
