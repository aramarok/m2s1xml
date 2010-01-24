<?xml version="1.0" encoding="windows-1252"?>

<xhtml:html xmlns:xforms="http://www.w3.org/2002/xforms"
	xmlns:xhtml="http://www.w3.org/1999/xhtml"
	xmlns:ev="http://www.w3.org/2001/xml-events"
	xmlns:soap-env="http://schemas.xmlsoap.org/soap/envelope/"
	xmlns:service="http://www.webservicex.net">

<xhtml:head>
	<xhtml:title>Bibtex</xhtml:title>
	<xforms:model>
		<xforms:instance id="request-bibtex-book">
			<soap-env:Envelope>
				<soap-env:Body>
					<service:add>
						<service:bibtexEntryId>BookId</service:bibtexEntryId>
						<service:bibtexEntryType>book</service:bibtexEntryType>
						<service:bittexEntryDetails>
							<item> <key>author</key> <value>author</value> </item>
							<item> <key>editor</key> <value>editor</value> </item>
							<item> <key>title</key> <value>title</value> </item>
							<item> <key>publisher</key> <value>publisher</value> </item>
							<item> <key>year</key> <value>0</value> </item>
							<item> <key>volume</key> <value>volume</value> </item>
							<item> <key>pages</key> <value>0</value> </item>
							<item> <key>edition</key> <value>edition</value> </item>
						</service:bittexEntryDetails>
					</service:add>
				</soap-env:Body>
			</soap-env:Envelope>
		</xforms:instance>

		<xforms:instance id="response-bibtex-book">
			<empty />
		</xforms:instance>

		<xforms:instance id="request-bibtex-article">
			<soap-env:Envelope>
				<soap-env:Body>
					<service:add>
						<service:bibtexEntryId>ArticleID</service:bibtexEntryId>
						<service:bibtexEntryType>article</service:bibtexEntryType>
						<service:bittexEntryDetails>
							<item> <key>author</key> <value>author</value> </item>
							<item> <key>title</key> <value>title</value> </item>
							<item> <key>journal</key> <value>journal</value> </item>
							<item> <key>year</key> <value>year</value> </item>
							<item> <key>volume</key> <value>volume</value> </item>
							<item> <key>pages</key> <value>pages</value> </item>
						</service:bittexEntryDetails>
					</service:add>
				</soap-env:Body>
			</soap-env:Envelope>
		</xforms:instance>

		<xforms:instance id="response-bibtex-article">
			<empty />
		</xforms:instance>

		<xforms:instance id="request-bibtex-conference">
			<soap-env:Envelope>
				<soap-env:Body>
					<service:add>
						<service:bibtexEntryId>ConferenceID</service:bibtexEntryId>
						<service:bibtexEntryType>conference</service:bibtexEntryType>
						<service:bittexEntryDetails>
							<item> <key>author</key> <value>author</value> </item>
							<item> <key>title</key> <value>title</value> </item>
							<item> <key>booktitle</key> <value>booktitle</value> </item>
							<item> <key>year</key> <value>year</value> </item>
							<item> <key>editor</key> <value>editor</value> </item>
							<item> <key>publisher</key> <value>publisher</value> </item>
							<item> <key>pages</key> <value>0</value> </item>
							<item> <key>organization</key> <value>organization</value> </item>
						</service:bittexEntryDetails>
					</service:add>
				</soap-env:Body>
			</soap-env:Envelope>
		</xforms:instance>

		<xforms:instance id="response-bibtex-conference">
			<empty />
		</xforms:instance>

		<xforms:submission id="bibtex_add_book" method="post"
			action="http://localhost:8080/m2s1xml/services/XMLBibtex"
			ref="instance('request-bibtex-book')" replace="instance"
			instance="response-bibtex-book"
			mediatype="application/soap+xml; action=&quot;http://localhost:8080/m2s1xml/services/XMLBibtex&quot;" />

		<xforms:submission id="bibtex_add_article" method="post"
			action="http://localhost:8080/m2s1xml/services/XMLBibtex"
			ref="instance('request-bibtex-article')" replace="instance"
			instance="response-bibtex-article"
			mediatype="application/soap+xml; action=&quot;http://localhost:8080/m2s1xml/services/XMLBibtex&quot;" />

		<xforms:submission id="bibtex_add_conference" method="post"
			action="http://localhost:8080/m2s1xml/services/XMLBibtex"
			ref="instance('request-bibtex-article')" replace="instance"
			instance="response-bibtex-conference"
			mediatype="application/soap+xml; action=&quot;http://localhost:8080/m2s1xml/services/XMLBibtex&quot;" />

	</xforms:model>

</xhtml:head>

<xhtml:body>
	<jsp:include page="menu/menu.jsp"></jsp:include>
	<xhtml:h1>Add Bibtex Entry</xhtml:h1>
	<xhtml:br />
	<xforms:group>
		<xforms:trigger>
			<xforms:label>Book</xforms:label>
			<xforms:toggle case="book" ev:event="DOMActivate" />
		</xforms:trigger>
		<xforms:trigger>
			<xforms:label>Article</xforms:label>
			<xforms:toggle case="article" ev:event="DOMActivate" />
		</xforms:trigger>
		<xforms:trigger>
			<xforms:label>Conference</xforms:label>
			<xforms:toggle case="conference" ev:event="DOMActivate" />
		</xforms:trigger>
	</xforms:group>
	<xhtml:br />
	<xhtml:br />
	<xforms:switch>
		<xforms:case id="book">
			<xforms:group>
				<xforms:input
					ref="instance('request-bibtex-book')/soap-env:Body/service:add/service:bibtexEntryId">
					<xforms:label>Id: </xforms:label>
				</xforms:input>
				<xhtml:br />
				<xforms:input
					ref="instance('request-bibtex-book')/soap-env:Body/service:add/service:bittexEntryDetails/item[1]/value">
					<xforms:label>Author: </xforms:label>
				</xforms:input>
				<xhtml:br />
				<xforms:input
					ref="instance('request-bibtex-book')/soap-env:Body/service:add/service:bittexEntryDetails/item[2]/value">
					<xforms:label>Editor: </xforms:label>
				</xforms:input>
				<xhtml:br />
				<xforms:input
					ref="instance('request-bibtex-book')/soap-env:Body/service:add/service:bittexEntryDetails/item[3]/value">
					<xforms:label>Title: </xforms:label>
				</xforms:input>
				<xhtml:br />
				<xforms:input
					ref="instance('request-bibtex-book')/soap-env:Body/service:add/service:bittexEntryDetails/item[4]/value">
					<xforms:label>Publisher: </xforms:label>
				</xforms:input>
				<xhtml:br />
				<xforms:input
					ref="instance('request-bibtex-book')/soap-env:Body/service:add/service:bittexEntryDetails/item[5]/value">
					<xforms:label>Year: </xforms:label>
				</xforms:input>
				<xhtml:br />
				<xforms:input
					ref="instance('request-bibtex-book')/soap-env:Body/service:add/service:bittexEntryDetails/item[6]/value">
					<xforms:label>Volume: </xforms:label>
				</xforms:input>
				<xhtml:br />
				<xforms:input
					ref="instance('request-bibtex-book')/soap-env:Body/service:add/service:bittexEntryDetails/item[7]/value">
					<xforms:label>Pages: </xforms:label>
				</xforms:input>
				<xhtml:br />
				<xforms:input
					ref="instance('request-bibtex-book')/soap-env:Body/service:add/service:bittexEntryDetails/item[8]/value">
					<xforms:label>Edition: </xforms:label>
				</xforms:input>
				<xhtml:br />
				<xhtml:br />
				<xforms:trigger>
					<xforms:label>Add Book</xforms:label>
					<xforms:send submission="bibtex_add_book" ev:event="DOMActivate" />
				</xforms:trigger>
			</xforms:group>
			<xhtml:br />
			<xhtml:br />
			<xhtml:hr />
			Result: 
			<xforms:group ref="instance('response-bibtex-book')/soap-env:Body">
				<xforms:output value="service:addResponse" mediatype="text/html" />
			</xforms:group>
		</xforms:case>
		<xforms:case id="article">
			<xforms:group>
				<xforms:input
					ref="instance('request-bibtex-article')/soap-env:Body/service:add/service:bibtexEntryId">
					<xforms:label>Id: </xforms:label>
				</xforms:input>
				<xhtml:br />
				<xforms:input
					ref="instance('request-bibtex-article')/soap-env:Body/service:add/service:bittexEntryDetails/item[1]/value">
					<xforms:label>Author: </xforms:label>
				</xforms:input>
				<xhtml:br />
				<xforms:input
					ref="instance('request-bibtex-article')/soap-env:Body/service:add/service:bittexEntryDetails/item[2]/value">
					<xforms:label>Title: </xforms:label>
				</xforms:input>
				<xhtml:br />
				<xforms:input
					ref="instance('request-bibtex-article')/soap-env:Body/service:add/service:bittexEntryDetails/item[3]/value">
					<xforms:label>Journal: </xforms:label>
				</xforms:input>
				<xhtml:br />
				<xforms:input
					ref="instance('request-bibtex-article')/soap-env:Body/service:add/service:bittexEntryDetails/item[4]/value">
					<xforms:label>Year: </xforms:label>
				</xforms:input>
				<xhtml:br />
				<xforms:input
					ref="instance('request-bibtex-article')/soap-env:Body/service:add/service:bittexEntryDetails/item[5]/value">
					<xforms:label>Volume: </xforms:label>
				</xforms:input>
				<xhtml:br />
				<xforms:input
					ref="instance('request-bibtex-article')/soap-env:Body/service:add/service:bittexEntryDetails/item[6]/value">
					<xforms:label>Pages: </xforms:label>
				</xforms:input>
				<xhtml:br />
				<xhtml:br />
				<xforms:trigger>
					<xforms:label>Add Article</xforms:label>
					<xforms:send submission="bibtex_add_article" ev:event="DOMActivate" />
				</xforms:trigger>
			</xforms:group>
			<xhtml:br />
			<xhtml:br />
			<xhtml:hr />
			Result: 
			<xforms:group ref="instance('response-bibtex-article')/soap-env:Body">
				<xforms:output value="service:addResponse" mediatype="text/html" />
			</xforms:group>
		</xforms:case>
		<xforms:case id="conference">
			<xforms:group>
				<xforms:input
					ref="instance('request-bibtex-conference')/soap-env:Body/service:add/service:bibtexEntryId">
					<xforms:label>Id: </xforms:label>
				</xforms:input>
				<xhtml:br />
				<xforms:input
					ref="instance('request-bibtex-conference')/soap-env:Body/service:add/service:bittexEntryDetails/item[1]/value">
					<xforms:label>Author: </xforms:label>
				</xforms:input>
				<xhtml:br />
				<xforms:input
					ref="instance('request-bibtex-conference')/soap-env:Body/service:add/service:bittexEntryDetails/item[2]/value">
					<xforms:label>Title: </xforms:label>
				</xforms:input>
				<xhtml:br />
				<xforms:input
					ref="instance('request-bibtex-conference')/soap-env:Body/service:add/service:bittexEntryDetails/item[3]/value">
					<xforms:label>Booktitile: </xforms:label>
				</xforms:input>
				<xhtml:br />
				<xforms:input
					ref="instance('request-bibtex-conference')/soap-env:Body/service:add/service:bittexEntryDetails/item[4]/value">
					<xforms:label>Year: </xforms:label>
				</xforms:input>
				<xhtml:br />
				<xforms:input
					ref="instance('request-bibtex-conference')/soap-env:Body/service:add/service:bittexEntryDetails/item[5]/value">
					<xforms:label>Editor: </xforms:label>
				</xforms:input>
				<xhtml:br />
				<xforms:input
					ref="instance('request-bibtex-conference')/soap-env:Body/service:add/service:bittexEntryDetails/item[6]/value">
					<xforms:label>Publisher: </xforms:label>
				</xforms:input>
				<xhtml:br />
				<xforms:input
					ref="instance('request-bibtex-conference')/soap-env:Body/service:add/service:bittexEntryDetails/item[7]/value">
					<xforms:label>Pages: </xforms:label>
				</xforms:input>
				<xhtml:br />
				<xforms:input
					ref="instance('request-bibtex-conference')/soap-env:Body/service:add/service:bittexEntryDetails/item[8]/value">
					<xforms:label>Organization: </xforms:label>
				</xforms:input>
				<xhtml:br />
				<xhtml:br />
				<xforms:trigger>
					<xforms:label>Add Conference</xforms:label>
					<xforms:send submission="bibtex_add_conference"
						ev:event="DOMActivate" />
				</xforms:trigger>
			</xforms:group>
			<xhtml:br />
			<xhtml:br />
			<xhtml:hr />
			Result: 
			<xforms:group
				ref="instance('response-bibtex-conference')/soap-env:Body">
				<xforms:output value="service:addResponse" mediatype="text/html" />
			</xforms:group>
		</xforms:case>
	</xforms:switch>
</xhtml:body>
</xhtml:html>
