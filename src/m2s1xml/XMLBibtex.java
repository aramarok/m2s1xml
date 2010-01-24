package m2s1xml;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.io.StringWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.sax.SAXResult;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathFactory;

import org.apache.fop.apps.FOUserAgent;
import org.apache.fop.apps.Fop;
import org.apache.fop.apps.FopFactory;
import org.apache.fop.apps.MimeConstants;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

public class XMLBibtex {

	public static void main(String[] args) {

		try {
			// HashMap<String, String> bittexEntryDetails = new HashMap<String,
			// String>();
			// bittexEntryDetails.put("author", "Mircea Eliade");
			// bittexEntryDetails.put("editor", "Eugen Simion");
			// bittexEntryDetails.put("title", "La tiganci");
			// bittexEntryDetails.put("publisher", "Editura RO");
			// bittexEntryDetails.put("year", "1969");
			// add("EliadeM1969LaTiganci", "book", bittexEntryDetails);

			// remove("EliadeM1969LaTiganci");
			System.out.println(search("ANI", "1974"));
			// search("EDITOR", "Wasowski")
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static boolean add(final String bibtexEntryId,
			final String bibtexEntryType,
			final HashMap<String, String> bittexEntryDetails) {

		// TODO: add validation

		if (bibtexEntryId != null && bibtexEntryType != null
				&& bittexEntryDetails != null) {
			try {
				File dbDocFile = new File(Constants.BIBTEX_XML_DB);

				Document dbDoc;

				XPath xPath;

				Node bibtexEntries = null;

				DocumentBuilderFactory factory = DocumentBuilderFactory
						.newInstance();
				DocumentBuilder builder = factory.newDocumentBuilder();
				dbDoc = builder.parse(dbDocFile);

				XPathFactory xpf = XPathFactory.newInstance();
				xPath = xpf.newXPath();
				xPath.setNamespaceContext(new BibTexPrefix());

				bibtexEntries = (Node) xPath.evaluate("/bibtex:file/.", dbDoc,
						XPathConstants.NODE);

				Element bibtexEntry = dbDoc.createElement(Constants.XML_BIBTEX
						+ "entry");
				bibtexEntry.setAttribute("id", bibtexEntryId);

				Element bibtexEntryType_ = dbDoc
						.createElement(Constants.XML_BIBTEX + bibtexEntryType);
				Element bibtexEntryType__ = null;

				Iterator<Map.Entry<String, String>> iterator = bittexEntryDetails
						.entrySet().iterator();
				Map.Entry<String, String> entry = null;

				while (iterator.hasNext()) {
					entry = iterator.next();
					bibtexEntryType__ = dbDoc
							.createElement(Constants.XML_BIBTEX
									+ entry.getKey());
					bibtexEntryType__.setTextContent(entry.getValue());
					bibtexEntryType_.appendChild(bibtexEntryType__);
				}

				bibtexEntry.appendChild(bibtexEntryType_);
				bibtexEntries.appendChild(bibtexEntry);

				TransformerFactory transformerfactory = TransformerFactory
						.newInstance();
				Transformer transformer = transformerfactory.newTransformer();

				transformer.setOutputProperty(OutputKeys.METHOD, "xml");
				transformer.setOutputProperty(OutputKeys.ENCODING, "utf-8");
				transformer.setOutputProperty(
						"{http://xml.apache.org/xslt}indent-amount", "4");
				transformer.setOutputProperty(OutputKeys.INDENT, "yes");

				DOMSource domSource = new DOMSource(dbDoc);
				FileOutputStream fOut = new FileOutputStream(dbDocFile);
				transformer.transform(domSource, new StreamResult(fOut));
				return true;
			} catch (Exception ex) {
				System.out.println("Error while adding bibtex entry.");
				ex.printStackTrace();
				return false;
			}
		} else {
			return false;
		}

	}

	public static boolean remove(final String bibtexEntryId) {
		try {
			TransformerFactory transformerFactory = TransformerFactory
					.newInstance();

			Transformer transformer = transformerFactory
					.newTransformer(new StreamSource(
							Constants.BIBTEX_XSL_REMOVE));

			transformer.setParameter("removeEntryId", bibtexEntryId);

			transformer.transform(new StreamSource(new File(
					Constants.BIBTEX_XML_DB)), new StreamResult(new File(
					Constants.BIBTEX_XML_DB)));

		} catch (TransformerConfigurationException tce) {
			tce.printStackTrace();
			return false;
		} catch (TransformerException te) {
			te.printStackTrace();
			return false;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public byte[] getPDFReport() {
		try {

			getPDFReport("ALL", "ALL");

			return Util.getBytesFromFile(new File(Constants.BIBTEX_PDF_FOP_OUT));
			
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(-1);
		}
		return null;
	}

	public static byte[] getPDFReport(final String searchBy, final String value) {
		try {
			File xmlFile = new File(Constants.BIBTEX_XML_DB);
			File xsltFile = new File(Constants.BIBTEX_PDF_FOP_XSL);
			File pdfFile = new File(Constants.BIBTEX_PDF_FOP_OUT);

			FopFactory fopFactory = FopFactory.newInstance();
			FOUserAgent foUserAgent = fopFactory.newFOUserAgent();
			OutputStream outputStream = new FileOutputStream(pdfFile);
			outputStream = new BufferedOutputStream(outputStream);

			try {
				Fop fop = fopFactory.newFop(MimeConstants.MIME_PDF,
						foUserAgent, outputStream);
				TransformerFactory transformerFactory = TransformerFactory
						.newInstance();
				Transformer transformer = transformerFactory
						.newTransformer(new StreamSource(xsltFile));
				transformer.setParameter("versionParam", "2.0");

				transformer.setParameter("PARAM_NAME", searchBy);
				transformer.setParameter("PARAM_VALUE", value);

				Source source = new StreamSource(xmlFile);
				Result result = new SAXResult(fop.getDefaultHandler());
				transformer.transform(source, result);
			} finally {
				outputStream.close();
			}
			return Util.getBytesFromFile(pdfFile);
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(-1);
		}
		return null;
	}

	public static String search(final String searchBy, final String value) {

		String outcome = "";

		try {
			TransformerFactory transformerFactory = TransformerFactory
					.newInstance();

			Transformer transformer = transformerFactory
					.newTransformer(new StreamSource(
							Constants.BIBTEX_XSL_SEARCH));

			transformer.setParameter("PARAM_NAME", searchBy);
			transformer.setParameter("PARAM_VALUE", value);

			Writer outWriter = new StringWriter();

			transformer.transform(new StreamSource(new File(
					Constants.BIBTEX_XML_DB)), new StreamResult(outWriter));

			outcome = outWriter.toString();

			getPDFReport(searchBy, value);

		} catch (TransformerConfigurationException tce) {
			tce.printStackTrace();
		} catch (TransformerException te) {
			te.printStackTrace();
		}

		return outcome;
	}
}