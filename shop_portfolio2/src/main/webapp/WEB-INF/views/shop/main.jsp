<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../include/includeFile.jsp" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>쇼핑몰 </title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
<style type="text/css">

  	#login_menu{
		left: 30px;
	    top: 40px;
	    width: auto;
	    background: rgba(255,255,255,0);
	    padding-bottom: 20px;	
	}   
 	
  	#shop{
 	font-size: 30px;
 	margin-left: 20px;	
 	} 
 	
 	 table{          
            float: left;
            margin-left: 20px;			
            font-size: 20px;
      }
       
	#addres{
	  
    }
    
    #logo{
    	display: block;
    	margin-left: 600px;
    }
    
  	.img-thumbnail{
  		width="304" height="236"
  		
  	}
   	
</style>
<script type="text/javascript">
	$(function() {
		//로그인 처리 
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
	})
	



</script>


</head>
<body>
		<a href="${path}/main"><img  id="logo" src="${path}/resources/img/logo2.webp" width="300px" height="130px" ></a>	
		
		<div id="login_menu">
			<ul>
				<li >
					<a href="${path}/login"  id="login">login</a>
					${sessionScope.mdto.userid} 
					<span>I</span>
					<a href="${path}/logout" id="logout">logout</a>
					<span>I</span>
					<a href="${path}/join" id="join">joins</a>
				</li>
					     
				<li>
					<a href="${path}/cart/cart" id="cart">cart</a> 
					<span>I</span>
					<a href="${path}/mypage" class="tuxedo-menu-trigger last">mypage</a>
				</li>
			</ul>
		
		</div>						
	

<div class="jumbotron text-center">
  <h1>shoping mall</h1>
  <p>this is my portfolio</p> 
</div>

  <h3 id="shop">shop</h3>  
  <table>
        <tr>
            <th><a href="${path}/clothes/top">top</a></th>
        </tr>  
       <tr>
            <th><a href="${path}/clothes/top">pants</a></th>
        </tr>   
        <tr>
            <th><a href="${path}/clothes/top">shoes</a></th>
        </tr>     
    </table>
    
<!--     <div id="addres">
  		서울특별시 양천구 신월7동<br>
		신월 시영아파트 13동 606호
  	</div>  -->

  	
 <div class="container">
  <div class="row">
    <div class="col-sm-4">
	    <div class="container">
	  		<img src="${path}/resources/img/model1.jpg" class="img-thumbnail" alt="Cinque Terre"> 
		</div>
    </div>
    <div class="col-sm-4">
		 <div class="container">
	  		<img src="${path}/resources/img/model2.jpg" class="img-thumbnail" alt="Cinque Terre" > 
		</div>
    </div>
     <div class="col-sm-4">
     	 <div class="container">
	  		<img src="${path}/resources/img/model5.jpg" class="img-thumbnail" alt="Cinque Terre"> 
		</div>
    </div>
  </div>
</div>
	

</body>
</html>