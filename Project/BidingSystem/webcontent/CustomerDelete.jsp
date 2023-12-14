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
	<div class="topBar">
        <h2>Delete User Account</h2>
    </div>
    <div class="sideBar">

    </div>
    <div class="bodyContent">
    
    

    		<div class="info">
    			<form method="post" action="cusDelete">
    				
    				<input type="submit" name="submit" value="Delete Profile" id="button">
    			
    			</form>
	    	
	    	</div>		

    </div>

</body>
</html>