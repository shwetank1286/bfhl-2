<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%> <%@ taglib prefix="c"
uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8" />
    <title>User List</title>
    <style>
      table {
        border-collapse: collapse;
        width: 100%;
      }
      th,
      td {
        text-align: left;
        padding: 8px;
        border-bottom: 1px solid #ddd;
      }
      tr:nth-child(even) {
        background-color: #f2f2f2;
      }
      th {
        background-color: #4caf50;
        color: white;
      }
    </style>
  </head>
  <body>
    <h1>User List</h1>

    <table>
      <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Email</th>
        <th>Actions</th>
      </tr>
      <c:forEach var="user" items="${users}">
        <tr>
          <td>${user.id}</td>
          <td>${user.name}</td>
          <td>${user.email}</td>
          <td>
            <a href="edit?id=${user.id}">Edit</a>
            <a href="delete?id=${user.id}">Delete</a>
          </td>
        </tr>
      </c:forEach>
    </table>

    <br />
    <a href="form">Add New User</a>
  </body>
</html>
