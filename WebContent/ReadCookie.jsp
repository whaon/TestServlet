<%@ page language="java" contentType="text/html; charset=GB18030"
    pageEncoding="GB18030"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB18030">
<title>Insert title here</title>
<script type="text/javascript">
function allCookie(){//��ȡ���б����cookie�ַ���
	var str = document.cookie;
	if(str == ""){
		str = "û�б����κ�cookie";
	}
	alert(str);
}
</script>
</head>
<body>
<input type="button" value="��ȡ����cookie" onclick="allCookie()" />
<br/>
JSP�ļ��ᱻ�����servlet,Ҳ��java�ļ�,�ڱ�����servlet��,�����һ��session,��session������
�ڴ���,����cookie�������,����cookie���Է��ʵ�
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