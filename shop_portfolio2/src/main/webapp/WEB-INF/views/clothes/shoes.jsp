<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../include/includeFile.jsp" %>
<%@ include file="../include/detailTem.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>신발</title>
<link rel="stylesheet" type="text/css" href="${path}/resources/css2/default.css"/>

<script type="text/javascript">
	$(function() {
		
			//제목을 클릭했을때
			$('.imgDetail').on('click', function(e) {
				e.preventDefault(); //기본기능  소멸
				var code = $(this).attr('href');
				console.log(code);
				$(location).attr('href', '${path}/clothes/detail?code='+code);
			});
			
			if('${sessionScope.mdto.userid}' == ""){	
				$('#login').show();
				$('#logout').hide();
				$('#join').show();
				$('#cart').show();
			}else{
				$('#login').hide();
				$('#join').hide();
				$('#logout').show();
			}
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
                            <li><a href="${path}/main">Home</a></li>
                            <li><a href="${path}/clothes/top">Top</a></li>
                            <li><a href="${path}/clothes/pants">Pants</a></li>
                            <li class="active"><a href="${path}/clothes/shoes">Shoes</a>
                            <c:if test="${sessionScope.mdto.authority eq 1}">
                            <li><a href="#">Manage Page</a>
                                <ul class="dropdown">
                                    <li><a href="${path}/clothes/manage">Register</a></li>
                                    <li><a href="${path}/clothes/list">Clothes List</a></li>
                                </ul>
                            </li>
                            </c:if>
                        </ul>
                    </nav>
                </div>
                <div class="col-lg-3">
                    <div class="header__right">
                        <div class="header__right__auth">
                            <a href="${path}/login" id="login">Login</a>
                             ${sessionScope.mdto.userid} 
                              <a href="${path}/logout" id="logout">logout</a>
                            <a href="${path}/join" id="join">Join</a>
                        </div>
                        <ul class="header__right__widget">
                            <li><a href="${path}/cart/cart"><span class="icon_bag_alt"></span>
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

    <!-- Breadcrumb Begin -->
    <div class="breadcrumb-option">
        <div class="container">
            <div class="row">
                <div class="col-lg-12">
                    <div class="breadcrumb__links">
                        <a href="${path}/main"><i class="fa fa-home"></i> Home</a>
                        <span>Shop</span>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <!-- Breadcrumb End -->

    <!-- Shop Section Begin -->
    <section class="shop spad">
        <div class="container">
            <div class="row">
                <div class="col-lg-3 col-md-3">
                    <div class="sidebar__categories">
                            <div class="section-title">
                                <h4>Categories</h4>
                            </div>
                            <div class="categories__accordion">
                                <div class="accordion" id="accordionExample">
                                    <div class="card">
                                        <div class="card-heading">
                                            <a data-toggle="collapse" data-target="#collapseOne" >Top</a>
                                        </div>
                                    </div>
                                    <div class="card">
                                        <div class="card-heading">
                                            <a data-toggle="collapse" data-target="#collapseTwo">Pants</a>
                                        </div>
                                    </div>
                                    <div class="card">
                                        <div class="card-heading active">
                                            <a data-toggle="collapse" data-target="#collapseThree" class="" aria-expanded="true">Shoes</a>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                </div>
                <div class="col-lg-9 col-md-9">
                    <div class="row">
                <c:forEach var="clothes" items="${clist}">
                        <div class="col-lg-4 col-md-6">
                            <div class="product__item">
                                <div class="product__item__pic set-bg" style="background-image: url(&quot;img/shop/shop-1.jpg&quot;);">
                                    <div>
                                    	<a class="imgDetail" href="${clothes.code}">
										<img src="${path}/localimg/${clothes.filename}" width="300px"></a>
                                    </div>
                                    <div class="label new">New</div>
                                </div>
                                <div class="product__item__text">
                                    <h6><a href="#">${clothes.cname}</a></h6>
                                    <div class="rating">
                                        <i class="fa fa-star"></i>
                                        <i class="fa fa-star"></i>
                                        <i class="fa fa-star"></i>
                                        <i class="fa fa-star"></i>
                                        <i class="fa fa-star"></i>
                                    </div>
                                    <div class="product__price">${clothes.price}WON<!-- <span>50000WON</span> --></div>
                                </div>
                            </div>
                        </div>
						</c:forEach>
                    </div>
                </div>
            </div>
        </div>
    </section>
    <!-- Shop Section End -->

    <!-- Footer Section Begin -->
    <footer class="footer">
        <div class="container">
            <div class="row">
                <div class="col-lg-12">
                    <!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->
                    <div class="footer__copyright__text">
                        <p>Copyright © <script>document.write(new Date().getFullYear());</script>2020 All rights reserved | This template is made with <i class="fa fa-heart" aria-hidden="true"></i> by <a href="https://colorlib.com" target="_blank">Colorlib</a></p>
                    </div>
                    <!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->
                </div>
            </div>
        </div>
    </footer>
    <!-- Footer Section End -->

    <!-- Search Begin -->
    <div class="search-model">
        <div class="h-100 d-flex align-items-center justify-content-center">
            <div class="search-close-switch">+</div>
            <form class="search-model-form">
                <input type="text" id="search-input" placeholder="Search here.....">
            </form>
        </div>
    </div>
    <!-- Search End -->


</body>
</html>
</html>