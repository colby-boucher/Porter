<jsp:include page="../include/header.jsp"/>
<!-- Use method = post rather than method = get on the form if you don't want the data appearing in the URL-->
    <div class="maincontainer">
        <form method="get" action="/login/registerSubmit" id="registerform" class="userform" onload="validate()">

            <input type="hidden" name="id" value="${form.id}">

            <div>
                <input type="text" name="email" id="emailId" placeholder="Email" value="${form.email}">
                <br>

                <c:forEach items="${bindingResult.getFieldErrors('email')}" var="error">
                    <div style="color:red;">${error.getDefaultMessage()}</div>
                </c:forEach>
            </div>

            <div>
                <input type="password" name="password" placeholder="Password" id="passwordId">
                    <br>

                <c:forEach items="${bindingResult.getFieldErrors('password')}" var="error">
                    <div style="color:red;">${error.getDefaultMessage()}</div>
                </c:forEach>
            </div>

            <div>
                <input type="password" name="confirmPassword" placeholder="Confirm Password" id="confirmId">
                    <br>

                <c:forEach items="${bindingResult.getFieldErrors('confirmPassword')}" var="error">
                    <div style="color:red;">${error.getDefaultMessage()}</div>
                </c:forEach>
            </div>

            <button type="submit" id="registersubmit">Submit</button>

        </form>
    </div>

<jsp:include page="../include/footer.jsp"/>
