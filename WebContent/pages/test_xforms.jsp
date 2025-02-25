<!--
    Copyright (C) 2006-2007 Orbeon, Inc.

    This program is free software; you can redistribute it and/or modify it under the terms of the
    GNU Lesser General Public License as published by the Free Software Foundation; either version
    2.1 of the License, or (at your option) any later version.

    This program is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY;
    without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.
    See the GNU Lesser General Public License for more details.

    The full text of the license is available at http://www.gnu.org/copyleft/lesser.html
-->
<xhtml:html xmlns:xforms="http://www.w3.org/2002/xforms"
    xmlns:f="http://orbeon.org/oxf/xml/formatting"
    xmlns:xhtml="http://www.w3.org/1999/xhtml"
    xmlns:xxforms="http://orbeon.org/oxf/xml/xforms"
    xmlns:widget="http://orbeon.org/oxf/xml/widget"
    xmlns:ev="http://www.w3.org/2001/xml-events"
    xmlns:xs="http://www.w3.org/2001/XMLSchema">

    <xhtml:head>
        <xhtml:title>Tree Widget</xhtml:title>
        <xhtml:style type="text/css">
            table td, table th { vertical-align: top }
            .xforms-label { font-weight: bold; padding-right: 1em }
        </xhtml:style>
        <xforms:model>
            <xforms:instance id="main-instance">
                <instance>
                    <data-set>encyclopedia-instance</data-set>
                    <select1>ar1</select1>
                    <select>"en1" cu1 cr1 sc2</select>
                </instance>
            </xforms:instance>
            <xforms:instance id="encyclopedia-instance">
                <items>
                    <item label="Cool Encyclopedia " value="en1">
                        <item label="Science" value="sc1"/>
                        <item label="Culture" value="cu1">
                            <item label="Art" value="ar1"/>
                            <item label="Craft" value="cr1"/>
                        </item>
                    </item>
                    <item label="Encyclopedia" value="en2">
                        <item label="Science" value="sc2"/>
                        <item label="Culture" value="cu2">
                            <item label="Art" value="ar2"/>
                            <item label="Craft" value="cr2"/>
                        </item>
                    </item>
                </items>
            </xforms:instance>
            <xforms:instance id="books-instance">
                <items>
                    <item label="Lois McMaster Bujold" value="bujold">
                        <item label="Cordelia's Honor" value="bujold-1"/>
                        <item label="The Warrior's Apprentice" value="bujold-2"/>
                        <item label="The Vor Game" value="bujold-3"/>
                        <item label="Young Miles" value="bujold-4"/>
                        <item label="Cetaganda" value="bujold-5"/>
                        <item label="Borders of Infinity" value="bujold-6"/>
                        <item label="Brothers in Arms" value="bujold-7"/>
                        <item label="Mirror Dance" value="bujold-8"/>
                        <item label="Memory" value="bujold-9"/>
                        <item label="Komarr" value="bujold-10"/>
                        <item label="A Civil Campaign" value="bujold-11"/>
                        <item label="Falling Free" value="bujold-12"/>
                        <item label="Ethan of Athos" value="bujold-13"/>
                        <item label="The Spirit Ring" value="bujold-14"/>
                    </item>
                    <item label="Carl Sagan" value="sagan">
                        <item label="Broca's Brain" value="sagan-1"/>
                        <item label="Cosmos" value="sagan-2"/>
                        <item label="The Dragons of Eden" value="sagan-3"/>
                        <item label="Murmurs of Earth" value="sagan-4"/>
                        <item label="Shadows of Forgotten Ancestors" value="sagan-5"/>
                    </item>
                </items>
            </xforms:instance>
        </xforms:model>
    </xhtml:head>
    <xhtml:body>
        <xforms:select1 ref="data-set">
            <xforms:label>Data Set:</xforms:label>
            <xforms:item>
                <xforms:label>Encyclopedia</xforms:label>
                <xforms:value>encyclopedia-instance</xforms:value>
            </xforms:item>
            <xforms:item>
                <xforms:label>Books</xforms:label>
                <xforms:value>books-instance</xforms:value>
            </xforms:item>
        </xforms:select1>

        <xhtml:table style="width: 100%">
            <xhtml:tr>
                <xhtml:th/>
                <xhtml:th>Incremental</xhtml:th>
                <xhtml:th>Non-Incremental</xhtml:th>
            </xhtml:tr>
            <xhtml:tr>
                <xhtml:th rowspan="2">Single Selection </xhtml:th>
                <xhtml:td colspan="2">
                    <xforms:output ref="select1">
                        <xforms:label>Selected values:</xforms:label>
                    </xforms:output>
                </xhtml:td>
            </xhtml:tr>
            <xhtml:tr>
                <xhtml:td>
                    <xforms:select1 ref="select1" appearance="xxforms:tree" id="tree1" incremental="true">
                        <xforms:itemset nodeset="instance(instance('main-instance')/data-set)//item">
                            <xforms:label ref="@label"/>
                            <xforms:value ref="@value"/>
                        </xforms:itemset>
                    </xforms:select1>
                </xhtml:td>
                <xhtml:td>
                    <xforms:select1 ref="select1" appearance="xxforms:tree" id="tree2" incremental="false">
                        <xforms:itemset nodeset="instance(instance('main-instance')/data-set)//item">
                            <xforms:label ref="@label"/>
                            <xforms:value ref="@value"/>
                        </xforms:itemset>
                    </xforms:select1>
                </xhtml:td>
            </xhtml:tr>
            <xhtml:tr>
                <xhtml:th rowspan="2">Multiple Selection </xhtml:th>
                <xhtml:td colspan="2">
                    <xforms:output ref="select">
                        <xforms:label>Selected values:</xforms:label>
                    </xforms:output>
                </xhtml:td>
            </xhtml:tr>
            <xhtml:tr>
                <xhtml:td>
                    <xforms:select ref="select" appearance="xxforms:tree" id="tree3" incremental="true">
                        <xforms:itemset nodeset="instance(instance('main-instance')/data-set)//item">
                            <xforms:label ref="@label"/>
                            <xforms:value ref="@value"/>
                        </xforms:itemset>
                    </xforms:select>
                </xhtml:td>
                <xhtml:td>
                    <xforms:select ref="select" appearance="xxforms:tree" id="tree4" incremental="false">
                        <xforms:itemset nodeset="instance(instance('main-instance')/data-set)//item">
                            <xforms:label ref="@label"/>
                            <xforms:value ref="@value"/>
                        </xforms:itemset>
                    </xforms:select>
                </xhtml:td>
            </xhtml:tr>
            <xhtml:tr>
                <xhtml:th rowspan="2">Multiple Selection <xhtml:br/>(No Itemset)</xhtml:th>
                <xhtml:td colspan="2">
                    <xforms:output ref="select">
                        <xforms:label>Selected values:</xforms:label>
                    </xforms:output>
                </xhtml:td>
            </xhtml:tr>
            <xhtml:tr>
                <xhtml:td>
                    <xforms:select ref="select" appearance="xxforms:tree" id="tree5" incremental="true">
                        <xforms:choices>
                            <xforms:label>Encyclopedia</xforms:label>
                            <xforms:item>
                                <xforms:label>Science</xforms:label>
                                <xforms:value>sc1</xforms:value>
                            </xforms:item>
                            <xforms:choices>
                                <xforms:label>Culture</xforms:label>
                                <xforms:item>
                                    <xforms:label>Art</xforms:label>
                                    <xforms:value>ar1</xforms:value>
                                </xforms:item>
                                <xforms:item>
                                    <xforms:label>Craft</xforms:label>
                                    <xforms:value>cr1</xforms:value>
                                </xforms:item>
                            </xforms:choices>
                        </xforms:choices>
                        <xforms:choices>
                            <xforms:label>Encyclopedia</xforms:label>
                            <xforms:item>
                                <xforms:label>Science</xforms:label>
                                <xforms:value>sc2</xforms:value>
                            </xforms:item>
                            <xforms:choices>
                                <xforms:label>Culture</xforms:label>
                                <xforms:item>
                                    <xforms:label>Art</xforms:label>
                                    <xforms:value>ar2</xforms:value>
                                </xforms:item>
                                <xforms:item>
                                    <xforms:label>Craft</xforms:label>
                                    <xforms:value>cr2</xforms:value>
                                </xforms:item>
                            </xforms:choices>
                        </xforms:choices>
                    </xforms:select>
                </xhtml:td>
                <xhtml:td>
                    <xforms:select ref="select" appearance="xxforms:tree" id="tree6" incremental="false">
                        <xforms:choices>
                            <xforms:label>Encyclopedia</xforms:label>
                            <xforms:item>
                                <xforms:label>Science</xforms:label>
                                <xforms:value>sc1</xforms:value>
                            </xforms:item>
                            <xforms:choices>
                                <xforms:label>Culture</xforms:label>
                                <xforms:item>
                                    <xforms:label>Art</xforms:label>
                                    <xforms:value>ar1</xforms:value>
                                </xforms:item>
                                <xforms:item>
                                    <xforms:label>Craft</xforms:label>
                                    <xforms:value>cr1</xforms:value>
                                </xforms:item>
                            </xforms:choices>
                        </xforms:choices>
                        <xforms:choices>
                            <xforms:label>Encyclopedia</xforms:label>
                            <xforms:item>
                                <xforms:label>Science</xforms:label>
                                <xforms:value>sc2</xforms:value>
                            </xforms:item>
                            <xforms:choices>
                                <xforms:label>Culture</xforms:label>
                                <xforms:item>
                                    <xforms:label>Art</xforms:label>
                                    <xforms:value>ar2</xforms:value>
                                </xforms:item>
                                <xforms:item>
                                    <xforms:label>Craft</xforms:label>
                                    <xforms:value>cr2</xforms:value>
                                </xforms:item>
                            </xforms:choices>
                        </xforms:choices>
                    </xforms:select>
                </xhtml:td>
            </xhtml:tr>
        </xhtml:table>

    </xhtml:body>
</xhtml:html>