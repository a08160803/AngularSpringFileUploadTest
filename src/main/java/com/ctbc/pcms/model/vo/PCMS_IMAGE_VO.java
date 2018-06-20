package com.ctbc.pcms.model.vo;

import java.io.Serializable;
import java.sql.Blob;

import javax.persistence.*;

@Entity
@Table(name = "PCMS_IMAGE")
public class PCMS_IMAGE_VO extends PCMS_BASIC_VO implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "SEQ")
	private Integer seq;

	@Column(name = "FLOW_BRANCH_IMAGE")
	private Blob flowBranchImage;

	@Column(name = "FLOW_MAIN_SEQ")
	private Integer flowMainSeq;

	public PCMS_IMAGE_VO() {
	}

	public Integer getSeq() {
		return seq;
	}

	public void setSeq(Integer seq) {
		this.seq = seq;
	}

	public Blob getFlowBranchImage() {
		return flowBranchImage;
	}

	public void setFlowBranchImage(Blob flowBranchImage) {
		this.flowBranchImage = flowBranchImage;
	}

	public Integer getFlowMainSeq() {
		return flowMainSeq;
	}

	public void setFlowMainSeq(Integer flowMainSeq) {
		this.flowMainSeq = flowMainSeq;
	}

}