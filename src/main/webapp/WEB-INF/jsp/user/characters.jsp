<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="../include/header.jsp"/>

<div class="maincontainer">
    <h1 class="title">Characters</h1>
    <div class="characterList">
        <ul>
            <c:forEach items="${characters}" var="character">
                <li>${character.name}</li>
                <button type="button"> Inventory</button>
                <button type="button"> Delete</button>
            </c:forEach>
        </ul>
    </div>

    <p>Your email: ${email}</p>

    <nav>
        <a href="/user/create">Create a new character</a>
        <a href="/login/logout">Log Out</a>
    </nav>
</div>

<jsp:include page="../include/footer.jsp"/>