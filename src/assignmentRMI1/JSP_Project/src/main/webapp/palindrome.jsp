<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Palindrome Checker</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f3f4f6;
            text-align: center;
            padding: 50px;
        }
        .container {
            background: #fff;
            padding: 20px;
            border-radius: 10px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.2);
            width: 40%;
            margin: auto;
        }
        h2 { color: #333; }
        p { font-size: 18px; }
        input, button {
            padding: 10px;
            font-size: 16px;
            margin-top: 10px;
        }
    </style>
</head>
<body>

<div class="container">
    <h2>Palindrome Checker</h2>
    <form method="post">
        <label>Enter a word or number:</label>
        <input type="text" name="inputStr" required>
        <button type="submit">Check</button>
    </form>

    <%
        String inputStr = request.getParameter("inputStr");
        if (inputStr != null && !inputStr.trim().isEmpty()) {
            String reversedStr = new StringBuilder(inputStr).reverse().toString();
            if (inputStr.equalsIgnoreCase(reversedStr)) {
                out.println("<p style='color: green;'><strong>" + inputStr + " is a Palindrome!</strong></p>");
            } else {
                out.println("<p style='color: red;'><strong>" + inputStr + " is NOT a Palindrome!</strong></p>");
            }
        }
    %>
</div>

</body>
</html>
