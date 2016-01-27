<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet 
    xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
    xmlns:v="http://ccc.com/Purchase"
    xmlns:hotels="http://aaa.com/Purchase"
    version="1.0">
    
    <xsl:output method="html" indent="yes" />
    <xsl:template match="/">
        <html>
            <head>
                <title>Tourist vouchers</title>
            </head>
            
            <body>
                <xsl:apply-templates />
            </body>
        </html>
    </xsl:template>
    
    <xsl:template match="v:vouchers">
        
                <table border="1">
                    <tr>
                        <th rowspan="2">id</th>
                        <th rowspan="2">type</th>
                        <th rowspan="2">country</th>
                        <th rowspan="2">days</th>
                        <th rowspan="2">nights</th>
                        <th rowspan="2">transport</th>
                        <th rowspan="2">stars</th>
                        <th rowspan="2">food</th>
                        <th rowspan="2">foodType</th>
                        <th rowspan="2">room</th>
                        <th rowspan="2">tv</th>
                        <th rowspan="2">conditioner</th>
                        <th rowspan="2">cost</th>
                    </tr>
                    
                    <xsl:for-each select="v:voucher">
                        <tr>
                            <tr>
                                <!-- <xsl:apply-templates select='type'></xsl:apply-templates> -->
                                <td><xsl:value-of select="@id"/></td>
                                <td><xsl:value-of select="v:type"/></td>
                                <td><xsl:value-of select="v:country"/></td>
                                <td><xsl:value-of select="v:duration/v:days"/></td>
                                <td><xsl:value-of select="v:duration/v:nights"/></td>
                                <td><xsl:value-of select="v:transport"/></td>
                                <td><xsl:value-of select="v:hotel/hotels:stars"/></td>
                                <td><xsl:value-of select="v:hotel/hotels:food"/></td>
                                <td><xsl:value-of select="v:hotel/hotels:foodType"/></td>
                                <td><xsl:value-of select="v:hotel/hotels:room"/></td>
                                <td><xsl:value-of select="v:hotel/hotels:tv"/></td>
                                <td><xsl:value-of select="v:hotel/hotels:conditioner"/></td>
                                <td><xsl:value-of select="v:cost"/></td>
                            </tr>
                        </tr>
                    </xsl:for-each>
                </table>
    </xsl:template>
    
    <xsl:template match='type'>
        <td><xsl:value-of select="type"/></td>
    </xsl:template>
    
</xsl:stylesheet>