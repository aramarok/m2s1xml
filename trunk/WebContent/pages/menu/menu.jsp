<%@page import="util.XMLParserMenuItems"%>
<%@page import="java.util.HashMap"%>
<%@page import="util.MenuItem"%>
<%@page import="java.util.Set"%>
<%
	String strInputMenu = "../webapps/m2s1xml/pages/menu/menuItems.xml";
	XMLParserMenuItems xmlp = new XMLParserMenuItems();
	HashMap<String, MenuItem> mItems = xmlp.parseDocument(strInputMenu);
	Set<String> keys = mItems.keySet();
%>

<table width="90%" height="5%"
	align="Center" cellspacing="0" border="0">
	<tr>
		<%
			for (String key : keys) {
				String strName = mItems.get(key).getName();
				String strLink = mItems.get(key).getLink();
		%>
		<td colspan="1" align="center" bgcolor="6666FF">
		<p><a href="<%=strLink%>"> <font face="Arial, sans-serif"
			size="2" color="FFFF66"><%=strName%></font></a></p>
		</td>
		<%
			}
		%>
	</tr>
</table>