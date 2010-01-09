<%@page import="util.XMLParserMenuItems"%>
<%@page import="java.util.HashMap"%>
<%@page import="util.MenuItem"%>
<%@page import="java.util.Set"%>
<html>
<title>m2s1xml</title>
<head>
</head>
<h1>m2s1xml</h1>
<body>
<h2>Operations</h2>
<%
	String strInputMenu = "../webapps/m2s1xml/pages/menu/menuItems.xml";
	XMLParserMenuItems xmlp = new XMLParserMenuItems();
	HashMap<String, MenuItem> mItems = xmlp.parseDocument(strInputMenu);
	Set<String> keys = mItems.keySet();
%>
<ul>
	<%
		for (String key : keys) {
			String strName = mItems.get(key).getName();
			String strLink = mItems.get(key).getLink();
	%>
	<li><a href="<%=strLink%>"><%=strName%></a></li>
	<%
		}
	%>
</ul>
</body>
</html>