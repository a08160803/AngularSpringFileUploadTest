package com.ctbc.pcms.model.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ctbc.pcms.model.vo.PCMS_BUSINESS_SET_VO;

@Repository
public class FM001Dao {

	@Autowired
	private SessionFactory sessionFactory;
	
	public void insert() {
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		PCMS_BUSINESS_SET_VO pcmsBusinessSetVO = new PCMS_BUSINESS_SET_VO();
		pcmsBusinessSetVO.setBusinessId("003");
		pcmsBusinessSetVO.setBusinessName("幹你老師3");
		session.save(pcmsBusinessSetVO);
		session.getTransaction().commit();
	}
	
}
