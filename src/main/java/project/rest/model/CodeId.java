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
@XmlType(propOrder = { "IBAN"})
@XmlAccessorType(XmlAccessType.FIELD)
public class CodeId implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@XmlTransient
	private long id;
	@XmlElement(name="IBAN")
	private String IBAN;
	
	public CodeId() {
	}

	public String getIBAN() {
		return IBAN;
	}

	public void setIBAN(String iBAN) {
		IBAN = iBAN;
	}

	public CodeId(String iBAN) {
		IBAN = iBAN;
	}

	@Override
	public String toString() {
		return "CodeId [id=" + id + ", CodeId=" + IBAN + "]";
	}
	
	
}
