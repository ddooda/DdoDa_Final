<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="resources/css/menubar-style.css" type="text/css">
<script type="text/javascript" src="http://code.jquery.com/jquery-3.4.1.min.js"></script>
<title>Insert title here</title>
</head>
<body>
		<!-- header -->
	<jsp:include page="/WEB-INF/views/common/header.jsp"></jsp:include>
	<br><br><br><br>
	<!-- end header -->

	
	<!-- footer -->
	<br><br><br><br><br><br>
	<jsp:include page="/WEB-INF/views/common/footer.jsp"></jsp:include>
	<!-- end footer -->
	
	<!-- <div class="nav-area">
		<div class="menu" onclick="location.href='home.doa'">HOME</div>
		<div class="menu" onclick="noticeListView();">공지사항</div>
		<div class="menu" onclick="boardListView();">자유게시판</div>
		<div class="menu" onclick="">etc</div>
	</div>
	<script>
		function nWriteView() {
			location.href='nWriteView.kh';
		}
		function boardListView() {
			location.href='boardList.kh';
		}
		function noticeListView() {
			location.href='noticeList.kh';
		}
	</script> -->
</body>
</html>