package com.ctbc.pcms.model.vo;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name = "PCMS_BUSINESS_SET")
public class PCMS_BUSINESS_SET_VO extends PCMS_BASIC_VO implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "SEQ")
	private Integer seq;

	@Column(name = "BUSINESS_ID")
	private String businessId;

	@Column(name = "BUSINESS_NAME")
	private String businessName;

	public PCMS_BUSINESS_SET_VO() {
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

	public String getBusinessName() {
		return businessName;
	}

	public void setBusinessName(String businessName) {
		this.businessName = businessName;
	}

}