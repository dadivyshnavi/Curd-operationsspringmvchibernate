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

<form:form method="post" modelAttribute="empbean" action="${pageContext.request.contextPath}/emp">
<table>
		<tr>
			<th colspan="2">Add Employee</th>
		</tr>
		<tr>
	<form:hidden path="id" />
	<tr>
               First Name
          <td><form:input path="fname" size="30" maxlength="30"></form:input></td>
   </tr>
        
		<tr>
			    Last Name
          <td><form:input path="lname" size="30" maxlength="30"></form:input></td>
		</tr>
		<tr>
			<td colspan="2"><input type="submit"
				class="blue-button" /></td>
		</tr>
	</table> 
</form:form>





</body>
</html>