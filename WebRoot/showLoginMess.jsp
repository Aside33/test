<%@ page contentType="text/html;charset=GB2312"%>
<%@ page import="mybean.data.Login"%>
<jsp:useBean id="login" type="mybean.data.Login" scope="session" />
<HTML>
<HEAD><%@ include file="head.txt"%></HEAD>
<BODY bgcolor=yellow>
	<CENTER>
		<jsp:getProperty name="login" property="backNews" />
		<%
			if (login.getSuccess() == true) {
		%>
		<BR>��¼��Ա����:<jsp:getProperty name="login" property="logname" />
		<%
			} else {
		%>
		<BR>��¼��Ա����:<jsp:getProperty name="login" property="logname" />
		<BR>��¼��Ա����:<jsp:getProperty name="login" property="password" />
		<%
			}
		%>
	</CENTER>
</BODY>
</HTML>
