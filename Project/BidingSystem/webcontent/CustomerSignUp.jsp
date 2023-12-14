<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="SignUp.css">
</head>
<body>
	<div class="colorBox">
        <div class="hText">
            <h1>Sign Up</h1>
          
            <div class="hh">
               <a href="CustomerLogin.jsp" input type="submit">Have An Account</a>   
            </div>
            </div>
        <div class="inpFiled">
            <form action="insert" method="post">
                <label><b>Full Name</b></label><br>
                <input type="text" id="fname" name="fname" placeholder="Frist Name"required>
                <input type="text" id="lname" name="lname" placeholder="Last Name"required><br>
                <label><b>Email</b></label><br>
                <input type="email" id="email" name="email" placeholder="123@gmail.com"required><br>
                <label><b>Phone</b></label><br>
                <input type="text" id="phone" name="phone" placeholder="0xx-xxxxxxx"required><br>
                <label><b>Password</b></label><br>
                <input type="text" id="pw" name="pw" placeholder="password"pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,}" title="Must contain at least one number and one uppercase and lowercase letter, and at least 8 or more characters"required><br>
                
                
                <input type ="submit" name="submit" value="Create Account" id="button">
                
            </form>
           
        </div>
    </div>

</body>
</html>