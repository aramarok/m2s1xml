<?xml version="1.0"?>
<xsl:stylesheet version="1.0"
	xmlns:xsl="http://www.w3.org/1999/XSL/Transform">

	<xsl:output method="xml" indent="yes" />

	<xsl:param name="rmvid" />

	<xsl:variable name="newline">
		<xsl:text>
</xsl:text>
	</xsl:variable>

	<xsl:template match="node() | @*">
		<xsl:copy>
			<xsl:apply-templates select="node() | @*" />
		</xsl:copy>
	</xsl:template>

	<xsl:template match="myagenda">
		<xsl:value-of select="$newline" />
		<xsl:text disable-output-escaping="yes">&lt;myagenda&gt;</xsl:text>
		<xsl:value-of select="$newline" />
		<xsl:apply-templates select="//contact[compare(attribute(id), $rmvid) != 0]" />
		<xsl:value-of select="$newline" />
		<xsl:text disable-output-escaping="yes">&lt;/myagenda&gt;</xsl:text>
	</xsl:template>

</xsl:stylesheet>