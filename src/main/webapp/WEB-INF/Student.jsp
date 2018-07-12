<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form:form method="post" modelAttribute="stubean" action="${pageContext.request.contextPath}/stu">
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
          <form:input path="marks" class="form-control validate numericOnly" size="30" maxlength="30"></form:input>
          </td>
		</tr>
		<tr>
		<td>
            <lablel for="student course">Student course</lablel>    
          <form:input path="course" class="form-control validate onlyCharacters" size="30" maxlength="30"></form:input>
          </td>
   </tr>
		<tr>
			<td colspan="2"><input type="submit" id="submit1"
				class="blue-button" /></td>
		</tr>
	</table> 
</form:form>
</body>

<script type='text/javascript' src='/JS/jquery-1.11.1.min.js'></script>

<script type='text/javascript' src='JS/customValidation.js'></script>



</html>