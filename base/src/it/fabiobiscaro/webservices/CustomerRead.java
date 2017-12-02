package it.fabiobiscaro.webservices;

import java.net.URL;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import it.fabiobiscaro.webservices.jaxb.Customer;

public class CustomerRead {
	public static void main(String[] args) {

		try {

			// Creo un URL con il percorso del file (web o fisico)
			URL file = CustomerRead.class.getResource("customer.xml");
			// Inizializzo l'interprete jaxb dell'xml customer
			JAXBContext jaxbContext = JAXBContext.newInstance(Customer.class);
			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
			Customer customer = (Customer) jaxbUnmarshaller.unmarshal(file);
			// Stampo L'età (posso stampare qualunque attributo/nodo)
			System.out.println(customer.getAge());

		} catch (JAXBException e) {
			e.printStackTrace();
		}

	}
}
