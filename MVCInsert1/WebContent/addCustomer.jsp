<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<script src="javascript/validation.js" type="text/javascript">
</script>
</head>
<body>
<h1>ADD CUSTOMER</h1>
<form action="CustomerController" method= "post" name= "customerForm">
<input type="hidden" name= "source" value="addCustomer">
<table>
<tr>
	<th align="left">First Name</th><td><input type="text" name="firstName" onBlur="chkFirstName()"/></td>
</tr>
<tr>
	<th align="left">Last Name</th><td><input type="text" name="lastName" onBlur="chkLastName()"/></td>
</tr>
<tr>
	<th align="left">Date of Birth(dd/mm/yyyy)</th><td><input type="text" name="dob" onBlur="chkDateOfBirth()"/></td>
</tr>
<tr>
	<th align="left">Gender</th><td><input type="radio" name="gender" value="male">Male
	<input type="radio" name="gender" value="female">Female<br></td>
</tr>
<tr>
	<th align="left">City</th><td><input type="text" name="city" onBlur="chkCity()"/></td>
</tr>
<tr>
	<th align="left">Country</th>
	<td>
	<select id="selCountry" multiple="multiple" size="6" name="selCountry">
	<option value="India">India</option>
	<option value="Australia">Australia</option>
	<option value="China">China</option>
	<option value="United States">United States</option>
	<option value="Germany">Germany</option>
	<option value="United Kingdom">United Kingdom</option>
	</select>
	</td>
</tr>
<tr>
	<th align="left">Email</th><td><input type="text" name="email" onBlur="chkEmail()"/></td>
</tr>
<tr>
	<th align="left">Annual Salary(INR)</th><td><input type="text" name="salary" onBlur="chkSalary()"/></td>
</tr>
<tr>
<td></td><td><input type="submit" value="Submit">
<input type="reset" value="Reset">
</td>
</tr> 
</table>
</form>
<center>
<font color="green"><h2>
<%
Integer customerId = (Integer)request.getAttribute("customerId");
if(customerId!=null){
	out.println("<br>Customer Register Succefully.<br>");
	out.println("<br>Customer Id :<u>" +customerId+"</u>");
}

%>


</h2>


</font>

</center>

</body>
</html>