<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.0/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.0/js/bootstrap.min.js"></script>
  
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
 
<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css"> 
<!-- <link rel="stylesheet" href="/resources/demos/style.css">  
 --> 
</head>
<style>           
.blue-button{
	background: #25A6E1;
	filter: progid: DXImageTransform.Microsoft.gradient( startColorstr='#25A6E1',endColorstr='#188BC0',GradientType=0);
	padding:3px 5px;
	color:#fff;
	font-family:'Helvetica Neue',sans-serif;
	font-size:12px;
	border-radius:2px;
	-moz-border-radius:2px;
	-webkit-border-radius:4px;
	border:1px solid #1A87B9
}     
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
<h1>Welcome ${loggedInUser}</h1>
<h2>  The date now is: <%= new java.util.Date() %></h2>

<form:form method="post" modelAttribute="stubean" action="${pageContext.request.contextPath}/stu" enctype="multipart/form-data">

<table>
		<tr>
			<th colspan="2">Add Student</th>
		</tr>
		<tr>
	<form:hidden path="id" />
	<tr>
	<td>
         <lablel for="student name">Student Name</lablel>
               
         <form:input path="name" class="form-control validate onlyCharacters" size="30" maxlength="30"></form:input>
   </td>
   </tr>
        
		<tr>
		<td>
		<lablel for="student marks">Student Marks</lablel>
          <form:input path="marks" class="form-control validate onlyCharacters" size="30" maxlength="3"></form:input>
          </td>
		</tr>
		<tr>
		<td>
		 							 
									<label class="col-md-3 control-label no-padding-right">Course<span class="impColor">*</span></label>
									
										<form:select path="course" class="form-control validate " >
											<form:option value="">-- Select Course --</form:option>
											<form:options items="${roles}"/>
										</form:select>
										
								
		</td>
		</tr>
   
   
   <tr>
		<td>
		  <lablel for="Address">Address</lablel>
          <form:textarea path="address" class="form-control validate onlyCharacters" size="30" maxlength="30"></form:textarea>
		</td>
		</tr>
   
   
   
  <tr>
		<td>
		  <lablel for="DateOfBirth">DateofBirth</lablel>
            <form:input path="dob" id="datepicker"></form:input>  
		</td>
		</tr>
		<tr>
		<td>
		<lablel for="student Mobile">Mobile No</lablel>
          <form:input path="phno" class="form-control validate numericOnly2" size="30" maxlength="10"></form:input>
          </td>
		</tr>
		<tr>
		<td>
       <label class="col-md-3 control-label no-padding-right">Select file:</label>
       <input type="file" name="file1" id="file1" multiple/>
       </td>
       </tr>
		
		<tr>
			<td colspan="2"><input type="submit" id="submit1"
				class="blue-button" /></td>
		</tr>
		
		
	</table> 
</form:form>
<table>
<tr>
<th> id  </th> <th> Name  </th> <th> Course </th> <th> Marks  </th><th> Address </th><th> DateofBirth  </th><th> Mobile No  </th><th> Files  </th><th> Delete Action  </th><th> Edit Action  </th>


</tr>
<c:forEach items="${list}" var="item">
<tr>


<td> "${item.id }" </td>
<td> "${item.name }" </td>
<td> "${item.course }" </td>
<td> "${item.marks}" </td>
<td> "${item.address }" </td>
<td> "${item.dob }" </td>
<td> "${item.phno }" </td>
<td> "${item.files }" </td>
<td> <a href="deleteStudent?id=${item.id }">Delete</a> </td>
<td> <a href="editStudent?id=${item.id }">Edit</a> </td>



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
  
  
  var items = ${loggedInUser};
  
  </script> 
  
<!-- this is for show students list and view in same page -->

</html>