<%@ page language="java" contentType="text/html; charset=UTF-8"
 pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
  
<!DOCTYPE html>
<html>

<head>
    <title>Contact Message</title>

    <link href="Vcon.css" rel="stylesheet" />

</head>

<body>
     <jsp:include page="header.jsp"></jsp:include> 
        </br></br></br></br>

        <div class="table-container">

            <table>
                <tr>
                    <th>Id</th>
                    <th>Name</th>
                    <th>Email</th>
                    <th>Message</th>
                   
                    
                    <th>Action</th>
                    
                </tr>
				<c:forEach var = "contact" items = "${listContact}">
				<tr> 
				
			
					<td><c:out value="${contact.id}" /></td>				
					<td><c:out value="${contact.name}" /></td>
					<td><c:out value="${contact.email}" /></td>
					<td><c:out value="${contact.message}" /></td>
					
					<td><a href="con_edit?id=<c:out value='${contact.id}' />">Edit</a> &nbsp;&nbsp;&nbsp;&nbsp; <a href="con_delete?id=<c:out value='${contact.id}' />">Delete</a></td>
					
				
				</tr>
				</c:forEach>
            </table>

        </div>
        <br><br><br><br><br><br><br><br><br><br><br><br>

</br></br></br></br></br>
      <jsp:include page="footer.jsp"></jsp:include>       
</body>

</html>