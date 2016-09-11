<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Account Number Generator</title>
</head>
<body>
	<ul>
	<jsp:useBean id="accountNumbers" class="com.openshift.aeg.AccountNumberGenerator" scope="request">
	Account numbers :
     <c:forEach var="acNumber" items="{accountNumbers}">
        <li><c:out value="${acNumber}" />
     </c:forEach>    
	</jsp:useBean>
	</ul>
</body>
</html>