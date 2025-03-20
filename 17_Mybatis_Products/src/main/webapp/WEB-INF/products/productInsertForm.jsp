<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@include file="./../common/common.jsp" %>    
    
productInsertForm.jsp<br>
<%
application.getAttribute("");
%>
<style type="text/css">

	table {
		margin: auto;
		width: 400px;
	}

.err {
	font-size: 10pt;
	color: red;
	font-weight: bold;
}
</style>
<h1>상품 추가 화면</h1>
<form:form commandName="products" action="insert.prd" method="post" enctype="multipart/form-data">
<p>
	<label>*상품명</label>
	<input type="text" name="name" value="${products.name }">
	<form:errors cssClass="err" path="name"/>
</p>
<p>
	<label>제조 회사</label>
	<input type="text" name="company">
</p>
<p>
	<label>*가격</label>
	<input type="text" name="price" value="${products.price }">
	<form:errors cssClass="err" path="price" />
</p>
<p>
	<label>재고 수량</label>
	<input type="text" name="stock">
</p>
<p>
	<label>적립 포인트</label> 
	<input type="text" name="point">
</p>
<p>
	<label>*설명</label> 
	<input type="text" name="contents" value="${products.contents }">
	<form:errors cssClass="err" path="contents"/>
</p>
<p>
	<label>*상품 이미지</label> 
	<input type="file" name="upload"> <!-- upload=구두.jpg -->
	<form:errors cssClass="err" path="image"/>
</p>
<p>
	<label>입고 일자</label>
	<input type="date" name="inputdate">
</p>
<p>
	<input type="submit" value="추가하기">
</p>
</form:form>

