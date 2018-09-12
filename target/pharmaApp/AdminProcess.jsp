<jsp:include page="/includes/header.jsp" />
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %> 

<table width="960" border="0" cellspacing="10" cellpadding="0" align="center">
  <tr align="justify">
    <td valign="top" width="220px">
    	<img src="images/hioxindia-pharmacy_08.jpg" alt="" border="0" /> <br /> 
      <h1>Pharmaceutist</h1>
      	<p>Freedesignertemplates.com has a wide collection of HTML web design templates.</p>
    	<p align="right"><a href="#" class="more">View More</a></p>
    </td> <td valign="top">
    	
	<table width="300" border="0" cellspacing="10" cellpadding="0" align="center">
		<s:url action="doAdminCust.action" var="adminCustURL" />
		<s:url action="doAdminCustOrder.action" var="adminCustOderURL" />
		<br><br><s:a href="%{adminCustURL}">Go To Customer Administration </s:a>
		<br><s:a href="%{adminCustOderURL}"> Go To Orders Administration </s:a><br>
	</table>
			
	</td>		
    <td valign="top">
    	<img src="images/hioxindia-pharmacy_10.jpg" alt="" border="0" />
        <h1>Drug Store</h1>
      <p>Anyone can use these HTML templates just by replacing the content to the pre-existing site designs.</p>
        <p align="right"><a href="#" class="more">View More</a></p>
    </td>
    <td valign="top">
    	<img src="images/hioxindia-pharmacy_12.jpg" alt="" border="0" />
        <h1>Tablets</h1>
      <p>This high quality free pharmaceutical company template is built using XHTML and CSS..</p>
        <p align="right"><a href="#" class="more">View More</a></p>
    </td>
    
  </tr>
  <tr><td colspan="4" style="border-bottom:1px solid #CCCCCC;"></td></tr>
</table>


<jsp:include page="/includes/footer.jsp" />
