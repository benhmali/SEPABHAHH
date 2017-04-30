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
@XmlType(propOrder = { "id" })
@XmlAccessorType(XmlAccessType.FIELD)
public class DebtorAccount implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@XmlTransient
	private long idDebtorAccount;
	@XmlElement(name = "Id")
	@OneToOne(cascade = CascadeType.PERSIST)
	private CodeId id;

	public DebtorAccount() {
	}

	public DebtorAccount(CodeId id) {
		this.id = id;
	}

	public CodeId getId() {
		return id;
	}

	public void setId(CodeId id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "DebtorAccount [id=" + idDebtorAccount + ", id=" + id + "]";
	}

}
