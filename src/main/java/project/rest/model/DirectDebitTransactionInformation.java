package project.rest.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
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
@XmlType(propOrder = { "paymentIdentification", "instructedAmount", "directDebitTransaction" , "debtorAgent" , "debtor", "debtorAccount", "remittanceInformation" })
@XmlAccessorType(XmlAccessType.FIELD)
public class DirectDebitTransactionInformation implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@XmlTransient
	private long id;
	@XmlElement(name="PmtId")
	@Column(unique=true)
	private String paymentIdentification;
	@OneToOne(cascade = CascadeType.PERSIST)
	@XmlElement(name="InstdAmt")
	private InstructedAmount instructedAmount;
	@OneToOne(cascade = CascadeType.PERSIST)
	@XmlElement(name="DrctDbtTx")
	private DirectDebitTransaction directDebitTransaction;;
	@OneToOne(cascade = CascadeType.PERSIST)
	@XmlElement(name="DbtrAgt")
	private DebtorAgent debtorAgent;
	@OneToOne(cascade = CascadeType.PERSIST)
	@XmlElement(name = "Dbtr")
	private Debtor debtor;
	@OneToOne(cascade = CascadeType.PERSIST)
	@XmlElement(name="DbtrAcct")
	private DebtorAccount debtorAccount;
	@XmlElement(name="RmtInf")
	private String remittanceInformation;
	
	public DirectDebitTransactionInformation() {
	}

	public DirectDebitTransactionInformation(String paymentIdentification, InstructedAmount instructedAmount,
			DirectDebitTransaction directDebitTransaction, DebtorAgent debtorAgent, Debtor debtor,
			DebtorAccount debtorAccount, String remittanceInformation) {
		
		this.paymentIdentification = paymentIdentification;
		this.instructedAmount = instructedAmount;
		this.directDebitTransaction = directDebitTransaction;
		this.debtorAgent = debtorAgent;
		this.debtor = debtor;
		this.debtorAccount = debtorAccount;
		this.remittanceInformation = remittanceInformation;
	}

	public String getPaymentIdentification() {
		return paymentIdentification;
	}

	public void setPaymentIdentification(String paymentIdentification) {
		this.paymentIdentification = paymentIdentification;
	}

	public InstructedAmount getInstructedAmount() {
		return instructedAmount;
	}

	public void setInstructedAmount(InstructedAmount instructedAmount) {
		this.instructedAmount = instructedAmount;
	}

	public DirectDebitTransaction getDirectDebitTransaction() {
		return directDebitTransaction;
	}

	public void setDirectDebitTransaction(DirectDebitTransaction directDebitTransaction) {
		this.directDebitTransaction = directDebitTransaction;
	}

	public DebtorAgent getDebtorAgent() {
		return debtorAgent;
	}

	public void setDebtorAgent(DebtorAgent debtorAgent) {
		this.debtorAgent = debtorAgent;
	}

	public Debtor getDebtor() {
		return debtor;
	}

	public void setDebtor(Debtor debtor) {
		this.debtor = debtor;
	}

	public DebtorAccount getDebtorAccount() {
		return debtorAccount;
	}

	public void setDebtorAccount(DebtorAccount debtorAccount) {
		this.debtorAccount = debtorAccount;
	}

	public String getRemittanceInformation() {
		return remittanceInformation;
	}

	public void setRemittanceInformation(String remittanceInformation) {
		this.remittanceInformation = remittanceInformation;
	}

	@Override
	public String toString() {
		return "DirectDebitTransactionInformation [id=" + id + ", paymentIdentification=" + paymentIdentification
				+ ", instructedAmount=" + instructedAmount + ", directDebitTransaction=" + directDebitTransaction
				+ ", debtorAgent=" + debtorAgent + ", debtor=" + debtor + ", debtorAccount=" + debtorAccount
				+ ", remittanceInformation=" + remittanceInformation + "]";
	}


	

}
