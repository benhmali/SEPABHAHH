package project.rest.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlValue;

@Entity
@XmlRootElement
@XmlType(propOrder = { "Ccy","value"})
@XmlAccessorType(XmlAccessType.FIELD)
public class InstructedAmount implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@XmlTransient
	private long id;
	@XmlAttribute(name="Ccy")
	private String Ccy;
	@XmlValue
	private double value;
	
	public InstructedAmount() {
	}

	public InstructedAmount(String ccy, double value) {
		
		Ccy = ccy;
		this.value = value;
	}

	public String getCcy() {
		return Ccy;
	}

	public void setCcy(String ccy) {
		Ccy = ccy;
	}

	public double getValue() {
		return value;
	}

	public void setValue(double value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return "InstructedAmount [id=" + id + ", Ccy=" + Ccy + ", value=" + value + "]";
	}

	

}
