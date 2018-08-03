<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

  
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  
  <style>
color: #ff0000;
 background-color: #ffEEEE;
 </style>
</head>
<body>

<div class="container">
  <h2>My Login Form</h2>
  <form action="login" method="post">
    <div class="form-group">
      <label for="uname">Username:</label>
      <input type="text" class="form-control validate numericOnly2" id="uname" placeholder="Enter username" name="uname">
    </div>
    <div class="form-group">
      <label for="pwd">Password:</label>
      <input type="password" class="form-control numericOnly2" id="pwd" placeholder="Enter password" name="pwd">
    </div>
    <button type="submit" id="submit1" class="btn btn-default">Submit</button>
  </form>
</div>

</body>

<script type='text/javascript' src='/JS/jquery-1.11.1.min.js'></script>

<script type='text/javascript' src='JS/customValidation.js'></script>



</html>
