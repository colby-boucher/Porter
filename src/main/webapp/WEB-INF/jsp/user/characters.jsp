<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="../include/header.jsp"/>

<div class="maincontainer">
    <h1 class="title">Characters</h1>
    <c:forEach items="${characters}" var="character">
        <p>${character.name}</p>
    </c:forEach>

    <p>Your email: ${email}</p>

    <nav>
        <a href="/user/create">Create a new character</a>
        <a href="/login/logout">Log Out</a>
    </nav>
</div>

<jsp:include page="../include/footer.jsp"/>