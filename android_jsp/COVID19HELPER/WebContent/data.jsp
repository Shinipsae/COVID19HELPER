<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import="javamysql.ConnectDB" %>
<%
	request.setCharacterEncoding("UTF-8");
	String id = request.getParameter("id");
	String pw = request.getParameter("pd");
	String type = request.getParameter("type");
	
	ConnectDB connectDB = ConnectDB.getInstance();
	if(type.equals("login")){
		String returns = connectDB.logindb(id, pw);
		out.print(returns);
	} else if(type.equals("join")){
		String returns = connectDB.joindb(id, pw);
		out.print(returns);
	}
%>