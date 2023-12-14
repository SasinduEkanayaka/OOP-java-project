<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="CustomerUpdate.css">

</head>
<body>
 <jsp:include page="header.jsp"></jsp:include> 
   </br></br></br></br>
	
	<%
		String fname = request.getParameter("fname");
		String lname = request.getParameter("lname");
		String email = request.getParameter("email");
		String phone = request.getParameter("phone");
	%>

    <div class="sideBar">

    </div>
    <div class="bodyContent">
    
    	<h1>Update Profile</h1>

    		<div class="info">
    			<form method="post" action="update">
    				
    				<h3>First Name:</h3>
    				<input type="text" name="fname" value="<%= fname %>"><hr>
    				
    				<h3>Last Name:</h3>
    				<input type="text" name="lname" value="<%= lname %>"><hr>
    				
    				<h3>Email:</h3>
    				<input type="text" name="email" value="<%= email %>"><hr>
    				
    				<h3>Phone:</h3>
    				<input type="text" name="phone" value="<%= phone %>"><hr><br>
    				
    				<input type="submit" name="submit" value="update" id="button">
    			
    			</form>
	    	
	    	</div>		

    </div>

</body>
</html>