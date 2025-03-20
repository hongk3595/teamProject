<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
web-inf\travel\travelList.jsp<br>

<%@include file="./../common/common.jsp" %>

<h2>여행 리스트 화면(${totalCount} /  ${fn:length(travelLists) } )</h2>

<form action="list.tv" method="get">
	<select name="whatColumn"> <!-- whatColumn=area or style -->
		<option value="">전체검색</option>
		<option value="area">지역</option>
		<option value="style">여행 타입</option>
	</select>
	<input type="text" name="keyword"> <!-- keyword=검색어 -->
	<input type="submit" value="검색">
</form>

<script type="text/javascript">
	function insert(){
		location.href="insert.tv";
	}
	function goUpdate(num){
		location.href="update.tv?num=" + num;
	} 
</script>
<table border="1">
	<tr>
		<td colspan="8" align="right">
			<input type="button" value="추가하기" onClick="insert()">
		</td>
	</tr>
	<tr>
		<th>번호</th>
		<th>이름</th>
		<th>나이</th>
		<th>지역</th>
		<th>스타일</th>
		<th>가격</th>
		<th>수정</th>
		<th>삭제</th>
	</tr>
	<c:forEach var="tl" items="${travelLists }"> <!-- begin end --> 
	<tr>
		<td>${tl.num }</td>
		<td>${tl.name }</td>
		<td>${tl.age }</td>
		<td>${tl.area }</td>
		<td>${tl.style}</td>
		<td>${tl.price }</td>
		<td><input type="button" value="수정" onClick="goUpdate('${tl.num}')"></td>
		<td><a href="delete.tv?num=${tl.num }">삭제</a></td>
	</tr>
	</c:forEach>
</table>

<br><br>

${pageInfo.pagingHtml}



