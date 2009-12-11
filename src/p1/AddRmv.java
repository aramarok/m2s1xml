package p1;

import java.io.File;
import java.util.HashMap;
import java.util.Map.Entry;

import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

public class AddRmv {

	public static void addEntity(HashMap<String, String> entityData) {
		try {
			TransformerFactory transformerFactory = TransformerFactory
					.newInstance();

			Transformer transformer = transformerFactory
					.newTransformer(new StreamSource(Constants.XSL_ADD));

			for (Entry<String, String> param : entityData.entrySet()) {
				transformer.setParameter(param.getKey(), param.getValue());
			}

			transformer.transform(new StreamSource(new File(Constants.XML_DB)),
					new StreamResult(new File(Constants.XML_DB)));

		} catch (TransformerConfigurationException tce) {
			tce.printStackTrace();
		} catch (TransformerException te) {
			te.printStackTrace();
		}
	}

	public static void deleteEntity(String entityId) {
		try {
			TransformerFactory transformerFactory = TransformerFactory
					.newInstance();

			Transformer transformer = transformerFactory
					.newTransformer(new StreamSource(Constants.XSL_RMV));

			transformer.setParameter("rmvid", entityId);

			transformer.transform(new StreamSource(new File(Constants.XML_DB)),
					new StreamResult(new File(Constants.XML_DB)));

		} catch (TransformerConfigurationException tce) {
			tce.printStackTrace();
		} catch (TransformerException te) {
			te.printStackTrace();
		}
	}

	public static void main(String d[]) {
		HashMap<String, String> hashMap = new HashMap<String, String>();
		hashMap.put("newname", "numenou");
		hashMap.put("newphone", "telnou");
		addEntity(hashMap);

//		deleteEntity("numenou");
	}
}