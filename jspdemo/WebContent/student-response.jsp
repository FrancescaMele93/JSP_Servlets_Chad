<html>

<body>

	The student is confirmed: ${param.firstName} ${param.lastName} 
	<br></br>
	
	The student country is: ${param.country}
	<br></br>
	
	<%-- ${param.favouriteLanguage} --%>
	<br></br>
	
	<% 
		String[] langs = request.getParameterValues("favouriteLanguage");
		
		for(String tempLang : langs) {
		    out.println("<li>" + tempLang + "</li>");
		}
	%>


</body>

</html>