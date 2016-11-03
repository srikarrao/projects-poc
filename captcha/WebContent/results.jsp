<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
<head>
<title>Captcha Demo - Servlet</title>
</head>
<body>
	<%
		Boolean B = (Boolean) session.getAttribute("PassedCaptcha");
		if (B != null && B.booleanValue()) {
	%>
	Congrats! You passed the Captcha test!
	<%
		} else {
	%>
	Sorry, you failed the Captcha test.
	<%
		}
	%>

	<p>
		Please <a href="/captcha.jsp">Try Again</a>
	</p>
</body>
</html>