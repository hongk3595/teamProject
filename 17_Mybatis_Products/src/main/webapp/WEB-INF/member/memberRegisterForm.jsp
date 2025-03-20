<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="./../common/common.jsp" %> 

<style type="text/css">

.err {
	font-size: 10pt;
	color: red;
	font-weight: bold;
}
</style>


memberRegisterForm.jsp<br>
 
<h3>회원 가입 화면</h3>
<form:form commandName="mb" action="register.mb" method="post">

<p>
<label>아이디</label>
<input type="text" name="id" value="${mb.id }">
<form:errors cssClass="err" path="id"/>
</p>

<p>
<label>이름</label>
<input type="text" name="name" value="${mb.name }">
<form:errors cssClass="err" path="name"/>
</p>

<p>
<label>비번</label>
<input type="text" name="password" value="${mb.password }">
<form:errors cssClass="err" path="password"/>
</p>

<p>
<%
	String[] gender = {"여자","남자"};
	pageContext.setAttribute("gender", gender);
%>
<label>성별</label>
<c:forEach var="gd" items="${gender }">
<input type="radio" name="gender" value="${gd}" <c:if test="${mb.gender eq gd}">checked</c:if>>${gd}
</c:forEach>

<!-- <input type="radio" name="gender" value="여자">여자
<input type="radio" name="gender" value="남자">남자 -->
<form:errors cssClass="err" path="gender"/>
</p>

<p>
<%
	String[] hobby = {"마라톤","영화감상","게임","공부"};
	pageContext.setAttribute("hobby", hobby);
%>

<label>취미</label>
<c:forEach var="hb" items="${hobby }">
 <input type="checkbox" name="hobby" value="${hb}" <c:if test="${fn:contains(mb.hobby, hb)}">checked</c:if>>${hb}
</c:forEach>
<!-- 
<input type="checkbox" name="hobby" value="마라톤">마라톤
<input type="checkbox" name="hobby" value="영화감상">영화감상
<input type="checkbox" name="hobby" value="게임">게임
<input type="checkbox" name="hobby" value="공부">공부
 --><form:errors cssClass="err" path="hobby"/>
</p>

<p>
<label>주소1</label>
<input type="text" name="address1" value="${mb.address1 }">
<form:errors cssClass="err" path="address1"/>
</p>

<p>
<label>주소2</label>
<input type="text" name="address2" value="${mb.address2 }">
</p>

<p>
<label>적립포인트</label>
<input type="text" name="mpoint" value="${mb.mpoint }">
</p>

<p>
<input type="submit" value="추가하기">
</p>


</form:form>