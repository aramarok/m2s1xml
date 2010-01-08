package oldP1;

import java.io.File;
import java.io.StringWriter;
import java.io.Writer;

import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

public class ServiciiBibtex {

	public static void main(String[] args) {

		try {
			System.out.println(search("EDITOR", "Wasowski"));
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static String add(final String entryXML) {
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

	public static String search(final String searchBy, final String value) {

		String outcome = "";

		try {
			TransformerFactory transformerFactory = TransformerFactory
					.newInstance();

			Transformer transformer = transformerFactory
					.newTransformer(new StreamSource(
							OldConstants.BIBTEX_XSL_SEARCH));

			transformer.setParameter("PARAM_NAME", searchBy);
			transformer.setParameter("PARAM_VALUE", value);

			Writer outWriter = new StringWriter();

			transformer.transform(new StreamSource(new File(
					OldConstants.BIBTEX_XML_DB)), new StreamResult(outWriter));

			outcome = outWriter.toString();

			System.out.println(outcome);

		} catch (TransformerConfigurationException tce) {
			tce.printStackTrace();
		} catch (TransformerException te) {
			te.printStackTrace();
		}

		return outcome;
	}
}
