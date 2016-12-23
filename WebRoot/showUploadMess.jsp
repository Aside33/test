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
		<font size=2>上传的文件名字：<jsp:getProperty name="upFile"
				property="fileName" /> 保存后的文件名字：<jsp:getProperty name="upFile"
				property="savedFileName" /> <BR> <img src=image
			/<jsp:getProperty name="upFile" property="savedFileName" /> width=500
			height=500>图像效果 </img> </FONT>
	</CENTER>
</BODY>
</HTML>
