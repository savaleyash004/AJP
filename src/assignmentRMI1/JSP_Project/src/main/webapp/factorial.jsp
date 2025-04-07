<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Factorial Calculator</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f9f9f9;
            text-align: center;
            padding: 50px;
        }
        .container {
            background: #fff;
            padding: 20px;
            border-radius: 8px;
            box-shadow: 0 2px 4px rgba(0, 0, 0, 0.2);
            width: 300px;
            margin: auto;
        }
        h2 { color: #444; }
        p { font-size: 16px; }
        input, button {
            padding: 8px;
            font-size: 14px;
            margin-top: 10px;
            width: 90%;
        }
    </style>
</head>
<body>

<div class="container">
    <h2>Factorial Calculator</h2>
    <form method="post">
        <label>Enter a number:</label>
        <input type="number" name="number" required min="0">
        <button type="submit">Calculate</button>
    </form>

    <%
        String numStr = request.getParameter("number");
        if (numStr != null && !numStr.trim().isEmpty()) {
            int num = Integer.parseInt(numStr);
            long factorial = 1;
            for (int i = 1; i <= num; i++) {
                factorial *= i;
            }
            out.println("<p><strong>Factorial of " + num + " is " + factorial + "</strong></p>");
        }
    %>
</div>

</body>
</html>
