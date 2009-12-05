package p1;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;

import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.sax.SAXResult;
import javax.xml.transform.stream.StreamSource;

import org.apache.fop.apps.FOUserAgent;
import org.apache.fop.apps.Fop;
import org.apache.fop.apps.FopFactory;
import org.apache.fop.apps.MimeConstants;

public class FOPPDF {

	public static void main(String[] args) {
		try {
			File xmlFile = new File(Constants.XML_DB);
			File xsltFile = new File(Constants.FOP_XSL);
			File pdfFile = new File(Constants.FOP_OUT);

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
}