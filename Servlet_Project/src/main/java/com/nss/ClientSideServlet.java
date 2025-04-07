package com.nss;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
//import jakarta.servlet.RequestDispatcher;
//import jakarta.servlet.ServletException;
//import jakarta.servlet.http.HttpServlet;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponse;

public class ClientSideServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Accept username and password from form
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        // Set them as request attributes
        request.setAttribute("username", username);
        request.setAttribute("password", password);

        // Forward to ServerSideServlet
        RequestDispatcher dispatcher = request.getRequestDispatcher("ServerSideServlet");
        dispatcher.forward(request, response);
    }
}
