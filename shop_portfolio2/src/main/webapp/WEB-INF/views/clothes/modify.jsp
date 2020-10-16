<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../include/includeFile.jsp" %>
<%@ include file="../include/detailTem.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>정보수정</title>
<link rel="stylesheet" href="../resources/css2/bootstrap.min.css" type="text/css">
<script type="text/javascript">
	$(function() {
 		//저장버튼을 클릭했을때
 		$('#btnAdd').on('click', function(e){
 			e.preventDefault(); //객체의 기본기능 소멸
 			$('#modifyForm').attr('action', '${path}/clothes/modify');
 			$('#modifyForm').attr('method', 'post');
 			$('#modifyForm').attr('enctype', 'multipart/form-data');
 			
 			$('#modifyForm').submit();
 		} );

 		//목록버튼을 클릭했을때
 		$('#btnList').on('click', function(e) {
 			e.preventDefault(); //객체의 기본기능 소멸
			$(location).attr('href', '${path}/clothes/list');
		});
 		
 		
 		//삭제버튼을 클릭했을때
 		$('#btnDelete').on('click', function(e) {
 			e.preventDefault(); //객체의 기본기능 소멸
 			var code = $('#code').val();
 			var size = $('#sizeChange').val();
			$(location).attr('href', '${path}/clothes/delete?code='+code+"&size="+size);
		});
		
		//파일 삭제 버튼을 클릭했을때
		$('.btnFileDelete').on('click',function(e) {
			e.preventDefault(); 
			$(this).parent().remove();
		});
		//사이즈 체인지
		$('#sizeChange').change(function(){
			var size = $(this).val();
			$('#updateSize').val(size);
		})
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
                <div class="col-lg-3">
                    <div class="header__right">
                        <div class="header__right__auth">
                            <a href="#">Login</a>
                            <a href="${path}/clothes/manage">Join</a>
                        </div>
                        <ul class="header__right__widget">
                            <li><a href="#"><span class="icon_bag_alt"></span>
                            </a></li>
                        </ul>
                    </div>
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
	  <p class="mb-0">Modify clothes</p>
	</blockquote>
	
	<form id="modifyForm">
		<table border = "1" class="table table-hover">
			<tr class="table-light">
				<td>CODE</td>
				<td><input id="code" type="text" name="code" value="${clothes.code}" readonly="readonly"></td>
			</tr>		
			<tr class="table-light">
				<td>NAME</td>
				<td><input type="text" name="cname" value="${clothes.cname}"></td>
			</tr>
			<tr class="table-light">
				<td>TYPE</td>
				<td><input type="text" name="ctype" value="${clothes.ctype}"></td>
			</tr>
			<tr class="table-light">
				<td>SIZE</td>
				<td><input type="text" id="updateSize" name="size" value="${size.size}">
					<select id ="sizeChange">
						<option value="S" <c:out value="${size.size=='S'?'selected':''}" />>S</option>
						<option value="M" <c:out value="${size.size=='M'?'selected':''}" />>M</option>
						<option value="L" <c:out value="${size.size=='L'?'selected':''}" />>L</option>
						<option value="XL" <c:out value="${size.size=='L'?'selected':''}" />>XL</option>
						<option value="280" <c:out value="${size.size=='280'?'selected':''}" />>280</option>
						<option value="270" <c:out value="${size.size=='270'?'selected':''}" />>270</option>
						<option value="260" <c:out value="${size.size=='260'?'selected':''}" />>260</option>
						<option value="250" <c:out value="${size.size=='250'?'selected':''}" />>250</option>
						<option value="240" <c:out value="${size.size=='240'?'selected':''}" />>240</option>
						<option value="230" <c:out value="${size.size=='230'?'selected':''}" />>230</option>
					</select></td>
			</tr>
			<tr class="table-light">
				<td>PRICE</td>
				<td> <input type="number" name="price" value="${clothes.price}"> </td>
			</tr>
			<tr class="table-light">
				<td>EA</td>
				<td><input type="number" name="qty" value="${size.qty}"></td>
			</tr>
			<tr class="table-light">
				<td>IMAGE</td>
				<td>
							<div>
								<input type="hidden" name="fnum" value="${fdetail.fnum}"> 
								<input type="text" value="${fdetail.filename}" readonly="readonly"><br>
								<img src="${path}/localimg/${fdetail.filename}" width="300px">
								<button class="btnFileDelete btn btn-outline-primary">삭제</button>
							</div>
						<div>
							<input type="file" name="cfile">		
						</div>
				</td>	
			</tr>
			<tr class="table-light">
				<td colspan="2">
					<button id="btnAdd" class="btn btn-outline-success">저장</button>
					<button id="btnDelete" class="btn btn-outline-primary">삭제</button>
					<button id="btnList" class = "btn btn-outline-info ">목록</button>
				</td>
				
			</tr>
		</table>
	</form>
</body>
</html>