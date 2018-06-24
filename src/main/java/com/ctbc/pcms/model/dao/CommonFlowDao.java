package com.ctbc.pcms.model.dao;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ctbc.pcms.model.vo.PCMS_FLOW_BRANCH_VO;
import com.ctbc.pcms.model.vo.PCMS_FLOW_MAIN_VO;

@Repository
public class CommonFlowDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Transactional(readOnly = true)
	public Integer getMaxBusinessSeq(String depId, String rocDate, String businessId) {
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		Integer maxBusinessSeq;
		String sql = "SELECT MAX(BUSINESS_SEQ) " + "FROM PCMS_FLOW_MAIN "
				+ "WHERE DEP_ID = :DEP_ID AND ROC_DATE = :ROC_DATE AND BUSINESS_ID = :BUSINESS_ID";

		SQLQuery query = session.createSQLQuery(sql);
		query.setParameter("DEP_ID", depId);
		query.setParameter("ROC_DATE", rocDate);
		query.setParameter("BUSINESS_ID", businessId);

		if (query.uniqueResult() == null) {
			maxBusinessSeq = 0;
		} else {
			maxBusinessSeq = (Integer) query.uniqueResult();
		}

		session.getTransaction().commit();

		return maxBusinessSeq;
	}

	@Transactional
	public void insertPcmsFlowMain(PCMS_FLOW_MAIN_VO pcmsFlowMainVO) {
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		session.save(pcmsFlowMainVO);
		session.getTransaction().commit();
	}

	@Transactional(readOnly = true)
	public String getIncomingTradeId(String businessId, Integer specifyNumber) {
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();

		String sql = "SELECT TOP 1 TRADE_ID FROM "
				+ "(SELECT TOP (:specifyNumber) * FROM PCMS_TRADT_SET WHERE BUSINESS_ID = :BUSINESS_ID ORDER BY SEQ ASC) temp1 "
				+ "ORDER BY SEQ DESC";

		SQLQuery query = session.createSQLQuery(sql);
		query.setParameter("specifyNumber", specifyNumber);
		query.setParameter("BUSINESS_ID", businessId);
		String tradeId = (String) query.uniqueResult();
		session.getTransaction().commit();

		return tradeId;
	}

	@Transactional
	public void insertPcmsFlowBranch(PCMS_FLOW_BRANCH_VO pcmsFlowBranchVO) {
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		session.save(pcmsFlowBranchVO);
		session.getTransaction().commit();
	}

	@Transactional(readOnly = true)
	public Integer getLastClosedBranch(Integer flowMainSeq, String tradeId) {
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();

		String sql = "SELECT TOP 1 BRANCH " 
				+ "FROM PCMS_FLOW_BRANCH "
				+ "WHERE FLOW_MAIN_SEQ = :FLOW_MAIN_SEQ AND TRADE_ID = :TRADE_ID AND STATUS = :STATUS ORDER BY SEQ DESC";

		SQLQuery query = session.createSQLQuery(sql);
		query.setParameter("FLOW_MAIN_SEQ", flowMainSeq);
		query.setParameter("TRADE_ID", tradeId);
		query.setParameter("STATUS", "1");
		
		Integer branch = (Integer) query.uniqueResult();
		session.getTransaction().commit();
		return branch;
	}
	
	@Transactional
	public void updatePcmsFlowMain(PCMS_FLOW_MAIN_VO pcmsFlowMainVO) {
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		session.saveOrUpdate(pcmsFlowMainVO);
		session.getTransaction().commit();
	}
	
	@Transactional
	public void closeFlowBranch(Integer flowBranchSeq) {
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		PCMS_FLOW_BRANCH_VO pcmsFlowBranchVO = (PCMS_FLOW_BRANCH_VO) session.get(PCMS_FLOW_BRANCH_VO.class, flowBranchSeq);
		pcmsFlowBranchVO.setStatus("1");
		session.saveOrUpdate(pcmsFlowBranchVO);
		session.getTransaction().commit();
	}

}
