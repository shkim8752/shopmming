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
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<style type="text/css">

 #logo{
    	display: block;
    	margin-left: 600px;
    }
</style>
</head>
<body>
	<a href="${path}/main"><img  id="logo" src="${path}/resources/img/logo2.webp"  width="350px" height="130px" ></a>
	 <div id="login">
        <h3 class="text-center text-white pt-5">Login form</h3>
        <div class="container">
            <div id="login-row" class="row justify-content-center align-items-center">
                <div id="login-column" class="col-md-6">
                    <div id="login-box" class="col-md-12">
                    
                        <form id="login-form" class="form" action="${path}/login" method="post">
                            <h3 class="text-center text-info">Login</h3>
                            <div class="form-group">
                                <label for="username" class="text-info">Userid:</label><br>
                                <input type="text" name="userid" id="userid" class="form-control">
                            </div>
                            <div class="form-group">
                                <label for="password" class="text-info">Password:</label><br>
                                <input type="password" name="passwd" id="passwd" class="form-control">
                            </div>
                            <div class="form-group">                              
                                <input type="submit" name="submit" class="btn btn-info btn-md" value="login">
                            </div>
                        </form>  
                                          
                    </div>
                </div>                
            </div>            	
        </div>
    </div>
</body>
</html>