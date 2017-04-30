package project.rest.service;

import java.util.List;

import project.rest.model.Document;

public interface ISEPAService {

	public int getStats();

	public List<Document> getAllSepa();

	public Document getSepaById(String id);

	public Document addSepa(Document sepa);

}
