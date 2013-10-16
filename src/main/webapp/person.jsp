<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head><title>People</title></head>
<body>
    <form action="/servlet-jpa-app/person" method="POST">

    <p><label for="full_name">Full name:</label><br>
    <input id=full_name name="full_name" size="30" type="text"/></p>

    <p><input type="submit" value="Add"/></p>
    </form>    
    
    <c:if test="${!empty people}">
   		<c:forEach var="person" items="${people}">
   			<c:out value="${person.fullName}"/><br/>
   		</c:forEach>
   </c:if>

</body>
</html>
