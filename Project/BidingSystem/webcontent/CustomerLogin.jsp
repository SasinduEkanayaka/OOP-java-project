<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
<link rel="stylesheet" href="Login.css">
</head>
<body>
	<div class="color_box">
        <div class="htext">
            <h1><b>Hello...</b></h1>
            <h3>Sign into your Account</h3>
        </div>
        <div class="btext">
            <h1>Welcome Back!</h1>
            <p>Lorem ipsum dolor sit amet consectetur adipisicing elit. Dicta quis vel fugit, quae repellat 
                adipisci, expedita odit velit temporibus earum nobis voluptatem.</p>
        </div>    
        <div class="frm">
                <form action="log" method="post">
                    <input type="text" id="email" name="email" placeholder="Email"><br>
                    <input type="text" id="password" name="password" placeholder="Password"><br>
                    <input type="submit" name="submit" value="Login" id="button">
                </form>
                <a class="fogPw" href="a">Forgot password?</a><br>
             
                <p>Don't have an account? <a class="dntAcc" href="CustomerSignUp.jsp">Create</a></p>
        </div>
    </div> 

</body>
</html>