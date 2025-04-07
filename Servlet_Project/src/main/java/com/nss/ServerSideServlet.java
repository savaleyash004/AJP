package com.nss;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
//import jakarta.servlet.ServletException;
//import jakarta.servlet.http.HttpServlet;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServerSideServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        // Retrieve forwarded values
        String username = (String) request.getAttribute("username");
        String password = (String) request.getAttribute("password");

        // Hardcoded credentials
        String correctUsername = "admin";
        String correctPassword = "12345";

        out.println("<html><body>");
        out.println("<h2>Login Result</h2>");
        out.println("<p>Entered Username: <b>" + username + "</b></p>");
        out.println("<p>Entered Password: <b>" + password + "</b></p><br>");

        if (correctUsername.equals(username) && correctPassword.equals(password)) {
            out.println("<p style='color:green;'>✅ Login Successful. Welcome, " + username + "!</p>");
        } else {
            out.println("<p style='color:red;'>❌ Login Failed. Invalid username or password.</p>");
            out.println("<a href='index.html'>Try Again</a>");
        }

        out.println("</body></html>");
        out.close();
    }
}
