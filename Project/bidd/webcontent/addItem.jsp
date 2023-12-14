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

    <!-- font awesome cdn link  -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css">

    <!-- custom css file link  -->
    <link rel="stylesheet" href="mainitem.css">

</head>
<body>
    <jsp:include page="header.jsp"></jsp:include> 
</br></br></br></br>

<!-- booking section starts   -->

  <div class="b1">
    <section class="book" id="book">
  <h1 class="heading"> 
		<c:if test="${item != null}">
            <span>Edit</span> Item
		</c:if>
		<c:if test="${item == null}">
			 <span>Add</span> Item
        </c:if>
	  </h1>

      <div class="row">
       
        <c:if test="${item != null}">
             <form action="itm_update" method="post">
        </c:if>
        <c:if test="${item == null}">
			  <form action="itm_insert" method="post">
		</c:if>
		
		
		<c:if test="${item != null}">
              <input type="hidden" name="code"  value="<c:out value='${item.code}' />" />
        </c:if>
          <label for="name">Title :</label>
          <input type="text" class="box" name ="title" value="<c:out value='${item.title}' />">
          <br>

          <label for="name">Category :</label>
          <input type="text" class="box" name ="category" value="<c:out value='${item.category}' />">
          <br>

          <label for="name">Start Price :</label>
          <input type="text" class="box" name ="sprice" value="<c:out value='${item.sprice}' />">
          <br>

          <label for="name">Description :</label>
          <input type="text"class="box" name ="description" value="<c:out value='${item.description}' />">
          <br>

          <label for="name">Biding Time :</label>
          <select class="box" name ="bidtime">
          
          <option selected>
              <c:if test="${item != null}">
                    <c:out value='${item.bidtime}' />
			  </c:if>
              <c:if test="${item == null}">
                     Choose Biding Time
              </c:if>
            </option>
            <option value="One Day">One Day</option>
            <option value="One Week">One Week</option>
            <option value="One Month">One Month</option>
            <option value="Three Month">Three Month</option>
          </select>
          <br>

          <input type="submit" <c:if test="${item != null}"> value = "update Item" </c:if> <c:if test="${item == null}">value = "Add Item"</c:if> class="btn12">
        </form>

      </div>

    </section>
    <br><br><br>
  </div>
</br></br></br>
<jsp:include page="footer.jsp"></jsp:include> 
</body>
</html>