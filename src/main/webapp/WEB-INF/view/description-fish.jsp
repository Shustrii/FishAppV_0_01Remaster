<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<body>

<h2>Fish Description</h2>
<br>



<form:form action="description" modelAttribute="fishClass">



        <th>Name: </th>${fishClass.name}
        <br>
        <th>Type Of Fish: </th>${fishClass.typeOfFish}
        <br>
        <th>Description: </th>${fishClass.description}

    </form:form>



</body>
</html>
