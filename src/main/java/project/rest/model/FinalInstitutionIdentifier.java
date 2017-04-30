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
@XmlType(propOrder = { "BIC"})
@XmlAccessorType(XmlAccessType.FIELD)
public class FinalInstitutionIdentifier implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@XmlTransient
	private long id;
	@XmlElement(name="BIC")
	private String BIC;
	public FinalInstitutionIdentifier() {
	}
	public FinalInstitutionIdentifier(String bIC) {
		BIC = bIC;
	}
	public String getBIC() {
		return BIC;
	}
	public void setBIC(String bIC) {
		BIC = bIC;
	}
	@Override
	public String toString() {
		return "FinalInstitutionIdentifier [id=" + id + ", BIC=" + BIC + "]";
	}
	
	

}
