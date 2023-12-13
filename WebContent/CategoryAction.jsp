<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@ page import = "com.mvc.dao.CategoryDAO" %>

    <%
    
    	String catName = request.getParameter("catName");
    
    	boolean flag = CategoryDAO.insertCategory(catName);
    
    	if(flag)
    		response.sendRedirect("index.html");
    	else
    		response.sendRedirect("error.html");
    %>