<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
  <head>
    <title>Result</title>
  </head>
  <body>
    <h1>Registration Result</h1>
    <p>Status: ${status}</p>
    <p>User ID: ${user.userId}</p>
    <p>College Email ID: ${user.collegeEmailId}</p>
    <p>College Roll Number: ${user.collegeRollNumber}</p>
    <p>Numbers Array: ${user.numbersArray}</p>
    <p>Alphabets Array: ${user.alphabetsArray}</p>
    <p>Highest Lowercase: ${user.highestLowercase}</p>
    <p>File Valid: ${fileValid}</p>
    <p>File MIME Type: ${fileMimeType}</p>
    <p>File Size (KB): ${fileSizeKB}</p>
  </body>
</html>
