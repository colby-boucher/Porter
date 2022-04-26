<jsp:include page="../include/header.jsp" />

<div class="maincontainer">

    <p>Hey</p>

    <form action="/user/characterSubmit" method="POST">
        <input type="hidden" name="id">
        <input type="hidden" name="userId" value="userId">
        <div>
            <input type="text" name="name" placeholder="Character Name"/>
            <br>
        </div>
        <div>
            <input type="number" name="strength" placeholder="Character Strength"/>
        </div>

        <button type="submit" id="registersubmit">Submit</button>
    </form>

</div>