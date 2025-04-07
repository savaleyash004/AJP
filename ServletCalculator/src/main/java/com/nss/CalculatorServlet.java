package com.nss;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

public class CalculatorServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        // Read parameters
        double num1 = Double.parseDouble(request.getParameter("num1"));
        double num2 = Double.parseDouble(request.getParameter("num2"));
        String operation = request.getParameter("operation");

        double result = 0;
        String opSymbol = "";

        // Perform calculation
        switch (operation) {
            case "add":
                result = num1 + num2;
                opSymbol = "+";
                break;
            case "subtract":
                result = num1 - num2;
                opSymbol = "-";
                break;
            case "multiply":
                result = num1 * num2;
                opSymbol = "×";
                break;
            case "divide":
                if (num2 != 0) {
                    result = num1 / num2;
                    opSymbol = "÷";
                } else {
                    out.println("<h3 style='color: red;'>Error: Division by zero is not allowed!</h3>");
                    return;
                }
                break;
            default:
                out.println("<h3 style='color: red;'>Invalid Operation!</h3>");
                return;
        }

        // Display result
        out.println("<html><head><title>Calculator Result</title>");
        out.println("<style>");
        out.println("body { font-family: Arial, sans-serif; background-color: #e3f2fd; text-align: center; padding: 50px; }");
        out.println(".container { background: #fff; padding: 20px; border-radius: 10px; box-shadow: 0 4px 8px rgba(0, 0, 0, 0.2); width: 40%; margin: auto; }");
        out.println("h2 { color: #333; } p { color: #555; font-size: 18px; }");
        out.println("a { text-decoration: none; color: blue; font-size: 16px; }");
        out.println("</style></head><body>");
        out.println("<div class='container'>");
        out.println("<h2>Calculation Result</h2>");
        out.println("<p><strong>" + num1 + " " + opSymbol + " " + num2 + " = " + result + "</strong></p>");
        out.println("<a href='index.html'>Perform another calculation</a>");
        out.println("</div>");
        out.println("</body></html>");
    }
}
