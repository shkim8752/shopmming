<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../include/includeFile.jsp"%>
<%@ include file="../include/detailTem.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>카트</title>
<style type="text/css">
#logo {
	display: block;
	margin-left: 600px;
}
</style>
<script type="text/javascript">
	$(function() {
		$('.test').on('click', function(e) {
			console.log($(this));
			var cartnum = $(this).next().val();			
			var userid = $('#userid').text(); 
			var userid = "admin";
			
/* 			var code = $('#code').text();
            var size = $('#size').text();
            var qty = $('#qty').val(); */
		     /*  alert(code);    alert(qty);  alert(size); alert(userid);  */

			$.ajax({
				type : 'get',
				url : '${path}/cart/delete',
				data : 'cartnum=' + cartnum +'&userid=' + userid,
				dataType : 'json', //결과값의 타입
				success : function(result) {
					console.log(result);
					$('#cartnum'+cartnum).remove();
					$('#totprice').html(result.totprice); 

				},
				error : function(result) {
					alert("error");
					console.log(result);
				}
			});

		});
		

		
		if ('${sessionScope.mdto.userid}' == "") { //로그인이 안됬을 때 
			$('#login').show();
			$('#join').show();
		} else {
			$('#login').hide();
			$('#join').hide();
		}
	});
</script>
</head>
<body>
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
							<li><a href="${path}/clothes/shoes">Shoes</a>
							<li class="active"><a href="#">Manage Page</a></li>
						</ul>
					</nav>
				</div>
				<div class="col-lg-3">
					<div class="header__right">
						<div class="header__right__auth">
							<a href="${path}/login" id="login">Login</a> <a id=userid>
								${sessionScope.mdto.userid} </a> 
								<a href="${path}/logout" id="logout">logout</a>
								<a href="${path}/join" id="join">Join</a>
						</div>
						<ul class="header__right__widget">
							<li><a href="${path}/cart"><span class="icon_bag_alt"></span>
							</a></li>
						</ul>
					</div>
				</div>
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
						<a href="${path}/main"><i class="fa fa-home"></i> Home</a> <span>Shopping
							cart</span>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- Breadcrumb End -->

	<!-- Shop Cart Section Begin -->
	<section class="shop-cart spad">
		<div class="container">
			<div class="row">
				<div class="col-lg-12">
					<div class="shop__cart__table">
						<table>
							<thead>
								<tr>
									<th>Product</th>
									<th>Price</th>
									<th>Quantity</th>
									<th>Size</th>
									<th></th>
								</tr>
							</thead>
							<tbody>
								<c:forEach var="cart" items="${cartlist}">
									<tr id="cartnum${cart.cartnum}">
										<td class="cart__product__item"><img
											src="img/shop-cart/cp-1.jpg" alt="">
											<div class="cart__product__item__title">
												<h2 hidden="" id ="code">${cart.code}</h2>
												<h6 id="cname">${cart.cname}</h6>
												<!-- 상품이름  -->

												<div class="rating">
													<i class="fa fa-star"></i> <i class="fa fa-star"></i> <i
														class="fa fa-star"></i> <i class="fa fa-star"></i> <i
														class="fa fa-star"></i>
												</div>
											</div></td>
										<td class="cart__price" id="price">${cart.price}</td>
										<!-- 상품 가격 -->
										<td class="cart__quantity">
											<div class="pro-qty">
												<!-- <span class="dec qtybtn">-</span> -->
												<input type="text" id="qty" value="${cart.qty}">
												<!-- 상품 수량 -->
												<!-- <span class="inc qtybtn">+</span> -->
											</div>
										</td>
										<td class="cart__total" id="size">${cart.size}</td>
										<!-- 상품 토탈 가격 -->
										<td class="cart__close" id="cartdel"><span class="icon_close test"></span>
											<input type="hidden" value="${cart.cartnum}"></td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</div>
				</div>
			</div>
			<div class="row">
				<!-- <div class="col-lg-6 col-md-6 col-sm-6">
                    <div class="cart__btn update__btn">
                        <a href="#"><span class="icon_loading"></span> Update cart</a>
                    </div>
                </div> -->
				<div class="col-lg-6 col-md-6 col-sm-6">
					<div class="cart__btn">
						<a href="${path}/main">Continue Shopping</a>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col-lg-6">
					<!--                     <div class="discount__content">
                        <h6>Discount codes</h6>
                        <form action="#">
                            <input type="text" placeholder="Enter your coupon code">
                            <button type="submit" class="site-btn">Apply</button>
                        </form>
                    </div> -->
				</div>
				<div class="col-lg-4 offset-lg-2">
					<div class="cart__total__procced">
						<h6>Cart total</h6>
						<ul>
							<li>Total <span id ="totprice">$ ${cartlist[0].totprice}</span></li>
							<%-- <li>Total <span id ="totprice">$ ${cartlist[0].totprice}</span></li> --%>

						</ul>
						<a href="${path}/cart/payment?userid=${sessionScope.mdto.userid}&totprice=${cartlist[0].totprice}" class="primary-btn">Proceed to checkout</a>
					</div>
				</div>
			</div>
		</div>
	</section>
	<!-- Shop Cart Section End -->

	<!-- Footer Section Begin -->
	<footer class="footer">
		<div class="container">
			<div class="row">
				<div class="col-lg-12">
					<!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->
					<div class="footer__copyright__text">
						<p>
							portfolio ©
							<script>
								document.write(new Date().getFullYear());
							</script>
							2020 All rights reserved | This is my portfolio <i
								class="fa fa-heart" aria-hidden="true"></i> by Colorlib
						</p>
					</div>

				</div>
			</div>
		</div>
	</footer>

</body>
</html>