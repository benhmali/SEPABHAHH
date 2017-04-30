package project.rest.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import project.rest.model.Document;
import project.rest.service.EntityManagerConnectionService;
import project.rest.service.ISEPAService;
import project.rest.service.SEPAServiceImpl;

@RestController
public class SEPAController {

	ISEPAService service;

	public SEPAController() {
		service = new SEPAServiceImpl();
		EntityManagerConnectionService.setPath(getClass().getClassLoader().getResource("META-INF/persistence.xml").getPath());
		EntityManagerConnectionService.getInstance();
	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<String> acceuil() {
		return new ResponseEntity<String>("Ben Hmida Ali & Hfidhi Hajer "
				+ "30/04/2017", HttpStatus.OK);
	}

	@RequestMapping(value = "/stats", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<String> getSynthese() {
		return new ResponseEntity<String>(Integer.toString(service.getStats()), HttpStatus.OK);
	}

	@RequestMapping(value = "/trx/{id}", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<Document> getSepaById(@PathVariable("id") String id) {
		try {
			Document sepa = service.getSepaById(id);
			if (sepa != null)
				return new ResponseEntity<Document>(sepa, HttpStatus.OK);

			return new ResponseEntity<Document>(HttpStatus.NOT_FOUND);
		} catch (Exception e) {
			System.err.println(e.getMessage());
			return new ResponseEntity<Document>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@RequestMapping(value = "/depot", method = RequestMethod.POST)
	public ResponseEntity<String> depotSepa(@RequestBody Document sepa) {
		System.out.println("ahla bkhouya");
		try {

			System.out.println(sepa.toString());

			sepa = service.addSepa(sepa);
			return new ResponseEntity<String>("", HttpStatus.OK);
		} catch (Exception e) {
			System.err.println(e.getMessage());
			System.err.println(e.getStackTrace());

			return new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
