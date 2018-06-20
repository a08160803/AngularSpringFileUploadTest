package com.ctbc.pcms.model.vo;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name = "PCMS_FLOW_MAIN")
public class PCMS_FLOW_MAIN_VO extends PCMS_BASIC_VO implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "SEQ")
	private Integer seq;

	@Column(name = "CUSTOMER_ID")
	private String customerId;

	@Column(name = "CUSTOMER_NAME")
	private String customerName;

	@Column(name = "BUSINESS_ID")
	private String businessId;

	@Column(name = "BUSINESS_SEQ")
	private Integer businessSeq;

	@Column(name = "DEP_ID")
	private String depId;

	@Column(name = "ROC_DATE")
	private String rocDate;

	public PCMS_FLOW_MAIN_VO() {
	}

	public Integer getSeq() {
		return seq;
	}

	public void setSeq(Integer seq) {
		this.seq = seq;
	}

	public String getBusinessId() {
		return businessId;
	}

	public void setBusinessId(String businessId) {
		this.businessId = businessId;
	}

	public Integer getBusinessSeq() {
		return businessSeq;
	}

	public void setBusinessSeq(Integer businessSeq) {
		this.businessSeq = businessSeq;
	}

	public String getDepId() {
		return depId;
	}

	public void setDepId(String depId) {
		this.depId = depId;
	}

	public String getRocDate() {
		return rocDate;
	}

	public void setRocDate(String rocDate) {
		this.rocDate = rocDate;
	}

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

}