<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../common/common.jsp"%>
travelInsertFrom.jsp
<br>
<br>
<style type="text/css">
.err {
	font-size: 10pt;
	color: red;
	font-weight: bold;
}
</style>
<h1>여행 정보 등록 화면</h1>
<form:form commandName="travel" action="insert.tv" method="post">

	이름 <input type="text" name="name" value="${travel.name }">
	<form:errors cssClass="err" path="name" />
	<br>
	<br>
	
	나이 <input type="text" name="age" value="${travel.age }">
	<form:errors cssClass="err" path="age" />
	<br>
	<br>
	
	지역  
			<input type="checkbox" name="area" value="유럽" <c:if test="${fn:contains(travel.area,'유럽')}">checked</c:if>>유럽
			<input type="checkbox" name="area" value="동남아" <c:if test="${fn:contains(travel.area,'동남아')}">checked</c:if>>동남아
			<input type="checkbox" name="area" value="일본" <c:if test="${fn:contains(travel.area,'일본')}">checked</c:if>>일본
			<input type="checkbox" name="area" value="중국" <c:if test="${fn:contains(travel.area,'중국')}">checked</c:if>>중국
	<form:errors cssClass="err" path="area" />
	<br>
	<br>
	
	여행 타입 
	
	<input type="radio" name="style" value="패키지" <c:if test="${travel.style.equals('패키지')}">checked</c:if>>패키지	
	<input type="radio" name="style" value="크루즈" <c:if test="${travel.style == '크루즈'}">checked</c:if>>크루즈	
	<input type="radio" name="style" value="자유여행" <c:if test="${travel.style.equals('자유여행')}">checked</c:if>>자유여행	
	<input type="radio" name="style" value="골프여행" <c:if test="${travel.style.equals('골프여행')}">checked</c:if>>골프여행
	<form:errors cssClass="err" path="style" />
	<br>
	<br>
	
	가격 
	 <select name="price">
			<option value="">선택하세요</option>
				<option value="100~200" <c:if test="${travel.price == '100~200' }">selected</c:if>>100~200</option>
				<option value="200~300" <c:if test="${travel.price == '200~300' }">selected</c:if>>200~300</option>
				<option value="300~400" <c:if test="${travel.price == '300~400' }">selected</c:if>>300~400</option>
				<option value="400~500" <c:if test="${travel.price == '400~500' }">selected</c:if>>400~500</option>
		</select>
	<form:errors cssClass="err" path="price" />
	<br>
	<br>
	<input type="submit" value="추가하기">
</form:form>
