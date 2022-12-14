<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="java.util.*,com.luv2code.jsp.tagdemo.Student" %>

<%
	//sample data:
	List<Student> data = new ArrayList<>();
	
	data.add(new Student("Theoden", "King", true));
	data.add(new Student("Aragorn", "Son of Arathorn", false));
	data.add(new Student("Arwen", "Und?miel", false));
	
	pageContext.setAttribute("myStudents", data);
%>
<html>
<body>

	
	<table border="1">
		<tr>
			<th>Name</th>
			<th>Surname</th>
			<th>Golden Customer</th>
		</tr>
		<c:forEach var="tempStudent" items="${myStudents}">
			<tr>
				<td>${tempStudent.firstName}</td>
				<td>${tempStudent.lastName}</td>
				<td>
<%-- 				${tempStudent.goldenCustomer} --%>
<%-- 					<c:if test="${not tempStudent.goldenCustomer}">  --%>
<!-- 						No special discount, bitch -->
<%-- 					</c:if> --%>
<%-- 					<c:if test="${tempStudent.goldenCustomer}">  --%>
<!-- 						Special discount -->
<%-- 					</c:if> --%>
						<c:choose>
							<c:when test="${tempStudent.goldenCustomer}">
								YOU get a discount!
							</c:when>
							<c:otherwise>
								You get nothing.
							</c:otherwise>
						</c:choose>
				</td>
			</tr>
	
		</c:forEach>
	</table>



</body>
</html>