<?xml version="1.0"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">

	<xsl:output method="xml" indent="yes" />

	<xsl:param name="newname" />
	<xsl:param name="newphone" />

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
		<xsl:value-of select="$newline"/>
		<xsl:text disable-output-escaping="yes">&lt;myagenda&gt;</xsl:text>
		<xsl:value-of select="$newline"/>
		<xsl:apply-templates select="contact" />
		<xsl:if test="string-length($newname) > 0">
			<xsl:element name="contact">
				<xsl:attribute name="id">
					<xsl:value-of select="$newname" />
				</xsl:attribute>
				<xsl:element name="name">
					<xsl:value-of select="$newname" />
				</xsl:element>
				<xsl:element name="phone">
					<xsl:value-of select="$newphone" />
				</xsl:element>
			</xsl:element>
		</xsl:if>
		<xsl:value-of select="$newline"/>
		<xsl:text disable-output-escaping="yes">&lt;/myagenda&gt;</xsl:text>
	</xsl:template>

</xsl:stylesheet>