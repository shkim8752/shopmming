<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../include/includeFile.jsp" %>
<%@ include file="../include/detailTem.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품상세페이지</title>
   
<script type="text/javascript">
   
   $(function() {
      $('#btnCart').on('click',function(e){
         if($('#Sbtn').hasClass("active")){
            var size = "s";
            var price = $('#price').text();
            var cname = $('#cname').text();
            var code = $('#code').text();
            var qty = $('#qtyNum').val();
            var userid = $('#userid').text(); 
         }else if($('#Mbtn').hasClass("active")){
             var size = "M";
             var price = $('#price').text();
             var cname = $('#cname').text();
             var code = $('#code').text();
             var qty = $('#qtyNum').val();
             var userid = $('#userid').text();
          }else if($('#Lbtn').hasClass("active")){
             var size = "L";
             var price = $('#price').text();
             var cname = $('#cname').text();
             var code = $('#code').text();
             var qty = $('#qtyNum').val();
             var userid = $('#userid').text();
          }else if($('#280btn').hasClass("active")){
             var size = "280";
             var price = $('#price').text();
             var cname = $('#cname').text();
             var code = $('#code').text();
             var qty = $('#qtyNum').val();
             var userid = $('#userid').text();
          }else if($('#270btn').hasClass("active")){
             var size = "270";
             var price = $('#price').text();
             var cname = $('#cname').text();
             var code = $('#code').text();
             var qty = $('#qtyNum').val();
             var userid = $('#userid').text();
          }else if($('#260btn').hasClass("active")){
             var size = "260";
             var price = $('#price').text();
             var cname = $('#cname').text();
             var code = $('#code').text();
             var qty = $('#qtyNum').val();
             var userid = $('#userid').text();
          }else if($('#250btn').hasClass("active")){
             var size = "250";
             var price = $('#price').text();
             var cname = $('#cname').text();
             var code = $('#code').text();
             var qty = $('#qtyNum').val();
             var userid = $('#userid').text();
          }else if($('#240btn').hasClass("active")){
             var size = "240";
             var price = $('#price').text();
             var cname = $('#cname').text();
             var code = $('#code').text();
             var qty = $('#qtyNum').val();
             var userid = $('#userid').text();
          }else if($('#230btn').hasClass("active")){
             var size = "230";
             var price = $('#price').text();
             var cname = $('#cname').text();
             var code = $('#code').text();
             var qty = $('#qtyNum').val();
             var userid = $('#userid').text();
          }
			
       /* alert(size); alert(price); alert(userid);alert(code);alert(qty);  */
            
            $.ajax({
                type:'post',
               contentType:'application/json',//json: 키와 값으로 생김 
                url : '${path}/cart/addCart',
                data : JSON.stringify({userid:userid,code:code,price:price,size:size,qty:qty,cname:cname}), //json문자열 표기법으로 변환 
                dataType : 'text',  //결과값의 타입
                success : function(result){
                	alert(result);
                	$(location).attr('href',
        					'${path}/cart/list?userid='+userid);                   
                },
                error:function(result){
                   alert("error");
                   console.log(result);
                }
             });
         });
   	
     
      
      $('#decQtybtn').on('click',function(){
         var qtyNum = $('#qtyNum').val();
         qtyNum = Number(qtyNum) - 1 ;
         if(qtyNum == 0){
            alert("최소 갯수는 1개입니다");
            qtyNum = 0;
         }else{
            $('#qtyNum').val(qtyNum);            
         };
      })
      $('#incQtybtn').on('click',function(){
         var qtyNum = $('#qtyNum').val();
         qtyNum = Number(qtyNum) + 1 ;
         if(qtyNum == 11){
            alert("최대 갯수는 10개입니다");
            qtyNum = 11;
         }else{
            $('#qtyNum').val(qtyNum);            
         };
      })
      
      $('#s-btn').click(function() {
          $(this).parent().addClass("active");
          $('#Mbtn').removeClass("active");
          $('#Lbtn').removeClass("active");
      });
      $('#m-btn').click(function() {
          $(this).parent().addClass("active");
          $('#Sbtn').removeClass("active");
          $('#Lbtn').removeClass("active");
      });
      $('#l-btn').click(function() {
          $(this).parent().addClass("active");
          $('#Sbtn').removeClass("active");
          $('#Mbtn').removeClass("active");
      });
     
      $('#280-btn').click(function() {
          $(this).parent().addClass("active");
          $('#270btn').removeClass("active");
          $('#260btn').removeClass("active");
          $('#250btn').removeClass("active");
          $('#240btn').removeClass("active");
          $('#230btn').removeClass("active");
      });
      $('#270-btn').click(function() {
          $(this).parent().addClass("active");
          $('#280btn').removeClass("active");
          $('#260btn').removeClass("active");
          $('#250btn').removeClass("active");
          $('#240btn').removeClass("active");
          $('#230btn').removeClass("active");
      });
      $('#260-btn').click(function() {
          $(this).parent().addClass("active");
          $('#280btn').removeClass("active");
          $('#270btn').removeClass("active");
          $('#250btn').removeClass("active");
          $('#240btn').removeClass("active");
          $('#230btn').removeClass("active");
      });
      $('#250-btn').click(function() {
          $(this).parent().addClass("active");
          $('#280btn').removeClass("active");
          $('#270btn').removeClass("active");
          $('#260btn').removeClass("active");
          $('#240btn').removeClass("active");
          $('#230btn').removeClass("active");
      });
      $('#240-btn').click(function() {
          $(this).parent().addClass("active");
          $('#280btn').removeClass("active");
          $('#270btn').removeClass("active");
          $('#260btn').removeClass("active");
          $('#250btn').removeClass("active");
          $('#230btn').removeClass("active");
      });
      $('#230-btn').click(function() {
          $(this).parent().addClass("active");
          $('#280btn').removeClass("active");
          $('#270btn').removeClass("active");
          $('#260btn').removeClass("active");
          $('#250btn').removeClass("active");
          $('#240btn').removeClass("active");
      });
      
      if('${sessionScope.mdto.userid}' == ""){	//로그인이 안됬을 때 
			$('#login').show();
			$('#join').show();
		}else{
			$('#login').hide();
			$('#join').hide();
		}
      
   });
   
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
                           <a id=userid>${sessionScope.mdto.userid}</a>
                            <a href="${path}/join" id="join">Join</a>
                        </div>
                        <ul class="header__right__widget">
                            <li><a href=""><span class="icon_bag_alt"></span>
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
                    <div class="shop__sidebar">
                        <div class="sidebar__categories">
                            <div class="section-title">
                                <h4>Categories</h4>
                            </div>
                            <div class="categories__accordion">
                                <div class="accordion" id="accordionExample">
                                    <div class="card">
                                        <div class="card-heading">
                                            <a data-toggle="collapse" data-target="#collapseOne" class="" aria-expanded="true">Top</a>
                                        </div>
                                    </div>
                                    <div class="card">
                                        <div class="card-heading">
                                            <a data-toggle="collapse" data-target="#collapseTwo">Pants</a>
                                        </div>
                                    </div>
                                    <div class="card">
                                        <div class="card-heading">
                                            <a data-toggle="collapse" data-target="#collapseThree">Shoes</a>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>                        
                    </div>
                </div>
                <div class="col-lg-9 col-md-9">
                    <div class="row">
                      <section class="product-details spad">
                       <div class="container">
                           <div class="row">
                               <div class="col-lg-6">
                                   <div class="product__details__pic">
                                       <div class="product__details__slider__content">
                                           <div class="product__details__pic__slider owl-carousel owl-loaded">
                                              <div class="owl-stage-outer">
                                                 <div class="owl-stage" style="transform: translate3d(0px, 0px, 0px); transition: all 0s ease 0s; width: 2073px;">
                                                    <div class="owl-item active" style="width: 518.2px;">
                                                       <img data-hash="product-1" class="product__big__img" src="${path}/localimg/${clothes.filename}"  alt="">
                                                    </div>
                                                </div>
                                            </div>
                                           </div>
                                       </div>
                                   </div>
                               </div>
                               <div class="col-lg-6">
                                   <div class="product__details__text">
                                       <h3 id="cname">${clothes.cname}</h3>
                                       <span>부가설명</span>
                                       <h2 hidden="" id="code">${clothes.code}</h2>
                                       <div class="rating">
                                           <i class="fa fa-star"></i>
                                           <i class="fa fa-star"></i>
                                           <i class="fa fa-star"></i>
                                           <i class="fa fa-star"></i>
                                           <i class="fa fa-star"></i>
                                           <span>( 0 reviews )</span>
                                       </div>
                                       <div class="product__details__price" id="price">${clothes.price}</div>
                                       <p>상세설명란</p>
                                       <div class="product__details__button">
                                           <div class="quantity">
                                               <span>Quantity:</span>
                                               <div class="pro-qty">
                                                  <span class="dec qtybtn" id="decQtybtn">-</span>
                                                        <input type="text" value="1" id="qtyNum">
                                                  <span class="inc qtybtn" id="incQtybtn">+</span></div>
                                           </div>
                                           <a href="#" class="cart-btn" id="btnCart"><span class="icon_bag_alt"></span> Add to cart</a>
                                       </div>
                                       <div class="product__details__widget">
                                           <ul>
                                               <!-- <li>
                                                   <span>color:</span>
                                                   <div class="color__checkbox">
                                                       <label for="red">
                                                           <input type="radio" name="color__radio" id="red" checked="">
                                                           <span class="checkmark"></span>
                                                       </label>
                                                       <label for="black">
                                                           <input type="radio" name="color__radio" id="black">
                                                           <span class="checkmark black-bg"></span>
                                                       </label>
                                                       <label for="grey">
                                                           <input type="radio" name="color__radio" id="grey">
                                                           <span class="checkmark grey-bg"></span>
                                                       </label>
                                                   </div>
                                               </li> -->
                                        
                                               <li id="sizePick">
                                                   <span>size:</span>
                                                   <div class="size__btn">
                                                      <c:forEach var="size" items="${sizeList}">
                                                           <c:if test="${size.size == 'L'}">
                                                             <label for="l-btn" id="Lbtn">
                                                      <input type="radio" id="l-btn" name="l">
                                                     ${size.size} 
                                                             </label>
                                                </c:if>
                                                
                                                           <c:if test="${size.size == 'M'}">
                                                   <label for="m-btn" id="Mbtn">
                                                      <input type="radio" id="m-btn" name="m">
                                                      ${size.size}
                                                   </label>
                                                </c:if>
                                                
                                                           <c:if test="${size.size == 'S'}">
                                                              <label for="s-btn" id="Sbtn">
                                                      <input type="radio" id="s-btn" name="s">
                                                      ${size.size}
                                                   </label>
                                                </c:if>
                                                
												<c:if test="${size.size == '280'}">
                                                              <label for="280-btn" id="280btn">
                                                      <input type="radio" id="280-btn" name="size">
                                                      ${size.size}
                                                   </label>
                                                </c:if>
                                                           <c:if test="${size.size == '270'}">
                                                              <label for="270-btn" id="270btn">
                                                      <input type="radio" id="270-btn" name="size">
                                                      ${size.size}
                                                   </label>
                                                </c:if>
                                                           <c:if test="${size.size == '260'}">
                                                              <label for="260-btn" id="260btn">
                                                      <input type="radio" id="260-btn" name="size">
                                                      ${size.size}
                                                   </label>
                                                </c:if>
                                                           <c:if test="${size.size == '250'}">
                                                              <label for="250-btn" id="250btn">
                                                      <input type="radio" id="250-btn" name="size">
                                                      ${size.size}
                                                   </label>
                                                </c:if>
                                                           <c:if test="${size.size == '240'}">
                                                              <label for="240-btn" id="240btn">
                                                      <input type="radio" id="240-btn" name="size">
                                                      ${size.size}
                                                   </label>
                                                </c:if>
                                                           <c:if test="${size.size == '230'}">
                                                              <label for="230-btn" id="230btn">
                                                      <input type="radio" id="230-btn" name="size">
                                                      ${size.size}
                                                   </label>
                                                </c:if>
                                                      </c:forEach>
                                                   </div>
                                               </li>
                                           </ul>
                                       </div>
                                   </div>
                               </div>
                               
                           </div>
                       </div>
                   </section>
                    </div>
                </div>
            </div>
        </div>
    </section>
    <!-- Shop Section End -->

    
   <section class="product-details spad">
        <div class="container">
            <div class="row">
                <div class="col-lg-12">
                    <div class="product__details__tab">
                        <ul class="nav nav-tabs" role="tablist">
                            <li class="nav-item">
                                <a class="nav-link active" data-toggle="tab" href="#tabs-1" role="tab">Description</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" data-toggle="tab" href="#tabs-2" role="tab">Specification</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" data-toggle="tab" href="#tabs-3" role="tab">Reviews ( 2 )</a>
                            </li>
                        </ul>
                        <div class="tab-content">
                            <div class="tab-pane active" id="tabs-1" role="tabpanel">
                                <h6>Description</h6>
                                <p>Nemo enim ipsam voluptatem quia voluptas sit aspernatur aut odit aut loret fugit, sed
                                    quia consequuntur magni dolores eos qui ratione voluptatem sequi nesciunt loret.
                                    Neque porro lorem quisquam est, qui dolorem ipsum quia dolor si. Nemo enim ipsam
                                    voluptatem quia voluptas sit aspernatur aut odit aut loret fugit, sed quia ipsu
                                    consequuntur magni dolores eos qui ratione voluptatem sequi nesciunt. Nulla
                                consequat massa quis enim.</p>
                                <p>Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo ligula eget
                                    dolor. Aenean massa. Cum sociis natoque penatibus et magnis dis parturient montes,
                                    nascetur ridiculus mus. Donec quam felis, ultricies nec, pellentesque eu, pretium
                                quis, sem.</p>
                            </div>
                            <div class="tab-pane" id="tabs-2" role="tabpanel">
                                <h6>Specification</h6>
                                <p>Nemo enim ipsam voluptatem quia voluptas sit aspernatur aut odit aut loret fugit, sed
                                    quia consequuntur magni dolores eos qui ratione voluptatem sequi nesciunt loret.
                                    Neque porro lorem quisquam est, qui dolorem ipsum quia dolor si. Nemo enim ipsam
                                    voluptatem quia voluptas sit aspernatur aut odit aut loret fugit, sed quia ipsu
                                    consequuntur magni dolores eos qui ratione voluptatem sequi nesciunt. Nulla
                                consequat massa quis enim.</p>
                                <p>Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo ligula eget
                                    dolor. Aenean massa. Cum sociis natoque penatibus et magnis dis parturient montes,
                                    nascetur ridiculus mus. Donec quam felis, ultricies nec, pellentesque eu, pretium
                                quis, sem.</p>
                            </div>
                            <div class="tab-pane" id="tabs-3" role="tabpanel">
                                <h6>Reviews ( 2 )</h6>
                                <p>Nemo enim ipsam voluptatem quia voluptas sit aspernatur aut odit aut loret fugit, sed
                                    quia consequuntur magni dolores eos qui ratione voluptatem sequi nesciunt loret.
                                    Neque porro lorem quisquam est, qui dolorem ipsum quia dolor si. Nemo enim ipsam
                                    voluptatem quia voluptas sit aspernatur aut odit aut loret fugit, sed quia ipsu
                                    consequuntur magni dolores eos qui ratione voluptatem sequi nesciunt. Nulla
                                consequat massa quis enim.</p>
                                <p>Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo ligula eget
                                    dolor. Aenean massa. Cum sociis natoque penatibus et magnis dis parturient montes,
                                    nascetur ridiculus mus. Donec quam felis, ultricies nec, pellentesque eu, pretium
                                quis, sem.</p>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>
    
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