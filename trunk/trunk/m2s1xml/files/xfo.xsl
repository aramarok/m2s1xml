<?xml version="1.0" encoding="utf-8"?>
<xsl:stylesheet version="1.0"
	xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
	xmlns:fo="http://www.w3.org/1999/XSL/Format">
	<xsl:template match="/">

		<fo:root xmlns:fo="http://www.w3.org/1999/XSL/Format">
			<fo:layout-master-set>
				<fo:simple-page-master master-name="A4"
					page-width="297mm" page-height="210mm" margin-top="1cm"
					margin-bottom="1cm" margin-left="1cm" margin-right="1cm">
					<fo:region-body margin="3cm" />
					<fo:region-before extent="2cm" />
					<fo:region-after extent="2cm" />
					<fo:region-start extent="2cm" />
					<fo:region-end extent="2cm" />
				</fo:simple-page-master>
			</fo:layout-master-set>

			<fo:page-sequence master-reference="A4" format="A">
				<fo:flow flow-name="xsl-region-body">
					<fo:block>
						<fo:inline font-weight="bold">
							<fo:table table-layout="fixed" width="100%">
								<fo:table-column column-width="proportional-column-width(1)"/>
								<fo:table-column column-width="proportional-column-width(1)"/>
								<fo:table-body>
									<xsl:for-each select="//contact">
										<fo:table-row>
										<fo:table-cell display-align="center">
										  <fo:block text-align="left">
											<xsl:value-of select="name" />
										  </fo:block>
										</fo:table-cell>
										<fo:table-cell display-align="center">
										  <fo:block text-align="left">
											<xsl:value-of select="phone" />
										  </fo:block>
										</fo:table-cell>
									  </fo:table-row>
									</xsl:for-each>
								</fo:table-body>
							</fo:table>
						</fo:inline>
					</fo:block>
				</fo:flow>
			</fo:page-sequence>
		</fo:root>
	</xsl:template>
</xsl:stylesheet>