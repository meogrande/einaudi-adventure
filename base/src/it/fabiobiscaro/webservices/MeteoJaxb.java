package it.fabiobiscaro.webservices;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import it.fabiobiscaro.webservices.jaxb.Current;

public class MeteoJaxb {

	public static void main(String[] args) throws MalformedURLException {
		try {

			URL xmlFile = new URL(
					"http://samples.openweathermap.org/data/2.5/weather?q=treviso&mode=xml&appid=b1b15e88fa797225412429c1c50c122a1");
			
			JAXBContext jaxbContext = JAXBContext.newInstance(Current.class);

			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
			Current current = (Current) jaxbUnmarshaller.unmarshal(xmlFile);
			System.out.println(current.getCity().getCoord().getLat());

		} catch (JAXBException e) {
			e.printStackTrace();
		}

	}

}
