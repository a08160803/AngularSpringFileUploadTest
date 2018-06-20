package com.ctbc.pcms.controller;

import java.io.BufferedReader;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ctbc.pcms.model.dao.FM001Dao;
import com.ctbc.pcms.model.vo.PCMS_FLOW_MAIN_VO;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

@Controller
public class FM001Controller {

	@Autowired
	private FM001Dao fm001Dao;

//	@RequestMapping(value = "/fileupload", method = RequestMethod.POST)
//	@ResponseBody
//	public String fileupload(HttpServletRequest request, HttpServletResponse response) throws JSONException {
//		StringBuffer jb = new StringBuffer();
//		String line = null;
//		try {
//			BufferedReader reader = request.getReader();
//			while ((line = reader.readLine()) != null)
//				jb.append(line);
//		} catch (Exception e) {
//
//		}
//
//		fm001Dao.insert();
//
		// String path = "";
		// CommonsMultipartResolver commonsMultipartResolver = new
		// CommonsMultipartResolver(
		// request.getSession().getServletContext());
		//
		// if (commonsMultipartResolver.isMultipart(request)) {
		// MultipartHttpServletRequest multipartHttpServletRequest =
		// (MultipartHttpServletRequest) request;
		// Iterator<String> iter = multipartHttpServletRequest.getFileNames();
		// while (iter.hasNext()) {
		// // 这里的name为fileItem的alias属性值，相当于form表单中name
		// String name = (String) iter.next();
		// System.out.println("name:" + name);
		// // 根据name值拿取文件
		// MultipartFile file = multipartHttpServletRequest.getFile(name);
		// if (file != null) {
		// String fileName = file.getOriginalFilename();
		// path = "H:/test/" + fileName;
		// File localFile = new File(path);
		// if (!localFile.getParentFile().exists()) {
		// // 如果目标文件所在的目录不存在，则创建父目录
		// localFile.getParentFile().mkdirs();
		// }
		// // 写文件到本地
		// try {
		// file.transferTo(localFile);
		// } catch (IOException e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// return path;
		// }
		// }
		// }
		// }
	// return "";
	// }

	@RequestMapping(value = "/insertCase", method = RequestMethod.POST)
	public void insertCase(@RequestBody PCMS_FLOW_MAIN_VO pcmsFlowMainVO) {
	}

}
