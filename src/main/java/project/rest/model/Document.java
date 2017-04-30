package project.rest.model;

import java.io.Serializable;
import java.text.DecimalFormat;
import java.text.Format;
import java.text.NumberFormat;
import java.util.Formatter;

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
@XmlRootElement(name = "Document")
@XmlType(propOrder = { "directDebitTransactionInformation"})
@XmlAccessorType(XmlAccessType.FIELD)
public class Document implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@XmlTransient
	private long id;
	@XmlElement(name = "DrctDbtTxInf")
	@OneToOne(cascade = CascadeType.PERSIST)
	private DirectDebitTransactionInformation directDebitTransactionInformation;

	public Document() {
	}

	public Document(DirectDebitTransactionInformation directDebitTransactionInformation) {

		this.directDebitTransactionInformation = directDebitTransactionInformation;
	}

	public DirectDebitTransactionInformation getDirectDebitTransactionInformation() {
		return directDebitTransactionInformation;
	}

	public void setDirectDebitTransactionInformation(
			DirectDebitTransactionInformation directDebitTransactionInformation) {
		this.directDebitTransactionInformation = directDebitTransactionInformation;
	}

	@Override
	public String toString() {
		return "Document [id=" + id + ", directDebitTransactionInformation=" + directDebitTransactionInformation + "]";
	}

}
