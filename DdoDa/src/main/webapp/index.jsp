<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Name</title>
<link rel="stylesheet" type="text/css" href="/resources/css/basicStyle.css">
</head>
<body>
	<!-- header -->
	<jsp:include page="/WEB-INF/views/common/header.jsp"></jsp:include>
	<br><br><br><br>
	<!-- end header -->

	<!-- content -->	
	<div class="content">
	<div class="menub">
		<ul>
			<li><a href="#">#</a></li>
			<li><a href="#">#</a></li>
		</ul>
	</div>
	<div class="main">
		<div class="main-name">
			<h2 class="main-name-h2">Name</h2>
		</div>
		<div class="table-wrap">
		<table align="center" border="1" cellspacing="0" style="clear:right;"  class="table table-hover table-responsive">
			<tr>
				<td>1</td>
				<td>2</td>
				<td>3</td>
				<td>4</td>
			</tr>
			
		</table>
		</div>	
		<br>
		<div id="searchArea" align="center" width="1000px" >
			<form action="openDiarySearch.doa" method="get">
			<select id="searchCondition" name="searchCondition">
				<option value="all" >전체</option>
				<option value="writer">작성자</option>
				<option value="title">제목</option>
				<option value="content">내용</option>
			</select>
			<input type="text" name="searchValue" value="#">
			<input type="submit" value="검색">
			<input type="checkbox" name="existFile">
			<button align="center">글쓰기</button>
			</form>		
		</div>
	</div>
	</div>

	<!-- end content -->
	
	<!-- footer -->
	<br><br><br><br><br><br>
	<jsp:include page="/WEB-INF/views/common/footer.jsp"></jsp:include>
	<!-- end footer -->
</body>
</html>