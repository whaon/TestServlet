<%@ page language="java" contentType="text/html; charset=GB18030"
    pageEncoding="GB18030"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB18030">
<title>Insert title here</title>
<script type="text/javascript">
function allCookie(){//读取所有保存的cookie字符串
	var str = document.cookie;
	if(str == ""){
		str = "没有保存任何cookie";
	}
	alert(str);
}
</script>
</head>
<body>
<input type="button" value="读取所有cookie" onclick="allCookie()" />
<br/>
JSP文件会被编译成servlet,也即java文件,在编译后的servlet中,会产生一个session,此session存在于
内存中,是由cookie来保存的,所以cookie可以访问到
<%
	Cookie[] cs = request.getCookies();
	if(cs != null) {
		for(Cookie c:cs) {
%>

		<%=c.getName() + ":--" + c.getValue()%>
<%
		}
	} else {
		System.out.println("this is null");
		
	}
	
	out.println("<hr/>");
%>
</body>
</html>