<?xml version="1.0" encoding="ISO-8859-1"?>
<!-- Edited by XMLSpy® -->
<xsl:stylesheet version="1.0"
	xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
	xmlns:bibtex="http://bibtexml.sf.net/">

	<xsl:param name="PARAM_VALUE" select="2007" />
	<xsl:param name="PARAM_NAME" select="by" />

	<xsl:template match="/">
		<html>
			<body>
				<h2>Results</h2>
				<h4>
					<a href="../files/bibtex/bibtex.pdf">[download]</a>
				</h4>
				<table border="1">
					<tr bgcolor="#9acd32">
						<th>Author</th>
						<th>Title</th>
					</tr>
					<xsl:choose>
						<xsl:when test="$PARAM_NAME = 'ANI'">
							<xsl:for-each
								select="bibtex:file/bibtex:entry//*[bibtex:year[text() = $PARAM_VALUE]]">
								<xsl:call-template
									name="createoutput">
									<xsl:with-param name="author"
										select="bibtex:author" />
									<xsl:with-param name="title"
										select="bibtex:title" />
								</xsl:call-template>
							</xsl:for-each>
						</xsl:when>
						<xsl:when test="$PARAM_NAME = 'AUTORI'">
							<xsl:for-each
								select="bibtex:file/bibtex:entry//*[bibtex:author[contains(upper-case(text()), upper-case($PARAM_VALUE))]]">
								<xsl:call-template
									name="createoutput">
									<xsl:with-param name="author"
										select="bibtex:author" />
									<xsl:with-param name="title"
										select="bibtex:title" />
								</xsl:call-template>
							</xsl:for-each>
						</xsl:when>
						<xsl:when test="$PARAM_NAME = 'KEYWORDS'">
							<xsl:for-each
								select="bibtex:file/bibtex:entry//*[bibtex:keywords[contains(upper-case(text()), upper-case($PARAM_VALUE))]]">
								<xsl:call-template
									name="createoutput">
									<xsl:with-param name="author"
										select="bibtex:author" />
									<xsl:with-param name="title"
										select="bibtex:title" />
								</xsl:call-template>
							</xsl:for-each>
						</xsl:when>
						<xsl:when test="$PARAM_NAME = 'PUBLISHER'">
							<xsl:for-each
								select="bibtex:file/bibtex:entry//*[bibtex:publisher[contains(upper-case(text()), upper-case($PARAM_VALUE))]]">
								<xsl:call-template
									name="createoutput">
									<xsl:with-param name="author"
										select="bibtex:author" />
									<xsl:with-param name="title"
										select="bibtex:title" />
								</xsl:call-template>
							</xsl:for-each>
						</xsl:when>
						<xsl:when test="$PARAM_NAME = 'EDITOR'">
							<xsl:for-each
								select="bibtex:file/bibtex:entry//*[bibtex:editor[contains(upper-case(text()), upper-case($PARAM_VALUE))]]">
								<xsl:call-template
									name="createoutput">
									<xsl:with-param name="author"
										select="bibtex:author" />
									<xsl:with-param name="title"
										select="bibtex:title" />
								</xsl:call-template>
							</xsl:for-each>
						</xsl:when>
						<xsl:otherwise>
							<xsl:for-each
								select="bibtex:file/bibtex:entry/*">
								<xsl:call-template
									name="createoutput">
									<xsl:with-param name="author"
										select="bibtex:author" />
									<xsl:with-param name="title"
										select="bibtex:title" />
								</xsl:call-template>
							</xsl:for-each>
						</xsl:otherwise>
					</xsl:choose>
				</table>
			</body>
		</html>
	</xsl:template>

	<xsl:template name="createoutput">
		<xsl:param name="author" select="'N/A'" />
		<xsl:param name="title" select="'N/A'" />
		<tr>
			<td>
				<xsl:value-of select="$author" />
			</td>
			<td>
				<xsl:value-of select="$title" />
			</td>
		</tr>
	</xsl:template>

</xsl:stylesheet>