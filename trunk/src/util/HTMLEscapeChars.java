package util;

/**
 * @author Flavius
 * 
 */
public class HTMLEscapeChars {
	private static String escape_chars[] = { "&lt;", "&gt;","&quot;", "&amp;" 
		/*,"&nbsp;", "&#47;", "&#35;", "&#37;", "&#39;" */};
	private static String html_input[] = { "<", ">", "\"", "&" 
		/*," ",*/ /*, "/", "#", "%", "'" */};

	public static String string2HTML(String text) {
		String result = text;
		for (int i = 0; i < html_input.length; i++) {
			result = result.replaceAll(html_input[i], escape_chars[i]);
		}
		return result;
	}

	public static void main(String args[]) {
		String text = "<html xmlns:bibtex=\"http://bibtexml.sf.net/\">\n"
				+ "<body>\n" + "<h2>Results</h2>\n" + "<table border=\"1\">\n"
				+ "<tr bgcolor=\"#9acd32\">\n" + "<th>Author</th>\n"
				+ "<th>Title</th>\n" + "</tr>\n" + "<tr>\n"
				+ "<td>Mavis Gallant</td>\n"
				+ "<td>The End of the World and Other Stories</td>\n"
				+ "</tr>\n" + "</table>\n" + "</body>\n" + "</html>\n";
		System.out.println(HTMLEscapeChars.string2HTML(text));
	}
}
