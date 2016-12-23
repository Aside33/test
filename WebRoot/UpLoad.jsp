<%@ page contentType="text/html;charset=GB2312"%>
<HTML>
<HEAD><%@ include file="head.txt"%></HEAD>
<BODY bgcolor=yellow>
	<Font size=2><CENTER>
			<BR>文件将被上传到 D:\apache-tomcat-5.5.20\webapps\ch10\image中。 <BR>选择要上传的图像照片文件(名字不可以含有非ASCII码字符，比如汉字等)：
			<FORM action="upload" method="post" ENCTYPE="multipart/form-data">
				<INPUT type=FILE name="fileName" size="40"> <BR> <INPUT
					type="submit" name="g" value="提交">
			</FORM>
		</CENTER> </font>
</BODY>
</HTML>
