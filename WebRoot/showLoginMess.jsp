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
		<BR>登录会员名称:<jsp:getProperty name="login" property="logname" />
		<%
			} else {
		%>
		<BR>登录会员名称:<jsp:getProperty name="login" property="logname" />
		<BR>登录会员密码:<jsp:getProperty name="login" property="password" />
		<%
			}
		%>
	</CENTER>
</BODY>
</HTML>
