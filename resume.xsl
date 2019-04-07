<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
	xmlns:fo="http://www.w3.org/1999/XSL/Format" xmlns:fox="http://xmlgraphics.apache.org/fop/extensions"
	xmlns:svg="http://www.w3.org/2000/svg" xmlns:xalan="http://xml.apache.org/xalan" xmlns:lc="lc" xmlns:dt="dt">

	<xsl:output method="xml" indent="yes" encoding="UTF-8"></xsl:output>
	
	<!-- main colors -->
	<xsl:param name="dark-color">#001f3f</xsl:param>
	<xsl:param name="light-color">#e3f2fd</xsl:param>
	
	<!-- parameter for photo URL or file -->
	<xsl:param name="photo.url" select="''" />	
	
	<!-- localizable texts used in this template -->
	<!-- see (or create) src/main/resources/messages-*.properties for localizations -->
	<xsl:param name="text.contact">CONTACT</xsl:param>
	<xsl:param name="text.getintouch">GET IN TOUCH</xsl:param>
	<xsl:param name="text.workhistory">WORK HISTORY</xsl:param>
	<xsl:param name="text.education">EDUCATION</xsl:param>
	<xsl:param name="text.skills">SKILLS</xsl:param>
	<xsl:param name="text.certificates">CERTIFICATES</xsl:param>
	<xsl:param name="text.today">present</xsl:param>
	<xsl:param name="text.monthYearSeparator" select="', '" />
	

	<xsl:template match="resume">
		<fo:root>
			<fo:layout-master-set>
				<fo:simple-page-master master-name="first-page" page-width="210mm" page-height="297mm">
					<fo:region-body region-name="xsl-region-body" margin-left="60mm" margin-right="10mm" margin-top="8mm" />
					<fo:region-start region-name="first-left-column" extent="50mm" background-color="{$dark-color}" />
				</fo:simple-page-master>
				<fo:simple-page-master master-name="default-page" page-width="210mm" page-height="297mm">
					<fo:region-body region-name="xsl-region-body" margin-left="60mm" margin-right="10mm" margin-top="10mm" />
					<fo:region-start region-name="left-column" extent="50mm" background-color="{$dark-color}" />
				</fo:simple-page-master>

				<fo:page-sequence-master master-name="all-pages">
					<fo:repeatable-page-master-alternatives>
						<fo:conditional-page-master-reference page-position="rest"
							master-reference="default-page" />
						<fo:conditional-page-master-reference page-position="first"
							master-reference="first-page" />
					</fo:repeatable-page-master-alternatives>
				</fo:page-sequence-master>
			</fo:layout-master-set>

			<fo:page-sequence master-reference="all-pages">
				<fo:static-content flow-name="first-left-column" font-family="Lato">
					<xsl:call-template name="basic-infos" />
				</fo:static-content>
				<fo:flow flow-name="xsl-region-body" font-family="Lato" font-size="9pt">
					<xsl:apply-templates select="basics" />
					<xsl:apply-templates select="workhistory" />
					<xsl:apply-templates select="educations" />
					<xsl:apply-templates select="skills" />
					<xsl:apply-templates select="certificates" />
				</fo:flow>
			</fo:page-sequence>
		</fo:root>
	</xsl:template>

	<!-- content for the left column on the first page -->
	<xsl:template name="basic-infos">
		<fo:block color="white" margin-left="8mm" margin-top="7mm">
			<fo:block width="30mm" height="30mm" margin-left="2mm">
				<fo:instream-foreign-object>
					<svg width="30mm" height="30mm" version="1.1" viewBox="0 0 100 100"
					     xmlns="http://www.w3.org/2000/svg" xmlns:xlink= "http://www.w3.org/1999/xlink">
					     <clipPath id="photoCircle">
						    <circle cx="50" cy="50" r="50" />
  						</clipPath>
						<image clip-path="url(#photoCircle)" xlink:href="{$photo.url}" x="0" y="0" width="100" height="1000" preserveAspectRatio="xMidYMin meet" />
					</svg>
				</fo:instream-foreign-object>
				<!-- 
	    		<fo:external-graphic content-width="30mm" content-height="30mm" src="url({$photo.url})" />
	    		 -->
			</fo:block>
			<fo:block margin-top="10mm" font-weight="900" font-size="10pt">
				<xsl:value-of select="$text.contact" />
			</fo:block>
			<fo:block font-size="8pt" margin-top="4mm" margin-left="-4mm">
				<fo:list-block provisional-label-separation="2mm" font-size="8pt" margin-right="1mm">
					<fo:list-item space-after="2mm">
						<fo:list-item-label end-indent="label-end()"><fo:block text-align="right" font-family="FontAwesome Regular">&#xf0e0;</fo:block></fo:list-item-label>
						<fo:list-item-body start-indent="body-start()"><fo:block><xsl:value-of select="basics/email" /></fo:block></fo:list-item-body>
					</fo:list-item>
					<fo:list-item space-after="2mm">
						<fo:list-item-label end-indent="label-end()"><fo:block text-align="right" font-family="FontAwesome">&#xf095;</fo:block></fo:list-item-label>
						<fo:list-item-body start-indent="body-start()"><fo:block><xsl:value-of select="basics/phone" /></fo:block></fo:list-item-body>
					</fo:list-item>
					<fo:list-item space-after="2mm">
						<fo:list-item-label end-indent="label-end()"><fo:block text-align="right" font-family="FontAwesome">&#xf3c5;</fo:block></fo:list-item-label>
						<fo:list-item-body start-indent="body-start()">
							<fo:block>
								<xsl:value-of select="basics/location/address" /><fo:block />
								<xsl:choose>
									<xsl:when test="basics/location/countryCode='US'">
										<xsl:value-of select="concat(basics/location/city, concat(', ', basics/location/postalCode))" />
									</xsl:when>
									<xsl:otherwise>
										<xsl:value-of select="concat(basics/location/postalCode, concat(' ', basics/location/city))" />							
									</xsl:otherwise>
								</xsl:choose>
							</fo:block>
						</fo:list-item-body>
					</fo:list-item>
				</fo:list-block>	
			</fo:block>
			
			<xsl:if test="basics/profiles/profile">
				<fo:block margin-top="150mm">
				</fo:block>
				<fo:block font-size="10pt" font-weight="900">
					<xsl:value-of select="$text.getintouch" />
				</fo:block>
				<fo:block margin-top="3mm"></fo:block>
				<xsl:apply-templates select="basics/profiles" />
			</xsl:if>
		</fo:block>
	</xsl:template>

	<xsl:template match="basics">
		<fo:block font-size="24pt" font-weight="900">
			<xsl:value-of select="lc:toUpper(string(name))" />
		</fo:block>
		<fo:block font-size="12pt">
			<xsl:value-of select="label" />
		</fo:block>
		<fo:block margin-top="1.5em" linefeed-treatment="preserve"><xsl:apply-templates select="summary" /></fo:block>
	</xsl:template>
	
	<xsl:template match="profiles">
		<fo:list-block font-size="8pt" margin-left="-4mm" margin-right="3mm" provisional-label-separation="2mm">
			<xsl:for-each select="profile">
				<fo:list-item space-after="2mm">
					<fo:list-item-label end-indent="label-end()"><fo:block text-align="right" font-family="FontAwesome Brands"><xsl:call-template name="network-icon">
						<xsl:with-param name="network" select="lc:toLower(string(network/text()))" />
					</xsl:call-template></fo:block></fo:list-item-label>
					<fo:list-item-body start-indent="body-start()">
						<fo:block>
							<xsl:choose>
								<xsl:when test="url and url/text() != ''">
									<xsl:value-of select="url" />
								</xsl:when>
								<xsl:otherwise>
									<xsl:value-of select="username" />
								</xsl:otherwise>
							</xsl:choose>
						</fo:block>
					</fo:list-item-body>
				</fo:list-item>	
			</xsl:for-each>
		</fo:list-block>
	
	</xsl:template>
	
	<xsl:template match="workhistory">
		<fo:block-container margin-top="1.5em">
			<xsl:call-template name="section-header">
				<xsl:with-param name="glyph">&#xf0b1;</xsl:with-param>
				<xsl:with-param name="title" select="$text.workhistory" />
			</xsl:call-template>
			
			<xsl:call-template name="timeline">
				<xsl:with-param name="nodes" select="work" />
			</xsl:call-template>
		</fo:block-container>
	</xsl:template>
	
	<xsl:template match="work">
		<fo:block font-size="10pt" font-weight="bold">
			<xsl:value-of select="position" />
		</fo:block>
		<fo:block font-size="8pt" font-weight="bold">
			<xsl:value-of select="name" />
		</fo:block>
		<fo:block font-size="8pt" font-style="italic">
			<xsl:value-of select="dt:toMonthYear(string(startDate), $text.monthYearSeparator)" /><xsl:text> - </xsl:text><xsl:choose>
				<xsl:when test="endDate and endDate/text() != ''"><xsl:value-of select="dt:toMonthYear(string(endDate), $text.monthYearSeparator)" /></xsl:when>
				<xsl:otherwise><xsl:value-of select="$text.today" /></xsl:otherwise>
			</xsl:choose>
		</fo:block>
		<fo:block font-size="8pt" margin-top="2mm" linefeed-treatment="preserve">
			<xsl:apply-templates select="summary" />
		</fo:block>
		<xsl:apply-templates select="highlights" />
		<xsl:apply-templates select="technologies" />
	</xsl:template>
	
	<xsl:template match="highlights">
		<fo:list-block margin-left="4mm" margin-top="1mm" font-size="8pt">
			<xsl:apply-templates />
		</fo:list-block>
	</xsl:template>
	
	<xsl:template match="highlight">
		<fo:list-item>
			<fo:list-item-label end-indent="label-end()"><fo:block>&#8226;</fo:block></fo:list-item-label>
			<fo:list-item-body start-indent="14mm"><fo:block><xsl:apply-templates /></fo:block></fo:list-item-body>
		</fo:list-item>
	</xsl:template>
	
	<xsl:template match="technologies">
		<fo:block margin-top="1.5mm" line-height="200%"><xsl:apply-templates /></fo:block>
	</xsl:template>
	
	<xsl:template match="technology">
		<fo:inline font-size="7pt" font-weight="bold" color="white" background-color="{$dark-color}" fox:border-radius="1mm" padding="1mm" keep-together.within-line="always">
			<xsl:value-of select="." />
		</fo:inline><fo:inline keep-together.within-line="auto"><xsl:value-of select="'  '" /></fo:inline>
	</xsl:template>
	
	
	<xsl:template match="educations">
		<fo:block-container margin-top="1.5em">
			<xsl:call-template name="section-header">
				<xsl:with-param name="glyph">&#xf19d;</xsl:with-param>
				<xsl:with-param name="title" select="$text.education" />
			</xsl:call-template>
			
			<xsl:call-template name="timeline">
				<xsl:with-param name="nodes" select="education" />
			</xsl:call-template>
		</fo:block-container>
	</xsl:template>
		
	<xsl:template match="education">
		<fo:block font-size="10pt" font-weight="bold">
			<xsl:value-of select="institution" />
		</fo:block>
		<fo:block font-size="8pt" font-weight="bold">
			<xsl:value-of select="area" />
		</fo:block>
		<fo:block font-size="8pt" font-style="italic">
			<xsl:value-of select="dt:toMonthYear(string(startDate), $text.monthYearSeparator)" /><xsl:text> - </xsl:text><xsl:choose>
				<xsl:when test="endDate and endDate/text() != ''"><xsl:value-of select="dt:toMonthYear(string(endDate), $text.monthYearSeparator)" /></xsl:when>
				<xsl:otherwise><xsl:value-of select="$text.today" /></xsl:otherwise>
			</xsl:choose>
		</fo:block>
		
		<fo:block margin-top="1em" font-size="10pt" font-weight="900">
			<xsl:value-of select="studyType" />
		</fo:block>
	</xsl:template>

	<xsl:template match="skills">
		<fo:block-container margin-top="1.5em">
			<xsl:call-template name="section-header">
				<xsl:with-param name="glyph">&#xf7d9;</xsl:with-param>
				<xsl:with-param name="title" select="$text.skills" />
			</xsl:call-template>
			
			<fo:block margin-left="7mm" margin-top="1em">
				<fo:table table-layout="fixed" width="100%">
					<fo:table-body>
						<xsl:call-template name="table-rows" />	
					</fo:table-body>
				</fo:table>
			</fo:block>
			
			<xsl:apply-templates select="../languages" />
		</fo:block-container>
	</xsl:template>
	
	<xsl:template match="languages">
		<fo:block margin-left="7mm" margin-top="1em">
			<fo:table table-layout="fixed" width="100%">
				<fo:table-body>
					<xsl:call-template name="table-rows" />						
				</fo:table-body>
			</fo:table>
		</fo:block>
	</xsl:template>
	
	<xsl:template name="table-rows">
		<xsl:param name="rownum">0</xsl:param>
		<xsl:if test="./*[(count(preceding-sibling::*) = $rownum * 2) or (count(preceding-sibling::*) = $rownum * 2 + 1)]">
			<fo:table-row>
				<xsl:apply-templates select="./*[(count(preceding-sibling::*) = $rownum * 2) or (count(preceding-sibling::*) = $rownum * 2 + 1)]" />
				<xsl:if test="not(./*[count(preceding-sibling::*) = $rownum * 2 + 1])">
					<fo:table-cell><fo:block /></fo:table-cell>
				</xsl:if>
			</fo:table-row>
			<xsl:call-template name="table-rows">
				<xsl:with-param name="rownum" select="$rownum + 1" />
			</xsl:call-template>
		</xsl:if>
	</xsl:template>

	<xsl:template match="skill">
		<fo:table-cell text-align="left">
			<fo:block margin-bottom="2mm">
				<xsl:value-of select="name" />
				<xsl:if test="not(rating) or rating = 0">
					<xsl:message terminate="no">Please specify (add) rating properties (0-100) to your skills for graphical representation!</xsl:message>
				</xsl:if>
				<fo:block></fo:block>
				<fo:instream-foreign-object>
					<svg:svg width="40mm" height="4mm" viewBox="0 0 100 10">
						<svg:rect x="0" y="0" width="100" height="10" rx="2" ry="2" fill="{$light-color}" />
						<svg:rect x="0" y="0" height="10" rx="2" ry="2" fill="{$dark-color}">
							<xsl:attribute name="width"><xsl:value-of select="rating" /></xsl:attribute>
						</svg:rect>
					</svg:svg>
				</fo:instream-foreign-object>
			</fo:block>
		</fo:table-cell>
	</xsl:template>
	
	<xsl:template match="language">
		<fo:table-cell text-align="left">
			<fo:block margin-bottom="2mm">
				<xsl:value-of select="language" />
				<fo:block font-size="8pt" font-style="italic">
					<xsl:value-of select="fluency" />
				</fo:block>
			</fo:block>		
		</fo:table-cell>
	</xsl:template>
	
	<xsl:template match="certificates">
		<fo:block-container margin-top="1em">
			<xsl:call-template name="section-header">
				<xsl:with-param name="glyph">&#xf0a3;</xsl:with-param>
				<xsl:with-param name="title" select="$text.certificates" />
			</xsl:call-template>
			
			<xsl:call-template name="timeline">
				<xsl:with-param name="nodes" select="certificate" />
			</xsl:call-template>
		</fo:block-container>
	</xsl:template>
	
	<xsl:template match="certificate">
		<fo:block font-size="10pt" font-weight="bold">
			<xsl:value-of select="name" />
		</fo:block>
		<xsl:if test="issuer and issuer/text() != ''">
			<fo:block font-size="8pt" font-weight="bold">
				<xsl:value-of select="issuer" />
			</fo:block>
		</xsl:if>
		
		<fo:block font-size="8pt" font-style="italic">
			<xsl:value-of select="dt:toMonthYear(string(date), $text.monthYearSeparator)" />
		</fo:block>
	</xsl:template>	
	
	<xsl:template name="section-header">
		<xsl:param name="glyph">&#xf0b1;</xsl:param>
		<xsl:param name="title"></xsl:param>
		<fo:block background-color="{$light-color}" margin-left="5mm" padding-top="1mm" padding-bottom="1mm" padding-left="8mm">
				
			<fo:inline font-weight="bold"><xsl:value-of select="$title" /></fo:inline></fo:block>
			<xsl:call-template name="header-circle">
				<xsl:with-param name="glyph" select="$glyph" />
			</xsl:call-template>
	</xsl:template>
	
	<xsl:template name="header-circle">
		<xsl:param name="glyph">&#xf0b1;</xsl:param>
			<fo:block-container position="absolute" top="-0.75mm" width="7mm" height="9mm">
			<fo:block font-family="FontAwesome" font-size="11pt" border-style="solid" background-color="white" border-color="black" border-width="0.5mm" 
				fox:border-radius="1em" text-align="center" padding-bottom="1mm" padding-top="1mm">
				<xsl:value-of select="$glyph" />
            </fo:block>
            </fo:block-container>
	</xsl:template>
	
	<xsl:template name="timeline">
		<xsl:param name="nodes"></xsl:param>
		
		<fo:block margin-left="3.25mm" margin-top="2mm" padding-top="2mm" padding-left="3mm" border-left-width="0.25mm" border-left-color="{$dark-color}" border-left-style="solid">
			<xsl:for-each select="$nodes">
				<fo:block-container margin-bottom="3mm" keep-together.within-page="always">
					<fo:block>
						<xsl:apply-templates select="." />						
					</fo:block>
					<fo:block-container position="absolute" left="-10.6mm" top="0.5mm" width="8.5mm" height="10mm">
						<fo:block font-size="5pt" border-style="solid" border-width="0.5mm" background-color="white" border-color="{$dark-color}" fox:border-radius="7mm">
						 &#160;
						</fo:block>
					</fo:block-container>
				</fo:block-container>
			</xsl:for-each>
		</fo:block>
	</xsl:template>
	
	<xsl:template name="network-icon">
		<xsl:param name="network"></xsl:param>
		<xsl:choose>
			<xsl:when test="$network = 'stackoverflow'">&#xf16c;</xsl:when>
			<xsl:when test="$network = 'github'">&#xf09b;</xsl:when>
			<xsl:when test="$network = 'facebook'">&#xf09a;</xsl:when>
			<xsl:when test="$network = 'twitter'">&#xf099;</xsl:when>
			<xsl:when test="$network = 'xing'">&#xf168;</xsl:when>
			<xsl:when test="$network = 'linkedin'">&#xf0e1;</xsl:when>
			<xsl:when test="$network = 'soundcloud'">&#xf1be;</xsl:when>
			<xsl:otherwise></xsl:otherwise>
		</xsl:choose>
	</xsl:template>
	
	<!-- extension helpers -->
	
	<xalan:component prefix="lc" functions="toLower toUpper">
		<xalan:script lang="javascript">
    		function toLower(str) {
    			return str.toLowerCase();
    		}
    		function toUpper(str) {
    			return str.toUpperCase();
    		}
		</xalan:script>
	</xalan:component>
	
	<xalan:component prefix="dt" functions="toMonthYear">
		<xalan:script lang="javaclass" src="xalan://com.github.albrechtf.cv.xslt.DateFunctions"/> 
	</xalan:component>
	

</xsl:stylesheet>