<%@ page contentType="text/html;charset=GB2312"%>
<%@ page import="mybean.data.*"%>
<jsp:useBean id="upFile" class="mybean.data.UpLoadFile" scope="request" />
<HTML>
<HEAD><%@ include file="head.txt"%></HEAD>
<HTML>
<BODY bgcolor=yellow>
	<CENTER>
		<Font size=2 color=blue> <BR> <jsp:getProperty
				name="upFile" property="backNews" /> 25 </Font> <BR>
		<font size=2>�ϴ����ļ����֣�<jsp:getProperty name="upFile"
				property="fileName" /> �������ļ����֣�<jsp:getProperty name="upFile"
				property="savedFileName" /> <BR> <img src=image
			/<jsp:getProperty name="upFile" property="savedFileName" /> width=500
			height=500>ͼ��Ч�� </img> </FONT>
	</CENTER>
</BODY>
</HTML>
