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
@XmlType(propOrder = { "mandateRelatedInformation"})
@XmlAccessorType(XmlAccessType.FIELD)
public class DirectDebitTransaction implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@XmlTransient
	private long id;
	@OneToOne(cascade = CascadeType.PERSIST)
	@XmlElement(name="MndtRltdInf")
	private MandateRelatedInformation mandateRelatedInformation;
	
	public DirectDebitTransaction() {
	}

	public DirectDebitTransaction(MandateRelatedInformation mandateRelatedInformation) {
		this.mandateRelatedInformation = mandateRelatedInformation;
	}

	public MandateRelatedInformation getMandateRelatedInformation() {
		return mandateRelatedInformation;
	}

	public void setMandateRelatedInformation(MandateRelatedInformation mandateRelatedInformation) {
		this.mandateRelatedInformation = mandateRelatedInformation;
	}

	@Override
	public String toString() {
		return "DirectDebitTransaction [id=" + id + ", mandateRelatedInformation=" + mandateRelatedInformation + "]";
	}
	

}
