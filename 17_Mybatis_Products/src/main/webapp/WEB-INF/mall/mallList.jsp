<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../common/common.jsp"%>
mallList.jsp
<br>

<center>
	<h2>주문 내역</h2>
</center>
<form action="" method="post">
	<table border="1" align="center">
		<tr align="center">
			<td colspan="5">주문자 정보 :
				${sessionScope.loginInfo.name}(${sessionScope.loginInfo.id})</td>
		</tr>
		<tr>
			<th>상품 번호</th>
			<th>상품명</th>
			<th>주문 수량</th>
			<th>단가</th>
			<th>금액</th>
		</tr>
		<c:if test="${fn:length(shopLists) == 0 }">
		상품 목록이 비어있습니다.
	</c:if>
		<c:if test="${fn:length(shopLists) != 0 }">
			<c:forEach var="shop" items="${shopLists}">
				<tr align="center">
					<td>${shop.pnum}</td>
					<td>${shop.pname}</td>
					<td>${shop.qty}</td>
					<td>${shop.price}</td>
					<td>${shop.amount}</td>
				</tr>
			</c:forEach>
		</c:if>
		<tr align="center">
			<td colspan="3"><a href="calculate.mall">결제하기</a> <!-- calculate.mall => CalculateController --> 
			<a href="list.prd">추가 주문</a></td>
			<td colspan="2" align="center">총 금액 : ${totalAmount}</td>
		</tr>
	</table>
</form>