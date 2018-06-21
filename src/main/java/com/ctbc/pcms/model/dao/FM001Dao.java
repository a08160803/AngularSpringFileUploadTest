package com.ctbc.pcms.model.dao;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ctbc.pcms.model.vo.PCMS_FLOW_MAIN_VO;

@Repository
public class FM001Dao {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Transactional
	public void insert(Integer max) {
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		PCMS_FLOW_MAIN_VO pcmsFlowMainVO = new PCMS_FLOW_MAIN_VO();
		pcmsFlowMainVO.setCustomerName("AAAA");
		pcmsFlowMainVO.setBusinessSeq(max+1);
		session.save(pcmsFlowMainVO);
		session.getTransaction().commit();
	}
	
	@Transactional
	public void insert2(Integer max) {
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		PCMS_FLOW_MAIN_VO pcmsFlowMainVO = new PCMS_FLOW_MAIN_VO();
		pcmsFlowMainVO.setCustomerName("BBBB");
		pcmsFlowMainVO.setBusinessSeq(max+1);
		session.save(pcmsFlowMainVO);
		session.getTransaction().commit();
	}
	
	public Integer selectMax() {
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		Integer max;
		
		SQLQuery query = session.createSQLQuery("SELECT MAX(BUSINESS_SEQ) FROM PCMS_FLOW_MAIN");
		if (query.uniqueResult() == null) {
			max = 0;
		} else {
			max = (Integer) query.uniqueResult();
		}
		System.out.println("max >>>>>>>> " + max);
		
		session.getTransaction().commit();
		
		return max;
	}
	
}
