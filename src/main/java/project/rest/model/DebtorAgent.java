package project.rest.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;

@Entity
@XmlRootElement
@XmlType(propOrder = { "finalInstitutionIdentifier"})
@XmlAccessorType(XmlAccessType.FIELD)
public class DebtorAgent implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@XmlTransient
	private long id;
	@OneToOne(cascade = CascadeType.PERSIST)
	@XmlElement(name="FinInstnId")
	private FinalInstitutionIdentifier finalInstitutionIdentifier;
	
	public DebtorAgent() {
	}

	public DebtorAgent(FinalInstitutionIdentifier finalInstitutionIdentifier) {
		this.finalInstitutionIdentifier = finalInstitutionIdentifier;
	}

	public FinalInstitutionIdentifier getFinalInstitutionIdentifier() {
		return finalInstitutionIdentifier;
	}

	public void setFinalInstitutionIdentifier(FinalInstitutionIdentifier finalInstitutionIdentifier) {
		this.finalInstitutionIdentifier = finalInstitutionIdentifier;
	}

	@Override
	public String toString() {
		return "DebtorAgent [id=" + id + ", finalInstitutionIdentifier=" + finalInstitutionIdentifier + "]";
	}
	
	

}
