package com.ctbc.pcms.model.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ctbc.pcms.model.vo.PCMS_BASIC_VO;

@Repository
public class BaseDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Transactional
	public void insertInitData(PCMS_BASIC_VO pcmsBasicVO) {
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();

		String system = "system";
		pcmsBasicVO.setCreateUser(system);
		pcmsBasicVO.setModifyUser(system);
		session.save(pcmsBasicVO);
		
		session.getTransaction().commit();
	}
}
