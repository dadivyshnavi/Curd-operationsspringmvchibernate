<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>



<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<title>Insert title here</title>
<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
  <link rel="stylesheet" href="/resources/demos/style.css">
</head>

<style>           
.blue-button{
	background: #25A6E1;
	filter: progid: DXImageTransform.Microsoft.gradient( startColorstr='#25A6E1',endColorstr='#188BC0',GradientType=0);
	padding:10px 20px;
	color:#fff;
	font-family:'Helvetica Neue',sans-serif;
	font-size:18px;
	border-radius:2px;
	-moz-border-radius:2px;
	-webkit-border-radius:4px;
	border:1px solid #1A87B9;
	
	
}  
.span-12 { text-align: center;}   
table {
  font-family: "Helvetica Neue", Helvetica, sans-serif;
   width: 50%;
}
th {
  background: SteelBlue;
  color: white;
 
}
 td,th{
                border: 1px solid gray;
                width: 25%;
                text-align: left;
                padding: 5px 10px;
            }
</style>

<body>

<form:form method="post" modelAttribute="empbean" action="${pageContext.request.contextPath}/emp">
<table>
		<tr>
			<th colspan="2" style="text-align:center">Add Employee</th>
		</tr>
		<tr>
	<form:hidden path="id" />
	<tr>
	<td>
          <lablel for="First name">First Name</lablel>
          <form:input path="fname" class="form-control validate onlyCharacters" size="30" maxlength="30"></form:input>
          </td>
   </tr>
        
		<tr>
		<td>
			    <lablel for="Last name">Last Name</lablel>
          <form:input path="lname" class="form-control validate onlyCharacters" size="30" maxlength="30"></form:input>
		</td>
		</tr>
		
		<tr>
		<td>
		  <lablel for="Designation">Designation</lablel>
          <form:input path="designation" class="form-control validate onlyCharacters" size="30" maxlength="10"></form:input>
		</td>
		</tr>
		
		
		<tr>
		<td>
		  <lablel for="Salary">Salary</lablel>
          <form:input path="salary" class="form-control validate numericOnly2" size="30" maxlength="7"></form:input>
		</td>
		</tr>
		
		<tr>
		<td>
		  <lablel for="Address">Address</lablel>
          <form:textarea path="address" class="form-control validate onlyCharacters" size="30" maxlength="10"></form:textarea>
		</td>
		</tr>
		
		
		<tr>
		<td>
		  <lablel for="phno">Mobile No</lablel>
          <form:input path ="phno" class="form-control validate numericOnly2" size="30" maxlength="10"></form:input>
		</td>
		</tr>
		
		
		<tr>
		<td>
		  <lablel for="DateOfBirth">DateofBirth</lablel>
          <form:input path="dob" id="datepicker"></form:input>
		</td>
		</tr>
		
		
		
		
		
		
		
		<tr>
			<td colspan="2"><center><input type="submit" id="submit1"
				class="blue-button" /></center></td>
		</tr>
		
	</table> 
</form:form>
<br>

<table>


<tr>
			<th colspan="8" style="text-align:center">Employees List</th>
		</tr>


<tr>
<th> id  </th> <th> First Name  </th> <th> Last Name  </th><th> Designation  </th> <th> Salary  </th> <th> Address </th><th> MobileNo </th><th> DateofBirth </th><th> Delete Actions </th><th> Edit Actions </th>


</tr>
<c:forEach items="${list}" var="item">
<tr>


<td> "${item.id }" </td>
<td> "${item.fname }" </td>
<td> "${item.lname}" </td>
<td> "${item.designation}" </td>
<td> "${item.salary}" </td>
<td> "${item.address}" </td>
<td> "${item.phno}" </td>
<td> "${item.dob}" </td>
<td> <a href="deleteEmployee?id=${item.id }">Delete</a> </td>
<td> <a href="editEmployee?id=${item.id }">Edit</a> </td>


</tr>
</c:forEach>


</table>



</body>



<script type='text/javascript' src='/JS/jquery-1.11.1.min.js'></script>

<script type='text/javascript' src='JS/customValidation.js'></script>

<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
  <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>

<script>
  $( function() {
    $( "#datepicker" ).datepicker();
  } );
  </script>

 <!-- this is for show form and view(.jsp file) in same page -->

</html>