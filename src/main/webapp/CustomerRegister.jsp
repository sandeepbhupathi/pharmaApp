<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %> 
<jsp:include page="/includes/header.jsp" />
<div style="width: 960px;position: relative;left:100px">
	<div style="width: 220px;position: relative;">
		<img src="images/hioxindia-pharmacy_08.jpg" alt="" border="0" /> <br /> 
      	<h1>Pharmaceutist</h1>
      	<p>Freedesignertemplates.com has a wide collection of HTML web design templates.</p>
    	<p align="right"><a href="#" class="more">View More</a></p>
	</div>
	<div style="width: 300px;position: relative;top: -270px;left:240px">
		<div  style="relative;top: -270px;left:240px">
			<s:if test="hasActionErrors()">
				<s:actionerror/>
			</s:if>
		</div>
	
		
		<s:form action="doCustomerRegister" method="post">
				 <table cellspacing="5" cellpadding="3">	
					<tr><s:textfield label="LOGIN NAME" name="user.userName"/></tr>
					<tr><s:password label="PASSWORD" name="user.password"/></tr>
					<tr><s:password label="RE-PASSWORD" name="user.repassword"/></tr>
					<tr><s:textfield label="DISTRIBUTER NAME" name="user.disname"/></tr>
					<tr><s:textfield label="ADDRESS" name="user.adderess"/></tr>
					<tr><s:textfield label="CITY NAME" name="user.cityname"/></tr>
					<tr><s:textfield label="STATE NAME" name="user.statename"/></tr>
					<tr><s:select label="COUNTRY NAME"  headerKey="-1" 
							  headerValue="COUNTRY" list="#{'1':'America', '2':'Bangladesh', '3':'China', '4':'Canada',
							  							 '5':'Germany','6':'Holland','7':'India','8':'Malasia',
							  							 '9':'Polland','10':'Russia','11':'UK'}" name="user.countryName"/></tr>
				    <tr><s:select label="REGION"  headerKey="-1" 
							  headerValue="REGION" list="#{'1':'Africa', '2':'Astralia', '3':'Asia', '4':'Europe',
							  							 '5':'Iropa','6':'North America','7':'South America'}" 
							  							 name="user.region"/></tr>
                    <tr><s:textfield label="PHONE" name="user.phoneNo"/></tr>
                    <tr><s:textfield label="EMAIL" name="user.email"/></tr>
					<tr><td> </td><td> <s:submit value="SUBMIT"/>
									</td><td> </td><td> <s:reset value="CLEAR"/></td></tr>
					</table>
			</s:form>
	</div>
	<div style="width: 220px;position: relative;top: -785px;left:560px">
		<img src="images/hioxindia-pharmacy_10.jpg" alt="" border="0" />
        <h1>Drug Store</h1>
        <p>Anyone can use these HTML templates just by replacing the content to the pre-existing site designs.</p>
        <p align="right"><a href="#" class="more">View More</a></p>
	</div>
	<div style="width: 220px;position: relative;top: -1085px;left:800px">
		<img src="images/hioxindia-pharmacy_12.jpg" alt="" border="0" />
        <h1>Tablets</h1>
      	<p>This high quality free pharmaceutical company template is built using XHTML and CSS..</p>
        <p align="right"><a href="#" class="more">View More</a></p>
	</div>
</div>

<jsp:include page="/includes/footer2.jsp" />
