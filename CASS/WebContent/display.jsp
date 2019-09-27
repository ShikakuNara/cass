<%@page import="com.beans.Balance"%>
<html>
<body>
	<%
		Balance balance = (Balance) request.getAttribute("balance");
	%>
	<%=balance%>
</body>
</html>