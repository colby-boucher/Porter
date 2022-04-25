<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="../include/header.jsp"/>

<div class="maincontainer">
    <h1 class="title">Characters</h1>
    <c:forEach items="${characters}" var="character">
        <p>${character.name}</p>
    </c:forEach>

    <nav>
        <a href="/user/createcharacter">Create a new character</a>
    </nav>
</div>

<jsp:include page="../include/footer.jsp"/>