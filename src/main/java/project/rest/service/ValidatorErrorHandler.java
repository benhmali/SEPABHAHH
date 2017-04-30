package project.rest.service;

import org.xml.sax.ErrorHandler;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;

public class ValidatorErrorHandler implements ErrorHandler {

	private boolean errorOccured = false;

	public void warning(SAXParseException exception) throws SAXException {
		setErrorOccured(true);
		System.out.println("\nWARNING");
		System.err.println(exception.getMessage());
	}

	public void error(SAXParseException exception) throws SAXException {
		setErrorOccured(true);
		System.out.println("\nERROR");
		System.err.println(exception.getMessage());
	}

	public void fatalError(SAXParseException exception) throws SAXException {
		setErrorOccured(true);
		System.out.println("\nFATAL ERROR");
		System.err.println(exception.getMessage());
	}

	public boolean hasError() {
		return errorOccured;
	}

	public void setErrorOccured(boolean errorOccured) {
		this.errorOccured = errorOccured;
	}

}
