<%@ page language="java" %>
<html>
<body>

    <h2>Result</h2>

    <%
    int a = Integer.parseInt(request.getParameter("num1"));
    int b = Integer.parseInt(request.getParameter("num2"));
    int sum = a + b;
    out.println("Sum = " + sum);
    %>

</body>
</html>
