package m2s1xml;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.io.StringWriter;
import java.io.Writer;
import java.util.HashMap;

import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.sax.SAXResult;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

import org.apache.fop.apps.FOUserAgent;
import org.apache.fop.apps.Fop;
import org.apache.fop.apps.FopFactory;
import org.apache.fop.apps.MimeConstants;

public class XMLBibtex {

	public static void main(String[] args) {

		try {
			remove("Bergamaschi1999");

			// search("ANI", "1974");
			// search("EDITOR", "Wasowski")
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
							Constants.BIBTEX_XSL_REMOVE));

			transformer.setParameter("removeEntryId", bibtexEntryId);

			transformer.transform(new StreamSource(new File(
					Constants.BIBTEX_XML_DB)), new StreamResult(new File(
					Constants.BIBTEX_XML_DB)));

		} catch (TransformerConfigurationException tce) {
			tce.printStackTrace();
		} catch (TransformerException te) {
			te.printStackTrace();
		}
		return outcome;
	}

	public void getPDFReport() {
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
				Source source = new StreamSource(xmlFile);
				Result result = new SAXResult(fop.getDefaultHandler());
				transformer.transform(source, result);
			} finally {
				outputStream.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(-1);
		}
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

			System.out.println(outcome);

		} catch (TransformerConfigurationException tce) {
			tce.printStackTrace();
		} catch (TransformerException te) {
			te.printStackTrace();
		}

		return outcome;
	}
}
