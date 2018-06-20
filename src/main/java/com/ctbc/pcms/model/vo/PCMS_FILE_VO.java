package com.ctbc.pcms.model.vo;

import java.io.Serializable;
import java.sql.Clob;

import javax.persistence.*;

@Entity
@Table(name = "PCMS_FLIE")
public class PCMS_FILE_VO extends PCMS_BASIC_VO implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "SEQ")
	private Integer seq;

	@Column(name = "FLOW_BRANCH_FILE")
	private Clob flowBranchFile;

	@Column(name = "FLOW_MAIN_SEQ")
	private Integer flowMainSeq;

	public PCMS_FILE_VO() {
	}

	public Integer getSeq() {
		return seq;
	}

	public void setSeq(Integer seq) {
		this.seq = seq;
	}

	public Clob getFlowBranchFile() {
		return flowBranchFile;
	}

	public void setFlowBranchFile(Clob flowBranchFile) {
		this.flowBranchFile = flowBranchFile;
	}

	public Integer getFlowMainSeq() {
		return flowMainSeq;
	}

	public void setFlowMainSeq(Integer flowMainSeq) {
		this.flowMainSeq = flowMainSeq;
	}

}