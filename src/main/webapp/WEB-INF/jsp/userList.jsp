<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>User List</title>
</head>
<body>
    <h1>Registered Users</h1>
    <table border="1">
        <tr>
            <th>User ID</th>
            <th>College Email ID</th>
            <th>College Roll Number</th>
            <th>Action</th>
        </tr>
        <c:forEach var="user" items="${users}">
            <tr>
                <td>${user.userId}</td>
                <td>${user.collegeEmailId}</td>
                <td>${user.collegeRollNumber}</td>
                <td>
                    <form action="${pageContext.request.contextPath}/users/${user.id}" method="post" onsubmit="return confirm('Are you sure you want to delete this user?');">
                        <input type="hidden" name="_method" value="DELETE">
                        <input type="submit" value="Delete">
                    </form>
                </td>
            </tr>
        </c:forEach>
    </table>

    <a href="${pageContext.request.contextPath}/users/form">Register New User</a>
</body>
</html>
