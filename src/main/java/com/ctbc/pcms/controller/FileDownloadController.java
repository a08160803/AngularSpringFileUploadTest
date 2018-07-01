package com.ctbc.pcms.controller;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.SQLException;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.ctbc.pcms.model.dao.FileService;

@Controller
public class FileDownloadController {

	@Autowired
	private FileService fileService;

	@RequestMapping(value = "/FileDownload", method = RequestMethod.GET)
	public void fileDownload(@RequestParam("flowMainSeq") Integer flowMainSeq,
			HttpServletResponse response) throws IOException, SQLException {
		Blob docFileContent = fileService.fileDownload(flowMainSeq);

//		byte[] docFileContentBytes = docFileContent.getBytes(1, (int) docFileContent.length());
//		HttpHeaders headers = new HttpHeaders();
//		headers.setContentDispositionFormData("attachment", "little");
//		headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
//		return new ResponseEntity<byte[]>(docFileContentBytes, headers, HttpStatus.CREATED);
		 InputStream inputStream = docFileContent.getBinaryStream();
		 IOUtils.copy(inputStream, response.getOutputStream());
		 inputStream.close();
		 response.setContentType(MediaType.IMAGE_JPEG_VALUE);
		 response.flushBuffer();
	}

}
