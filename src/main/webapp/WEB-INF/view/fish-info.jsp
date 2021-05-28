<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<body>

<h2>Fish Info</h2>
<br>
<form:form action="saveFish" modelAttribute="fishClass">
<form:hidden path="id"/>
    Name <form:input path="name"/>
    <br><br>
    Type Of Fish <form:input path="typeOfFish"/>
<br><br>
    <input type="submit" value="OK">
</form:form>
</body>
</html>