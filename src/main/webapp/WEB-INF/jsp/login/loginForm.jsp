<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="../include/header.jsp" />

<div class="maincontainer">

    <h1 class="title">Porter</h1>
    <p class="subtitle">An inventory manager for the TTRPG Mythras</p>
    
    <form action="/login/loginSubmit" method="POST">
        <div>
            <input type="text" name="username" placeholder="Email">
            <br>
        </div>
        <div>
            <input type="password" name="password" placeholder="Password">
            <br>
        </div>
        <button type="submit">Submit</button>
    </form>
    <nav>
        <a href = "/login/registerForm">Sign Up</a>
    </nav>
</div>


<jsp:include page="../include/footer.jsp" />