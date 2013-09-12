//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vhudson-jaxb-ri-2.1-2 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2013.09.12 at 10:41:09 AM COT 
//


package org.primefaces.examples.moviecollector.ws;

import java.math.BigInteger;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for Movie complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Movie">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="MovieId" type="{http://www.w3.org/2001/XMLSchema}integer"/>
 *         &lt;element name="MovieTitle" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="MovieDiscs" type="{http://www.w3.org/2001/XMLSchema}integer"/>
 *         &lt;element name="MovieDescription" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="MovieFormat" type="{http://ws.moviecollector.examples.primefaces.org}EnumMovieFormat"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Movie", propOrder = {
    "movieId",
    "movieTitle",
    "movieDiscs",
    "movieDescription",
    "movieFormat"
})
public class Movie {

    @XmlElement(name = "MovieId", required = true)
    protected BigInteger movieId;
    @XmlElement(name = "MovieTitle", required = true)
    protected String movieTitle;
    @XmlElement(name = "MovieDiscs", required = true)
    protected BigInteger movieDiscs;
    @XmlElement(name = "MovieDescription", required = true)
    protected String movieDescription;
    @XmlElement(name = "MovieFormat", required = true)
    protected EnumMovieFormat movieFormat;

    /**
     * Gets the value of the movieId property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getMovieId() {
        return movieId;
    }

    /**
     * Sets the value of the movieId property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setMovieId(BigInteger value) {
        this.movieId = value;
    }

    /**
     * Gets the value of the movieTitle property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMovieTitle() {
        return movieTitle;
    }

    /**
     * Sets the value of the movieTitle property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMovieTitle(String value) {
        this.movieTitle = value;
    }

    /**
     * Gets the value of the movieDiscs property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getMovieDiscs() {
        return movieDiscs;
    }

    /**
     * Sets the value of the movieDiscs property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setMovieDiscs(BigInteger value) {
        this.movieDiscs = value;
    }

    /**
     * Gets the value of the movieDescription property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMovieDescription() {
        return movieDescription;
    }

    /**
     * Sets the value of the movieDescription property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMovieDescription(String value) {
        this.movieDescription = value;
    }

    /**
     * Gets the value of the movieFormat property.
     * 
     * @return
     *     possible object is
     *     {@link EnumMovieFormat }
     *     
     */
    public EnumMovieFormat getMovieFormat() {
        return movieFormat;
    }

    /**
     * Sets the value of the movieFormat property.
     * 
     * @param value
     *     allowed object is
     *     {@link EnumMovieFormat }
     *     
     */
    public void setMovieFormat(EnumMovieFormat value) {
        this.movieFormat = value;
    }

}
