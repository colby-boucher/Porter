<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="../include/header.jsp" />

<div class="maincontainer">
    
    <form action="/login/loginSubmit" method="POST">
        <div>
            <input type="text" name="username" placeholder="Email">
            <br>
        </div>
        <div>
            <input type="text" name="password" placeholder="Password">
            <br>
        </div>
        <button type="submit">Submit</button>
    </form>
</div>


<jsp:include page="../include/footer.jsp" />