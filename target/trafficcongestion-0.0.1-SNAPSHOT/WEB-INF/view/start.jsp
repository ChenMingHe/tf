<%@page import="org.apache.commons.dbcp.BasicDataSource"%>
<%@page import="com.mchange.v2.c3p0.ComboPooledDataSource"%>
<jsp:directive.page import="org.springframework.web.context.WebApplicationContext"/>  
<%@page import="springmvc.parse.ServiceParserException"%>
<%@page import="springmvc.parse.JsonParserUtil"%>
<%@page import="springmvc.parse.EchoServiceCreds"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>计算拥塞度服务</title>
</head>
<body>
<%
		/* String services_json = System.getenv("VCAP_SERVICES");
		EchoServiceCreds creds = null;
		try {
			creds = JsonParserUtil.getServiceInstance(services_json,
					"myecho");
		} catch (ServiceParserException e) {
		} */
		WebApplicationContext context = (WebApplicationContext) this
				.getServletContext()
				.getAttribute(
						WebApplicationContext.ROOT_WEB_APPLICATION_CONTEXT_ATTRIBUTE);
		//能否找到BasicDataSource这个类？
		BasicDataSource datasource = (BasicDataSource)context.getBean("dataSource"); 
	
		//ComboPooledDataSource datasource = (ComboPooledDataSource) context
			//	.getBean("dataSource");
		/* String url = "jdbc:mysql://";
		url = url + creds.getHost();
		url = url + "/";
		url = url + creds.getUser();
		datasource.setUrl(url); */
		//datasource.setJdbcUrl(url);
		//datasource.setUser(creds.getUsername());
/* 		datasource.setUsername(creds.getUsername());
		datasource.setPassword(creds.getPassword()); */
		datasource.setUsername("root");
		datasource.setPassword("1234");
	%>
<%-- 	<%=url%>
	<%=creds.getUsername()%>
	<%=creds.getPassword()%> --%>
	<center>
		<h2>计算拥塞度</h2>
		<form method="post" action="<c:url value="/data.html"/>">
			<table>
				<tr>
					<td><input type="submit" name="提交注册" /></td>
				</tr>
			</table>
		</form>
	</center>

	
</body>
</html>

