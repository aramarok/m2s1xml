<?xml version="1.0" encoding="utf-8"?>
<xsl:stylesheet version="1.0"
	xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
	xmlns:fo="http://www.w3.org/1999/XSL/Format"
	xmlns:bibtex="http://bibtexml.sf.net/">


	<xsl:param name="PARAM_VALUE" select="ANI" />
	<xsl:param name="PARAM_NAME" select="1974" />


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
					<fo:block text-align="center" font="32pt Times">
						<fo:inline font-weight="bold"
							color="darkblue">
							Bibtex Book List
						</fo:inline>
					</fo:block>
					<fo:block border-top-color="black"
						border-top-style="solid" border-top-width="thick"
						background-color="lightblue">
						<fo:table table-layout="fixed" width="100%">
							<fo:table-column
								column-width="proportional-column-width(1)" />
							<fo:table-column
								column-width="proportional-column-width(1)" />
							<fo:table-column
								column-width="proportional-column-width(1)" />
							<fo:table-column
								column-width="proportional-column-width(1)" />
							<fo:table-column
								column-width="proportional-column-width(1)" />
							<fo:table-body>
								<fo:table-row>
									<fo:table-cell
										display-align="center">
										<fo:block text-align="left">
											<fo:inline
												font-weight="bold" color="black">
												Author
											</fo:inline>
										</fo:block>
									</fo:table-cell>
									<fo:table-cell
										display-align="center">
										<fo:block text-align="left">
											<fo:inline
												font-weight="bold" color="black">
												Title
											</fo:inline>
										</fo:block>
									</fo:table-cell>
									<fo:table-cell
										display-align="center">
										<fo:block text-align="left">
											<fo:inline
												font-weight="bold" color="black">
												Publisher
											</fo:inline>
										</fo:block>
									</fo:table-cell>
									<fo:table-cell
										display-align="center">
										<fo:block text-align="left">
											<fo:inline
												font-weight="bold" color="black">
												Year
											</fo:inline>
										</fo:block>
									</fo:table-cell>
									<fo:table-cell
										display-align="center">
										<fo:block text-align="left">
											<fo:inline
												font-weight="bold" color="black">
												Pages
											</fo:inline>
										</fo:block>
									</fo:table-cell>
								</fo:table-row>
							</fo:table-body>
						</fo:table>
					</fo:block>
					<fo:block border-top-color="black"
						border-top-style="solid" border-top-width="thick"
						background-color="lightgray">
						<fo:inline font-weight="bold"
							color="darkblue">
							<fo:table table-layout="fixed"
								width="100%">
								<fo:table-column
									column-width="proportional-column-width(1)" />
								<fo:table-column
									column-width="proportional-column-width(1)" />
								<fo:table-column
									column-width="proportional-column-width(1)" />
								<fo:table-column
									column-width="proportional-column-width(1)" />
								<fo:table-column
									column-width="proportional-column-width(1)" />
								<fo:table-body>
									<xsl:choose>
										<xsl:when
											test="$PARAM_NAME = 'ANI'">
											<xsl:for-each
												select="bibtex:file/bibtex:entry//*[bibtex:year[text() = $PARAM_VALUE]]">
												<xsl:call-template
													name="create-pdf-row">
													<xsl:with-param
														name="author" select="bibtex:author" />
													<xsl:with-param
														name="title" select="bibtex:title" />
													<xsl:with-param
														name="publisher" select="bibtex:publisher" />
													<xsl:with-param
														name="year" select="bibtex:year" />
													<xsl:with-param
														name="pages" select="bibtex:pages" />
												</xsl:call-template>
											</xsl:for-each>
										</xsl:when>
										<xsl:when
											test="$PARAM_NAME = 'AUTORI'">
											<xsl:for-each
												select="bibtex:file/bibtex:entry//*[bibtex:author[contains(upper-case(text()), upper-case($PARAM_VALUE))]]">
												<xsl:call-template
													name="create-pdf-row">
													<xsl:with-param
														name="author" select="bibtex:author" />
													<xsl:with-param
														name="title" select="bibtex:title" />
													<xsl:with-param
														name="publisher" select="bibtex:publisher" />
													<xsl:with-param
														name="year" select="bibtex:year" />
													<xsl:with-param
														name="pages" select="bibtex:pages" />
												</xsl:call-template>
											</xsl:for-each>
										</xsl:when>
										<xsl:when
											test="$PARAM_NAME = 'KEYWORDS'">
											<xsl:for-each
												select="bibtex:file/bibtex:entry//*[bibtex:keywords[contains(upper-case(text()), upper-case($PARAM_VALUE))]]">
												<xsl:call-template
													name="create-pdf-row">
													<xsl:with-param
														name="author" select="bibtex:author" />
													<xsl:with-param
														name="title" select="bibtex:title" />
													<xsl:with-param
														name="publisher" select="bibtex:publisher" />
													<xsl:with-param
														name="year" select="bibtex:year" />
													<xsl:with-param
														name="pages" select="bibtex:pages" />
												</xsl:call-template>
											</xsl:for-each>
										</xsl:when>
										<xsl:when
											test="$PARAM_NAME = 'PUBLISHER'">
											<xsl:for-each
												select="bibtex:file/bibtex:entry//*[bibtex:publisher[contains(upper-case(text()), upper-case($PARAM_VALUE))]]">
												<xsl:call-template
													name="create-pdf-row">
													<xsl:with-param
														name="author" select="bibtex:author" />
													<xsl:with-param
														name="title" select="bibtex:title" />
													<xsl:with-param
														name="publisher" select="bibtex:publisher" />
													<xsl:with-param
														name="year" select="bibtex:year" />
													<xsl:with-param
														name="pages" select="bibtex:pages" />
												</xsl:call-template>
											</xsl:for-each>
										</xsl:when>
										<xsl:when
											test="$PARAM_NAME = 'EDITOR'">
											<xsl:for-each
												select="bibtex:file/bibtex:entry//*[bibtex:editor[contains(upper-case(text()), upper-case($PARAM_VALUE))]]">
												<xsl:call-template
													name="create-pdf-row">
													<xsl:with-param
														name="author" select="bibtex:author" />
													<xsl:with-param
														name="title" select="bibtex:title" />
													<xsl:with-param
														name="publisher" select="bibtex:publisher" />
													<xsl:with-param
														name="year" select="bibtex:year" />
													<xsl:with-param
														name="pages" select="bibtex:pages" />
												</xsl:call-template>
											</xsl:for-each>
										</xsl:when>
										<xsl:otherwise>
											<xsl:for-each
												select="bibtex:file/bibtex:entry/*">
												<xsl:call-template
													name="create-pdf-row">
													<xsl:with-param
														name="author" select="bibtex:author" />
													<xsl:with-param
														name="title" select="bibtex:title" />
													<xsl:with-param
														name="publisher" select="bibtex:publisher" />
													<xsl:with-param
														name="year" select="bibtex:year" />
													<xsl:with-param
														name="pages" select="bibtex:pages" />
												</xsl:call-template>
											</xsl:for-each>
										</xsl:otherwise>
									</xsl:choose>

									<!-- sa nu crape -->
									<fo:table-row>
			<fo:table-cell display-align="center">
				<fo:block text-align="left">
				</fo:block>
			</fo:table-cell>
		</fo:table-row>
									
									
									
									
								</fo:table-body>
							</fo:table>
						</fo:inline>
					</fo:block>
				</fo:flow>
			</fo:page-sequence>
		</fo:root>
	</xsl:template>

	<xsl:template name="create-pdf-row">
		<xsl:param name="author" select="'N/A'" />
		<xsl:param name="title" select="'N/A'" />
		<xsl:param name="publisher" select="'N/A'" />
		<xsl:param name="year" select="'N/A'" />
		<xsl:param name="pages" select="'N/A'" />

		<fo:table-row>
			<fo:table-cell display-align="center">
				<fo:block text-align="left">
					<xsl:value-of select="$author" />
				</fo:block>
			</fo:table-cell>
			<fo:table-cell display-align="center">
				<fo:block text-align="left">
					<xsl:value-of select="$title" />
				</fo:block>
			</fo:table-cell>
			<fo:table-cell display-align="center">
				<fo:block text-align="left">
					<xsl:value-of select="$publisher" />
				</fo:block>
			</fo:table-cell>
			<fo:table-cell display-align="center">
				<fo:block text-align="left">
					<xsl:value-of select="$year" />
				</fo:block>
			</fo:table-cell>
			<fo:table-cell display-align="center">
				<fo:block text-align="left">
					<xsl:value-of select="$pages" />
				</fo:block>
			</fo:table-cell>
		</fo:table-row>
	</xsl:template>

</xsl:stylesheet>