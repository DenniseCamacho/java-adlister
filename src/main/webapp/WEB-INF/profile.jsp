<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <jsp:include page="../WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Your Profile" />
    </jsp:include>
</head>
<body>
    <jsp:include page="../WEB-INF/partials/navbar.jsp" />

    <div class="container">
        <h1>Viewing your profile.</h1>
        <h2>Hello ${sessionScope['user']}</h2>
    </div>

</body>
</html>
