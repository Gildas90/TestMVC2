<%@ tag description="Template Tag" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<!doctype>
<html>
<head>
    <link href="<c:url value="/resources/css/main.css"/>" rel="stylesheet">
    <script src="<c:url value="/resources/script/carUtil.js"/>"></script>
    <title>Car Manager</title>

    <div class="login-link-container">
        <sec:authorize access="isAnonymous()">
            <p>
                <a href="/login">Sign In</a>
            </p>
        </sec:authorize>
        <sec:authorize access="isAuthenticated()">

            <a href="/login">Sign Out</a>
        </sec:authorize>
    </div>

</head>
<body>
<div class="content">
    <h1>Car Manager</h1>
    <jsp:doBody/>
</div>

<div class="test">
    <sec:authorize access="isAuthenticated()">

<sec:authentication property="authorities" var="roles" scope="page" />
Your roles are:
<ul>
    <c:forEach var="role" items="${roles}">
        <li>${role}</li>
    </c:forEach>
</ul>


Your username is <sec:authentication property="principal.username"/>
    </sec:authorize>
</div>
</body>
</html>