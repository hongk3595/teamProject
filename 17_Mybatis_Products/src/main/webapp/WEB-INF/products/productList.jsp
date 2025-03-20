<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="./../common/common.jsp" %>    
productList.jsp<br>
<script type="text/javascript">
	function insert(){
		location.href="insert.prd";
	}
	function update(num, pageNumber, whatColumn, keyword){
		location.href="update.prd?num=" + num + "&pageNumber=" + pageNumber + "&whatColumn=" + whatColumn + "&keyword=" + keyword;
	}
</script>
<h2>상품 리스트 화면</h2>
<h2>productList.jsp(${totalCount})</h2>
<center>
<form action="list.prd" method="get">
	<select name="whatColumn">
		<option value="">전체 검색</option>
		<option value="name">상품명</option>
		<option value="contents">설명</option>
	</select>
	<input type="text" name="keyword">
	<input type="submit" value="검색">
</form>
</center>

<table border="1" align="center" width="60%">
	<tr>
		<td colspan="6" align="right">
			<input type="button" value="추가하기" onClick="insert()">
		</td>
	</tr>
	<tr>
		<th>상품번호</th>
		<th>상품명</th>
		<th>설명</th>
		<th>가격</th>
		<th>삭제</th>
		<th>수정</th>
	</tr>
	
	<c:forEach var="pb" items="${productLists }">
		<tr>
			<td>${pb.num }</td>
			<td>
				<a href="detail.prd?num=${pb.num }&pageNumber=${pageInfo.pageNumber}&whatColumn=${param.whatColumn }&keyword=${param.keyword }">${pb.name }</a>
			</td>
			<td>${pb.contents }</td>
			<td>${pb.price }</td>
			<td><a href="delete.prd?num=${pb.num }&pageNumber=${pageInfo.pageNumber}&whatColumn=${param.whatColumn }&keyword=${param.keyword }">삭제</a></td>
			<td>
				<input type="button" value="수정" onClick="update(${pb.num}, ${pageInfo.pageNumber},'${param.whatColumn }','${param.keyword }')">
			</td>
		</tr>
	</c:forEach>
</table>
<br><br>
<center>
${pageInfo.pagingHtml}
</center>

