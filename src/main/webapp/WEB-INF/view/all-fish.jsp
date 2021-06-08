<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>

<body>

<h2>All Fish</h2>
<br>

<table>
    <tr> <th>Name</th>
        <th>TypeOfFish</th>
    </tr>

<tr>
    <c:forEach var="fishes" items="${allFishes}">
    <c:url var="updateButton" value="/updateInfo">
    <c:param name="fishId" value="${fishes.id}"/>
    </c:url>

    <c:url var="deleteButton" value="/deleteFish">
        <c:param name="fishId" value="${fishes.id}"/>
    </c:url>
        <c:url var="descriptionButton" value="/description">
            <c:param name="fishId" value="${fishes.id}"/>
        </c:url>

    <td>${fishes.name}</td>
        <td>${fishes.typeOfFish}</td>
    <td>
        <input type="button" value="Update"
        onclick="window.location.href='${updateButton}'">
        <input type="button" value="Delete"
        onclick="window.location.href='${deleteButton}'">
        <input type="button" value="See more"
               onclick="window.location.href='${descriptionButton}'">

    </td>
</tr>


    </c:forEach>
</table>

<br>
<input type="button" value="Add" onclick="window.location.href='addNewFish'">
</body>
</html>