<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>메이트 모집 상세보기</title>
<link rel="stylesheet" type="text/css" href="/resources/css/basicStyle.css">
<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=310fc683ebc82542a03a51f91a654846&libraries=services,clusterer,drawing"></script>
</head>
<body>
<!-- header -->
	<jsp:include page="/WEB-INF/views/common/header.jsp"></jsp:include>
	<br><br><br><br>
	<!-- end header -->
	
	<!-- content -->
	<div class="content" style="height:800px;">
	<div class="menub">
		<ul>
			<li><a href="mateList.doa">메이트 커뮤니티</a></li>
			<li><a href="opendiaryList.doa">공유일기 게시판</a></li>
		</ul>
	</div>

	<div class="main">
		<div class="main-name">
			<h2 class="main-name-h2">${mateOne.mateNo }번 글 상세보기</h2>
		</div>
		<div class="table-wrap">
			<table align="center" cellpadding="10" cellspacing="0" border="1" width="500" class="table">
				<!-- 최대최소 모집 인원 -->
				<c:set var="requireNumber" value="${mateOne.mateRequireNo }"/>
				<c:set var="min" value="${ fn:substring(requireNumber,0,1) }"/>
				<c:set var="max" value="${ fn:substring(requireNumber,2,3) }"/>
				
				<c:set var="position" value="${mateOne.latLong}"/>
				<c:set var="llat" value="${ fn:substringBefore(position, '_')}" />
				<c:set var="llng" value="${ fn:substringAfter(position, '_')}" />
				
					
				<tr align="center" valign="middle"> <!-- valign : 수직 가운데 -->
					<td height="15" width="70">제목</td>
					<td>${mateOne.mateTitle }</td>
				</tr>
				<tr>
					<td>작성자</td>
					<td>${mateOne.userId }</td>
				</tr>
				<tr>
					<td>작성 날짜</td>
					<td>${mateOne.mateDate }</td>
				</tr>
				<tr>
					<td>모집 최소인원</td>
					<td>${ min }</td>
				</tr>
				<tr>
					<td>모집 최대인원</td>
					<td>${ max }</td>
				</tr>
				<tr>
					<td rowspan="2">모임 장소</td>
					<td>${mateOne.matePlace }</td>
				</tr>
				<tr>
					<td><div id="map" style="width:100%;height:200px;margin-top:10px;">
					</div></td>
				</tr>
				<tr>
					<td height="30">내용</td>
					<td>${mateOne.mateContents }</td>
				</tr>
				<tr>
				<c:url var="mateList" value="mateList.doa">
					<c:param name="page" value="${currentPage }"></c:param>
				</c:url>
					<a href="#">수정하기</a>
					<a href="#">삭제하기</a>
					<a href="${mateList }">목록으로</a>
				</tr>
			</table>
		</div>
		<br><br><br><br><br><br>
		<c:if test="${ !empty sessionScope.loginUser }">
		<div style="width:80px;float:left;">
			<input type="button" name="attendBtn" value="참여하기" class="btn btn-primary" >
		</div>
		</c:if>
		<c:if test="${ empty sessionScope.loginUser  }">
		<div style="width:80px;float:left;">
			<input type="button"value="참여하기" class="btn btn-primary" onclick="loginquest()">
		</div>
		</c:if>
			<table align="center" id="mymateTb" style="width:80%;margin-left:0px;margin-right:0px;">
				<input type="text" id="" value="" >
				<tbody>
					<tr>
						<td></td>
					</tr>
				</tbody>
			</table>
		<br>
		<hr>
		<!-- 댓글 등록 -->
		<table align="center">
			<tr>
				<th>댓글 등록
				</th>
			</tr>
			<tr>
				<c:if test="${ !empty sessionScope.loginUser }">
				<td><textarea rows="3" cols="55" id="mateComContents" placeholder="내용을 입력해주세요" ></textarea></td>
				</c:if>
				<c:if test="${ empty sessionScope.loginUser }">
				<td><textarea rows="3" cols="55" id="mateComContents" placeholder="로그인 후 이용해주세요" readonly ></textarea></td>
				</c:if>
				<td>
					<button id="mateSubmit">등록하기</button>
				</td>
			</tr>
		</table>
		
		<!-- 댓글 목록 -->
		<table align="center" width="500" border="1" cellspacing="0" id="mateComTb">
			<thead>
			<tr>
				<td colspan="3"><b id="mateComCount"></b></td>
			</tr>
			</thead>
			<tbody>
				<tr><td><button></button></td></tr>
			</tbody>
		</table>
	
		<!-- end content -->

	<!-- footer -->
	<br><br><br><br><br><br>
	<jsp:include page="/WEB-INF/views/common/footer.jsp"></jsp:include>
	<!-- end footer -->
	
	<script>
	//--------참여하기 
	function loginquest() {
		alert("로그인 후 이용해주세요");
		return false;
	}
	$(function() {
		myMateList();
		setInterval(function() {
			myMateList();
		}, 5000);
		
		$('input[name="attendBtn"]').on("click", function() {
			var really = confirm("정말로 참여하시겠습니까?");
			if(really) {
				var mateNo = ${mateOne.mateNo};
				$.ajax({
					url : "addMymate.doa",
					type : "post",
					async:false,
					data : {"mateNo" : mateNo},
					success : function(data) {
						if(data == "success") {
							alert("모임에 참여되셨습니다.");
							$('input[name="attendBtn"]').attr('disabled', true);
							$('input[name="attendBtn"]').attr('value', '참여 중');
							$('input[name="attendBtn"]').css('background-color', "gray");
							myMateList();
							
						}else {
							alert("모임 참여에 실패했습니다.");
						}
					}
				});
			} else {
				return false;
			}
		});
	});
	//--------참여자 목록
	function myMateList() {
		var mateNo = ${mateOne.mateNo};
		$.ajax({
			url : "myMateList.doa",
			type : "get",
			data : {"mateNo" : mateNo},
			dataType : "json",
			success : function(data) {
				$tableBody = $("#mymateTb tbody");
				$tableBody.html("");
				
				var $tr;
				var $userId;
				if(data.length > 0) {
					for(var i in data) {
						$tr = $("<tr  style='float:left;'>");
						$userId = $("<td width='80' height='10'>").text(decodeURIComponent(data[i].userId));
						$tr.append($userId);
						$tableBody.append($tr);
						/* if(data[i].userId ==) */
					}
					
				} else {
					$tr =$("<tr>");	
					$userId = $("<td width='80' height='10'>").text("참여한 메이트가 없습니다.");
					
					$tr.append($userId); 
					$tableBody.append($tr);
				}
				console.log(data);
			}
			
		});
	}
	
	//--------댓글등록
	$(function() {
		mateComList();
		setInterval(function() {
			console.log("동작중");
			mateComList();
		}, 5000);
		
		$("#mateSubmit").on("click", function() {
			var mateComContents = $("#mateComContents").val();
			var mateNo = ${mateOne.mateNo};
			$.ajax({
				url : "addMateComments.doa",
				type : "post",
				data : { "mateComContents" : mateComContents, "mateNo" : mateNo },
				success : function(data) {
					if(data == "success") {
						mateComList();
						$("#mateComContents").val("");
					}else {
						alert("댓글 등록에 실패했습니다.");
					}
				}
			});
		});
	});
	
	//---------댓글 리스트
	function mateComList() {
		var mateNo = ${mateOne.mateNo};
		$.ajax({
			url : "mateComList.doa",
			type : "get",
			data : {"mateNo" : mateNo},
			dataType : "json",
			success : function(data) {
				$tableBody = $("#mateComTb tbody");
				$tableBody.html("");
				
				var $tr;
				var $button;
				var $userId;
				var $mateComContents;
				var $mateComDate;
				$("#mateComCount").text("댓글(" + data.length + ")");
				if(data.length >0) {
					for(var i in data) {
						$tr = $("<tr>");
						$userId = $("<td width='100'>").text(data[i].userId);
						$mateComContents = $("<td>").text(decodeURIComponent(data[i].mateComContents).replace(/\+/g, " "));
						$mateComDate = $("<td width='100'>").text(data[i].mateComDate);
						$button = $("<button type='button'>수정하기")
						
						$tr.append($userId);
						$tr.append($mateComContents);
						$tr.append($mateComDate);
						$tr.append($button);
						$tableBody.append($tr);
					}
				} else {
					$tr =$("<tr>");
					$mateComContents = $("<td colspan='3'>").text("등록된 댓글이 없습니다.");
					$tr.append($rContent);
					$tableBody.append($tr);
				}
			}
		})
	}
	
	//--------지도 
	var mapContainer = document.getElementById('map'), // 지도를 표시할 div
	
    mapOption = {
        center: new daum.maps.LatLng(${llat}, ${llng}), // 지도의 중심좌표
        level: 4 // 지도의 확대 레벨
    };
	
	//지도를 미리 생성
	var map = new daum.maps.Map(mapContainer, mapOption);
	//주소-좌표 변환 객체를 생성
	var geocoder = new daum.maps.services.Geocoder();
	//마커를 미리 생성
	var marker = new daum.maps.Marker({
	    position: new daum.maps.LatLng(${llat}, ${llng}),
	    map: map
	});
	// 마커를 지도에 표시합니다.
	marker.setMap(map);

	// 인포윈도우를 생성합니다
	var infowindow = new kakao.maps.InfoWindow({
	    zindex:1
	}); 
	
	function searchDetailAddrFromCoords(marker, callback) {
	    // 좌표로 법정동 상세 주소 정보를 요청합니다
	    geocoder.coord2Address(marker.getPosition().getLng(), marker.getPosition().getLat(), callback);
	}
	
	// 마커에 마우스오버 이벤트를 등록합니다
	kakao.maps.event.addListener(marker, 'mouseover', function() {
		searchDetailAddrFromCoords(marker, function(result, status) {
	        if (status === kakao.maps.services.Status.OK) {
	        	console.log(${llat})
	            detailAddr = !!search ? '<div><b>장소 : ' + search + '</b></div>' : '';
	            detailAddr += '<div> ' + result[0].address.address_name + '</div>'; 
	            
	            var content = '<div class="bAddr" style="height:50px;font-size:small;">' + detailAddr + '</div>';

	            // 마커를 클릭한 위치에 표시합니다 
	            marker.setPosition(marker.getPosition());
	            marker.setMap(map);

	            // 인포윈도우에 클릭한 위치에 대한 법정동 상세 주소정보를 표시합니다
	            infowindow.setContent(content);
	            infowindow.open(map, marker);
	        }   
	    });
	});
	// 마커에 마우스아웃 이벤트를 등록합니다
	kakao.maps.event.addListener(marker, 'mouseout', function() {
	    // 마커에 마우스아웃 이벤트가 발생하면 인포윈도우를 제거합니다
	    infowindow.close();
	});
	</script>
	
</body>
</html>