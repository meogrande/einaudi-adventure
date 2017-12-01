//
// Questo file è stato generato dall'architettura JavaTM per XML Binding (JAXB) Reference Implementation, v2.2.8-b130911.1802 
// Vedere <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Qualsiasi modifica a questo file andrà persa durante la ricompilazione dello schema di origine. 
// Generato il: 2017.12.01 alle 01:07:12 PM CET 
//


package it.fabiobiscaro.webservices.jaxb;

import javax.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the it.fabiobiscaro.webservices package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {


    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: it.fabiobiscaro.webservices
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Current }
     * 
     */
    public Current createCurrent() {
        return new Current();
    }

    /**
     * Create an instance of {@link Current.Wind }
     * 
     */
    public Current.Wind createCurrentWind() {
        return new Current.Wind();
    }

    /**
     * Create an instance of {@link Current.City }
     * 
     */
    public Current.City createCurrentCity() {
        return new Current.City();
    }

    /**
     * Create an instance of {@link Current.Temperature }
     * 
     */
    public Current.Temperature createCurrentTemperature() {
        return new Current.Temperature();
    }

    /**
     * Create an instance of {@link Current.Humidity }
     * 
     */
    public Current.Humidity createCurrentHumidity() {
        return new Current.Humidity();
    }

    /**
     * Create an instance of {@link Current.Pressure }
     * 
     */
    public Current.Pressure createCurrentPressure() {
        return new Current.Pressure();
    }

    /**
     * Create an instance of {@link Current.Clouds }
     * 
     */
    public Current.Clouds createCurrentClouds() {
        return new Current.Clouds();
    }

    /**
     * Create an instance of {@link Current.Visibility }
     * 
     */
    public Current.Visibility createCurrentVisibility() {
        return new Current.Visibility();
    }

    /**
     * Create an instance of {@link Current.Precipitation }
     * 
     */
    public Current.Precipitation createCurrentPrecipitation() {
        return new Current.Precipitation();
    }

    /**
     * Create an instance of {@link Current.Weather }
     * 
     */
    public Current.Weather createCurrentWeather() {
        return new Current.Weather();
    }

    /**
     * Create an instance of {@link Current.Lastupdate }
     * 
     */
    public Current.Lastupdate createCurrentLastupdate() {
        return new Current.Lastupdate();
    }

    /**
     * Create an instance of {@link Current.Wind.Speed }
     * 
     */
    public Current.Wind.Speed createCurrentWindSpeed() {
        return new Current.Wind.Speed();
    }

    /**
     * Create an instance of {@link Current.Wind.Direction }
     * 
     */
    public Current.Wind.Direction createCurrentWindDirection() {
        return new Current.Wind.Direction();
    }

    /**
     * Create an instance of {@link Current.City.Coord }
     * 
     */
    public Current.City.Coord createCurrentCityCoord() {
        return new Current.City.Coord();
    }

    /**
     * Create an instance of {@link Current.City.Sun }
     * 
     */
    public Current.City.Sun createCurrentCitySun() {
        return new Current.City.Sun();
    }

}
