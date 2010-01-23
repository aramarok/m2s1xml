<?xml version="1.0" encoding="windows-1252"?>

<xhtml:html xmlns:xforms="http://www.w3.org/2002/xforms"
	xmlns:xhtml="http://www.w3.org/1999/xhtml"
	xmlns:ev="http://www.w3.org/2001/xml-events"
	xmlns:soap-env="http://schemas.xmlsoap.org/soap/envelope/"
	xmlns:service="http://www.webservicex.net">

<xhtml:head>
	<xhtml:title>Bibtex</xhtml:title>
	<xforms:model>
		<xforms:instance id="request-bibtex">
			<soap-env:Envelope>
				<soap-env:Body>
					<service:search>
						<service:searchBy>ANI</service:searchBy>
						<service:value>1974</service:value>
					</service:search>
				</soap-env:Body>
			</soap-env:Envelope>
		</xforms:instance>

		<xforms:instance id="response-bibtex">
			<empty />
		</xforms:instance>

		<xforms:submission id="bibtex_search" method="post"
			action="http://localhost:8080/m2s1xml/services/XMLBibtex"
			ref="instance('request-bibtex')" replace="instance"
			instance="response-bibtex"
			mediatype="application/soap+xml; action=&quot;http://localhost:8080/m2s1xml/services/XMLBibtex&quot;" />

	</xforms:model>

</xhtml:head>

<xhtml:body>
	<jsp:include page="menu/menu.jsp"></jsp:include>
	<h1>Search Bibtext</h1>
	<xhtml:br />

	<xforms:input
		ref="instance('request-bibtex')/soap-env:Body/service:search/service:searchBy">
		<xforms:label>Criteria: </xforms:label>
	</xforms:input>
	<xforms:input
		ref="instance('request-bibtex')/soap-env:Body/service:search/service:value">
		<xforms:label>Parameter: </xforms:label>
	</xforms:input>

	<xforms:trigger>
		<xforms:label>Search</xforms:label>
		<xforms:send submission="bibtex_search" ev:event="DOMActivate" />
	</xforms:trigger>

	<xhtml:br />
	<xhtml:br />
	<xhtml:hr />

	<xforms:group ref="instance('response-bibtex')/soap-env:Body">
		<xforms:output value="service:searchResponse" mediatype="text/html" />
	</xforms:group>

</xhtml:body>
</xhtml:html>
