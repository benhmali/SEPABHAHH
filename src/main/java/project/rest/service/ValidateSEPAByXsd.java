package project.rest.service;

import java.io.File;
import java.io.IOException;

import javax.xml.XMLConstants;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.util.JAXBSource;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;

import org.xml.sax.SAXException;

import project.rest.model.Document;

public class ValidateSEPAByXsd {

	public static boolean isValid(Document sepa) {
		ValidatorErrorHandler veh = new ValidatorErrorHandler();

		try {
			SchemaFactory sf = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
			Source schemaFile = new StreamSource(
					new File(ValidateSEPAByXsd.class.getClassLoader().getResource("sepa.xsd").getPath()));
			Schema schema = sf.newSchema(schemaFile);

			JAXBContext jc = JAXBContext.newInstance(Document.class);
			JAXBSource source = new JAXBSource(jc, sepa);

			Validator validator = schema.newValidator();
			validator.setErrorHandler(veh);
			validator.validate(source);
		} catch (JAXBException | SAXException | IOException e) {
			System.out.println(e.getMessage());
			e.getStackTrace();
		}

		return !veh.hasError();
	}
}
