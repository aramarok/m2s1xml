<xsl:stylesheet version="1.0"
	xmlns:xsl="http://www.w3.org/1999/XSL/Transform" xmlns:bibtex="http://bibtexml.sf.net/">

	<xsl:output omit-xml-declaration="yes" />
	<xsl:output method="xml" indent="yes" />

	<xsl:param name="removeEntryId" />
	<xsl:template match="node()|@*">
		<xsl:copy>
			<xsl:apply-templates select="node()|@*" />
		</xsl:copy>
	</xsl:template>

	<xsl:template
		match="//bibtex:entry[compare(attribute(id), $removeEntryId)=0]" />

</xsl:stylesheet>