package project.rest.dao;

import java.util.List;

import project.rest.model.Document;

public interface ISEPADao {

public String getStats();
	
	public List<Document> getAllSepa();
	
	public Document getSepaById(String id);
	
	public Document addSepa(Document sepa);

}
