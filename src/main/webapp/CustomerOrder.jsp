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
		<s:form action="doCustomerOrder" method="post">
				 <table cellspacing="5" cellpadding="3">
				 	<tr><s:select label="Product Code"  headerKey="CODE" 
							  headerValue="CODE" list="#{'APLG0001':'APLG0001', 'APLG0002':'APLG0002', 'APLG0003':'APLG0003', 
							  							 'APLG0004':'APLG0004','APLG0005':'APLG0005'}" 
							  							 name="order.code"/></tr>	
					<tr><s:textfield label="Product Name" name="order.productName"/></tr>
					<tr><s:textfield label="Tax" name="order.tax"/></tr>
					<tr><s:textfield label="Min Qty to Order" name="order.minq"/></tr>
					<tr><s:textfield label="Ordering Qty" name="order.orderq"/></tr>
					<tr><s:textfield label="Discount" name="order.discount"/></tr>
					<tr><s:textfield label="Net Cost" name="order.netCost"/></tr>
					<tr><s:textfield label="Amount" name="order.amount"/></tr>
					<tr> <s:radio list="#{'Cash':'Cash','Check':'Check','D.D':'D.D' }" name='order.modePay' label="ModeofPayment"/> </tr>
					<tr><td> </td><td> <s:submit value="SUBMIT"/>
									</td><td> </td><td> <s:reset value="CLEAR"/></td></tr>
					</table>
			</s:form>
	</div>
	<div style="width: 220px;position: relative;top: -645px;left:560px">
		<img src="images/hioxindia-pharmacy_10.jpg" alt="" border="0" />
        <h1>Drug Store</h1>
        <p>Anyone can use these HTML templates just by replacing the content to the pre-existing site designs.</p>
        <p align="right"><a href="#" class="more">View More</a></p>
	</div>
	<div style="width: 220px;position: relative;top: -945px;left:800px">
		<img src="images/hioxindia-pharmacy_12.jpg" alt="" border="0" />
        <h1>Tablets</h1>
      	<p>This high quality free pharmaceutical company template is built using XHTML and CSS..</p>
        <p align="right"><a href="#" class="more">View More</a></p>
	</div>
</div>

<jsp:include page="/includes/footer2.jsp" />

