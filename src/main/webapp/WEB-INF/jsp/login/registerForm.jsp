<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="../include/header.jsp"/>
<!-- Use method = post rather than method = get on the form if you don't want the data appearing in the URL-->
    <div class="maincontainer">

        <h1 class="title">Porter</h1>
        <p class="subtitle">An inventory manager for the TTRPG Mythras</p>

        <form method="POST" action="/login/registerSubmit" id="registerform"
              class="userform" onload="validate()">

            <input type="hidden" name="id" value="${form.id}">

            <div>
                <c:forEach items="${bindingResult.getFieldErrors('email')}" var="error">
                    <div style="color:red;">${error.getDefaultMessage()}</div>
                </c:forEach>
                <input type="text" name="email" id="emailId" placeholder="Email"
                       value="${form.email}">
                <br>

            </div>

            <div>
                <c:forEach items="${bindingResult.getFieldErrors('password')}" var="error">
                    <div style="color:red;">${error.getDefaultMessage()}</div>
                </c:forEach>
                <input type="password" name="password" placeholder="Password"
                       id="passwordId" value="${form.password}">
                    <br>
            </div>

            <div>
                <c:forEach items="${bindingResult.getFieldErrors('confirmPassword')}"
                           var="error">
                    <div style="color:red;">${error.getDefaultMessage()}</div>
                </c:forEach>
                <input type="password" name="confirmPassword"
                       placeholder="Confirm Password" id="confirmId"
                       value="${form.confirmPassword}">
                    <br>

            </div>

            <button type="submit" id="registersubmit">Submit</button>

        </form>

        <nav>
            <a href = "/login/loginForm">Log In</a>
        </nav>
    </div>

<jsp:include page="../include/footer.jsp"/>
