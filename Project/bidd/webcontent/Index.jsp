<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Online Payment Form</title>
    <link rel="stylesheet" type="text/css" href="payment.css">
</head>
<body>

  

    <form action="<%= request.getContextPath() %>/payment" method="post">
        <!-- User Information -->
        <label for="username">User name:</label>
        <input type="text" id="username" name="username" required><br>

        <label for="email">Email:</label>
        <input type="email" id="email" name="email" required><br>

        <!-- Payment Information -->
        <label for="cardNumber">Card Number:</label>
        <input type="text" id="cardNumber" name="cardNumber" required><br>

        <label for="expiryDate">ExpiryDate:</label>
        <input type="text" id="expiryDate" name="expiryDate" placeholder="MM/YY" required><br>

        <label for="cvv">CVV:</label>
        <input type="text" id="cvv" name="cvv" required><br>

        <!-- Transaction Information -->
        <input type="hidden" name="userId" value="1"> <!-- Replace with actual user ID -->
        <input type="hidden" name="itemId" value="1"> <!-- Replace with actual item ID -->
        <input type="hidden" name="amount" value="100.00"> <!-- Replace with actual amount -->

        <!-- Submit Button -->
        <input type="submit" value="Submit Payment">
    </form>

</body>
</html>
