package com.example.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * Handles HTTP POST requests from the login form
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Get form parameters
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        // Simple validation - In production, validate against database
        if (username != null && !username.isEmpty() && 
            password != null && !password.isEmpty() &&
            password.length() >= 6) {
            
            // Set response content type
            response.setContentType("text/html;charset=UTF-8");
            PrintWriter out = response.getWriter();
            
            // Display personalized welcome message
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Welcome</title>");
            out.println("<style>");
            out.println("  body { font-family: Arial, sans-serif; margin: 40px; background-color: #f5f5f5; }");
            out.println("  .welcome-container { background-color: white; padding: 30px; border-radius: 5px; box-shadow: 0 0 10px rgba(0,0,0,0.1); max-width: 500px; margin: 0 auto; }");
            out.println("  h1 { color: #333; }");
            out.println("  .username { color: #0066cc; font-weight: bold; }");
            out.println("  .logout { margin-top: 20px; }");
            out.println("  a { color: #0066cc; text-decoration: none; }");
            out.println("  a:hover { text-decoration: underline; }");
            out.println("</style>");
            out.println("</head>");
            out.println("<body>");
            out.println("<div class='welcome-container'>");
            out.println("<h1>Welcome, <span class='username'>" + username + "</span>!</h1>");
            out.println("<p>You have been successfully logged in.</p>");
            out.println("<p>Session started at: " + new java.util.Date() + "</p>");
            out.println("<div class='logout'>");
            out.println("<a href='login.html'>Back to Login</a>");
            out.println("</div>");
            out.println("</div>");
            out.println("</body>");
            out.println("</html>");
            out.close();
        } else {
            // Invalid credentials - redirect back to login form with error
            response.setContentType("text/html;charset=UTF-8");
            PrintWriter out = response.getWriter();
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Login Error</title>");
            out.println("<style>");
            out.println("  body { font-family: Arial, sans-serif; margin: 40px; background-color: #f5f5f5; }");
            out.println("  .error-container { background-color: white; padding: 30px; border-radius: 5px; box-shadow: 0 0 10px rgba(0,0,0,0.1); max-width: 500px; margin: 0 auto; }");
            out.println("  h1 { color: #d9534f; }");
            out.println("  .error { color: #d9534f; background-color: #f2dede; padding: 10px; border-radius: 3px; border: 1px solid #ebccd1; }");
            out.println("  a { color: #0066cc; text-decoration: none; }");
            out.println("  a:hover { text-decoration: underline; }");
            out.println("</style>");
            out.println("</head>");
            out.println("<body>");
            out.println("<div class='error-container'>");
            out.println("<h1>Login Failed</h1>");
            out.println("<div class='error'>");
            out.println("<p>Invalid username or password. Password must be at least 6 characters.</p>");
            out.println("</div>");
            out.println("<p><a href='login.html'>Try again</a></p>");
            out.println("</div>");
            out.println("</body>");
            out.println("</html>");
            out.close();
        }
    }

    /**
     * Handles HTTP GET requests - displays the login form
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.sendRedirect("login.html");
    }
}
