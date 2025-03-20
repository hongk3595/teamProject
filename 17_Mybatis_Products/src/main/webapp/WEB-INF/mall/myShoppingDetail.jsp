<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file=".././common/common.jsp" %>    
    
<style type="text/css">
    table {
        margin: auto;
        width: 600px;
    }
</style>

<h2 align="center">주문 상세 내역</h2>
<table border="1">
    <tr>
        <td colspan="2">고객명 : ${loginInfo.name}</td>
        <td colspan="3">송장 번호(주문번호) : ${param.oid}</td>
    </tr>
    <tr>
        <td>배송지 :</td>
        <td colspan="4">${loginInfo.address1 } ${loginInfo.address2 }</td>
    </tr>
    <tr class="header-row" align="center">
        <th>순번</th>
        <th>상품명(상품번호)</th>
        <th>수량</th>
        <th>단가</th>
        <th>금액</th>
    </tr>
    
    <c:if test="${empty shopLists}">
        <tr>
            <td colspan="5" align="center">주문 상세 내역이 없습니다.</td>
        </tr>
    </c:if>
    
    <c:if test="${not empty shopLists}">
        <c:set var="totalAmount" value="0"/>
        <c:forEach var="shop" items="${shopLists}" varStatus="status">
            <tr align="center">
                <td>${status.count}</td>
                <td>${shop.pname}(${shop.pnum})</td>
                <td>${shop.qty}</td>
                <td><fmt:formatNumber value="${shop.price}" pattern="#,###"/>원</td>
                <td><fmt:formatNumber value="${shop.amount}" pattern="#,###"/>원</td>
            </tr>
            <c:set var="totalAmount" value="${totalAmount + shop.amount}"/>
        </c:forEach>
        <tr>
            <td colspan="4" align="right"><strong>총 결제 금액</strong></td>
            <td align="center"><fmt:formatNumber value="${totalAmount}" pattern="#,###"/>원</td>
        </tr>
    </c:if>
</table>

