<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
memberList.jsp
<br>

<%@include file="./../common/common.jsp"%>
<script type="text/javascript">
	function insert(){
		location.href="register.mb";
	}
	function update(id, pageNumber, whatColumn, keyword){
		location.href="update.mb?id=" + id + "&pageNumber=" + pageNumber + "&whatColumn=" + whatColumn + "&keyword=" + keyword;
	}

</script>

<center>
	<h2>회원 리스트 화면(${totalCount})</h2>
</center>

<center>
	<form action="list.mb" method="get">
		<select name="whatColumn">
			<option value="">전체 검색</option>
			<option value="name">이름</option>
			<option value="gender">성별</option>
		</select> <input type="text" name="keyword"> <input type="submit"
			value="검색">
	</form>
</center>

<table border="1" align="center" >
	<tr>
		<td colspan="9" align="right"><input type="button" value="추가하기"
			onClick="insert()"></td>
	</tr>
	<tr>
		<th>ID</th>
		<th>이름</th>
		<th>비번</th>
		<th>성별</th>
		<th>취미</th>
		<th>주소</th>
		<th>포인트</th>
		<th>삭제</th>
		<th>수정</th>
	</tr>

	<c:forEach var="mb" items="${memberList }">
		<tr>
			<td>${mb.id }</td>
			<td><a href="detail.mb?id=${mb.id }&pageNumber=${pageInfo.pageNumber}&whatColumn=${param.whatColumn }&keyword=${param.keyword }">${mb.name }</a>
			</td>
			<td>${mb.password}</td>
			<td>${mb.gender}</td>
			<td>${mb.hobby}</td>
			<td>${mb.address1}${mb.address2}</td>
			<td>${mb.mpoint}</td>
			<td><a href="delete.mb?id=${mb.id }&pageNumber=${pageInfo.pageNumber}&whatColumn=${param.whatColumn }&keyword=${param.keyword }">삭제</a></td>
			<td><input type="button" value="수정"
				onClick="update(${mb.id}, ${pageInfo.pageNumber},'${param.whatColumn }','${param.keyword }')">
			</td>
		</tr>
	</c:forEach>
</table>
<br>
<br>
<center>${pageInfo.pagingHtml}</center>

