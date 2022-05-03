<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<c:forEach var="author" items="${authors}">
    <ul>
    <li>${author.author_name}</li>
    </ul>
</c:forEach>

</body>
</html>
