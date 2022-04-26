<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="../include/header.jsp"/>

<div class="maincontainer">

    <h1 class="smallerTitle">${character.name}</h1>

    <table>
        <thead>
            <tr>
                <th>Item</th>
                <th>Quantity</th>
                <th>Weight</th>
            </tr>
        </thead>
        <tbody>
        <c:forEach items="${inventory}" var="item">
            <tr>
                <td>${item.id}</td>
                <td>${item.quantity}</td>
                <td>${item.quantity}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>

</div>

<jsp:include page="../include/footer.jsp"/>