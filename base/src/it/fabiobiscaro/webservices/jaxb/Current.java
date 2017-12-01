//
// Questo file è stato generato dall'architettura JavaTM per XML Binding (JAXB) Reference Implementation, v2.2.8-b130911.1802 
// Vedere <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Qualsiasi modifica a questo file andrà persa durante la ricompilazione dello schema di origine. 
// Generato il: 2017.12.01 alle 01:07:12 PM CET 
//


package it.fabiobiscaro.webservices.jaxb;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Classe Java per anonymous complex type.
 * 
 * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="city">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="coord">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;attribute name="lon" type="{http://www.w3.org/2001/XMLSchema}decimal" />
 *                           &lt;attribute name="lat" type="{http://www.w3.org/2001/XMLSchema}decimal" />
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                   &lt;element name="country" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="sun">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;attribute name="rise" type="{http://www.w3.org/2001/XMLSchema}dateTime" />
 *                           &lt;attribute name="set" type="{http://www.w3.org/2001/XMLSchema}dateTime" />
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                 &lt;/sequence>
 *                 &lt;attribute name="id" type="{http://www.w3.org/2001/XMLSchema}int" />
 *                 &lt;attribute name="name" type="{http://www.w3.org/2001/XMLSchema}string" />
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="temperature">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;attribute name="value" type="{http://www.w3.org/2001/XMLSchema}decimal" />
 *                 &lt;attribute name="min" type="{http://www.w3.org/2001/XMLSchema}decimal" />
 *                 &lt;attribute name="max" type="{http://www.w3.org/2001/XMLSchema}decimal" />
 *                 &lt;attribute name="unit" type="{http://www.w3.org/2001/XMLSchema}string" />
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="humidity">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;attribute name="value" type="{http://www.w3.org/2001/XMLSchema}int" />
 *                 &lt;attribute name="unit" type="{http://www.w3.org/2001/XMLSchema}string" />
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="pressure">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;attribute name="value" type="{http://www.w3.org/2001/XMLSchema}int" />
 *                 &lt;attribute name="unit" type="{http://www.w3.org/2001/XMLSchema}string" />
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="wind">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="speed">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;attribute name="value" type="{http://www.w3.org/2001/XMLSchema}decimal" />
 *                           &lt;attribute name="name" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                   &lt;element name="gusts" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="direction">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;attribute name="value" type="{http://www.w3.org/2001/XMLSchema}int" />
 *                           &lt;attribute name="code" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                           &lt;attribute name="name" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="clouds">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;attribute name="value" type="{http://www.w3.org/2001/XMLSchema}int" />
 *                 &lt;attribute name="name" type="{http://www.w3.org/2001/XMLSchema}string" />
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="visibility">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;attribute name="value" type="{http://www.w3.org/2001/XMLSchema}int" />
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="precipitation">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;attribute name="mode" type="{http://www.w3.org/2001/XMLSchema}string" />
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="weather">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;attribute name="number" type="{http://www.w3.org/2001/XMLSchema}int" />
 *                 &lt;attribute name="value" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                 &lt;attribute name="icon" type="{http://www.w3.org/2001/XMLSchema}string" />
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="lastupdate">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;attribute name="value" type="{http://www.w3.org/2001/XMLSchema}dateTime" />
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "city",
    "temperature",
    "humidity",
    "pressure",
    "wind",
    "clouds",
    "visibility",
    "precipitation",
    "weather",
    "lastupdate"
})
@XmlRootElement(name = "current")
public class Current {

    @XmlElement(required = true)
    protected Current.City city;
    @XmlElement(required = true)
    protected Current.Temperature temperature;
    @XmlElement(required = true)
    protected Current.Humidity humidity;
    @XmlElement(required = true)
    protected Current.Pressure pressure;
    @XmlElement(required = true)
    protected Current.Wind wind;
    @XmlElement(required = true)
    protected Current.Clouds clouds;
    @XmlElement(required = true)
    protected Current.Visibility visibility;
    @XmlElement(required = true)
    protected Current.Precipitation precipitation;
    @XmlElement(required = true)
    protected Current.Weather weather;
    @XmlElement(required = true)
    protected Current.Lastupdate lastupdate;

    /**
     * Recupera il valore della proprietà city.
     * 
     * @return
     *     possible object is
     *     {@link Current.City }
     *     
     */
    public Current.City getCity() {
        return city;
    }

    /**
     * Imposta il valore della proprietà city.
     * 
     * @param value
     *     allowed object is
     *     {@link Current.City }
     *     
     */
    public void setCity(Current.City value) {
        this.city = value;
    }

    /**
     * Recupera il valore della proprietà temperature.
     * 
     * @return
     *     possible object is
     *     {@link Current.Temperature }
     *     
     */
    public Current.Temperature getTemperature() {
        return temperature;
    }

    /**
     * Imposta il valore della proprietà temperature.
     * 
     * @param value
     *     allowed object is
     *     {@link Current.Temperature }
     *     
     */
    public void setTemperature(Current.Temperature value) {
        this.temperature = value;
    }

    /**
     * Recupera il valore della proprietà humidity.
     * 
     * @return
     *     possible object is
     *     {@link Current.Humidity }
     *     
     */
    public Current.Humidity getHumidity() {
        return humidity;
    }

    /**
     * Imposta il valore della proprietà humidity.
     * 
     * @param value
     *     allowed object is
     *     {@link Current.Humidity }
     *     
     */
    public void setHumidity(Current.Humidity value) {
        this.humidity = value;
    }

    /**
     * Recupera il valore della proprietà pressure.
     * 
     * @return
     *     possible object is
     *     {@link Current.Pressure }
     *     
     */
    public Current.Pressure getPressure() {
        return pressure;
    }

    /**
     * Imposta il valore della proprietà pressure.
     * 
     * @param value
     *     allowed object is
     *     {@link Current.Pressure }
     *     
     */
    public void setPressure(Current.Pressure value) {
        this.pressure = value;
    }

    /**
     * Recupera il valore della proprietà wind.
     * 
     * @return
     *     possible object is
     *     {@link Current.Wind }
     *     
     */
    public Current.Wind getWind() {
        return wind;
    }

    /**
     * Imposta il valore della proprietà wind.
     * 
     * @param value
     *     allowed object is
     *     {@link Current.Wind }
     *     
     */
    public void setWind(Current.Wind value) {
        this.wind = value;
    }

    /**
     * Recupera il valore della proprietà clouds.
     * 
     * @return
     *     possible object is
     *     {@link Current.Clouds }
     *     
     */
    public Current.Clouds getClouds() {
        return clouds;
    }

    /**
     * Imposta il valore della proprietà clouds.
     * 
     * @param value
     *     allowed object is
     *     {@link Current.Clouds }
     *     
     */
    public void setClouds(Current.Clouds value) {
        this.clouds = value;
    }

    /**
     * Recupera il valore della proprietà visibility.
     * 
     * @return
     *     possible object is
     *     {@link Current.Visibility }
     *     
     */
    public Current.Visibility getVisibility() {
        return visibility;
    }

    /**
     * Imposta il valore della proprietà visibility.
     * 
     * @param value
     *     allowed object is
     *     {@link Current.Visibility }
     *     
     */
    public void setVisibility(Current.Visibility value) {
        this.visibility = value;
    }

    /**
     * Recupera il valore della proprietà precipitation.
     * 
     * @return
     *     possible object is
     *     {@link Current.Precipitation }
     *     
     */
    public Current.Precipitation getPrecipitation() {
        return precipitation;
    }

    /**
     * Imposta il valore della proprietà precipitation.
     * 
     * @param value
     *     allowed object is
     *     {@link Current.Precipitation }
     *     
     */
    public void setPrecipitation(Current.Precipitation value) {
        this.precipitation = value;
    }

    /**
     * Recupera il valore della proprietà weather.
     * 
     * @return
     *     possible object is
     *     {@link Current.Weather }
     *     
     */
    public Current.Weather getWeather() {
        return weather;
    }

    /**
     * Imposta il valore della proprietà weather.
     * 
     * @param value
     *     allowed object is
     *     {@link Current.Weather }
     *     
     */
    public void setWeather(Current.Weather value) {
        this.weather = value;
    }

    /**
     * Recupera il valore della proprietà lastupdate.
     * 
     * @return
     *     possible object is
     *     {@link Current.Lastupdate }
     *     
     */
    public Current.Lastupdate getLastupdate() {
        return lastupdate;
    }

    /**
     * Imposta il valore della proprietà lastupdate.
     * 
     * @param value
     *     allowed object is
     *     {@link Current.Lastupdate }
     *     
     */
    public void setLastupdate(Current.Lastupdate value) {
        this.lastupdate = value;
    }


    /**
     * <p>Classe Java per anonymous complex type.
     * 
     * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element name="coord">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;attribute name="lon" type="{http://www.w3.org/2001/XMLSchema}decimal" />
     *                 &lt;attribute name="lat" type="{http://www.w3.org/2001/XMLSchema}decimal" />
     *               &lt;/restriction>
     *             &lt;/complexContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *         &lt;element name="country" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="sun">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;attribute name="rise" type="{http://www.w3.org/2001/XMLSchema}dateTime" />
     *                 &lt;attribute name="set" type="{http://www.w3.org/2001/XMLSchema}dateTime" />
     *               &lt;/restriction>
     *             &lt;/complexContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *       &lt;/sequence>
     *       &lt;attribute name="id" type="{http://www.w3.org/2001/XMLSchema}int" />
     *       &lt;attribute name="name" type="{http://www.w3.org/2001/XMLSchema}string" />
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "coord",
        "country",
        "sun"
    })
    public static class City {

        @XmlElement(required = true)
        protected Current.City.Coord coord;
        @XmlElement(required = true)
        protected String country;
        @XmlElement(required = true)
        protected Current.City.Sun sun;
        @XmlAttribute(name = "id")
        protected Integer id;
        @XmlAttribute(name = "name")
        protected String name;

        /**
         * Recupera il valore della proprietà coord.
         * 
         * @return
         *     possible object is
         *     {@link Current.City.Coord }
         *     
         */
        public Current.City.Coord getCoord() {
            return coord;
        }

        /**
         * Imposta il valore della proprietà coord.
         * 
         * @param value
         *     allowed object is
         *     {@link Current.City.Coord }
         *     
         */
        public void setCoord(Current.City.Coord value) {
            this.coord = value;
        }

        /**
         * Recupera il valore della proprietà country.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getCountry() {
            return country;
        }

        /**
         * Imposta il valore della proprietà country.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setCountry(String value) {
            this.country = value;
        }

        /**
         * Recupera il valore della proprietà sun.
         * 
         * @return
         *     possible object is
         *     {@link Current.City.Sun }
         *     
         */
        public Current.City.Sun getSun() {
            return sun;
        }

        /**
         * Imposta il valore della proprietà sun.
         * 
         * @param value
         *     allowed object is
         *     {@link Current.City.Sun }
         *     
         */
        public void setSun(Current.City.Sun value) {
            this.sun = value;
        }

        /**
         * Recupera il valore della proprietà id.
         * 
         * @return
         *     possible object is
         *     {@link Integer }
         *     
         */
        public Integer getId() {
            return id;
        }

        /**
         * Imposta il valore della proprietà id.
         * 
         * @param value
         *     allowed object is
         *     {@link Integer }
         *     
         */
        public void setId(Integer value) {
            this.id = value;
        }

        /**
         * Recupera il valore della proprietà name.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getName() {
            return name;
        }

        /**
         * Imposta il valore della proprietà name.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setName(String value) {
            this.name = value;
        }


        /**
         * <p>Classe Java per anonymous complex type.
         * 
         * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
         * 
         * <pre>
         * &lt;complexType>
         *   &lt;complexContent>
         *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *       &lt;attribute name="lon" type="{http://www.w3.org/2001/XMLSchema}decimal" />
         *       &lt;attribute name="lat" type="{http://www.w3.org/2001/XMLSchema}decimal" />
         *     &lt;/restriction>
         *   &lt;/complexContent>
         * &lt;/complexType>
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "")
        public static class Coord {

            @XmlAttribute(name = "lon")
            protected BigDecimal lon;
            @XmlAttribute(name = "lat")
            protected BigDecimal lat;

            /**
             * Recupera il valore della proprietà lon.
             * 
             * @return
             *     possible object is
             *     {@link BigDecimal }
             *     
             */
            public BigDecimal getLon() {
                return lon;
            }

            /**
             * Imposta il valore della proprietà lon.
             * 
             * @param value
             *     allowed object is
             *     {@link BigDecimal }
             *     
             */
            public void setLon(BigDecimal value) {
                this.lon = value;
            }

            /**
             * Recupera il valore della proprietà lat.
             * 
             * @return
             *     possible object is
             *     {@link BigDecimal }
             *     
             */
            public BigDecimal getLat() {
                return lat;
            }

            /**
             * Imposta il valore della proprietà lat.
             * 
             * @param value
             *     allowed object is
             *     {@link BigDecimal }
             *     
             */
            public void setLat(BigDecimal value) {
                this.lat = value;
            }

        }


        /**
         * <p>Classe Java per anonymous complex type.
         * 
         * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
         * 
         * <pre>
         * &lt;complexType>
         *   &lt;complexContent>
         *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *       &lt;attribute name="rise" type="{http://www.w3.org/2001/XMLSchema}dateTime" />
         *       &lt;attribute name="set" type="{http://www.w3.org/2001/XMLSchema}dateTime" />
         *     &lt;/restriction>
         *   &lt;/complexContent>
         * &lt;/complexType>
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "")
        public static class Sun {

            @XmlAttribute(name = "rise")
            @XmlSchemaType(name = "dateTime")
            protected XMLGregorianCalendar rise;
            @XmlAttribute(name = "set")
            @XmlSchemaType(name = "dateTime")
            protected XMLGregorianCalendar set;

            /**
             * Recupera il valore della proprietà rise.
             * 
             * @return
             *     possible object is
             *     {@link XMLGregorianCalendar }
             *     
             */
            public XMLGregorianCalendar getRise() {
                return rise;
            }

            /**
             * Imposta il valore della proprietà rise.
             * 
             * @param value
             *     allowed object is
             *     {@link XMLGregorianCalendar }
             *     
             */
            public void setRise(XMLGregorianCalendar value) {
                this.rise = value;
            }

            /**
             * Recupera il valore della proprietà set.
             * 
             * @return
             *     possible object is
             *     {@link XMLGregorianCalendar }
             *     
             */
            public XMLGregorianCalendar getSet() {
                return set;
            }

            /**
             * Imposta il valore della proprietà set.
             * 
             * @param value
             *     allowed object is
             *     {@link XMLGregorianCalendar }
             *     
             */
            public void setSet(XMLGregorianCalendar value) {
                this.set = value;
            }

        }

    }


    /**
     * <p>Classe Java per anonymous complex type.
     * 
     * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;attribute name="value" type="{http://www.w3.org/2001/XMLSchema}int" />
     *       &lt;attribute name="name" type="{http://www.w3.org/2001/XMLSchema}string" />
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "")
    public static class Clouds {

        @XmlAttribute(name = "value")
        protected Integer value;
        @XmlAttribute(name = "name")
        protected String name;

        /**
         * Recupera il valore della proprietà value.
         * 
         * @return
         *     possible object is
         *     {@link Integer }
         *     
         */
        public Integer getValue() {
            return value;
        }

        /**
         * Imposta il valore della proprietà value.
         * 
         * @param value
         *     allowed object is
         *     {@link Integer }
         *     
         */
        public void setValue(Integer value) {
            this.value = value;
        }

        /**
         * Recupera il valore della proprietà name.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getName() {
            return name;
        }

        /**
         * Imposta il valore della proprietà name.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setName(String value) {
            this.name = value;
        }

    }


    /**
     * <p>Classe Java per anonymous complex type.
     * 
     * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;attribute name="value" type="{http://www.w3.org/2001/XMLSchema}int" />
     *       &lt;attribute name="unit" type="{http://www.w3.org/2001/XMLSchema}string" />
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "")
    public static class Humidity {

        @XmlAttribute(name = "value")
        protected Integer value;
        @XmlAttribute(name = "unit")
        protected String unit;

        /**
         * Recupera il valore della proprietà value.
         * 
         * @return
         *     possible object is
         *     {@link Integer }
         *     
         */
        public Integer getValue() {
            return value;
        }

        /**
         * Imposta il valore della proprietà value.
         * 
         * @param value
         *     allowed object is
         *     {@link Integer }
         *     
         */
        public void setValue(Integer value) {
            this.value = value;
        }

        /**
         * Recupera il valore della proprietà unit.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getUnit() {
            return unit;
        }

        /**
         * Imposta il valore della proprietà unit.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setUnit(String value) {
            this.unit = value;
        }

    }


    /**
     * <p>Classe Java per anonymous complex type.
     * 
     * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;attribute name="value" type="{http://www.w3.org/2001/XMLSchema}dateTime" />
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "")
    public static class Lastupdate {

        @XmlAttribute(name = "value")
        @XmlSchemaType(name = "dateTime")
        protected XMLGregorianCalendar value;

        /**
         * Recupera il valore della proprietà value.
         * 
         * @return
         *     possible object is
         *     {@link XMLGregorianCalendar }
         *     
         */
        public XMLGregorianCalendar getValue() {
            return value;
        }

        /**
         * Imposta il valore della proprietà value.
         * 
         * @param value
         *     allowed object is
         *     {@link XMLGregorianCalendar }
         *     
         */
        public void setValue(XMLGregorianCalendar value) {
            this.value = value;
        }

    }


    /**
     * <p>Classe Java per anonymous complex type.
     * 
     * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;attribute name="mode" type="{http://www.w3.org/2001/XMLSchema}string" />
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "")
    public static class Precipitation {

        @XmlAttribute(name = "mode")
        protected String mode;

        /**
         * Recupera il valore della proprietà mode.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getMode() {
            return mode;
        }

        /**
         * Imposta il valore della proprietà mode.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setMode(String value) {
            this.mode = value;
        }

    }


    /**
     * <p>Classe Java per anonymous complex type.
     * 
     * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;attribute name="value" type="{http://www.w3.org/2001/XMLSchema}int" />
     *       &lt;attribute name="unit" type="{http://www.w3.org/2001/XMLSchema}string" />
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "")
    public static class Pressure {

        @XmlAttribute(name = "value")
        protected Integer value;
        @XmlAttribute(name = "unit")
        protected String unit;

        /**
         * Recupera il valore della proprietà value.
         * 
         * @return
         *     possible object is
         *     {@link Integer }
         *     
         */
        public Integer getValue() {
            return value;
        }

        /**
         * Imposta il valore della proprietà value.
         * 
         * @param value
         *     allowed object is
         *     {@link Integer }
         *     
         */
        public void setValue(Integer value) {
            this.value = value;
        }

        /**
         * Recupera il valore della proprietà unit.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getUnit() {
            return unit;
        }

        /**
         * Imposta il valore della proprietà unit.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setUnit(String value) {
            this.unit = value;
        }

    }


    /**
     * <p>Classe Java per anonymous complex type.
     * 
     * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;attribute name="value" type="{http://www.w3.org/2001/XMLSchema}decimal" />
     *       &lt;attribute name="min" type="{http://www.w3.org/2001/XMLSchema}decimal" />
     *       &lt;attribute name="max" type="{http://www.w3.org/2001/XMLSchema}decimal" />
     *       &lt;attribute name="unit" type="{http://www.w3.org/2001/XMLSchema}string" />
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "")
    public static class Temperature {

        @XmlAttribute(name = "value")
        protected BigDecimal value;
        @XmlAttribute(name = "min")
        protected BigDecimal min;
        @XmlAttribute(name = "max")
        protected BigDecimal max;
        @XmlAttribute(name = "unit")
        protected String unit;

        /**
         * Recupera il valore della proprietà value.
         * 
         * @return
         *     possible object is
         *     {@link BigDecimal }
         *     
         */
        public BigDecimal getValue() {
            return value;
        }

        /**
         * Imposta il valore della proprietà value.
         * 
         * @param value
         *     allowed object is
         *     {@link BigDecimal }
         *     
         */
        public void setValue(BigDecimal value) {
            this.value = value;
        }

        /**
         * Recupera il valore della proprietà min.
         * 
         * @return
         *     possible object is
         *     {@link BigDecimal }
         *     
         */
        public BigDecimal getMin() {
            return min;
        }

        /**
         * Imposta il valore della proprietà min.
         * 
         * @param value
         *     allowed object is
         *     {@link BigDecimal }
         *     
         */
        public void setMin(BigDecimal value) {
            this.min = value;
        }

        /**
         * Recupera il valore della proprietà max.
         * 
         * @return
         *     possible object is
         *     {@link BigDecimal }
         *     
         */
        public BigDecimal getMax() {
            return max;
        }

        /**
         * Imposta il valore della proprietà max.
         * 
         * @param value
         *     allowed object is
         *     {@link BigDecimal }
         *     
         */
        public void setMax(BigDecimal value) {
            this.max = value;
        }

        /**
         * Recupera il valore della proprietà unit.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getUnit() {
            return unit;
        }

        /**
         * Imposta il valore della proprietà unit.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setUnit(String value) {
            this.unit = value;
        }

    }


    /**
     * <p>Classe Java per anonymous complex type.
     * 
     * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;attribute name="value" type="{http://www.w3.org/2001/XMLSchema}int" />
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "")
    public static class Visibility {

        @XmlAttribute(name = "value")
        protected Integer value;

        /**
         * Recupera il valore della proprietà value.
         * 
         * @return
         *     possible object is
         *     {@link Integer }
         *     
         */
        public Integer getValue() {
            return value;
        }

        /**
         * Imposta il valore della proprietà value.
         * 
         * @param value
         *     allowed object is
         *     {@link Integer }
         *     
         */
        public void setValue(Integer value) {
            this.value = value;
        }

    }


    /**
     * <p>Classe Java per anonymous complex type.
     * 
     * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;attribute name="number" type="{http://www.w3.org/2001/XMLSchema}int" />
     *       &lt;attribute name="value" type="{http://www.w3.org/2001/XMLSchema}string" />
     *       &lt;attribute name="icon" type="{http://www.w3.org/2001/XMLSchema}string" />
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "")
    public static class Weather {

        @XmlAttribute(name = "number")
        protected Integer number;
        @XmlAttribute(name = "value")
        protected String value;
        @XmlAttribute(name = "icon")
        protected String icon;

        /**
         * Recupera il valore della proprietà number.
         * 
         * @return
         *     possible object is
         *     {@link Integer }
         *     
         */
        public Integer getNumber() {
            return number;
        }

        /**
         * Imposta il valore della proprietà number.
         * 
         * @param value
         *     allowed object is
         *     {@link Integer }
         *     
         */
        public void setNumber(Integer value) {
            this.number = value;
        }

        /**
         * Recupera il valore della proprietà value.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getValue() {
            return value;
        }

        /**
         * Imposta il valore della proprietà value.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setValue(String value) {
            this.value = value;
        }

        /**
         * Recupera il valore della proprietà icon.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getIcon() {
            return icon;
        }

        /**
         * Imposta il valore della proprietà icon.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setIcon(String value) {
            this.icon = value;
        }

    }


    /**
     * <p>Classe Java per anonymous complex type.
     * 
     * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element name="speed">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;attribute name="value" type="{http://www.w3.org/2001/XMLSchema}decimal" />
     *                 &lt;attribute name="name" type="{http://www.w3.org/2001/XMLSchema}string" />
     *               &lt;/restriction>
     *             &lt;/complexContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *         &lt;element name="gusts" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="direction">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;attribute name="value" type="{http://www.w3.org/2001/XMLSchema}int" />
     *                 &lt;attribute name="code" type="{http://www.w3.org/2001/XMLSchema}string" />
     *                 &lt;attribute name="name" type="{http://www.w3.org/2001/XMLSchema}string" />
     *               &lt;/restriction>
     *             &lt;/complexContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "speed",
        "gusts",
        "direction"
    })
    public static class Wind {

        @XmlElement(required = true)
        protected Current.Wind.Speed speed;
        @XmlElement(required = true)
        protected String gusts;
        @XmlElement(required = true)
        protected Current.Wind.Direction direction;

        /**
         * Recupera il valore della proprietà speed.
         * 
         * @return
         *     possible object is
         *     {@link Current.Wind.Speed }
         *     
         */
        public Current.Wind.Speed getSpeed() {
            return speed;
        }

        /**
         * Imposta il valore della proprietà speed.
         * 
         * @param value
         *     allowed object is
         *     {@link Current.Wind.Speed }
         *     
         */
        public void setSpeed(Current.Wind.Speed value) {
            this.speed = value;
        }

        /**
         * Recupera il valore della proprietà gusts.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getGusts() {
            return gusts;
        }

        /**
         * Imposta il valore della proprietà gusts.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setGusts(String value) {
            this.gusts = value;
        }

        /**
         * Recupera il valore della proprietà direction.
         * 
         * @return
         *     possible object is
         *     {@link Current.Wind.Direction }
         *     
         */
        public Current.Wind.Direction getDirection() {
            return direction;
        }

        /**
         * Imposta il valore della proprietà direction.
         * 
         * @param value
         *     allowed object is
         *     {@link Current.Wind.Direction }
         *     
         */
        public void setDirection(Current.Wind.Direction value) {
            this.direction = value;
        }


        /**
         * <p>Classe Java per anonymous complex type.
         * 
         * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
         * 
         * <pre>
         * &lt;complexType>
         *   &lt;complexContent>
         *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *       &lt;attribute name="value" type="{http://www.w3.org/2001/XMLSchema}int" />
         *       &lt;attribute name="code" type="{http://www.w3.org/2001/XMLSchema}string" />
         *       &lt;attribute name="name" type="{http://www.w3.org/2001/XMLSchema}string" />
         *     &lt;/restriction>
         *   &lt;/complexContent>
         * &lt;/complexType>
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "")
        public static class Direction {

            @XmlAttribute(name = "value")
            protected Integer value;
            @XmlAttribute(name = "code")
            protected String code;
            @XmlAttribute(name = "name")
            protected String name;

            /**
             * Recupera il valore della proprietà value.
             * 
             * @return
             *     possible object is
             *     {@link Integer }
             *     
             */
            public Integer getValue() {
                return value;
            }

            /**
             * Imposta il valore della proprietà value.
             * 
             * @param value
             *     allowed object is
             *     {@link Integer }
             *     
             */
            public void setValue(Integer value) {
                this.value = value;
            }

            /**
             * Recupera il valore della proprietà code.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getCode() {
                return code;
            }

            /**
             * Imposta il valore della proprietà code.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setCode(String value) {
                this.code = value;
            }

            /**
             * Recupera il valore della proprietà name.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getName() {
                return name;
            }

            /**
             * Imposta il valore della proprietà name.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setName(String value) {
                this.name = value;
            }

        }


        /**
         * <p>Classe Java per anonymous complex type.
         * 
         * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
         * 
         * <pre>
         * &lt;complexType>
         *   &lt;complexContent>
         *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *       &lt;attribute name="value" type="{http://www.w3.org/2001/XMLSchema}decimal" />
         *       &lt;attribute name="name" type="{http://www.w3.org/2001/XMLSchema}string" />
         *     &lt;/restriction>
         *   &lt;/complexContent>
         * &lt;/complexType>
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "")
        public static class Speed {

            @XmlAttribute(name = "value")
            protected BigDecimal value;
            @XmlAttribute(name = "name")
            protected String name;

            /**
             * Recupera il valore della proprietà value.
             * 
             * @return
             *     possible object is
             *     {@link BigDecimal }
             *     
             */
            public BigDecimal getValue() {
                return value;
            }

            /**
             * Imposta il valore della proprietà value.
             * 
             * @param value
             *     allowed object is
             *     {@link BigDecimal }
             *     
             */
            public void setValue(BigDecimal value) {
                this.value = value;
            }

            /**
             * Recupera il valore della proprietà name.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getName() {
                return name;
            }

            /**
             * Imposta il valore della proprietà name.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setName(String value) {
                this.name = value;
            }

        }

    }

}
