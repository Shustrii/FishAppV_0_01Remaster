<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<body>

<h2>Fish Info</h2>
<br>
<form:form enctype="multipart/form-data" action="saveFish" modelAttribute="fishClass">
<form:hidden path="id"/>
    Name <form:input path="name"/>
    <br><br>
    Type Of Fish <form:input path="typeOfFish"/>
<br><br>
    Description<form:textarea path="description"/>
    <br>
    <input type="file" name="imageFile">
    <br>
    <input type="submit" value="OK">
</form:form>
<!--form enctype="multipart/form-data" action="/uploadImage">
    <input type="file" name="imageFile">
    <input type="submit" value="Upload">
</form-->
</body>
</html>