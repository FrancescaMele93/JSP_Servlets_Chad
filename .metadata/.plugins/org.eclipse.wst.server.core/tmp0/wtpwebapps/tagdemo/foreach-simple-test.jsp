<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%
	//sample data (usually provided by the MVC)
	String[] cities = {"Mumbai", "Singapore", "Philadelphia", "Chicago"};

	pageContext.setAttribute("myCities", cities);
%>
<html>
<body>

<c:forEach var="tempCity" items="${myCities}">
	${tempCity} <br>
</c:forEach>

</body>
</html>