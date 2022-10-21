<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<html>
<body>

<c:set var="data" value="luv2code" />

Length of the string <b>${data}</b>: ${fn:length(data)} characters.

<br/><br/>

Uppercase version of the string <b>${data}</b>: ${fn:toUpperCase(data)}

<br/><br/>

Does the string <b>${data}</b> start with "<b>luv</b>"? 
<c:set var="data2" value="${fn:startsWith(data, \"luv\")}" />
- ${fn:toUpperCase(data2)}

<br/><br/>

<c:set var="cities" value="Singapore, Paris, London, Tokyo" />
<c:set var="citiesArray" value="${fn:split(cities, ',')}" />
<c:forEach var="city" items="${citiesArray}">
	${city} <br/>
</c:forEach>

<br/><br/>

<c:set var="fun" value="${fn:join(citiesArray, ' - ')}" />
Result of joining: ${fun}.

</body>
</html>