<%@page language = "java" %>

<html>
<head>
   <link rel="stylesheet" type="text/css" href="style.css">
</head>

<body>
    <div class="container">
        <h1>Welcome to Calculator</h1>
        <form action="add">
          <label for="num1">Enter Num 1:</label>
          <input type="text" id="num1" name="num1">

          <label for="num2">Enter Num 2:</label>
          <input type="text" id="num2" name="num2">

          <input type="submit" value="Add">
        </form>
    </div>
</body>
</html>