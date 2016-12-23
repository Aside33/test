<%@ page contentType="text/html;charset=GB2312" %> 
<jsp:useBean id="register" class="mybean.data.Register" scope="request" /> 
<jsp:setProperty property="*" name="register"/>
<HTML><HEAD><%@ include file="head.txt" %></HEAD> 
<HTML><BODY bgcolor=cyan > 
<CENTER> 
  
<table> 
 <tr><td>注册的会员名称:</td><td><%=register.getLogname()%></td></tr> 
 <tr><td> 注 册 的 广 告 标 题 :</td><td><%=register.getAdvertiseTitle()%></td></tr> 
 <tr><td>注册的电子邮件:</td><td><%=register.getEmail()%></td></tr> 
 <tr><td>注册的联系电话:</td><td><%=register.getPhone()%></td></tr> 
</table> 
 <table><tr><td>您的广告词：</td></tr> 
   <tr><td><TextArea name="message" Rows="6" Cols="30"> 
                <%=register.getMessage()%>
           </TextArea> 
       </td> 
   </tr> 
</table> </CENTER></BODY></HTML> 