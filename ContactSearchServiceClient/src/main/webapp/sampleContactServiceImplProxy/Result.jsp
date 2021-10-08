<%@page contentType="text/html;charset=UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); %>
<HTML>
<HEAD>
<TITLE>Result</TITLE>
</HEAD>
<BODY>
<H1>Result</H1>

<jsp:useBean id="sampleContactServiceImplProxyid" scope="session" class="com.gaggle.rarmstrong.contactsearch.ContactServiceImplProxy" />
<%
if (request.getParameter("endpoint") != null && request.getParameter("endpoint").length() > 0)
sampleContactServiceImplProxyid.setEndpoint(request.getParameter("endpoint"));
%>

<%
String method = request.getParameter("method");
int methodID = 0;
if (method == null) methodID = -1;

if(methodID != -1) methodID = Integer.parseInt(method);
boolean gotMethod = false;

try {
switch (methodID){ 
case 2:
        gotMethod = true;
        java.lang.String getEndpoint2mtemp = sampleContactServiceImplProxyid.getEndpoint();
if(getEndpoint2mtemp == null){
%>
<%=getEndpoint2mtemp %>
<%
}else{
        String tempResultreturnp3 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(getEndpoint2mtemp));
        %>
        <%= tempResultreturnp3 %>
        <%
}
break;
case 5:
        gotMethod = true;
        String endpoint_0id=  request.getParameter("endpoint8");
            java.lang.String endpoint_0idTemp = null;
        if(!endpoint_0id.equals("")){
         endpoint_0idTemp  = endpoint_0id;
        }
        sampleContactServiceImplProxyid.setEndpoint(endpoint_0idTemp);
break;
case 10:
        gotMethod = true;
        com.gaggle.rarmstrong.contactsearch.ContactServiceImpl getContactServiceImpl10mtemp = sampleContactServiceImplProxyid.getContactServiceImpl();
if(getContactServiceImpl10mtemp == null){
%>
<%=getContactServiceImpl10mtemp %>
<%
}else{
        if(getContactServiceImpl10mtemp!= null){
        String tempreturnp11 = getContactServiceImpl10mtemp.toString();
        %>
        <%=tempreturnp11%>
        <%
        }}
break;
case 13:
        gotMethod = true;
        String request_1id=  request.getParameter("request16");
            java.lang.String request_1idTemp = null;
        if(!request_1id.equals("")){
         request_1idTemp  = request_1id;
        }
        java.lang.String getContactByID13mtemp = sampleContactServiceImplProxyid.getContactByID(request_1idTemp);
if(getContactByID13mtemp == null){
%>
<%=getContactByID13mtemp %>
<%
}else{
        String tempResultreturnp14 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(getContactByID13mtemp));
        %>
        <%= tempResultreturnp14 %>
        <%
}
break;
case 18:
        gotMethod = true;
        String request_2id=  request.getParameter("request21");
            java.lang.String request_2idTemp = null;
        if(!request_2id.equals("")){
         request_2idTemp  = request_2id;
        }
        java.lang.String getContactsBySearch18mtemp = sampleContactServiceImplProxyid.getContactsBySearch(request_2idTemp);
if(getContactsBySearch18mtemp == null){
%>
<%=getContactsBySearch18mtemp %>
<%
}else{
        String tempResultreturnp19 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(getContactsBySearch18mtemp));
        %>
        <%= tempResultreturnp19 %>
        <%
}
break;
}
} catch (Exception e) { 
%>
Exception: <%= org.eclipse.jst.ws.util.JspUtils.markup(e.toString()) %>
Message: <%= org.eclipse.jst.ws.util.JspUtils.markup(e.getMessage()) %>
<%
return;
}
if(!gotMethod){
%>
result: N/A
<%
}
%>
</BODY>
</HTML>