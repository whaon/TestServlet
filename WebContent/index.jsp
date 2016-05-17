<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%=request.getAttribute("name1") %> <hr/>
<%
System.out.println(request.getParameter("pid"));
%>
<!-- <iframe src="javascript:alert(1)"></iframe> -->
<%=request.getParameter("pid") %>
test1 <hr/>
<%=request.getParameter("name") %>
<%=request.getAttribute("user0") %> 
</body>
</html>