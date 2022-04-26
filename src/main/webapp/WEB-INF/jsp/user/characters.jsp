<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="../include/header.jsp"/>

<div class="maincontainer">
    <h1 class="smallerTitle">Characters</h1>
    <div class="characterList">
        <ul>
            <c:forEach items="${characters}" var="character">
                <li>${character.name}</li>
                <a href="/character/${character.id}/inventory"> <button type="button"> Inventory</button></a>
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