package p1;

public interface Constants {

	//public String ASSETS_PATH = "../webapps/m2s1xml/files/";
	public String ASSETS_PATH = "WebContent/files/";
	
	// bibtex
	public String XML_PATH = ASSETS_PATH + "bibtex.xml";
	public String XSD_PATH = ASSETS_PATH + "bibtex.xsd";
	public String FOP_BOOKS = ASSETS_PATH + "fo_books.xsl";

	// myagenda
	public String XML_DB = ASSETS_PATH + "myagenda.xml";
	public String FOP_XSL = ASSETS_PATH + "xfo.xsl";
	public String FOP_OUT = ASSETS_PATH + "test.pdf";

	public String XSL_ADD = ASSETS_PATH + "myagendaadd.xsl";
	public String XSL_RMV = ASSETS_PATH + "myagendarmv.xsl";

}
