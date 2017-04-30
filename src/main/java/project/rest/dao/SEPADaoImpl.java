package project.rest.dao;

import java.util.List;

import javax.persistence.Query;

import project.rest.model.Document;
import project.rest.service.EntityManagerConnectionService;

public class SEPADaoImpl implements ISEPADao {

	public SEPADaoImpl() {
		EntityManagerConnectionService.getInstance();
	}

	@Override
	public String getStats() {
		String chaine;
		int nb_sepa = getAllSepa().size();
		int count = 0;
		for(Document doc : getAllSepa()){
			count += doc.getDirectDebitTransactionInformation().getInstructedAmount().getValue();
		}
		chaine = "Le nombre de transactions sont :"+Integer.toString(nb_sepa)+" et la somme =  "+ Integer.toString(count);
		return chaine;
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Document> getAllSepa() {
		EntityManagerConnectionService.getInstance().getTransaction().begin();
		Query query = EntityManagerConnectionService.getInstance().createQuery("select s from Document s");
		EntityManagerConnectionService.getInstance().getTransaction().commit();
		return query.getResultList();
	}

	@Override
	public Document getSepaById(String id) {
		EntityManagerConnectionService.getInstance().getTransaction().begin();
		Document sepa = EntityManagerConnectionService.getInstance().find(Document.class, Long.parseLong(id));
		EntityManagerConnectionService.getInstance().getTransaction().commit();
		return sepa;
	}

	@Override
	public Document addSepa(Document sepa) {
		try {
			EntityManagerConnectionService.getInstance().getTransaction().begin();
			EntityManagerConnectionService.getInstance().persist(sepa);
			EntityManagerConnectionService.getInstance().flush();
			EntityManagerConnectionService.getInstance().getTransaction().commit();
			return sepa;
		} catch (Exception e) {
			EntityManagerConnectionService.getInstance().getTransaction().rollback();
			return null;
		}

	}
}
