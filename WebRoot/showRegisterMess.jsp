<%@ page contentType="text/html;charset=GB2312" %> 
<jsp:useBean id="register" class="mybean.data.Register" scope="request" /> 
<jsp:setProperty property="*" name="register"/>
<HTML><HEAD><%@ include file="head.txt" %></HEAD> 
<HTML><BODY bgcolor=cyan > 
<CENTER> 
  
<table> 
 <tr><td>ע��Ļ�Ա����:</td><td><%=register.getLogname()%></td></tr> 
 <tr><td> ע �� �� �� �� �� �� :</td><td><%=register.getAdvertiseTitle()%></td></tr> 
 <tr><td>ע��ĵ����ʼ�:</td><td><%=register.getEmail()%></td></tr> 
 <tr><td>ע�����ϵ�绰:</td><td><%=register.getPhone()%></td></tr> 
</table> 
 <table><tr><td>���Ĺ��ʣ�</td></tr> 
   <tr><td><TextArea name="message" Rows="6" Cols="30"> 
                <%=register.getMessage()%>
           </TextArea> 
       </td> 
   </tr> 
</table> </CENTER></BODY></HTML> 