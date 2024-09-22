<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <title>User Registration</title>
  </head>
  <body>
    <h1>User Registration</h1>
    <form
      action="${pageContext.request.contextPath}/users/process"
      method="post"
      enctype="multipart/form-data"
    >
      <label for="userId">User ID:</label>
      <input type="text" name="userId" required /><br /><br />

      <label for="collegeEmailId">College Email ID:</label>
      <input type="email" name="collegeEmailId" required /><br /><br />

      <label for="collegeRollNumber">College Roll Number:</label>
      <input type="text" name="collegeRollNumber" required /><br /><br />

      <label for="data">Data (Alphabets and Numbers):</label>
      <input type="text" name="data" required /><br /><br />

      <label for="file">Upload File:</label>
      <input type="file" name="file" /><br /><br />

      <input type="submit" value="Submit" />
    </form>
  </body>
</html>
