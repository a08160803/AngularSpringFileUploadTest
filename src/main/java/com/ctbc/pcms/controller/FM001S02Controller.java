package com.ctbc.pcms.controller;

import java.util.HashMap;
import java.util.Map;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ctbc.pcms.model.dao.CommonFlowDao;
import com.ctbc.pcms.model.vo.PCMS_FLOW_BRANCH_VO;
import com.ctbc.pcms.model.vo.PCMS_FLOW_MAIN_VO;

import util.JsonHelper;

@Controller
public class FM001S02Controller {

	@Autowired
	private CommonFlowDao commonFlowDao;

	@RequestMapping(value = "/FM001S02/incoming", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> incoming(@RequestBody String requestJson) throws JSONException {
		Map<String, Object> requestMap = JsonHelper.toMap(new JSONObject(requestJson));

		String customerId = (String) requestMap.get("customerId");
		String customerName = (String) requestMap.get("customerName");
		String depId = (String) requestMap.get("depId");
		String rocDate = (String) requestMap.get("rocDate");
		String businessId = (String) requestMap.get("businessId");

		Integer businessSeq = commonFlowDao.getMaxBusinessSeq(depId, rocDate, businessId) + 1;

		PCMS_FLOW_MAIN_VO pcmsFlowMainVO = new PCMS_FLOW_MAIN_VO();
		pcmsFlowMainVO.setCustomerId(customerId);
		pcmsFlowMainVO.setCustomerName(customerName);
		pcmsFlowMainVO.setDepId(depId);
		pcmsFlowMainVO.setRocDate(rocDate);
		pcmsFlowMainVO.setBusinessId(businessId);
		pcmsFlowMainVO.setBusinessSeq(businessSeq);
		pcmsFlowMainVO.setStatus("0");
		commonFlowDao.insertPcmsFlowMain(pcmsFlowMainVO);

		String tradeId = commonFlowDao.getIncomingTradeId(businessId, 1);
		PCMS_FLOW_BRANCH_VO pcmsFlowBranchVO = new PCMS_FLOW_BRANCH_VO();
		pcmsFlowBranchVO.setFlowMainSeq(pcmsFlowMainVO.getSeq());
		pcmsFlowBranchVO.setTradeId(tradeId);
		pcmsFlowBranchVO.setDeliveryUser("Z00040150");
		pcmsFlowBranchVO.setProcessUser("Z00040150");
		pcmsFlowBranchVO.setBranch(1);
		pcmsFlowBranchVO.setStatus("1");
		commonFlowDao.insertPcmsFlowBranch(pcmsFlowBranchVO);

		// ----------- AOP ------------
//		commonFlowDao.closeFlowBranch(pcmsFlowBranchVO.getSeq());
		PCMS_FLOW_BRANCH_VO pcmsFlowBranchVO2 = new PCMS_FLOW_BRANCH_VO();
		Integer newbranch = commonFlowDao.getLastClosedBranch(pcmsFlowMainVO.getSeq(), pcmsFlowBranchVO.getTradeId()) + 1;
		tradeId = commonFlowDao.getIncomingTradeId(businessId, 2);
		pcmsFlowBranchVO2.setFlowMainSeq(pcmsFlowMainVO.getSeq());
		pcmsFlowBranchVO2.setTradeId(tradeId);
		pcmsFlowBranchVO2.setDeliveryUser("Z00040150");
		pcmsFlowBranchVO2.setProcessUser(null);
		pcmsFlowBranchVO2.setBranch(newbranch);
		pcmsFlowBranchVO2.setStatus("0");
		commonFlowDao.insertPcmsFlowBranch(pcmsFlowBranchVO2);
		
		pcmsFlowMainVO.setBranch(newbranch);
		commonFlowDao.updatePcmsFlowMain(pcmsFlowMainVO);
		// -----------------------------

		Map<String, Object> responseMap = new HashMap<String, Object>();
		responseMap.put("flowMainSeq", pcmsFlowMainVO.getSeq());
		responseMap.put("flowBranchSeq", pcmsFlowBranchVO2.getSeq());
		responseMap.put("tradeId", pcmsFlowBranchVO2.getTradeId());
		responseMap.put("businessId", pcmsFlowMainVO.getBusinessId());

		return responseMap;
	}

}
