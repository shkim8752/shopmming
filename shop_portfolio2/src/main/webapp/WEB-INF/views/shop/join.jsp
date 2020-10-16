<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../include/includeFile.jsp" %> 
<!DOCTYPE html>
<html>
<head>
<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<meta charset="EUC-KR">
<title>회원가입</title>
<style type="text/css">
    #logo{
    	display: block;
    	margin-left: 600px;
    }
</style>
<script type="text/javascript">
function joinCheck() {
	var userid = joinForm.userid.value;
	var passwd = joinForm.passwd.value;
	var email = joinForm.email.value;
	var address = joinForm.address.value;
	
	if (userid == ''){
		alert('아이디를 입력해 주세요!');
		joinForm.userid.focus();
	}else if (passwd == ''){
		alert('패스워드를 입력해 주세요!');
		joinForm.passwd.focus();
	}else if (email == ''){
		alert('이메일를 입력해 주세요!');
		joinForm.email.focus();
	}else if (address == ''){
		alert('주소를 입력해 주세요!');
		joinForm.address.focus();
	}else{
		joinForm.submit();	
	}
			
}

function main() {
	location.href = '${path}/main';
}



</script>
</head>
<body>
<a href="${path}/main"><img  id="logo" src="${path}/resources/img/logo2.webp" width="300px" height="130px" ></a>	
	<div id="Join">
        <h3 class="text-center text-white pt-5">Join</h3>
        <div class="container">
            <div id="login-row" class="row justify-content-center align-items-center">
                <div id="Mypage-column" class="col-md-6">
                    <div id="Mypage-box" class="col-md-12">
                    
                        <form id="joinForm" class="form" action="${path}/join" method="post">
                            <h3 class="text-center text-info">Join</h3>
                            <div class="form-group">
                                <label for="username" class="text-info">Userid:</label><br>
                                <input type="text" name="userid" id="userid" class="form-control">
                            </div>
                            <div class="form-group">
                                <label for="password" class="text-info">Password:</label><br>
                                <input type="password" name="passwd" id="passwd" class="form-control" >
                            </div>
                            <div class="form-group">
                                <label for="name" class="text-info">name:</label><br>
                                <input type="text" name="name" id="name" class="form-control">
                            </div>
                            <div class="form-group">
                                <label for="email" class="text-info">email:</label><br>
                                <input type="text" name="email" id="email" class="form-control"">
                            </div>
                            <div class="form-group">
                                <label for="address" class="text-info">address:</label><br>
                                <input type="text" name="address" id="address" class="form-control">
                            </div>                            
                            <div class="form-group">                              
                                <input type="button" class="btn btn-info btn-md" value="가입" onclick="joinCheck()">
                                <input type="button" class="btn btn-info btn-md" value="취소" onclick="main()">
                            </div>
                        </form>  
                                          
                    </div>
                </div>                
            </div>            	
        </div>
    </div>
	
	
	
	
</body>
</html>