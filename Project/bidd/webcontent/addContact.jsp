<%@ page language="java" contentType="text/html; charset=UTF-8"
 pageEncoding="UTF-8"%>
  <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

   
    
 

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Add Item </title>


    <!-- custom css file link  -->
    <link rel="stylesheet" href="Acon.css">

</head>
<body>
<jsp:include page="header.jsp"></jsp:include> 
    
</br></br></br></br></br></br>



  <div class="b1">
    <section class="con" id="book">
  <h1 class="heading"> 
		<c:if test="${contact != null}">
            <span>Edit </span> Contact
		</c:if>
		<c:if test="${contact == null}">
			 <span>Contact</span> Us
        </c:if>
	  </h1>

      <div class="row">
       
        <c:if test="${contact != null}">
             <form action="con_update" method="post">
        </c:if>
        <c:if test="${contact == null}">
			  <form action="con_insert" method="post">
		</c:if>
		
		
		<c:if test="${contact != null}">
              <input type="hidden" name="id" value="<c:out value='${contact.id}' />" />
        </c:if>
          <label for="name">Name :</label>
          <input type="text" class="box" name ="name" value="<c:out value='${contact.name}' />">
          <br>

          <label for="name">Email :</label>
          <input type="text" class="box" name ="email" value="<c:out value='${contact.email}' />">
          <br>

          <label for="name">Message :</label>
          <input type="textarea" class="box" name ="message"  maxlength="300"value="<c:out value='${contact.message}' />">
          <br>

          <br>

          <input type="submit" <c:if test="${contact != null}"> value = "update Message" </c:if> <c:if test="${contact == null}">value = "Add Message"</c:if> class="btn12">
        </form>

      </div>

    </section>
    <br><br><br>
  </div>
</br></br></br></br>
<jsp:include page="footer.jsp"></jsp:include> 
</body>
</html>