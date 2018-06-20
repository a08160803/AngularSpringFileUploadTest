package com.ctbc.pcms.model.vo;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name = "PCMS_FLOW_BRANCH")
public class PCMS_FLOW_BRANCH_VO extends PCMS_BASIC_VO implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "SEQ")
	private Integer seq;

	@Column(name = "BRANCH")
	private Integer branch;

	@Column(name = "DELIVERY_USER")
	private String deliveryUser;

	@Column(name = "FLOW_MAIN_SEQ")
	private Integer flowMainSeq;

	@Column(name = "PROCESS_USER")
	private String processUser;

	@Column(name = "TRADE_ID")
	private String tradeId;

	public PCMS_FLOW_BRANCH_VO() {
	}

	public Integer getSeq() {
		return seq;
	}

	public void setSeq(Integer seq) {
		this.seq = seq;
	}

	public Integer getBranch() {
		return branch;
	}

	public void setBranch(Integer branch) {
		this.branch = branch;
	}

	public String getDeliveryUser() {
		return deliveryUser;
	}

	public void setDeliveryUser(String deliveryUser) {
		this.deliveryUser = deliveryUser;
	}

	public Integer getFlowMainSeq() {
		return flowMainSeq;
	}

	public void setFlowMainSeq(Integer flowMainSeq) {
		this.flowMainSeq = flowMainSeq;
	}

	public String getProcessUser() {
		return processUser;
	}

	public void setProcessUser(String processUser) {
		this.processUser = processUser;
	}

	public String getTradeId() {
		return tradeId;
	}

	public void setTradeId(String tradeId) {
		this.tradeId = tradeId;
	}

}