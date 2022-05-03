<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Quotes</title>
</head>
<body>
<c:forEach var="quote" items="${quotes}">
    <div class="quote">
        <p>${quote.author.author_name} said: ${quote.content}</p>
    </div>
</c:forEach>
</body>
</html>