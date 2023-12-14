<%@ page language="java" contentType="text/html; charset=UTF-8"
 pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>

<head>
    <title>Item Details</title>

    <link href="style.css" rel="stylesheet" />

</head>

<body>
     <jsp:include page="header.jsp"></jsp:include> 
        </br></br></br></br>

        <div class="table-container">

            <table>
                <tr>
                    <th>Id</th>
                    <th>Fname</th>
                    <th>Lname</th>
                    <th>Email</th>
                    <th>Phone</th>
                    <th>password</th>
                   
                    
                </tr>
				<c:forEach var = "item" items = "${listcust}">
				<tr> 
				
					<td><c:out value="${item.id}" /></td>
					<td><c:out value="${item.fname}" /></td>
					<td><c:out value="${item.lname}" /></td>
					<td><c:out value="${item.email}" /></td>
					<td><c:out value="${item.phone}" /></td>
					<td><c:out value="${item.password}" /></td>
					<td><a href="usr_edit?code=<c:out value='${item.id}' />">Edit</a> &nbsp;&nbsp;&nbsp;&nbsp; <a href="itm_delete?code=<c:out value='${item.code}' />">Delete</a></td>
					
				
				</tr>
				</c:forEach>
            </table>

        </div>
        <br><br><br><br><br><br><br><br><br><br><br><br>
</br></br></br></br></br>

        <jsp:include page="footer.jsp"></jsp:include>     
</body>

</html>