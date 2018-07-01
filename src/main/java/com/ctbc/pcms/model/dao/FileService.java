package com.ctbc.pcms.model.dao;

import java.io.IOException;
import java.sql.Blob;

import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ctbc.pcms.model.vo.PCMS_DOC_FILE_VO;

@Service("fileUploadService")
public class FileService {

	@Autowired
	private SessionFactory sessionFactory;

	@Transactional
	public void insertPcmsImage(byte[] bytes, Integer flowMainSeq) throws IOException {
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		// byte[] bytes = IOUtils.toByteArray(inputStream);
		Blob flowBranchImage = Hibernate.getLobCreator(session).createBlob(bytes);

		PCMS_DOC_FILE_VO pcmsDocFileVO = new PCMS_DOC_FILE_VO();
		pcmsDocFileVO.setDocInfoSeq(flowMainSeq);
		pcmsDocFileVO.setDocContent(flowBranchImage);

		session.save(pcmsDocFileVO);
		session.getTransaction().commit();
	}
	
	public Blob fileDownload(Integer flowMainSeq) {
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		
		String sql = "SELECT pdf.* "
				+ "FROM PCMS_DOC_INFO pdi "
				+ "LEFT JOIN PCMS_DOC_FILE pdf ON pdi.SEQ = pdf.DOC_INFO_SEQ "
				+ "WHERE pdi.FLOW_MAIN_SEQ = :FLOW_MAIN_SEQ";
		Query query = session.createSQLQuery(sql).addEntity(PCMS_DOC_FILE_VO.class).setParameter("FLOW_MAIN_SEQ", flowMainSeq);
		PCMS_DOC_FILE_VO pcmsDocFileVO = (PCMS_DOC_FILE_VO) query.uniqueResult();
		session.getTransaction().commit();
		if (pcmsDocFileVO != null) {
			return pcmsDocFileVO.getDocContent();
		}
		return null;
	}

}
