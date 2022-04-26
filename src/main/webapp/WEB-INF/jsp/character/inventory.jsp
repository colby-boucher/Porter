<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="../include/header.jsp"/>

<div class="maincontainer">

    <h1 class="smallerTitle">${character.name}</h1>

    <table>
        <thead>
            <tr>
                <th>Item</th>
                <th>Weight</th>
                <th>Value</th>
                <th>Quantity</th>
            </tr>
        </thead>
        <tbody>
        <c:forEach items="${inventory}" var="item">
            <tr>
                <td>${item.name}</td>
                <td>${item.weight}</td>
                <td>${item.value}</td>
                <td>${item.quantity}</td>
                <td><a>Subtract 1</a></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>

    <nav>
        <a href="/character/${character.id}/delete">DELETE CHARACTER</a>
    </nav>

</div>

<jsp:include page="../include/footer.jsp"/>