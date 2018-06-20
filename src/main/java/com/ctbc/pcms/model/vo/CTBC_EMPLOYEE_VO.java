package com.ctbc.pcms.model.vo;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name = "CTBC_EMPLOYEE")
public class CTBC_EMPLOYEE_VO extends PCMS_BASIC_VO implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "SEQ")
	private Integer seq;

	@Column(name = "DEP_ID")
	private String depId;

	@Column(name = "EMP_NAME")
	private String empName;

	public CTBC_EMPLOYEE_VO() {
	}

	public Integer getSeq() {
		return seq;
	}

	public void setSeq(Integer seq) {
		this.seq = seq;
	}

	public String getDepId() {
		return depId;
	}

	public void setDepId(String depId) {
		this.depId = depId;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

}