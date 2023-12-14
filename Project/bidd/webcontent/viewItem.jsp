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
                    <th>Code</th>
                    <th>Title</th>
                    <th>Category</th>
                    <th>Start Price</th>
                    <th>Description</th>
                    <th>Biding Time</th>
                    
                    <th>Action</th>
                    
                </tr>
				<c:forEach var = "item" items = "${listItem}">
				<tr> 
				
					<td><c:out value="${item.code}" /></td>
					<td><c:out value="${item.title}" /></td>
					<td><c:out value="${item.category}" /></td>
					<td><c:out value="${item.sprice}" /></td>
					<td><c:out value="${item.description}" /></td>
					<td><c:out value="${item.bidtime}" /></td>
					<td><a href="usr_edit?code=<c:out value='${item.code}' />">Edit</a> &nbsp;&nbsp;&nbsp;&nbsp; <a href="usr_delete?code=<c:out value='${item.code}' />">Delete</a></td>
					
				
				</tr>
				</c:forEach>
            </table>

        </div>
        <br><br><br><br><br><br><br><br><br><br><br><br>
</br></br></br></br></br>

        <jsp:include page="footer.jsp"></jsp:include>     
</body>

</html>