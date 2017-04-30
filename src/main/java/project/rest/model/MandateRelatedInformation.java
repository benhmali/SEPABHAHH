package project.rest.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;

@Entity
@XmlRootElement
@XmlType(propOrder = { "mandateIdentifier","dateOfSignature"})
@XmlAccessorType(XmlAccessType.FIELD)
public class MandateRelatedInformation implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@XmlTransient
	private long id;
	@XmlElement(name="MndtId")
	private String mandateIdentifier;
	@XmlElement(name="DtOfSgntr")
	private String dateOfSignature;
	
	public MandateRelatedInformation() {
	}

	public MandateRelatedInformation(String mandateIdentifier, String dateOfSignature) {
		this.mandateIdentifier = mandateIdentifier;
		this.dateOfSignature = dateOfSignature;
	}

	public String getMandateIdentifier() {
		return mandateIdentifier;
	}

	public void setMandateIdentifier(String mandateIdentifier) {
		this.mandateIdentifier = mandateIdentifier;
	}

	public String getDateOfSignature() {
		return dateOfSignature;
	}

	public void setDateOfSignature(String dateOfSignature) {
		this.dateOfSignature = dateOfSignature;
	}

	@Override
	public String toString() {
		return "MandateRelatedInformation [id=" + id + ", mandateIdentifier=" + mandateIdentifier + ", dateOfSignature="
				+ dateOfSignature + "]";
	}
	
	
	

}
