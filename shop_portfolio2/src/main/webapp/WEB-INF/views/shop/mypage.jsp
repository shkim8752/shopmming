<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../include/includeFile.jsp" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
<style type="text/css">
    #logo{
    	display: block;
    	margin-left: 600px;
    }
</style>
<script type="text/javascript">


	$(function(){

		//수정시 체크
		$('#btnsubmit').on('click', function(e){
			var userid = $('#userid').val();
			var passwd = $('#passwd').val();
			var name = $('#name').val();
			var email = $('#email').val();
			var address = $('#address').val();
			
			if (passwd == ''){
				alert('패스워드를 입력해 주세요!');
				MyPageForm.oldpasswd.focus();
			}else if (name == ''){
				alert('이름을 입력해 주세요!');
				MyPageForm.email.focus();
			}else if(email == ''){
				alert('이메일을 입력해 주세요!');
				MyPageForm.email.focus();
			}else if(address == ''){
				alert('주소를 입력해 주세요!');
				MyPageForm.email.focus();
			}else{
				$('#MyPageForm').submit();
			}
		});

	});
	
	function main() {
		location.href = '${path}/main';
	}

</script>
</head>
<body>
		<a href="${path}/main"><img  id="logo" src="${path}/resources/img/logo2.webp"  width="350px" height="130px" ></a>
		<div id="Mypage">
        <h3 class="text-center text-white pt-5">MyPage</h3>
        <div class="container">
            <div id="login-row" class="row justify-content-center align-items-center">
                <div id="Mypage-column" class="col-md-6">
                    <div id="Mypage-box" class="col-md-12">
                    
                        <form id="MyPageForm" class="form" action="${path}/mypage" method="post">
                            <h3 class="text-center text-info">MyPage</h3>
                            <div class="form-group">
                                <label for="username" class="text-info">Userid:</label><br>
                                <input type="text"class="form-control"name="userid" id="userid" value="${dto.userid}" readonly>
                            </div>
                            <div class="form-group">
                                <label for="password" class="text-info">Password:</label><br>
                                <input type="password" name="passwd" id="passwd" class="form-control" >
                            </div>
                            <div class="form-group">
                                <label for="name" class="text-info">name:</label><br>
                                <input type="text" name="name" id="name" class="form-control"value="${dto.name}" >
                            </div>
                            <div class="form-group">
                                <label for="email" class="text-info">email:</label><br>
                                <input type="text" name="email" id="email" class="form-control" value="${dto.email}">
                            </div>
                            <div class="form-group">
                                <label for="address" class="text-info">address:</label><br>
                                <input type="text" name="address" id="address" class="form-control"value="${dto.address}">
                            </div>                            
                            <div class="form-group">                              
                                <input type="button" name="btnsubmit" id="btnsubmit" class="btn btn-info btn-md" value="수정" >
                                <input type="button" name="btnmain" class="btn btn-info btn-md" value="취소" onclick="main()">
                            </div>
                        </form>  
                                          
                    </div>
                </div>                
            </div>            	
        </div>
    </div>
</body>
</html>