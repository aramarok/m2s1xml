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
					<service:add>
						<service:bibtexEntryId>EliadeM1969LaTiganci</service:bibtexEntryId>
						<service:bibtexEntryType>book</service:bibtexEntryType>
						<service:bittexEntryDetails>
							<item>
								<key>autor</key>
								<value></value>
							</item>
							<item>
								<key>editor</key>
								<value></value>
							</item>
							<item>
								<key>title</key>
								<value></value>
							</item>
							<item>
								<key>publisher</key>
								<value></value>
							</item>
							<item>
								<key>year</key>
								<value></value>
							</item>
						</service:bittexEntryDetails>
					</service:add>
				</soap-env:Body>
			</soap-env:Envelope>
		</xforms:instance>

		<xforms:instance id="response-bibtex">
			<empty />
		</xforms:instance>

		<xforms:submission id="bibtex_add" method="post"
			action="http://localhost:8080/m2s1xml/services/XMLBibtex"
			ref="instance('request-bibtex')" replace="instance"
			instance="response-bibtex"
			mediatype="application/soap+xml; action=&quot;http://localhost:8080/m2s1xml/services/XMLBibtex&quot;" />

	</xforms:model>

</xhtml:head>

<xhtml:body>
	<jsp:include page="menu/menu.jsp"></jsp:include>
	<h1>Add Bibtext</h1>
	<xhtml:br />

	<xforms:input
		ref="instance('request-bibtex')/soap-env:Body/service:add/service:bibtexEntryId">
		<xforms:label>Id: </xforms:label>
	</xforms:input>

	<xforms:input
		ref="instance('request-bibtex')/soap-env:Body/service:add/service:bibtexEntryType">
		<xforms:label>Type: </xforms:label>
	</xforms:input>

	<xhtml:br />

	<xforms:input
		ref="instance('request-bibtex')/soap-env:Body/service:add/service:bittexEntryDetails/item[1]/value">
		<xforms:label>Author: </xforms:label>
	</xforms:input>

	<xforms:input
		ref="instance('request-bibtex')/soap-env:Body/service:add/service:bittexEntryDetails/item[2]/value">
		<xforms:label>Editor: </xforms:label>
	</xforms:input>

	<xforms:input
		ref="instance('request-bibtex')/soap-env:Body/service:add/service:bittexEntryDetails/item[3]/value">
		<xforms:label>Title: </xforms:label>
	</xforms:input>

	<xforms:input
		ref="instance('request-bibtex')/soap-env:Body/service:add/service:bittexEntryDetails/item[4]/value">
		<xforms:label>Publisher: </xforms:label>
	</xforms:input>

	<xforms:input
		ref="instance('request-bibtex')/soap-env:Body/service:add/service:bittexEntryDetails/item[5]/value">
		<xforms:label>Year: </xforms:label>
	</xforms:input>

	<xforms:trigger>
		<xforms:label>Add</xforms:label>
		<xforms:send submission="bibtex_add" ev:event="DOMActivate" />
	</xforms:trigger>

	<xhtml:br />
	<xhtml:br />
	<xhtml:hr />
	<p>TODO: Nu merge, trebuie construit si trimis un hasmap la soap
	body ...</p>
	<xforms:group ref="instance('response-bibtex')/soap-env:Body">
		<xforms:output value="service:addResponse" mediatype="text/html" />
	</xforms:group>

</xhtml:body>
</xhtml:html>
