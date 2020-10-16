<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../include/includeFile.jsp" %>
<%@ include file="../include/detailTem.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>관리자모드</title>
<link rel="stylesheet" href="../resources/css2/bootstrap.min.css" type="text/css">
<script type="text/javascript">

 	$(function() {
 		//저장버튼을 클릭했을때
 		$('#btnAdd').on('click', function(e){
 			e.preventDefault(); //객체의 기본기능 소멸
 			$('#addForm').attr('action', '${path}/clothes/manage');
 			$('#addForm').attr('method', 'post');
 			$('#addForm').attr('enctype', 'multipart/form-data');
 			
 			$('#addForm').submit();
 		} );

 		//목록버튼을 클릭했을때
 		$('#btnList').on('click', function(e) {
 			e.preventDefault(); //객체의 기본기능 소멸
			$(location).attr('href', '${path}/clothes/list');
		});
 		
		//파일 삭제 버튼을 클릭했을때
		$('.btnFileDelete').on('click', function(e) {
			e.preventDefault(); 
			$(this).parent().remove();
		});
		
		$('.sizeCh').on('click',function(){
 			if($(this).is(':checked')){
				$(this).parent().append('<input type="number" name="qty" id="qty">');
			}
 			else{
 				$(this).next().remove();
 			}
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
	  <p class="mb-0">Create clothes</p>
	</blockquote>
	
	<form id="addForm">
		<table border="1" class="table table-hover">
			<tr class="table-light">
				<td>코드</td>
				<td><input type="text" name="code"></td>
			</tr>
			<tr class="table-light">
				<td>옷이름</td>
				<td><input type="text" name="cname"></td>
			</tr>
			<tr class="table-light">
				<td>타입</td>
				<td><select name="ctype">
						<option value="top">Top</option>
						<option value="pants">Pants</option>
						<option value="shoes">Shoes</option>
					</select></td>
			</tr>
			<tr class="table-light">
				<td>가격</td>
				<td><input type="number" name="price"></td>
			</tr>

			<tr class="table-light">
				<td rowspan="11">사이즈/수량</td>
			</tr>
			<tr>
				<td>
					<label><input type="checkbox" name="size" value="S" class="sizeCh"> S</label>
				</td>			
			</tr>
			<tr>
				<td>
					<label><input type="checkbox" name="size" value="M" class="sizeCh"> M</label>
				</td>			
			</tr>
			<tr>
				<td>
					<label><input type="checkbox" name="size" value="L" class="sizeCh"> L</label>
				</td>			
			</tr>
			<tr>
				<td>
					<label><input type="checkbox" name="size" value="XL" class="sizeCh"> XL</label>
				</td>			
			</tr>
			<tr>
				<td>
					<label><input type="checkbox" name="size" value="280" class="sizeCh"> 280</label>
				</td>			
			</tr>
			<tr>
				<td>
					<label><input type="checkbox" name="size" value="270" class="sizeCh"> 270</label>
				</td>			
			</tr>
			<tr>
				<td>
					<label><input type="checkbox" name="size" value="260" class="sizeCh"> 260</label>
				</td>			
			</tr>
			<tr>
				<td>
					<label><input type="checkbox" name="size" value="250" class="sizeCh"> 250</label>
				</td>			
			</tr>
			<tr>
				<td>
					<label><input type="checkbox" name="size" value="240" class="sizeCh"> 240</label>
				</td>			
			</tr>
			<tr>
				<td>
					<label><input type="checkbox" name="size" value="230" class="sizeCh"> 230</label>
				</td>			
			</tr>
			<tr class="table-light">
				<td>옷파일</td>
				<td>
						<div>
							<input type="file" name="cfile">	
							<button class="btnFileDelete btn btn-outline-primary">삭제</button>		
						</div>
				</td>	
			</tr>
			<tr class="table-light">
				<td colspan="2">
					<button id="btnAdd" class="btn btn-outline-success">저장</button>
					<button id="btnList" class = "btn btn-outline-info">목록</button>
				</td>
			</tr>
		</table>
		 
	</form>

</body>
</html>