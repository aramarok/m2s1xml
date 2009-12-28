<?xml version="1.0"?>
<xsl:stylesheet version="1.0"
	xmlns:xsl="http://www.w3.org/1999/XSL/Transform" 
	xmlns:bibtex="http://bibtexml.sf.net/" >

	<xsl:output method="xml" indent="yes" />

	<xsl:param name="removeEntryId" />

	<xsl:variable name="newline">
		<xsl:text>
		</xsl:text>
	</xsl:variable>

	<xsl:template match="node() | @*">
		<xsl:copy>
			<xsl:apply-templates select="node() | @*" />
		</xsl:copy>
	</xsl:template>

	<xsl:template match="bibtex:file">
		<xsl:value-of select="$newline" />
		<xsl:text disable-output-escaping="yes">&lt;bibtex:file&gt;</xsl:text>
		<xsl:value-of select="$newline" />
		<xsl:apply-templates select="//bibtex:entry[compare(attribute(id), $removeEntryId) != 0]" />
		<xsl:value-of select="$newline" />
		<xsl:text disable-output-escaping="yes">&lt;/bibtex:file&gt;</xsl:text>
	</xsl:template>

</xsl:stylesheet>