<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../include/includeFile.jsp" %>
<%@ include file="../include/detailTem.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>결제창</title>
<script type="text/javascript">

   $(function(){
      
      if('${sessionScope.mdto.userid}' == ""){   //로그인이 안됬을 때
         
         $('#login').show();
         $('#logout').hide();
         $('#userid').hide();
         $('#mypage').hide();
         $('#join').show();
      }else{
         $('#login').hide();
         $('#join').hide();
         $('#logout').show();
         $('#mypage').show();
      }
      
      
      $('.site-btn').on('click',function(e){
          var userid = $('#formuserid').val();
          var phone = $('#phone').val();
          var address = $('#address').val();
          var address2 = $('#address2').val();

          
          if (userid == ''){
             alert('아이디를 입력해 주세요!');
             
          }else if (phone == ''){
             alert('핸드폰 번호를 입력해 주세요!');
             
          }else if(address == ''){
             alert('주소 입력해 주세요!');
             
          }else if(address2 == ''){
             alert('상세주소 입력해 주세요!');
             
          }else{
             alert("주문이 완료되었습니다.");
            /*  var userid = $('#userid').val(); */
            alert(userid);
             $('#payForm').attr('action','${path}/cart/allDelete?userid=' +userid);
          }
          
       });
      
   })

</script>
</head>
<body>
   <!-- Page Preloder -->
    <div id="preloder" style="display: none;">
        <div class="loader" style="display: none;"></div>
    </div>

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
                            <c:if test="${sessionScope.mdto.authority eq 1}">
                            <li><a>Manage Page</a>
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
                            <a href="${path}/join" id="join">Join</a>
                            <a href="${path}/mypage" id="userid">${sessionScope.mdto.userid}</a>
                            <a href="${path}/mypage" id="mypage">MyPage</a>
                        </div>
                        <ul class="header__right__widget">
                            <li><a id="cart"><span class="icon_bag_alt"></span>
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
                        <span>Shopping cart</span>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <!-- Breadcrumb End -->

    <!-- Checkout Section Begin -->
    <section class="checkout spad">
        <div class="container">
            <div class="row">
                <div class="col-lg-12">
                    <h6 class="coupon__link"><span class="icon_tag_alt"></span> <a href="#">Have a coupon?</a> Click
                    here to enter your code.</h6>
                </div>
            </div>
            <form id="payForm"  action="" class="checkout__form">
                <div class="row">
                    <div class="col-lg-8">
                        <h5>배송정보</h5>
                        <div class="row">
                            <div class="col-lg-6 col-md-6 col-sm-6">
                                <div class="checkout__form__input">
                                    <p>아이디 <span>*</span></p>
                                    <input type="text" name='userid' id='formuserid' value="${sessionScope.mdto.userid}">
                                </div>
                            </div>
                            <div class="col-lg-6 col-md-6 col-sm-6">
                                <div class="checkout__form__input">
                                    <p>휴대폰번호 <span>*</span></p>
                                    <input type="text" id="phone" placeholder="'-' 없이 입력해주세요">
                                </div>
                            </div>
                            <div class="col-lg-12">
                                <div class="checkout__form__input">
                                    <p>주소 <span>*</span></p>
                                    <input type="text" id="address" placeholder="도/시/읍까지 입력해주세요">
                                    <input type="text" id="address2" placeholder="상세주소입력">
                                </div>
                            </div>
                            <div class="col-lg-12">
                                <div class="checkout__form__checkbox">
                                    </div>
                                    
                                    <div class="checkout__form__input">
                                        <p>배송메모</p>
                                        <input type="text" placeholder="배송시 요구사항을 입력해주세요">
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="col-lg-4">
                            <div class="checkout__order">
                                <h5>Your order</h5>
                                <div class="checkout__order__product">
                                    <ul>
                                        <li>
                                            <span class="top__text">Product</span>
                                            <span class="top__text__right">Price</span>
                                        </li>
                                        <c:forEach var="cart" items="${cartlist}">
                                        <li>${cart.cname}<span>${cart.price}</span></li>
                                        </c:forEach>
                                    </ul>
                                </div>
                                <div class="checkout__order__total">
                                    <ul>
                                        <li>Total <span><%-- ${totprice} --%>원</span></li>
                                    </ul>
                                </div>
                                <div class="checkout__order__widget">
                                    <label for="o-acc">
                                        무통장입금
                                        <input type="checkbox" id="o-acc">
                                        <span class="checkmark"></span>
                                    </label>
                                    <p>입금확인 후 배송이 진행됩니다</p>
                                    <label for="check-payment">
                                        카카오페이
                                        <input type="checkbox" id="kakaoPay">
                                        <span class="checkmark"></span>
                                    </label>
                                    <label for="paypal">
                                        Tose
                                        <input type="checkbox" id="Tose">
                                        <span class="checkmark"></span>
                                    </label>
                                </div>
                                <button type="submit" class="site-btn">Place oder</button>
                            </div>
                        </div>
                    </div>
                </form>
            </div>
        </section>
    <!-- Checkout Section End -->

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