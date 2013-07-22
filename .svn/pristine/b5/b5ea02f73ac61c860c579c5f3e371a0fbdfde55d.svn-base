<%@page import="org.apache.commons.dbcp.BasicDataSource"%>
<%@page import="com.mchange.v2.c3p0.ComboPooledDataSource"%>
<jsp:directive.page
	import="org.springframework.web.context.WebApplicationContext" />
<%@page import="springmvc.parse.ServiceParserException"%>
<%@page import="springmvc.parse.JsonParserUtil"%>
<%@page import="springmvc.parse.EchoServiceCreds"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%  
String path = request.getContextPath();  
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";  
%>  
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GBK">
<title>计算拥塞度服务</title>
<link rel="stylesheet" type="text/css" href="<%= basePath%>css/histogram.css">
<style>
table {
	width: 100%;
}
</style>
<script src="./view/javaScript/gotClick.js"></script>
</head>
<body>
	<img width="100%" src="./images/kd.jpg">

	<form name="form1" target="_blank" method="post" action="<c:url value="/data.html"/>">

		<em style="font-size: 18px; color: blue">交通应用:</em><input
			style="width: 85px; height: 30px; color: #660066" type="submit"
			name="submitForm1" value="提交"
			onclick="this.disabled=true;this.form.submit();gotClick()" /> <span
			id="results" style="text-align: center;"></span>
	</form>

	<table>
		<caption style="font-size: 16px; color: #00CC99">结果展示</caption>
		<tr style="background-color: lightblue">
			<td style="border: 1px none black; border-radius: 10px">
				<div class="histogram-container" id="histogram-container">
					<div class="histogram-bg-line">
						<ul>
							<li><div></div></li>
							<li><div></div></li>
							<li><div></div></li>
							<li><div></div></li>
						</ul>
						<ul>
							<li><div></div></li>
							<li><div></div></li>
							<li><div></div></li>
							<li><div></div></li>
						</ul>
						<ul>
							<li><div></div></li>
							<li><div></div></li>
							<li><div></div></li>
							<li><div></div></li>
						</ul>
						<ul>
							<li><div></div></li>
							<li><div></div></li>
							<li><div></div></li>
							<li><div></div></li>
						</ul>
						<ul>
							<li><div></div></li>
							<li><div></div></li>
							<li><div></div></li>
							<li><div></div></li>
						</ul>
					</div>
					<!--柱状条-->
					<div class="histogram-content">
						<ul>
							<li><span class="histogram-box"><a
									style="height: 20%; background: #2f87d9;" title="20%"></a></span> <span
								class="name">百度</span></li>
							<li><span class="histogram-box"><a
									style="height: 40%; background: green;" title="40%"></a></span> <span
								class="name">新浪</span></li>
							<li><span class="histogram-box"><a
									style="height: 50%; background: orange;" title="50%"></a></span> <span
								class="name">腾讯</span></li>
							<li><span class="histogram-box"><a
									style="height: 80%; background: gray;" title="80%"></a></span> <span
								class="name">阿里</span></li>
						</ul>
					</div>
					<!--百分比 y轴-->
					<div class="histogram-y">
						<ul>
							<li>100%</li>
							<li>80%</li>
							<li>60%</li>
							<li>40%</li>
							<li>20%</li>
							<li>0%</li>
						</ul>
					</div>
				</div>
			</td>

			<td
				style="background-color: #387; border: 1px none #60C; border-radius: 10px">
				<div class="histogram-container" id="histogram-container">
					<div class="histogram-bg-line">
						<ul>
							<li><div></div></li>
							<li><div></div></li>
							<li><div></div></li>
							<li><div></div></li>
						</ul>
						<ul>
							<li><div></div></li>
							<li><div></div></li>
							<li><div></div></li>
							<li><div></div></li>
						</ul>
						<ul>
							<li><div></div></li>
							<li><div></div></li>
							<li><div></div></li>
							<li><div></div></li>
						</ul>
						<ul>
							<li><div></div></li>
							<li><div></div></li>
							<li><div></div></li>
							<li><div></div></li>
						</ul>
						<ul>
							<li><div></div></li>
							<li><div></div></li>
							<li><div></div></li>
							<li><div></div></li>
						</ul>
					</div>
					<!--柱状条-->
					<div class="histogram-content">
						<ul>
							<li><span class="histogram-box"><a
									style="height: 20%; background: #2f87d9;" title="20%"></a></span> <span
								class="name">百度</span></li>
							<li><span class="histogram-box"><a
									style="height: 40%; background: green;" title="40%"></a></span> <span
								class="name">新浪</span></li>
							<li><span class="histogram-box"><a
									style="height: 50%; background: orange;" title="50%"></a></span> <span
								class="name">腾讯</span></li>
							<li><span class="histogram-box"><a
									style="height: 80%; background: gray;" title="80%"></a></span> <span
								class="name">阿里</span></li>
						</ul>
					</div>
					<!--百分比 y轴-->
					<div class="histogram-y">
						<ul>
							<li>100%</li>
							<li>80%</li>
							<li>60%</li>
							<li>40%</li>
							<li>20%</li>
							<li>0%</li>
						</ul>
					</div>
				</div>
			</td>

			<td style="border: 1px none black; border-radius: 10px">
				<div class="histogram-container" id="histogram-container">
					<div class="histogram-bg-line">
						<ul>
							<li><div></div></li>
							<li><div></div></li>
							<li><div></div></li>
							<li><div></div></li>
						</ul>
						<ul>
							<li><div></div></li>
							<li><div></div></li>
							<li><div></div></li>
							<li><div></div></li>
						</ul>
						<ul>
							<li><div></div></li>
							<li><div></div></li>
							<li><div></div></li>
							<li><div></div></li>
						</ul>
						<ul>
							<li><div></div></li>
							<li><div></div></li>
							<li><div></div></li>
							<li><div></div></li>
						</ul>
						<ul>
							<li><div></div></li>
							<li><div></div></li>
							<li><div></div></li>
							<li><div></div></li>
						</ul>
					</div>
					<!--柱状条-->
					<div class="histogram-content">
						<ul>
							<li><span class="histogram-box"><a
									style="height: 20%; background: #2f87d9;" title="20%"></a></span> <span
								class="name">百度</span></li>
							<li><span class="histogram-box"><a
									style="height: 40%; background: green;" title="40%"></a></span> <span
								class="name">新浪</span></li>
							<li><span class="histogram-box"><a
									style="height: 50%; background: orange;" title="50%"></a></span> <span
								class="name">腾讯</span></li>
							<li><span class="histogram-box"><a
									style="height: 80%; background: gray;" title="80%"></a></span> <span
								class="name">阿里</span></li>
						</ul>
					</div>
					<!--百分比 y轴-->
					<div class="histogram-y">
						<ul>
							<li>100%</li>
							<li>80%</li>
							<li>60%</li>
							<li>40%</li>
							<li>20%</li>
							<li>0%</li>
						</ul>
					</div>
				</div>
			</td>
		</tr>
	</table>


	<table>
		<tr style="background-color: lightgreen">
			<td style="border: 1px none black; border-radius: 10px">
				<P class=MsoNormal style="margin: 0cm 0cm 0pt">
					<STRONG><SPAN lang=EN-US
						style="FONT-SIZE: 9pt; FONT-FAMILY: 宋体"></SPAN> <SPAN
						style="FONT-SIZE: 9pt; FONT-FAMILY: 宋体">本周亮点 <SPAN
							lang=EN-US></SPAN></SPAN></STRONG>
				</P>
				<P class=MsoNormal style="MARGIN: 0cm 0cm 0pt">
					<SPAN style="FONT-SIZE: 9pt; FONT-FAMILY: 宋体"> <marquee
							behavior="scroll" direction="up" width="300" height="65"
							loop="-1" scrollamount="1.5" scrolldelay="0.5" style="font: 50px">
							本周图书国庆特大书讯<br />我们虚位以待 你准备好了吗<br />本周解码亮相国际书展会
						</marquee></SPAN>
				</P>

				<P class=MsoNormal style="MARGIN: 0cm 0cm 0pt">
					<STRONG><SPAN lang=EN-US
						style="FONT-SIZE: 9pt; FONT-FAMILY: 宋体"></SPAN> <SPAN
						style="FONT-SIZE: 9pt; FONT-FAMILY: 宋体">未来猜想<SPAN
							lang=EN-US></SPAN></SPAN></STRONG>
				</P>
				<P class=MsoNormal style="MARGIN: 0cm 0cm 0pt">
					<SPAN style="FONT-SIZE: 9pt; FONT-FAMILY: 宋体"> <marquee
							behavior="scroll" direction="up" width="300" height="65"
							loop="-1" scrollamount="1.5" scrolldelay="0.5" style="font: 50px">
							新财富主义下消失的白领职业<br />小行星2098年掠过地球
						</marquee></SPAN>
				</P>
			</td>



			<td style="border: 1px none black; border-radius: 10px">
				<P class=MsoNormal style="MARGIN: 0cm 0cm 0pt">
					<STRONG><SPAN lang=EN-US
						style="FONT-SIZE: 9pt; FONT-FAMILY: 宋体"></SPAN> <SPAN
						style="FONT-SIZE: 9pt; FONT-FAMILY: 宋体">本周亮点 <SPAN
							lang=EN-US></SPAN></SPAN></STRONG>
				</P>
				<P class=MsoNormal style="MARGIN: 0cm 0cm 0pt">
					<SPAN style="FONT-SIZE: 9pt; FONT-FAMILY: 宋体"> <marquee
							behavior="scroll" direction="up" width="300" height="65"
							loop="-1" scrollamount="1.5" scrolldelay="0.5" style="font: 50px">
							本周图书国庆特大书讯<br />我们虚位以待 你准备好了吗<br />本周解码亮相国际书展会
						</marquee></SPAN>
				</P>


				<P class=MsoNormal style="MARGIN: 0cm 0cm 0pt">
					<STRONG><SPAN lang=EN-US
						style="FONT-SIZE: 9pt; FONT-FAMILY: 宋体"></SPAN> <SPAN
						style="FONT-SIZE: 9pt; FONT-FAMILY: 宋体">未来猜想<SPAN
							lang=EN-US></SPAN></SPAN></STRONG>
				</P>
				<P class=MsoNormal style="MARGIN: 0cm 0cm 0pt">
					<SPAN style="FONT-SIZE: 9pt; FONT-FAMILY: 宋体"> <marquee
							behavior="scroll" direction="up" width="300" height="65"
							loop="-1" scrollamount="1.5" scrolldelay="0.5" style="font: 50px">
							新财富主义下消失的白领职业<br />小行星2098年掠过地球
						</marquee></SPAN>
				</P>
			</td>
		</tr>
	</table>
	
	<%-- <%
		/* String services_json = System.getenv("VCAP_SERVICES");
		EchoServiceCreds creds = null;
		try {
			creds = JsonParserUtil.getServiceInstance(services_json,
					"myecho");
		} catch (ServiceParserException e) {
		} */
		/* WebApplicationContext context = (WebApplicationContext) this
				.getServletContext()
				.getAttribute(
						WebApplicationContext.ROOT_WEB_APPLICATION_CONTEXT_ATTRIBUTE);
		BasicDataSource datasource = (BasicDataSource) context
				.getBean("dataSource"); */
/* 
		String url = "jdbc:mysql://";
		url = url + creds.getHost();
		url = url + "/";
		url = url + creds.getUser();
		datasource.setUrl(url);
		datasource.setUsername(creds.getUsername());
		datasource.setPassword(creds.getPassword()); */	
		//datasource.setUsername("root");
		//datasource.setPassword("1234"); 
	%>
		<%=url%>
	 <%=creds.getUsername()%>
	 <%=creds.getPassword()%> --%> 	
</body>
</html>

