package com.ctbc.pcms.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ctbc.pcms.model.dao.BaseDao;
import com.ctbc.pcms.model.vo.CTBC_DEP_VO;
import com.ctbc.pcms.model.vo.CTBC_EMPLOYEE_VO;
import com.ctbc.pcms.model.vo.PCMS_BUSINESS_SET_VO;
import com.ctbc.pcms.model.vo.PCMS_TRADE_SET_VO;

@Controller
public class BaseController {

	@Autowired
	private BaseDao baseDao;

	@RequestMapping(value = "/initDB", method = RequestMethod.POST)
	@ResponseBody
	@Transactional
	public Map<String, Object> initDB() {
		CTBC_DEP_VO ctbcDepVO = new CTBC_DEP_VO();
		ctbcDepVO.setDepId("0901");
		ctbcDepVO.setDepName("應用系統部資訊開發三科");
		baseDao.insertInitData(ctbcDepVO);

		CTBC_EMPLOYEE_VO ctbcEmployeeVO = new CTBC_EMPLOYEE_VO();
		ctbcEmployeeVO.setEmpName("Z00040150");
		ctbcEmployeeVO.setDepId("0901");
		baseDao.insertInitData(ctbcEmployeeVO);

		PCMS_BUSINESS_SET_VO pcmsBusinessSetVO = new PCMS_BUSINESS_SET_VO();
		pcmsBusinessSetVO.setBusinessId("001");
		pcmsBusinessSetVO.setBusinessName("簡易開戶");
		baseDao.insertInitData(pcmsBusinessSetVO);
		
		pcmsBusinessSetVO.setBusinessId("003");
		pcmsBusinessSetVO.setBusinessName("開戶審查");
		baseDao.insertInitData(pcmsBusinessSetVO);

		PCMS_TRADE_SET_VO pcmsTradeSetVO = new PCMS_TRADE_SET_VO();
		pcmsTradeSetVO.setBusinessId("001");
		pcmsTradeSetVO.setTradeId("0001");
		pcmsTradeSetVO.setTradeName("案件進件");
		baseDao.insertInitData(pcmsTradeSetVO);
		pcmsTradeSetVO.setBusinessId("001");
		pcmsTradeSetVO.setTradeId("0003");
		pcmsTradeSetVO.setTradeName("案件審查");
		baseDao.insertInitData(pcmsTradeSetVO);
		pcmsTradeSetVO.setBusinessId("001");
		pcmsTradeSetVO.setTradeId("0007");
		pcmsTradeSetVO.setTradeName("主管放行");
		baseDao.insertInitData(pcmsTradeSetVO);
		
		pcmsTradeSetVO.setBusinessId("003");
		pcmsTradeSetVO.setTradeId("0001");
		pcmsTradeSetVO.setTradeName("案件進件");
		baseDao.insertInitData(pcmsTradeSetVO);
		pcmsTradeSetVO.setBusinessId("003");
		pcmsTradeSetVO.setTradeId("0002");
		pcmsTradeSetVO.setTradeName("案件審查");
		baseDao.insertInitData(pcmsTradeSetVO);
		pcmsTradeSetVO.setBusinessId("003");
		pcmsTradeSetVO.setTradeId("0003");
		pcmsTradeSetVO.setTradeName("結果覆核");
		baseDao.insertInitData(pcmsTradeSetVO);
		
		Map<String, Object> responseMap = new HashMap<String, Object>();
		responseMap.put("success", "success");
		return responseMap;
	}

}
