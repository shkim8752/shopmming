<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../include/includeFile.jsp" %>
<%@ include file="../include/detailTem.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>재고 리스트</title>
<link rel="stylesheet" href="../resources/css2/bootstrap.min.css" type="text/css">
<!-- <link rel="stylesheet" href="../resources/css2/default.css" type="text/css"> -->
<script type="text/javascript">
	//document가 로딩 완료된후 함수 실행
	$(function() {
		//조회버튼
		$('#btnSearch').on('click', function(){
			var findKey = $('#findKey').val();
			var findValue = $('#findValue').val();
			console.log(findKey);
			console.log(findValue);
			$(location).attr('href',
					'${path}/clothes/list?findKey='+findKey+'&findValue='+findValue);
		});
		//추가 버튼 클릭시
		$('#btnAdd').on('click', function() {
			$(location).attr('href','${path}/clothes/manage');
		});
		
 		//메인버튼을 클릭했을때
 		$('#btnMain').on('click', function(e) {
 			e.preventDefault(); //객체의 기본기능 소멸
			$(location).attr('href', '${path}/clothes/main');
		});
		
		//페이지를 클릭했을때
		$('.aPage').on('click', function(e) {
			e.preventDefault(); //기본기능  소멸
			var curPage = $(this).attr('href');
			var findKey = $('#findKey').val();
			var findValue = $('#findValue').val();
			
			console.log(curPage);
			$(location).attr('href','${path}/clothes/list?curPage='+curPage+'&findKey='+findKey+'&findValue='+findValue);
		});
		
		//코드를 클릭했을때
		$('.code').on('click', function(e) {
			e.preventDefault(); //기본기능  소멸
			var size = $(this).attr('href');
			var code = $(this).html();
			var qty = $('.qty').html();
			$(location).attr('href','${path}/clothes/modify?code='+code+'&size='+size+'&qty='+qty);
		});
		
		//세션삭제 클릭
		$('#btnSessionDelete').on('click', function() {
			$(location).attr('href','${path}/clothes/sessionDelete');
		});
		
		
	});

</script>
</head>
<body>
	<!-- Page Preloder -->
    <div id="preloder" style="display: none;">
        <div class="loader" style="display: none;"></div>
    </div>

    <!-- Offcanvas Menu Begin -->
    <div class="offcanvas-menu-overlay"></div>
    <div class="offcanvas-menu-wrapper">

        <div class="offcanvas__logo">
            <a href="./index.html"><img src="img/logo.png" alt=""></a>
        </div>
        <div class="offcanvas__auth">
            <a href="#">Login</a>
            <a href="#">Register</a>
        </div>
    </div>
    <!-- Offcanvas Menu End -->

    <!-- Header Section Begin -->
    <header class="header">
        <div class="container-fluid">
            <div class="row">
                <div class="col-xl-3 col-lg-2">
                    <div class="header__logo">
                        <a href="./index.html"><img src="img/logo.png" alt=""></a>
                    </div>
                </div>
                <div class="col-xl-6 col-lg-7">
                    <nav class="header__menu">
                        <ul>
                            <li><a href="${path}/clothes/main">Home</a></li>
                            <li><a href="${path}/clothes/top">Top</a></li>
                            <li><a href="${path}/clothes/pants">Pants</a></li>
                            <li><a href="${path}/clothes/shoes">Shoes</a>
                            <li class="active"><a href="#">Manage Page</a>
                                <ul class="dropdown">
                                    <li><a href="${path}/clothes/manage">Register</a></li>
                                    <li><a href="${path}/clothes/list">Clothes List</a></li>
                                </ul>
                            </li>
                        </ul>
                    </nav>
                </div>

            </div>
            <div class="canvas__open">
                <i class="fa fa-bars"></i>
            </div>
        </div>
    </header>
    <!-- Header Section End -->

	<blockquote class="blockquote text-center">
	  <footer class="blockquote-footer">High quality <cite title="Source Title">provide clothes</cite></footer>
	  <p class="mb-0">Product check</p>
	</blockquote>
	<div class="root">
		<div class="conBox">
			<div class="form-group">
				<select id ="findKey" class="custom-select">
					<option value="code" <c:out value="${pdto.findKey=='code'?'selected':''}" />>code</option>
					<option value="cname" <c:out value="${pdto.findKey=='cname'?'selected':''}" />>name</option>
					<option value="ctype" <c:out value="${pdto.findKey=='ctype'?'selected':''}" />>type</option>
					<option value="subcon" <c:out value="${pdto.findKey=='subcon'?'selected':''}" />>name+type</option>
				</select>
			  <input type="text" class="form-control" placeholder="Default input" id="findValue" value="${pdto.findValue}">
			</div>
			
			<div>
				<button type="button" class="btn btn-outline-primary" id="btnSearch">조회</button>
				<button type="button" class="btn btn-outline-success" id="btnAdd">추가</button>
				<button type="button" class="btn btn-outline-info" id="btnMain">메인</button>
				<button type="button" class="btn btn-outline-danger" id="btnSessionDelete">세션값삭제</button>
			</div>
			<!-- 리스트 출력 -->
			<div>
				<table border="1" class="table table-hover">
					<tr>
						<th>code</th>
						<th>name</th>
						<th>type</th>
						<th>price</th>
						<th>EA</th>
						<th>size</th>
					</tr>
				
					<c:forEach var="clothes" items="${clist}">
						<tr class="table-light">
							<td><a class="code" href="${clothes.size}" >${clothes.code}</a></td>
							<td>${clothes.cname}</td>
							<td>${clothes.ctype}</td>
							<td>${clothes.price}</td>
							<td class="qty">${clothes.qty}</td>
							<td>${clothes.size}</td>
						</tr>
					</c:forEach>
				</table>
			</div>
		</div>
		<!-- 페이징 처리 -->
		<div class="botBox">
			<c:if test="${pdto.startPage!=1}">
				<a class ="aPage" href="${pdto.startPage-1}">이전</a>
			</c:if> 
			<c:forEach var="i" begin="${pdto.startPage}" end="${pdto.endPage}">
				<a class ="aPage" href="${i}"> ${i}</a>
			</c:forEach>
			<c:if test="${pdto.endPage < pdto.totPage}">
				<a class ="aPage" href="${pdto.endPage+1}">다음</a>
			</c:if>
		 </div>
	</div>
	
</html>