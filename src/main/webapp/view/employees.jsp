<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<body>
    <h1>Employee List</h1>
    <table width="59%" border="1">
     <thead>
        <tr>
            <td> Employee</td>
            <td> Role</td>
            <td> Manager </td>
        </tr>
      </thead>
        <c:forEach var="employee" items="${employees}">
            <tr>
                <td> ${employee.firstName} ${employee.lastName} </td>
                <td> ${employee.role} </td>
                <td> ${employee.manager.firstName} ${employee.manager.lastName}</td>
            </tr>
        </c:forEach>
    </TABLE>
</body>
</html>