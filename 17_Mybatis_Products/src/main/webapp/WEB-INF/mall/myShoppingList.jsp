<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file=".././common/common.jsp" %>

<style type="text/css">

	table {
		margin: auto;
		width: 400px;
	}

</style>   
myShoppingList<br>
<h2 align="center">주문 내역</h2>
<table border="1">
	<tr align="center">
		<td colspan="3">
			주문자 정보 : ${sessionScope.loginInfo.name }(${loginInfo.id })
		</td>
	</tr>
	<tr>
		<th>주문 번호</th>
		<th>주문 일자</th>
		<th>상세 보기</th>
	</tr>
	<c:if test="${fn:length(obLists) == 0 }">
		<tr align="center">
			<td colspan="3">
				구매하신 내역이 없습니다.
			</td>
		</tr>
	</c:if>
	<c:if test="${fn:length(obLists) != 0 }">
		<c:forEach var="ob" items="${obLists }">
			<tr align="center">
				<td>${ob.oid }</td>
				<td>${ob.orderdate }</td>
				<td><a href="orderDetailView.mall?oid=${ob.oid }">상세 보기</a></td>
				<!-- orderDetailView.mall => orderDetailViewController -->
			</tr>
		</c:forEach>
	</c:if>
</table>
