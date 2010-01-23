package m2s1xml;

public interface Constants {

	 //String ASSETS_PATH = "../m2s1xml/WebContent/files/bibtex/";

	// TODO: uncomment before deploy
	String ASSETS_PATH = "../webapps/m2s1xml/files/bibtex/";

	String BIBTEX_XML_DB = ASSETS_PATH + "bibtex.xml";
	String BIBTEX_XSD = ASSETS_PATH + "bibtex.xsd";

	String BIBTEX_PDF_FOP_XSL = ASSETS_PATH + "bibtex.xsl";
	String BIBTEX_PDF_FOP_OUT = ASSETS_PATH + "bibtex.pdf";

	String BIBTEX_XSL_SEARCH = ASSETS_PATH + "bibtexSearch.xsl";
	String BIBTEX_XSL_ADD = ASSETS_PATH + "bibtexAdd.xsl";
	String BIBTEX_XSL_REMOVE = ASSETS_PATH + "bibtexRemoveV2.xsl";

	String XML_BIBTEX = "bibtex:";
}