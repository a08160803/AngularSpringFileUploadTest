package com.ctbc.pcms.model.vo;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name = "PCMS_TRADT_SET")
public class PCMS_TRADE_SET_VO extends PCMS_BASIC_VO implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "SEQ")
	private Integer seq;

	@Column(name = "BUSINESS_ID")
	private String businessId;

	@Column(name = "TRADE_ID")
	private String tradeId;

	@Column(name = "TRADE_NAME")
	private String tradeName;

	public PCMS_TRADE_SET_VO() {
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

	public String getTradeId() {
		return tradeId;
	}

	public void setTradeId(String tradeId) {
		this.tradeId = tradeId;
	}

	public String getTradeName() {
		return tradeName;
	}

	public void setTradeName(String tradeName) {
		this.tradeName = tradeName;
	}

}