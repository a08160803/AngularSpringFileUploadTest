//package com.ctbc.pcms.controller;
//
//import java.io.IOException;
//import java.io.InputStream;
//import java.util.Collection;
//
//import javax.servlet.ServletConfig;
//import javax.servlet.ServletException;
//import javax.servlet.annotation.MultipartConfig;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.Part;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.AnnotationConfigApplicationContext;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.context.WebApplicationContext;
//import org.springframework.web.context.support.SpringBeanAutowiringSupport;
//import org.springframework.web.context.support.WebApplicationContextUtils;
//
//import com.ctbc.pcms.model.dao.FileUploadService;
//
//import config.WebConfig;
//
//@WebServlet("/FileUpload")
//@MultipartConfig
//public class FileUploadServlet extends HttpServlet {
//	private static final long serialVersionUID = 1L;
//
//	
//	protected void doGet(HttpServletRequest request, HttpServletResponse response)
//			throws ServletException, IOException {
//		doPost(request, response);
//	}
//
//	protected void doPost(HttpServletRequest request, HttpServletResponse response)
//			throws ServletException, IOException {
//		WebApplicationContext springApplicationContext = WebApplicationContextUtils.getWebApplicationContext(request.getServletContext());
////		springApplicationContext.getBean("fileUploadService");
//		FileUploadService fileUploadService = springApplicationContext.getBean(FileUploadService.class);
//		
//		Collection<Part> parts = request.getParts();
//
//		for (Part part : parts) {
//			InputStream inputStream = part.getInputStream();
//			try {
//				fileUploadService.insertPcmsImage(inputStream, 1);
//			} catch (Exception e) {
//				e.getStackTrace();
//			} finally {
//				inputStream.close();
//			}
//
//		}
//	}
//
//}
