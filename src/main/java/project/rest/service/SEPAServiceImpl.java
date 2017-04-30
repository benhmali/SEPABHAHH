package project.rest.service;

import java.util.List;

import project.rest.dao.ISEPADao;
import project.rest.dao.SEPADaoImpl;
import project.rest.model.Document;

public class SEPAServiceImpl implements ISEPAService {

	ISEPADao dao;

	public SEPAServiceImpl() {
		dao = new SEPADaoImpl();
	}

	@Override
	public int getStats() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Document> getAllSepa() {
		return dao.getAllSepa();
	}

	@Override
	public Document getSepaById(String id) {
		return dao.getSepaById(id);
	}

	@Override
	public Document addSepa(Document sepa) {
		return dao.addSepa(sepa);
	}

}
