package com.ctbc.pcms.controller;

import java.io.IOException;
import java.util.Map;

import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.ctbc.pcms.model.dao.FileService;

@Controller
public class FileUploadController {

	@Autowired
	private FileService fileUploadService;

	@RequestMapping(value = "/FileUpload", method = RequestMethod.POST)
	public Map<String, Object> incoming(@RequestParam("file")MultipartFile file, @RequestParam("formData")String json) throws IOException, JSONException {
		System.out.println(json);
		byte[] bytes = file.getBytes();
		fileUploadService.insertPcmsImage(bytes, 1);
		return null;
	}

}
